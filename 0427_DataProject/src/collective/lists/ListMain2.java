package collective.lists;

import java.util.ArrayList;

/* 
 	����Ʈ LIST (���) => �迭�� ����Ʈ�� ���� �� ����
 	java.util.List �������̽� 
 	> ����� �ߺ��� ����. 
 	> ��ҵ��� �߰��� ����(��ȣ; �ε���) ����
 	> ������ȣ(index) 0 ~ size()-1 ����
 	// ����Ʈ �������̽��� ���� �� ������ ����ü Ŭ���� ArrayList
 	 * 
 	 * ArrayList ������ ������ ����ҷν��� CRUD �������� ����.
 	 *  CRUD(Create, Read/Retrieve, Update, Delete)
 	 *   add()/insert?,  get(),   set(),   remove()
 	
 	
*/
public class ListMain2 {

	public static void main(String[] args) {
		// ���׸� generic: Ÿ�� �Ķ���� ����
//		ArrayList<Object> nameList
//					= new ArrayList<Object>();
//		ArrayList nameList = new ArrayList(); // �Ϲݸ���Ʈ
		ArrayList<String> nameList
		// = new ArrayList<String>();
				= new ArrayList<>();
		// ����Ʈ �÷����� ���Ÿ���� ��� ���ڿ��� ���ѽ�Ŵ.
		nameList.add("���");
//		nameList.add(22); // x
//		nameList.add(""+22); // o "22"
//		nameList.add(String.valueOf(22)); // o "22" 
		// <=> Integer.parseInt("22")
		nameList.add("����"); // add() ����Ʈ�� �� �ڿ� ���ο� ��Ҹ� �߰�
		nameList.add("����");
		nameList.add("����"); // Create

		printNameList(nameList);

		System.out.println("** �л��̸� ����Ʈ(������Reverse): " + nameList.size() + "��");
		final int CNT_NAMES = nameList.size();
		for (int i = CNT_NAMES - 1; i >= 0; i--) {
			System.out.printf("\t �л�: %03d�� => %s \n", i, nameList.get(i)); // Read
		}
		System.out.println("----------------------------");

		nameList.add("����"); // ? �ǵ�(��ġ)�� �߰�
		nameList.add(2, "����"); // 2����ġ�� ���Ӱ� ������ �߰�
		printNameList(nameList);

		nameList.add(0, "����"); // ����Ʈ�� �� ��(��ġ)�� �߰�
		printNameList(nameList);

		nameList.add(0, "����"); // ����Ʈ�� �� ��(��ġ)�� �߰�
		nameList.add("����"); // ����Ʈ�� �� ��(��ġ)�� �߰�
		nameList.add(nameList.size(), "����"); // ����Ʈ�� �� ��(��ġ)�� �߰�
		printNameList(nameList);

		// update
		// ������ �ִ� ���� ���� �ϴ� set
		nameList.set(9, "���� ori");
		printNameList(nameList);
//		String oldEntitle = nameList.get(9);// ���
		String oldEntitle = nameList.set(9, "�����̴�");// ���
		nameList.set(8, "���� �Ҽ���");
		printNameList(nameList);

		// delete
		nameList.add(oldEntitle);
		nameList.remove(2);
		// ���� ��ġ �������� ���� ��� ���� ��� 1��ġ�� ������ �����
		printNameList(nameList);

		for (String name : nameList) {
			System.out.println(">>>> - " + name);
		}
	}

	private static void printNameList(ArrayList<String> nameList) {
		System.out.println("** �л��̸� ����Ʈ(������Forward): " + nameList.size() + "��");
		for (int i = 0; i < nameList.size(); i++) {
			System.out.printf("\t �л�: %03d�� => %s \n", i, nameList.get(i)); // Read
		}
		System.out.println("----------------------------");

	}
}
