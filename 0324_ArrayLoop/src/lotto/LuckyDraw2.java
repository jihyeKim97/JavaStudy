package lotto;

import java.util.Arrays;

import utility.ScanUtill;

public class LuckyDraw2 {
	// static���� ���
	public static final int MAX_BALLS = 32;
	public static final int MATCH_BALLS = 6;
	public static final int NO_SEL = -1;
	public static final int DEFAULT_TICKETS = 3;
	public static final int MIN_TICKETS = 3;
	public static final int MAX_TICKETS = 20;

	// �ִ� Ƽ�� �Է��� main args���ڸ� ����ϴ� verson
	public static void main(String[] args) {
		System.out.println("---------- 6/45 ��� ��ȣ ����Ʈ ���α׷� -----------");

		int userWantTickets = 0;
		if (args.length == 0) {
			userWantTickets = ScanUtill.userInputToIntInRange("Ƽ�ϼ��� �Է� �ϼ��� : ", MIN_TICKETS, MAX_TICKETS);
		} else {
			userWantTickets = getTicketCountFromArgs(args[0]);
		}
//		if (args.length == 0) {
//			System.out.println(">>>>--- �Է� Ƽ�� �� ����!");
//			userWantTickets = MIN_TICKETS;
//		} else { // args.lenght > 0
//			String ticketStr = args[0]; // Ƽ���� �� ���� ǥ��
//			int temp = Integer.parseInt(ticketStr); // ���ڿ��� �ɺ��ڵ�� ���� , ������ 4����Ʈ�� �Ľ�
//			if (temp >= MIN_TICKETS && temp <= MAX_TICKETS) { // 3~20
//				userWantTickets = temp;
//			} else { // ���� ó��, ������ ���� ó��
//				if (temp <= 0) {
//					System.out.println("�ּ� 3�� �̻� ���� �ٶ�");
//					userWantTickets = MIN_TICKETS; // ���Ѻ���
//				} else if (temp >= MAX_TICKETS) {
//					System.out.println("�ѵ��� 20�� �̹Ƿ� �ش� Ƽ�ϼ��� ó�� �Ҽ� �����ϴ�");
//					userWantTickets = MAX_TICKETS; // ���Ѻ��� (�Ž����� �ڵ����� ��� ����)
//				}
//			}
//		}

		int ticketCount = 0;
		do {
			int selBalls[] = selectLuckyBalls(); // ���� �迭�� �Լ� ������ ��� ����
			Arrays.sort(selBalls);
			printOneLDTicket(selBalls, ++ticketCount, userWantTickets);
		} while (ticketCount < userWantTickets);
	}

	/* _____________________________ Function ________________________________ */
	
	public static int getTicketCountFromArgs(String argsZero) {
			int userWantTickets = 0;
			String ticketStr = argsZero; // Ƽ���� �� ���� ǥ��
			int temp = Integer.parseInt(ticketStr); // ���ڿ��� �ɺ��ڵ�� ���� , ������ 4����Ʈ�� �Ľ�
			// ����ڿ��� ���� ���ڵ�� ������ ���ڿ��� �Է� �޾ƾ� ��
			if (temp >= MIN_TICKETS && temp <= MAX_TICKETS) { // 3~20
				userWantTickets = temp;
			} else { // ���� ó��, ������ ���� ó��
				if (temp <= 0) {
					System.out.println("�ּ� 3�� �̻� ���� �ٶ�");
					userWantTickets = MIN_TICKETS; // ���Ѻ���
				} else if (temp >= MAX_TICKETS) {
					System.out.println("�ѵ��� 20�� �̹Ƿ� �ش� Ƽ�ϼ��� ó�� �Ҽ� �����ϴ�");
					userWantTickets = MAX_TICKETS; // ���Ѻ��� (�Ž����� �ڵ����� ��� ����)
				}
			}
		
		return userWantTickets;
	}

	public static int[] selectLuckyBalls() { // ���� �迭�� ��� �� ��ü�� ����
		// int�迭�� ���������� null�� �⺻ return null;
		int selBalls[] = { NO_SEL, NO_SEL, NO_SEL, NO_SEL, NO_SEL, NO_SEL };

		int count = 0;
		int selCount = 0;
		while (selCount < MATCH_BALLS) {
			int ball = (int) (Math.random() * MAX_BALLS) + 1;
			System.out.println(count + "ȸ�� �ڵ���ȣ �� ==> (" + ball + ")");
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
				System.out.println("\t>> �ߺ���!!! " + ball);
			}
			count++;
		}
		return selBalls;
	}

	public static void printOneLDTicket(int[] selBalls, int ticketCount, int userWantTickets) {
		System.out.println("\n=====  6/45 Ticket =====");
		System.out.println("* Ƽ�Ϲ߱Ǽ�: " + ticketCount + " / " + userWantTickets);
		System.out.println("* ���ι�ȣ: " + (long) (Math.random() * 100000000000000L));
		for (int i = 0; i < selBalls.length; i++) {
			System.out.print("(" + selBalls[i] + ") ");
		}
		System.out.println("\n\n\n################################\n\n");

	}

}
