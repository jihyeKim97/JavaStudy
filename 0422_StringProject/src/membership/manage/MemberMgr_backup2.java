package membership.manage;
// 회원들을 관리하기 위한 중개 클래스 

import membership.data.Member;

// Member 스키마(데이터)를 CRUD 조작하는 클래스
// 회원 생성, 회원 갱신, 회원 삭제, 회원 조회
public class MemberMgr_backup2 {
	public static final int MAX_MEMBERS = 5;
	
	// 관리되는 회원들 (저장소; 메모리, 파일, DB, 클라우드)
	
	// 1. 다 수의 회원들을 저장할 공간을 준비 (유즈케이스 다이어그램)
	private Member[] _members;
	
	public MemberMgr_backup2() {
		this._members = new Member[MAX_MEMBERS];
		 // { null, null, null, null, null }
	}

	public MemberMgr_backup2(int size) {
//		super();
		if( size <= 0 ) size = MAX_MEMBERS;
		this._members = new Member[size];
	}
	
	public MemberMgr_backup2(Member[] store) {
		super();
		if( store != null && store.length > 0 )
			this._members = store;
		else 
			this._members = new Member[MAX_MEMBERS];
	}
	
	
	
	// 2. 다 수의 회원들을 한 명씩 등록할 수 있다. (가입)
	
	// 3. 등록된 회원들의 총 리스트를 출력할 수 있다.
	public void printAllMembers() {
		System.out.println("=== 회원 리스트 === (" 
				//+ checkNumberOfMembers() + "명)");
				+ checkNumberOfMembers() +
				" / " + _members.length + " 명)");
				//+ this._members.length + "명)");
		System.out.println(
		"번호, 이름, 나이, 이메일, 마일리지, 계정명, 암호, 생일, 가입일");
		System.out.println("-------------------------------");
		for (Member mb : _members) {
			System.out.println( mb == null ?
					"Member 없음 " : mb.toString());
		}
		System.out.println("-------------------------------");
	}
	
	// 4. 등록된 전체 회원들의 총 명수를 확인할 수 있다. 
	public int checkNumberOfMembers() {
		// 등록된 회원 명수 === 저장공간 배열에서  null아닌 개수.
		int count = 0;
		for (int i = 0; i < _members.length; i++) {
//			Member mb = _members[i];
//			if( mb != null ) count++;			
			if( _members[i] != null ) count++;
		}
		return count;
	}
	
	// 5. 회원 저장소가 꽉차였는지? 비워졌는지 확인 할 수 있다.
	public boolean isMembersFull() {
//		if(checkNumberOfMembers() == _members.length) return true;
//		else return false;
//		return checkNumberOfMembers()
//				== _members.length ? true: false;
		return checkNumberOfMembers() == _members.length;		
	}
	public boolean isMembersEmpty() {
		return checkNumberOfMembers() == 0;
	}
	
	// 6. 등록된 회원들을 특정 조건/키워드로 검색할 수 있다.
	
	// 7. 로그인 인증 처리 할 수 있다.
	
	// (8. 패스워드를 암호화 할 수 있다.) 
}
