package collective.hash;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 * https://ko.wikipedia.org/wiki/%EB%A7%88%EB%B8%94_%EC%BD%94%EB%AF%B9%EC%8A%A4
	마블은 자회사의 유명한 캐릭터 Hero인 
	
	캡틴 아메리카, 토르, 스파이더맨, 엑스맨,
	 판타스틱 포, 헐크, 아이언 맨, 닉 퓨리, 
	 닥터 스트레인지, 호크아이, 블레이드, 퍼니셔, 
	 데어데블, 타노스, 블랙 팬서, 고스트 라이더, 
	 앤트맨, 그루트? 가디언즈 오브 갤럭시 등 으로 잘 알려져 있다. 
 */

// 마블/DC 영웅 캐릭터들 스키마 
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
		return "NeoHero [name=" + name + ", 소속팀 - " + team + ", ability=" + ability + ", birthDay=" + birthDay + "]";
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
//		영웅들을 그 이름으로 구분하여(키) 묶은 해시맵
		HashMap<String, NeoHero> NeoHeroes = null;

		/* 1번 */
//		NeoHeroes = new HashMap<String, NeoHero>();
//		NeoHero h1 = new NeoHero("캡틴 아메리카");
//		NeoHero h2 = new NeoHero("토르");
//		NeoHero h3 = new NeoHero("스파이더맨");
//		NeoHero h4 = new NeoHero("엑스맨");			
//		NeoHeroes.put("캡틴 아메리카", h1);
//		NeoHeroes.put("토르", h2);
//		NeoHeroes.put("스파이더맨", h3);
//		NeoHeroes.put("엑스맨", h4);

		/* 2번 */
//		String[] names = { "캡틴 아메리카", "토르", "스파이더맨", "엑스맨" };
//		for (String name : names) {
//			NeoHeroes.put(name, new NeoHero(name));
//		}
//		NeoHeroes.put("유치원생", 123); // 제네릭 에러!!
//
//		// 영웅맵 출력
//		Set<String> nameSet = NeoHeroes.keySet();
//		for (String name : nameSet) {
//			NeoHero hr = NeoHeroes.getOrDefault(name, new NeoHero());
//			System.out.println(name + " 영웅 => " + hr);
//		}
//
//		// 영웅 맵에서 영웅들(value) 묶어서 영웅 리스트에 저장
//		// 영웅 벨류 컬렉션 (모음): 컬렉션 객체는 집합이나 리스트로 변경이 용이
//		Collection<NeoHero> NeoHeroValues = NeoHeroes.values();
//		HashSet<NeoHero> NeoHeroSet = new HashSet<>(NeoHeroValues);
//		ArrayList<NeoHero> NeoHeroList = new ArrayList<>(NeoHeroValues);
//
//		for (int i = 0; i < NeoHeroList.size(); i++) {
//			NeoHero h = NeoHeroList.get(i);
//			System.out.println(h);
//		}

		/* 3번 */
		final String[] DC_HEROES = { "DC_Super man", "DC_Bat man", "DC_Wonder Woman", "DC_Aquaman", "DC_Frankenstein" };
		final String[] MARVEL_HEROES = { "MARVEL_Captain America", "MARVEL_Thor", "MARVEL_Black panther",
				"MARVEL_Spiderman", "MARVEL_X-Men", "MARVEL_Groot", "MARVEL_Storm" };

		// 2차원 배열은 배열의 배열(요소가 1차원배열인 배열)
		final String[][] HERO2d = { DC_HEROES, MARVEL_HEROES };

		// 통합 영웅들 이름 리스트(콜라보레이션)
		ArrayList<String> nameList = new ArrayList<>();
		for (int i = 0; i < HERO2d.length; i++) { // 2
			for (int j = 0; j < HERO2d[i].length; j++) {
				nameList.add(HERO2d[i][j]);
			}
		}
		// 셔플링 하기(랜덤으로 순서 변환)
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
			// 자기 자신의 번호가 아니면 자리를 바꿈
			do {
				movePos = (int) (Math.random() * SIZE);
			} while (movePos == i);
			String iName =nameList.set(i, nameList.get(movePos));
			nameList.set(movePos, iName);
		}

	}
}
