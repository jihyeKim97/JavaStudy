package text;

public class CharacterMain4 {

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
		boolean flag = true;
		char start = 'A';
		int count = 0; // 카운터 변수 정의 (빈도수, 진행 도수의 누적합)
		//while(true) { // 무한루프
		//while(flag) {
		final int ALPHABETS = 26;
		while(flag == true) {		
			//count = count + 1;// 1씩 증가하는 카운터
			count++; // 자신의 값을 1씩 증가시킴; 
			// 증감연산자 incremental operator			
			//System.out.printf("%c \n", 'A');
			//System.out.printf("%c \n", 'B');
			//System.out.printf("%c \n", 'A'+1);
			//System.out.printf("%c \n", start+1);
			//System.out.printf("%c \n", start);
			System.out.printf("%d번 구간 => %c \n", count, start);
			start = (char)(start + 1);
			if( count == ALPHABETS ) flag = false;
		}
		System.out.println("문자 출력 loop 종료!!!");

		
	}
	


	private static void printCharWithCode(char c) {
		System.out.printf("문자 %c => 코드값 %d [0x%X] \n", 
				c, (int)c, (int)c); 
	}

}

