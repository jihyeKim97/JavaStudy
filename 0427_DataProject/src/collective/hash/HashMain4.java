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
class NeoHero {

	public static final String DC_TEAM = "_DC_";
	public static final String MARVEL_TEAM = "_MARVEL_";

	private String name;
	private int ability;
	private Date birthDay;
	private String team;

	public NeoHero() {
	}

	public NeoHero(String name) {
		this(name, (int) (Math.random() * 100) + 1, new Date());
	}

	public NeoHero(String name, String team) {
		this(name, (int) (Math.random() * 100) + 1, new Date(), team);

	}

	public NeoHero(String name, int ability, Date birthDay) {
		this(name, ability, birthDay, DC_TEAM);
	}

	public NeoHero(String name, int ability, Date birthDay, String team) {
		super();
		this.name = name;
		this.ability = ability;
		this.birthDay = birthDay;
		this.team = team;
	}

	@Override
	public String toString() {
		return "NeoHero [name=" + name + ", �Ҽ��� - " + team + ", ability=" + ability + ", birthDay=" + birthDay + "]";
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

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

}

public class HashMain4 {

	public static void main(String[] args) {
//		�������� �� �̸����� �����Ͽ�(Ű) ���� �ؽø�
		HashMap<String, NeoHero> NeoHeroes = null;

		/* 1�� */
//		NeoHeroes = new HashMap<String, NeoHero>();
//		NeoHero h1 = new NeoHero("ĸƾ �Ƹ޸�ī");
//		NeoHero h2 = new NeoHero("�丣");
//		NeoHero h3 = new NeoHero("�����̴���");
//		NeoHero h4 = new NeoHero("������");			
//		NeoHeroes.put("ĸƾ �Ƹ޸�ī", h1);
//		NeoHeroes.put("�丣", h2);
//		NeoHeroes.put("�����̴���", h3);
//		NeoHeroes.put("������", h4);

		/* 2�� */
//		String[] names = { "ĸƾ �Ƹ޸�ī", "�丣", "�����̴���", "������" };
//		for (String name : names) {
//			NeoHeroes.put(name, new NeoHero(name));
//		}
//		NeoHeroes.put("��ġ����", 123); // ���׸� ����!!
//
//		// ������ ���
//		Set<String> nameSet = NeoHeroes.keySet();
//		for (String name : nameSet) {
//			NeoHero hr = NeoHeroes.getOrDefault(name, new NeoHero());
//			System.out.println(name + " ���� => " + hr);
//		}
//
//		// ���� �ʿ��� ������(value) ��� ���� ����Ʈ�� ����
//		// ���� ���� �÷��� (����): �÷��� ��ü�� �����̳� ����Ʈ�� ������ ����
//		Collection<NeoHero> NeoHeroValues = NeoHeroes.values();
//		HashSet<NeoHero> NeoHeroSet = new HashSet<>(NeoHeroValues);
//		ArrayList<NeoHero> NeoHeroList = new ArrayList<>(NeoHeroValues);
//
//		for (int i = 0; i < NeoHeroList.size(); i++) {
//			NeoHero h = NeoHeroList.get(i);
//			System.out.println(h);
//		}

		/* 3�� */
		final String[] DC_HEROES = { "DC_Super man", "DC_Bat man", "DC_Wonder Woman", "DC_Aquaman", "DC_Frankenstein" };
		final String[] MARVEL_HEROES = { "MARVEL_Captain America", "MARVEL_Thor", "MARVEL_Black panther",
				"MARVEL_Spiderman", "MARVEL_X-Men", "MARVEL_Groot", "MARVEL_Storm" };

		// 2���� �迭�� �迭�� �迭(��Ұ� 1�����迭�� �迭)
		final String[][] HERO2d = { DC_HEROES, MARVEL_HEROES };

		// ���� ������ �̸� ����Ʈ(�ݶ󺸷��̼�)
		ArrayList<String> nameList = new ArrayList<>();
		for (int i = 0; i < HERO2d.length; i++) { // 2
			for (int j = 0; j < HERO2d[i].length; j++) {
				nameList.add(HERO2d[i][j]);
			}
		}
		// ���ø� �ϱ�(�������� ���� ��ȯ)
		for (String str : nameList) {
			System.out.println(str);
		}
		System.out.println("----------------");

		shuffleHeroList(nameList);
		for (String str : nameList) {
			System.out.println(str);
		}
	}

	private static void shuffleHeroList(ArrayList<String> nameList) {
		final int SIZE = nameList.size();
		for (int i = 0; i < SIZE; i++) {
			int movePos = -1;
			// �ڱ� �ڽ��� ��ȣ�� �ƴϸ� �ڸ��� �ٲ�
			do {
				movePos = (int) (Math.random() * SIZE);
			} while (movePos == i);
			String iName =nameList.set(i, nameList.get(movePos));
			nameList.set(movePos, iName);
		}

	}
}
