package collective.sets;

import java.util.HashSet;

/* 
 *    ���� Set (��Ʈ)
 *    	(Ư�� Ÿ����) ��ҵ��� �ϳ��� ���� ���� ������� ��.
 *     ������ȣ(index) ���� ���� ����(���� ��ü�� �ǹ̸� �ο����� ����)
 *     �ڹٿ����� ��, ������ ��ҵ��� �ߺ��Ǵ� ���� ������� ����.
 *     ��� ��ҵ��� ���� ���۷��� �� '��ü'�� ������.
 *    	https://docs.oracle.com/javase/8/docs/api/java/util/Set.html
 */
public class SetMain3 {

	public static void main(String[] args) {
		System.out.println("================NO.1==================");
		// �ڹ� ���ʸ������� ���� ����� Ÿ���� ��ü ������(���۷�����)���� �����ؾ��� �⺻�� �ȵ� = ��� Ÿ���Ķ���� ����
		// �����ڸ����� �� ���ʸ��̸��� ���� ����
		HashSet<Character> hsA = new HashSet<>(); // char�� �ȵ�
		hsA.add('K');
		hsA.add('G');
		hsA.add('B');// auto boxing
		printCharSet(hsA, "�������� HS_A");

		
		System.out.println("================NO.2==================");
		HashSet<Character> hsB = new HashSet<Character>();
		System.out.println("[�� ���տ� ������ ���ڰ�ü ��Ҹ� 20�� ���� �Է��� �ֱ�]");
		fillRandomCharToSet(hsB, 20);
		printCharSet(hsB, "���� �������� HS_B");

		
		System.out.println("================NO.3==================");
		HashSet<Character> hsC = null;
		hsC = fillRandomCharToSetReturn(22);
		printCharSet(hsC, "�������� HS_C");

		
		System.out.println("================NO.4==================");
		HashSet<Character> intersection = new HashSet<Character>(); // ������
		// A�� B�� ������ (A��B)  �� ������ ��� ��ҵ��� ���� ���� ��� ��
//		<���>
//		for (Character cA : hsA) {
//			for (Character cB : hsB) {
//				if (cA == cB) { // �����տ� ���� ��Ұ� �߽߰� ��� ����!
//					intersection.add(cA);
//					break;
//				}
//			}
//		}
		for (Character c : hsA) {
			if(hsB.contains(c)) {
				intersection.add(c); // c�� hsB�� ���� �Ǿ��ִٸ�
			}
		}
		printCharSet(intersection, "A��B ���հ��� ������ ���� ���� ����");
	}
/*---------------------------------------------------------------------------------------*/
	private static HashSet<Character> fillRandomCharToSetReturn(int inputLumit) {
		HashSet<Character> hs = new HashSet<Character>();
		fillRandomCharToSet(hs, inputLumit);
		return hs;
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
