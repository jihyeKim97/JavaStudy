package greet;

// 패키지  = 폴더 (namespace) 
// 프로젝트폴더 /src/greet/HelloMain.java 소스파일
// greet.HelloMain 클래스 타입명



//public class HelloMain {}  클래스 정의 된 거임

//클래스
public class HelloMain {
	
	//Main함수
	public static void main(String[] args) {
		
		System.out.println("음악가 인사 하기 프로그램");
		String who1 = "조수미";
		String who2 = "바흐";
		String who3 = "헨댈";
		String who4 = "신사임당";

		final String MSG = "안녕?"; // 상수 선언가 동시에 정의 
	
		sayHelloMusician("베토밴", "모짜르트는 뭐냐 치즈 이름이냐?");
		sayHelloMusician("모짜르트", "지가 베트맨인줄 아나보네");
		sayHelloMusician(who3, "ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ");
		sayHelloMusician(who1, "지금 내가 대세야");
		sayHelloMusician(who2, "뭐래 말라깽이 꺼져");
		
		sayHelloMusician2(who1, MSG, true);
		sayHelloMusician2(who2, MSG, false);
		sayHelloMusician2(who3, MSG, false);
		sayHelloMusician2(who4, MSG, false);
		
		
	
		 for (int i = 1; i <=5; i++) {
			for (int j = 1; j <= 5-i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k <= i*2-1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		 
		 for (int i = 5; i >=1; i--) {
			for (int j = 0; j < 5-i; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= i*2-1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	
	}
	
	public static void sayHelloMusician(String name, String msg) {
		
		
		System.out.println("++++++++++++++++++++++++++++++");
		System.out.println(name +"님"+" : "+"\t"+ msg);
		System.out.println("++++++++++++++++++++++++++++++");
		System.out.println(); //개행 문자 포함 "\n"
		
	}//sayHelloMusician() end
	
	//gender 성별 , 여성 남성인지 표현
	//isFemale 입력 변수가 t이면, 여성 음악가로 설정 ,f일때 남성 음악가로 설정
	public static void sayHelloMusician2(String name, String msg, boolean isFemale) {
		//boolean 부을대수(T/F만 존재)
		
		//if 조건부분기분- 조건식 결과에 따라 문장을 분기하여 수여
		if(isFemale){
			System.out.println(name +"양"+" : "+"\t"+ msg); //T			
		}else {
			System.out.println(name +"군"+" : "+"\t"+ msg); //F
		}
		
		System.out.println("++++++++++++++++++++++++++++++");
		System.out.println(); //개행 문자 포함 "\n"
		
		
	}//sayHelloMusician2() end
	
	
	
	
	

}
