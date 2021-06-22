package text;

public class CharacterMain2 {

	public static void main(String[] args) {

		char c = 65;// 'A'; 
		// 자바 char형 0 ~ 65535 코드값 범위 => 0x0000 ~ 0xFFFF		
		final char SPACE = ' '; // ASCII 코드표에서 32번째 글자..
		final char SPACE2 = 32;
		final char SPACE3 = 0x0020; // 0x20;// 32 = 16^1*2 + 16^0*0
		final char SPACE4 = 0b0000_0000_0010_0000;
		final char SPACE5 = '\u0020'; // unicode 리터럴
		
		//if( 'A' == 'B' ) {
//		if( 'A' != 'B' ) { // 코드값을 비교
		//if( 'A'+1 == 'B' ) { // 64 + 1 == 65
		if( 'A'  > 'B' ) {
			System.out.println("실행됨!!!");
		} else 
			System.out.println("거짓이네요!!!!");
		
		if( 'z' == 'a' + 25 ) // offset
			System.out.println("z 참이네요."); 
		
		if( 'A' < 'a' ) // 대문자들은 소문자들보다 코드표상 앞에 정의..
			System.out.println("A < a 참이네요.");
		
		if( 'A' == 'a'-32 )
			System.out.println("A == a-32 참이네요.");
		if( 'A'+32 == 'a' )
			System.out.println("A+32 == a 참이네요.");
		
		if( 'A'+SPACE == 'a' )
			System.out.println("A+SPACE == a 참이네요.");
		
		printCharWithCode((char)('A'+32)); // 소문자로 변경
		printCharWithCode((char)('A'+' ')); // 소문자로 변경
		printCharWithCode((char)('A'+SPACE)); // 소문자로 변경
		
		printCharWithCode((char)('j'-SPACE)); // 대문자로 변경
		printCharWithCode((char)('y'-SPACE)); // 대문자로 변경
		
		
	}

	private static void printCharWithCode(char c) {
		System.out.printf("문자 %c => 코드값 %d [0x%X] \n", 
				c, (int)c, (int)c); 
	}

}
