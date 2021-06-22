package multi;

import java.util.Scanner; 

public class SwitchMain {

	private static final int COLOR_RED = 1; // ��
	private static final int COLOR_ORANGE = 2;
	private static final int COLOR_YELLOW = 3;
	private static final int COLOR_GREEN = 4;
	private static final int COLOR_BLUE = 5;
	private static final int COLOR_NAVY = 6;
	private static final int COLOR_PURPLE = 7; // ��
	private static final String COLOR_NAME_BLACK = "black";

	public static void main(String[] args) {
		printHTMLStart("������ �� ��� 5 (�ݺ�ȸ���Է�)");

		// java �⺻ �ܼ� �Է� ���� Scanner
		Scanner sc = new Scanner(System.in);

		System.out.print("\n>> ������ ī�� ���� ��� �̸� �Է� : ");
		String toName = sc.next();
		System.out.println("<h2>�Է��� �̸��� "+toName+" �Դϴ�</h2>");
		System.out.print("\n>> �ݺ� ȸ���� �Է�: "); 
		int countRainbow = sc.nextInt();
		System.out.println("<h2> �Է��� Ƚ����"+countRainbow+" ȸ �Դϴ�</h2>");
		
		System.out.println("\n >> ���� ����( 1:red~\t,2:puple~ ) �Է� : ");
		int orderInput = sc.nextInt();
		final int FROM_RED = 1;
		final int FROM_PURPLE = 2;
		boolean order = false;
		
		if(orderInput == FROM_RED) {
			order = true;
			System.out.println("�Է��� ������ ���� �Դϴ�");
		}else if(orderInput == FROM_PURPLE) {
			System.out.println("�Է��� ������ ���� �Դϴ�");
			order = false;
		}else {
			System.out.println("1��2�� �ƴ� ���ڰ� ���� �Ͽ����ϴ� ������ ���� 1�� �Է� �ϰڽ��ϴ�");
			order = true;
		}
		
		
		
		
		
		int count = 0; // 0, 1, 2, ...
		while (count < countRainbow) { // 3 < 3, false ��������
			printRainbow("�׽�Ʈ �������� " + (count + 1) + "��: red -> purple",order);
			count++;
		}

		printHTMLEnd();
		sc.close(); // �ڿ��� ȸ��, �ݳ� ó��.

	}

	private static void printRainbow(String caption) {
		System.out.println("<div>");
		System.out.println("<h3>----- " + caption + " ------</h3>");
		int startColor = COLOR_RED;// 1
		while (startColor++ <= COLOR_PURPLE) { // 7
			String strColorName = whichColorToHTML(startColor - 1); // "red"
			System.out.println((startColor - 1) + "�� �÷�: " + strColorName + "<br>");
		}
		System.out.println("</div>");
	}

	// order�� true��� red => purple�� ������ ������ ���
	// order�� false��� purple => red�� ������ ������ ���
	// private static void printRainbowTWO(
	// ������ �Լ��̸����� �ټ����� �Լ� �ٵ� ������ �� ����..
	// �Լ� �����ε� ����(Function Overloading) => ������
	private static void printRainbow(String caption, boolean order) {
		System.out.println("<div>");
		System.out.println("<h3>----- " + caption + " ------</h3>");
		int startColor;// ���� ��ġ�� ����.
		if (order == true) {
			// ������ true
			startColor = COLOR_RED;
			while (startColor++ <= COLOR_PURPLE) { 
				String strColorName = whichColorToHTML(startColor - 1); 
				System.out.println((startColor - 1) + "�� �÷�: " + strColorName + "<br>");
			}
		} else 
		{
			// ������ false
			startColor = COLOR_PURPLE;
			while (startColor >= COLOR_RED) {
				System.out.println(startColor + "�� �÷�: " + whichColorToHTML(startColor) + "<br>");
				startColor -= 1; // startColor--;
			}
		}

		System.out.println("</div>");
	}

	// �÷� ��ȣ�� �Է¹޾� ����ǥ���� ������ html tag�� ������ �÷��̸� ���ڿ� ����.
	// private static String whichColorToHTML(int nColor, boolean tag) {
	private static String whichColorToHTML(int nColor) {
		String strColor = whichColor(nColor);
		return "<b style='color:" + strColor + "'>" + strColor + "</b>";
	}

	private static String whichColorToHTMLOrigin(int nColor) {
		String strColor;
		switch (nColor) { 
		case COLOR_RED:
			strColor = "red";
			break;
		case COLOR_ORANGE:
			strColor = "orange";
			break;
		case COLOR_YELLOW:
			strColor = "yellow";
			break;
		case COLOR_GREEN:
			strColor = "green";
			break;
		case COLOR_BLUE:
			strColor = "blue";
			break;
		case COLOR_NAVY:
			strColor = "navy";
			break;
		case COLOR_PURPLE:
			strColor = "purple";
			break;
		default:
			strColor = COLOR_NAME_BLACK;
		}
		return "<b style='color:" + strColor + "'>" + strColor + "</b>";
	}

	// �÷� ������ �Է��ϸ� �÷��̸� ���ڿ��� �����ϴ� �Լ�
	public static String whichColor(int nColor) {
		String strColor;
		switch (nColor) {
		case COLOR_RED:
			strColor = "red";
			break;
		case COLOR_ORANGE:
			strColor = "orange";
			break;
		case COLOR_YELLOW:
			strColor = "yellow";
			break;
		case COLOR_GREEN:
			strColor = "green";
			break;
		case COLOR_BLUE:
			strColor = "blue";
			break;
		case COLOR_NAVY:
			strColor = "navy";
			break;
		case COLOR_PURPLE:
			strColor = "purple";
			break;
		default:
			strColor = COLOR_NAME_BLACK;

		}
		return strColor;
	}

	// html�� ����� �����ֱ����� �Լ� �߰�
	public static void printHTMLStart(String title) {
		final String HTML_START = "<!DOCTYPE html>" + "<html>" + "<head>" + "<meta charset='EUC-KR' />" + "<title> "
				+ title + " </title>" + "<style>" + "	div {" + "		border: 1px solid black;" + "		width: 25%;"
				+ "		margin: 10px;" + " }" + "</style>" + "</head>" + "<body>" + "<h1>" + title + "</h1>" + "<hr>";
		System.out.println(HTML_START);
	}

	public static void printHTMLEnd() {
		final String HTML_END = "</body>" + "</html>";
		System.out.println(HTML_END);
	}

	public static void printColor(String color) {
		System.out.println(" === " + color + " === ");
	}

}
