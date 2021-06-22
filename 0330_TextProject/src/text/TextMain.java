package text;

public class TextMain {
	public static void main(String[] args) {
		char c1 = 'A';
		Character c2 = 65;
		char c3 = c2.charValue();
		char c4 = 0x0041;
		char c5 = '\u0041';
		char c6 = 0;
		char c7 = '한';
		char c8 = '가';

		// 문자 배열(char Array ) != 문자열(String)
		// 한번 정의된 배열의 크기 = lenght 는 이후 절대 변경 불가능( 상수임)
		char[] cArr1 = { 'X', 'Z', 'Y' };
		char a = cArr1[2];
		char e = cArr1[cArr1.length - 1];
		for (int i = 0; i < cArr1.length; i++) {
			char az = cArr1[i];
			System.out.printf("%d번째 문자 하나 %c[%d, 0x%x]\n", i, az, (int) az, (int) cArr1[i]);
		}
		char[] name1 = {}; // length가 0인 빈 배열 empty array
		char[] name2 = { '임', '경', '진' };
		char[] name3 = { 51076, 44221, 51652 };
		char[] name3b = { 0xC784, 0xACBD, 0xC9C4 };
		char[] name3c = { 0b1100_0111_1000_0100, 0xACBD, 0xC9C4 };
		char[] name3d = { '\uC784', '\uACBD', '\uC9C4' };

		char nameN1[] = new char[3];
		char nameN2[] = { '\0', '\0', '\0' };
		nameN1[0] = '임';
		nameN1[0] = 0b1100_0111_1000_0100; // '임'
		nameN1[1] = 44221;
		nameN1[2] = 0xC9C4;
		nameN2[0] = '\uC784';
		nameN2[3 - 3] = 0xACBD;
		nameN2[3 - 2] = 0xACBD;
		nameN2[3 - 1] = '진';
		nameN2[nameN2.length - 1] = nameN1[2];

		// 문자열형 String 클래스 타입 ->객체 데이터
		// reference형 변수는 데이터 값 자체를 가지는게 아니고, 특정 데이터의 위치를 가리키는 주소 값을 저장
		// 문자열 형도 문자배열 처럼 다수개의 글자들을 표현하고 관리
		String kname1 = "이주현"; // 문자열 객체 생성
		String kname2 = new String("이주현"); // ->>정식 객체 셍성 및 초기화.

		char kName[] = { '이', '주', '현' };
		System.out.println(kname1);
		System.out.println(kname2);
		// kname1.length() = 상수
		for (int i = 0; i < kName.length; i++) {
			System.out.printf("한글자씩 => %c \n", kName[i]);
		}
		// kname1.length() == lenght 함수 메소드 : 문자열 형 데이터 객채의 구성된 글자수(유니코드 글자 수)
		for (int i = 0; i < kname1.length(); i++) {
			// char c = kname1.charAt(i);
			// 문자열형 객체에서 순서대로 포함된
			// 글자 하나를 char형으로 리턴해주는 함수
			// System.out.printf("한 글자 씩 => %c \n", c);
			System.out.printf("한 글자 씩 => %c \n", kname1.charAt(i));
		}

		String princess = "Anna 공주"; // 7글자; 0 ~ 6 순서번호..
		System.out.printf(" %c => %c \n", princess.charAt(0), princess.charAt(6));
		// 'A' => '주'
		System.out.printf(" %c => %c \n", princess.charAt(0), princess.charAt(princess.length() - 1));

	}
}
