package membership.manage;
// ȸ������ �����ϱ� ���� �߰� Ŭ���� 

import membership.data.Member;

// Member ��Ű��(������)�� CRUD �����ϴ� Ŭ����
// ȸ�� ����, ȸ�� ����, ȸ�� ����, ȸ�� ��ȸ
public class MemberMgr_backup2 {
	public static final int MAX_MEMBERS = 5;
	
	// �����Ǵ� ȸ���� (�����; �޸�, ����, DB, Ŭ����)
	
	// 1. �� ���� ȸ������ ������ ������ �غ� (�������̽� ���̾�׷�)
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
	
	
	
	// 2. �� ���� ȸ������ �� �� ����� �� �ִ�. (����)
	
	// 3. ��ϵ� ȸ������ �� ����Ʈ�� ����� �� �ִ�.
	public void printAllMembers() {
		System.out.println("=== ȸ�� ����Ʈ === (" 
				//+ checkNumberOfMembers() + "��)");
				+ checkNumberOfMembers() +
				" / " + _members.length + " ��)");
				//+ this._members.length + "��)");
		System.out.println(
		"��ȣ, �̸�, ����, �̸���, ���ϸ���, ������, ��ȣ, ����, ������");
		System.out.println("-------------------------------");
		for (Member mb : _members) {
			System.out.println( mb == null ?
					"Member ���� " : mb.toString());
		}
		System.out.println("-------------------------------");
	}
	
	// 4. ��ϵ� ��ü ȸ������ �� ����� Ȯ���� �� �ִ�. 
	public int checkNumberOfMembers() {
		// ��ϵ� ȸ�� ��� === ������� �迭����  null�ƴ� ����.
		int count = 0;
		for (int i = 0; i < _members.length; i++) {
//			Member mb = _members[i];
//			if( mb != null ) count++;			
			if( _members[i] != null ) count++;
		}
		return count;
	}
	
	// 5. ȸ�� ����Ұ� ����������? ��������� Ȯ�� �� �� �ִ�.
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
	
	// 6. ��ϵ� ȸ������ Ư�� ����/Ű����� �˻��� �� �ִ�.
	
	// 7. �α��� ���� ó�� �� �� �ִ�.
	
	// (8. �н����带 ��ȣȭ �� �� �ִ�.) 
}
