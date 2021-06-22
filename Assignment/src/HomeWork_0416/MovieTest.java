package HomeWork_0416;

import java.util.Scanner;

import HomeWork_0416.MyTheater;

/*
// �ǽ� 3). MyTheater Ŭ������ �ۼ�
// 	  ���� ������ ������ Ŭ����...
//   �̸�, �ּ�(���ڿ�)
//   ���尳����ũ��(�󿵰� ����)
//   �󿵰� ���� ��ŭ�� MyMoive �迭�� �غ�
//   �������Լ����� �� �󿵰��� "�������"
//   ���� ��� printTheater() �Լ���
//   ��� �󿵰��� ���� ������ ��ȭ�� ����� �帣 �� ǥ��..
//   addMoiveToTheater(�󿵰� ��ȣ, ��ȭ ��ü)�Լ��� ����...
//   addMoiveToTheater(1, �ܿ�ձ�2);

/* �̷�CGV (������ 11����...)
 * 	 [1��] �������.
 *	 [2��] �������.
 *   [3��] �������.  
 * 
 * 
 * �̷�CGV (������ 11����...)
 * 	 [1��] '�ܿ�ձ�2', ȯŸ��/�ִ�
 *	 [2��] '�͹̳����� ', �׼�
 *   [3��] 'ȫ�浿 ', ������
 */
/*
 * �ǽ� 4). MyMoive�� '��û���ɿ��ɴ�' => ������� level�� 
// �����ϴ� �ʵ带 �߰��ϰ� ������(�ʱ�ȭ, ������, ����Ʈ..) ó��. 
 * ��ȭ��ü�� 7~10������ �����, �� ��ȭ��  
 * 	    ������� level�� ��ȭ���� �ٸ��� 4 ~ 40 ����...
 * 	MyTheater Ŭ������ final ����� ������� ����
 *  MAX_LEVEL = 19;
 *  �󿵰� ��ġ�� ���� ��ȭ ��ü���� �Է¹迭�� ����.
 *  addMoiveToTheater() �Լ����� MAX_LEVEL �̻���
 *  ��ȭ�� �󿵰��� ��ġ�մϴ�.
 *  ��, �Է¹迭�� ��� ��ȭ�� �󿵰� ��ġ ���� �ϱ� ����
 *  �ش� ��ȭ���� �迭, �� �󿵰��� �������ٸ� �ٷ� ����.
 *   
 *   �󿵰� ��ġ
 *   1. ������ 		12�� => ��ġ ����
 *   2. �ܿ�ձ�2		20�� => 1���� ��ġ
 *   3. �͹̳�����   	30�� => 2���� ��ġ
 *   4. �ǻǷ�		6��   => ��ġ ����
 *   5. �׻���       	4��   => ��ġ ����
 *   6. ȫ�浿       	33�� => 3���� ��ġ
 *   7. ���ƿ� ¯��	22�� => ��ġ ���� 
 *   
 *   �̷�CGV (������ 11����...)
 * 	 [1��] '�ܿ�ձ�2', ȯŸ��/�ִ�, 4.5��
 *	 [2��] '�͹̳����� ', �׼�, 2.4��
 *   [3��] 'ȫ�浿 ', ������, 1.0��
 */

public class MovieTest {

	public static void main(String[] args) {
		MyTheater cgv = new MyTheater();
		MyMovie[] movie = { new MyMovie("������", 12, 2.5f), new MyMovie("�ܿ�ձ�2", 20, 4.7f),
				new MyMovie("�͹̳�����", 30, 3.2f), new MyMovie("�Ƿη�", 6, 2.5f), new MyMovie("�׻���", 4, 5.0f),
				new MyMovie("ȫ�浿", 33, 4.0f), new MyMovie("���ƿ� ¯��", 22, 3.1f), };
		addMoiveToTheater(cgv, movie);

	}

	private static void addMoiveToTheater(MyTheater cgv, MyMovie[] movie) {
		cgv = new MyTheater();
		int count = 0;
		for (int i = 0; i < movie.length; i++) {
			if (count < 3) {
				if (movie[i].level >= MyTheater.MAX_LEVEL) {
					System.out.printf("%d. %s\t%d�� => %d���� ��ġ\n", i + 1, movie[i].name, movie[i].level, count + 1);
					cgv.mov[count] = movie[i];
					count++;
				} else
					System.out.printf("%d. %s\t%d�� => ������� ���Ƽ� ��ġ����\n", i + 1, movie[i].name, movie[i].level);
			} else
				System.out.printf("%d. %s\t%d�� => �󿵰� �� ���� ��ġ����\n", i + 1, movie[i].name, movie[i].level);
		}
		cgv.printTheater();
	}

	private static MyMovie addMoiveToTheater() {
		Scanner sc = new Scanner(System.in);
		System.out.println(">> ��ȭ ������ �Է����ּ���!");
		System.out.println("��ȭ �̸�: ");
		String name = sc.next();
		System.out.println("��ȭ ���: ");
		int level = sc.nextInt();
		System.out.println("��ȭ ����: ");
		float score = sc.nextFloat();

		MyMovie mv = new MyMovie(name, level, score);
		return mv;
	}

}
