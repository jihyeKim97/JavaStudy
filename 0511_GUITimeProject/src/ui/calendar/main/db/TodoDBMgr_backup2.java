package ui.calendar.main.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

// 중개(중재) 클래스 broker, manager, agent?
// 저장단(DB..) <===> UI단 (스윙?..) 사이에서 
// todo 스키마 데이터의 입출력을 기능적으로 중개해주는 클래스
// TodoVO (데이터) --- TodoDAO (데이터액세스오브젝트)

public class TodoDBMgr_backup2 {
	
	Connection conn; // DBMS 서버와 접속하는 통로 기준객체
	private static final String account = "DEVEL"; // 스키마명/유저명
	private static final String pw = "1234";
	static final String url 
		= "jdbc:oracle:thin:@localhost:1521:xe"; 
			// IP 주소, port 포트 1521, SID 서비스아이디 xe 
				// XE 서비스 지역 오라클 서버 (127.0.0.1 주소 같은컴에 있는 서버 - 루프백주소)
		//= "jdbc:oracle:thin:@localhost:1521:orcl"; // ORCL 상용
	
	public TodoDBMgr_backup2() { // 생성자에서 통신채널 연결 셋업.
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
	
	// memo, userName
	
	// 기존 todo를 하나를 편집, 갱신 할 수 있다. (완료??)
	// 기존 todo를 하나를 삭제할 수 있다.
	
	// 기존 todo를 하나를 조회할 수 있다. 
	// 기존 todo 모두를 조회할 수 있다. (전체, 기간, 사용자, 타입...)
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
		TodoDBMgr_backup2 tdMgr = new TodoDBMgr_backup2();
		//tdMgr.beginConnection();		
		// todo 스키마를 기능에 맞도록 실행 영역
		tdMgr.printAllTodos();
		
		tdMgr.endConnection();
		//endConnection();
	}

}
