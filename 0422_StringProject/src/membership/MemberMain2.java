package membership;

import java.util.Date;

import membership.data.Member;
import membership.manage.MemberMgr;

public class MemberMain2 {
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
		MemberMgr mgr = new MemberMgr(store);
		//if( mgr.isMembersEmpty() == false)
		if( !mgr.isMembersEmpty() )
			mgr.printAllMembers();
		else 
			System.out.println(" 아직 등록회원이 한 명도 없네요!");
		
		// 회원 가입 - 여러 명 연속적 추가 등록
		mgr.processJoinMembers();
		
		if( !mgr.isMembersEmpty() )
			mgr.printAllMembers();
		else 
			System.out.println(" 아직 등록회원이 한 명도 없네요!");
	
	}

}

/*
=== 회원 리스트 === (2 / 6 명)
번호, 이름, 나이, 이메일, 마일리지, 계정명, 암호, 생일, 가입일
-------------------------------
1, 엘사, 18, elsa@winter.com, 1500.0, elsa, 1234, Mon Apr 26 13:19:17 KST 2021, Mon Apr 26 13:19:17 KST 2021
2, 안나, 18, anna@winter.com, 1000.0, anna, 1234, Mon Apr 26 13:19:17 KST 2021, Mon Apr 26 13:19:17 KST 2021
Member 없음 
Member 없음 
Member 없음 
Member 없음 
-------------------------------
>> 회원 이름: olaf
>> 회원 나이: 11
>> 이메일 주소: olaf@w.com
>> 회원 아이디: olaf
>> 회원 암호: 1234
>> 회원 생년월일 [예: 2020-03-14]: 2020-03월30
잘못된 포맷 생년월일 입력!!
~~~~~~~~~~~~~~~~~~~~~~~
	 olaf 님 가입을 환영합니다!!
	 가입 내역:: 
3, olaf, 11, olaf@w.com, 1000.0, olaf, 1234, Mon Apr 26 13:19:52 KST 2021, Mon Apr 26 13:19:52 KST 2021
~~~~~~~~~~~~~~~~~~~~~~~
>> 추가 회원 가입? (yes/no)y
>> 회원 이름: sben
>> 회원 나이: 22
>> 이메일 주소: sben@ss.com
>> 회원 아이디: sben
>> 회원 암호: 1234
>> 회원 생년월일 [예: 2020-03-14]: 2022-03-22
~~~~~~~~~~~~~~~~~~~~~~~
	 sben 님 가입을 환영합니다!!
	 가입 내역:: 
4, sben, 22, sben@ss.com, 1000.0, sben, 1234, Tue Mar 22 00:00:00 KST 2022, Mon Apr 26 13:20:49 KST 2021
~~~~~~~~~~~~~~~~~~~~~~~
>> 추가 회원 가입? (yes/no)No
	 신규회원 2명이 추가됨......
=== 회원 리스트 === (4 / 6 명)
번호, 이름, 나이, 이메일, 마일리지, 계정명, 암호, 생일, 가입일
-------------------------------
1, 엘사, 18, elsa@winter.com, 1500.0, elsa, 1234, Mon Apr 26 13:19:17 KST 2021, Mon Apr 26 13:19:17 KST 2021
2, 안나, 18, anna@winter.com, 1000.0, anna, 1234, Mon Apr 26 13:19:17 KST 2021, Mon Apr 26 13:19:17 KST 2021
3, olaf, 11, olaf@w.com, 1000.0, olaf, 1234, Mon Apr 26 13:19:52 KST 2021, Mon Apr 26 13:19:52 KST 2021
4, sben, 22, sben@ss.com, 1000.0, sben, 1234, Tue Mar 22 00:00:00 KST 2022, Mon Apr 26 13:20:49 KST 2021
Member 없음 
Member 없음 
-------------------------------
*/