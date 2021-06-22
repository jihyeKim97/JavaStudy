package membership;

import java.util.Date;

import membership.data.Member;
import membership.manage.MemberMgr;
import membership.manage.MemberNextMgr;

public class MemberMain3 {
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
		
		MemberNextMgr nMgr = new MemberNextMgr(store);
		nMgr.processJoinMembers();
		nMgr.printAllMembers();
		
//		nMgr.searchMembers(keyword);
		nMgr.readySearch();
	
	}

}

/*
>> 회원 이름: 올라프
>> 회원 나이: 12
>> 이메일 주소: olaf@summer.com
>> 회원 아이디: olaf
>> 회원 암호: 1234
>> 회원 생년월일 [예: 2020-03-14]: 2020-11-22
~~~~~~~~~~~~~~~~~~~~~~~
	 올라프 님 가입을 환영합니다!!
	 가입 내역:: 
3, 올라프, 12, olaf@summer.com, 1000.0, olaf, 1234, Sun Nov 22 00:00:00 KST 2020, Mon Apr 26 14:07:13 KST 2021
~~~~~~~~~~~~~~~~~~~~~~~
>> 추가 회원 가입? (yes/no)아니요
>> 회원 이름: 스벤
>> 회원 나이: 11
>> 이메일 주소: sben@summer.com
>> 회원 아이디: sben
>> 회원 암호: 1111
>> 회원 생년월일 [예: 2020-03-14]: 2202-12-23
~~~~~~~~~~~~~~~~~~~~~~~
	 스벤 님 가입을 환영합니다!!
	 가입 내역:: 
4, 스벤, 11, sben@summer.com, 1000.0, sben, 1111, Thu Dec 23 00:00:00 KST 2202, Mon Apr 26 14:08:30 KST 2021
~~~~~~~~~~~~~~~~~~~~~~~
>> 추가 회원 가입? (yes/no)no
	 신규회원 2명이 추가됨......
=== 회원 리스트 === (4 / 6 명)
번호, 이름, 나이, 이메일, 마일리지, 계정명, 암호, 생일, 가입일
-------------------------------
1, 엘사, 18, elsa@winter.com, 1500.0, elsa, 1234, Mon Apr 26 14:06:35 KST 2021, Mon Apr 26 14:06:35 KST 2021
2, 안나, 18, anna@winter.com, 1000.0, anna, 1234, Mon Apr 26 14:06:35 KST 2021, Mon Apr 26 14:06:35 KST 2021
3, 올라프, 12, olaf@summer.com, 1000.0, olaf, 1234, Sun Nov 22 00:00:00 KST 2020, Mon Apr 26 14:07:13 KST 2021
4, 스벤, 11, sben@summer.com, 1000.0, sben, 1111, Thu Dec 23 00:00:00 KST 2202, Mon Apr 26 14:08:30 KST 2021
Member 없음 
Member 없음 
-------------------------------
=== 회원 검색 ===
>> 검색 키워드: summer
...
...
	 FOUND:: 3, 올라프, 12, olaf@summer.com, 1000.0, olaf, 1234, Sun Nov 22 00:00:00 KST 2020, Mon Apr 26 14:07:13 KST 2021
	 FOUND:: 4, 스벤, 11, sben@summer.com, 1000.0, sben, 1111, Thu Dec 23 00:00:00 KST 2202, Mon Apr 26 14:08:30 KST 2021

*/