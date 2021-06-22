package operation;

public class OpMain {

	public static void main(String[] args) {
		// 산술연산자 Arithmetic Operators
		// + - * /     % 
		int one = 200;
		int two = 101;
		int nResult1 = one + two;
		int nResult2 = one - two;
		int nResult3 = one * two;
		int nResult4 = 0;
		float fResult4 = 0f;// 0.0F; 
		float fResult5 = 0.0f;		
		
		if( two != 0 ) { // 젯수?
			// 나눠도 되는 안전 블록
			nResult4 = one / two;
			fResult4 = (float)one / two;
			// 수학함수 - 반올림, 절상, 절하
			//fResult5 = Math.round( one / (float)two ); // 0.5~ 
			//fResult5 = (float) Math.ceil(3.99); // 4.0
			//fResult5 = (float) Math.ceil(3.01); // 4.0
//			fResult5 = (float) Math.ceil(3.00); // 3.0
//			fResult5 = (float) Math.ceil(3); // 3.0
//			fResult5 = (float) Math.ceil(one / (float)two); // 3.0
			//fResult5 = (float) Math.floor(3.65); // 3.0 
			//fResult5 = (float) Math.floor(3.01); // 3.0
//			fResult5 = (float) Math.floor(-2.50); // -3.000 
//			fResult5 = (float) Math.floor(-0.01); // -1.000
			fResult5 = (float) Math.ceil(-0.01); // -0.000			
		} else { 
			System.out.println("zero 나누기 시도!!");
		}
		
		System.out.printf(" 나누기 결과: %d \r\n", nResult4);
		System.out.printf(" 나누기 결과: %.2f \r\n", fResult4);
		System.out.printf(" 나누기 결과 Math: %.3f \r\n",
					fResult5);	

	}

}
