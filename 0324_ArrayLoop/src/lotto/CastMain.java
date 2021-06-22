package lotto;

import java.util.Scanner;

public class CastMain {

	public static void main(String[] args) {
		// args 변수는 main() 시작 시 (프로그램 맨 처음 실행..)에
		// 입력되는 초기값 파라미터 ==> Arguments
		System.out.println("Arguments == Parameters 인자, 입력변수");
		System.out.println("args = " + args);
		System.out.println("args.length = " + args.length);
		/*
		 Arguments == Parameters 인자, 입력변수
		 args = [Ljava.lang.String;@33909752
		 args.length = 0
		 
		 Arguments == Parameters 인자, 입력변수
			args = [Ljava.lang.String;@33909752
			args.length = 4
			args[0] = Elsa
			args[1] = 123
			args[2] = 엘사
			args[3] = 25.41

		 */
		for (int i = 0; i < args.length; i++) {
			System.out.println("args["+ i +"] = " 
					+ args[i]);
		}
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print(">> 이름 입력: ");
//		String name = sc.next(); // 프로그램 실행중에
//		System.out.print(">> 나이 입력: ");
//		int age = sc.nextInt(); // 키보드 입력을 변수에 저장
//
//		System.out.println("이름: " + name);
//		System.out.println("나이: " + age);
		
	}

}
