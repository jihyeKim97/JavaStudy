package HomeWork_0405;

import java.util.Scanner;

public class EmilMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("�̸������ּұ��� �Է�ũ! : ");
		String emailInput = sc.nextLine();
		String[] emailArray = emailInput.split("@");
		System.out.println("����ڰ��� : " + emailArray[0] + "\n" + "�Ҽ� : " + emailArray[1]+"\n");
		int alD = 0,alS = 0,alN = 0,alM = 0;
		for (int i = 0; i < emailInput.length(); i++) {
			char ch = emailInput.charAt(i);
			if (ch >= 65 && ch <= 90) {
				alD ++; 
			}else if(ch >= 97 && ch <= 122){
				alS ++; 
			}else if(ch >= 49 && ch <= 57) {
				alN++;
			}else if((ch >=33&&ch<=47)||(ch>=58&&ch<=63)||(ch>=91&&ch<=96)){
				alM++;
			}
		}
		System.out.printf("���� �빮�� ���� : %d\n",alD);
		System.out.printf("���� �ҹ��� ���� : %d\n",alS);
		System.out.printf("���� ���� : %d\n",alN);
		System.out.printf("���������ڵ���  ���� : %d\n",alM);

	}

}
