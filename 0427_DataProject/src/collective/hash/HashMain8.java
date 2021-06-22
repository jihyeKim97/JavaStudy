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

// 마블/DC 영웅 캐릭터들 스키마 II 
class NeoHero2 {
	public static final String DC_TEAM = "_DC_";
	public static final String MARVEL_TEAM = "_Marvel_";
	
	private String name; // 반드시 고유한 필드 (기준 키)
	private int ability;
	private Date birthDay;
	private String team; // 스키마 필드 추가
	
	public NeoHero2() {}
	public NeoHero2(String name) {
		this(name, (int)(Math.random()*100)+1,
				new Date());
	}
	public NeoHero2(String name, String team) {
		this(name, (int)(Math.random()*100)+1, 
				new Date(), team);
	}
	public NeoHero2(String name, int ability, Date birthDay) {
		this(name, ability, birthDay, DC_TEAM);
	}
	
	public NeoHero2(String name, int ability, Date birthDay, String team) {
		super();
		this.name = name;
		this.ability = ability;
		this.birthDay = birthDay;
		this.team = team;
	}
	@Override
	public String toString() {
		return "Hero [name=" + name 
				+ ", 소속팀=" + team 
				+ ", ability=" + ability + ", birthDay=" + birthDay + "]";
	}
	
	
	
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
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

public class HashMain8 {

	public static void main(String[] args) {
		// 영웅들을 그 이름으로 구분하여(키) 묶은 해시맵
		// https://namu.wiki/w/%EB%A7%88%EB%B8%94%20%EC%BD%94%EB%AF%B9%EC%8A%A4/%EC%BA%90%EB%A6%AD%ED%84%B0
		// https://namu.wiki/w/DC%20%EC%BD%94%EB%AF%B9%EC%8A%A4/%EC%BA%90%EB%A6%AD%ED%84%B0%EC%99%80%20%ED%8C%80

//		HashMap<String, NeoHero2> heroes = null;
		
		final String[] DC_HEROES = {  // 5
			"DC슈퍼맨", "DC원더우먼", "DC배트맨", "DC아쿠아맨", "DC프랑켄스타인" 	
		};
		final String[] MARVEL_HEROES = { // 7
			"MV캡틴 아메리카", "MV토르", "MV스파이더맨", "MV엑스맨,",
			"MV블랙 팬서", "MV그루트", "MV스톰"
		};
		// 2차원 배열 = 배열의 배열, (요소가 1차원배열인 배열)
		final String[][] HERO2d = { DC_HEROES, MARVEL_HEROES };
		
		// 통합 영웅들 이름 리스트 (DC + Marvel) 콜라보
		ArrayList<String> nameList = new ArrayList<String>();
		for (int i = 0; i < HERO2d.length; i++) { // 2
			for (int j = 0; j < HERO2d[i].length; j++) {
				nameList.add(HERO2d[i][j]); // 원본 순서 유지
			}
		}
		
		// 통합 영웅들 이름리스트 출력		
		for (String name : nameList) {
			System.out.println(name);
		}
		System.out.println("--------------------");
		
		// 셔플링 하기 (랜덤으로 순서 변환하기)
		for (int i = 0; i < 10; i++) {
			shuffleHeroList(nameList);
		}		
				
		for (String name : nameList) {
			System.out.println(name);
		}
		System.out.println("--------------------");
		
		// 영웅들의 이름이 가변리스트에 램던 순서로 준비.
		// 이 순서의 리스트를 탐색하면서 영웅객체(NeoHero2) 생성하여
		// 영웅리스트에 저장
		ArrayList<NeoHero2> heroList = new ArrayList<>();
		for (String name : nameList) {
			String team = name.startsWith("DC") ?
					NeoHero2.DC_TEAM : NeoHero2.MARVEL_TEAM;
			NeoHero2 hero = new NeoHero2(name, team);
			heroList.add(hero);
		}
		HashMap<String, NeoHero2> heroes = new HashMap<>();
		// 이름 리스트와 영웅 리스트를 하나로 묶어서 맵으로 표현.
		for (NeoHero2 hero : heroList) {
			heroes.put(hero.getName(), hero);
		}
		
		for (String name : nameList) {
			System.out.println(name + " hero => "
					+ heroes.get(name).getTeam() );
		}
		System.out.println("---------------------");
		
		
		// 팀별 영웅리스트를 요소로하는 영웅팀맵 만들기
		// 키: 팀이름문자열   =>  밸류: 영웅리스트
		HashMap<String, ArrayList<NeoHero2>>
					teamMap = new HashMap<>();
		teamMap.put(NeoHero2.DC_TEAM, 
				new ArrayList<NeoHero2>()); // 팀원 0명 리스트 생성 
		teamMap.put(NeoHero2.MARVEL_TEAM, 
				new ArrayList<NeoHero2>()); 
		teamMap.put("재욱팀", new ArrayList<NeoHero2>());
		
		//
		heroList.add(new NeoHero2("재욱", "재욱팀"));
		heroList.add(new NeoHero2("규진", "재욱팀"));
		heroList.add(new NeoHero2("종세", "재욱팀"));
		heroList.add(new NeoHero2("동현", "재욱팀"));
		//
		for (int i = 0; i < heroList.size(); i++) {
			NeoHero2 hero = heroList.get(i);
			// i번째 영웅 객체의 소속팀을 확인 
			if (hero.getTeam().equals(NeoHero2.DC_TEAM)) {
				ArrayList<NeoHero2> dcTeam = // 요소 리스트
					teamMap.get(NeoHero2.DC_TEAM);
				dcTeam.add(hero);
			} else if(hero.getTeam().equals(NeoHero2.MARVEL_TEAM)) {
				teamMap.get(NeoHero2.MARVEL_TEAM).add(hero);
			} else if(hero.getTeam().equals("재욱팀")) {
				teamMap.get("재욱팀").add(hero);
			} else {
				System.out.println(hero + "는 소속팀이 없음!");
			}
		}
		System.out.println("----------------");
		System.out.println("영웅팀의 개수 : " + teamMap.size() +"팀");
		Set<String> teamNameSet = teamMap.keySet();
		// 집합 기반 팀이름 루프
		
	}

