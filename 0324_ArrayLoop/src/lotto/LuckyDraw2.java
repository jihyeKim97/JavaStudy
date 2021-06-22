package lotto;

import java.util.Arrays;

import utility.ScanUtill;

public class LuckyDraw2 {
	// static공용 상수
	public static final int MAX_BALLS = 32;
	public static final int MATCH_BALLS = 6;
	public static final int NO_SEL = -1;
	public static final int DEFAULT_TICKETS = 3;
	public static final int MIN_TICKETS = 3;
	public static final int MAX_TICKETS = 20;

	// 최대 티켓 입력을 main args인자를 사용하는 verson
	public static void main(String[] args) {
		System.out.println("---------- 6/45 행운 번호 리스트 프로그램 -----------");

		int userWantTickets = 0;
		if (args.length == 0) {
			userWantTickets = ScanUtill.userInputToIntInRange("티켓수를 입력 하세요 : ", MIN_TICKETS, MAX_TICKETS);
		} else {
			userWantTickets = getTicketCountFromArgs(args[0]);
		}
//		if (args.length == 0) {
//			System.out.println(">>>>--- 입력 티켓 수 없음!");
//			userWantTickets = MIN_TICKETS;
//		} else { // args.lenght > 0
//			String ticketStr = args[0]; // 티켓의 장 수를 표현
//			int temp = Integer.parseInt(ticketStr); // 문자열은 심볼코드로 나열 , 정수형 4바이트로 파싱
//			if (temp >= MIN_TICKETS && temp <= MAX_TICKETS) { // 3~20
//				userWantTickets = temp;
//			} else { // 음수 처리, 비정상 숫자 처리
//				if (temp <= 0) {
//					System.out.println("최소 3개 이상 구매 바람");
//					userWantTickets = MIN_TICKETS; // 하한보정
//				} else if (temp >= MAX_TICKETS) {
//					System.out.println("한도는 20개 이므로 해당 티켓수는 처리 할수 없습니다");
//					userWantTickets = MAX_TICKETS; // 상한보정 (거스름돈 자동으로 계산 해줌)
//				}
//			}
//		}

		int ticketCount = 0;
		do {
			int selBalls[] = selectLuckyBalls(); // 정수 배열을 함수 실행의 결과 리턴
			Arrays.sort(selBalls);
			printOneLDTicket(selBalls, ++ticketCount, userWantTickets);
		} while (ticketCount < userWantTickets);
	}

	/* _____________________________ Function ________________________________ */
	
	public static int getTicketCountFromArgs(String argsZero) {
			int userWantTickets = 0;
			String ticketStr = argsZero; // 티켓의 장 수를 표현
			int temp = Integer.parseInt(ticketStr); // 문자열은 심볼코드로 나열 , 정수형 4바이트로 파싱
			// 사용자에게 정수 문자들로 구성된 문자열만 입력 받아야 함
			if (temp >= MIN_TICKETS && temp <= MAX_TICKETS) { // 3~20
				userWantTickets = temp;
			} else { // 음수 처리, 비정상 숫자 처리
				if (temp <= 0) {
					System.out.println("최소 3개 이상 구매 바람");
					userWantTickets = MIN_TICKETS; // 하한보정
				} else if (temp >= MAX_TICKETS) {
					System.out.println("한도는 20개 이므로 해당 티켓수는 처리 할수 없습니다");
					userWantTickets = MAX_TICKETS; // 상한보정 (거스름돈 자동으로 계산 해줌)
				}
			}
		
		return userWantTickets;
	}

	public static int[] selectLuckyBalls() { // 정수 배열에 담아 그 자체를 리턴
		// int배열의 변수에서는 null이 기본 return null;
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
		return selBalls;
	}

	public static void printOneLDTicket(int[] selBalls, int ticketCount, int userWantTickets) {
		System.out.println("\n=====  6/45 Ticket =====");
		System.out.println("* 티켓발권수: " + ticketCount + " / " + userWantTickets);
		System.out.println("* 승인번호: " + (long) (Math.random() * 100000000000000L));
		for (int i = 0; i < selBalls.length; i++) {
			System.out.print("(" + selBalls[i] + ") ");
		}
		System.out.println("\n\n\n################################\n\n");

	}

}
