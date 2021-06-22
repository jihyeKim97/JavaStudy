package text;

public class UnicodeMain {
	

	public static void main(String[] args) {
		printCharWithCode('ÇÑ');
		printCharWithCode('±Û');
		// ¹®ÀÚ ÇÑ => ÄÚµå°ª 54620 [0xD55C]
		// ¹®ÀÚ ±Û => ÄÚµå°ª 44544 [0xAE00]

		char c1 = 'ÇÑ';
		char c2 = '±Û';
		printCharWithCode(c1);
		printCharWithCode('°¡');
		
		boolean cccc = isKorean('°¡');

		if(cccc == true) {
			System.out.println("ÇÑ±ÛÀÔ´Ï´Ù");
		}else {
			System.out.println("ÇÑ±ÛÀÌ¾Æ´Õ´Ï´Ù");
		}
	}

	// °ø¿ë»ó¼ö
	public static final char SPC = ' ';

	//±ÛÀÚ ÇÏ³ª ¹Þ¾Æ¼­ ÇÑ±ÛÀÎÁö ÆÇº° ÇÏ´Â ÇÔ¼ö
	public static boolean isKorean(char c) {
		return c >= '°¡' && c <= 'ÆR';
	}
	public static boolean isKorean2(char c) {
		if(c >= '°¡' && c <= 'ÆR')  return  true;
		return false;
	}
	public static boolean isKorean3(char c) {
		boolean anwer = false;
//		if(c >= 0xAC00 && c <= 0xD7A3) {
//		if(c >= '\uAC00' && c <= '\uD7A3') {
		if(c >= '°¡' && c <= 'ÆR') {
			anwer = true;
			System.out.println("ÇÑ±ÛÀÔ´Ï´Ù");
		}else {
			System.out.println("ÇÑ±ÛÀÌ¾Æ´Õ´Ï´Ù");
		}		
		return anwer;
	}
		

	// ´ë¹®ÀÚ ÇÏ³ª¸¦ ÀÔ·Â¹Þ¾Æ ¼Ò¹®ÀÚ·Î º¯°æÇÏ¿© ¸®ÅÏÇÏ´Â ÇÔ¼ö
	public static char upperToLower(char big) {
		// big Á¤»ó¹üÀ§ ÀÔ·ÂÀ¸·Î ¹Ï°í!!!
		// bigÀÌ ´ë¹®ÀÚÀÇ ¹üÀ§ ¹®ÀÚÄÚµå°ªÀ¸·Î °¡Á¤.
		char small = 0; // '\0'; //0;
		// '0'´Â 48°ªÀ¸·Î »ç¿ë¾ÈµÊ..
		small = (char) (big + SPC);
		return small;
	}

	// ¼Ò¹®ÀÚ ÇÏ³ª¸¦ ÀÔ·Â¹Þ¾Æ ´ë¹®ÀÚ·Î º¯°æÇÏ¿© ¸®ÅÏÇÏ´Â ÇÔ¼ö
	public static char lowerToUpper(char small) {
		// smallÀÌ ¼Ò¹®ÀÚÀÇ ¹üÀ§ ¹®ÀÚÄÚµå°ªÀ¸·Î °¡Á¤. 97~122
		char big = (char) (small - SPC); // '\0';
		return big;
	}

	public static char lowerToUpper2(char small) {
		return (char) (small - SPC);
	}

	// Åä±ÛÇÔ¼ö ±¸Çö
	// ¹®ÀÚ ÇÏ³ª¸¦ ÀÔ·Â¹Þ¾Æ ÇØ´ç ¹®ÀÚ°¡ ¿µ¹®´ë¹®ÀÚ¶ó¸é ¼Ò¹®ÀÚ·Î º¯°æÇÏ¿© ¸®ÅÏÇÏ°í,
	// ¸¸¾à ÇØ´ç ¹®ÀÚ°¡ ¿µ¹®¼Ò¹®ÀÚ¶ó¸é ´ë¹®ÀÚ·Î º¯°æÇÏ¿© ¸®ÅÏÇÏ´Â ÇÔ¼ö
	public static char toggleCase(char c) {
		char convC = '\0'; // Á¾·á¹®ÀÚ
		// ¿µ¹® ´ë¹®ÀÚ¶ó¸é => ¹®ÀÚÄÚµå°ªÀÌ ¹®ÀÚ¼Â¿¡¼­ ´ë¹®ÀÚÀÇ ¹üÀ§¿¡ ÀÖÀ¸¸é..
		// if( c >= 65 && c <= 65+25 )
		if (c >= 65 && c <= 90) // ´ë¹®ÀÚ ÆÇÁ¤
			convC = (char) (c + SPC); // ´ë => ¼Ò
		if (c >= 97 && c <= 122) // ¼Ò¹®ÀÚ ¹üÀ§ ÆÇÁ¤ 97+25)
			convC = (char) (c - SPC); // ¼Ò => ´ë
		return convC;
	}

	public static char toggleCase2(char c) {
		char convC = '\0';
		if (c >= 65 && c <= 90) // ¿µ¹® ´ë¹®ÀÚ ÆÇÁ¤
			convC = (char) (c + SPC); // ´ë => ¼Ò
		else if (c >= 97 && c <= 122) // ¿µ¹® ¼Ò¹®ÀÚ ¹üÀ§ ÆÇÁ¤ 97+25)
			convC = (char) (c - SPC); // ¼Ò => ´ë
		else
			System.out.println(">> '" + c + "' ´Â ¿µ¹® ´ë¼Ò¹®ÀÚ°¡ ¾Æ´Õ´Ï´Ù!");
		return convC;
	}

	public static final char ERROR_CHAR = 0;// '\0';

	public static char toggleCase3(char c) {
		if (c >= 'A' && c <= 'Z') // 'A'+25 )
			return (char) (c + SPC); // ´ë => ¼Ò
		else if (c >= 'a' && c <= 'z')
			return (char) (c - SPC); // ¼Ò => ´ë
		else {
			System.out.println(">> '" + c + "' ´Â ¿µ¹® ´ë¼Ò¹®ÀÚ°¡ ¾Æ´Õ´Ï´Ù!");
			return ERROR_CHAR;
		}
	}

	public static char toggleCase4(char c) {
		if (c >= 'A' && c <= 'Z') // 'A'+25 )
			return upperToLower(c); // ´ë => ¼Ò
		else if (c >= 'a' && c <= 'z') {
			char t = lowerToUpper(c);
			return t; // ¼Ò => ´ë
		} else {
			System.out.println(">> '" + c + "' ´Â ¿µ¹® ´ë¼Ò¹®ÀÚ°¡ ¾Æ´Õ´Ï´Ù!");
			return ERROR_CHAR;
		}
	}

	private static void printCharWithCode(char c) {
		if (c == 0) // '\0'
			return;
		System.out.printf("¹®ÀÚ %c => ÄÚµå°ª %d [0x%X] \n", c, (int) c, (int) c);
	}

}
