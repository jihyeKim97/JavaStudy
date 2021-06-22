package ui.calendar.main.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import ui.calendar.main.db.data.Todo;

// 중개(중재) 클래스 broker, manager, agent?
// 저장단(DB..) <===> UI단 (스윙?..) 사이에서 
// todo 스키마 데이터의 입출력을 기능적으로 중개해주는 클래스
// TodoVO (데이터) --- TodoDAO (데이터액세스오브젝트)

public class TodoDBMgr {
	
	Connection conn; // DBMS 서버와 접속하는 통로 기준객체
	private static final String account = "DEVEL"; // 스키마명/유저명
	private static final String pw = "1234";
	static final String url 
		= "jdbc:oracle:thin:@localhost:1521:xe"; 
			// IP 주소, port 포트 1521, SID 서비스아이디 xe 
				// XE 서비스 지역 오라클 서버 (127.0.0.1 주소 같은컴에 있는 서버 - 루프백주소)
		//= "jdbc:oracle:thin:@localhost:1521:orcl"; // ORCL 상용
	
	public TodoDBMgr() { // 생성자에서 통신채널 연결 셋업.
		beginConnection();
	}
	
	// DB에 연결하기 (접속하기 - 통신채널 셋업)
	public boolean beginConnection() {
		try {
		// 1. 오라클 JDBC 연결자(드라이버) 클래스 '동적' 로딩
		//Class.forName("oracle.jdbc.driver.racleDriver");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 2. 오라클 DBMS 서버와 통신연결을 수행 (계정 인증) 
//		Connection conn = 
			conn = DriverManager.getConnection(url, account, pw);
			System.out.println("DB 접속 성공! "
					+ new Date());
					//+ new java.util.Date());
		// 3. 인증으로 정상이면 null이 아닌 연결객체가 리턴됨 
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("ojdbc.jar의 오라클DB 드라이버 로딩 실패!");
		} catch (SQLException e) {
			System.out.println("통신 연결 실패!!! ");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("java 일반 예외!!!");
//			e.printStackTrace();
		}
		return false;
	}
	
	// DB에서 접속해제하기
	public boolean endConnection() {
		if( conn != null ) {
			try {
				conn.close();
				System.out.println("DB 종료 성공!!");
				return true;
			} catch (SQLException e) {
				System.out.println("DB 종료 실패!!");
				e.printStackTrace();
			}
		}		
		return false;
	}
	
	// actor가 ~할 수 있다.  
	// 신규 todo를 하나의 레코드로 추가 할 수 있다. 
	// id, memo, userName, memoType, // checked,// createdAt
	
	
	// memo, userName, memoType
	
	// memo, userName, memoType, strDate
//	insert into todos(id, memo, user_name, memo_type,
//			checked, created_at) 
//	       values(TODO_SEQ.nextval, '통기타 스페셜 구매하기',
//	    		   '동근', 3, 0,
//	            TO_DATE('2021-12-25','YYYY-MM-DD') );
	public boolean insertNewTodoOnDay(
			String memo, String userName, 
			int memoType, String strDate
			) {
		if( this.conn != null ) {
			String sql = 
				"insert into todos(id, memo, user_name, "
				+ "memo_type, checked, created_at) " + 
			" values(TODO_SEQ.nextval, "
			+ "'"+memo+"'," + 
			" '"+userName+"', "+memoType+", 0," +
			" TO_DATE('"+strDate+"','YYYY-MM-DD') )"; 
			System.out.println("sql : "  + sql);
			try {
				Statement stmt = conn.createStatement();
				int r = stmt.executeUpdate(sql); // CUD, insert, update, delete
//				stmt.executeQuery(sql); // R, select
				if( r == 1 ) { // 1개의 레코드 insert 성공
					 System.out.println("todo 레코드 추가 성공: "
							 + memo);
					 return true;
				} else { // 0,..., 2, 3??
					System.out.println("todo 레코드 추가 실패!: "
							 + memo);
				}
			} catch (SQLException e) {
				System.out.println("todo 레코드 추가 실패 - SQL 예외");
				e.printStackTrace();
			}
		}
		return false;
	}
	
	// memo, userName
	
	// 기존 todo를 하나를 편집, 갱신 할 수 있다. (완료??)
	// 기존 todo를 하나를 삭제할 수 있다.
	
