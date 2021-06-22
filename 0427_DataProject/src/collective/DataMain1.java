package collective;

import java.util.HashSet;
import java.util.Set;

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

/* 
 *    집합 Set (세트)
 *    	(특정 타입의) 요소들을 하나의 범위 내에 묶어놓은 것.
 *     순서번호(index) 존재 하지 않음(순서 자체에 의미를 부여하지 않음)
 *     자바에서는 단, 집합이 요소들이 중복되는 것을 허용하지 않음.
 *     모든 요소들은 오직 레퍼런스 형 '객체'만 가능함.
 *    	https://docs.oracle.com/javase/8/docs/api/java/util/Set.html
 */

public class DataMain1 {

	public static void main(String[] args) {
		//Set set1 = new Set()???  // Set 인터페이스
		HashSet hs = new HashSet();    // Set 인터페이스를 구현한 구체화 클래스형

		System.out.println("요소 개수: " + hs.size()); 
								// 현재시점의 요소의 총개수
		hs.add(new 
		Integer(1999)); // 수치형 객체 요소
		hs.add(1982); // auto-boxing 
		hs.add(2002);
		hs.add(2021);
		hs.add(2022);
		hs.add(2030);
		hs.add(2040);
		hs.add(2019);
		System.out.println("년도 집합의 요소 개수: " + hs.size()); 
		
//		for (int i = 0; i < args.length; i++) {
		// 집합에는 순서번호 없네.. 루프를 돌 수 없다.
		for (Object year : hs) {
			System.out.println("* 년도 :" + year);
		}	
		
		hs.add(3000);
		System.out.println("년도 집합의 요소 개수: " + hs.size());
		for (Object year : hs) {
			//Integer y = (Integer) year;
			//System.out.println("* 년도 :" + y.intValue());			
			int y = (int)year;
			System.out.println("* 년도 :" + y );
		}
				
	}

}
