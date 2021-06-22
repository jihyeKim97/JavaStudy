package text;

public class TextMain3 {

	public static void main(String[] args) { // args Àº null Ã¼Å©ºÎÅÍ lenghtÃ¼Å©
		// String[] ¹®ÀÚ charÀÇ ±âÁØÀ¸·Î º¸¸é 2Â÷¿ø ¹è¿­ÀÇ ±¸Á¶¿Í ºñ½ÁÇÔ
//		String input = "abcdeXYZJQK012789 -+*/%$@&^°¡³ª´Ù«¢«¨«¤«ª«¦";
		String input = "±ÔÁø¾¾°¡ English·Î «¢«¤¸¦ ¿ÜÃÆ´Ù~~!";

		if (args.length == 0) {
			printStringInformation(input);
		} else {
			for (int i = 0; i < args.length; i++) { // args.length »ó¼ö == ÀÔ·ÂÀÇ °¹¼ö
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
				System.out.println(c + " ¹®ÀÚ´Â ÇÑ±¹¾î ±ÛÀÚÀÔ´Ï´Ù.");
			else if (isEngUpper(c))
				System.out.println(c + " ¹®ÀÚ´Â ¿µ¾î ´ë¹®ÀÚÀÔ´Ï´Ù.");
			else if (isEngLower(c))
				System.out.println(c + " ¹®ÀÚ´Â ¿µ¾î ¼Ò¹®ÀÚÀÔ´Ï´Ù.");
			else if (isNumeric(c))
				System.out.println(c + " ¹®ÀÚ´Â ¼ıÀÚ ¹®ÀÚÀÔ´Ï´Ù.");
			else if (isJapenese(c))
				System.out.println(c + " ¹®ÀÚ´Â ÀÏº»¾î °¡³ª¹®ÀÚÀÔ´Ï´Ù.");
			else if (isSpaceBar(c))
				System.out.println(c + " ¹®ÀÚ´Â °ø¹é ±âÈ£¹®ÀÚÀÔ´Ï´Ù.");
			else
				System.out.println(c + " ¹®ÀÚ´Â ±âÅ¸ ¹®ÀÚÀÔ´Ï´Ù.");
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
		return c >= '°¡' && c <= 'ÆR';
	}

	public static boolean isJapenese(char c) {
		return c >= 0x3041 && c <= 0x30FF;

	}

}
