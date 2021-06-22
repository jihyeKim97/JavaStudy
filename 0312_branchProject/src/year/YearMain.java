package year;

import java.util.Scanner;
import utility.ScanUtil;

// 윤년 판단...
// Leap year
/*
https://ko.wikipedia.org/wiki/%EC%9C%A4%EB%85%84
 
 윤년 판단 알고리즘 Algorithm
 
그레고리력의 정확한 윤년 규칙은 다음과 같다.

서력 기원 연수가 004로 나누어 떨어지는 해는 윤년으로 한다. (1984년, 1988년, 1992년, 1996년, 2004년, 2008년, 2012년, 2016년, 2020년, 2024년, 2028년, 2032년, 2036년, 2040년, 2044년 ...)
서력 기원 연수가 004, 100으로 나누어 떨어지는 해는 평년으로 한다. (1900년, 2100년, 2200년, 2300년, 2500년...)
서력 기원 연수가 004, 100, 400으로 나누어 떨어지는 해는 윤년으로 둔다. (2000년, 2400년...)

*/

public class YearMain {

	public static final String NONAME = ""; // empty string 빈문자열
	public static final String LEAP_YEAR = "윤년";
	public static final String COMMON_YEAR = "평년";
	public static final String YEAR_INPUT_MSG = "윤년 판단용 년도 입력(1900~2400): ";

	public static void main(String[] args) {
		// 윤년 판단 프로그램
		int c = 0; // counter
		final int LIMIT_YEARS = ScanUtil.userInputToInt(">> 판정한 년도의 개수를 입력(반복회수) :");
		// while(c < LIMIT_YEARS) { // c는 0 ~ 3까지 실행, 4에서 멈춤.
		do {
			c += 1;
			int year = ScanUtil.userInputToIntInRange2("[" + c + " 회차] 윤년 판단용 년도 입력(1900~2400):", 1900, 2400); // 1900~2400
			System.out.printf(">> 해당 %4d년도는 '%c년' 입니다.\n", year, (isLeapYear(year) ? '윤' : '평'));
		} while (c < LIMIT_YEARS); // do~while();
		// }http://www.q-net.or.kr/crf006.do?id=crf00611&gSite=Q&gId=
		System.out.println(" c = " + c);
	}

//	// 스캐너로 정수 입력 받아오는 함수
//	private static int userInputToInt(String msg) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println(msg);
////		sc.close();
//		int year = sc.nextInt();
//		sc.close();
//		return year;
//	}

	// 일반화
	// 정수형 년도를 입력받아 윤년알고리즘 판단 후
	// 윤년이면 true를 평년이면 false를 판단결과로 리턴하는 함수
	public static boolean isLeapYear(int year) {
		boolean bLeap = false; // 평년
		if (year % 4 == 0)
			bLeap = true; // 윤년
		if (year % 100 == 0)
			bLeap = false; // 평년
		if (year % 400 == 0)
			bLeap = true; // 윤년
		return bLeap;
	}

	// 구체화
	// 정수형 년도를 입력받아 윤년알고리즘 판단 후
	// 문자열형 "윤년" 혹은 "평년"으로 리턴하는 함수
	private static String whichYear(int year) {
		String yearName = NONAME;

		if (year % 4 == 0) {
			yearName = LEAP_YEAR;
			// 서력 기원 연수가 004,(and) 100으로 나누어 떨어지는 해는 평년으로 한다.
			if (year % 100 == 0) {
				yearName = COMMON_YEAR;
				// 서력 기원 연수가 004, 100, 400으로 나누어 떨어지는 해는 윤년으로 둔다.
				if (year % 400 == 0)
					yearName = LEAP_YEAR;
				else
					yearName = COMMON_YEAR;
			} else
				yearName = LEAP_YEAR;
		} else {
			yearName = COMMON_YEAR;
		}

		return yearName;
	}

}
