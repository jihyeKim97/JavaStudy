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



	// �θ�� ������� ��� ������ �߻�޼ҵ���� �� �Ѱ��� ������� 
	// ��� �����Ͽ� �ڽ��� ��üȭ Ŭ��������.
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
			String mbId = mb.getId(); // null �ƴ϶�� ����..
			if( mbId.equals(id)) { // ���
//			if( mbId == id ) // ���ϼ� 	// ���Ե� ȸ��...
				String mbPw = mb.getPassword();
				if( mbPw.equals(pw) ) { // ��ȣ ��ġ!
					return LOGIN_SUCCESS;
				} else { // pw ����ġ..
					return LOGIN_ERR_PW_MISMATCH;	
				}
			}
		}
		// ���Ե��� �ʴ� ȸ��		
		return LOGIN_ERR_ID_NOT_FOUND;
	}

}

