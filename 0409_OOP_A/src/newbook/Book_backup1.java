package newbook;
// 도서관 도서관리 프로젝트
// 요구사항정의문서 SRS: SW 제품(프로젝트)에 필요한 모든 내용을 기술한 기획서...
// 스토리에 등장하는 모든 개념들 중에서...  주요 기능을 분석하고, 
// 여기에 필요한 모든 개념들을 스키마(Schema)로 표현하고 이를 개별 클래스로 구현.

// '책'이라는 개념(스키마)은 복합적인 '속성'들로 구성됨.
// 제목, 저자, 출판사, 가격, 커버이미지, 출간/발행년도, 쪽수, ISBN, 장르, ..
// + 관리번호(입고순서), 평점, 코멘트(리뷰), 이력관리..

// 클래스는 새로운 타입 (설계도), 
// 클래스 = 데이터(필드=상수/변수) + 기능(함수;메소드)
public class Book_backup1 {
	// 제목, 저자, 출판사, 가격, 커버이미지, 출간/발행년도, 쪽수, ISBN, 장르, ..
	// + 관리번호(입고순서), 평점, 코멘트(리뷰), 이력관리..
	
	// 상수 필드
	public static final String NO_TITLE = "제목없음";
	public static final String NO_AUTHOR = "저자없음";
	public static final int DEF_PUB = 0 ; //국영 출판사?
	public static final String DUMMY_COVER = "default/dummy.png";
	public static final String DUMMY_ISBN = "9876543210123";
	public static final String NO_COMMENT = "댓글없음"; //"";
	// 변수 필드
	public String title; // 제목
	public String author; // 저자
//	public String publisher; // 출판사명?
	public int publisher; // 출판사등록번호?
//	public int price; // 가격
	//public Image cover; // 책표지사진? png, jpg, 
	public String imgPath; // 책표지 커버이미지 파일의 파일명/경로명 문자열
	public String ISBN; // 바코드
	// 
	public int no;// 관리번호(입고순서) 0 자동초기화
	public float rate; // 평점 (5점 척도?) 0.0f 자동초기화
	public String comment; // 코멘트(리뷰)
	
	// 생성자들
	// 생성자함수(클래스동일명; constructor) 
	// => new를 통해 만들어지는 객체의 초기화를 담당.
	// => 리턴형이 없이... 객체를 만들고나서 초기화도 끝내고나서.. 
	//    그 정상 객체의 메모리상의 위치정보(주소 address; 힙heap공간)를 리턴함.
	
	// 기본생성자(더미생성자) -- 자동으로 정의되는 생성자함수
//	public Book() {} // 기본생성자는 (클래스내 생성자가 하나도 없을 때 생략가능)
	public Book_backup1() {} // 각 변수필드들은 자신의 타입의 기본값으로 자동초기화..

	// 중간 생성자 (필드들의 일부만 가지고 객체를 우선 만들기)
	public Book_backup1(String atitle, String aauthor,int apublisher) {
		title = atitle;
		author = aauthor;
		publisher = apublisher;
//		imgPath = null; // 생략 시 자동초기화됨.
//		ISBN = null; // 자동초기화됨.
//		no = 0; // 자동초기화됨.
//		rate = 0.0f; // 자동초기화됨.
//		comment = null;// 자동초기화됨.
	}	
	
	public Book_backup1(int no, String atitle, String aauthor,
			int apublisher) {
		title = atitle;
		author = aauthor;
		publisher = apublisher;
		// 객체필드변수 = 지역변수(인자)
		// this.필드변수 = 지역변수(인자)
//		imgPath = null; // 자동초기화됨.
//		ISBN = null; // 자동초기화됨.
		// no = no;  // ?? 		
		this.no = no;  // OK 자신에게 속한 no 변수 필드에 인자 no를 할당.
		// this는 객체 자신의 주소 (자기자신) ==> 이름공간을 구별.
//		rate = 0.0f; // 자동초기화됨.
//		comment = null;// 자동초기화됨.
	}	
	
	
	
	// 풀 생성자 (모든 필드 초기화 가능)
	public Book_backup1(String atitle, String aauthor,int apublisher, 
			String aimgPath, String aISBN, int ano, 
			float arate, String acomment )
	{
		title = atitle;
		author = aauthor;
		publisher = apublisher;
		imgPath = aimgPath;
		ISBN = aISBN;
		no = ano;
		rate = arate;
		comment = acomment;
	}
	
	
	// 메소드들
	public void printBook() {
		//System.out.println("도서관 책: #BK0000" + no);
		System.out.printf("도서관 책: #BK-%06d \n", no);
		System.out.println("제목: " + title);
		System.out.println("\t\t\t\t" + this.author +" 지음");
		System.out.println("\t출판사: " + this.publisher );
		System.out.println("\t커버표지: " + imgPath );
		System.out.println("\tISBN: " + this.ISBN );
		System.out.printf("\t\t 평점: %.2f pt \n", this.rate);
		System.out.printf("\t\t 리뷰: %s \n", comment);
		System.out.println("-----------------------------");

	}
}


