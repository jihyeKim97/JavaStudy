package lotto;

import java.util.Scanner;

public class CastMain {

	public static void main(String[] args) {
		// args ������ main() ���� �� (���α׷� �� ó�� ����..)��
		// �ԷµǴ� �ʱⰪ �Ķ���� ==> Arguments
		System.out.println("Arguments == Parameters ����, �Էº���");
		System.out.println("args = " + args);
		System.out.println("args.length = " + args.length);
		/*
		 Arguments == Parameters ����, �Էº���
		 args = [Ljava.lang.String;@33909752
		 args.length = 0
		 
		 Arguments == Parameters ����, �Էº���
			args = [Ljava.lang.String;@33909752
			args.length = 4
			args[0] = Elsa
			args[1] = 123
			args[2] = ����
			args[3] = 25.41

		 */
		for (int i = 0; i < args.length; i++) {
			System.out.println("args["+ i +"] = " 
					+ args[i]);
		}
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print(">> �̸� �Է�: ");
//		String name = sc.next(); // ���α׷� �����߿�
//		System.out.print(">> ���� �Է�: ");
//		int age = sc.nextInt(); // Ű���� �Է��� ������ ����
//
//		System.out.println("�̸�: " + name);
//		System.out.println("����: " + age);
		
	}

}
