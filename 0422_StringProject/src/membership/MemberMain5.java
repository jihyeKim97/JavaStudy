package membership;

import java.util.Date;

import membership.data.Member;
import membership.manage.MemberMgr;
import membership.manage.MemberNextChildMgr;
import membership.manage.MemberNextMgr;
import membership.manage.MemberShoppingChildMgr;
import membership.manage.MemberShoppingMgr;
import membership.manage.MemberTotalMgr;

public class MemberMain5 {
	// 회원 (관리 대상) Member
	// 회원 관리자 MemberManager => MemberMgr
	public static void main(String[] args) {
		// 회원 데이터 (스키마)
		Member mb1 = new Member("엘사", "elsa@winter.com", "elsa", "1234", new Date());
//		System.out.println(Member.order);
		mb1.setMileage(mb1.getMileage() + 500.0);
//		System.out.println(mb1);

		// 회원 관리 운영자 (회원 스키마 중개관리)
		Member[] store = { mb1, new Member("안나", "anna@winter.com", "anna", "1234", new Date()), null, null, null,
				null };

//		MemberTotalMgr ttMgr = new MemberTotalMgr(store);
		// 추상클래스는 일반적으로 new를 통해 객체 생성이 안된다!!
//		ttMgr.processJoinMembers(); // 2대
//		ttMgr.marketingPromotion(); // 3대
//		ttMgr.readySearch(); // 4대의 인터페이스 메소드 재정의
//
//		// String login = ttMgr.iuputInteger(sc, msg)
//		if (ttMgr.loginProcess("hong", "123")) // 5대
//			System.out.println("hong 로그인 인증 성공!!");
//		else
//			System.out.println("hong 로그인 인증 실패!!");
	}

}
