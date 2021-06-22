package membership;

import java.util.Date;
import java.util.Scanner;

import membership.data.Member;
import membership.manage.FinalMemberMgr;
import membership.manage.MemberLogin;
import membership.manage.MemberMgr;
import membership.manage.MemberNextChildMgr;
import membership.manage.MemberNextMgr;
import membership.manage.MemberShoppingChildMgr;
import membership.manage.MemberShoppingMgr;
import membership.manage.MemberTotalChildMgr;
import membership.manage.MemberTotalMgr;

public class MemberMain6 {
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
		
		FinalMemberMgr ttMgr = new FinalMemberMgr(store);
			// �߻�Ŭ������ �Ϲ������� new�� ���� ��ü ������ �ȵȴ�!!
		ttMgr.processJoinMembers(); // 2��
		ttMgr.printAllMembers();
		ttMgr.marketingPromotion(); // 3��
		ttMgr.readySearch(); // 4���� �������̽� �޼ҵ� ������
		int loginResult = ttMgr.readyLogin(new Scanner(System.in));
					// 5�밡 �������̽� �����Ϸ��ߴٰ� ������ �߻�޼ҵ�
					// 6�밡 ������ �޼ҵ�
					// 7�밡 readyLogin()���� ���Ǵ� �߻�޼ҵ� ������.
		
		switch(loginResult) {
			case MemberLogin.LOGIN_SUCCESS:
				System.out.println("�α��� ����!!");
				// �⼮��, ����.. �� �ʱ�ȭ
				System.out.println(">> ������������ �̵�!");
				break;
			case MemberLogin.LOGIN_ERR_ID_NULL:				
			case MemberLogin.LOGIN_ERR_PW_NULL:				
			case MemberLogin.LOGIN_ERR_ID_EMPTY:				
			case MemberLogin.LOGIN_ERR_PW_EMPTY:
				System.out.println(">> �α��� ����! �������̳� �н����尡 ����");
				break;	
			case MemberLogin.LOGIN_ERR_ID_NOT_FOUND:	
				System.out.println(">> �α��� ����! ���Ծȵ� ȸ��?");
				break;
			case MemberLogin.LOGIN_ERR_PW_MISMATCH:			
				System.out.println(">> �α��� ����! ��ȣ ����ġ!!_");
				break;
			default: 
				System.out.println("�α��� ����� ó�� �Ұ���!");
		} 
		
	}

}

/*
 * >> ȸ�� �̸�: �ȳ���
>> ȸ�� ����: 22
>> �̸��� �ּ�: annaf@winter.com
>> ȸ�� ���̵�: annaf
>> ȸ�� ��ȣ: 1234
>> ȸ�� ������� [��: 2020-03-14]: 2020-02-02
~~~~~~~~~~~~~~~~~~~~~~~
	 �ȳ��� �� ������ ȯ���մϴ�!!
	 ���� ����:: 
3, �ȳ���, 22, annaf@winter.com, 1000.0, annaf, 1234, Sun Feb 02 00:00:00 KST 2020, Tue Apr 27 11:45:13 KST 2021
~~~~~~~~~~~~~~~~~~~~~~~
>> �߰� ȸ�� ����? (yes/no)n
	 �ű�ȸ�� 1���� �߰���......
=== ȸ�� ����Ʈ === (3 / 6 ��)
��ȣ, �̸�, ����, �̸���, ���ϸ���, ������, ��ȣ, ����, ������
-------------------------------
1, ����, 18, elsa@winter.com, 1500.0, elsa, 1234, Tue Apr 27 11:44:36 KST 2021, Tue Apr 27 11:44:36 KST 2021
2, �ȳ�, 18, anna@winter.com, 1000.0, anna, 1234, Tue Apr 27 11:44:36 KST 2021, Tue Apr 27 11:44:36 KST 2021
3, �ȳ���, 22, annaf@winter.com, 1000.0, annaf, 1234, Sun Feb 02 00:00:00 KST 2020, Tue Apr 27 11:45:13 KST 2021
Member ���� 
Member ���� 
Member ���� 
-------------------------------
>> ������:: ��ǰ ���θ��!!!!
--- �α��� ó�� ---
>>�α���: annaf
>>�н�����: 1234
�α��� ����!!
>> ������������ �̵�!


>> ������:: ��ǰ ���θ��!!!!
--- �α��� ó�� ---
>>�α���: sben
>>�н�����: 1234
>> �α��� ����! ���Ծȵ� ȸ��?


>> ������:: ��ǰ ���θ��!!!!
--- �α��� ó�� ---
>>�α���: elsa
>>�н�����: 12300
>> �α��� ����! ��ȣ ����ġ!!_

*/

