package HomeWork_0427;

import java.util.Scanner;

public class HomeMain2 {
	public static final String[] KR_LAG = { "안녕하세요", "안녕히주무셨어요?", "안녕히 주무세요", "식사 하셨습니까?", "잘 지내셨습니까?", "오랜만입니다.",
			"처음뵙겠습니다.", "다음에 또봅시다." };
	public static final String[] EN_LAG = { "Hello", "Good morning?", "Good night", "Have you eaten?", "How are you?",
			"Long time no see.", "Nice to meet you.", "See you next time." };
	public static final String[] JP_LAG = { "こんにちは", "よく眠っていた?", "おやすみ", "ご飯食べた?", "元気だった?", "久しぶりだ.", "はじめまして.",
			"次またましょう." };
	public static final String[] CH_LAG = { "你好", "早上好?", "晚安", "你吃了没?", "你好吗?", "好久不见.", "很高兴认识你.", "下次见." };
	public static String[] LAG = new String[1];

	public static void main(String[] args) {
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.print(" ** Q.Enter greetings : ");
			String inputValue = sc.nextLine();
			String splited[] = inputValue.split(",");
			
			if (inputValue.equalsIgnoreCase("exit")) { System.out.println("-------------- Close all contents --------------"); break; }
			
			for (int i = 0; i < splited.length; i++) {
				String strVal = splited[i].toString();
				String inputInt = "", inputStr = "";
				for (int j = 0; j < strVal.length(); j++) {
					char ch = strVal.charAt(j);
					if (48 <= ch && 52 >= ch) {
						inputInt += ch;
					} else {
						inputStr += ch;
					}
				}
				switch (inputStr) {
				case "kr":
					LAG = KR_LAG;
					break;
				case "en":
					LAG = EN_LAG;
					break;
				case "jp":
					LAG = JP_LAG;
					break;
				case "ch":
					LAG = CH_LAG;
					break;
				default:
					LAG = null;
					break;
				}
				if (LAG == null) {
					System.out.println("error");
				} else {
					if (inputInt.length() == 0) {
						for (int k = 0; k < LAG.length; k++) {
							System.out.println(k + ". " + LAG[k]);
						}
					} else {
						System.out.println(strVal + " => " + LAG[Integer.parseInt(inputInt)]);
					}
				}
			}
		}
	}
}