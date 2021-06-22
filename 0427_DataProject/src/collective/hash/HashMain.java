package collective.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
	https://ko.wikipedia.org/wiki/%ED%95%B4%EC%8B%9C_%ED%85%8C%EC%9D%B4%EB%B8%94
	https://ko.wikipedia.org/wiki/%ED%95%B4%EC%8B%9C_%ED%95%A8%EC%88%98
	�ؽ� ���̺�(��), �ؽ� �Լ�
	
	�ؽ�(Hash, ��Map, ����Dictionary)
	: ����(mapping) ���踦 ǥ���� �ڷᱸ���� ��ǥ��.	
 	�������:  key(hat �ܾ��̸�) => value(���ڶ� �濡 ����)
 	����:     key(����/�浵) => value(������ �� ��ġ)
 	�̸� => �繰,  �±� => ������,   Ű => �ڹ���
 	
 	key => value �������谡 �ؽ��� �⺻ ����. 
 	�������踦 �ڹٿ����� MapEntry��� ��. (Ű,���)�� ������ Pair�����.
 	pair���� ������ �ؽø��̶�� ��.
 	
 	����������, �ؽø��� ����ó�� ������ ����.. �׳� pair���� ������. 
 	
 	�ݵ�� Key�� '����'�ؾ���. (�ߺ� x), Key���� ���߿� ������ ������...
 	�ٸ�, Value�� �������� �ʾƵ� �Ǹ�(�ߺ� o), ������ null�� ��.
 	java.util.Map �������̽�, �̸� ������ java.util.HashMap
*/

public class HashMain {

