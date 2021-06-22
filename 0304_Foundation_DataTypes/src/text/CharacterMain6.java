package text;



public class CharacterMain6 {

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
	
	// 토글함수 구현 
	// 문자 하나를 입력받아 해당 문자가 영문대문자라면 소문자로 변경하여 리턴하고, 
	// 만약 해당 문자가 영문소문자라면 대문자로 변경하여 리턴하는 함수
	public static char toggleCase(char c) {
		char convC = '\0'; // 종료문자
		// 영문 대문자라면 => 문자코드값이 문자셋에서 대문자의 범위에 있으면..
		//if( c >= 65 && c <= 65+25 )
		if( c >= 65 && c <= 90 ) // 대문자 판정
			convC = (char)(c + SPC); // 대 => 소
		if( c >= 97 && c <= 122 ) // 소문자 범위 판정 97+25)	
			convC = (char)(c - SPC); // 소 => 대
		return convC;		
	}
	
	public static char toggleCase2(char c) {
		char convC = '\0';
		if( c >= 65 && c <= 90 ) // 영문 대문자 판정
			convC = (char)(c + SPC); // 대 => 소
		else if( c >= 97 && c <= 122 ) // 영문 소문자 범위 판정 97+25)	
			convC = (char)(c - SPC); // 소 => 대
		else 
			System.out.println(">> '"+c+"' 는 영문 대소문자가 아닙니다!");
		return convC;		
	}
	public static final char ERROR_CHAR = 0;// '\0';
	public static char toggleCase3(char c) {		
		if( c >= 'A' && c <= 'Z' ) // 'A'+25 )
			return (char)(c + SPC); // 대 => 소
		else if( c >= 'a' && c <= 'z' ) 	
			return (char)(c - SPC); // 소 => 대
		else {
			System.out.println(">> '"+c+"' 는 영문 대소문자가 아닙니다!");
			return ERROR_CHAR;
		}
	}
	
	public static char toggleCase4(char c) {		
		if( c >= 'A' && c <= 'Z' ) // 'A'+25 )
			return upperToLower(c); // 대 => 소
		else if( c >= 'a' && c <= 'z' ) {
			char t = lowerToUpper(c);
			return t; // 소 => 대
		} else {
			System.out.println(">> '"+c+"' 는 영문 대소문자가 아닙니다!");
			return ERROR_CHAR;
		}
	}
	
	
	public static void main(String[] args) {
		
//		printCharWithCode(upperToLower('A'));
//		printCharWithCode(lowerToUpper('z'));
//		printCharWithCode(upperToLower('다')); // '댄'
		// toggle 두가지 상태를 왔다갔다 스위칭..
		printCharWithCode(toggleCase4('A'));
		printCharWithCode(toggleCase4('z'));
		printCharWithCode(toggleCase4('F'));
		printCharWithCode(toggleCase4('p'));
		printCharWithCode(toggleCase4(toggleCase4('p')));
		printCharWithCode(toggleCase4('다'));
		printCharWithCode(toggleCase4('5'));
		printCharWithCode(toggleCase4(' '));
		printCharWithCode(toggleCase4('$'));
		printCharWithCode(toggleCase4('?'));
	
	}
	private static void printCharWithCode(char c) {
		if( c == 0 )  //'\0'
			return;
		System.out.printf("문자 %c => 코드값 %d [0x%X] \n", 
				c, (int)c, (int)c); 
	}
	

}
