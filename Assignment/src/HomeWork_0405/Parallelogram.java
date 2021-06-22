package HomeWork_0405;

public class Parallelogram {

	public static void main(String[] args) {
		int cnt = 1;
		for (int i = 1; i < 6; i++) {
			for (int j = 5; j > 0; j--) {
				if (i < j) {
					System.out.print("\t");
				} else {
					System.out.print(cnt++);
					System.out.print("\t");
				}
			}
			System.out.println("");
		}
		int secnt = 1;
		for (int i = 5; i > 0; i--) {
			for (int j = 1; j < 6; j++) {
				if (i < j) {
					System.out.print("\t");
				} else {
					System.out.print(secnt++);
					System.out.print("\t");
				}
			}
			System.out.println("");
		}
	}
}
