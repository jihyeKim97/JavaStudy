package db.mgr;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*
> CAFE.members TBL ���̺�
> db.data.Member ������ Ŭ����
> db.mgr.MemberDBMgr ������ DB�߰��� Ŭ���� 
 */
//import java.sql.Connection;
//import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

import db.data.Member;
import db.util.OracleDBUtil;

public class MemberDBMgr_backup1 {
	
	Connection conn;
	
	public MemberDBMgr_backup1() {
		this.conn = OracleDBUtil.getConn();
	}
	
//	- �ű� ȸ�� ���� �� �� �ִ�. C Member ��ü�� �Է�
	public boolean insertNewMember(Member mb) {
		if( this.conn != null && mb != null ) {
			String sql   // ����, ����, Ÿ��.. ����
			= "INSERT INTO members VALUES ("
		+ "MEMBER_SEQ.nextval, ?, ?, ?, ?, ?, 1000, sysdate)";
			System.out.println(sql); // ? �����ڴ� ���� '��' �ڵ� ������..
			try {
//				Statement stmt = conn.createStatement();
				PreparedStatement pstmt
					= conn.prepareStatement(sql); // ���������غ�
				// ?�������� ����, ����, Ÿ�� set...
				pstmt.setString(1, mb.getName());				
				pstmt.setString(2, mb.getLogin());
				pstmt.setString(3, mb.getPw());
				pstmt.setInt(4, mb.getAge());
				pstmt.setInt(5, mb.getGender());				
				int r = pstmt.executeUpdate(); // ����
					// ������ ��ȭ(DML insert, update, delete)
				// ��ȭ ���� �ܼ� ������ ��ȸ�� stmt.executeQuery() select
				if( r == 1 ) {
					System.out.println("DBMgr: ȸ�� ���� ����! "
							+ mb);
				} else {
					System.out.println("DBMgr: ȸ�� ���� ����! " 
							+ mb);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB ��� ����!!");
		}
		return false;
	}
	
	public boolean insertNewMember2(Member mb) {
		if( this.conn != null && mb != null ) {
			String sql   // ����, ����, Ÿ��.. ����
			= "INSERT INTO members VALUES ("
			  + "MEMBER_SEQ.nextval, '"+mb.getName()+"', "
			  + "'"+mb.getLogin()+"', '"+mb.getPw()+"'" + 
				", "+mb.getAge()+", "+mb.getGender()+", 1000, sysdate)";
			System.out.println(sql);
			try {
				Statement stmt = conn.createStatement();
				int r = stmt.executeUpdate(sql); 
					// ������ ��ȭ(DML insert, update, delete)
				// ��ȭ ���� �ܼ� ������ ��ȸ�� stmt.executeQuery() select
				if( r == 1 ) {
					System.out.println("DBMgr: ȸ�� ���� ����! "
							+ mb);
				} else {
					System.out.println("DBMgr: ȸ�� ���� ����! " 
							+ mb);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB ��� ����!!");
		}
		return false;
	}
	
//	- �ű� ȸ�� ���� �� �� �ִ�. C ȸ�� ��Ű���� ���� �Է�
	public boolean insertNewMember(
			String name, String login,
			String pw, int age, int gender) {
		if( this.conn != null ) {
			String sql   // ����, ����, Ÿ��.. ����
			= "INSERT INTO members VALUES ("
			  + "MEMBER_SEQ.nextval, '"+name+"', "
			  + "'"+login+"', '"+pw+"'" + 
				", "+age+", "+gender+", 1000, sysdate)";
			System.out.println(sql);
			try {
				Statement stmt = conn.createStatement();
				int r = stmt.executeUpdate(sql); 
					// ������ ��ȭ(DML insert, update, delete)
				// ��ȭ ���� �ܼ� ������ ��ȸ�� stmt.executeQuery() select
				if( r == 1 ) {
					System.out.println("DBMgr: ȸ�� ���� ����! "
							+ login);
				} else {
					System.out.println("DBMgr: ȸ�� ���� ����! " 
							+ login);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB ��� ����!!");
		}
		return false;
	}
//	- ���� ȸ���� �ڽ��� ������ �������� (����) �� �� �ִ�. U
//		�̸�, ��ȣ, ����, ���ϸ��� ��..!! (* ��������)
//	- ���� ȸ���� �� ����� ����Ͽ� ��ȸ�� �� �ִ�.
	public int checkTotalNumberOfMembers() {
		if( this.conn != null ) {
//			String sql = "select COUNT(*) from members";
			String sql = "select COUNT(*) "
					+ "as member_cnt from members";
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				if( rs.next() ) {
					//int mbCnt = rs.getInt("COUNT(*)");
//					int mbCnt = rs.getInt(1); // ù��° �÷�
					int mbCnt = rs.getInt("member_cnt");
					return mbCnt;
				} else 
					return 0;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB ��� ����!!");
		}
		return -1;
	}
	
//	- ���� ȸ���� ���ϸ��� (����) �� �� �ִ�. U
//	- ���� ȸ���� ��ȣ (����) �� �� �ִ�. U
//	- ��� ���� ȸ������ ��ȸ�� �� �ִ�. R (����, ����, �˻�, ����, ���������̼�ȭ)
	public ArrayList<Member> selectAllMembers() {
		if( this.conn != null ) {
			ArrayList<Member> mbList = new ArrayList<>();
			String sql = "select * from members ORDER BY joined_at desc";
			try {
				Statement stmt =  conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while( rs.next() ) {	
					Date joinDay = rs.getDate("joined_at");
						// varchar --> date
//					java.sql.Date joinDay 
//						= (java.sql.Date)rs.getDate("joined_at");
					Member mb 
						= new Member(rs.getInt("id"),
								rs.getString("name"), 
								rs.getString("login"),
								rs.getString("pw"),
								rs.getInt("age"),
								rs.getInt("gender"),
								rs.getInt("mileage"),
								joinDay);
//								rs.getDate("joined_at"));
							// joinedAt <-----> joined_at
					mbList.add(mb);
				}
				System.out.println("DBMgr: ȸ�� ��ȸ ��� => " + mbList.size());
				return mbList;
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		} else {
			System.out.println("DB ��� ����!!");
		}
		return null;
	}
	
//	- Ư�� ���� ȸ�� �� ���� ��ȸ�� �� �ִ�. R (�α��θ�, ������ȣ)	
	public Member selectOneMemberById(int mbId) {
		if( this.conn != null ) {
			String sql = "select * from members"
					+ " where id = " + mbId;
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				if( rs.next() ) { // �� ���� ���ڵ常...
					Member mb 
					= new Member(rs.getInt("id"),
							rs.getString("name"), 
							rs.getString("login"),
							rs.getString("pw"),
							rs.getInt("age"),
							rs.getInt("gender"),
							rs.getInt("mileage"),
							rs.getDate("joined_at"));
					return mb;
				} else {
					System.out.println(mbId + 
							"��ȣ�� ȸ�� ���ڵ� ��ȸ DB ����!");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB ��� ����!!");
		}		
		return null;
	}
	public Member selectOneMemberByLogin(String mbLogin) {
		if( this.conn != null ) {
//			String sql = "select * from members"
//				+ " where login = '" + mbLogin + "'";
			String sql = "select * from members"
					+ " where login = ?";
			try {
//				Statement stmt = conn.createStatement();
				PreparedStatement pstmt =
							conn.prepareStatement(sql);
//				ResultSet rs = stmt.executeQuery(sql);
				pstmt.setString(1, mbLogin);				
				ResultSet rs = pstmt.executeQuery();
				if( rs.next() ) { // �� ���� ���ڵ常...
					Member mb 
					= new Member(rs.getInt("id"),
							rs.getString("name"), 
							rs.getString("login"),
							rs.getString("pw"),
							rs.getInt("age"),
							rs.getInt("gender"),
							rs.getInt("mileage"),
							rs.getDate("joined_at"));
					return mb;
				} else {
					System.out.println(mbLogin + 
							" �α��θ��� ȸ�� ���ڵ� ��ȸ DB ����!");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB ��� ����!!");
		}		
		return null;
	}

//	- ���� ȸ������ Ű���� ��� ������ �������� �˻� �� �� �ִ�. R
	
//	- ���� ȸ���� Ż���� �� �ִ�. (����? => Ż��� ���·� Ư���÷� ����) D
//	- Ư�� Ȱ���� ���� �������� ȸ�� ���ϸ��� ������ �� �ִ�.
//	- ȸ���� �ٸ� ȸ���� ��õ/���ƿ�/�ȷ���..�� �� �ִ�.

//	- ȸ���� �α���/�α׾ƿ�... �� �� �ִ�.(���ȣȭ)
	
//	- ȸ�� ���
	
	public static void main(String[] args) {
		MemberDBMgr_backup1 mbMgr = new MemberDBMgr_backup1();
		System.out.println("���� -----------");
		ArrayList<Member> oldList = mbMgr.selectAllMembers();
		for (Member mb : oldList) {
			System.out.println(mb.toString());
		}
		
		System.out.println("���ڵ� 2�� �߰�....");
		mbMgr.insertNewMember( 
				new Member("�ö���", "olaf4", "1234",
				18, Member.GENDER_MALE));
		Member newMB = new Member("����", "sven4", "1234",
				33, Member.GENDER_MALE);
		mbMgr.insertNewMember(newMB);
//		mbMgr.insertNewMember("�ö���", "olaf", "1234",
//				18, Member.GENDER_MALE);
//		mbMgr.insertNewMember("����", "sven", "1234",
//				33, Member.GENDER_MALE);
		
		System.out.println("�߰� -----------");
		ArrayList<Member> newList = mbMgr.selectAllMembers();
		for (Member mb : newList) {
			System.out.println(mb);
		}
		
		System.out.println(">> ���� ȸ�� ���ڵ� ��: " 
				+ mbMgr.checkTotalNumberOfMembers() + "��");
		
		OracleDBUtil.endConnection();
	}
}

/*
DB ���� ����! Thu May 20 13:36:18 KST 2021
���� -----------
DBMgr: ȸ�� ��ȸ ��� => 9
Member [id=11, name=����, login=sven3, pw=1234, age=33, gender=2, mileage=1000, joinedAt=2021-05-20]
Member [id=10, name=�ö���, login=olaf3, pw=1234, age=18, gender=2, mileage=1000, joinedAt=2021-05-20]
Member [id=9, name=����, login=sven2, pw=1234, age=33, gender=2, mileage=1000, joinedAt=2021-05-20]
Member [id=8, name=�ö���, login=olaf2, pw=1234, age=18, gender=2, mileage=1000, joinedAt=2021-05-20]
Member [id=6, name=�ö���, login=olaf, pw=1234, age=18, gender=2, mileage=1000, joinedAt=2021-05-20]
Member [id=7, name=����, login=sven, pw=1234, age=33, gender=2, mileage=1000, joinedAt=2021-05-20]
Member [id=2, name=�ȳ�, login=anna, pw=1234, age=18, gender=1, mileage=2000, joinedAt=2021-05-20]
Member [id=1, name=����, login=elsa, pw=1234, age=20, gender=1, mileage=1000, joinedAt=2021-05-20]
Member [id=5, name=�ȳ�, login=anna2, pw=1234, age=18, gender=1, mileage=2000, joinedAt=2021-05-20]
���ڵ� 2�� �߰�....
INSERT INTO members VALUES (MEMBER_SEQ.nextval, ?, ?, ?, ?, ?, 1000, sysdate)
DBMgr: ȸ�� ���� ����! Member [id=0, name=�ö���, login=olaf4, pw=1234, age=18, gender=2, mileage=1000, joinedAt=null]
INSERT INTO members VALUES (MEMBER_SEQ.nextval, ?, ?, ?, ?, ?, 1000, sysdate)
DBMgr: ȸ�� ���� ����! Member [id=0, name=����, login=sven4, pw=1234, age=33, gender=2, mileage=1000, joinedAt=null]
�߰� -----------
DBMgr: ȸ�� ��ȸ ��� => 11
Member [id=12, name=�ö���, login=olaf4, pw=1234, age=18, gender=2, mileage=1000, joinedAt=2021-05-20]
Member [id=13, name=����, login=sven4, pw=1234, age=33, gender=2, mileage=1000, joinedAt=2021-05-20]
Member [id=11, name=����, login=sven3, pw=1234, age=33, gender=2, mileage=1000, joinedAt=2021-05-20]
Member [id=10, name=�ö���, login=olaf3, pw=1234, age=18, gender=2, mileage=1000, joinedAt=2021-05-20]
Member [id=8, name=�ö���, login=olaf2, pw=1234, age=18, gender=2, mileage=1000, joinedAt=2021-05-20]
Member [id=9, name=����, login=sven2, pw=1234, age=33, gender=2, mileage=1000, joinedAt=2021-05-20]
Member [id=6, name=�ö���, login=olaf, pw=1234, age=18, gender=2, mileage=1000, joinedAt=2021-05-20]
Member [id=7, name=����, login=sven, pw=1234, age=33, gender=2, mileage=1000, joinedAt=2021-05-20]
Member [id=1, name=����, login=elsa, pw=1234, age=20, gender=1, mileage=1000, joinedAt=2021-05-20]
Member [id=5, name=�ȳ�, login=anna2, pw=1234, age=18, gender=1, mileage=2000, joinedAt=2021-05-20]
Member [id=2, name=�ȳ�, login=anna, pw=1234, age=18, gender=1, mileage=2000, joinedAt=2021-05-20]
>> ���� ȸ�� ���ڵ� ��: 11��
DB ���� ����!!

 */
