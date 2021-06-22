package data.intnum;

public class WhichNumber3 {

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
		int a = 256;
		int b = 37;
		
		boolean b50 = isEvenNumber(50); 
			// true/false로 판정결과를 리턴하는 함수 
		//System.out.println(50+"은 짝수가 맞아요? " + b50);
		if( b50 == true ) System.out.println("b50 은 짝수.");
		//if( b50 ) System.out.println("b50 은 짝수.");
		else System.out.println("b50 은 홀수.");
		
		boolean b37 = isEvenNumber(37);
		System.out.println(37+"은 짝수가 맞아요? " + b37);
		
		if( isEvenNumber(99) == true )
//		if( isEvenNumber(99) )
			System.out.println("99 은 짝수.");
		else 
			System.out.println("99 은 홀수(짝수가 아님).");
		
		
		oddOrEvenNumber(100);// 짝홀수 판정 결과 출력하는 함수
		oddOrEvenNumber(37);
		oddOrEvenNumber(123456);
		oddOrEvenNumber(0);
		oddOrEvenNumber(-39);
		
		String oddEvenMsg; // 짝홀수 판정 결과가 "짝수", "홀수"로 담기는 변수
		oddEvenMsg = oddOrEvenReturnMsg(200); // call
		// 짝홀수 판정 결과를 함수 안에서 바로 출력하지 않고!!! 
		// 문자열 데이터 리턴으로 가져오는 함수 
		System.out.println(200+"은/는 " + oddEvenMsg 
						+ "로 판정되었음!");
		
		// 짝수 even (pair), 홀수 odd?
		// 나머지 연산자 %
		// 임의 정수를 2로 나눈 나머지가 0으로 딱 떨어지면 짝수.
		// 임의 정수를 2로 나눈 나머지가 1이면 홀수.
//		int r = a % 2;
		int r = b % 2;
		
		// if( 조건식 ) { 조건식이 true이면 실행; }
		// else { 조건식이 false이면 실행; }
		if( r == 0 ) 
			System.out.println("짝수 입니다.");
		else
			System.out.println("홀수 입니다.");
		
		//if( 1 == 1 ) // 언제나 true
		//if( a % 2 == 1 ) // 홀수면...
		if( true )
			System.out.println("홀수 입니다.");
		else 
			System.out.println("짝수 입니다.");
		
		//if( b % 2 == 0 )
		//if( 1 != 1 ) // 언제나 false
		//if( 2 < 1 )
		if( false )
		//if( b % 2 != 1 ) // 홀수가 아니면..
			System.out.println("짝수 입니다.");
		else 
			System.out.println("홀수 입니다.");
		
		//if( 3 + 4 >= 7 ) System.out.println("error!");
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
}



