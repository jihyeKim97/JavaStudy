package greet.mutleple;


public class Step2_Constant_SayHelloMain {
	
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
		 
		 //인사말 선택
		 int seletion =2; //SAY_A
		 
		 // 선택 범위 (1 - 4)(SAY_A - SAY_D)
		 // 분기문(if 조건부분기문)
		 if(seletion == 1 ) {
			 sayGreetingMsgToName(SAY_A,  queen+TITLE);			 
		 }else if(seletion == 2 ){
			 queen = "모아나";
			 sayGreetingMsgToName(SAY_B,  queen+TITLE);			 
		 }else if(seletion == 3 ) {
			 queen = "백설공주";
			 sayGreetingMsgToName(SAY_C,  queen+TITLE);			 
		 }else if(seletion == 4 ) {
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
