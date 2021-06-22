package loop;

//import utility.*; // 해당 패키지에 있는 모든 클래스들을 사용가능함.
import utility.ScanUtill;

public class FruitsMain2 {

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
		String fruitFlavors[] = {	
			"달콤한", "새콤한", "상큼한", "시큼한", "고소한", 
			"행복한", "깔끔한" 
		};
		
		//String userName = "길동";
		String userName = 
			ScanUtill.userInputToString("사용자 이름: ");
		
		int frName = (int)(Math.random()*fruitNames.length);
		String fruit = fruitNames[frName];
		String flavor = 
			fruitFlavors[(int)(
				Math.random()*fruitFlavors.length)]; // 0 ~ 6
		System.out.println(userName + "은/는 " 
				//+ "달콤한 " + "과일을/를" + " 먹는다.");
				//+ "달콤한 " + fruit + "을/를" + " 먹는다.");
				+ flavor + " " + fruit + "을/를" + " 먹는다.");
		
		
		
		
		
		
		
//		System.out.println("과일배열의 요수개수(길이) = "
//					+ fruitNames.length ); // 상수
//		System.out.println("첫번째 과일: " + fruitNames[0]);
//		System.out.println("마지막번째 과일: " 
//						+ fruitNames[fruitNames.length-1]);
//		//System.out.println("마지막번째 과일: " + fruitNames[9]);
//		
//		try {
//			System.out.println("마지막 과일: " 
//					+ fruitNames[fruitNames.length]); // 10 error
//			// 10은 순서번호 범위 0 ~ 9를 벗어남...
//			// ArrayIndexOutOfBoundsException 예외 에러가 발생..
//		} catch(ArrayIndexOutOfBoundsException e) { // 예외처리
//			System.out.println("잘못된 배열요소 접근시도! 에러코드 F0301");
//			//e.printStackTrace();
//		}
	}

}
/*
과일배열의 요수개수(길이) = 10
첫번째 과일: 멜론
마지막번째 과일: 자두
잘못된 배열요소 접근시도! 에러코드 F0301
*/