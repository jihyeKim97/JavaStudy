package membership;

import java.util.Date;

import membership.data.Member;
import membership.manage.MemberMgr;

public class MemberMain2 {
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
		MemberMgr mgr = new MemberMgr(store);
		//if( mgr.isMembersEmpty() == false)
		if( !mgr.isMembersEmpty() )
			mgr.printAllMembers();
		else 
			System.out.println(" ���� ���ȸ���� �� �� ���׿�!");
		
		// ȸ�� ���� - ���� �� ������ �߰� ���
		mgr.processJoinMembers();
		
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
1, ����, 18, elsa@winter.com, 1500.0, elsa, 1234, Mon Apr 26 13:19:17 KST 2021, Mon Apr 26 13:19:17 KST 2021
2, �ȳ�, 18, anna@winter.com, 1000.0, anna, 1234, Mon Apr 26 13:19:17 KST 2021, Mon Apr 26 13:19:17 KST 2021
Member ���� 
Member ���� 
Member ���� 
Member ���� 
-------------------------------
>> ȸ�� �̸�: olaf
>> ȸ�� ����: 11
>> �̸��� �ּ�: olaf@w.com
>> ȸ�� ���̵�: olaf
>> ȸ�� ��ȣ: 1234
>> ȸ�� ������� [��: 2020-03-14]: 2020-03��30
�߸��� ���� ������� �Է�!!
~~~~~~~~~~~~~~~~~~~~~~~
	 olaf �� ������ ȯ���մϴ�!!
	 ���� ����:: 
3, olaf, 11, olaf@w.com, 1000.0, olaf, 1234, Mon Apr 26 13:19:52 KST 2021, Mon Apr 26 13:19:52 KST 2021
~~~~~~~~~~~~~~~~~~~~~~~
>> �߰� ȸ�� ����? (yes/no)y
>> ȸ�� �̸�: sben
>> ȸ�� ����: 22
>> �̸��� �ּ�: sben@ss.com
>> ȸ�� ���̵�: sben
>> ȸ�� ��ȣ: 1234
>> ȸ�� ������� [��: 2020-03-14]: 2022-03-22
~~~~~~~~~~~~~~~~~~~~~~~
	 sben �� ������ ȯ���մϴ�!!
	 ���� ����:: 
4, sben, 22, sben@ss.com, 1000.0, sben, 1234, Tue Mar 22 00:00:00 KST 2022, Mon Apr 26 13:20:49 KST 2021
~~~~~~~~~~~~~~~~~~~~~~~
>> �߰� ȸ�� ����? (yes/no)No
	 �ű�ȸ�� 2���� �߰���......
=== ȸ�� ����Ʈ === (4 / 6 ��)
��ȣ, �̸�, ����, �̸���, ���ϸ���, ������, ��ȣ, ����, ������
-------------------------------
1, ����, 18, elsa@winter.com, 1500.0, elsa, 1234, Mon Apr 26 13:19:17 KST 2021, Mon Apr 26 13:19:17 KST 2021
2, �ȳ�, 18, anna@winter.com, 1000.0, anna, 1234, Mon Apr 26 13:19:17 KST 2021, Mon Apr 26 13:19:17 KST 2021
3, olaf, 11, olaf@w.com, 1000.0, olaf, 1234, Mon Apr 26 13:19:52 KST 2021, Mon Apr 26 13:19:52 KST 2021
4, sben, 22, sben@ss.com, 1000.0, sben, 1234, Tue Mar 22 00:00:00 KST 2022, Mon Apr 26 13:20:49 KST 2021
Member ���� 
Member ���� 
-------------------------------
*/