	// 기존 todo를 하나를 조회할 수 있다. 
	// 기존 todo 모두를 조회할 수 있다. (전체, 기간, 사용자, 타입...)
	public ArrayList<Todo> selectAllTodos() {
		if( this.conn != null ) {
			ArrayList<Todo> tdList = new ArrayList<Todo>();
			String sql = "select * from todos order by created_at desc";
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while( rs.next() ) {
//					rs.get타입("필드명");  
					int id = rs.getInt("id");
					String memo = rs.getString("memo");
					String userName = rs.getString("user_name");
					int memoType = rs.getInt("memo_type");
					int checked = rs.getInt("checked");
					Date createdAt = rs.getDate("created_at");
					
					Todo td = new Todo(id, memo, userName,
							memoType, 
							checked == Todo.DONE,
							createdAt);
							//checked == Todo.DONE ? true: false,
							//	createdAt);
					tdList.add(td);
				}
				System.out.println("DB에서 조회한 todo 개수: "
						+ tdList.size());
				return tdList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		return null;
	}
	
	public void printAllTodos() {
		if( this.conn != null ) {
			String sql = "select * from todos order by created_at desc";
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while( rs.next() ) {
//					rs.get타입("필드명");  
					int id = rs.getInt("id");
					String memo = rs.getString("memo");
					String userName = rs.getString("user_name");
					int memoType = rs.getInt("memo_type");
					int checked = rs.getInt("checked");
					Date createdAt = rs.getDate("created_at");
					
					System.out.println("투두: " + 
							id + ", " + 
							memo + ", " +
							userName + ", " +
							memoType + ", " +
							checked + ", " +
							createdAt );
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
//		return;
	}
	
	// todo 통계/어드민??

	public static void main(String[] args) {
		//beginConnection(); // static?
		TodoDBMgr tdMgr = new TodoDBMgr();
		//tdMgr.beginConnection();		
		// todo 스키마를 기능에 맞도록 실행 영역
		//tdMgr.printAllTodos();
     	ArrayList<Todo> todos =	tdMgr.selectAllTodos();
     	
     	// '수박 구매' [v] checked
//     	for (int i = 0; i < todos.size(); i++) {
//			Todo td = todos.get(i);
//			String memo = td.getMemo();
//			if( memo.equals("수박 구매") )
//				td.setChecked(true); // DONE
//		}
     	
     	for (Todo td : todos) {
//			System.out.println(td); // to.toString()
     		System.out.println(td.toList());
//     		System.out.println(td.getMemo() 
//     				+ " " + td.getUserName() );
		}
     	
     	System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
     	
     	tdMgr.insertNewTodoOnDay(
     		"여행가기", "지혜", Todo.MT_NORMAL, "2021-05-15");     	
     	tdMgr.insertNewTodoOnDay(
         	"마이카 구매", "지혜", Todo.MT_PURCHASE, "2021-05-16");
     	
     	ArrayList<Todo> jhList =
     			tdMgr.selectAllTodosForUser("지혜");//"동근"
     	System.out.println("지혜 TODO 리스트::");
     	for (Todo jh : jhList) {
			System.out.println(jh);
		}
		
		tdMgr.endConnection();
		//endConnection();
	}

	public ArrayList<Todo> selectAllTodosForUser(
			String user) {
		if( this.conn != null ) {
			ArrayList<Todo> tdList = new ArrayList<Todo>();
			String sql = 
			"select * from todos "
			+ " where user_name = '" + user + "' " 		
			+ " order by created_at desc";
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while( rs.next() ) {
//					rs.get타입("필드명");  
					int id = rs.getInt("id");
					String memo = rs.getString("memo");
					String userName = rs.getString("user_name");
					int memoType = rs.getInt("memo_type");
					int checked = rs.getInt("checked");
					Date createdAt = rs.getDate("created_at");
					
					Todo td = new Todo(id, memo, userName,
							memoType, 
							checked == Todo.DONE,
							createdAt);
							//checked == Todo.DONE ? true: false,
							//	createdAt);
					tdList.add(td);
				}
				System.out.println("DB에서 조회한 todo 개수: "
						+ tdList.size());
				return tdList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		return null;
	}

	// 특정 날자 strDate에 속하는 todos 레코드들만 조회하기
	// strDate => "2021-05-14"
	public ArrayList<Todo> selectAllTodos(String strDate) {
		if( this.conn != null ) {
			ArrayList<Todo> tdList = new ArrayList<Todo>();
			String sql = 
			"select * from todos where created_at "
			+ ">= TO_DATE('"+strDate+"','YYYY-MM-DD') "  
			+ " and created_at "
			+ "< TO_DATE('"+strDate+"','YYYY-MM-DD')+1";
			System.out.println("sql: " + sql);
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while( rs.next() ) {
//					rs.get타입("필드명");  
					int id = rs.getInt("id");
					String memo = rs.getString("memo");
					String userName = rs.getString("user_name");
					int memoType = rs.getInt("memo_type");
					int checked = rs.getInt("checked");
					Date createdAt = rs.getDate("created_at");
					
					Todo td = new Todo(id, memo, userName,
							memoType, 
							checked == Todo.DONE,
							createdAt);
							//checked == Todo.DONE ? true: false,
							//	createdAt);
					tdList.add(td);
				}
				System.out.println("DB에서 조회한 todo 개수: "
						+ tdList.size());
				return tdList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		return null;
	}

}


/*
DB 접속 성공! Fri May 14 11:02:37 KST 2021
DB에서 조회한 todo 개수: 9
Todo [id=7, memo=만섭씨랑 스테이크 먹기, userName=진영, memoType=1, checked=false, createdAt=2021-05-14]
Todo [id=23, memo=파인애플 구매, userName=진영, memoType=3, checked=false, createdAt=2021-05-14]
Todo [id=50, memo=파인애플 구매, userName=진영, memoType=3, checked=false, createdAt=2021-05-14]
Todo [id=22, memo=수박 구매, userName=진영, memoType=3, checked=false, createdAt=2021-05-14]
Todo [id=21, memo=수박 구매, userName=진영, memoType=3, checked=false, createdAt=2021-05-14]
Todo [id=5, memo=삼겹살 구매, userName=진영, memoType=3, checked=false, createdAt=2021-05-13]
Todo [id=6, memo=삼겹살 구매, userName=진영, memoType=3, checked=false, createdAt=2021-05-13]
Todo [id=4, memo=삼겹살 구매, userName=진영, memoType=3, checked=false, createdAt=2021-05-13]
Todo [id=3, memo=삼겹살 구매, userName=진영, memoType=3, checked=false, createdAt=2021-05-13]
DB 종료 성공!!
*/