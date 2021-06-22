package membership.manage;

import java.util.Scanner;

import membership.data.Member;

public class MemberNextChildMgr extends MemberNextMgr {
	
	private String kwHistory; // �˻��� Ű���� ����
	
	// �θ� Ŭ���� �޼ҵ� ������
	@Override
	public void readySearch() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== ȸ�� �˻� MemberNextChildMgr ===");
		String keyword = inputString(sc, ">> �˻� Ű����: ");
		this.kwHistory += keyword + " ";
		searchMembers(keyword);
	}

	// ���θ� Ŭ���� �޼ҵ� ������
	@Override
	public void printAllMembers() {
		System.out.println("=== ȸ�� ����Ʈ MemberNextChildMgr === (" 
				+ checkNumberOfMembers() +
				" / " + _members.length + " ��)");
		System.out.println(
		"��ȣ, �̸�, ����, �̸���, ���ϸ���, ������, ��ȣ, ����, ������");
		System.out.println("===============================");
		for (Member mb : _members) {
			System.out.println( mb == null ?
					"Member ���� " : mb.toString());
			System.out.println("-------------------------------");
		}
		System.out.println("===============================");
	}

	public MemberNextChildMgr() {
		super();
		kwHistory = "";
	}

	public MemberNextChildMgr(int size) {
		super(size);
		kwHistory = "";
	}

	public MemberNextChildMgr(Member[] store) {
		super(store);
		kwHistory = "";
	}
	
	
}
