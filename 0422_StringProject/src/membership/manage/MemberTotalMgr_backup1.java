package membership.manage;

import membership.data.Member;

// Object > MemberMgr > MemberShoppingMgr 
//		> MemberShoppingChildMgr : MemberSearch 
//		> MemberTotalMgr 
public class MemberTotalMgr_backup1 
	extends MemberShoppingChildMgr 
	implements MemberLogin {
//	extends MemberShoppingChildMgr {
	
	public MemberTotalMgr_backup1() {
		super();
	}

	public MemberTotalMgr_backup1(int size) {
		super(size);
	}

	public MemberTotalMgr_backup1(Member[] store) {
		super(store);
	}

	@Override
	public boolean loginProcess(String id, String pw) {
		final String dummyPW = "1234";
		
		if( pw.equals(dummyPW) ||
			 pw.isEmpty() ) return true;		
		else return false;
	}

	@Override
	public int loginProcessWithErrors(String id, String pw) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}

/*
>> ȸ�� �̸�: ȫ�浿
>> ȸ�� ����: 11
>> �̸��� �ּ�: hong@h.com
>> ȸ�� ���̵�: hong
>> ȸ�� ��ȣ: 123
>> ȸ�� ������� [��: 2020-03-14]: 2020-09-30
~~~~~~~~~~~~~~~~~~~~~~~
	 ȫ�浿 �� ������ ȯ���մϴ�!!
	 ���� ����:: 
3, ȫ�浿, 11, hong@h.com, 1000.0, hong, 123, Wed Sep 30 00:00:00 KST 2020, Tue Apr 27 10:18:51 KST 2021
~~~~~~~~~~~~~~~~~~~~~~~
>> �߰� ȸ�� ����? (yes/no)no
	 �ű�ȸ�� 1���� �߰���......
>> ������:: ��ǰ ���θ��!!!!
hong �α��� ���� ����!!
*/