package membership;

import java.util.Date;

import membership.data.Member;
import membership.manage.MemberMgr;
import membership.manage.MemberNextChildMgr;
import membership.manage.MemberNextMgr;
import membership.manage.MemberShoppingChildMgr;
import membership.manage.MemberShoppingMgr;

public class MemberMain4 {
	// ȸ�� (���� ���) Member 
	// ȸ�� ������ 	   MemberManager => MemberMgr	
	public static void main(String[] args) {
		// ȸ�� ������ (��Ű��)
		Member mb1 = new Member(
				"����", "elsa@winter.com",
				"elsa", "1234", new Date());
//		System.out.println(Member.order);
		mb1.setMileage(mb1.getMileage() + 500.0);
//		System.out.println(mb1);
		
		// ȸ�� ���� ��� (ȸ�� ��Ű�� �߰�����)
		Member[] store = {
			mb1, new Member("�ȳ�", "anna@winter.com",
					"anna", "1234", new Date())
			, null, null, null, null
		};
		
//		MemberNextChildMgr nMgr = new MemberNextChildMgr(store);
//		nMgr.processJoinMembers();
//		nMgr.printAllMembers();
//		nMgr.readySearch(); // next ���뿡�� �˻� ��������� Ȯ���..
//		
//		MemberShoppingMgr sMgr = new MemberShoppingMgr(3);
//		sMgr.processJoinMembers();
//		sMgr.marketingPromotion(); // shopping ���뿡�� �������� ����..
//		sMgr.printAllMembers();
//		sMgr.readySearch(); // ?
		
		//MemberShoppingChildMgr sMgr = new MemberShoppingChildMgr(3);
		MemberShoppingChildMgr sMgr = 
				new MemberShoppingChildMgr(store);
		sMgr.processJoinMembers();
		sMgr.marketingPromotion(); // shopping ���뿡�� �������� ����..
		sMgr.printAllMembers();
		
		Member[] result = sMgr
				.searchMembersAndReturn("el");
		System.out.println("** ���� ���ϵ� �˻����:: ");
		for (Member member : result) {
			if( member == null ) break;
			System.out.println(member);
		}
	}

}

