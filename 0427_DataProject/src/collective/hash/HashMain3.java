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
class Hero {
	private String name; // 반드시 고유한 필드 (기준 키)
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
//		영웅들을 그 이름으로 구분하여(키) 묶은 해시맵
		HashMap<String, Hero> heroes = null;
//		Hero h1 = new Hero("캡틴 아메리카");
//		Hero h2 = new Hero("토르");
//		Hero h3 = new Hero("스파이더맨");
//		Hero h4 = new Hero("엑스맨");			
		heroes = new HashMap<String, Hero>();
//		heroes.put("캡틴 아메리카", h1);
//		heroes.put("토르", h2);
//		heroes.put("스파이더맨", h3);
//		heroes.put("엑스맨", h4);
		String[] names = { "캡틴 아메리카", "토르", "스파이더맨", "엑스맨" };
		for (String name : names) {
			heroes.put(name, new Hero(name));
		}
//		heroes.put("유치원생", 123); // 제네릭 에러!!

		// 영웅맵 출력
		Set<String> nameSet = heroes.keySet();
		for (String name : nameSet) {
			Hero hr = heroes.getOrDefault(name, new Hero());
			System.out.println(name + " 영웅 => " + hr);
		}

		// 영웅 맵에서 영웅들(value) 묶어서 영웅 리스트에 저장
		// 영웅 벨류 컬렉션 (모음): 컬렉션 객체는 집합이나 리스트로 변경이 용이
		Collection<Hero> heroValues = heroes.values();
		HashSet<Hero> heroSet = new HashSet<>(heroValues);
		ArrayList<Hero> heroList = new ArrayList<>(heroValues);
		
		for (int i = 0; i < heroList.size(); i++) {
			Hero h = heroList.get(i);
			System.out.println(h);
		}
	}

}
