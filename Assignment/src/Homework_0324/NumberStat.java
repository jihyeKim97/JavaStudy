package Homework_0324;

import java.util.Scanner;

/*  ��ġ �Է� ��� 

n���� ���� ����(�ڿ���)�� �ݺ�ȸ���� �Է¹޾�,
�ݺ������� �����հ� ��� ����� ����.
�Է��� Scanner nextInt() ���
�ݺ��� for���̳� while�� ���
���� �Ǵ��� if/else if/else �� switch/case ���
---------------------- 	

���� ��) 

** ��ġ �Է� ��� ���α׷� **

�ݺ�ȸ���� �Է�: 100
--------------

1ȸ �Է�: 3
>> stat: 1ȸ�� �Է� 3 => ������: 3, ���: 3.00
2ȸ �Է�: 47
>> stat: 2ȸ�� �Է� 47 => ������: 50, ���: 25.00

...

100ȸ �Է�: 99
>> stat: 100ȸ�� �Է� 99 => ������: 16532, ���: 165.32 	
==============

100ȸ������ �Է� �� �� �ִ�: 99 
100ȸ������ �Է� �� �� �ּ�: 3

��� 100.0�� �Ѵ� ������ ȸ��: 82ȸ�� => ���: 100.24

Ȥ�� 

��� 100.0�� �Ѵ� ������ ȸ��: ����.. 

----- �� ----- 

*/

public class NumberStat {

	public static void main(String[] args) {
		System.out.println("** ��ġ �Է� ��� ���α׷� **");
		int sum = 0;
		int min = 100;
		int max = 0;
		int overNum = 0;
		double overAvg = 0.0;
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.print("�ݺ� Ƚ�� �Է�[1-100] : ");
			int count = sc.nextInt();
			if (count > 101 || count <= 0) {
				System.out.println("�Է��� ���� ���� �ȿ� �����ϴ� �ٽ� �Է� ���ּ���");
			} else {
				for (int i = 1; i <= count; i++) {
					if ((i != 1) && (sum / (i - 1) >= 100) && (overNum == 0)) {
						overNum = i - 1;
						overAvg = sum / overNum;
					}
					System.out.printf("%3dȸ �Է� : ", i);
					int time = sc.nextInt();
					sum += time;
					System.out.printf("\t\t\t������ �� : %d  / ��� : %.2f\n", sum, (double) sum / i);
					if (min > time) {
						min = time;
					} else if (max < time) {
						max = time;
					}
				}
				System.out.println("�ּҰ� : " + min);
				System.out.println("�ִ밪 : " + max);
				if (overAvg == 0) {
					System.out.println("100�� �Ѵ� ������ ȸ���� ����");
				} else {
					System.out.printf("��� 100.0�� �Ѵ� ������ ȸ��: %dȸ�� => ���: %.2f\\n", overNum, overAvg);
				}
			}
			break;
		}

	}

}
