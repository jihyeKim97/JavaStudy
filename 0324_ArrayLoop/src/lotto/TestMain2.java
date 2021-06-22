package lotto;

import java.util.Scanner;

/*
 * RUN/run configuration ����  arguments�ǿ� �Ʒ� �Է�
 
�ö��� 11 OLAf 45.89

�ö���
11
OLAf
45.89


����â ���� ��    java lotte.TestMain2 �ö��� 11 OLAf 45.89 <����> 

 */
public class TestMain2 {

	public static void main(String[] args) {
		// args ������ main() ���� �� (���α׷� �� ó�� ����..)��
		// �ԷµǴ� �ʱⰪ �Ķ���� ==> Arguments
		System.out.println("Arguments == Parameters ����, �Էº���");
		System.out.println("args = " + args);
		System.out.println("args.length = " + args.length);

		for (int i = 0; i < args.length; i++) {
			System.out.println("args[" + i + "] = " + args[i]);
		}

		if (args.length >= 4) { 
			String name = args[0]; 
			int age = Integer.parseInt(args[1]); //-> Parse,Parsing,Parser (�Ľ�, �Ľ�, �ļ�) : ������ ���ڵ��� ��ģ�� �Ľ��� ���� ���ڵ����� ��ȯ
			String engName = args[2];
			double height = Double.parseDouble(args[3]); 

			System.out.println(name + "��/�� ���̰� " + age + "���� �Ǿ����ϴ�.");
			System.out.println("�׷��� �����̸� " + engName + "�� �Ҹ��� �Ǿ���, " + "����� Ű�� " + height + "cm�� �ڶ����ϴ�.");
		} else { // 4�� �̸��� ����...
			System.out.println("ARGS ���ڰ� 4�� �̻� �ʿ�..");
		}
	}

}
