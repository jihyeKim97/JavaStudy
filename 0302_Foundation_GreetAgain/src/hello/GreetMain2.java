package hello;

public class GreetMain2 {

	public static void main(String[] args) {
//		String GREET_MSG1 = ""; // 빈 문자열 
		String GREET_MSG1 = "안녕??";  // 변수 선언과 동시에 데이터 할당 => 초기화
		
		// 자바에게 변수사용할 공간을 할당 해달라고 요청
		String GREET_MSG2; 
		//변수 선언(저장공간 준비하라고 알려줌)
		GREET_MSG2 = "안녕 하세요"; //선언과 분리되어 두개의 문장으로 초기화
		
		String person1 = "엘사";
		String person2 = "안나";
		System.out.println(GREET_MSG1 + " " + person1);
		
		person1 = person1 + "~!!!"; // 변수 person1이 재할당이 되어 "엘사~!!!" (변수값 새롭게 재할당(갱신))
		// = 할당 기호 오른편의 person1 변수는 아직 갱신 전의 "엘사" 데이터를 가진 변수 임
		person2 = "princess!" + person2;
		System.out.println(GREET_MSG1 + " " + person1);
		System.out.println(GREET_MSG1 + " " + person2);

		person2 = person2 + "공주";
		System.out.println(GREET_MSG1 + " " + person2);
		// person1 = person1;
		// 할당 기호가 있으면 오른쪽에 있는 변수가 왼쪽에 적용 된다
		// System.out.println(GREET_MSG1 + " " + "홍홍홍");
		
		
	}

}
