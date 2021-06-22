package HomeWork_0405;

import java.util.Scanner;

public class argsMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("아무럿게쓰세요 : ");
		String inputTxt = sc.next();
		int[] ch = new int[inputTxt.length()];

		System.out.println("-------- >> 입력한 값 출력 --------");
		for (int i = 0; i < ch.length; i++) {
			ch[i] = inputTxt.charAt(i);
			System.out.printf("%s(%d)\n", (char) ch[i], ch[i]);
		}
		for (int i = 0; i < ch.length; i++) {
			for (int j = i + 1; j < ch.length; j++) {
				if (ch[i] > ch[j]) {
					int temp = ch[i];
					ch[i] = ch[j];
					ch[j] = temp;
				}
			}
		}
		System.out.println();
		System.out.println("-------- >> 정렬한 값 출력 --------");
		for (int i = 1; i <= ch.length; i++) {
			System.out.print((char) ch[i-1] + "(" + ch[i-1] + ")   ");
			if (i % 5 == 0) {
				System.out.println();
			}
		}
	}
}
//		Arrays.sort(ch);
//		for (int j = 0; j < ch.length; j++) {
//			System.out.println(ch[j] + "(" + (int) ch[j] + ")");
//		}