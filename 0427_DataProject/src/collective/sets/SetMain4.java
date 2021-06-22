package collective.sets;

import java.util.HashSet;

public class SetMain4 {

	public static void main(String[] args) {

		System.out.println("================NO.1==================");
		HashSet<Character> hsA = new HashSet<Character>();
		HashSet<Character> hsB = new HashSet<Character>();

		fillRandomCharToSet(hsA, 4);
		printCharSet(hsA, "랜덤 문자집합 HS_A");
		fillRandomCharToSet(hsB, 14);
		printCharSet(hsB, "랜덤 문자집합 HS_B");

		printCharSet(MySets.intersectionSet(hsA, hsB), "-------------교집합");
		printCharSet(MySets.unionSetReturn(hsA, hsB), "-------------합집합");
		printCharSet(MySets.differenceSet(hsA, hsB), "-------------차집합");
		printCharSet(MySets.differenceSet(hsB, hsA), "-------------차집합");
	}

	/*---------------------------------------------------------------------------------------*/
	// 집합과 집합 사이의 연산
	// 교집합 setA ∩ setB 연산
	public static HashSet<Character> intersectionSet(HashSet<Character> setA, HashSet<Character> setB) {
		if (setA == null || setB == null) {
			System.out.println("null 집합은 비교 불가능");
			return null;
		}
		if (!setA.isEmpty() || setB.size() > 0) {
			HashSet<Character> intersection = new HashSet<>();
			for (Character c : setA) {
				if (setB.contains(c)) {
					intersection.add(c);
				}
			}
			return intersection;
		} else {
			// 둘중하나 이상이 공집합
			return new HashSet<Character>();// 0크기의 공집합
		}
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
