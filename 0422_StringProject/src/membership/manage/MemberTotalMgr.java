package membership.manage;

import java.util.Scanner;

import membership.data.Member;

// Object > MemberMgr > MemberShoppingMgr 
//		> MemberShoppingChildMgr : MemberSearch 
//		> MemberTotalMgr
// abstract 클래스; 추상클래스 선언! 한 개 이상의 추상 메소드를 가져도 정상인 클래스
public abstract class MemberTotalMgr 
	extends MemberShoppingChildMgr 
	implements MemberLogin {
//	extends MemberShoppingChildMgr {
	
	public MemberTotalMgr() {
		super();
	}

	public MemberTotalMgr(int size) {
		super(size);
	}

	public MemberTotalMgr(Member[] store) {
		super(store);
	}
	
	// 자신의 고유한 추상메서드를 선언함
	public abstract int readyLogin(Scanner sc);

	@Override
	public boolean loginProcess(String id, String pw) {
		final String dummyPW = "1234";
		
		if( pw.equals(dummyPW) ||
			 pw.isEmpty() ) return true;		
		else return false;
	}

	// 추상 메소드를 모두 구현하지 못했음...
//	@Override
//	public int loginProcessWithErrors(String id, String pw) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
	
	
}

/*
>> 회원 이름: 홍길동
>> 회원 나이: 11
>> 이메일 주소: hong@h.com
>> 회원 아이디: hong
>> 회원 암호: 123
>> 회원 생년월일 [예: 2020-03-14]: 2020-09-30
~~~~~~~~~~~~~~~~~~~~~~~
	 홍길동 님 가입을 환영합니다!!
	 가입 내역:: 
3, 홍길동, 11, hong@h.com, 1000.0, hong, 123, Wed Sep 30 00:00:00 KST 2020, Tue Apr 27 10:18:51 KST 2021
~~~~~~~~~~~~~~~~~~~~~~~
>> 추가 회원 가입? (yes/no)no
	 신규회원 1명이 추가됨......
>> 마케팅:: 상품 프로모션!!!!
hong 로그인 인증 실패!!
*/