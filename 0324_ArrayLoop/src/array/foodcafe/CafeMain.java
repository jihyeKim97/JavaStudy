package array.foodcafe;

import java.util.Scanner;

import utility.ScanUtill;

public class CafeMain {

	public static final String NONE = null;

	public static void main(String[] args) {
		String strMainMeun[] = { "Big Mac", "Wafer", "Shrimp", "Shanghai", "McMorning", "Psy", "Cheese", "Jinger",
				"Rice" };
		String strSideMeun[] = { "French fries", "Rap", "Coleslaw", "Corn Salad", "Cheese Stick", "cider", "coffee",
				new String("Cola"), new String("Milk") }; // new String ("우유") 문자열 객체 : string 타입의 데이터
		int nMainPrices[] = { 990, 5000, 6000, 4500, 4000, 7000, 990, 1500, 8000 };
//	1>>	int nSidePricesaa[] = { 200, 300, 400, 500, 600, 700, 800, 900, 1000 }; // 배열 선언과 동시에 메모리 할당, 초기화
//	2>>	int nSidePrices[]  = {0,0,0,0,0,0,0,0,0}; // 공간 확보 의미없는 9개의 공간만 선언
//	3>>	int nSidePrices[] = new int[9]; // 1차원 배열 공간이 생성 = 선언과 동시에 메모리 할당
		int nSidePrices[] = new int[strSideMeun.length];

		for (int i = 0; i < nSidePrices.length; i++) {
			nSidePrices[i] = 200 + 100 * i;
		}
		System.out.println("======  My Cafe  ======\n");
		System.out.println("Main Menu : " + strMainMeun.length + "ea");
		System.out.println("Side Menu : " + strSideMeun.length + "ea\n");

		String[] evMainManu = { "", "", "", "", "", "", "", "", "" };
		String[] evSideMenu = new String[strSideMeun.length];

		nMainPrices[0] = 490;
		evMainManu[0] = "//Open 1+1 Event";
		strMainMeun[7] = "triple";
		nMainPrices[7] = 1000;
		evMainManu[7] = "//Open 6900won -> 1000won event";
		strSideMeun[2] = "RichDeepCon";
		nSidePrices[2] -= 100; // nSidePrices[2]-100;
		evSideMenu[2] = "//Runching -100won D.C";

		final int NO_SEL = 0;
		int menuOrders[] = new int[4];
		int order = 0;
		Scanner sc = new Scanner(System.in);

		do {
			if (order > 0) {
				int goStop = ScanUtill.userInputToIntInRange("1, Add , 2. Exit", 1, 2);
				if (goStop == 2) {
					break;
				}
			}
			if (order == 0) {
				printCafeManu("MAIN MENU", strMainMeun, nMainPrices, evMainManu);
			} else {
				printCafeManu("SIDE MENU", strSideMeun, nSidePrices, evSideMenu);
			}
			System.out.println("------------------------");
			String mtype = order == 0 ? "Main" : "Side";
			int menu = ScanUtill.userInputToIntInRange("\n\n>> Please select a menu? :  ", 1, strMainMeun.length);
			menuOrders[order] = menu;
			order++;
			if (order == menuOrders.length)
				break;
		} while (true);
		System.out.println("=== Thank u ===");
		int totalPrice = 0;
		for (int i = 0; i < menuOrders.length; i++) {
			if (menuOrders[i] == NO_SEL)
				break;
			int mOrder = menuOrders[i] - 1;
			String mType = (i == 0) ? "main" : "side";
			String mName = (i == 0) ? strMainMeun[mOrder] : strSideMeun[mOrder];
			int mPrice = (i == 0) ? nMainPrices[mOrder] : nSidePrices[mOrder];
			System.out.println(mType + "menu : " + (mOrder + 1) + "th - " + mName + "(" + mPrice + "won)");
			totalPrice += mPrice;
		}
		System.out.printf("\t\t total cash : %4d won \n", totalPrice);
	}

	public static void printCafeManu(String subTitle, String strMeun[], int nPrices[]) {
		System.out.println("\n-- " + subTitle + " --");
		for (int i = 1; i <= strMeun.length; i++) {
			System.out.printf("manu %02dth - %s : %4d won\r\n", i, strMeun[i - 1], nPrices[i - 1]);
		}
	}

	public static void printCafeManu(String subTitle, String strMeun[], int nPrices[], String[] evMenu) {
		System.out.println("\n-- " + subTitle + " --");
		for (int i = 0; i < strMeun.length; i++) {
			/* NullPointerException = hard error<필수 선행 null check> */
			System.out.printf("manu %02dth - %s : %4d won %s\r\n", i + 1, strMeun[i], nPrices[i],
					((evMenu[i] != null && evMenu[i].isEmpty() == false) ? evMenu[i] : "*BEST"));
		}
	}
}
