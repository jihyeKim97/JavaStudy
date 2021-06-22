package gugudan;

public class Gugudan3b {

	public static final String EMTPY = "";
	public static void main(String[] args) {
		// 배열을 정의하여 구구단 실행결과를 바로 출력하지 않고, 
		// 이후 다목적으로 사용하기 위해 저장함.
		//  length => 8개, 순서번호 0 ~ 7
		// 0번째에 2단저장, ... 7번째 배열요소공간 9단저장..
		String[] guguArr = {
			EMTPY, EMTPY, EMTPY, EMTPY, 
			EMTPY, EMTPY, EMTPY, EMTPY
			//"", "", "", ""  	
			//null, null, null, null, null, null,null, null   	
		}; // 배열 요소공간 EMPTY 마다 단 하나의 구구단 결과를 저장할 예정.
		// 배열 공간에 관련이 있는 연산결과들을 저장시켰다가...
		// 이후 필요에 의해서 해당 배열에 구조적으로 접근하여 사용해야함. 
		
		// 구구단 2 ~ 9 단
		final int DAN_LIMIT = 9;//19; //9; // 인도, 일본?
		final int J_LIMIT = 10;//20; //10;
		for (int dan = 2; dan <= DAN_LIMIT; dan++) { // 8번실행
			guguArr[dan-2] += "** " + dan + "단 **\n";
			for (int j = 1; j < J_LIMIT; j++) { //9번실행
				guguArr[dan-2] += (dan + " x " + j 
						+ " = " + (dan*j) + "\n" );
			}
			guguArr[dan-2] += "-------------------";
		}
		// 이중 for문 완료 후 구구단 실행결과 문자열들을 guguArr배열에 모두 저장됨.
		
		System.out.println(guguArr[3-2]); // 3단
		System.out.println(guguArr[5-2]); // 5단
		System.out.println(guguArr[9-2]); // 9단
		
		
	}

}

/*
** 2단 **
2 x 1 = 2
2 x 2 = 4
2 x 3 = 6
2 x 4 = 8
2 x 5 = 10
2 x 6 = 12
2 x 7 = 14
2 x 8 = 16
2 x 9 = 18
-------------------
** 3단 **
3 x 1 = 3
3 x 2 = 6
3 x 3 = 9
3 x 4 = 12
3 x 5 = 15
3 x 6 = 18
3 x 7 = 21
3 x 8 = 24
3 x 9 = 27
-------------------
** 4단 **
4 x 1 = 4
4 x 2 = 8
4 x 3 = 12
4 x 4 = 16
4 x 5 = 20
4 x 6 = 24
4 x 7 = 28
4 x 8 = 32
4 x 9 = 36
-------------------
** 5단 **
5 x 1 = 5
5 x 2 = 10
5 x 3 = 15
5 x 4 = 20
5 x 5 = 25
5 x 6 = 30
5 x 7 = 35
5 x 8 = 40
5 x 9 = 45
-------------------
** 6단 **
6 x 1 = 6
6 x 2 = 12
6 x 3 = 18
6 x 4 = 24
6 x 5 = 30
6 x 6 = 36
6 x 7 = 42
6 x 8 = 48
6 x 9 = 54
-------------------
** 7단 **
7 x 1 = 7
7 x 2 = 14
7 x 3 = 21
7 x 4 = 28
7 x 5 = 35
7 x 6 = 42
7 x 7 = 49
7 x 8 = 56
7 x 9 = 63
-------------------
** 8단 **
8 x 1 = 8
8 x 2 = 16
8 x 3 = 24
8 x 4 = 32
8 x 5 = 40
8 x 6 = 48
8 x 7 = 56
8 x 8 = 64
8 x 9 = 72
-------------------
** 9단 **
9 x 1 = 9
9 x 2 = 18
9 x 3 = 27
9 x 4 = 36
9 x 5 = 45
9 x 6 = 54
9 x 7 = 63
9 x 8 = 72
9 x 9 = 81
-------------------
*/