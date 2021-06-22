package gugudan;

public class GuGuDanMain {

	public static void main(String[] args) {

		final int DAN_LIMIT = 20;
		final int JJ_LIMIT = 20;
//		for (int dan = 1; dan <= DAN_LIMIT; dan++) {
//			for (int j = 1; j < JJ_LIMIT; j++) {
//				System.out.printf("%d X %d = %d\n", dan, j, dan * j);
//			}
//			System.out.println("-----------");
//		}


		int i = 1;
		while (i < 10) {
			int j = 1;
			while (j < 10) {
				System.out.printf("%d X %d = %d\n", i, j, i * j);
				j++;
			}
			i++;
			System.out.println("-----------");
		}
	}
}
