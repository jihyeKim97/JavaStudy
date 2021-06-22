package color;

import javax.jws.Oneway;

public class ThemeColor {

	public static void main(String[] args) {
		String[] theme1Names = { "red", "lightgary", "yellow", "cyan", "green", "black", "blue" };
		String[] theme1Codes = { "0xff0000", "0xf2f2f2", "0xFFFF00", "0x00FFFF", "0xff0000", "0x000000", "0x0000FF" };
		String[] theme2Names = { "LightSkyBlue", "DeepSkyBlue", "RoyalBlue", "MediumBlue", "DarkBlue" };
		String[] theme2Codes = { "0x87CEFA", "0x00BFFF", "0x4169E1", "0x0000CD", "0x00008B" };
		String[] theme3Names = { "LightSkyBlue", "DeepSkyBlue", "RoyalBlue", "MediumBlue", "DarkBlue" };

		int rows = theme1Names.length;
		String titleContent = "1) 테마 컬러 wiki WEB - " + rows + "색 팔레트";
		String title = "<h3>" + titleContent + "</h3>";
		String table = makeColorTable(theme1Names, theme1Codes);

		int rows2 = theme2Names.length;
		String titleContent2 = "2) GRA- " + rows2 + "색 팔레트";
		String title2 = "<h3>" + titleContent2 + "</h3>";
		String table2 = makeColorTable(theme2Names, theme2Codes);

		String[] theme3Codes = new String[theme3Names.length];
		int rows3 = theme3Names.length;
		String titleContent3 = "3) GRA- " + rows3 + "색 팔레트";
		String title3 = "<h3>" + titleContent2 + "</h3>";

		int blue = 255;
		for (int i = 0; i < theme3Codes.length; i++) {
			// int형의 랩퍼클래스형 Integer클래스의 함수를 적용
			// 연이어서 String 클래스의 함수가 소문자를 모두 대문자로 변환

			String code = "0x0000" + Integer.toHexString(blue).toUpperCase(); // 4바이트로 줄테니 16진법으로 변환해서 문자열로 돌려줘라
			theme3Codes[i] = code;
			System.out.println(code);
			blue -= 36;
			//십진법 정수 blue를 16진법의 문자열 두글자로 만드는 문제.
		}
		String table3 = makeColorTable(theme3Names, theme3Codes);

		final String HTML_HEAD = "<!DOCTYPE html> " + "<html> " + "	<head> "
				+ "<title> 테마 컬러 wiki WEB / GRA-  </title> " + "</head> " + "<body> ";
		final String HTML_TAIL = "</body> " + "</html>";
		table += "</table>";
		System.out.println(HTML_HEAD);
		System.out.println(title);
		System.out.println(table);
		System.out.println("<hr>");
		System.out.println(title2);
		System.out.println(table2);
		System.out.println(HTML_TAIL);

	}

	private static String makeColorTable(String[] theme1Names, String[] theme1Codes) {

		String table = "<table border='1'>";
		table += "<tr> <th> 컬러이름 </th> <th> 컬러코드 </th> </tr>";
		for (int i = 0; i < theme1Names.length; i++) {
			table += "<tr bgcolor='#" + getColorCodeOnly(theme1Codes[i]) + "'> <td> " + theme1Names[i] + "색 </td> "
					+ "<td> <i>" + theme1Codes[i] + "</i> </td> </tr>";
		}
		table += "</table>";
		return table;

	}

	private static String getColorCodeOnly(String incr) {

		char[] crArr = new char[6];
		for (int i = 0; i < crArr.length; i++) {
			crArr[i] = incr.charAt(i + 2);
		}

		String retCr = new String(crArr); // 문자 배열을 입력 받아 문자열 객체로 만듬
		// 배열을 리턴 하지 않아야 하기에 문자열 객체로 변경 하여 문자열로 리턴
		return retCr;
	}

//문자배열->문자열
	private static String getColorCodeOnly2(String inCr) {
		char[] editArr = getColorArray(inCr);
		char[] crArr = new char[editArr.length - 2];
		for (int i = 0; i < crArr.length; i++) {
			crArr[i] = editArr[i + 2];
		}
		String str = new String(crArr);
		return str;
	}

//문자열->문자배열
	public static char[] getColorArray(String inCr) { // "" 문자열 입력을 array 배열로 변경하여 리턴하는 함수
		char[] retArr = new char[inCr.length()];
		for (int i = 0; i < retArr.length; i++) {
			retArr[i] = inCr.charAt(i); // 문자열 요소를 하나씩 배열칸에 복사
		}
		return retArr;
	}

}
