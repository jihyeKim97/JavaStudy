package collective.sets;

import java.util.HashSet;

/* 
 *    집합 Set (세트)
 *    	(특정 타입의) 요소들을 하나의 범위 내에 묶어놓은 것.
 *     순서번호(index) 존재 하지 않음(순서 자체에 의미를 부여하지 않음)
 *     자바에서는 단, 집합이 요소들이 중복되는 것을 허용하지 않음.
 *     모든 요소들은 오직 레퍼런스 형 '객체'만 가능함.
 *    	https://docs.oracle.com/javase/8/docs/api/java/util/Set.html
 */
public class SetMain1 {

	public static void main(String[] args) {
		// 중복 불가 / 순서 없음
		
		// 일반집합
		HashSet hs = new HashSet();
		// 집합컬렉션의 요소가 0개, size = 0
		// 컬렉션, 즉 집합의 사이즈는 가변적(유동적).
		hs.add(123); // new Integer(123) 정수 객체 autoboxing
		hs.add(3.14f); // new Float(3.14f) 실수 객체
		hs.add('A'); // new Character('A') 문자 객체
		hs.add("xyz"); // new String("xyz")
		// hs.add(오브젝트형)
		// 어느 타입의 요소(객체)도 집합에 add됨?
		System.out.println("집합 hs의 크기 = " + hs.size());
		//
		// 요소(Element)타입을 제한한 특수집합
		// <E> 요소타입을 제한하는 제네릭(Generic) - 타입파라미터 제한
		HashSet<String> hs2 = new HashSet<>();
//		hs2.add(문자열형)
		hs2.add("1234"); // x 제네릭 타입 파라미터 제한받아..에러
		hs2.add(String.valueOf(3.141592)); // x
		hs2.add("" + '프'); // x
		hs2.add("java");
		hs2.add("python");
		hs2.add("ruby");
		hs2.add("javascript");
		hs2.add("go");
		hs2.add("swift");
		hs2.add("kotlin");

		for (String string : hs2) {
			System.out.println(string);
		}
		System.out.println("집합 hs의 크기 = " + hs2.size());
		System.out.println("++++++++++++++++++++++");
		hs2.add("php");
		hs2.add("typescript");
		hs2.add("swift");

		for (String string : hs2) {
			System.out.println(string);
		}
		System.out.println("집합 hs2의 크기 = " + hs2.size());
		System.out.println("++++++++++++++++++++++");
		hs2.remove("1234");
		for (String string : hs2) {
			System.out.println(string);
		}
		System.out.println("집합 hs2의 크기 = " + hs2.size());
		System.out.println("++++++++++++++++++++++");
		hs2.clear();
		for (String string : hs2) {
			System.out.println(string);
		}
		System.out.println("집합 hs2의 크기 = " + hs2.size());
		System.out.println("++++++++++++++++++++++");
//		hs2.add("php");
//		hs2.add("typescript");
//		hs2.add("swift");
//		System.out.println("집합 hs2의 크기 = " + hs2.size());
//		System.out.println("++++++++++++++++++++++");

		if(hs2.isEmpty()) {
			System.out.println("집합비워져 있음");
		}else {
			for (String string : hs2) {
				System.out.println(string);
			}
		}
	}

}
