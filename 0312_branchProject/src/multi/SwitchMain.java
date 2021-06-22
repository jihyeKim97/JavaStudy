package multi;

import java.util.Scanner; 

public class SwitchMain {

	private static final int COLOR_RED = 1; // 빨
	private static final int COLOR_ORANGE = 2;
	private static final int COLOR_YELLOW = 3;
	private static final int COLOR_GREEN = 4;
	private static final int COLOR_BLUE = 5;
	private static final int COLOR_NAVY = 6;
	private static final int COLOR_PURPLE = 7; // 보
	private static final String COLOR_NAME_BLACK = "black";

	public static void main(String[] args) {
		printHTMLStart("무지개 띠 출력 5 (반복회수입력)");

		// java 기본 콘솔 입력 도구 Scanner
		Scanner sc = new Scanner(System.in);

		System.out.print("\n>> 무지개 카드 받을 사람 이름 입력 : ");
		String toName = sc.next();
		System.out.println("<h2>입력한 이름은 "+toName+" 입니다</h2>");
		System.out.print("\n>> 반복 회수를 입력: "); 
		int countRainbow = sc.nextInt();
		System.out.println("<h2> 입력한 횟수는"+countRainbow+" 회 입니다</h2>");
		
		System.out.println("\n >> 방향 결정( 1:red~\t,2:puple~ ) 입력 : ");
		int orderInput = sc.nextInt();
		final int FROM_RED = 1;
		final int FROM_PURPLE = 2;
		boolean order = false;
		
		if(orderInput == FROM_RED) {
			order = true;
			System.out.println("입력한 방향은 레드 입니다");
		}else if(orderInput == FROM_PURPLE) {
			System.out.println("입력한 방향은 퍼플 입니다");
			order = false;
		}else {
			System.out.println("1과2가 아닌 숫자가 접근 하였습니다 임의의 숫자 1를 입력 하겠습니다");
			order = true;
		}
		
		
		
		
		
		int count = 0; // 0, 1, 2, ...
		while (count < countRainbow) { // 3 < 3, false 종료조건
			printRainbow("테스트 무지개띠 " + (count + 1) + "번: red -> purple",order);
			count++;
		}

		printHTMLEnd();
		sc.close(); // 자원을 회수, 반납 처리.

	}

	private static void printRainbow(String caption) {
		System.out.println("<div>");
		System.out.println("<h3>----- " + caption + " ------</h3>");
		int startColor = COLOR_RED;// 1
		while (startColor++ <= COLOR_PURPLE) { // 7
			String strColorName = whichColorToHTML(startColor - 1); // "red"
			System.out.println((startColor - 1) + "번 컬러: " + strColorName + "<br>");
		}
		System.out.println("</div>");
	}

	// order가 true라면 red => purple로 순방향 무지개 출력
	// order가 false라면 purple => red로 역방향 무지개 출력
	// private static void printRainbowTWO(
	// 동일한 함수이름으로 다수개의 함수 바디를 정의할 수 있음..
	// 함수 오버로딩 정의(Function Overloading) => 다형성
	private static void printRainbow(String caption, boolean order) {
		System.out.println("<div>");
		System.out.println("<h3>----- " + caption + " ------</h3>");
		int startColor;// 선언 위치가 변경.
		if (order == true) {
			// 순방향 true
			startColor = COLOR_RED;
			while (startColor++ <= COLOR_PURPLE) { 
				String strColorName = whichColorToHTML(startColor - 1); 
				System.out.println((startColor - 1) + "번 컬러: " + strColorName + "<br>");
			}
		} else 
		{
			// 역방향 false
			startColor = COLOR_PURPLE;
			while (startColor >= COLOR_RED) {
				System.out.println(startColor + "번 컬러: " + whichColorToHTML(startColor) + "<br>");
				startColor -= 1; // startColor--;
			}
		}

		System.out.println("</div>");
	}

	// 컬러 번호를 입력받아 색상표현을 포함한 html tag로 감싸진 컬러이름 문자열 리턴.
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

	// 컬러 정수를 입력하면 컬러이름 문자열로 리턴하는 함수
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

	// html로 출력을 보여주기위한 함수 추가
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