	public static void main(String[] args) {
		/*---------------------------------------- [1��] ---------------------------------------*/
//		 Map<K, V> �������̽� ����
//		 = new HashMap<String, Integer>();
//		HashMap<String, Integer> hm
//				= new HashMap<>(); // �ؽø� size 0 ����
//		// �ؽø�: ��(pair)�� ���Ÿ���� ���� generic(Ÿ���Ķ���� ����)
//		// ŰŸ���� ���ڿ��� ����, ���Ÿ���� ������ ����.
//		// �л��̸� ���ڿ� Ű => ���� ���� ����
//		hm.put("����", 26); // size++
//		hm.put("����", 24);
//		hm.put("����", new Integer(28));
//		hm.put(""+123, 33);
//		hm.put(String.valueOf(123), 24);
//
//		System.out.println("** �ؽø��� ũ��(�л���): " + hm.size());
//		System.out.println("���徾�� ���� :   ����   =>  " + hm.get("����"));
//		// READ ����Ű�� �����ϴ� ������ ����
//		System.out.println("�������� ���� :   ����   =>  " + hm.get("����")+"��");
//		System.out.println("�������� ���� :   ����   =>  " + hm.get("����")+"��");
//		System.out.println("���־��� ���� :   ����   =>  " + hm.getOrDefault("����ORI", 23)+"��"); // �⺻���� �ɼ����� ����
		/*---------------------------------------- [2��] ---------------------------------------*/
		HashMap<String, Integer> hm = new HashMap<>();

		String[] keys = null;
		keys = new String[] { "����", "����", "����", "����", "����", "����", "����", "����", "����", "����" };
		// Values list ready
		ArrayList<Integer> values = new ArrayList<>();
		for (int i = 0; i < keys.length; i++) {
			Integer age = (int) (Math.random() * 100) + 1;
			values.add(age);
		}
		// mapping loop : 10���� �� Pair�� ��������� ��� �ؽ����� ��Ұ���
		// key �迭 -> valueslist�� Ű�� ������ ���� ��Ÿ������ ���� ����
		for (int i = 0; i < keys.length; i++) {
			hm.put(keys[i], values.get(i)); // �ʿ�ũ��, ���
		}
		// ���� Ű���� ������� Ű�� �߽����� ������ Ž���ϸ鼭 pair�� ���

		for (int i = 0; i < keys.length; i++) {
			String keey = keys[i];
			Integer valuee = hm.get(keey);
			System.out.println("Ű : " + keey + "�л� " + "->> ���� : " + hm.get(keys[i]) + "��");
		}
		System.out.println("----------------");
		for (int i = keys.length - 1; i >= 0; i--) {
			String keey = keys[i];
			Integer valuee = hm.get(keey);
			System.out.println("Ű : " + keey + "�л� " + "->> ���� : " + hm.get(keys[i]) + "��");
		}
		/*---------------------------------------- [3��] ---------------------------------------*/
		// ���� Ű���� �ѹ��� ������
//		hm.put("+����",24);
//		hm.put("+����",28);
		Set<String> keySet = hm.keySet();
		// �������̽� SetŸ������ �ؽ����� ��� Ű���� ��� �ϳ��� �������� ����
		// Set �������̽��� ������ ��ü�� ����
		// �������̽� ������ : �������̽��� ������ ��� Ŭ������ ������� �ش� �������̽��� ������ ������ �ִ�.
		// Ű ���� �����̶� ������ ������ ����
		System.out.println("----------------");
		System.out.println("�ؽø��� ũ��(�л���)" + hm.size());
		hm.remove("-����");
		hm.remove("-����");
		for (String key : keySet) {
			System.out.println("Ű : " + key + "�л� " + "->> ���� : " + hm.get(key) + "��");
		}
		/*---------------------------------------- [4��] ---------------------------------------*/
//		hm.clear();
//		// ���ü� ���� ����() ---------------------1��
//		for (String key : keySet) {
//			// ������ ������ ����
//			Integer oldValue = hm.remove(key);
//			System.out.println("-----------remove---------");
//			System.out.println("Ű : " + key + "�л� " + "->> ���� : " + oldValue + "��");
//			
//		}
//		// ���ü� ���� ����() ---------------------2��
//		for (String key : keySet) {
//			// �ʿ� �ش�Ű�� ���� �Ǿ����� Ȯ��
//			if(hm.containsKey(key) == true) {
//				Integer oldValue = hm.remove(key);
//				System.out.println("-----------remove---------");
//				System.out.println("Ű : " + key + "�л� " + "->> ���� : " + oldValue + "��");
//			}
//		}
//		// ���ü� ���� ����()���� �ڵ� ---------------------3��
		// keySet ������ �̿��׵� ���ͷ��̼� ����
		// iterator �������̽�: �ѹ��� �ϳ��� �ݺ������� ���� / � Ư���� �Ⱓ���� �ϳ��� ó����
		// ���ʸ��� ����

		// �������� ǥ���� iterator
		Iterator<String> it = keySet.iterator();
		// �ܹ��� iterator
		// it.hasNext(); -->> ���տ��� Ž���� ���� ��Ұ� �ִ��� ? T : F
		while (it.hasNext() == true) { // iterator �� false�� �ɶ����� = ���̻� ��Ұ� ������ ���� ���� ����
			// it.next(); -->> ��� �ϳ��� ����
			String key = it.next();
			if (hm.containsKey(key)) {
				System.out.println("Ű : " + key + "�л� " + "->> ���� : " + hm.get(key) + "��");
				it.remove(); //  iterator��ü�� ����
			}
		}
		printStydentAgeMap(hm);

	}

	private static void printStydentAgeMap(HashMap<String, Integer> hm) {
		if (hm == null) {
			System.out.println("���� null!!");
			return;
		}
		System.out.println("** �ؽø��� ũ��(�л���): " + hm.size());
		if (hm.isEmpty()) {
			System.out.println("�л��� ���׿�!!");
		} else {
			Set<String> keySet = hm.keySet();
			for (String key : keySet) {
				System.out.println(" Ű: " + key + " �л�" + " => ���: " + hm.get(key) + "��");
			}
		}
	}

}
