package membership;

import java.util.Date;
import java.util.Scanner;

import membership.data.Member;
import membership.manage.FinalMemberMgr;
import membership.manage.MemberLogin;
import membership.manage.MemberMgr;
import membership.manage.MemberNextChildMgr;
import membership.manage.MemberNextMgr;
import membership.manage.MemberShoppingChildMgr;
import membership.manage.MemberShoppingMgr;
import membership.manage.MemberTotalChildMgr;
import membership.manage.MemberTotalMgr;

public class MemberMain6 {
	// 회원 (관리 대상) Member 
	// 회원 관리자 	   MemberManager => MemberMgr	
	public static void main(String[] args) {
		// 회원 데이터 (스키마)
		Member mb1 = new Member(
				"엘사", "elsa@winter.com",
				"elsa", "1234", new Date());
//		System.out.println(Member.order);
		mb1.setMileage(mb1.getMileage() + 500.0);
//		System.out.println(mb1);
		
		// 회원 관리 운영자 (회원 스키마 중개관리)
		Member[] store = {
			mb1, new Member("안나", "anna@winter.com",
					"anna", "1234", new Date())
			, null, null, null, null
		};
		
		FinalMemberMgr ttMgr = new FinalMemberMgr(store);
			// 추상클래스는 일반적으로 new를 통해 객체 생성이 안된다!!
		ttMgr.processJoinMembers(); // 2대
		ttMgr.printAllMembers();
		ttMgr.marketingPromotion(); // 3대
		ttMgr.readySearch(); // 4대의 인터페이스 메소드 재정의
		int loginResult = ttMgr.readyLogin(new Scanner(System.in));
					// 5대가 인터페이스 구현하려했다가 설계한 추상메소드
					// 6대가 구현한 메소드
					// 7대가 readyLogin()에서 사용되는 추상메소드 구현함.
		
		switch(loginResult) {
			case MemberLogin.LOGIN_SUCCESS:
				System.out.println("로그인 성공!!");
				// 출석부, 세션.. 등 초기화
				System.out.println(">> 마이페이지로 이동!");
				break;
			case MemberLogin.LOGIN_ERR_ID_NULL:				
			case MemberLogin.LOGIN_ERR_PW_NULL:				
			case MemberLogin.LOGIN_ERR_ID_EMPTY:				
			case MemberLogin.LOGIN_ERR_PW_EMPTY:
				System.out.println(">> 로그인 에러! 계정명이나 패스워드가 없음");
				break;	
			case MemberLogin.LOGIN_ERR_ID_NOT_FOUND:	
				System.out.println(">> 로그인 에러! 가입안된 회원?");
				break;
			case MemberLogin.LOGIN_ERR_PW_MISMATCH:			
				System.out.println(">> 로그인 에러! 암호 불일치!!_");
				break;
			default: 
				System.out.println("로그인 결과가 처리 불가능!");
		} 
		
	}

}

/*
 * >> 회원 이름: 안나프
>> 회원 나이: 22
>> 이메일 주소: annaf@winter.com
>> 회원 아이디: annaf
>> 회원 암호: 1234
>> 회원 생년월일 [예: 2020-03-14]: 2020-02-02
~~~~~~~~~~~~~~~~~~~~~~~
	 안나프 님 가입을 환영합니다!!
	 가입 내역:: 
3, 안나프, 22, annaf@winter.com, 1000.0, annaf, 1234, Sun Feb 02 00:00:00 KST 2020, Tue Apr 27 11:45:13 KST 2021
~~~~~~~~~~~~~~~~~~~~~~~
>> 추가 회원 가입? (yes/no)n
	 신규회원 1명이 추가됨......
=== 회원 리스트 === (3 / 6 명)
번호, 이름, 나이, 이메일, 마일리지, 계정명, 암호, 생일, 가입일
-------------------------------
1, 엘사, 18, elsa@winter.com, 1500.0, elsa, 1234, Tue Apr 27 11:44:36 KST 2021, Tue Apr 27 11:44:36 KST 2021
2, 안나, 18, anna@winter.com, 1000.0, anna, 1234, Tue Apr 27 11:44:36 KST 2021, Tue Apr 27 11:44:36 KST 2021
3, 안나프, 22, annaf@winter.com, 1000.0, annaf, 1234, Sun Feb 02 00:00:00 KST 2020, Tue Apr 27 11:45:13 KST 2021
Member 없음 
Member 없음 
Member 없음 
-------------------------------
>> 마케팅:: 상품 프로모션!!!!
--- 로그인 처리 ---
>>로그인: annaf
>>패스워드: 1234
로그인 성공!!
>> 마이페이지로 이동!


>> 마케팅:: 상품 프로모션!!!!
--- 로그인 처리 ---
>>로그인: sben
>>패스워드: 1234
>> 로그인 에러! 가입안된 회원?


>> 마케팅:: 상품 프로모션!!!!
--- 로그인 처리 ---
>>로그인: elsa
>>패스워드: 12300
>> 로그인 에러! 암호 불일치!!_

*/

