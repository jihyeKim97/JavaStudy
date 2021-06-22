package loop;

//import utility.*; // 해당 패키지에 있는 모든 클래스들을 사용가능함.
import utility.ScanUtill;

public class FruitsMain4 {

	public static void main(String[] args) {
		// '과일 이름' 배열 표현 (요소 타입 => "" 문자열형)
//		String fruitNames[]; // 배열 선언.
//		String[] fruitNames;
//		String []fruitNames = {}; 
		// 길이 0인 empty array 빈배열. 요소자체가 하나도 없음...
		String fruitNames[] = { // 배열 선언 및 초기화
			"멜론", "수박", "오렌지", "자몽", "사과",
			"바나나", "파인애플", "살구", "복숭아", "자두"
		}; // length 길이 10인 과일이름들의 배열; index 0 ~ 9까지 접근됨.
//		String fruitFlavors[] = {	
//			"달콤한", "새콤한", "상큼한", "시큼한", "고소한", 
//			"행복한", "깔끔한" 
//		};
		
		//String userName = "길동";
		String userName = 
			ScanUtill.userInputToString("사용자 이름: ");
		
		int frName = (int)(Math.random()*fruitNames.length);
		String fruit = fruitNames[frName];
		
		userEatsFruit("홍길동", "체리");
		userEatsFruit(userName, fruit);
		userEatsFruit(userName, fruitNames[0]); // "멜론"
		
//		String flavor = 
//			fruitFlavors[(int)(
//				Math.random()*fruitFlavors.length)]; // 0 ~ 6
//		System.out.println(userName + "은/는 " 
//				//+ "달콤한 " + "과일을/를" + " 먹는다.");
//				//+ "달콤한 " + fruit + "을/를" + " 먹는다.");
//				+ flavor + " " + fruit + "을/를" + " 먹는다.");
	}

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