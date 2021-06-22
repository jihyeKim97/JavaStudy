package greet.mutleple;


//class A {}
//class B {}
//src에는 파일에는 sayHelloMain.java
//bin에는 파일에는  sayHelloMain.class / a.class / b.class

public class Step1_Justice_SayHelloMain {
	
	public static void main(String[] args) {
//함수화 단계

// 1단계 함수화
		System.out.println("======함수화 1단계======");
		System.out.println("아침 좋아" + "\t" + "에리어" + "!!");
		System.out.println("+++++++++++++++++++++++++++");
		System.out.println("\n"); // ASCII, UNICODE
		
		System.out.println("점심 좋아" + "\t" + "모아나" + "!!");
		System.out.println("+++++++++++++++++++++++++++");
		System.out.println("\n"); // ASCII, UNICODE
		
		System.out.println("저녁 좋아" + "\t" + "백설공주" + "!!");
		System.out.println("+++++++++++++++++++++++++++");
		System.out.println("\n"); // ASCII, UNICODE
		
		System.out.println("세벽 좋아" + "\t" + "신데렐라" + "!!");
		System.out.println("+++++++++++++++++++++++++++");
		System.out.println("\n"); // ASCII, UNICODE
		
		
		
		
		System.out.println("======함수화 2단계======");
//2단계 상수화 (결과에서 변하지 않는 고정 데이터)
		 final String TAB = "\t";
		 final String PUNC = "!!";
		 final String SEP = "+++++++++++++++++++++++++++";
		 final String END = "\r\n";
		
		 System.out.println("아침 좋아" + TAB + "에리어" + PUNC);
		 System.out.println(SEP);
		 System.out.println(END); // ASCII, UNICODE
		 
		 System.out.println("점심 좋아" + TAB + "모아나" + PUNC);
		 System.out.println(SEP);
		 System.out.println(END); // ASCII, UNICODE
		 
		 System.out.println("저녁 좋아" + TAB + "백설공주" + PUNC);
		 System.out.println(SEP);
		 System.out.println(END); // ASCII, UNICODE
		 
		 System.out.println("세벽 좋아" + TAB + "신데렐라" + PUNC);
		 System.out.println(SEP);
		 System.out.println(END); // ASCII, UNICODE

		 
		 
		 
		 System.out.println("======함수화 3단계======");
 //3단계 변수화 적용 (결과에서 매번 실행시 마다 입력으로 들어오는 변하는 데이터)
		 String msgGreeting;
		 String toName;
		 
		msgGreeting = "아침 좋아";
		toName = "에리어";		 
		 System.out.println(msgGreeting + TAB + toName + PUNC);
		 System.out.println(SEP);
		 System.out.println(END); // ASCII, UNICODE
		 
		 msgGreeting = "점심 좋아";
		 toName = "모아나";		 
		 System.out.println(msgGreeting + TAB + toName + PUNC);
		 System.out.println(SEP);
		 System.out.println(END); // ASCII, UNICODE
		 
		 msgGreeting = "저녁 좋아";
		 toName = "백설공주";		 
		 System.out.println(msgGreeting + TAB + toName + PUNC);
		 System.out.println(SEP);
		 System.out.println(END); // ASCII, UNICODE
		 
		 msgGreeting = "세벽 좋아";
		 toName = "신데렐라";		 
		 System.out.println(msgGreeting + TAB + toName + PUNC);
		 System.out.println(SEP);
		 System.out.println(END); // ASCII, UNICODE
		 
 //4단계 함수화 (공통부분의 명령해들을 하나의 독립 기능으로 묶어서 정의
		 //					+ 정의된 함수는 그 이름으로 이후 필요 시마다 호출)
		 System.out.println("======함수화 4단계======");
		 sayGreetingMsgToName("아침 좋아",  "에리어");
		 sayGreetingMsgToName("점심 좋아",  "모아나");
		 sayGreetingMsgToName("저녁 좋아",  "백설공주");
		 sayGreetingMsgToName("새벽 좋아",  "신데렐라");
		 
		 
		
	}
	// 클래스 안에서 독단적으로 사용가능한 함수 = private
	// 클래스 밖에서 자유분방하게 사용가능한 함수 = public
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
