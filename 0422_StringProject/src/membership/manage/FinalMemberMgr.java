package membership.manage;

import membership.data.Member;

public class FinalMemberMgr extends MemberTotalChildMgr {

	public FinalMemberMgr() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public FinalMemberMgr(int size) {
		super(size);
		// TODO Auto-generated constructor stub
	}



	public FinalMemberMgr(Member[] store) {
		super(store);
		// TODO Auto-generated constructor stub
	}



	// 부모님 조상들의 모든 물려준 추상메소드들을 단 한개도 남김없이 
	// 모두 구현하여 자신은 구체화 클래스가됨.
	@Override
	public int loginProcessWithErrors(String id, String pw) {
		if( id == null ) return LOGIN_ERR_ID_NULL;
		if( id.isEmpty() ) return LOGIN_ERR_ID_EMPTY;
		if( pw == null ) return LOGIN_ERR_PW_NULL;
		if( pw.isEmpty() ) return LOGIN_ERR_PW_EMPTY;
		
		//for (int i = 0; i < _members.length; i++) {
		final int readMbCnt = checkNumberOfMembers();
//		for (int i = 0; i < _members.length; i++) {
		for (int i = 0; i < readMbCnt; i++) {
			Member mb = _members[i];
			String mbId = mb.getId(); // null 아니라고 믿음..
			if( mbId.equals(id)) { // 동등성
//			if( mbId == id ) // 동일성 	// 가입된 회원...
				String mbPw = mb.getPassword();
				if( mbPw.equals(pw) ) { // 암호 일치!
					return LOGIN_SUCCESS;
				} else { // pw 불일치..
					return LOGIN_ERR_PW_MISMATCH;	
				}
			}
		}
		// 가입되지 않는 회원		
		return LOGIN_ERR_ID_NOT_FOUND;
	}

}

