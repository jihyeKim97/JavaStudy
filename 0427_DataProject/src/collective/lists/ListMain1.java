package collective.lists;

import java.util.ArrayList;
/*
 * https://ko.wikipedia.org/wiki/%EB%A6%AC%EC%8A%A4%ED%8A%B8_(%EC%BB%B4%ED%93%A8%ED%8C%85)
// Data Structure �ڷ� ���� ( + �˰���)
// java �� ���� �����͵��� ȿ�������� ǥ���ϴ� ����..
// �������� collective data ��������..
// => �������� ����, �������� ����� ����, ����(���), ����,
//	  ����, ����/����, ����, �ߺ�, (�ð�?) 
// �迭?
// �ڹ��� 3�� �⺻ �÷�����
//    ���� Set, ����Ʈ List, �ؽ�(Hash ��/����)
//  JCF(�ڹ� �÷��� �����ӿ�ũ) => �ڹ� �������� �����͵��� 
//   ǥ�� �� ó���� �� �ִ� �������̽�, Ŭ�������� ������� ����. 
//   JFC�� �÷��� �ڷ����� ��� ��ҵ��� ���� ���۷��� �� '��ü'�� ������.
//					�⺻�� 123 x    new Integer(123) o 
 
 */

public class ListMain1 {

	public static void main(String[] args) {
		//�ߺ� ��� / ���� ��ȣ ����
		
		
		// List ���� ���̽�(�Ծ�) -> �ε��� ���� ��ȣ�� ����
		// ArrayList Ŭ����(List�������̽��� ��� ������ ����Ʈ Ŭ����)
		ArrayList list = new ArrayList(); // ���ʸ� ���� // �Ϲ� ����Ʈ ��ü(�������� �迭)

		// ����Ʈ�� �ǵڿ� ��ġ�� �������� ���� ��ȣ�� �ο� �Ͽ� ���������� �߰�
		/*  C(����)   */
		list.add(100);
		list.add(new Integer(100));
		list.add(123456789L);
		list.add(new Long(123456789L));
		list.add(3.141592f);
		list.add(new Float(3.141592f));
		list.add("java");
		list.add(new String("java"));
		list.add(3 == 2);
		list.add(new Boolean(3 == 2));
		list.add('A');
		list.add(new Character('A'));
		for (Object ob : list) {
			System.out.println(ob);
		}
		System.out.println("/************************/");
		// �迭�� �����ϼ� ����Ʈ�� ������ȣ�� 0 ~ size()-1 ���
		// Ŭ���� for�� ���� �ε��� ��� ���� Ž���� ������.
		
		list.add("����̴�");
		for (int i = 0; i < list.size(); i++) {
			/*  R(��ȸ)   */
			System.out.println(i +":"+list.get(i));
		}
	}

}
