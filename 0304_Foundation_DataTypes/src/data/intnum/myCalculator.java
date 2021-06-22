package data.intnum;

public class myCalculator {

	public static void main(String[] args) {
		// 두 정수에 대해서 사칙연산, 나머지를 모두 독립된 함수로서 수행
		int numA = 100, numB = 47;

		myCalsubtrAction(numA,numB);
		myCalSubtraction(numA,numB);
		myCalMultiplication(numA,numB);
		myCalDivision(numA,numB);
		myCalModulus(numA,numB);
		myCalModulus2(numA,numB);
	}
	
	
	private static void myCalsubtrAction(int x, int y) {
		int z = 0; // 임시 4byte 변수
		z = x + y ; 
		System.out.println("[덧셈]"+x+"+"+y+"="+z);
	}

	private static void myCalSubtraction(int x, int y) {
		int z = 0; // 임시 4byte 변수
		z = x - y ; 
		System.out.println("[뺄셈]"+x+"-"+y+"="+z);
		
	}
	
	private static void myCalMultiplication(int x, int y) {
		int z = 0; // 임시 4byte 변수
		z = x * y ; 
		System.out.println("[곱셈]"+x+"*"+y+"="+z);
	}
	
	private static void myCalDivision(int x, int y) {
		
		if(y == 0) {
			System.out.println("y 가 0이기에 나눌수 없습니다");
			return;
		}else {
			int z = 0; // 임시 4byte 변수
			z = x / y ; 
			System.out.println("[나눗셈]"+x+"/"+y+"="+z);			
		}
	}
	
	private static void myCalModulus(int x, int y) { //return이 있을때
		
		if(y == 0) {
			System.out.println("y 가 0이기에 나눌수 없습니다");
			return;
		}
		int z = 0; // 임시 4byte 변수
		z = x % y ; 
		System.out.println("[나머지]"+x+"%"+y+"="+z);			
	}
	
	private static void myCalModulus2(int x, int y) { //return이 없고 else가 있을때
		
		if(y == 0) {
			System.out.println("y 가 0이기에 나눌수 없습니다");
		}else {
			int z = 0; // 임시 4byte 변수
			z = x % y ; 
			System.out.println("[나머지]"+x+"%"+y+"="+z);			
		}
	}

}
