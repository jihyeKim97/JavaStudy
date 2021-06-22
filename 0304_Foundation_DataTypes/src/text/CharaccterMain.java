package text;

public class CharaccterMain {

	public static void main(String[] args) {

		// 텍스트 편집기 = 메모장
		// 문자 하나 => 자바(컴퓨터)에서 문자 코드값(수치형 데이터)로 표현,
		// 문자를 직접 표현 하거나 처리 할수는 없음 단, 문자에 대응되는 순서 번호값을 부여하여 문자를 처리할수 있음

		// 문자형 Character Type 
		char c;
		// 단 하나의 글자 하나만 저장할 메모리 공간 확보 | (2byte) => (16bits) 0 ~ 65,535까지 문자코드값
		// 각 문자들은 모두 현재 선택된 문자세트(character set)에 따라서 표현됨.
		// 자바언어는 char형 문자에 대해서 UTF-16형식 -> 유니코드(unicode)으로 처리함.
		// 다만, 가장 자주 사용되는 즉, 키보드 자판으로 표현되는 문자들은 ASCII 아스키 코드셋을 따라 인코딩됨.
		
		c = 'A'; // 65 코드값을 표현.
		c = 65; // 십진법 코드값 
		c = 0x41; // 65 = 16^1 * 4 + 16^0 * 1
		char c2 = 'B';// 66;
		char c3 = 66;
		char c4 = 65 + 1; // 코드값을 수치형으로보고 +거나 -면 순서가 변경.
		char c5 = 'A' + 1;
		
		char d = 'a'; // 97, 0x61  아스키코드셋 문자표에서 찾아보기!!!
		char e = '0'; // 48 숫자문자... 외우세요. 
		char space = ' '; // 32 => 0x20 공백문자 스페이스 
		String strEmpty = ""; // 문자열형의 빈문자열.

		System.out.println('A'); // ASCII 영문대문자
		System.out.println('가'); // 한글 유니코드
		System.out.println('\t'); // 특수문자 \n, \b, \r
		
		System.out.println(c);
		// "abc123" 문자열(String) 리터럴 " 큰따옴표.
		String b = "abc123";
		 
		// https://ko.wikipedia.org/wiki/ASCII

	}

}
