package collective.sets;

import java.util.HashSet;

public class SetMain4 {

	public static void main(String[] args) {

		System.out.println("================NO.1==================");
		HashSet<Character> hsA = new HashSet<Character>();
		HashSet<Character> hsB = new HashSet<Character>();

		fillRandomCharToSet(hsA, 4);
		printCharSet(hsA, "���� �������� HS_A");
		fillRandomCharToSet(hsB, 14);
		printCharSet(hsB, "���� �������� HS_B");

		printCharSet(MySets.intersectionSet(hsA, hsB), "-------------������");
		printCharSet(MySets.unionSetReturn(hsA, hsB), "-------------������");
		printCharSet(MySets.differenceSet(hsA, hsB), "-------------������");
		printCharSet(MySets.differenceSet(hsB, hsA), "-------------������");
	}

	/*---------------------------------------------------------------------------------------*/
	// ���հ� ���� ������ ����
	// ������ setA �� setB ����
	public static HashSet<Character> intersectionSet(HashSet<Character> setA, HashSet<Character> setB) {
		if (setA == null || setB == null) {
			System.out.println("null ������ �� �Ұ���");
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
			// �����ϳ� �̻��� ������
			return new HashSet<Character>();// 0ũ���� ������
		}
	}

	private static void fillRandomCharToSet(HashSet<Character> hs, int inputLumit) {
		if (hs == null) {
			hs = new HashSet<Character>(); // �����
		}
		final int limit = inputLumit > 0 ? inputLumit : 20;
		System.out.print("�ߺ� ���ĺ� : ");
		for (int i = 0; i < limit; i++) { // ��������� �ε����� ������
			// ������ �ߺ��� ���� �ϱ⿡ 20���� ��ü�� ���� �ʴ´�
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
			// ���� ���ο� �ٸ� �Ϸ��Ǽ����� ������ �ּ� ��ġ�� ���� ���� �Է��� ���� ������ �ƴϹǷ� ������ ����
			// System.out.println(ch.charValue()); // ���� ��ڽ�(manual un boxing)
			System.out.print(ch + " "); // �ڵ� ��ڽ�(auto un boxing)
		}
		System.out.println();
		System.out.println();
	}
}
