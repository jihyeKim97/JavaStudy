package logic;

/* 캘린더/ 달력

지구가 태양을 한 바퀴 도는 데에는 365일 5시간 48분 46초가 걸리므로...

태양력의 윤년
현재 전 세계 대부분의 나라에서 쓰는 그레고리력은 4년에 반드시 하루씩 윤날(2월 29일)을 추가하는 율리우스력을 보완한 것으로, 태양년과의 편차를 줄이기 위해 율리우스력의 400년에서 3일(세 번의 윤년)을 뺐다.

그레고리력의 정확한 윤년 규칙은 다음과 같다.

서력 기원 연수가 4로 나누어 떨어지는 해는 윤년으로 한다. (1988년, 1992년, 1996년, 2004년, 2008년, 2012년, 2016년, 2020년, 2024년, 2028년, 2032년, 2036년, 2040년, 2044년 ...)
서력 기원 연수가 4, 100으로 나누어 떨어지는 해는 평년으로 한다. (1700년, 1800년, 1900년, 2100년, 2200년, 2300년...)
서력 기원 연수가 4, 100, 400으로 나누어 떨어지는 해는 윤년으로 둔다. (1600년, 2000년, 2400년...)
즉, 400년에 97년은 윤년이 되며, 1년은 평균 365.2425일이 된다. 이는 춘분점을 기준으로 한 태양년보다 0.0003일(26초)이 길기 때문에, 약 3,300년마다 1일의 편차가 난다.

윤년 계산법
개정 내용은 다음과 같다.

1582년 10월 4일(목) 다음날을 1582년 10월 15일(금)로 한다.(위에서 설명한 열흘의 편차를 제거함)[6]
4의 배수인 해를 윤년으로 한다. 그러나 100으로 나눌 수 있지만 400으로 나뉘어 떨어지지 않는 해는 예외로 평년으로 한다.[6]
그레고리력은 1년을 365.2425일로 보아 율리우스력의 400년에서 3일을 빼야 했고, 이를 위해 400년에서 3번의 윤년을 제외시키는 방법을 썼다. 즉, 율리우스력의 윤년 중에서 100으로 나누어 떨어지는 해는 평년으로 하되, 그 중 400으로 나누어 떨어지는 해는 윤년으로 두었다(예: 1700년, 1800년, 1900년, 2100년, 2200년, 2300년은 윤년에 해당되지 않지만, 1600년, 2000년, 2400년은 윤년이다).  
  
 * */

public class MyCalendar2 {

	public static void main(String[] args) {
//		showMyCal(2020, 2);
//		showMyCal(2021, 12);
		int year = 2021;
		for (int month = 1; month <= 12; month++) {
			showMyCal(year, month);
		}
	}
	
	public static void showMyCal(int year, int month) {
		// 그레고리안 역법을 달력으로 표현 (논리상의 달력)
		// 년도의 범위 1582. 10/4 목 => 10/15 금 (10일치 날자가 사라짐)
		// 1583년부터 정상 년도 입력...
		// 입력 : 년도, 월  
//		int year = 2020; //2021;
//		int month = 2; //5; // => 5/1 날자의 요일만 끝나는 문제.
		// 서기력의 총 일수, 각 월별 (총)일수, 요일(각 월의 시작1일의 요일),
		// + 그레고리안 칙령 달력을 표현(윤년판단) 
		
		int totalDays = 0; // 2021. 5. 1일까지의 총 일수합...
		
		// 서기 1 ~ 서기 2020 년도별 총 일수 계산 (2021의 전년도/작년까지의 총일수 합)
		for (int y = 1; y < year; y++) {
			if( y % 400 == 0 ) totalDays += 366; // 윤년
			else if( y % 100 == 0 ) totalDays += 365;// 평년
			else if( y % 4 == 0 ) totalDays += 366; // 윤년
			else totalDays += 365;// 평년
		} // 2020.12.31까지의 모든 일수 합...
		
		// 타켓연도 2021의 윤년판단
		boolean bLeap = false;// 평년
		if( year % 400 == 0 ) bLeap = true; // 윤년
		else if( year % 100 == 0 ) bLeap = false;// 평년
		else if( year % 4 == 0 ) bLeap = true; // 윤년
		else bLeap = false;// 평년
		
		// 타켓연도의 타켓월 전월까지의 총 일수 합 구하기 (2월 윤년유무 29일/28일?)
		// 쥴리어스력
		int daysInMonth[] = {
			0, 31, bLeap ? 29 : 28, 31, 30, 31, 30,
			31, 31, 30, 31, 30, 31
		};
		for (int m = 1; m < month; m++) {
			totalDays += daysInMonth[m];
		} // 4.30까지..
		
		// 타켓년타켓월의 1일을 추가
		totalDays++; // 5.1
		// 서양력은 일요일부터 시작하는 달력으로 만들어야함.
		// 0을 일요일, 1을 월요일 ~ 6 토요일  // 일주일 7일로 나눈 나머지가 요일 순서번호.
		// 0 ~ 6 월 ~ 토
		int yoil = totalDays % 7; 
//		System.out.println("yoil => " + yoil); // 6
		
		// 텍스트 모드 월단위 달력 출력 (고정 가로폭 폰트 fixed width)
		System.out.println("MyCalendar: ");
		System.out.println( year + "년 " + month + "월");
		// 하루 날자칸을 스페이스바4개의 칸으로 가정.
		System.out.println("============================"); // 28
		System.out.println(" SUN MON TUE WED THU FRI SAT"); // 요일 컬럼 헤더
		System.out.println("============================"); // 28
		
		// 요일공백 보정 출력
		final String SPC = "    ";
		for (int i = 0; i < yoil; i++) {
			System.out.print(SPC); // 공백 4칸을 각 요일마다 출력
		}
		
		// 요일별 날자 주단위 출력
		for (int day = 1; day <= daysInMonth[month]; day++) {
//			System.out.printf("%4d", day);
			System.out.printf(" %2d ", day);
			// 토요일마다 한 주가 끝나서 개행
			if( (day+yoil) % 7 == 0 )
				System.out.println();
		}
		System.out.println();
		System.out.println("============================"); // 28
	}

}

