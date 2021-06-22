package dbtest;

//import java.sql.*; // JDBC ��� ����� ��� Ÿ��
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
// https://www.oracle.com/database/technologies/appdev/jdbc-downloads.html
// ojdbc6.jar ���̺귯���� �ٿ�ε� �޾Ƽ� ���
// 11gXE�� ȣȯ������ ������ jar�� ����.
// �����ͺ��̽������� �ڹ�(Ŭ���̾�Ʈ)���α׷��� ����ϴ� ���� TCP ������
// ���� ������ ���ؼ� �����.

// ������ ��Ű�� �߽� ��� 
// DB coporations TBL <----> java Company Ŭ���� ��������
//    ���ڵ� �ϳ�					 ��ü �ϳ�

public class DBTest {
	
	static Connection conn; // DBMS ������ �����ϴ� ��� ���ذ�ü
	private static final String account = "DEVEL"; // ��Ű����/������
	private static final String pw = "1234";
	static final String url 
		= "jdbc:oracle:thin:@localhost:1521:xe"; 
			// IP �ּ�, port ��Ʈ 1521, SID ���񽺾��̵� xe 
				// XE ���� ���� ����Ŭ ���� (127.0.0.1 �ּ� �����Ŀ� �ִ� ���� - �������ּ�)
		//= "jdbc:oracle:thin:@localhost:1521:orcl"; // ORCL ���
	
	// DB�� �����ϱ� (�����ϱ� - ���ä�� �¾�)
	public static boolean beginConnection() {
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
	public static boolean endConnection() {
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
	
	public static void main(String[] args) {
		beginConnection(); // ����		
		// DB ����, ����... ��ɵ��� ������ �� �ִ� ����
		
		endConnection(); // ����
	}

}
