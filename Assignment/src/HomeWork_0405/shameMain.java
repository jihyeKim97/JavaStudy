package HomeWork_0405;

import java.util.Scanner;

public class shameMain {

	public static void main(String[] args) {
		while (true) {
			int arrInt[] = new int[26];
			int arrNum = 0;
			Scanner sc = new Scanner(System.in);
			System.out.print("반복횟수 : ");
			int input = sc.nextInt();
			if (input < 0 || input > 999) {
				System.out.println("다시 입력 ㄱㄱ");
			} else {
				for (int i = 0; i < input; i++) {
					if (i % 5 == 0) {
						System.out.println();
					}
					char alp = (char) ((int) (Math.random() * 25) + 65);
					arrNum = (int) alp - 65;
					System.out.print(alp + "(" + (int) alp + ")" + "[" + arrNum + "]" + " ");
					arrInt[arrNum] += 1;
				}
				System.out.println("\n--------->> 루프종료");
				for (int i = 65; i <= 90; i++) {
					if (i % 5 == 0) {
						System.out.println();
					}
					System.out.print((char) i + "=" + arrInt[i - 65] + "  ");
				}
			}
			break;
		}
	}
}
