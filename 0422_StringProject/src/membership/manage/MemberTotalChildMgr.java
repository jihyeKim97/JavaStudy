package membership.manage;

import java.util.Scanner;

import membership.data.Member;

public abstract class MemberTotalChildMgr extends MemberTotalMgr {
//public class MemberTotalChildMgr extends MemberTotalMgr {

	// �θ� Ŭ������ �߻�޼ҵ带 ������� �����ؾ���
//	@Override
//	public int loginProcessWithErrors(String id, String pw) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	// �θ� �߻�Ŭ���� ������ �߻�޼ҵ带 �ڽ��� �������Ͽ� ��üȭ�޼ҵ�
	// 
	@Override
	public int readyLogin(Scanner sc) {
		System.out.println("--- �α��� ó�� ---");
		System.out.print(">>�α���: ");
		String login = sc.next();
		String pw = inputString(sc, ">>�н�����: ");
		
		return loginProcessWithErrors(login, pw);
	}
	
	public MemberTotalChildMgr() {
		// TODO Auto-generated constructor stub
	}

	public MemberTotalChildMgr(int size) {
		super(size);
		// TODO Auto-generated constructor stub
	}

	public MemberTotalChildMgr(Member[] store) {
		super(store);
		// TODO Auto-generated constructor stub
	}
	
	

}
