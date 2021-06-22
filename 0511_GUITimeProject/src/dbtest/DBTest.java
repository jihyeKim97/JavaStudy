package dbtest;

//import java.sql.*; // JDBC 통신 연결용 모든 타입
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
// https://www.oracle.com/database/technologies/appdev/jdbc-downloads.html
// ojdbc6.jar 라이브러리를 다운로드 받아서 사용
// 11gXE에 호환가능한 버젼의 jar가 좋음.
// 데이터베이스서버와 자바(클라이언트)프로그램이 통신하는 것은 TCP 수준의
// 동기 동신을 통해서 진행됨.

// 데이터 스키마 중심 통신 
// DB coporations TBL <----> java Company 클래스 대응관계
//    레코드 하나					 객체 하나

public class DBTest {
	
	static Connection conn; // DBMS 서버와 접속하는 통로 기준객체
	private static final String account = "DEVEL"; // 스키마명/유저명
	private static final String pw = "1234";
	static final String url 
		= "jdbc:oracle:thin:@localhost:1521:xe"; 
			// IP 주소, port 포트 1521, SID 서비스아이디 xe 
				// XE 서비스 지역 오라클 서버 (127.0.0.1 주소 같은컴에 있는 서버 - 루프백주소)
		//= "jdbc:oracle:thin:@localhost:1521:orcl"; // ORCL 상용
	
	// DB에 연결하기 (접속하기 - 통신채널 셋업)
	public static boolean beginConnection() {
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
	public static boolean endConnection() {
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
	
	public static void main(String[] args) {
		beginConnection(); // 접속		
		// DB 생성, 조작... 명령들을 수행할 수 있는 영역
		
		endConnection(); // 해제
	}

}
