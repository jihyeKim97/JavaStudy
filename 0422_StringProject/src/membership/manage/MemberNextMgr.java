package membership.manage;

import java.util.Scanner;

import membership.data.Member;

// 차세대 회원관리자 클래스 
public class MemberNextMgr extends MemberMgr {
	public MemberNextMgr() {
		//this.
		super();
	}

	public MemberNextMgr(int size) {
		super(size);
		//super();
//		this._members = new Member[size];
	}

	public MemberNextMgr(Member[] store) {
		super(store);
	}
	
	// 6. 등록된 회원들을 특정 조건/키워드로 검색할 수 있다.
	// 간략히 키워드 문자열로 회원의 이름,이메일,계정명에
	//  해당 키워드가 포함되는 부분일치 검색을 수행
	public void readySearch() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== 회원 검색 ===");
		String keyword = inputString(sc, ">> 검색 키워드: ");
		searchMembers(keyword);
	}
	
	public void searchMembers(String keyword) {
		if( keyword == null || keyword.isEmpty() ) return;
		for (Member member : _members) {
			if( member == null ) break;
			String name = member.getName();
			String email = member.getEmail();
			String id = member.getId();
			if( name == null || email == null 
					|| id == null ) {
				continue; //break;
			}
			
			//if( name.contains(keyword) )
			if( name.indexOf(keyword) != -1 
				|| email.indexOf(keyword) != -1
					|| id.indexOf(keyword) != -1 ) {
				System.out.println("\t FOUND:: " + member);
			} else
				System.out.println("...");
			
		}
	}
	
}





