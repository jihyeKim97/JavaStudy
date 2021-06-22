package collective.sets;

import java.util.HashSet;

public class MySets {
	// ���հ� ���ջ����� ���� =====================

	// ������ setA �� setB ���� (�������� ����� setA�� �ݿ�)
	public static void unionSet(HashSet<Character> setA, HashSet<Character> setB) {
		if (setA == null || setB == null) {
			System.out.println("null ������ �� �Ұ���!");
			return;
		}

		if (setA.isEmpty()) {
			for (Character c : setB)
				setA.add(c); // ��� ����
			// setA = setB; // x
		} else if (setB.isEmpty()) {
			System.out.println("setA�� ������ ��� �ڱ��ڽ���.");
		} else { // �� �� �������� �ƴ�...
			for (Character c : setB) {
				setA.add(c); // �ߺ��� �ڵ� ���ŵ�...
				// ���� B���� �ְ� ���� A�� ���� ���ڵ鸸 ����A�� �߰���.
			}
		}
	}

	// ������ setA �� setB ���� (�������� ����� ���ο� �������� ����)
	public static HashSet<Character> unionSetReturn(HashSet<Character> setA, HashSet<Character> setB) {
		if (setA == null || setB == null) {
			System.out.println("null ������ �� �Ұ���!");
			return null;
		}
		HashSet<Character> union = new HashSet<>();
		for (Character c : setA)
			union.add(c); // ���� ����
		for (Character c : setB)
			union.add(c);
		// �ߺ��� �ڵ� ���ŵǸ� �ߺ����� �ʴ�
		// B������ ��Ҹ� ���� union�� add��
		return union;
	}

	// ������ setA �� setB ����
	public static HashSet<Character> intersectionSet(HashSet<Character> setA, HashSet<Character> setB) {
		if (setA == null || setB == null) {
			System.out.println("null ������ �� �Ұ���!");
			return null;
		}
		if (!setA.isEmpty() || setB.size() > 0) {
			HashSet<Character> intersection = new HashSet<>(); // empty set
			for (Character c : setA)
				if (setB.contains(c))
					intersection.add(c);
			return intersection;
		} else { // �� �� �ϳ� �̻��� ������
			return new HashSet<Character>(); // 0 ũ���� ������
		}
	}

	// ������ setA - setB = setA - (setA �� setB)
	public static HashSet<Character> differenceSet(HashSet<Character> setA, HashSet<Character> setB) {
		if (setA == null || setB == null) {
			System.out.println("null ������ �� �Ұ���!");
			return null;
		}
		if (!setA.isEmpty() || setB.size() > 0) {
			HashSet<Character> minusAB = new HashSet<>();
			for (Character c : setA)
				minusAB.add(c);
//			minusAB = setA; // ���� ������ ����Ŵ.. ���ÿ� ����.			
			HashSet<Character> interAB = intersectionSet(setA, setB);
			for (Character c : interAB) {
				minusAB.remove(c); // size--
			}
			return minusAB;
		} else {
			System.out.println("������....");
			return null;
		}
	}
}
