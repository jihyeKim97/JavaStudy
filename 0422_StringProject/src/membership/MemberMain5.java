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
	// ȸ�� (���� ���) Member
	// ȸ�� ������ MemberManager => MemberMgr
	public static void main(String[] args) {
		// ȸ�� ������ (��Ű��)
		Member mb1 = new Member("����", "elsa@winter.com", "elsa", "1234", new Date());
//		System.out.println(Member.order);
		mb1.setMileage(mb1.getMileage() + 500.0);
//		System.out.println(mb1);

		// ȸ�� ���� ��� (ȸ�� ��Ű�� �߰�����)
		Member[] store = { mb1, new Member("�ȳ�", "anna@winter.com", "anna", "1234", new Date()), null, null, null,
				null };

//		MemberTotalMgr ttMgr = new MemberTotalMgr(store);
		// �߻�Ŭ������ �Ϲ������� new�� ���� ��ü ������ �ȵȴ�!!
//		ttMgr.processJoinMembers(); // 2��
//		ttMgr.marketingPromotion(); // 3��
//		ttMgr.readySearch(); // 4���� �������̽� �޼ҵ� ������
//
//		// String login = ttMgr.iuputInteger(sc, msg)
//		if (ttMgr.loginProcess("hong", "123")) // 5��
//			System.out.println("hong �α��� ���� ����!!");
//		else
//			System.out.println("hong �α��� ���� ����!!");
	}

}