	// 셔플링 함수 호출 수 오를 수록 랜덤성 up!
	private static void shuffleHeroList(
			ArrayList<String> nameList) {
		final int SIZE = nameList.size();
		for (int i = 0; i < SIZE; i++) {
			int movePos = -1;
			do {
				movePos = (int)(Math.random()*SIZE);
			} while( movePos == i );
			String iName = nameList
				.set(i, nameList.get(movePos));
			nameList.set(movePos, iName); // 위치 맞바꿈..
//			String iName = nameList.get(i);
//			String mName = nameList.get(movePos);
//			nameList.set(i, mName);
//			nameList.set(movePos, iName);
		}
	}

}

/*
캡틴 아메리카 영웅 => Hero [name=캡틴 아메리카, ability=25, birthDay=Fri Apr 30 14:16:31 KST 2021]
스파이더맨 영웅 => Hero [name=스파이더맨, ability=32, birthDay=Fri Apr 30 14:16:31 KST 2021]
엑스맨 영웅 => Hero [name=엑스맨, ability=95, birthDay=Fri Apr 30 14:16:31 KST 2021]
토르 영웅 => Hero [name=토르, ability=18, birthDay=Fri Apr 30 14:16:31 KST 2021]
Hero [name=캡틴 아메리카, ability=25, birthDay=Fri Apr 30 14:16:31 KST 2021]
Hero [name=스파이더맨, ability=32, birthDay=Fri Apr 30 14:16:31 KST 2021]
Hero [name=엑스맨, ability=95, birthDay=Fri Apr 30 14:16:31 KST 2021]
Hero [name=토르, ability=18, birthDay=Fri Apr 30 14:16:31 KST 2021]
 
 */



