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
public class SetMain3 {

	public static void main(String[] args) {
		System.out.println("================NO.1==================");
		// 자바 제너릭에서는 오직 요소의 타입을 객체 지향형(레퍼런스형)으로 제한해야함 기본형 안됨 = 요소 타입파라미터 제한
		// 생성자명에서의 긴 제너릭이름은 생략 가능
		HashSet<Character> hsA = new HashSet<>(); // char는 안됨
		hsA.add('K');
		hsA.add('G');
		hsA.add('B');// auto boxing
		printCharSet(hsA, "문자집합 HS_A");

		
		System.out.println("================NO.2==================");
		HashSet<Character> hsB = new HashSet<Character>();
		System.out.println("[빈 집합에 랜덤한 문자객체 요소를 20개 정도 입력해 넣기]");
		fillRandomCharToSet(hsB, 20);
		printCharSet(hsB, "랜덤 문자집합 HS_B");

		
		System.out.println("================NO.3==================");
		HashSet<Character> hsC = null;
		hsC = fillRandomCharToSetReturn(22);
		printCharSet(hsC, "문자집합 HS_C");

		
		System.out.println("================NO.4==================");
		HashSet<Character> intersection = new HashSet<Character>(); // 공집합
		// A와 B의 교집합 (A∩B)  두 집합의 모든 요소들을 서로 각각 모두 비교
//		<편법>
//		for (Character cA : hsA) {
//			for (Character cB : hsB) {
//				if (cA == cB) { // 교집합에 넣을 요소가 발견시 즉시 멈춰!
//					intersection.add(cA);
//					break;
//				}
//			}
//		}
		for (Character c : hsA) {
			if(hsB.contains(c)) {
				intersection.add(c); // c가 hsB에 포함 되어있다면
			}
		}
		printCharSet(intersection, "A∩B 집합간의 교집합 연산 실행 개수");
	}
/*---------------------------------------------------------------------------------------*/
	private static HashSet<Character> fillRandomCharToSetReturn(int inputLumit) {
		HashSet<Character> hs = new HashSet<Character>();
		fillRandomCharToSet(hs, inputLumit);
		return hs;
	}

	private static void fillRandomCharToSet(HashSet<Character> hs, int inputLumit) {
		if (hs == null) {
			hs = new HashSet<Character>(); // 명시적
		}
		final int limit = inputLumit > 0 ? inputLumit : 20;
		System.out.print("중복 알파벳 : ");
		for (int i = 0; i < limit; i++) { // 저장기준의 인덱스로 쓰여짐
			// 집합은 중복을 제거 하기에 20개가 대체로 들어가지 않는다
			boolean b = false;
			do {
				char c = (char) ((int) (Math.random() * 26) + 'A');
				// Character c1 = (char) ((int) (Math.random() * 26) + 'A'); // auto boxing
				b = hs.add(c);
				if (b == false) {
					System.out.print(c + " ");
				}
			} while (b == false);
		}
		System.out.println();
		System.out.println();
	}

	public static void printCharSet(HashSet<Character> hs, String title) {
		System.out.println(title + " : " + hs.size());
		for (Character ch : hs) {
			// 집합 내부에 다른 일렬의순서가 있지만 주소 위치의 순서 이지 입력한 값의 순서가 아니므로 쓸일이 없다
			// System.out.println(ch.charValue()); // 수동 언박싱(manual un boxing)
			System.out.print(ch + " "); // 자동 언박싱(auto un boxing)
		}
		System.out.println();
		System.out.println();

	}

}
