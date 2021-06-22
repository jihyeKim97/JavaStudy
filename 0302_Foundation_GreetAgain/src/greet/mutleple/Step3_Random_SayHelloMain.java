package greet.mutleple;


public class Step3_Random_SayHelloMain {
	
	public static void main(String[] args) {
		  
		 //힘수 호출부
//		 sayGreetingMsgToName("아침 좋아",  "에리어");
//		 sayGreetingMsgToName("점심 좋아",  "모아나");
//		 sayGreetingMsgToName("저녁 좋아",  "백설공주");
//		 sayGreetingMsgToName("새벽 좋아",  "신데렐라");
	 
		 //상수정의 (로컬, 지역상수)
		 //메인함수 안에서만 사용할수 있는 지역상수 (재할당 불가)
		 final String PREFIX = "HAPPY_";
		 final String SAY_A = PREFIX + "좋은 아침";
		 //	final String SAY_A = PREFIX(접두어) + "좋은 아침"; // 접두어가 붙은 상태로 상수 초기화, 정의
		 final String SAY_B = PREFIX + "좋은 점심";
		 final String SAY_C = PREFIX + "좋은 저녁";
		 final String SAY_D = PREFIX + "좋은 새벽";
		 
		 final String TITLE = "공주";
		 
		 // 변수 정의
		 String queen = "에리어";
		 
		 // 인사말 선택
		 
		 // 랜덤성을 적용 하여 선택번호를 입력

		 // double PI = 3.141592;  
		 // int myPi = 3.14; // 소수점을 표현 하는 정수형 타입 = error
		 
		 double ran = Math.random(); //소수점을 표현 할수 있는 실수형 double 타입
		  System.out.println("랜덤 실수(소수점) = "+ ran);
		 // returns a double 
		 // 0.0 ~ 0.xxxxx ~ 0.999xxx범위
		 // 0.0 이상 그리고 1.0미만의 범위의 랜덤한 실수(소수점 있는)가 발생
		 // double 형으로 랜덤 실수를 리턴

		 
		 double ran1 = 0.33225; //소수점을 표현 할수 있는 실수형 double 타입
		 System.out.println("실수(소수점) = "+ ran1);

		 // 랜덤 실수 소수점수를 정수로 변환
		 int ran2 = (int) ((Math.random()*100)/10); // 강제로 데이터의 타입을 변경하는 "type casting(타입 캐스팅)"
		 System.out.println("0~10중에 1개의 난수 발생 = "+ ran2); //0~10중에 1개의 난수 발생
		 
		// 랜덤 실수 소수점수를 정수로 변환
		 int ran3 = (int) ((Math.random()*1000)/10); // 강제로 데이터의 타입을 변경하는 "type casting(타입 캐스팅)"
		 System.out.println("0~100중에 1개의 난수 발생 "+ ran3); //0~100중에 1개의 난수 발생
		 
		 // 랜덤 실수 소수점수를 정수로 변환
		 int ran4 = (int) ((Math.random()*10000)/10); // 강제로 데이터의 타입을 변경하는 "type casting(타입 캐스팅)"
		 System.out.println("0~1000중에 1개의 난수 발생 = "+ ran4); //0~1000중에 1개의 난수 발생
		 
		
		 int seletion = (int)(ran * 4); // 0, 1, 2, 3 => 0~3
		 System.out.println("seletion= "+ seletion);
		 int seletion1 = (int)(ran * 4) + 1; // 0,1, 2, 3 +1 => 1~4
		 System.out.println("seletion1= "+ seletion1);
		 
		 // 분기문(if 조건부분기문)
		 // 선택 범위 (1 - 4)(SAY_A - SAY_D)
		 if(seletion1 == 1 ) {
			 sayGreetingMsgToName(SAY_A,  queen+TITLE);			 
		 }else if(seletion1 == 2 ){
			 queen = "모아나";
			 sayGreetingMsgToName(SAY_B,  queen+TITLE);			 
		 }else if(seletion1 == 3 ) {
			 queen = "백설공주";
			 sayGreetingMsgToName(SAY_C,  queen+TITLE);			 
		 }else if(seletion1 == 4 ) {
			 queen = "신데렐라";
			 sayGreetingMsgToName(SAY_D,  queen+TITLE);			 
		 }else {
			 System.out.println("없는 숫자 입니다");
		 }
		 
	}
	
	//함수 정의부
	private static void sayGreetingMsgToName(String msgGreeting, String toName) {
		
		final String TAB = "\t";
		final String PUNC = "!!";
		final String SEP = "+++++++++++++++++++++++++++";
		final String END = "\r\n";

		System.out.println(msgGreeting + TAB + toName + PUNC);
		System.out.println(SEP);
		System.out.println(END); // ASCII, UNICODE
		
	}
	
}
