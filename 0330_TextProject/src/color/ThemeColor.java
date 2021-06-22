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
		String titleContent = "1) �׸� �÷� wiki WEB - " + rows + "�� �ȷ�Ʈ";
		String title = "<h3>" + titleContent + "</h3>";
		String table = makeColorTable(theme1Names, theme1Codes);

		int rows2 = theme2Names.length;
		String titleContent2 = "2) GRA- " + rows2 + "�� �ȷ�Ʈ";
		String title2 = "<h3>" + titleContent2 + "</h3>";
		String table2 = makeColorTable(theme2Names, theme2Codes);

		String[] theme3Codes = new String[theme3Names.length];
		int rows3 = theme3Names.length;
		String titleContent3 = "3) GRA- " + rows3 + "�� �ȷ�Ʈ";
		String title3 = "<h3>" + titleContent2 + "</h3>";

		int blue = 255;
		for (int i = 0; i < theme3Codes.length; i++) {
			// int���� ����Ŭ������ IntegerŬ������ �Լ��� ����
			// ���̾ String Ŭ������ �Լ��� �ҹ��ڸ� ��� �빮�ڷ� ��ȯ

			String code = "0x0000" + Integer.toHexString(blue).toUpperCase(); // 4����Ʈ�� ���״� 16�������� ��ȯ�ؼ� ���ڿ��� �������
			theme3Codes[i] = code;
			System.out.println(code);
			blue -= 36;
			//������ ���� blue�� 16������ ���ڿ� �α��ڷ� ����� ����.
		}
		String table3 = makeColorTable(theme3Names, theme3Codes);

		final String HTML_HEAD = "<!DOCTYPE html> " + "<html> " + "	<head> "
				+ "<title> �׸� �÷� wiki WEB / GRA-  </title> " + "</head> " + "<body> ";
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
		table += "<tr> <th> �÷��̸� </th> <th> �÷��ڵ� </th> </tr>";
		for (int i = 0; i < theme1Names.length; i++) {
			table += "<tr bgcolor='#" + getColorCodeOnly(theme1Codes[i]) + "'> <td> " + theme1Names[i] + "�� </td> "
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

		String retCr = new String(crArr); // ���� �迭�� �Է� �޾� ���ڿ� ��ü�� ����
		// �迭�� ���� ���� �ʾƾ� �ϱ⿡ ���ڿ� ��ü�� ���� �Ͽ� ���ڿ��� ����
		return retCr;
	}

//���ڹ迭->���ڿ�
	private static String getColorCodeOnly2(String inCr) {
		char[] editArr = getColorArray(inCr);
		char[] crArr = new char[editArr.length - 2];
		for (int i = 0; i < crArr.length; i++) {
			crArr[i] = editArr[i + 2];
		}
		String str = new String(crArr);
		return str;
	}

//���ڿ�->���ڹ迭
	public static char[] getColorArray(String inCr) { // "" ���ڿ� �Է��� array �迭�� �����Ͽ� �����ϴ� �Լ�
		char[] retArr = new char[inCr.length()];
		for (int i = 0; i < retArr.length; i++) {
			retArr[i] = inCr.charAt(i); // ���ڿ� ��Ҹ� �ϳ��� �迭ĭ�� ����
		}
		return retArr;
	}

}
