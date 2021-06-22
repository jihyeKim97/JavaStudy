package text;

public class CharacterMain3 {

	// 공용상수
	public static final char SPC = ' ';
	
	// 대문자 하나를 입력받아 소문자로 변경하여 리턴하는 함수
	public static char upperToLower(char big) {
		// big 정상범위 입력으로 믿고!!! 
		// big이 대문자의 범위 문자코드값으로 가정.
		char small = 0; // '\0'; //0;
				// '0'는 48값으로 사용안됨..
		small = (char)(big + SPC);
		return small;
	}
	
	// 소문자 하나를 입력받아 대문자로 변경하여 리턴하는 함수 
	public static char lowerToUpper(char small) {
		// small이 소문자의 범위 문자코드값으로 가정. 97~122
		char big = (char)(small - SPC); //'\0';
		return big;
	}
	
	public static char lowerToUpper2(char small) {		
		return (char)(small - SPC);
	}
	
	
	public static void main(String[] args) {
		
		printCharWithCode('W');
		printCharWithCode(upperToLower('W'));
		char conv = lowerToUpper('k'); // 'K' 저장
		printCharWithCode(conv);

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
	
	}

	private static void printCharWithCode(char c) {
		System.out.printf("문자 %c => 코드값 %d [0x%X] \n", 
				c, (int)c, (int)c); 
	}

}
