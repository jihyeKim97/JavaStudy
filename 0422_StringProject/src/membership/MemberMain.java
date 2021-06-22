package membership;

import java.util.Date;

import membership.data.Member;
import membership.manage.MemberMgr;

public class MemberMain {
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
//			null	
			, null, null, null, null
		};
		MemberMgr mgr = new MemberMgr(store);
		//if( mgr.isMembersEmpty() == false)
		if( !mgr.isMembersEmpty() )
			mgr.printAllMembers();
		else 
			System.out.println(" ���� ���ȸ���� �� �� ���׿�!");
		
		// ȸ�� ���� - 1�� �߰� ���
		Member newMb = mgr.joinNewMember(null);
		if( newMb != null ) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("\t " +newMb.getName() +" �� ������ ȯ���մϴ�!!");
			System.out.println("\t ���� ����:: "); 
			System.out.println(newMb);// toString()
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
		}
		
		if( !mgr.isMembersEmpty() )
			mgr.printAllMembers();
		else 
			System.out.println(" ���� ���ȸ���� �� �� ���׿�!");
	
	}

}

/*
=== ȸ�� ����Ʈ === (2 / 6 ��)
��ȣ, �̸�, ����, �̸���, ���ϸ���, ������, ��ȣ, ����, ������
-------------------------------
1, ����, 18, elsa@winter.com, 1500.0, elsa, 1234, Mon Apr 26 11:49:24 KST 2021, Mon Apr 26 11:49:24 KST 2021
2, �ȳ�, 18, anna@winter.com, 1000.0, anna, 1234, Mon Apr 26 11:49:24 KST 2021, Mon Apr 26 11:49:24 KST 2021
Member ���� 
Member ���� 
Member ���� 
Member ���� 
-------------------------------
>> ȸ�� �̸�: ����
>> ȸ�� ����: 12
>> �̸��� �ּ�: sven@w.com
>> ȸ�� ���̵�: sven
>> ȸ�� ��ȣ: 1234
>> ȸ�� ������� [��: 2020-03-14]: 2002-07-08
~~~~~~~~~~~~~~~~~~~~~~~
	 ���� �� ������ ȯ���մϴ�!!
	 ���� ����:: 
3, ����, 12, sven@w.com, 1000.0, sven, 1234, Mon Jul 08 00:00:00 KST 2002, Mon Apr 26 11:49:44 KST 2021
~~~~~~~~~~~~~~~~~~~~~~~
=== ȸ�� ����Ʈ === (3 / 6 ��)
��ȣ, �̸�, ����, �̸���, ���ϸ���, ������, ��ȣ, ����, ������
-------------------------------
1, ����, 18, elsa@winter.com, 1500.0, elsa, 1234, Mon Apr 26 11:49:24 KST 2021, Mon Apr 26 11:49:24 KST 2021
2, �ȳ�, 18, anna@winter.com, 1000.0, anna, 1234, Mon Apr 26 11:49:24 KST 2021, Mon Apr 26 11:49:24 KST 2021
3, ����, 12, sven@w.com, 1000.0, sven, 1234, Mon Jul 08 00:00:00 KST 2002, Mon Apr 26 11:49:44 KST 2021
Member ���� 
Member ���� 
Member ���� 
-------------------------------
*/