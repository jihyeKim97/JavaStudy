package book2;

public class MyLibrary4 {

	public static void main(String[] args) {
		MyBook book4 = new MyBook("안녕 앤 - 앤이 어렸을 적에..", 
				"버지 윌슨", "소설/고전",
				300, 20000, 2,
				0, 4.89f, "987654321222", 
				"어린 적의 추억이 새록새록 하네요!!"); // 생성과 동시 초기화
//		book4.init("안녕 앤 - 앤이 어렸을 적에..", 
//				"버지 윌슨", "소설/고전",
//				300, 20000, 2,
//				0, 4.89f, "987654321222", 
//				"어린 적의 추억이 새록새록 하네요!!");
		book4.printBook(); // 객체 출력
		
		MyBook book5 = new MyBook(); // 객체 생성
		book5.init("날씨 이야기",   // 초기화 별도 실행
				"날씨소년", "환경/기상",
				100, 14900, 3,
				1, 1.32f, "987654321333", 
				"날씨가 전혀 안 맞아요 TT");
		book5.printBook(); // 객체 출력
		
		MyBook book6 = new MyBook(); // 각 필드값이 초기화? 
		book6.printBook();
	}

}
