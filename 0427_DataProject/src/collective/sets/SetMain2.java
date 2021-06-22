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
public class SetMain2 {
	// 문자열 집합을 입력받아 그 내용, 즉 요소들을 출력하는 함수
	public static void printSet(HashSet<String> hs) {
		if (hs == null) {
			System.out.println("집합 null");
			return;
		}
		System.out.println("집합 hs의 크기 = " + hs.size());
		if (hs.isEmpty()) {
			System.out.println("빈집합");
		} else {
			for (String string : hs) {
				System.out.println(string);
			}
		}
		System.out.println("++++++++++++++++++++++");
	}

	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<>();
		hs.add("php");
		hs.add("db");
		hs.add("sc");
		hs.add("lib");
		hs.add("java");
		SetMain2.printSet(hs);
	}

}
