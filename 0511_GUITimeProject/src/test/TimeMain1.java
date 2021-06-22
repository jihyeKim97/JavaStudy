package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeMain1 {

	public static void main(String[] args) {
		// 날자 , 시간 => 달력
		// 하루? 1 day = 24 x 60 x 60 = 86400 seconds
		// 시간날자는 수치형으로 표현... long형   2^64?
		// 현재 전 세계의 표준 디지털기기의 시간은 
		// epoch time 1970.1.1.0시0분0초0밀리에 기준을 둠.
		
		// 완전한정이름 FQN
		java.util.Date today1 = new java.util.Date();
		Date today2 = new Date();
		System.out.println(today1.toString());
			// Tue May 11 14:16:29 KST 2021		
		System.out.println(today2);
	
		// KST => Korean Standard Time? GMT/UTC + 9 위도/경도차...
		// 타임존 (TimeZone) => 시간축경도 위치편차 (로케일, 지역시간 정보)
		// 서울/동경시  =>  8.5시?
		// 표준 시간서버에 맞춰진 OS의 구동중인 JVM이 얻어낸 시간데이터.
		
		System.out.println("long형 시간 수치값: " + today2.getTime()
				+ "ms"); // mile초 1/1000초
		
		// 표준 서식화한 long형 시간의 다른 출력?
		DateFormat df = DateFormat.getDateInstance();
		System.out.println(df.format(today2));
		// 커스텀 서식화
		SimpleDateFormat sdf = 
				new SimpleDateFormat("G yyyy년 MM월 dd일 HH:mm:ss z");
			// G era 세기, z 타임존
		System.out.println(sdf.format(today2));
		// sdf.format() <=> sdf.parse()
	}

}

/*
Tue May 11 14:35:00 KST 2021
Tue May 11 14:35:00 KST 2021
long형 시간 수치값: 1620711300802ms
2021. 5. 11
서기 2021년 05월 11일 14:35:00 KST
*/ 
