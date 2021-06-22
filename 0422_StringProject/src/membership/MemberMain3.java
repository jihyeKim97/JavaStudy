package membership;

import java.util.Date;

import membership.data.Member;
import membership.manage.MemberMgr;
import membership.manage.MemberNextMgr;

public class MemberMain3 {
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
		
		MemberNextMgr nMgr = new MemberNextMgr(store);
		nMgr.processJoinMembers();
		nMgr.printAllMembers();
		
//		nMgr.searchMembers(keyword);
		nMgr.readySearch();
	
	}

}

/*
>> ȸ�� �̸�: �ö���
>> ȸ�� ����: 12
>> �̸��� �ּ�: olaf@summer.com
>> ȸ�� ���̵�: olaf
>> ȸ�� ��ȣ: 1234
>> ȸ�� ������� [��: 2020-03-14]: 2020-11-22
~~~~~~~~~~~~~~~~~~~~~~~
	 �ö��� �� ������ ȯ���մϴ�!!
	 ���� ����:: 
3, �ö���, 12, olaf@summer.com, 1000.0, olaf, 1234, Sun Nov 22 00:00:00 KST 2020, Mon Apr 26 14:07:13 KST 2021
~~~~~~~~~~~~~~~~~~~~~~~
>> �߰� ȸ�� ����? (yes/no)�ƴϿ�
>> ȸ�� �̸�: ����
>> ȸ�� ����: 11
>> �̸��� �ּ�: sben@summer.com
>> ȸ�� ���̵�: sben
>> ȸ�� ��ȣ: 1111
>> ȸ�� ������� [��: 2020-03-14]: 2202-12-23
~~~~~~~~~~~~~~~~~~~~~~~
	 ���� �� ������ ȯ���մϴ�!!
	 ���� ����:: 
4, ����, 11, sben@summer.com, 1000.0, sben, 1111, Thu Dec 23 00:00:00 KST 2202, Mon Apr 26 14:08:30 KST 2021
~~~~~~~~~~~~~~~~~~~~~~~
>> �߰� ȸ�� ����? (yes/no)no
	 �ű�ȸ�� 2���� �߰���......
=== ȸ�� ����Ʈ === (4 / 6 ��)
��ȣ, �̸�, ����, �̸���, ���ϸ���, ������, ��ȣ, ����, ������
-------------------------------
1, ����, 18, elsa@winter.com, 1500.0, elsa, 1234, Mon Apr 26 14:06:35 KST 2021, Mon Apr 26 14:06:35 KST 2021
2, �ȳ�, 18, anna@winter.com, 1000.0, anna, 1234, Mon Apr 26 14:06:35 KST 2021, Mon Apr 26 14:06:35 KST 2021
3, �ö���, 12, olaf@summer.com, 1000.0, olaf, 1234, Sun Nov 22 00:00:00 KST 2020, Mon Apr 26 14:07:13 KST 2021
4, ����, 11, sben@summer.com, 1000.0, sben, 1111, Thu Dec 23 00:00:00 KST 2202, Mon Apr 26 14:08:30 KST 2021
Member ���� 
Member ���� 
-------------------------------
=== ȸ�� �˻� ===
>> �˻� Ű����: summer
...
...
	 FOUND:: 3, �ö���, 12, olaf@summer.com, 1000.0, olaf, 1234, Sun Nov 22 00:00:00 KST 2020, Mon Apr 26 14:07:13 KST 2021
	 FOUND:: 4, ����, 11, sben@summer.com, 1000.0, sben, 1111, Thu Dec 23 00:00:00 KST 2202, Mon Apr 26 14:08:30 KST 2021

*/