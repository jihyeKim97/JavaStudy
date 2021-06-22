package ui.calendar.main.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

// �߰�(����) Ŭ���� broker, manager, agent?
// �����(DB..) <===> UI�� (����?..) ���̿��� 
// todo ��Ű�� �������� ������� ��������� �߰����ִ� Ŭ����
// TodoVO (������) --- TodoDAO (�����;׼���������Ʈ)

public class TodoDBMgr_backup2 {
	
	Connection conn; // DBMS ������ �����ϴ� ��� ���ذ�ü
	private static final String account = "DEVEL"; // ��Ű����/������
	private static final String pw = "1234";
	static final String url 
		= "jdbc:oracle:thin:@localhost:1521:xe"; 
			// IP �ּ�, port ��Ʈ 1521, SID ���񽺾��̵� xe 
				// XE ���� ���� ����Ŭ ���� (127.0.0.1 �ּ� �����Ŀ� �ִ� ���� - �������ּ�)
		//= "jdbc:oracle:thin:@localhost:1521:orcl"; // ORCL ���
	
	public TodoDBMgr_backup2() { // �����ڿ��� ���ä�� ���� �¾�.
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
	
	// memo, userName
	
	// ���� todo�� �ϳ��� ����, ���� �� �� �ִ�. (�Ϸ�??)
	// ���� todo�� �ϳ��� ������ �� �ִ�.
	
	// ���� todo�� �ϳ��� ��ȸ�� �� �ִ�. 
	// ���� todo ��θ� ��ȸ�� �� �ִ�. (��ü, �Ⱓ, �����, Ÿ��...)
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
		TodoDBMgr_backup2 tdMgr = new TodoDBMgr_backup2();
		//tdMgr.beginConnection();		
		// todo ��Ű���� ��ɿ� �µ��� ���� ����
		tdMgr.printAllTodos();
		
		tdMgr.endConnection();
		//endConnection();
	}

}
