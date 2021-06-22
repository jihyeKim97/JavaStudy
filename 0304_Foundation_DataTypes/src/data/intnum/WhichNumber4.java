package data.intnum;

public class WhichNumber4 {

	public static void oddOrEvenNumber(int num) {
		// 전처리부 -- 양의 정수 (자연수)만... 처리하자 
		//if( num >= 0 ) { 참이면실행; } else { 거짓이면실행; }
		if( num > 0 ) {
			// 메인처리부
			if( num % 2 == 1 ) // 홀수 기준으로 참 true
				System.out.println(num + "은/는 홀수Odd 입니다.");
			else // 짝수  기준으로 거짓 false
				System.out.println(num + "은/는 짝수Even 입니다.");
		} else {
			System.out.println(
				"짝홀수 판별 대상수는 양의 정수만 됩니다.^^ - 대상수: " + num);
		}		
	}
	
	public static void main(String[] args) {
		final int ODD_NUMBER = 1; // 홀수
		final int EVEN_NUMBER = 2; // 짝수
		final int ERROR_ZERO = 0; // 예외 0
		final int ERROR_MINUS = -1; // 예외 음수
		
		int a = 77;// 100;
		int rType = oddOrEvenReturnInt(a);
		//if( rType == 1 ) System.out.println("홀수!!!!!");
		//if( rType == 2 ) System.out.println("짝수!!!!!");
		if( rType == ODD_NUMBER ) System.out.println("홀수!!!!!");
		if( rType == EVEN_NUMBER ) System.out.println("짝수!!!!!");
	}

	// definition
	private static String oddOrEvenReturnMsg(int num) {
		final String ODD = "홀수";
		final String EVEN = "짝수";
		String result = ""; // emtpy string
		//return null; // 아무것도 가리키지 않은 상태 표현함 null 널
		//return ""; // 빈문자열
		if( num % 2 == 0 ) result = EVEN;
		else result = ODD;
		return result;
	}

	// 짝수야라고 물어보는 일반 판단 함수, true/false를 리턴
	public static boolean isEvenNumber(int num) {
		boolean result = false;
		if( num % 2 == 0 ) result = true; // 짝수
		else result = false; // 짝수가 아님, 즉 홀수..
			// true를 짝수에 대응시킴...
		return result;
	}

	// 임의 수를 입력 받아서 정상범위라면 짝수, 홀수 판정하고 리턴
	// 예외 범위라면 그 예외를 리턴 
	// 리턴하는 정수값:  
	//  		홀수면 1을 리턴, 짝수면 2를 리턴
	//			예외이고 0이 입력된거라면 0을 리턴
	//			예외이고 음수가 입력된거라면 -1을 리턴
//	public static int oddOrEvenReturnInt(int num) {
//		if( num < 0 ) return -1; // 예외 음수
//		if( num == 0 ) return 0; // 예외 0
//		if( num % 2 == 1 ) return 1; // 홀수
//		else // 짝수
//			return 2;
//	}
	public static int oddOrEvenReturnInt(int num) {
		if( num < 0 ) {
			System.out.println("예외 발생: 음수");
			return -1; // 예외 음수
		}
		if( num == 0 ) {
			System.out.println("예외 발생: 0");
			return 0; // 예외 0			
		}
		if( num % 2 == 1 ) return 1; // 홀수
		else // 짝수
			return 2;
	}
}



