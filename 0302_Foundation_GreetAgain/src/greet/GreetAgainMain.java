package greet;

//다국어 인사
//클래스는 기능과 목적을 묶어놓은 것
public class GreetAgainMain { //{}brace //() perenthesis
	
	
	/*  정적 함수
	 - 함수정의시 소문자로 시작 관례
	 - 함수의 시작은 명령어를 묶어 놓는것
	 - 반복된 코드, 공통으로 적용 되는 코드, 특정 의미를 부여한 코드 묶어서 대표 이름을 붙임 */
	
//---------------------------------------------sayHello---------------------------------------------	
	
	//입력 값이 0개 이며, 안에서 값을 줬을때
	public static void sayHello() { // 함수 정의 시작
		// 함수 정의 =  선언 + 구현부
		
		String  name1 = "백설공주";
		String MSG_JPw = "こんにちは";
		System.out.println(MSG_JPw + " " +  name1);

	} // 함수 정의 끝
	
	
	
//---------------------------------------------sayHello2--------------------------------------------	
	
	/* who라고 하는 문자열 입력 데이터가 함수호출시 반드시 제공
	- sayHello2();  => error  		sayHello2("홍길동")
	- who는 입력변수{parameter, argument} 로써 함수 호출시 초기화 됨 */

	//입력 값이 1개 일때
	public static void sayHello2(String who) {

		String  name1 = who;
		String MSG_JP = "こんにちは";
		System.out.println(MSG_JP + "\\t " +  name1);
		
		// \t  이스케이프 문자
	}
	
	
	
//---------------------------------------------sayHello2B--------------------------------------------	
	
	public static void sayHello2B(String who) {
		
		String  name1 = who;
		String MSG_JP = "こんにちは";
		sayHello3(MSG_JP, who);
		System.out.println(MSG_JP +  name1);
	}
	
	
//---------------------------------------sayHello3---------------------------------------------------	
	
	//입력 값이 2개 일때
	public static void sayHello3(String msg, String who) {
		System.out.println(msg+"\t------"+who);
	}
	
	
	
//++++++++++++++++++++++++++++Main++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	// void = 결과값없음
	public static void main(String[] args) { // [] bracket
		// unicode.org  유니코드로 자바는 모든 문자를 인코딩 함
		String MSG_KR; // 문자열 변수 선언
		MSG_KR = "안녕하세요 :)"; // 할당(초기화 initalization)
		
		String MSG_EN = "HELLO";
		String MSG_JP = "こんにちは";
		String MSG_CN = "你好";
		String MSG_FR = "salut";
		String MSG_BR = "Здравей";
		String MSG_ND = "Hoi";
		String MSG_BE = "Chào";
		String MSG_GR = "γεια";
		
		
		// 상수 선언 및 초기화 constant ->  처음 초기화로 갑과 타입이 고정됨
		
		final String MSG_EN2 = "Nice to meet you";
		final String MSG_JP2 = "はじめまして";
		
		
		MSG_JP = "ㅁㅁㅁㅁㅁ?";  // 새로운 값으로 언제든지 변수는 재할당이 가능
		// MSG_JP2 = "ㅠㅠㅠㅠㅠ?";  // 상수는 재 할당이 안되어  error 남

		
		String  name1 = "백설공주";
		String  name3 = "신데렐라";
		
		
		System.out.println(MSG_KR + " " +  name1);
		System.out.println(MSG_EN + " " +  name1);
		System.out.println(MSG_JP + " " + name1);
		System.out.println(MSG_CN + " " + name1);
		// println(입력값)  람수  괄호안에 입력값을 받아서 한수 자신에게 정의된 고유 기능 수행
		
		name1="새";
		MSG_JP = MSG_JP2;
		System.out.println(MSG_EN2 + " " + name1);
		System.out.println(MSG_JP2 + " " + name1);
		
		
		// 정의된 함수를 필요한 순간에 call
		// Function Call  -> 함수 이름();    () -> 인보크
		sayHello();  // 함수 호출
		// sayHello();  // 함수 호출
		// sayHello();  // 함수 호출
		// sayHello();  // 함수 호출
		// sayHello();  // 함수 호출
		// Open call hierarchy = 정의된 함수가 어디에 사용되었는지 확인 할수 있음
		
		
		
		sayHello2("홍길동"); // 문자열 입력 데이터가 sayHello2() 함수 안쪽의 who변수에 할당됨.
		sayHello2("홍길동 동생");
		// sayHello2(); // who에 넘겨지는 입력값(인자)가 없어서 error
		
		sayHello2B("나 김지혜");
		
		sayHello3(MSG_EN2, name3);
		sayHello3("좋은 아침입니다", "크리스토프");
		sayHello3("당근 먹을래?'", "울라프");
		
		String name2 = "스벤";
		sayHello3("오이 먹을래?'",name2);
	
	}

}
