package HomeWork_0402;

import java.util.Scanner;

/*   �������� �̱� �ӽ� ���α׷� ( NC, NEXON, NETMARBLE? ���༺?)
===========================================================

1)	�־��� Ȯ���������� Toy ������ 1���� �̴� 
// getRandomHero() �Լ��� ����.
��޺� Ȯ��
5%	LEGEND  
	"�Ƿη�", "ũ��", "����", "��Ƽ"
	"����", "�ظ�", "������", "����"-
15%	SUPER	
	"���̾��", "�����̴���", 
	"ĸƾAm.", "�丣", "��ũ"
30%	RARE
	"����", "�ȳ�", "�����"
50%	NORMAL
	"���", "����", "����", "��ũ"
	
--------------------------------------
2) 	
- �ݺ����� ���ؼ� �� Toy�� 30ȸ ���� �̱��ϴ� ������ ����.
- ������ �� ���� ��, �Ʒ� ó�� ���

  1ȸ�� LEGEND ũ��
  2ȸ�� RARE ����� 
  ...
  30ȸ�� NORMAL ���
  -----------------
  30ȸ ���� ���: 
   	   LEGEND: 3ȸ (10.00%)
   	   SUPER: 6ȸ (20.00%)
   	   RARE: 3ȸ (10.00%)
   	   NORMAL: 18ȸ (60.00%)

--------------------------------------
   	   	   
3)	* ����ڿ��� �ȳ������� ���� Toy���� �̱� ���� �ݾ��� �Է¹޴´�.
�� �ݾ����� �̱� 1ȸ�� ������ ������ �ݾ��� ���� �����˴ϴ�.
��� �����Ǿ� �ݾ��� 0�̵ǰų� (���� �ƴ�...), 
�� 1ȸ�� ���� �� ���� ���� �������� ������ �ݺ��� ������.	
���⼭, Toy 1���� �̱� 1ȸ �ݾ��� ����� 500��(����)���� �Ѵ�. 

===============================
** �� 10ȸ �̻��� ���� �� �ִ� ������ �ݾ��̶��, 
�� ���� 10ȸ ���� ����̱⸦ ������ �����ϸ�, 
�� ���� ** �� ���� ���ʽ��� 1ȸ�� '����'�̱⸦ �߰��� �� ������ �ش�. (�� 11ȸ ���� �̱�)
-------------------------------

* �̱����α׷�: 
  �ݾ��� �Է��ϼ���: 6400
 >> �Էµ� �ݾ�: �� 6400�� 
 
 1ȸ�� LEGEND ũ�� (���� �ݾ�: 5900��)
 2ȸ�� RARE �����  (���� �ݾ�: 5400��)
  ...
 12ȸ�� NORMAL ��� (���� �ݾ�: 400��)
 <�̱� �ݾ� ����!!!> 
 
 LEGEND: 1ȸ (10.00%)
 SUPER: 2ȸ (20.00%)
 RARE: 3ȸ (10.00%)
 NORMAL: 18ȸ (60.00%) 
 
 
 ** �̱����α׷�: 
  �ݾ��� �Է��ϼ���: 6550
 >> �Էµ� �ݾ�: �� 6550�� 
 
 >> 10ȸ �ϰ��̱� ����....
 1ȸ�� LEGEND ũ�� 
 2ȸ�� RARE ����� 
  ...
 10ȸ�� NORMAL ��� (���� �ݾ�: 1550��)
                                                                                                                                                                                                                                                                                                                                                       
 11ȸ�� NORMAL ��� (���� �ݾ�: 1050��)
 12ȸ�� NORMAL ��� (���� �ݾ�: 550��)
 13ȸ�� NORMAL ��� (���� �ݾ�: 50��)
 <�̱� �ݾ� ����!!!>
 	 
 LEGEND: 1ȸ (10.00%)
 SUPER: 3ȸ (20.00%)
 RARE: 0ȸ (10.00%)
 NORMAL: 18ȸ (60.00%) 
 
 
 
 *** �̱����α׷�:  
  �ݾ��� �Է��ϼ���: 11550  
 >> �Էµ� �ݾ�: �� 11550�� 
  
 >> 10ȸ �ϰ��̱� ����....
 1ȸ�� LEGEND ũ�� 
 2ȸ�� RARE ����� 
  ...
 10ȸ�� NORMAL ��� (���� �ݾ�: 6550��)
 <FREE ���ʽ�> 11ȸ�� LEGEND �Ƿη�
   
 >> 10ȸ �ϰ��̱� ����....
 12ȸ�� LEGEND ũ�� 
 13ȸ�� RARE ����� 
  ...
 21ȸ�� NORMAL ��� (���� �ݾ�: 1550��)
 <FREE ���ʽ�> 22ȸ�� RARE �ȳ�  
   
 23ȸ�� NORMAL ��� (���� �ݾ�: 1050��)
 24ȸ�� NORMAL ��� (���� �ݾ�: 550��)
 25ȸ�� NORMAL ��� (���� �ݾ�: 50��)
 <�̱� �ݾ� ����!!!>
 	 
 LEGEND: 5ȸ (10.00%)
 SUPER: 5ȸ (20.00%)
 RARE: 5ȸ (10.00%)
 NORMAL: 18ȸ (60.00%)
 + ���ʽ�: 2ȸ  
   	
*/

