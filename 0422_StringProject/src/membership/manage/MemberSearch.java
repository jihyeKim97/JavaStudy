package membership.manage;

import membership.data.Member;

// �������̽�
/*
 * �߻����� ��ɰ� ����� �������� ����
 * 
 * "���Ѿ��ϴ� ��Ģ�̳� ����, ���, ���� ���� ������ ��"
 * �ϴ� �ڹ� 1.8 ��������  �������̽��� ����
 *  �߻�޼ҵ�� ����� ���� �־���..
 *  
 *   �߻�޼ҵ� abstract method
 *   : �Լ��� �ٵ� ����{}�� ���� �Լ��� �������� �ִ� ��� 
 */
public interface MemberSearch {
	public static final String DEF_MSG = "Ű���� �˻� ���!";
	// 6. ��ϵ� ȸ������ Ư�� ����/Ű����� �˻��� �� �ִ�.
	public abstract void readySearch(); 
	public abstract void searchMembers(String keyword); //{} 
	abstract public Member[] 
			searchMembersAndReturn(String keyword);
	
}
