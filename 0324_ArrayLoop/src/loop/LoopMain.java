package loop;

public class LoopMain {

	public static void main(String[] args) {
		// 루프 loop: 반복 실행 구간 (문장, 블록을 루프로 설정)
		// 매번 반복을 실행할 때마다 변하는 데이터가 있어야 하며
		// 이런 변화되는 데이터를 기준으로 루프를 제어해야 함.
		// 매번 실행 후 조건식의 변화를 살펴서 반복유무 결정함. 
		// 종료조건을 잘 설계해야 함. 
		// 1) WHILE 루프 
		// 		조건식이 true면 루프실행에 들어가고, 
		//		false라면 단 한 번도 실행하지 않음.
		int w = 0; // 초기식
		while(w < 2) {  // 조건식   2 < 2 거짓..
			System.out.println(w + " ");
			w++; // 증감식(변화식)
			//w = w + 1;
		}
		System.out.println();
		
		// 2) FOR 루프 (C언어 스타일 클래식)
		// 초기식(단 한번 실행),
		// 조건식(매번 루프구간 실행 전에 한번 체크), 
		// 증감식(매번 루프구간 실행 후 한번씩 실행)이 하나로 묶어서 표현됨.
		// 조건식이 true이어야지만 루프실행이 시작됨.
//		for( 초기식; 조건식; 증감식 ) {
//			// 반복구간.
//		}
		int f = 1; // 초기식
		for(; f <= 10;) { //조건식
			System.out.println(f + " ");
			f++; // 증감식
		}
		System.out.println();
		
//		for( int f = 1; f <= 10; f++ ) { // error
//		for( f = 1; f <= 10; f++ ) { 
		for( int f2 = 1; f2 <= 10; f2++ ) { // 1 ~ 10
			System.out.print(f2 + " ");
		}
		System.out.println();
		
		//for( int f2 = 0; f2 <= 10; f2++ ) { // 0 ~ 10 
		//for( int f2 = 0; f2 <= 9; f2++ ) { // 0 ~ 9
		for( int f2 = 0, a = 3; f2 < 10; f2++ ) { // 0 ~ 9
			System.out.print(f2 + " ");
		}
		System.out.println();
		
		for (int i = 0; i < 10; i++) {
			System.out.printf("%d\t", i);
		}
		System.out.println();
		
//		for(int i = 0; i < 10; i+=1) { // 0 ~ 9 
		//for(int i = 0; i < 10; i+=2) { // 0 2 4 6 8
		for(int i = 0; i < 10; i += 3) { // 0 3 6 9 ~ 12
		// int i for문의 초기식에서 선언된 변수 i는 for문 종료와 동시에 사라짐.
		//int i; // i변수는 for문에 관계없이 메모리에 유지 (반복종료후에도 살아있음)
		//for(i = 0; i < 10; i += 3) { // 0 3 6 9 ~ 12
			System.out.printf("%d\t", i);
		}
//		System.out.printf("\n%d\t", i); // error
		System.out.println();
		
		// 99 -> 0, i가 1씩 줄어들다가 -1이 되면 루프 종료.
//		for (int i = 99; i >= 0; --i) {
		for (int i = 99; i >= 0; i--) {
			System.out.printf("%d ", i );
		}
		System.out.println();
		
		// 99 -> 0, i가 1씩 줄어들다가 -1이 되면 루프 종료.
		for (int i = 99; i > -1; --i) {
			System.out.printf("%d ", i );
		}
		System.out.println();
		
		// 100 ~ 1
		for (int i = 100; i > 0; --i) {
			System.out.printf("%d ", i );
		}
		System.out.println();
		
		// 100 ~ 0 (101번)
		for (int i = 100; i >= 0; --i) {
			System.out.printf("%d ", i );
		}
		System.out.println();
		
		// 99 ~ 0
		for (int i = 100; i > 0; --i) {
			System.out.printf("%d ", i-1 );
		}
		System.out.println();
				
		for (int i = 100; i >= 0; i -= 6) {
			System.out.printf("%d ", i );
		}
		System.out.println();
	}

}
