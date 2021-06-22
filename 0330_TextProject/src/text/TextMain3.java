package text;

public class TextMain3 {

	public static void main(String[] args) { // args �� null üũ���� lenghtüũ
		// String[] ���� char�� �������� ���� 2���� �迭�� ������ �����
//		String input = "abcdeXYZJQK012789 -+*/%$@&^�����٫���������";
		String input = "�������� English�� ������ ���ƴ�~~!";

		if (args.length == 0) {
			printStringInformation(input);
		} else {
			for (int i = 0; i < args.length; i++) { // args.length ��� == �Է��� ����
				String word = args[i];
				System.out.println(i+","+word);
				printStringInformation(word);
			}
		}

	}

	private static void printStringInformation(String input) {
		// for (int i = 0; i < cntInput; i++) {
		for (int i = 0; i < input.length(); i++) { // i=>0~34
			char c = input.charAt(i);
			if (isKorean(c) == true)
				System.out.println(c + " ���ڴ� �ѱ��� �����Դϴ�.");
			else if (isEngUpper(c))
				System.out.println(c + " ���ڴ� ���� �빮���Դϴ�.");
			else if (isEngLower(c))
				System.out.println(c + " ���ڴ� ���� �ҹ����Դϴ�.");
			else if (isNumeric(c))
				System.out.println(c + " ���ڴ� ���� �����Դϴ�.");
			else if (isJapenese(c))
				System.out.println(c + " ���ڴ� �Ϻ��� ���������Դϴ�.");
			else if (isSpaceBar(c))
				System.out.println(c + " ���ڴ� ���� ��ȣ�����Դϴ�.");
			else
				System.out.println(c + " ���ڴ� ��Ÿ �����Դϴ�.");
		}
	}

	public static boolean isSpaceBar(char c) {
		return c == ' ';
	}

	public static Boolean isNumeric(char c) {
		return c >= '0' && c <= '9';
	}

	public static boolean isEngUpper(char c) {

		return c >= 'A' && c <= 'Z';
	}

	public static boolean isEngLower(char c) {
		return c >= 'a' && c <= 'z';
	}

	public static boolean isKorean(char c) {
		return c >= '��' && c <= '�R';
	}

	public static boolean isJapenese(char c) {
		return c >= 0x3041 && c <= 0x30FF;

	}

}
