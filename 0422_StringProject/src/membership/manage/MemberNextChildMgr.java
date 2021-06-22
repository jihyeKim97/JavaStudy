package membership.manage;

import java.util.Scanner;

import membership.data.Member;

public class MemberNextChildMgr extends MemberNextMgr {
	
	private String kwHistory; // 검색한 키워드 내역
	
	// 부모 클래스 메소드 재정의
	@Override
	public void readySearch() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== 회원 검색 MemberNextChildMgr ===");
		String keyword = inputString(sc, ">> 검색 키워드: ");
		this.kwHistory += keyword + " ";
		searchMembers(keyword);
	}

	// 조부모 클래스 메소드 재정의
	@Override
	public void printAllMembers() {
		System.out.println("=== 회원 리스트 MemberNextChildMgr === (" 
				+ checkNumberOfMembers() +
				" / " + _members.length + " 명)");
		System.out.println(
		"번호, 이름, 나이, 이메일, 마일리지, 계정명, 암호, 생일, 가입일");
		System.out.println("===============================");
		for (Member mb : _members) {
			System.out.println( mb == null ?
					"Member 없음 " : mb.toString());
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
