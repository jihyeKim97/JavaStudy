package HomeWork_0405;

import java.util.Scanner;

public class HtmlMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("입력('X'포함) : ");
		String inValue = sc.nextLine();

		if (inValue.contains("X")) {
			int fN = Integer.parseInt(inValue.split("X")[0]);
			int sN = Integer.parseInt(inValue.split("X")[1]);

			String tableOpen = "<Table border = 1 >";
			String tableClose = "</Table>";
			String trOpen = "<tr>";
			String trClose = "</tr>";
			String tdOpen = "<td>";
			String tdClose = "</td>";

			System.out.println(tableOpen);
			for (int i = 1; i <= fN; i++) {
				System.out.print("\t" + trOpen + " ");
				for (int j = 1; j <= sN; j++) {
					System.out.print(tdOpen + "(" + i + "," + j + ")" + tdClose + " ");
				}
				System.out.println(trClose);
			}
			System.out.println(tableClose);
		} else {
			System.out.println("Errorrrr!!");
		}

	}
}
