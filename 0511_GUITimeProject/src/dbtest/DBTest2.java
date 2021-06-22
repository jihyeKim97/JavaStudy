package dbtest;

//import java.sql.*; // JDBC ��� ����� ��� Ÿ��
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import dbtest.data.Company;
// https://www.oracle.com/database/technologies/appdev/jdbc-downloads.html
// ojdbc6.jar ���̺귯���� �ٿ�ε� �޾Ƽ� ���
// 11gXE�� ȣȯ������ ������ jar�� ����.
// �����ͺ��̽������� �ڹ�(Ŭ���̾�Ʈ)���α׷��� ����ϴ� ���� TCP ������
// ���� ������ ���ؼ� �����.

// ������ ��Ű�� �߽� ��� 
// DB corporations TBL <----> java Company Ŭ���� ��������
//    ���ڵ� �ϳ�					 ��ü �ϳ�

public class DBTest2 {
	
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
	
	
	// ȸ�� ��Ű�� ����...
	// IT ȸ�� ���̺��� ������ �����ͼ� ����ϱ� (��� ���ڵ� ��ȸ)
	// DEVEL.coporations ���̺� select ��ȸ
	public static void printAllCompaniesFromDB() {
		if( conn != null ) { // ��� ���� ���ӿ��� ��...
			// 4. ������ SQL ����� ���ڿ��� �غ���
			String sql = "select * from corporations";
			try {
				// 5. ���ä��conn���κ��� ���� ��ü ���� �غ�
				Statement stmt = conn.createStatement();
				// 6. ���� ��ü�� �����Լ��� ���� ���������� sql ������ ����
				// 7. (select) ������ ����� ResultSet ���̺������� 
				//    ��ȸ ��������͸� DB������ ���� �������� ���Ź���.
				ResultSet rs = stmt.executeQuery(sql);
				
				// 8. rs (���̾ƴ϶��..)�� �߽�����  �������
				//  �ϳ��� ���ڵ������ Ž���ϸ� ���� (ó���� ��� �����Ͱ� ������..)
				while(rs.next() ) { //) == true)
					// 9. �� �� ���� �ش� ���ڵ��� ���� ��� �ʵ�(�÷�)���� �� Ÿ������ ���� get��.
					//rs.getInt(1);// ù��° �ʵ�/�÷�
					int id = rs.getInt("id");// 'id' �÷�
					String name = rs.getString("name");
					String domain = rs.getString("domain");
					String ceo = rs.getString("ceo");
					float rate = rs.getFloat("rate");
					String rank = rs.getString("rank");
					// ���̺� ���ڵ尡 ��Ű�� ��ü�� ���� 1:1 
					Company cp = new 
						Company(id, name, domain, 
								ceo, rate, rank);
					System.out.println(cp); // toString()
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.println("��� ä�� ����!!");
		}
	}
	
	public static void main(String[] args) {
		beginConnection(); // ����		
		// DB ����, ����... ��ɵ��� ������ �� �ִ� ����
		printAllCompaniesFromDB();
		endConnection(); // ����
	}

}
