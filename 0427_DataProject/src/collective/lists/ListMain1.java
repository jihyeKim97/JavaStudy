package collective.lists;

import java.util.ArrayList;
/*
 * https://ko.wikipedia.org/wiki/%EB%A6%AC%EC%8A%A4%ED%8A%B8_(%EC%BB%B4%ED%93%A8%ED%8C%85)
// Data Structure 자료 구조 ( + 알고리즘)
// java 다 수의 데이터들을 효율적으로 표현하는 구조..
// 집합적인 collective data 데이터형..
// => 복합적인 구성, 가변적인 요소의 개수, 범위(경계), 계층,
//	  관계, 순서/정렬, 내포, 중복, (시간?) 
// 배열?
// 자바의 3대 기본 컬렉션형
//    집합 Set, 리스트 List, 해시(Hash 맵/사전)
//  JCF(자바 컬렉션 프레임워크) => 자바 집합적인 데이터들을 
//   표현 및 처리할 수 있는 인터페이스, 클래스들을 묶어놓은 도구. 
//   JFC의 컬렉션 자료형의 모든 요소들은 오직 레퍼런스 형 '객체'만 가능함.
//					기본형 123 x    new Integer(123) o 
 
 */

public class ListMain1 {

	public static void main(String[] args) {
		//중복 허용 / 순서 번호 있음
		
		
		// List 인터 페이스(규약) -> 인덱스 순서 번호가 존재
		// ArrayList 클래스(List인터페이스를 모두 구현한 리스트 클래스)
		ArrayList list = new ArrayList(); // 제너릭 생략 // 일반 리스트 객체(가변길이 배열)

		// 리스트의 맨뒤에 위치에 아이템을 순서 번호를 부여 하여 순차적으로 추가
		/*  C(생성)   */
		list.add(100);
		list.add(new Integer(100));
		list.add(123456789L);
		list.add(new Long(123456789L));
		list.add(3.141592f);
		list.add(new Float(3.141592f));
		list.add("java");
		list.add(new String("java"));
		list.add(3 == 2);
		list.add(new Boolean(3 == 2));
		list.add('A');
		list.add(new Character('A'));
		for (Object ob : list) {
			System.out.println(ob);
		}
		System.out.println("/************************/");
		// 배열과 동일하세 리스트는 순서번호를 0 ~ size()-1 사용
		// 클래식 for문 으로 인덱스 기반 루프 탐색이 가능함.
		
		list.add("목록이다");
		for (int i = 0; i < list.size(); i++) {
			/*  R(조회)   */
			System.out.println(i +":"+list.get(i));
		}
	}

}
