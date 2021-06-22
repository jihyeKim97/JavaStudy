package greet.mutleple;


public class Step4_Function_SayHelloMain {
	
	public static void main(String[] args) {
		
		int seletion = (int)(Math.random() * 4)+1;  //1~4
		
		//	pickAndShowMessage(seletion);
		pickAndShowMessageRandemly();
		pickAndShowMessageRandemly();
		pickAndShowMessageRandemly();
		pickAndShowMessageRandemly();
		pickAndShowMessageRandemly();
	 
	}
	
	private static void pickAndShowMessage(int seletion) {
		
		final String PREFIX = "HAPPY_";
		final String SAY_A = PREFIX + "좋은 아침";
		final String SAY_B = PREFIX + "좋은 점심";
		final String SAY_C = PREFIX + "좋은 저녁";
		final String SAY_D = PREFIX + "좋은 새벽";
		final String TITLE = "공주";
		String queen = "에리어";

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
	private static void pickAndShowMessageRandemly() {
		
		int seletion = (int)(Math.random() * 4)+1;  //1~4
		System.out.println("seletion = "+ seletion);
	
		final String PREFIX = "HAPPY_";
		final String SAY_A = PREFIX + "좋은 아침";
		final String SAY_B = PREFIX + "좋은 점심";
		final String SAY_C = PREFIX + "좋은 저녁";
		final String SAY_D = PREFIX + "좋은 새벽";
		final String TITLE = "공주";
		String queen = "에리어";
		
		
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
