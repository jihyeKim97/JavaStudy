package collective.hash;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 * https://ko.wikipedia.org/wiki/%EB%A7%88%EB%B8%94_%EC%BD%94%EB%AF%B9%EC%8A%A4
	������ ��ȸ���� ������ ĳ���� Hero�� 
	
	ĸƾ �Ƹ޸�ī, �丣, �����̴���, ������,
	 ��Ÿ��ƽ ��, ��ũ, ���̾� ��, �� ǻ��, 
	 ���� ��Ʈ������, ȣũ����, ���̵�, �۴ϼ�, 
	 �����, Ÿ�뽺, �� �Ҽ�, ��Ʈ ���̴�, 
	 ��Ʈ��, �׷�Ʈ? ������� ���� ������ �� ���� �� �˷��� �ִ�. 
 */

// ����/DC ���� ĳ���͵� ��Ű�� 
class Hero {
	private String name; // �ݵ�� ������ �ʵ� (���� Ű)
	private int ability;
	private Date birthDay;

	public Hero() {
	}

	public Hero(String name) {
		this(name, (int) (Math.random() * 100) + 1, new Date());
	}

	public Hero(String name, int ability, Date birthDay) {
		super();
		this.name = name;
		this.ability = ability;
		this.birthDay = birthDay;
	}

	@Override
	public String toString() {
		return "Hero [name=" + name + ", ability=" + ability + ", birthDay=" + birthDay + "]";
	}

	public int getAbility() {
		return ability;
	}

	public void setAbility(int ability) {
		this.ability = ability;
	}

	public String getName() {
		return name;
	}

	public Date getBirthDay() {
		return birthDay;
	}

}

public class HashMain3 {

	public static void main(String[] args) {
//		�������� �� �̸����� �����Ͽ�(Ű) ���� �ؽø�
		HashMap<String, Hero> heroes = null;
//		Hero h1 = new Hero("ĸƾ �Ƹ޸�ī");
//		Hero h2 = new Hero("�丣");
//		Hero h3 = new Hero("�����̴���");
//		Hero h4 = new Hero("������");			
		heroes = new HashMap<String, Hero>();
//		heroes.put("ĸƾ �Ƹ޸�ī", h1);
//		heroes.put("�丣", h2);
//		heroes.put("�����̴���", h3);
//		heroes.put("������", h4);
		String[] names = { "ĸƾ �Ƹ޸�ī", "�丣", "�����̴���", "������" };
		for (String name : names) {
			heroes.put(name, new Hero(name));
		}
//		heroes.put("��ġ����", 123); // ���׸� ����!!

		// ������ ���
		Set<String> nameSet = heroes.keySet();
		for (String name : nameSet) {
			Hero hr = heroes.getOrDefault(name, new Hero());
			System.out.println(name + " ���� => " + hr);
		}

		// ���� �ʿ��� ������(value) ��� ���� ����Ʈ�� ����
		// ���� ���� �÷��� (����): �÷��� ��ü�� �����̳� ����Ʈ�� ������ ����
		Collection<Hero> heroValues = heroes.values();
		HashSet<Hero> heroSet = new HashSet<>(heroValues);
		ArrayList<Hero> heroList = new ArrayList<>(heroValues);
		
		for (int i = 0; i < heroList.size(); i++) {
			Hero h = heroList.get(i);
			System.out.println(h);
		}
	}

}
