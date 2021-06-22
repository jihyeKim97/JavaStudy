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
public class SetMain2 {
	// ���ڿ� ������ �Է¹޾� �� ����, �� ��ҵ��� ����ϴ� �Լ�
	public static void printSet(HashSet<String> hs) {
		if (hs == null) {
			System.out.println("���� null");
			return;
		}
		System.out.println("���� hs�� ũ�� = " + hs.size());
		if (hs.isEmpty()) {
			System.out.println("������");
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
