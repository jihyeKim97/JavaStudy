package membership;

import java.util.Date;

import membership.data.Member;
import membership.manage.MemberMgr;

public class MemberMain {
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
//			null	
			, null, null, null, null
		};
		MemberMgr mgr = new MemberMgr(store);
		//if( mgr.isMembersEmpty() == false)
		if( !mgr.isMembersEmpty() )
			mgr.printAllMembers();
		else 
			System.out.println(" 아직 등록회원이 한 명도 없네요!");
		
		// 회원 가입 - 1명 추가 등록
		Member newMb = mgr.joinNewMember(null);
		if( newMb != null ) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("\t " +newMb.getName() +" 님 가입을 환영합니다!!");
			System.out.println("\t 가입 내역:: "); 
			System.out.println(newMb);// toString()
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
		}
		
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
1, 엘사, 18, elsa@winter.com, 1500.0, elsa, 1234, Mon Apr 26 11:49:24 KST 2021, Mon Apr 26 11:49:24 KST 2021
2, 안나, 18, anna@winter.com, 1000.0, anna, 1234, Mon Apr 26 11:49:24 KST 2021, Mon Apr 26 11:49:24 KST 2021
Member 없음 
Member 없음 
Member 없음 
Member 없음 
-------------------------------
>> 회원 이름: 스벤
>> 회원 나이: 12
>> 이메일 주소: sven@w.com
>> 회원 아이디: sven
>> 회원 암호: 1234
>> 회원 생년월일 [예: 2020-03-14]: 2002-07-08
~~~~~~~~~~~~~~~~~~~~~~~
	 스벤 님 가입을 환영합니다!!
	 가입 내역:: 
3, 스벤, 12, sven@w.com, 1000.0, sven, 1234, Mon Jul 08 00:00:00 KST 2002, Mon Apr 26 11:49:44 KST 2021
~~~~~~~~~~~~~~~~~~~~~~~
=== 회원 리스트 === (3 / 6 명)
번호, 이름, 나이, 이메일, 마일리지, 계정명, 암호, 생일, 가입일
-------------------------------
1, 엘사, 18, elsa@winter.com, 1500.0, elsa, 1234, Mon Apr 26 11:49:24 KST 2021, Mon Apr 26 11:49:24 KST 2021
2, 안나, 18, anna@winter.com, 1000.0, anna, 1234, Mon Apr 26 11:49:24 KST 2021, Mon Apr 26 11:49:24 KST 2021
3, 스벤, 12, sven@w.com, 1000.0, sven, 1234, Mon Jul 08 00:00:00 KST 2002, Mon Apr 26 11:49:44 KST 2021
Member 없음 
Member 없음 
Member 없음 
-------------------------------
*/