package HomeWork_0405;

import java.util.Scanner;

public class EmilMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("이메일을주소까지 입력크! : ");
		String emailInput = sc.nextLine();
		String[] emailArray = emailInput.split("@");
		System.out.println("사용자계정 : " + emailArray[0] + "\n" + "소속 : " + emailArray[1]+"\n");
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
		System.out.printf("영문 대문자 개수 : %d\n",alD);
		System.out.printf("영문 소문자 개수 : %d\n",alS);
		System.out.printf("숫자 개수 : %d\n",alN);
		System.out.printf("나머지문자들의  개수 : %d\n",alM);

	}

}
