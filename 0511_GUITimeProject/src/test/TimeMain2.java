package test;

import java.util.Calendar;
import java.util.Date;

public class TimeMain2 {

	public static void main(String[] args) {
		// JVM 시스템 달력 객체를 생성하기
		Calendar cal = Calendar.getInstance();
		//System.out.println(cal);
		Date today = cal.getTime();
		System.out.println(today);
		
		System.out.println("달력 기준 년: " + cal.get(Calendar.YEAR));
		System.out.println("달력 기준 월: " +
				(cal.get(Calendar.MONTH)+1) );
				// 달력에서의 월은 0 ~ 11
		System.out.println("달력 기준 일: " + cal.get(Calendar.DATE)); // DAY_OF_MONTH
		//
		System.out.println("달력 기준 시: " 
				+ cal.get(Calendar.HOUR));
		System.out.println("달력 기준 분: " 
				+ cal.get(Calendar.MINUTE));
		System.out.println("달력 기준 초: " 
				+ cal.get(Calendar.SECOND));
		System.out.println("달력 기준 밀리초: " 
				+ cal.get(Calendar.MILLISECOND) + "ms");
		//
		System.out.println("달력 기준 시중일(24h): " 
				+ cal.get(Calendar.HOUR_OF_DAY));
		System.out.println("달력 기준 AMPM: " 
				+
				(cal.get(Calendar.AM_PM) == Calendar.PM 
						? "오후" : "오전")	); // AM 0, PM 1
		System.out.println("달력 기준 타임존: " 
				+ cal.get(Calendar.ZONE_OFFSET));
		// 32400000 밀리초 => 32400/3600 = 9 
		// (영국 그리니치에서 9시간 시간차) GMT/UTC + 9  
	}

}
/*
java.util.GregorianCalendar[time=1620711583033,
areFieldsSet=true,areAllFieldsSet=true,
lenient=true,
zone=sun.util.calendar.ZoneInfo[
id="Asia/Seoul",offset=32400000,
dstSavings=0,useDaylight=false,transitions=22,
lastRule=null],firstDayOfWeek=1,
minimalDaysInFirstWeek=1,ERA=1,
YEAR=2021,MONTH=4,WEEK_OF_YEAR=20,
WEEK_OF_MONTH=3,DAY_OF_MONTH=11,DAY_OF_YEAR=131,DAY_OF_WEEK=3,DAY_OF_WEEK_IN_MONTH=2,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=39,SECOND=43,MILLISECOND=33,ZONE_OFFSET=32400000,DST_OFFSET=0]


Tue May 11 15:02:50 KST 2021
달력 기준 년: 2021
달력 기준 월: 5
달력 기준 일: 11
달력 기준 시: 3
달력 기준 분: 2
달력 기준 초: 50
달력 기준 밀리초: 77ms
달력 기준 시중일(24h): 15
달력 기준 AMPM: 오후
달력 기준 타임존: 32400000

*/