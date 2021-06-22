package string;

public class StrMain2 {

	public static void main(String[] args) {
				
		// 문자열을 문자배열로 전환??
		String word3 = "August"; // "April";
		final int wlen3 = word3.length(); // 5
		char[] cArr4c = new char[word3.length()];
		
		// 문자 랩퍼클래스형의 배열
		char[] abc = { 'a', 'b', 'c' };
		Character[] coArr = { 'a', 'b', 'c' }; // 오토박싱
				// new Character()로 자동 감싸서 저장됨..
		Character[] coArr2 = { 
				new Character('a'), 
				new Character('b'), 
				new Character('c')
		};
		
		String word4 = "Princess Elsa"; // 13자
		//Character[] coArr3 = new Character[3];
		Character[] coArr3 = new Character[word4.length()];
		for (int i = 0; i < coArr3.length; i++) {
			coArr3[i] = word4.charAt(i); // 0 ~ 12 오토박싱
//			coArr3[i] = new Character(
//					word4.charAt(i)); // 0 ~ 12 수동박싱
		}
		
//		printCharArray(coArr3); // 에러? char[] != Character[]
		// classic for문 (c언어 스타일) 
		for (int i = 0; i < coArr3.length; i++) {
			Character c = coArr3[i];
			char cc = c.charValue(); // 수동 언박싱
			System.out.println(cc);
//			System.out.println(c);
//			System.out.println(coArr3[i]);
		}
		System.out.println("------------");
		// 빠른 for문; (java언어 스타일, 객체지향형 스타일); 
		// fast enumeration
		// for( 범위타입요소변수 : 반복적으로탐색할범위 ) {}
		// 반복적으로탐색할범위 => 배열, 집합, 리스트, 해시맵... 
		for( Character c : coArr3 ) {
			System.out.println(c);
		}
		char[] winter = word4.toCharArray();
		
		for( Character c : winter ) {
			System.out.println(c);
			//System.out.println(c.charValue());
		}
		for( char c : winter ) {
			System.out.println(c);
		}
		
//		// 수동복사 1 - 루프문으로 문자열 요소 개별 하나하나를 
//		// 순차적으로 하나씩 배열 공간에 복제
//		for (int i = 0; i < cArr4c.length; i++) {
//			cArr4c[i] = word3.charAt(i);
//		}
//		printCharArray(cArr4c);
//		
//		// 수동복사 2 - 함수화
//		char[] manualCopyArr = toMyCharArray( word3 );
//		printCharArray(manualCopyArr);
//		
//		// 자동복사 
//		char[] copyArr = word3.toCharArray(); 
//			// "April"  ----> { 'A', 'p', 'r', 'i', 'l' }
//		printCharArray(copyArr);
	}
	
	private static char[] toMyCharArray2(String word) {
		if( word != null && word.length() > 0 ) { // 널체크최우선
		//if( word.length() > 0 && word != null ) { // 절대안됨!!
				char[] cArr = new char[word.length()];			
				for (int i = 0; i < cArr.length; i++) {
					cArr[i] = word.charAt(i);
				}
				return cArr;
		} else {
			System.out.println("word 입력이 길이가 0이거나 입력이 null.");
			return null;
		}
	}
	

	private static char[] toMyCharArray(String word) {
		if( word != null ) { // 널체크가 우선!! 널이아닐 때만 사용 가능
			if( word.length() > 0 ) { // 글자가 문자열에 1개이상 있는지?
				char[] cArr = new char[word.length()];			
				for (int i = 0; i < cArr.length; i++) {
					cArr[i] = word.charAt(i);
				}
				return cArr;
			} else {
				System.out.println("word 입력이 길이가 0이네요.");
				return new char[0];
			}
		} else {
			System.out.println("문자열이 자체가 입력이 없음. 널!!");
			return null;
		}
	}

	private static void printCharArray(char[] cArr4c) {
		for (int i = 0; i < cArr4c.length; i++) {
			System.out.println(i+"번째 요소 복제 -> " + cArr4c[i]);
		}		
	}

}
/*
0번째 요소 복제 -> A
1번째 요소 복제 -> p
2번째 요소 복제 -> r
3번째 요소 복제 -> i
4번째 요소 복제 -> l 
 */









