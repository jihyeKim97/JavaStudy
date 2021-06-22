package Homework_0324;

import java.util.Scanner;

/*  수치 입력 통계 

n번의 양의 정수(자연수)를 반복회수로 입력받아,
반복적으로 누적합과 평균 계산을 수행.
입력은 Scanner nextInt() 사용
반복은 for문이나 while문 사용
조건 판단은 if/else if/else 나 switch/case 사용
---------------------- 	

실행 예) 

** 수치 입력 통계 프로그램 **

반복회수를 입력: 100
--------------

1회 입력: 3
>> stat: 1회차 입력 3 => 누적합: 3, 평균: 3.00
2회 입력: 47
>> stat: 2회차 입력 47 => 누적합: 50, 평균: 25.00

...

100회 입력: 99
>> stat: 100회차 입력 99 => 누적합: 16532, 평균: 165.32 	
==============

100회까지의 입력 수 중 최대: 99 
100회까지의 입력 수 중 최소: 3

평균 100.0이 넘는 최초의 회차: 82회차 => 평균: 100.24

혹은 

평균 100.0이 넘는 최초의 회차: 없음.. 

----- 끝 ----- 

*/

public class NumberStat {

	public static void main(String[] args) {
		System.out.println("** 수치 입력 통계 프로그램 **");
		int sum = 0;
		int min = 100;
		int max = 0;
		int overNum = 0;
		double overAvg = 0.0;
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.print("반복 횟수 입력[1-100] : ");
			int count = sc.nextInt();
			if (count > 101 || count <= 0) {
				System.out.println("입력한 값은 범위 안에 없습니다 다시 입력 해주세요");
			} else {
				for (int i = 1; i <= count; i++) {
					if ((i != 1) && (sum / (i - 1) >= 100) && (overNum == 0)) {
						overNum = i - 1;
						overAvg = sum / overNum;
					}
					System.out.printf("%3d회 입력 : ", i);
					int time = sc.nextInt();
					sum += time;
					System.out.printf("\t\t\t누적된 값 : %d  / 평균 : %.2f\n", sum, (double) sum / i);
					if (min > time) {
						min = time;
					} else if (max < time) {
						max = time;
					}
				}
				System.out.println("최소값 : " + min);
				System.out.println("최대값 : " + max);
				if (overAvg == 0) {
					System.out.println("100이 넘는 최초의 회차는 없음");
				} else {
					System.out.printf("평균 100.0이 넘는 최초의 회차: %d회차 => 평균: %.2f\\n", overNum, overAvg);
				}
			}
			break;
		}

	}

}
