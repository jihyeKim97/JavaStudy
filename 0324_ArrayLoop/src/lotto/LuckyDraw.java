package lotto;

import java.util.Arrays;

import utility.ScanUtill;

public class LuckyDraw {
	public static final int MAX_BALLS = 32;
	public static final int MATCH_BALLS = 6;
	public static final int NO_SEL = -1;
	public static final int DEFAULT_TICKETS = 3;

	public static void main(String[] args) {
		System.out.println("---------- LD6/32 행운티켓 뽑기 프로그램 -----------");
		int userWantTickets = ScanUtill.userInputToIntInRange("구매할 티켓의 개수 : ", 1, 20);
		int ticketCount = 0;
		do {

			int selBalls[] = { NO_SEL, NO_SEL, NO_SEL, NO_SEL, NO_SEL, NO_SEL };
			int count = 0;
			int selCount = 0;
			while (selCount < MATCH_BALLS) {
				int ball = (int) (Math.random() * MAX_BALLS) + 1;
				System.out.println(count + "회차 자동번호 볼 ==> (" + ball + ")");
				boolean duplicated = false;
				for (int i = 0; i < selBalls.length; i++) {
					if (ball == selBalls[i]) {
						duplicated = true;
						break;
					}
				}
				if (duplicated == false) {
					selBalls[selCount] = ball;
					selCount++;
				} else {
					System.out.println("\t>> 중복됨!!! " + ball);
				}
				count++;
			}
			int[] oriSelBalls = { NO_SEL, NO_SEL, NO_SEL, NO_SEL, NO_SEL, NO_SEL };
			for (int i = 0; i < oriSelBalls.length; i++) {
				oriSelBalls[i] = selBalls[i];
			}
			Arrays.sort(selBalls);

			ticketCount++;
			System.out.println("\n===== LD 6/32 Ticket =====");
			System.out.println("* 티켓발권수: " + ticketCount + " / " + userWantTickets);
			System.out.println("* 승인번호: " + (long) (Math.random() * 100000000000000L));
			for (int i = 0; i < selBalls.length; i++) {
				System.out.print("(" + selBalls[i] + ") ");
			}
			System.out.println("\n\n\n################################\n\n");
//			System.out.println("--------------------------");
//			System.out.println(" 원본선택볼번호리스트:: ");
//			for (int i = 0; i < oriSelBalls.length; i++) {
//				System.out.print(oriSelBalls[i] + (i < oriSelBalls.length - 1 ? "," : ""));
//			}
//			System.out.println("\n==========================\n\n\n\n");

		} while (ticketCount < userWantTickets);
	}

}
