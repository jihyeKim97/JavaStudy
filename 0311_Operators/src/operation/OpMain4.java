package operation;

public class OpMain4 {

	public static void main(String[] args) {
		// 증감 연산자 정리 
		int a = 1, b = 1, c = 1, d = 1;
		// 실행전에 각 행의 출력결과를 예상으로 적어보자.
		System.out.println( a++ + a++ ); // 1 + 2 = 3 => "3"
//		int t = a; // 1
//		a = a + 1;
//		int t2 = a; // 2
//		int r = t + t2; // 1 + 2 = 3
//		System.out.println(r);
//		a = a + 1;		
		System.out.println( " a = " + a ); // 3
		
		System.out.println( ++b + ++b ); // 2 + (2+1) = 5
		System.out.println( b++ * 4 + ++b); 
		//System.out.println( (b)++ * 4 + (++b)); // 3 * 4 + (1+(3+1))
		System.out.println( " b = " + b );// 5
//		
		System.out.println( ++c + c++ ); // 2 + 2 = 4
		System.out.println( " c = " + c ); // 3
//		
		System.out.println( d++ + ++d ); // 1 + (1+2) = 4
		System.out.println( " d = " + d ); //3
	}

}
