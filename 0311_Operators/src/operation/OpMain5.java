package operation;

public class OpMain5 {

	public static void main(String[] args) {
		// 논리형 boolean true, false 명제
		boolean flag = false;
		flag = 365 > 30; // true
		flag = 365 % 2 == 0; 
			// 비교연산자 => 조건식;  짝수 => false
		flag = (365 % 2 == 1); // 홀수 => true
		flag = 365 % 2 != 0; // 짝수아니면 => 홀수 true
		flag = 'A' < 'a'; // 65 < 97 => true
		flag = ('Z'-'A') == 25; // true
		// 
		if(1 ==1 ) {System.out.println("1 ==1 ="+true);}
		if(2 != 1 ) {System.out.println("2 !=1 ="+true);}
		if(2  > 1 ) {System.out.println("2 >1 ="+true);}
		if(2  > 2 ) {System.out.println("2 >2 ="+false);}
		if(2  >= 2 ) {System.out.println("2 >=2 ="+true);}
		if(1  <= 3 ) {System.out.println("1 <=3= "+true);}
		
		
		if(true && true) {System.out.println("true && true="+true);}
		if(true && false) {System.out.println("true && false="+false);}
		if(false && true) {System.out.println("false && true="+false);}
		if(false && false) {System.out.println("false && false="+false);}
		
		if(true || true) {System.out.println("true || true="+true);}
		if(true || false) {System.out.println("true || false="+true);}
		if(false || true) {System.out.println("true || false="+true);}
		if(false || false) {System.out.println("true || false="+false);}

		if(false || false || false || false || false || true) {System.out.println("false || false || false || false || false || true="+true);}
		//true 는 논리형 값이다
		
		
		
		
	}

}
