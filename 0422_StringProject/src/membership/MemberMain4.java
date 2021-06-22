package membership;

import java.util.Date;

import membership.data.Member;
import membership.manage.MemberMgr;
import membership.manage.MemberNextChildMgr;
import membership.manage.MemberNextMgr;
import membership.manage.MemberShoppingChildMgr;
import membership.manage.MemberShoppingMgr;

public class MemberMain4 {
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
		
//		MemberNextChildMgr nMgr = new MemberNextChildMgr(store);
//		nMgr.processJoinMembers();
//		nMgr.printAllMembers();
//		nMgr.readySearch(); // next 계통에는 검색 고유기능이 확장됨..
//		
//		MemberShoppingMgr sMgr = new MemberShoppingMgr(3);
//		sMgr.processJoinMembers();
//		sMgr.marketingPromotion(); // shopping 계통에는 마케팅을 고유..
//		sMgr.printAllMembers();
//		sMgr.readySearch(); // ?
		
		//MemberShoppingChildMgr sMgr = new MemberShoppingChildMgr(3);
		MemberShoppingChildMgr sMgr = 
				new MemberShoppingChildMgr(store);
		sMgr.processJoinMembers();
		sMgr.marketingPromotion(); // shopping 계통에는 마케팅을 고유..
		sMgr.printAllMembers();
		
		Member[] result = sMgr
				.searchMembersAndReturn("el");
		System.out.println("** 쇼핑 차일드 검색결과:: ");
		for (Member member : result) {
			if( member == null ) break;
			System.out.println(member);
		}
	}

}

/*
>> 회원 이름: olaf
>> 회원 나이: 22
>> 이메일 주소: oalf@winter.com
>> 회원 아이디: anolaf
>> 회원 암호: 1234
>> 회원 생년월일 [예: 2020-03-14]: 2122-12-22
~~~~~~~~~~~~~~~~~~~~~~~
	 olaf 님 가입을 환영합니다!!
	 가입 내역:: 
3, olaf, 22, oalf@winter.com, 1000.0, anolaf, 1234, Tue Dec 22 00:00:00 KST 2122, Mon Apr 26 14:26:11 KST 2021
~~~~~~~~~~~~~~~~~~~~~~~
>> 추가 회원 가입? (yes/no)n
	 신규회원 1명이 추가됨......
=== 회원 리스트 MemberNextChildMgr === (3 / 6 명)
번호, 이름, 나이, 이메일, 마일리지, 계정명, 암호, 생일, 가입일
===============================
1, 엘사, 18, elsa@winter.com, 1500.0, elsa, 1234, Mon Apr 26 14:25:42 KST 2021, Mon Apr 26 14:25:42 KST 2021
-------------------------------
2, 안나, 18, anna@winter.com, 1000.0, anna, 1234, Mon Apr 26 14:25:42 KST 2021, Mon Apr 26 14:25:42 KST 2021
-------------------------------
3, olaf, 22, oalf@winter.com, 1000.0, anolaf, 1234, Tue Dec 22 00:00:00 KST 2122, Mon Apr 26 14:26:11 KST 2021
-------------------------------
Member 없음 
-------------------------------
Member 없음 
-------------------------------
Member 없음 
-------------------------------
===============================
=== 회원 검색 MemberNextChildMgr ===
>> 검색 키워드: an
...
	 FOUND:: 2, 안나, 18, anna@winter.com, 1000.0, anna, 1234, Mon Apr 26 14:25:42 KST 2021, Mon Apr 26 14:25:42 KST 2021
	 FOUND:: 3, olaf, 22, oalf@winter.com, 1000.0, anolaf, 1234, Tue Dec 22 00:00:00 KST 2122, Mon Apr 26 14:26:11 KST 2021





>> 회원 이름: 엘르
>> 회원 나이: 23
>> 이메일 주소: elle@spring.com
>> 회원 아이디: elle
>> 회원 암호: 1234
>> 회원 생년월일 [예: 2020-03-14]: 2020-04-09
~~~~~~~~~~~~~~~~~~~~~~~
	 엘르 님 가입을 환영합니다!!
	 가입 내역:: 
3, 엘르, 23, elle@spring.com, 1000.0, elle, 1234, Thu Apr 09 00:00:00 KST 2020, Mon Apr 26 15:24:44 KST 2021
~~~~~~~~~~~~~~~~~~~~~~~
>> 추가 회원 가입? (yes/no)y
>> 회원 이름: 종세
>> 회원 나이: 20
>> 이메일 주소: jongel@java.com
>> 회원 아이디: jongel
>> 회원 암호: 1111
>> 회원 생년월일 [예: 2020-03-14]: 2002-09-02
~~~~~~~~~~~~~~~~~~~~~~~
	 종세 님 가입을 환영합니다!!
	 가입 내역:: 
4, 종세, 20, jongel@java.com, 1000.0, jongel, 1111, Mon Sep 02 00:00:00 KST 2002, Mon Apr 26 15:25:41 KST 2021
~~~~~~~~~~~~~~~~~~~~~~~
>> 추가 회원 가입? (yes/no)no
	 신규회원 2명이 추가됨......
>> 마케팅:: 상품 프로모션!!!!
=== 회원 리스트 === (4 / 6 명)
번호, 이름, 나이, 이메일, 마일리지, 계정명, 암호, 생일, 가입일
-------------------------------
1, 엘사, 18, elsa@winter.com, 1500.0, elsa, 1234, Mon Apr 26 15:23:54 KST 2021, Mon Apr 26 15:23:54 KST 2021
2, 안나, 18, anna@winter.com, 1000.0, anna, 1234, Mon Apr 26 15:23:54 KST 2021, Mon Apr 26 15:23:54 KST 2021
3, 엘르, 23, elle@spring.com, 1000.0, elle, 1234, Thu Apr 09 00:00:00 KST 2020, Mon Apr 26 15:24:44 KST 2021
4, 종세, 20, jongel@java.com, 1000.0, jongel, 1111, Mon Sep 02 00:00:00 KST 2002, Mon Apr 26 15:25:41 KST 2021
Member 없음 
Member 없음 
-------------------------------
	 FOUND:: 엘사
...
	 FOUND:: 엘르
	 FOUND:: 종세
*** 결과: el로 검색한 회원이 3명 발견됨!!
** 쇼핑 차일드 검색결과:: 
1, 엘사, 18, elsa@winter.com, 1500.0, elsa, 1234, Mon Apr 26 15:23:54 KST 2021, Mon Apr 26 15:23:54 KST 2021
3, 엘르, 23, elle@spring.com, 1000.0, elle, 1234, Thu Apr 09 00:00:00 KST 2020, Mon Apr 26 15:24:44 KST 2021
4, 종세, 20, jongel@java.com, 1000.0, jongel, 1111, Mon Sep 02 00:00:00 KST 2002, Mon Apr 26 15:25:41 KST 2021

*/