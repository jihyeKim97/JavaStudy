package hello;
// 패키지 설정 (가작 맨 위에 시작 위치)
// 이 소스 파일의 클래스 들은 이 패키지에 소속
// keyword ,reserved(키워드, 예약어)


// 클래스 정의 (Class Definition)
public class GreetMain {  //Class 정의 시작

	// 함수는 클래스 밖에 있으면 안됨
	// 함수 정의 (Function  Definition) => 기능
	// 반복적인 기능이나 같은 기능만 정의 한다
	// main() 메인 함수 -> 프로그램의 시작과 끝을 담당한
	//									흐름제어 함수
	//entry point(시작 진입 점)
	public static void main(String[] args) { // 메인 함수 정의 시작 main() 프로그램 시작
		
		String GREET_MESSAGE = "유하"; // 변수에 데이터 할당
					// 할당(저장 assign) 연산자
		System.out.println("mian() 실행 ㄱ"); // 문장 = Statement 명령 실행의 최소 단위, 반드시 세미콜론으로 끝남,
		System.out.println("안녕하세요"); //엔터키 (리턴키) -  개행
		System.out.println(GREET_MESSAGE+"심청이"); //변수 참조
		System.out.println(GREET_MESSAGE+"엘사"); 
		System.out.println(GREET_MESSAGE+ "백설공주" ); 
		
		GREET_MESSAGE = "유하~?"; // 새로운 데이터로 재 할당
		
		System.out.println(GREET_MESSAGE+"심청이"); //변수 참조(제 할당된 새로운 데이터)
		System.out.println(GREET_MESSAGE+"엘사");
		System.out.println(GREET_MESSAGE+ "백설공주" ); 
//		System.out.println(GREET_MESSAGE+"심청이"); //엔터키 (리턴키) -  개행(문자열 데이터 ->  상수)

	} // 메인 함수 정의 끝 mian() 프로그램 끝

} // Class 정의 끝
