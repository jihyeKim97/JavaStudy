package Homework_0323;

import java.util.Scanner;

/*
1)  1�� '��'' ��ȯ, 2�� '��'�� ��ȯ�����ִ� 
	whichNote()�Լ��� ������. 

	whichNote(1) => "��"�� ���ϵǴ� ��ǥ(Note) ���� �Լ� ��.  
	whichNote() �Լ��� switch/case  
			Ȥ�� if/elseif/else ���ߺб������ ����	
	
	��,  1 2  3 4 5 6  7  8  ���.. 
		��-��-��-��-��-��-��-��' ���
	
		8   7 6 5  4 3  2 1  �̶��..
		��'-��-��-��-��-��-��-��  ���	
		  
	* Scanner�� �̿��Ͽ� ������ ������ ������� �Է¹޾� ��� ����... 
	
	=== ���̸� ��� ���α׷� === 
	���� �� �Է�: 8 
	�ֶּ�� | �ֹּ̹� | �ֶּ�� | �ֹּ̹�   ||
	�ֶּ�� | �ֹּ̹� | �ַּ��� | ������'�� ||
	
	���� �� �Է�: 6 
	�ֶּ�� | �ֹּ̹� | �ֶּ�� | �ֹּ̹� ||
	�ֶּ�� | �ֹּ̹� |
		
	���� �� �Է�: 13 
	�ֶּ�� | �ֹּ̹� | �ֶּ�� | �ֹּ̹� ||
	�ֶּ�� | �ֹּ̹� | �ֶּ�� | �ֹּ̹� ||
	�ֶּ�� | �ֹּ̹� | �ֶּ�� | �ֹּ̹� ||
	�ֶּ�� | 
		  
	��, �����ϰ� ��� ��ǥ�� �����մϴ�. �� ~ ��'
	���𸶴� �ݵ�� 4�� ��ǥ�� �����Ͽ� ǥ��.
	�� ������ ������ "|"�� ����Ͽ�ǥ��. 
	�׸��� �� �ݺ��Ǵ� 4������ ������ "||"���ν� ���� ǥ��.
	
	���� ���� �� �Է��� 4 �̸��̸�.. 
	"�߸��� ���� ��"�� ����ϰ� �ٽ� �Է� �޴� 
	������ do / while ������ ����.
*/
public class MyNotes {

	public static void main(String[] args) {
		System.out.println("----���̸� ��� ���α׷�----");
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.print("����� �Է� : ");
			int madi = sc.nextInt();
			if (madi < 4) {
				System.out.println("+++4�̸��� ���ڴ� ���� ���� �ٽ� �ӷ� �ϼ�");
			} else {
				for (int i = 1; i < madi + 1; i++) {
					for (int j = 1; j <= 4; j++) {
						int ran = (int) (Math.random() * 7) + 1;
						switch (ran) {
						case 1:
							System.out.print("��");
							break;
						case 2:
							System.out.print("��");
							break;
						case 3:
							System.out.print("��");
							break;
						case 4:
							System.out.print("��");
							break;
						case 5:
							System.out.print("��");
							break;
						case 6:
							System.out.print("��");
							break;
						case 7:
							System.out.print("��");
							break;
						case 8:
							System.out.print("��#");
							break;
						}
					}
					if (i % 4 == 0) {
						System.out.print("||\t\n");
					} else {
						System.out.print("|\t");
					}
				}
				break;
			}
			System.out.println();
		}
	}
}
