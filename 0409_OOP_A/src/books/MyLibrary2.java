package books;

public class MyLibrary2 {

	public static void main(String[] args) {
//		MyBook book = null; // 새로운 타입 MyBook 클래스형 변수 book 선언.
//		System.out.println(book.toString());
		MyBook book = new MyBook(); 
			// 클래스와 동일한 이름의 함수(생성자함수 constructor)를
			// 반드시  new와 함께 한 번만 실행해서 객체를 만들어야 함. 
			// 만들어진 객체가 book 변수에 기억됨.
		// 객체는 클래스의 형태로 만들어져서 .. 하나의 범위가 됨.
		// 즉, 객체 안의 함수들, 변수들, 상수들은  객체명.OOO로 선택접근가능.
		book.bookTitle = "자바가 제일 쉬워요!"; 
		book.bookAuthor = "제임스 고즐링";
		book.bookGenre = "IT 개발";
		book.bookPages = 500;// pp
		book.bookPrice = 30000; //원
		
		MyBook book2 = new MyBook();// 객체를 태어나게 하기 위해...
			// JVM에 메모리를 확보하고, 이후 데이터를 초기화하여 
			// book2변수에 객체를 기억시킴
		book2.bookAuthor = "루시 모드 몽고메리";		
		book2.bookTitle = "빨강 머리 앤";
		book2.bookGenre = "소설/고전";
		book2.bookPrice = 16800;
		book2.bookPages = 532;		
		
		//book.printBook();
		book2.printBook();
		book.printBook();
		
	}

}