/*
>> ȸ�� �̸�: olaf
>> ȸ�� ����: 22
>> �̸��� �ּ�: oalf@winter.com
>> ȸ�� ���̵�: anolaf
>> ȸ�� ��ȣ: 1234
>> ȸ�� ������� [��: 2020-03-14]: 2122-12-22
~~~~~~~~~~~~~~~~~~~~~~~
	 olaf �� ������ ȯ���մϴ�!!
	 ���� ����:: 
3, olaf, 22, oalf@winter.com, 1000.0, anolaf, 1234, Tue Dec 22 00:00:00 KST 2122, Mon Apr 26 14:26:11 KST 2021
~~~~~~~~~~~~~~~~~~~~~~~
>> �߰� ȸ�� ����? (yes/no)n
	 �ű�ȸ�� 1���� �߰���......
=== ȸ�� ����Ʈ MemberNextChildMgr === (3 / 6 ��)
��ȣ, �̸�, ����, �̸���, ���ϸ���, ������, ��ȣ, ����, ������
===============================
1, ����, 18, elsa@winter.com, 1500.0, elsa, 1234, Mon Apr 26 14:25:42 KST 2021, Mon Apr 26 14:25:42 KST 2021
-------------------------------
2, �ȳ�, 18, anna@winter.com, 1000.0, anna, 1234, Mon Apr 26 14:25:42 KST 2021, Mon Apr 26 14:25:42 KST 2021
-------------------------------
3, olaf, 22, oalf@winter.com, 1000.0, anolaf, 1234, Tue Dec 22 00:00:00 KST 2122, Mon Apr 26 14:26:11 KST 2021
-------------------------------
Member ���� 
-------------------------------
Member ���� 
-------------------------------
Member ���� 
-------------------------------
===============================
=== ȸ�� �˻� MemberNextChildMgr ===
>> �˻� Ű����: an
...
	 FOUND:: 2, �ȳ�, 18, anna@winter.com, 1000.0, anna, 1234, Mon Apr 26 14:25:42 KST 2021, Mon Apr 26 14:25:42 KST 2021
	 FOUND:: 3, olaf, 22, oalf@winter.com, 1000.0, anolaf, 1234, Tue Dec 22 00:00:00 KST 2122, Mon Apr 26 14:26:11 KST 2021





>> ȸ�� �̸�: ����
>> ȸ�� ����: 23
>> �̸��� �ּ�: elle@spring.com
>> ȸ�� ���̵�: elle
>> ȸ�� ��ȣ: 1234
>> ȸ�� ������� [��: 2020-03-14]: 2020-04-09
~~~~~~~~~~~~~~~~~~~~~~~
	 ���� �� ������ ȯ���մϴ�!!
	 ���� ����:: 
3, ����, 23, elle@spring.com, 1000.0, elle, 1234, Thu Apr 09 00:00:00 KST 2020, Mon Apr 26 15:24:44 KST 2021
~~~~~~~~~~~~~~~~~~~~~~~
>> �߰� ȸ�� ����? (yes/no)y
>> ȸ�� �̸�: ����
>> ȸ�� ����: 20
>> �̸��� �ּ�: jongel@java.com
>> ȸ�� ���̵�: jongel
>> ȸ�� ��ȣ: 1111
>> ȸ�� ������� [��: 2020-03-14]: 2002-09-02
~~~~~~~~~~~~~~~~~~~~~~~
	 ���� �� ������ ȯ���մϴ�!!
	 ���� ����:: 
4, ����, 20, jongel@java.com, 1000.0, jongel, 1111, Mon Sep 02 00:00:00 KST 2002, Mon Apr 26 15:25:41 KST 2021
~~~~~~~~~~~~~~~~~~~~~~~
>> �߰� ȸ�� ����? (yes/no)no
	 �ű�ȸ�� 2���� �߰���......
>> ������:: ��ǰ ���θ��!!!!
=== ȸ�� ����Ʈ === (4 / 6 ��)
��ȣ, �̸�, ����, �̸���, ���ϸ���, ������, ��ȣ, ����, ������
-------------------------------
1, ����, 18, elsa@winter.com, 1500.0, elsa, 1234, Mon Apr 26 15:23:54 KST 2021, Mon Apr 26 15:23:54 KST 2021
2, �ȳ�, 18, anna@winter.com, 1000.0, anna, 1234, Mon Apr 26 15:23:54 KST 2021, Mon Apr 26 15:23:54 KST 2021
3, ����, 23, elle@spring.com, 1000.0, elle, 1234, Thu Apr 09 00:00:00 KST 2020, Mon Apr 26 15:24:44 KST 2021
4, ����, 20, jongel@java.com, 1000.0, jongel, 1111, Mon Sep 02 00:00:00 KST 2002, Mon Apr 26 15:25:41 KST 2021
Member ���� 
Member ���� 
-------------------------------
	 FOUND:: ����
...
	 FOUND:: ����
	 FOUND:: ����
*** ���: el�� �˻��� ȸ���� 3�� �߰ߵ�!!
** ���� ���ϵ� �˻����:: 
1, ����, 18, elsa@winter.com, 1500.0, elsa, 1234, Mon Apr 26 15:23:54 KST 2021, Mon Apr 26 15:23:54 KST 2021
3, ����, 23, elle@spring.com, 1000.0, elle, 1234, Thu Apr 09 00:00:00 KST 2020, Mon Apr 26 15:24:44 KST 2021
4, ����, 20, jongel@java.com, 1000.0, jongel, 1111, Mon Sep 02 00:00:00 KST 2002, Mon Apr 26 15:25:41 KST 2021

*/