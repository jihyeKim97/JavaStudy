package greet.mutleple;


public class Step5_Retrun_SayHelloMain {
	
	public static void main(String[] args) {
		
		/*함수 호출부*/
		
		int seletion = (int)(Math.random() * 4)+1;  //1~4
		System.out.println("1~4까지의 랜덤 숫자는 = "+seletion+"\t"+ pickAndReturnMessage(seletion));
	
		System.out.println( pickAndRetrunMessageRandemly());
		
	}
	
	
/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/	
	
	/*함수 정의부*/	
	
	//함수 안에서 랜덤으로 숫자를 추출하여 그에 맞는 텍스트를 찍어내는 함수
	private static String pickAndRetrunMessageRandemly() {
		
		int seletion = (int)(Math.random() * 4)+1;  //1~4
		//	System.out.println("seletion = "+ seletion);
		
		final String PREFIX = "HAPPY_";
		final String SAY_A = PREFIX + "좋은 아침";
		final String SAY_B = PREFIX + "좋은 점심";
		final String SAY_C = PREFIX + "좋은 저녁";
		final String SAY_D = PREFIX + "좋은 새벽";
		
		if(seletion == 1 ) { return SAY_A; }
		else if(seletion == 2 ) { return SAY_B; }
		else if(seletion == 3 ) { return SAY_C; }
		else if(seletion == 4 ) { return SAY_D; }
		else { return "none"; }
		
	}
	
	
	// 문자열을 반환하는 리턴 함수 (String)	
	//리턴값 = 문자열로 반환
	// 함수 실행(호출) 결과로 문자열 데이터 리턴 
	private static String  pickAndReturnMessage(int seletion) {
		
		final String PREFIX = "HAPPY_";
		final String SAY_A = PREFIX + "좋은 아침";
		final String SAY_B = PREFIX + "좋은 점심";
		final String SAY_C = PREFIX + "좋은 저녁";
		final String SAY_D = PREFIX + "좋은 새벽";
		
		String retMsg = "";
		if(seletion == 1 ) { retMsg = SAY_A; }
		if(seletion == 2 ) { retMsg = SAY_B; }
		if(seletion == 3 ) { retMsg = SAY_C; }
		if(seletion == 4 ) { retMsg = SAY_D; } 
		
		return retMsg; // 함수는 return을 만나면 바로 종료
		
	}
	
	
	
	//함수 안에서 랜덤으로 숫자를 추출하여 그에 맞는 텍스트를 찍어내는 함수
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
	
	
	
	// 함수에 원하는 숫자를 넣어 찍어내는 함수
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
	
	
	
	//형식에 맞는 함수를 찍어내는 함수
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
