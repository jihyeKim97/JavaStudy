package HomeWork_0402;

import java.util.Scanner;

/*   �������� �̱� �ӽ� ���α׷� ( NC, NEXON, NETMARBLE? ���༺?)
===========================================================


1)   �־��� Ȯ���������� Toy ������ 1���� �̴� 
// getRandomHero() �Լ��� ����.
��޺� Ȯ��
5%   LEGEND  
   "�Ƿη�", "ũ��", "����", "��Ƽ"
   "����", "�ظ�", "������", "����"
15%   SUPER   
   "���̾��", "�����̴���", 
   "ĸƾAm.", "�丣", "��ũ"
30%   RARE
   "����", "�ȳ�", "�����"
50%   NORMAL
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
         NORMAL: 18ȸ (70.00%)

--------------------------------------
               
3)   * ����ڿ��� �ȳ������� ���� Toy���� �̱� ���� �ݾ��� �Է¹޴´�.
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
 LEGEND: 6ȸ (70.00%)  
 
 
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
 LEGEND: 9ȸ (70.00%)  
 
 
 
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
 LEGEND: 10ȸ (70.00%)
 + ���ʽ�: 2ȸ  
      
*/

public class ToyDoll_end {

   public static final String[] LEGENDITEM = { "�Ƿη�", "ũ��", "����", "��Ƽ", "����", "�ظ�", "������", "����" };// 5%
   public static final String[] SUPERITEM = { "���̾��", "�����̴���", "ĸƾAm.", "�丣", "��ũ" };// 15%
   public static final String[] RAREITEM = { "����", "�ȳ�", "�ö���" };// 30%
   public static final String[] NORMALITEM = { "���", "����", "����", "��ũ" };// 50%   
   public static int countLegend = 0, countSuper = 0, countRare = 0, countNormal = 0;
   public static int MIN_COIN = 500;

   public static void main(String[] args) {
      System.out.println("***�̱����α׷�: ");
      Scanner sc = new Scanner(System.in);
      System.out.println("�ݾ��� �Է��ϼ���: ");
      int input = sc.nextInt();
      int count = 0;
      final int BONUS = input / 5000 ; //�Է��� ���� ������ 5000(10ȸ�� ����) ex)10000 = 2
      final int LIMIT = (input / 500) + BONUS;
      boolean ten = false; // 10���� ������ �÷���
      int bi = 0; // 0 ~ 9 �ϰ� 10���� �̱� �����ε���
      int b = 0; // ���ʽ� ó�� ī����
      
      for (int i = 0; i <LIMIT; i++) { // �Է¼��� ���� �̱� Ƚ��         
         int hundredCases = (int) (Math.random() * 100); // 0~99
         count++;         
         System.out.printf("ten = %s, b = %d, BONUS = %d,bi = %d, count = %d \n", ten, b,BONUS, bi, count); // ����׿�
         if (BONUS != 0 && b < BONUS && ten == false ) { 
            System.out.println(">>10ȸ �ϰ�����...");
            ten = true;
            bi = 0;
         }               
         if( ten == false || (ten == true && bi <= 9) ) {
            input -= 500;
            if (ten == true && bi < 9) 
               System.out.printf("%d ȸ�� %s\n", count, getRandomHero(hundredCases));
            else 
               System.out.printf("%d ȸ�� %s (���� �ݾ�: %d)\n", count, getRandomHero(hundredCases), input);            
            if ( ten == false && input < MIN_COIN) System.out.println("�ܾ��� ������!!A");         
         } 
         if(ten == true && bi == 10) {            
            System.out.printf("<FREE ���ʽ�!>%d ȸ�� %s\n", count , getRandomHero(hundredCases));
            ten = false;
            b++;
            if (input < MIN_COIN) System.out.println("�ܾ��� ������!!B");            
         }
         if( ten == true ) bi++;                     
      }
      System.out.println("-----------------------");
      System.out.println("�� " + count + "ȸ �̱�");
      System.out.printf("LEGEND: %dȸ (%.2f%%) \n", countLegend, ((double) countLegend / count) * 100);
      System.out.printf("SUPER: %dȸ (%.2f%%) \n", countSuper, ((double) countSuper / count) * 100);
      System.out.printf("RARE: %dȸ (%.2f%%) \n", countRare, ((double) countRare / count) * 100);
      System.out.printf("NORMAL: %dȸ (%.2f%%) \n", countNormal, ((double) countNormal / count) * 100);
      System.out.println("���ʽ�: " + b +"ȸ");
   }

   public static String getRandomHero(int input) {
      if (input <= 5) {
         countLegend++;
         return ("Legend " + LEGENDITEM[(int) (Math.random() * LEGENDITEM.length)]);
      } else if (input >= 5 && input <= 20) {
         countSuper++;
         return ("Super " + SUPERITEM[(int) (Math.random() * SUPERITEM.length)]);
      } else if (input >= 20 && input <= 50) {
         countRare++;
         return ("Rare " + RAREITEM[(int) (Math.random() * RAREITEM.length)]);
      } else if (input >= 50 && input <= 100) {
         countNormal++;
         return ("Normal " + NORMALITEM[(int) (Math.random() * NORMALITEM.length)]);
      } else
         return "error";
   }
}