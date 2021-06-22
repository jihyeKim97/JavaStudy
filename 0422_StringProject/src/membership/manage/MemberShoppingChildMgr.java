package membership.manage;

import membership.data.Member;

// 상속(관리자고유기능 + 마케팅 고유기능) + 검색기능을 동시에 구현??
//public class MemberShoppingChildMgr
//		extends MemberShoppingMgr {

public class MemberShoppingChildMgr 
	extends MemberShoppingMgr
	implements MemberSearch { 
//	implements MemberSearch, 회원정렬, 회원html출력  { 
	// 인터페이스의 모든 추상메소드들은 반드시 모두 구현을 완료(body를 가지게 정의)
	
	public MemberShoppingChildMgr() {
		//this.
		super();
	}

	public MemberShoppingChildMgr(int size) {
		super(size);
		//super();
//		this._members = new Member[size];
	}

	public MemberShoppingChildMgr(Member[] store) {
		super(store);
	}
	
//	@Override
//	public void readySearch() {
//		// TODO Auto-generated method stub
//	}
	@Override
	public void readySearch() {
		// TODO Auto-generated method stub
	}
	@Override
	public void searchMembers(String keyword) {
		// TODO Auto-generated method stub
	}
	@Override
	public Member[] searchMembersAndReturn(String keyword) {
		if( keyword == null || keyword.isEmpty() ) return null;		
		Member[] foundMbs = new Member[checkNumberOfMembers()];
		int countFound = 0;
		for (Member member : _members) {
			if( member == null ) break;
			String name = member.getName();
			String email = member.getEmail();
			String id = member.getId();
			if( name == null || email == null 
					|| id == null ) { 	continue; } //break;			
			if( name.indexOf(keyword) != -1 
				|| email.indexOf(keyword) != -1
					|| id.indexOf(keyword) != -1 ) {
				System.out.println("\t FOUND:: " + member.getName());
				foundMbs[countFound] = member;
				countFound++;				
			} else
				System.out.println("...");			
		}		
		System.out.println("*** 결과: " + keyword +"로 검색한 회원이 "+
				countFound +"명 발견됨!!");
		return foundMbs;
	}
	

}
