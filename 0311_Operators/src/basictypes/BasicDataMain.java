package basictypes;

public class BasicDataMain {

	public static void main(String[] args) {
		// 기본형 Primitives 
		// 수치형
		// 숫자로 구성된 수치값의 크기를 표현 (number value)
		// 고정된 바이트 크기가 각 타입별로 정해짐 (범위)
		// 자바의 모든 수치형 타입들은 모두 부호가 있는 signed 임 +/-
		//  정수계열: long L 8 > int(integer) 4 > short 2 > byte 1
		//		=> 자바의 정수리터럴 표현의 기본형 int임   365 (4바이트 int)
		//		=> 진법(radix) 표현이 가능함  0b0011 0x0F 088	100
		//		=> 기본값 0, 0L
		//  실수계열: double D 8 > float 4 F
		//		=> 정밀도 표현 (소수점)
		//		=> 자바의 실수 표현의 기본 double임    3.14
		//		=> 기본값 0.0, 0.0D, 0.0F
		// 논리형: boolean 참과 거짓의 오직 두 가지 상태만 존재.
		//		=> true, false 만이 존재.
		//		=> 조건식에 적합, 분기문을 제어, 반복 루프 제어, 토글스위치, 검증
		//		=> 기본값 false
		// 문자형: char(character) 단 하나의 문자를 표현.
		//		=> 실제로는 문자 심볼에 대한 코드값을 수치로 표현한 것. 
		//		=> 2byte 유니코드로 표현됨. 0 ~ 65535, 0x0000 ~ 0xFFFF
		//		=> UTF-16 코드체계.
		//		=> 유니코드 코드세트(ASCII 포함)의 순서번호가 문자코드값인데, 
		//		=> 'A' 작은 따옴표 리터럴이 문자코드값 표현.
		//		=> 기본값 0, '\0'
		// 레퍼런스형 계열... 
		//	문자열형 String: 
		//			기본형도 아닌지만 매우 자주 사용됨
		//			"abc" 리터럴 표현됨.  하나 이상의 문자들이 합쳐져서 표현.
		//	클래스(class 형) => 모든 클래스는 그 자체가 하나의 고유 데이터 타입임.
		//	인터페이스(interface 형), 열거형(enum)
		//	String str;
		//	BasicDataMain basic;
		//  함수형??? 
		//   	=> 기본값은 null  (널) -- 아무것도 가리키지 않은 상태
		
		// 헝가리안 표기법... 
		byte bOne = 127; 
		short sTwo = -32345;
		int iThree = 33;  // i => index, 순서번호, 카운터..
		int nFour = 44;
		long lFive = 555L; // 0L;
		
		double dPi = 3.141592; //3.141592D;
		final double dPi2 = Math.PI; // 상수
		float fTemperature = 36.5f;
		
		boolean bFlag = false;
		boolean bResult = 365 > 30; // 조건식의 최종결과는 논리형, true
		
		char cSix = '가';
		char cSeven = 'A';
		char cEight = 97; // 'a'
		
		String strName = null; // "" ;// "홍길동";
	}

}
