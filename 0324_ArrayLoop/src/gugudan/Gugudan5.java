package gugudan;

public class Gugudan5 {

	public static void main(String[] args) {
		int[] gugudan1D = { 0, 0, 0, 0, 0, 0, 0, 0, 0, // 2단 행 (0,0) ~ (0,8)
				0, 0, 0, 0, 0, 0, 0, 0, 0, // 3단 행 (1,0) ~ (1,8)
				0, 0, 0, 0, 0, 0, 0, 0, 0, // 4단 행
				0, 0, 0, 0, 0, 0, 0, 0, 0, // 5단 행
				0, 0, 0, 0, 0, 0, 0, 0, 0, // 6단 행
				0, 0, 0, 0, 0, 0, 0, 0, 0, // 7단 행
				0, 0, 0, 0, 0, 0, 0, 0, 0, // 8단 행
				0, 0, 0, 0, 0, 0, 0, 0, 0 // 9단 행 (7,0) ~ (7,8)
		};
		for (int i = 0, dan = 2; i < gugudan1D.length; i++) {
			int k = i % 9; // 9의 나머지를 '순환' 보정
			int d = dan + i / 9; // 단수를 9의 몫으로 보정
			System.out.printf(" %d x %d = %2d \n", d, k + 1, d * (k + 1));
			gugudan1D[i] = d * (k + 1);
			for (int c = 9; c < 18; c++) {
				System.out.println(gugudan1D[c]);
			}
		}
	}

}
