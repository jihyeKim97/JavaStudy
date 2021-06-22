package loop;

//import utility.*; // 해당 패키지에 있는 모든 클래스들을 사용가능함.
import utility.ScanUtill;

public class FruitsMain5 {

	public static void main(String[] args) {
		// '과일 이름' 배열 표현 (요소 타입 => "" 문자열형)
		// 한국어
		String fruitNamesKr[] = { // 배열 선언 및 초기화
			"멜론", "수박", "오렌지", "자몽", "사과",
			"바나나", "파인애플", "살구", "복숭아", "자두"
		}; // length 길이 10인 과일이름들의 배열; index 0 ~ 9까지 접근됨.
		// 영어
		String fruitNamesEn[] = { 
			"melon", "watermelon", "orange", "grapefruit", "apple",
			"banana", "pineapple", "apricot", "peach", "plum"
			,"cherry", "strawberry", "blueberry"
		};
		
		int lang = ScanUtill.userInputToIntInRange(
				"언어선택 (1. 한국어,  2. 영어)"
			+ " / Select language (1. Kr, 2. En): ", 1, 2);
		if( lang == 1 ) { // KR
			String userName = 
				ScanUtill.userInputToString("사용자 이름을 입력하세요: ");
			int frName = (int)(Math.random()*fruitNamesKr.length); // 10
			if( frName >= 0 && frName <= 9 )
				userEatsFruit(userName, fruitNamesKr[frName]);
		} else { // EN
			String userName = 
				ScanUtill.userInputToString("Insert user's name in English: ");
			int frName = (int)(Math.random()*fruitNamesEn.length); // 13
			userEatsFruit(userName, fruitNamesEn[frName]);
		}
	}

	// 공통 상수 언어 결정
	public static final int LANG_KR = 1;
	public static final int LANG_EN = 2;
	
	// 공통 배열 상수 정의 (프로그램 시작부터 끝까지 공유..)
	public static final String[] FRUIT_FLAVORS = {	
			"달콤한", "새콤한", "상큼한", "시큼한", "고소한", 
			"행복한", "깔끔한" 
	};	
	
	private static void userEatsFruit(
			String userName, String fruitName) {
//		String fruitFlavors[] = {	
//				"달콤한", "새콤한", "상큼한", "시큼한", "고소한", 
//				"행복한", "깔끔한" 
//		};
		String flavor = 
				FRUIT_FLAVORS[(int)(
			Math.random()*FRUIT_FLAVORS.length)]; // 0 ~ 6
		System.out.println(userName + "은/는 " 
			//+ "달콤한 " + "과일을/를" + " 먹는다.");
			//+ "달콤한 " + fruit + "을/를" + " 먹는다.");
			+ flavor + " " + fruitName + "을/를" + " 먹는다.");		
	}

}