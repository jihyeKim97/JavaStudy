public class HelloMain {


	public static void main(String[] args) {
		
		// main 함수 (function) -- 프로그램 시작 위치
		
		System.out.print("안녕하세요");
		System.out.println("Hello java!!!!!!!!!");
		System.out.println("Happy new " + 2021 + " year!!");
		
		// text  - 휴먼 리더블 > 문자열 string 
		// 리터럴 기호 인 ""(더블코테이션)을 사용 하여 문자열을 표현.
		// "로 시작해서 "로 끝나는 문자열들의 일련의 집합
		// "xyz" , "ABCDF" , "12345(숫자+문자로 이뤄진 문자열)" , "제임스 아더 고즐링"
		// 12345 : 양의숫자
		System.out.println( "제임스 아더 고즐링");

		String who = "잼민";
		// data type 기본형VS참조
		// type == String 
		// 변수(명) == who
		// 할당(저장)연산자 == =
		// 문자열데이터 == "제임스 아더 고즐링"
		// 명령의끝 == ;
		int age = 15;
		// 정수 타입 (수치형 , 값)
		System.out.println(who +"이는 "+ age +"살 이다"); // 변수 참조
		
		 who = "고창석";
		 age = 55;
		 // 변수 : 변하는 값
		 // os한테 허락을 맡아서 메모리 공간에 저장을 시켜 메모리 공간을 읽어 온다
		 System.out.println(who +"은 "+ age +"살 이다"); // 변수 참조
		 
		
	
	}
}
	
