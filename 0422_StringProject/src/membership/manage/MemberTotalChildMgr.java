package membership.manage;

import java.util.Scanner;

import membership.data.Member;

public abstract class MemberTotalChildMgr extends MemberTotalMgr {
//public class MemberTotalChildMgr extends MemberTotalMgr {

	// 부모 클래스의 추상메소드를 남김없이 구현해야함
//	@Override
//	public int loginProcessWithErrors(String id, String pw) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	// 부모 추상클래스 고유의 추상메소드를 자식이 재정의하여 구체화메소드
	// 
	@Override
	public int readyLogin(Scanner sc) {
		System.out.println("--- 로그인 처리 ---");
		System.out.print(">>로그인: ");
		String login = sc.next();
		String pw = inputString(sc, ">>패스워드: ");
		
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
