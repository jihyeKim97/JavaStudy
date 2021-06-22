package ui.calendar.main.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import ui.calendar.main.db.data.Todo;

// �߰�(����) Ŭ���� broker, manager, agent?
// �����(DB..) <===> UI�� (����?..) ���̿��� 
// todo ��Ű�� �������� ������� ��������� �߰����ִ� Ŭ����
// TodoVO (������) --- TodoDAO (�����;׼���������Ʈ)

public class TodoDBMgr {
	
	Connection conn; // DBMS ������ �����ϴ� ��� ���ذ�ü
	private static final String account = "DEVEL"; // ��Ű����/������
	private static final String pw = "1234";
	static final String url 
		= "jdbc:oracle:thin:@localhost:1521:xe"; 
			// IP �ּ�, port ��Ʈ 1521, SID ���񽺾��̵� xe 
				// XE ���� ���� ����Ŭ ���� (127.0.0.1 �ּ� �����Ŀ� �ִ� ���� - �������ּ�)
		//= "jdbc:oracle:thin:@localhost:1521:orcl"; // ORCL ���
	
	public TodoDBMgr() { // �����ڿ��� ���ä�� ���� �¾�.
		beginConnection();
	}
	
	// DB�� �����ϱ� (�����ϱ� - ���ä�� �¾�)
	public boolean beginConnection() {
		try {
		// 1. ����Ŭ JDBC ������(����̹�) Ŭ���� '����' �ε�
		//Class.forName("oracle.jdbc.driver.racleDriver");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 2. ����Ŭ DBMS ������ ��ſ����� ���� (���� ����) 
//		Connection conn = 
			conn = DriverManager.getConnection(url, account, pw);
			System.out.println("DB ���� ����! "
					+ new Date());
					//+ new java.util.Date());
		// 3. �������� �����̸� null�� �ƴ� ���ᰴü�� ���ϵ� 
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("ojdbc.jar�� ����ŬDB ����̹� �ε� ����!");
		} catch (SQLException e) {
			System.out.println("��� ���� ����!!! ");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("java �Ϲ� ����!!!");
//			e.printStackTrace();
		}
		return false;
	}
	
	// DB���� ���������ϱ�
	public boolean endConnection() {
		if( conn != null ) {
			try {
				conn.close();
				System.out.println("DB ���� ����!!");
				return true;
			} catch (SQLException e) {
				System.out.println("DB ���� ����!!");
				e.printStackTrace();
			}
		}		
		return false;
	}
	
	// actor�� ~�� �� �ִ�.  
	// �ű� todo�� �ϳ��� ���ڵ�� �߰� �� �� �ִ�. 
	// id, memo, userName, memoType, // checked,// createdAt
	
	
	// memo, userName, memoType
	
	// memo, userName, memoType, strDate
//	insert into todos(id, memo, user_name, memo_type,
//			checked, created_at) 
//	       values(TODO_SEQ.nextval, '���Ÿ ����� �����ϱ�',
//	    		   '����', 3, 0,
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
				if( r == 1 ) { // 1���� ���ڵ� insert ����
					 System.out.println("todo ���ڵ� �߰� ����: "
							 + memo);
					 return true;
				} else { // 0,..., 2, 3??
					System.out.println("todo ���ڵ� �߰� ����!: "
							 + memo);
				}
			} catch (SQLException e) {
				System.out.println("todo ���ڵ� �߰� ���� - SQL ����");
				e.printStackTrace();
			}
		}
		return false;
	}
	
	// memo, userName
	
	// ���� todo�� �ϳ��� ����, ���� �� �� �ִ�. (�Ϸ�??)
	// ���� todo�� �ϳ��� ������ �� �ִ�.
	
	// ���� todo�� �ϳ��� ��ȸ�� �� �ִ�. 
	// ���� todo ��θ� ��ȸ�� �� �ִ�. (��ü, �Ⱓ, �����, Ÿ��...)
	public ArrayList<Todo> selectAllTodos() {
		if( this.conn != null ) {
			ArrayList<Todo> tdList = new ArrayList<Todo>();
			String sql = "select * from todos order by created_at desc";
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while( rs.next() ) {
//					rs.getŸ��("�ʵ��");  
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
				System.out.println("DB���� ��ȸ�� todo ����: "
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
//					rs.getŸ��("�ʵ��");  
					int id = rs.getInt("id");
					String memo = rs.getString("memo");
					String userName = rs.getString("user_name");
					int memoType = rs.getInt("memo_type");
					int checked = rs.getInt("checked");
					Date createdAt = rs.getDate("created_at");
					
					System.out.println("����: " + 
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
	
	// todo ���/����??

	public static void main(String[] args) {
		//beginConnection(); // static?
		TodoDBMgr tdMgr = new TodoDBMgr();
		//tdMgr.beginConnection();		
		// todo ��Ű���� ��ɿ� �µ��� ���� ����
		//tdMgr.printAllTodos();
     	ArrayList<Todo> todos =	tdMgr.selectAllTodos();
     	
     	// '���� ����' [v] checked
//     	for (int i = 0; i < todos.size(); i++) {
//			Todo td = todos.get(i);
//			String memo = td.getMemo();
//			if( memo.equals("���� ����") )
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
     		"���డ��", "����", Todo.MT_NORMAL, "2021-05-15");     	
     	tdMgr.insertNewTodoOnDay(
         	"����ī ����", "����", Todo.MT_PURCHASE, "2021-05-16");
     	
     	ArrayList<Todo> jhList =
     			tdMgr.selectAllTodosForUser("����");//"����"
     	System.out.println("���� TODO ����Ʈ::");
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
//					rs.getŸ��("�ʵ��");  
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
				System.out.println("DB���� ��ȸ�� todo ����: "
						+ tdList.size());
				return tdList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		return null;
	}

	// Ư�� ���� strDate�� ���ϴ� todos ���ڵ�鸸 ��ȸ�ϱ�
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
//					rs.getŸ��("�ʵ��");  
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
				System.out.println("DB���� ��ȸ�� todo ����: "
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
DB ���� ����! Fri May 14 11:02:37 KST 2021
DB���� ��ȸ�� todo ����: 9
Todo [id=7, memo=�������� ������ũ �Ա�, userName=����, memoType=1, checked=false, createdAt=2021-05-14]
Todo [id=23, memo=���ξ��� ����, userName=����, memoType=3, checked=false, createdAt=2021-05-14]
Todo [id=50, memo=���ξ��� ����, userName=����, memoType=3, checked=false, createdAt=2021-05-14]
Todo [id=22, memo=���� ����, userName=����, memoType=3, checked=false, createdAt=2021-05-14]
Todo [id=21, memo=���� ����, userName=����, memoType=3, checked=false, createdAt=2021-05-14]
Todo [id=5, memo=���� ����, userName=����, memoType=3, checked=false, createdAt=2021-05-13]
Todo [id=6, memo=���� ����, userName=����, memoType=3, checked=false, createdAt=2021-05-13]
Todo [id=4, memo=���� ����, userName=����, memoType=3, checked=false, createdAt=2021-05-13]
Todo [id=3, memo=���� ����, userName=����, memoType=3, checked=false, createdAt=2021-05-13]
DB ���� ����!!
*/