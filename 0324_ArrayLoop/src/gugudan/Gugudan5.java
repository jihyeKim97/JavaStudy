package gugudan;

public class Gugudan5 {

	public static void main(String[] args) {
		int[] gugudan1D = { 0, 0, 0, 0, 0, 0, 0, 0, 0, // 2�� �� (0,0) ~ (0,8)
				0, 0, 0, 0, 0, 0, 0, 0, 0, // 3�� �� (1,0) ~ (1,8)
				0, 0, 0, 0, 0, 0, 0, 0, 0, // 4�� ��
				0, 0, 0, 0, 0, 0, 0, 0, 0, // 5�� ��
				0, 0, 0, 0, 0, 0, 0, 0, 0, // 6�� ��
				0, 0, 0, 0, 0, 0, 0, 0, 0, // 7�� ��
				0, 0, 0, 0, 0, 0, 0, 0, 0, // 8�� ��
				0, 0, 0, 0, 0, 0, 0, 0, 0 // 9�� �� (7,0) ~ (7,8)
		};
		for (int i = 0, dan = 2; i < gugudan1D.length; i++) {
			int k = i % 9; // 9�� �������� '��ȯ' ����
			int d = dan + i / 9; // �ܼ��� 9�� ������ ����
			System.out.printf(" %d x %d = %2d \n", d, k + 1, d * (k + 1));
			gugudan1D[i] = d * (k + 1);
			for (int c = 9; c < 18; c++) {
				System.out.println(gugudan1D[c]);
			}
		}
	}

}
