package data.intnum;

public class MyCalculator2 {

	public static void main(String[] args) {
		// 두 정수에 대해서 사칙연산, 나머지를 모두 독립된 함수로써 수행
		int numA = 100, numB = 47;
		
		mycalAdd(numA, numB); // 함수 호출
		//mycalAdd(9999, 1);
		
//		return;
			// 리턴 뒤로는 수행하지 않고 도달하지 않기에 죽은 코드... 실행무..
		mycalSubtract(numA, numB);  
		mycalMultiply(numA, numB);
		mycalDivide(numA, 0); // numB);
//		mycalModulus(numA, numB);
		mycalModulus(numA, 0);
		mycalModulus2(numA, 22); // 0);
	}
	
	public static void mycalModulus2(int x, int y) {
		if( y == 0 ) {
			System.out.println("~~~ 0으로 나누는 시도!!! II");
		} else {		
			int z = 0;
			z = x % y;
			System.out.print(">> 나머지 수행 II: ");
			System.out.println(x + " % " + y + " = " + z);
		}
	}
	
	public static void mycalModulus(int x, int y) {
		if( y == 0 ) {
			System.out.println("~~~ 0으로 나누는 시도!!!");
			return; // mycalModulus() 함수의 종료.
		}
		
		int z = 0;
		z = x % y;
		System.out.print(">> 나머지 수행: ");
		System.out.println(x + " % " + y + " = " + z);
	}
	
	public static void mycalDivide(int x, int y) {
		if( y == 0 ) {
			System.out.println("~~~ 0으로 나누는 시도!!!");
			return; // mycalDivide() 함수의 종료.
		}
		
		int z = 0;
		z = x / y;
		System.out.print(">> 나눗셈 수행: ");
		System.out.println(x + " / " + y + " = " + z);
	}

	private static void mycalMultiply(int x, int y) {
		int z = 0;
		z = x * y;
		System.out.print(">> 곱셈 수행: ");
		System.out.println(x + " * " + y + " = " + z);
	}
	
	private static void mycalSubtract(int x, int y) {
		int z = 0;
		z = x - y;
		System.out.print(">> 뺄셈 수행: ");
		System.out.println(x + " - " + y + " = " + z);
	}

	// 함수 정의
	private static void mycalAdd(int x, int y) {
		int z = 0;
		z = x + y;
		System.out.print(">> 덧셈 수행: ");
		System.out.println(x + " + " + y + " = " + z);
	}

}
