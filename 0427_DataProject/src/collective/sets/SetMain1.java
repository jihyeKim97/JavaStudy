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
public class SetMain1 {

	public static void main(String[] args) {
		// �ߺ� �Ұ� / ���� ����
		
		// �Ϲ�����
		HashSet hs = new HashSet();
		// �����÷����� ��Ұ� 0��, size = 0
		// �÷���, �� ������ ������� ������(������).
		hs.add(123); // new Integer(123) ���� ��ü autoboxing
		hs.add(3.14f); // new Float(3.14f) �Ǽ� ��ü
		hs.add('A'); // new Character('A') ���� ��ü
		hs.add("xyz"); // new String("xyz")
		// hs.add(������Ʈ��)
		// ��� Ÿ���� ���(��ü)�� ���տ� add��?
		System.out.println("���� hs�� ũ�� = " + hs.size());
		//
		// ���(Element)Ÿ���� ������ Ư������
		// <E> ���Ÿ���� �����ϴ� ���׸�(Generic) - Ÿ���Ķ���� ����
		HashSet<String> hs2 = new HashSet<>();
//		hs2.add(���ڿ���)
		hs2.add("1234"); // x ���׸� Ÿ�� �Ķ���� ���ѹ޾�..����
		hs2.add(String.valueOf(3.141592)); // x
		hs2.add("" + '��'); // x
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
		System.out.println("���� hs�� ũ�� = " + hs2.size());
		System.out.println("++++++++++++++++++++++");
		hs2.add("php");
		hs2.add("typescript");
		hs2.add("swift");

		for (String string : hs2) {
			System.out.println(string);
		}
		System.out.println("���� hs2�� ũ�� = " + hs2.size());
		System.out.println("++++++++++++++++++++++");
		hs2.remove("1234");
		for (String string : hs2) {
			System.out.println(string);
		}
		System.out.println("���� hs2�� ũ�� = " + hs2.size());
		System.out.println("++++++++++++++++++++++");
		hs2.clear();
		for (String string : hs2) {
			System.out.println(string);
		}
		System.out.println("���� hs2�� ũ�� = " + hs2.size());
		System.out.println("++++++++++++++++++++++");
//		hs2.add("php");
//		hs2.add("typescript");
//		hs2.add("swift");
//		System.out.println("���� hs2�� ũ�� = " + hs2.size());
//		System.out.println("++++++++++++++++++++++");

		if(hs2.isEmpty()) {
			System.out.println("���պ���� ����");
		}else {
			for (String string : hs2) {
				System.out.println(string);
			}
		}
	}

}
