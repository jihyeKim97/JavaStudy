package membership.manage;
// 회원들을 관리하기 위한 중개 클래스 

import membership.data.Member;

public class MemberMgr_backup1 {
	public static final int MAX_MEMBERS = 5;
	
	// 관리되는 회원들 (저장소; 메모리, 파일, DB, 클라우드)
	
	// 1. 다 수의 회원들을 저장할 공간을 준비 (유즈케이스 다이어그램)
	private Member[] _members;
	
	// 2. 다 수의 회원들을 한 명씩 등록할 수 있다. (가입)
	
	// 3. 등록된 회원들의 총 리스트를 출력할 수 있다. 
	
	// 4. 등록된 전체 회원들의 총 명수를 확인할 수 있다. 
	
	// 5. 회원 저장소가 꽉차였는지? 비워졌는지 확인 할 수 있다.
	
	// 6. 등록된 회원들을 특정 조건/키워드로 검색할 수 있다.
	
	// 7. 로그인 인증 처리 할 수 있다.
	
	// (8. 패스워드를 암호화 할 수 있다.) 
}