/*
MyCalendar: 
2021년 1월
============================
 SUN MON TUE WED THU FRI SAT
============================
                      1   2 
  3   4   5   6   7   8   9 
 10  11  12  13  14  15  16 
 17  18  19  20  21  22  23 
 24  25  26  27  28  29  30 
 31 
============================
MyCalendar: 
2021년 2월
============================
 SUN MON TUE WED THU FRI SAT
============================
      1   2   3   4   5   6 
  7   8   9  10  11  12  13 
 14  15  16  17  18  19  20 
 21  22  23  24  25  26  27 
 28 
============================
MyCalendar: 
2021년 3월
============================
 SUN MON TUE WED THU FRI SAT
============================
      1   2   3   4   5   6 
  7   8   9  10  11  12  13 
 14  15  16  17  18  19  20 
 21  22  23  24  25  26  27 
 28  29  30  31 
============================
MyCalendar: 
2021년 4월
============================
 SUN MON TUE WED THU FRI SAT
============================
                  1   2   3 
  4   5   6   7   8   9  10 
 11  12  13  14  15  16  17 
 18  19  20  21  22  23  24 
 25  26  27  28  29  30 
============================
MyCalendar: 
2021년 5월
============================
 SUN MON TUE WED THU FRI SAT
============================
                          1 
  2   3   4   5   6   7   8 
  9  10  11  12  13  14  15 
 16  17  18  19  20  21  22 
 23  24  25  26  27  28  29 
 30  31 
============================
MyCalendar: 
2021년 6월
============================
 SUN MON TUE WED THU FRI SAT
============================
          1   2   3   4   5 
  6   7   8   9  10  11  12 
 13  14  15  16  17  18  19 
 20  21  22  23  24  25  26 
 27  28  29  30 
============================
MyCalendar: 
2021년 7월
============================
 SUN MON TUE WED THU FRI SAT
============================
                  1   2   3 
  4   5   6   7   8   9  10 
 11  12  13  14  15  16  17 
 18  19  20  21  22  23  24 
 25  26  27  28  29  30  31 

============================
MyCalendar: 
2021년 8월
============================
 SUN MON TUE WED THU FRI SAT
============================
  1   2   3   4   5   6   7 
  8   9  10  11  12  13  14 
 15  16  17  18  19  20  21 
 22  23  24  25  26  27  28 
 29  30  31 
============================
MyCalendar: 
2021년 9월
============================
 SUN MON TUE WED THU FRI SAT
============================
              1   2   3   4 
  5   6   7   8   9  10  11 
 12  13  14  15  16  17  18 
 19  20  21  22  23  24  25 
 26  27  28  29  30 
============================
MyCalendar: 
2021년 10월
============================
 SUN MON TUE WED THU FRI SAT
============================
                      1   2 
  3   4   5   6   7   8   9 
 10  11  12  13  14  15  16 
 17  18  19  20  21  22  23 
 24  25  26  27  28  29  30 
 31 
============================
MyCalendar: 
2021년 11월
============================
 SUN MON TUE WED THU FRI SAT
============================
      1   2   3   4   5   6 
  7   8   9  10  11  12  13 
 14  15  16  17  18  19  20 
 21  22  23  24  25  26  27 
 28  29  30 
============================
MyCalendar: 
2021년 12월
============================
 SUN MON TUE WED THU FRI SAT
============================
              1   2   3   4 
  5   6   7   8   9  10  11 
 12  13  14  15  16  17  18 
 19  20  21  22  23  24  25 
 26  27  28  29  30  31 
============================
 
 */
