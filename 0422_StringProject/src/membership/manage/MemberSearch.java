package membership.manage;

import membership.data.Member;

// 인터페이스
/*
 * 추상적인 기능과 상수의 집합적인 단위
 * 
 * "지켜야하는 규칙이나 합의, 계약, 법률 등을 정의한 것"
 * 일단 자바 1.8 전까지는  인터페이스는 오직
 *  추상메소드와 상수만 가질 있었음..
 *  
 *   추상메소드 abstract method
 *   : 함수의 바디 정의{}가 없이 함수의 원형선언만 있는 경우 
 */
public interface MemberSearch {
	public static final String DEF_MSG = "키워드 검색 기능!";
	// 6. 등록된 회원들을 특정 조건/키워드로 검색할 수 있다.
	public abstract void readySearch(); 
	public abstract void searchMembers(String keyword); //{} 
	abstract public Member[] 
			searchMembersAndReturn(String keyword);
	
}
