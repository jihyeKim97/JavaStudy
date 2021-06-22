package lotto;

import java.util.Scanner;

/*
 * RUN/run configuration 에서  arguments탭에 아래 입력
 
올라프 11 OLAf 45.89

올라프
11
OLAf
45.89


도스창 실행 시    java lotte.TestMain2 올라프 11 OLAf 45.89 <엔터> 

 */
public class TestMain2 {

	public static void main(String[] args) {
		// args 변수는 main() 시작 시 (프로그램 맨 처음 실행..)에
		// 입력되는 초기값 파라미터 ==> Arguments
		System.out.println("Arguments == Parameters 인자, 입력변수");
		System.out.println("args = " + args);
		System.out.println("args.length = " + args.length);

		for (int i = 0; i < args.length; i++) {
			System.out.println("args[" + i + "] = " + args[i]);
		}

		if (args.length >= 4) { 
			String name = args[0]; 
			int age = Integer.parseInt(args[1]); //-> Parse,Parsing,Parser (파스, 파싱, 파서) : 일정한 디코딩을 거친뒤 파싱을 통해 인코딩으로 변환
			String engName = args[2];
			double height = Double.parseDouble(args[3]); 

			System.out.println(name + "은/는 나이가 " + age + "세가 되었습니다.");
			System.out.println("그래서 영어이름 " + engName + "로 불리게 되었고, " + "어느새 키가 " + height + "cm로 자랐습니다.");
		} else { // 4개 미만의 인자...
			System.out.println("ARGS 인자가 4개 이상 필요..");
		}
	}

}
