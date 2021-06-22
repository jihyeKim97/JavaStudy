package data.logical;

public class LogicalMain {

	// 변하지 않는 고정된 공통데이터를 상수화 (클래스/스태틱 상수 정의부)
	public static final String MARK = "모자를 "; //"깃발을 "; 


	public static void main(String[] args) {
		// 자바 프리미티브 primitives (기본형)
		// 수치형 계열 = 정수, 실수
		// 논리형 계열 = 부울대수 boolean (선형 대수학?)
		// 오직 두 가지 상태 즉 yes/no, b/w, true/false
		// 참/거짓... 
		// 명제, 즉 조건식 (conditional expression)
		//   조건식의 결과는 무조건 논리형 즉 true, false만..
		boolean b1; // 논리형 변수 공간 생성
		b1 = true;
		boolean b2 = false;
		//int b3 = true; 
		
		boolean b3 = 33 > 20; // true; 
		boolean b4 = 33 < 20; // false;
		boolean b5 = 33 > 33; // false;
		boolean b6 = 33 < 33; // false;
		boolean b7 = 33 >= 33; // true; 경계포함 문제? 초과이상미만이하
		boolean b8 = 2 == 2; // true;
		boolean b9 = (1 != 1); // false
		//
		int val = 17; //100; //20;
		boolean flag = val < 100 && 21 > 20; // and 연산
				// flag = true && true;
				// flag = true;
				// true && true = true (양쪽조건모두 참일 때 참)
				// true && false = false
				// false && true = false
				// false && false = false
				// '&' and 문자, ampersand 문자..
		System.out.println("flag = " + flag);
		
		//flagAction3(flag);
		//flagAction(flag);
		//flagAction(false);
		String result = flagAction4(flag); //false);
		System.out.println("결과: => " + result);
		System.out.println("결과: => " + flagAction4(false));
		
		String result5 = flagAction5B(flag);
		System.out.println("결과5B: => " + result5);
	}
	
	public static String flagAction5B(boolean flag) {
		System.out.print("깃발 액션:: ");
		if( flag == true ) 
			//return "깃발을 "+"올려라!";				
			return MARK + "올려라!";
		else  
			//return "깃발을 "+"내려라!";		
			return MARK +"내려라!";
	}
	
	public static String flagAction5(boolean flag) {
		System.out.print("깃발 액션:: ");
		if( flag == true ) 
			return "깃발을 올려라!";				
		else  
			return "깃발을 내려라!";		
	}
	
	public static String flagAction4(boolean flag) {
		String result = ""; // empty string 
		System.out.print("깃발 액션:: ");
		if( flag == true ) {
			result = "깃발을 올려라!";				
		} else { 
			result = "깃발을 내려라!"; 
		}
		return result; // "깃발을 올려라!" 혹은 "깃발을 내려라!"가 반드시 저장됨.
	}
	
	public static void flagAction3(boolean flag) {
		// if... A else B 조건식은 A나 B 문장/블록이 둘 중 하나가 무조건 분기 실행 
		if( flag == true ) {
			System.out.println("깃발을 올려라!");				
		}
		else { // 앞의 조건식이 false일 때만 else 블록으로와서 실행
			System.out.println("깃발을 내려라!"); 
		}
		System.out.println("== 끝 ==");
	}
	

	
	public static void flagAction2(boolean flag) {
		if( flag == true ) {
			System.out.println("깃발을 올려라!");
			return; // 함수 즉시 종료 (뒤에 문장 실행 못함)
		}
		if( flag == false ) {
			System.out.println("깃발을 내려라!"); return;
		}
//		return;
		System.out.println("== 끝 =="); // 앞서서 리턴되어서 이문장 실행 안됨..
	}
	
	
	public static void flagAction(boolean flag) {
		// if(조건식) 문장;   
		// if가 혼자 사용되면 조건식이 true일때 문장을 실행하고,
		// false이면 그냥 건너뜀.
		if( flag == true )
			System.out.println("깃발을 올려라!");
		
		if( flag == false )
			System.out.println("깃발을 내려라!");
		
		System.out.println("== 끝 ==");
	}

}



