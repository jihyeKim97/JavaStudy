package utility;
// 공통 기능들을 전문 클래스로 분리하여 정의 

import java.util.Scanner;

// 스캐너 관련 기능 함수를 모아둔 유틸리티 클래스 
public class ScanUtill {

	// 스캐너로 정수 입력 받아오는 함수
	// ScanUtil.userInputToInt("OOOO"); 호출
	//private static int userInputToInt(String msg) {
	public static int userInputToInt(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		int year = sc.nextInt();
		//sc.close();
		return year;
	}
	
	// 함수 오버로딩 적용
	// 스캐너로 정수 입력 받아오는데 '정상'적인 min ~ max에서만 받아오는 정수입력 함수
	// 경계의 문제를 처리할 수 있는 함수
	public static int userInputToInt(
			String msg, int min, int max) {
		if( min > max )	{
			System.out.println("min > max 입력 오류!!!");
			return -99999999;
		}	// 논리적 입력 오류 필터링....	
		Scanner sc = new Scanner(System.in);
		
		int input = 0;
		while( true ) {
			System.out.println(msg);
			input = sc.nextInt();
			// 정상범위(min이상... max이하)
			if( input >= min && input <= max ) break;
		}
		return input; // min ~ max
	}
	
	// 범위 입력 단, min < max 함수...
	public static int userInputToIntInRange(
			String msg, int min, int max) {
		if( min > max )	{
			System.out.println("min > max 입력 오류!!!");
			return -99999999;
		}	// 논리적 입력 오류 필터링....	
		Scanner sc = new Scanner(System.in);
		
		int input = 0;
		//while( true ) {
		// 단 1번의 루프 실행을 보장하는 반복문 do ~ while()문. 
		// 일단 1번 실행하고..나서야 조건식을 보고 반복할지말지 결정함. 
//		do {
//			System.out.println(msg);
//			input = sc.nextInt();
//			// 정상범위(min이상... max이하)
//			if( input >= min && input <= max ) break;
//		} while(true);
		
		do {
			System.out.println(msg);
			input = sc.nextInt();
			// 정상범위(min이상... max이하)
			//if( input >= min && input <= max ) break;
		} while(!(input >= min && input <= max)); // 정상아님.
//		} while( (input >= min && input <= max) == false); // 정상아님.
		// !true == false, true == !false
		//} while(input < min || input > max); // 정상아님..
		//} while(input >= min && input <= max); // 정상
		
		return input; // min ~ max
	}
	
	
	public static int userInputToIntInRange2(
			String msg, int min, int max) {
		if( min > max )	{
			System.out.println("min > max 입력 오류!!!");
			return -99999999;
		}		
		int input = 0;				
		do {			
			input = userInputToInt(msg);			
		} while(!(input >= min && input <= max)); // 정상아님.
		return input; // min ~ max
	}
	
	public static int userInputToIntInRange3(
			String msg, int min, int max) {
		if( min > max )	{
			System.out.println("min > max 입력 오류!!!");
			return -99999999;
		}		
		if( min <= 0 ) {
			System.out.println("최소 1번은 실행하시죠.");
			return -1;
		}
		int input = 0;				
		do {			
			input = userInputToInt(msg);
			if( input == 0 ) return 0; //System.exit(0);
		} while(!(input >= min && input <= max)); // 정상아님.
		return input; // min ~ max
	}

	// 사용자의 키보드 입력을 스캐너로 단어 문자열로 받아서 리턴하는 함수
	public static String userInputToString(String msg) {
		System.out.print(msg);
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		return input;
	}
}


