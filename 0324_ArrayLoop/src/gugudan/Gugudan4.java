package gugudan;

public class Gugudan4 {

	public static void main(String[] args) {
		// 배열을 정의하여 구구단 실행결과를 바로 출력하지 않고, 
		// 이후 다목적으로 사용하기 위해 저장함.
		// 총 8개단수를 행으로 보고, 각 단마다 연산식 9번을 열로 보는 2차원 배열로 표현.
		// 8 x 9 = 72개 요소...   72 x 4 바이트 = 288바이트 할당...
		//int[][] gugudan2D; // 배열의 배열
		// (0,0) ~ (7,8) 
		int[][] gugudan2D = {
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 2단 행 (0,0) ~ (0,8)
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 3단 행 (1,0) ~ (1,8)
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 4단 행
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 5단 행
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 6단 행
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 7단 행
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 8단 행
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }  // 9단 행 (7,0) ~ (7,8)
		};
		// 2 ~ 9단을 행에 대응,
		// 각 단별로 1 ~ 9 곱한 값을 결과 정수로 각각 배열요소로 저장
		// i를 단수, j를 각 단의 곱하는 수로 보자. 
		// i 2 ~ 9, j 1 ~ 9 범위
//		for (int i = 2; i <= 9; i++) { // 단수 == 행번호
//			for (int j = 1; j <= 9; j++) { // 곱하는수 == 열번호
//				int temp = i * j;
//				gugudan2D[i-2][j-1] = temp;
//			}
//		}
//		for (int i = 0; i < 8; i++) { // 단수 == 행번호
//			for (int j = 0; j < 9; j++) { // 곱하는수 == 열번호
		for (int i = 0; i < gugudan2D.length; i++) { // 단수 == 행번호
			for (int j = 0; j < gugudan2D[i].length; j++) { // 곱하는수 == 열번호		
				int temp = (i+2) * (j+1);
				gugudan2D[i][j] = temp;
				// 저장기준으로 인덱스를 0으로 기준을 잡자. 
			}
		}
		
		// 테스트 출력
		int dan = 3;//8; //9;
		System.out.println( dan + "단");
		for (int k = 1; k <= 9; k++) {
			System.out.printf(" %d x %d = %2d \n", 
					dan, k, gugudan2D[dan-2][k-1] );
		}
		
		// 아래 내용은 지금 이해못해도 괜찮음...
		//int[] dayArr = gugudan2D[3-2]; // 3단만 dayArr로 복사?
		dan = 7;
		int[] dayArr = gugudan2D[dan-2]; // 7단만 dayArr로 복사?
		System.out.println(" -- 선택한 단: " + dan);
		for (int m = 1; m <= dayArr.length; m++) {
			System.out.printf(" %d x %d = %2d \n", 
					dan, m, dayArr[m-1] );
		}
	}

}