public class ToyDoll {
	public static final int BROKEN_PRI = 500;
	public static final String LEGEND = "LEGEND";
	public static final String SUPER = "SUPER";
	public static final String RARE = "RARE";
	public static final String NORMAL = "NORMAL";

	public static void main(String[] args) {
		String[] dollName = { "�Ƿη�", "ũ��", "����", "��Ƽ", "����", "�ظ�", "������", "����", "���̾��", "�����̴���", "ĸƾAm.", "�丣", "��ũ",
				"����", "�ȳ�", "�����", "���", "����", "����", "��ũ" };

		System.out.println("****�̱� ���α׷�(1 ȸ�� 500��)");
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.print("�ݾ� �Է� : ");
			int price = sc.nextInt();
			if (price < 500 || price > 30000) {
				System.out.println("�ݾ� ������ 500������ 30000�� ���� �Դϴ� �ٽ� �Է� ����");
			} else {
				System.out.printf(">> �Էµ� �ݾ� : %d��\n", price);
				int cal = price / BROKEN_PRI;
				System.out.printf(">> %d������ ������ �ִ� Ƚ���� %dȸ�Դϴ�\n\n", price, cal);
				int bonusC = 0, legendC = 0, superC = 0, rareC = 0, namalC = 0;
				double legendP = 0, superP = 0, rareP = 0, nomalP = 0;
				for (int i = 0; i < cal; i++) {
					int ran = (int) (Math.random() * dollName.length);
					if (i % 10 == 0 && i != 1 && i != 0) {
						System.out.printf("\n[��.��.��!!] %dȸ�� %s�� �̾Ҿ��!! \n\n",i+1, dollName[ran]);
						bonusC++;
						i++;
					}
					if (ran >= 0 && ran <= 8) {
						System.out.printf("%dȸ�� LEGEND : %s <���� �ݾ� :: %d��>\n", i + 1, dollName[ran],
								price -= BROKEN_PRI);
						legendC++;
					} else if (ran >= 9 && ran <= 13) {
						System.out.printf("%dȸ�� SUPER : %s <���� �ݾ� :: %d��>\n", i + 1, dollName[ran],
								price -= BROKEN_PRI);
						superC++;
					} else if (ran >= 14 && ran <= 16) {
						System.out.printf("%dȸ�� RARE : %s <���� �ݾ� :: %d��>\n", i + 1, dollName[ran], price -= BROKEN_PRI);
						rareC++;
					} else if (ran >= 17 && ran <= 20) {
						System.out.printf("%dȸ�� NORMAL : %s <���� �ݾ� :: %d��>\n", i + 1, dollName[ran],
								price -= BROKEN_PRI);
						namalC++;
					}
					legendP = ((double) legendC / (double) cal) * 100.0;
					superP = ((double) superC / (double) cal) * 100.0;
					rareP = ((double) rareC / (double) cal) * 100.0;
					nomalP = ((double) namalC / (double) cal) * 100.0;

				}
				System.out.print(" -------�̱� �ݾ� ����!!�̱� ����!\n");
//				System.out.print("LEGEND : " + legendC + "ȸ ("+legendP+"%)\n SUPER : " + superC + "ȸ("+superP+"%)\n RARE : " 
//				+ rareC+ "ȸ("+rareP+"%)\n NOMAL : " + namalC + "ȸ("+nomalP+"%)\n BONUS : " + bonusC + "��");
				System.out.printf("LEGEND : %dȸ (%.2f %%)\n",legendC ,legendP);
				System.out.printf("SUPER : %dȸ (%.2f %%)\n",superC ,superP);
				System.out.printf("RARE : %dȸ (%.2f %%)\n",rareC ,rareP);
				System.out.printf("NOMAL : %dȸ (%.2f %%)\n",namalC ,nomalP);
				System.out.printf("BONUS : %dȸ \n",bonusC);
				
				
				break;
			}
		}
	}
}
