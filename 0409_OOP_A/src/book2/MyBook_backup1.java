package book2;

// 클래스 class 정의 == java에서 클래스란 '새로운 타입'을 만드는 것.
// 		설계도...? 
//     객체지향적인 세상에서... (이 세상은 객체지향인 물리적으론 3차원)  
// 객체 object라는 것은 클래스의 설계대로 객체지향 세상에 만들어진 단위.
// '책'이라는 개념(스키마 Schema)을 클래스로 표현..
//  해당 스키마의 특징들을 클래스에 구성요소 삼아야 함. 
//  책을 떠올리면... 제목, 분야(장르), 저자, 출판사, 쪽수, 가격 (바코드), 표지..
// 클래스는 이런 특징을 개별 변수들로 표현하지 않고, 그 변수들을 하나의 클래스 범위 묶음.
// 여기에 스키마에 처리에 관계된 기능들을 함수로써 해당 클래스 포함해서 구현함.
// 즉, 클래스는 고유 데이터 구성요소(필드,속성property) + 고유 기능 (함수;메소드)들로 표현됨. 
// class = fields + methods
// 변수 구성요소, 상수 구성요소, 함수 구성요소(메소드)
// 클래스는 새로운 타입을 위해 "데이터 + 기능"을 하나로 묶은 설계 도면. (blueprint)
// java에서는 특정 클래스의 객체를 자바 JVM메모리 세상에 태어나게 하기 위해 
// 반드시 new의 과정을 거치며... new 정상으로수행되면 객체로 활동함.

// book2.MyBook 타입 정의   !=  book.MyBook 다름..

// 책스키마 표현 (설계도)
public class MyBook_backup1 {	
	// 데이터 표현 (필드) ------------
	// (공통) 상수 필드
	public static final int DEF_PRICE = 2900; 
	public static final String DEF_GENRE = "소설";
	
	// 변수 필드 (멤버변수) // v1.0
	// public 으로 선언하면 패키지가 다른 클래스들에서도 사용가능함.
	public int no; // 번호 numeric order
	//int no; // 번호 numeric order
	public String bookTitle; // 제목
	public String bookGenre; // 분야(장르)
	public String bookAuthor; // 저자(이름)
	public int bookPages; // 쪽수 (pp)
	public int bookPrice; // 가격 (원)
	// 스키마 변경됨... // v1.1
	public int publisher; // 출판사 (번호)
	public String ISBN; // 바코드/국제표준서적번호(인덱스 13자리..)
	public float rate; // 평점 5점만점 척도 0.0 ~ 5.0
	public String comment; // 코멘트
	
	// 기능 표현 (메소드; 멤버함수)
//	public void printBook() {
//		//String bookTitle;
//		System.out.println("BOOK");
//		System.out.println("\t 제목: " + bookTitle);
//		System.out.println("\t 분야: " + bookGenre);
//		System.out.println("\t 가격(정가제): " + bookPrice +"won");
//		System.out.println("\t 저자: '" + bookAuthor + "'님");
//		System.out.println("\t 쪽수: " + bookPages + "pp");
//		System.out.println("-----------------------------");
//	}
	
	public void printBook() {
		//String bookTitle;
		System.out.println("BOOK " + no);
		System.out.println("\t 제목: " + bookTitle);
		System.out.println("\t 분야: " + bookGenre);
		System.out.println("\t 가격(정가제): " + bookPrice +"won");
		System.out.println("\t 저자: '" + bookAuthor + "'님");
		System.out.println("\t 쪽수: " + bookPages + "pp");
		System.out.println("\t 출판사 번호: " + publisher);
		System.out.println("\t ISBN: " + ISBN);
		System.out.println("\t 평점: " + rate);
		System.out.println("\t 리뷰코멘트: " + comment);
		System.out.println("-----------------------------");
	}
}





