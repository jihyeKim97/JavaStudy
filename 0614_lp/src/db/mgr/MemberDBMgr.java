package db.mgr;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import db.data.Member;
import db.util.OracleDBUtil;
public class MemberDBMgr {
	Connection conn;
	
	public MemberDBMgr() {
		this.conn = OracleDBUtil.getConn();
	}
	// 회원가입
	public boolean insertNewMember(Member mb) {
		if( this.conn != null && mb != null ) {
			String sql   // 순서, 개수, 타입.. 띄어쓰기
			= "INSERT INTO members VALUES ("
		+ "MEMBER_SEQ.nextval, ?, ?, ?, ?, ?, ?, sysdate)";
			System.out.println(sql); // ? 서식자는 값을 '값' 자동 감싸줌..
			try {
//				Statement stmt = conn.createStatement();
				PreparedStatement pstmt
					= conn.prepareStatement(sql); // 사전문장준비
				// ?서식자의 순서, 개수, 타입 set...
				pstmt.setString(1, mb.getName());				
				pstmt.setString(2, mb.getLogin());
				pstmt.setString(3, mb.getPw());
				pstmt.setInt(4, mb.getAge());
				pstmt.setString(5, mb.getEmail());	
				pstmt.setInt(6, mb.getPhone());
				int r = pstmt.executeUpdate(); // 전송
					// 데이터 변화(DML insert, update, delete)
				// 변화 없이 단순 데이터 조회는 stmt.executeQuery() select
				if( r == 1 ) {
					System.out.println("DBMgr: 회원 가입 성공! "
							+ mb);
					return true;
				} else {
					System.out.println("DBMgr: 회원 가입 실패! " 
							+ mb);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB 통신 에러!!");
		}
		return false;
	}
	public boolean insertNewMember2(Member mb) {
		if( this.conn != null && mb != null ) {
			String sql   // 순서, 개수, 타입.. 띄어쓰기
			= "INSERT INTO members VALUES ("
			  + "MEMBER_SEQ.nextval, '"+mb.getName()+"', "
			  + "'"+mb.getLogin()+"', '"+mb.getPw()+"'" + 
				", "+mb.getAge()+", "+mb.getEmail()+", "+mb.getPhone()+")";
			System.out.println(sql);
			try {
				Statement stmt = conn.createStatement();
				int r = stmt.executeUpdate(sql); 
					// 데이터 변화(DML insert, update, delete)
				// 변화 없이 단순 데이터 조회는 stmt.executeQuery() select
				if( r == 1 ) {
					System.out.println("DBMgr: 회원 가입 성공! "
							+ mb);
				} else {
					System.out.println("DBMgr: 회원 가입 실패! " 
							+ mb);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB 통신 에러!!");
		}
		return false;
	}
	
//	- 신규 회원 가입 할 수 있다. C 회원 스키마의 재료들 입력
	public boolean insertNewMember(
			String name, String login,
			String pw, int age, String email, int phone) {
		if( this.conn != null ) {
			String sql   // 순서, 개수, 타입.. 띄어쓰기
			= "INSERT INTO members VALUES ("
			  + "MEMBER_SEQ.nextval, '"+name+"', "
			  + "'"+login+"', '"+pw+"'" + 
				", "+age+", "+email+", "+phone+", sysdate)";
			System.out.println(sql);
			try {
				Statement stmt = conn.createStatement();
				int r = stmt.executeUpdate(sql); 
					// 데이터 변화(DML insert, update, delete)
				// 변화 없이 단순 데이터 조회는 stmt.executeQuery() select
				if( r == 1 ) {
					System.out.println("DBMgr: 회원 가입 성공! "
							+ login);
				} else {
					System.out.println("DBMgr: 회원 가입 실패! " 
							+ login);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB 통신 에러!!");
		}
		return false;
	}
	
	
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
//					int mbCnt = rs.getInt(1); // 첫번째 컬럼
					int mbCnt = rs.getInt("member_cnt");
					return mbCnt;
				} else 
					return 0;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB 통신 에러!!");
		}
		return -1;
	}
	public Member selectOneMemberByLogin(String mbLogin) {
		if( this.conn != null ) {
			String sql = "select * from members"
					+ " where login = ?";
			try {
				PreparedStatement pstmt =
							conn.prepareStatement(sql);
				pstmt.setString(1, mbLogin);				
				ResultSet rs = pstmt.executeQuery();
				if( rs.next() ) { // 한 개의 레코드만...
					Member mb 
					= new Member(rs.getInt("id"),
							rs.getString("name"), 
							rs.getString("login"),
							rs.getString("pw"),
							rs.getInt("age"),
							rs.getString("email"),
							rs.getInt("phone"),
							rs.getDate("joined_at"));
					return mb;
				} else {
					System.out.println(mbLogin + 
				" 로그인명의 회원 레코드 조회 DB 에러이거나 없는 계정임..");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB 통신 에러!!");
		}		
		return null;
	}
	
	
	public static final int LOGIN_SUCCESS = 1; // 인증 성공
	public static final int LOGIN_FAIL_PW_MISMATCH = 2; // 암호 불일치
	public static final int LOGIN_FAIL_NOT_FOUND = 3; // 회원계정 없음..
	public static final int LOGIN_ERROR = 4; // 기타 에러
	public int loginProcess(String login, String pw) {
		if( login == null || pw == null || 
				login.isEmpty() || pw.isEmpty() ) {
			System.out.println("로그인 인증에 대한 입력 에러!!");
			return LOGIN_ERROR;
		}
		if( this.conn != null ) {
			Member mb = selectOneMemberByLogin(login); // UQ
			if( mb != null ) { // 가입된 회원레코들 찾음!
				String mbPw = mb.getPw();
				if( mbPw != null && !mbPw.isEmpty() ) {
					if( mbPw.equals(pw) ) {
						System.out.println("로그인 인증 성공!!");
						return LOGIN_SUCCESS;
					} else {
						System.out.println("암호 불일치!!");
						return LOGIN_FAIL_PW_MISMATCH;
					}
				} else {
					System.out.println("로그인 인증에 대한 PW 에러!!");
					return LOGIN_ERROR;
				}						
			} else {
				System.out.println("잘못된 로그인 이름이거나 없는 회원!");
				return LOGIN_FAIL_NOT_FOUND;
			}
		}
		else {
			System.out.println("DB 통신 에러!!");
		}		
		return LOGIN_ERROR;
	}
	public ArrayList<Member> selectAllMembers() {
		if( this.conn != null ) {
			ArrayList<Member> mbList = new ArrayList<>();
			String sql = "select * from members ORDER BY joined_at desc";
			try {
				Statement stmt =  conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while( rs.next() ) {	
					Date joinDay = rs.getDate("joined_at");
					Member mb 
						= new Member(rs.getInt("id"),
								rs.getString("name"), 
								rs.getString("login"),
								rs.getString("pw"),
								rs.getInt("age"),
								rs.getString("email"),
								rs.getInt("phone"),
								rs.getDate("joined_at"));
//				
					mbList.add(mb);
				}
				System.out.println("DBMgr: 회원 조회 명수 => " + mbList.size());
				return mbList;
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		} else {
			System.out.println("DB 통신 에러!!");
		}
		return null;
	}
	
	
	public Member selectOneMemberById(int mbId) {
		if( this.conn != null ) {
			String sql = "select * from members"
					+ " where id = " + mbId;
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				if( rs.next() ) { // 한 개의 레코드만...
					Member mb 
					= new Member(rs.getInt("id"),
							rs.getString("name"), 
							rs.getString("login"),
							rs.getString("pw"),
							rs.getInt("age"),
							rs.getString("email"),
							rs.getInt("phone"),
							rs.getDate("joined_at"));
					return mb;
				} else {
					System.out.println(mbId + 
							"번호의 회원 레코드 조회 DB 에러!");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB 통신 에러!!");
		}		
		return null;
	}
	
	
//	- 회원 통계
	
	public static void main(String[] args) {
		MemberDBMgr mbMgr = new MemberDBMgr();
		System.out.println("기존 -----------");
		ArrayList<Member> oldList = mbMgr.selectAllMembers();
		for (Member mb : oldList) {
			System.out.println(mb.toString());
		}
		System.out.println("추가 -----------");
		ArrayList<Member> newList = mbMgr.selectAllMembers();
		for (Member mb : newList) {
			System.out.println(mb);
		}
		
		System.out.println(">> 최종 회원 레코드 수: " 
				+ mbMgr.checkTotalNumberOfMembers() + "명");
		
		// login
		Scanner sc = new Scanner(System.in);
		System.out.print(">> 아이디: " );
		String mbInputLogin = sc.next();
		System.out.print(">> 암호: " );
		String mbInputPW = sc.next();
		
		int loginR = mbMgr
				.loginProcess(mbInputLogin, mbInputPW);
		if( loginR == LOGIN_SUCCESS ) {
			Member mb = mbMgr.selectOneMemberByLogin(mbInputLogin);
			System.out.println(mbInputLogin + "("+ 
						mb.getName() +")회원님 인증 성공!");
			System.out.println("... 마이페이지 이동!!");
		}
		
		OracleDBUtil.endConnection();
	}	
	
	
}

