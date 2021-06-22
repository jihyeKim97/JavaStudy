package inherit;
// 도서관 도서관리 프로젝트
// 요구사항정의문서 SRS: SW 제품(프로젝트)에 필요한 모든 내용을 기술한 기획서...
// 스토리에 등장하는 모든 개념들 중에서...  주요 기능을 분석하고, 
// 여기에 필요한 모든 개념들을 스키마(Schema)로 표현하고 이를 개별 클래스로 구현.

// '책'이라는 개념(스키마)은 복합적인 '속성'들로 구성됨.
// 제목, 저자, 출판사, 가격, 커버이미지, 출간/발행년도, 쪽수, ISBN, 장르, ..
// + 관리번호(입고순서), 평점, 코멘트(리뷰), 이력관리..

// 클래스는 새로운 타입 (설계도), 
// 클래스 = 데이터(필드=상수/변수) + 기능(함수;메소드)
public class Book {
	// 제목, 저자, 출판사, 가격, 커버이미지, 출간/발행년도, 쪽수, ISBN, 장르, ..
	// + 관리번호(입고순서), 평점, 코멘트(리뷰), 이력관리..
	
	// 상수 필드 (클래스에 속한 공통 상수)
	public static final String NO_TITLE = "제목없음";
	public static final String NO_AUTHOR = "저자없음";
	public static final int DEF_PUB = 0 ; //국영 출판사?
	public static final String DUMMY_COVER = "default/dummy.png";
	public static final String DUMMY_ISBN = "9876543210123";
	public static final String NO_COMMENT = "댓글없음"; //"";
	//
	public static final String[] PUB_NAMES = {
		"국영출판사", "재욱도서", "고전문학사", 
		"길벗출판", "생능출판사"   // 0 ~ 4
		, "일본문화사"
	}; // publisher는 PUB_NAMES의 순서번호..
	
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
	
	// 도서관에 입고 처리된 상태 필드
	public boolean stamp; // false 입고 전, true 도장이 찍혀서 입고 완료
	
	// 생성자들
	// 생성자함수(클래스동일명; constructor) 
	// => new를 통해 만들어지는 객체의 초기화를 담당.
	// => 리턴형이 없이... 객체를 만들고나서 초기화도 끝내고나서.. 
	//    그 정상 객체의 메모리상의 위치정보(주소 address; 힙heap공간)를 리턴함.
	
	// 기본생성자(더미생성자) -- 자동으로 정의되는 생성자함수
//	public Book() {} // 기본생성자는 (클래스내 생성자가 하나도 없을 때 생략가능)
	public Book() {} // 각 변수필드들은 자신의 타입의 기본값으로 자동초기화..

	// 중간 생성자 (필드들의 일부만 가지고 객체를 우선 만들기)
	
	public Book(String title, String author ) {
		this.title = title;
		this.author = author; 
		this.comment = Book.NO_COMMENT;
		this.imgPath = DUMMY_COVER; // Book.DUMMY_COVER;
		publisher = DEF_PUB;
		this.no = 0; // ?
		this.rate = 0.0f;
		this.ISBN = DUMMY_ISBN;
	}
	public Book(String atitle, String aauthor,int apublisher) {
		title = atitle;
		author = aauthor;
		publisher = apublisher;
//		imgPath = null; // 생략 시 자동초기화됨.
//		ISBN = null; // 자동초기화됨.
//		no = 0; // 자동초기화됨.
//		rate = 0.0f; // 자동초기화됨.
//		comment = null;// 자동초기화됨.
	}	
	
	public Book(int no, String atitle, String aauthor,
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
	
	
	
	// old 풀 생성자 (모든 필드 초기화 가능)
	public Book(String atitle, String aauthor,int apublisher, 
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
		//this.stamp = false; // 자동초기화
	}
	
	
	
	
	// 메소드들
	// 평점 필드 변경 기능  (평점 처리)
	// 0.0~5.0 범위 제한?
//	public void changeRate(float rate) {
//		this.rate = rate; 
//	}
	//public void changeRate(float rate) {
	
	// 입고 스탬프용 풀 생성자
	public Book(String title, String author, int publisher, String imgPath, String iSBN, int no, float rate,
			String comment, boolean stamp) {
//		super();
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.imgPath = imgPath;
		ISBN = iSBN;
		this.no = no;
		this.rate = rate;
		this.comment = comment;
		this.stamp = stamp;
	}
	
	// 입고 유무만 판단하여 출력하고 그 상태도 리턴해주는 함수
	public boolean isBookRegister() {
//		if( stamp == true ) {
//			System.out.println(this.title +" 책은 입고 되었습니다.");
//			//return stamp; //return true;
//		} else {
//			System.out.println(this.title +" 책은 입고 전 입니다.");
//			//return stamp; //return false;
//		}
		System.out.println( this.title +" 책은 " +
			(stamp ? " 입고 되었습니다." : " 입고 전 입니다.")
		);
		return stamp;
	}

	// 임의 안전한 범위의 평점으로 재설정
	public boolean changeRate(float rate) {
		if( rate >= 0.0f && rate <= 5.0f ) {			
			this.rate = rate; 
			System.out.println(
			">> 도서 [" + this.title + "]의  평점이 "
			+ this.rate +"으로 변경되었습니다."	);
			return true;
		} else {
			System.out.println(
				">> 평점 범위 벗어난 에러: " + rate);
			return false;
		}
	}
	
	// 기존 평점 1.0, 0.5, 0.1... 단위만큼 올리기? // 상한, 하한
	public static final float RATE_UNIT = .5f; //.1f; //1.0f;
	
	public void increaseRate() { 
		if( this.changeRate(this.rate + RATE_UNIT) == false ) 			
			this.rate = 5.0f;
	}
	
	public void decreaseRate() {
		//if( this.changeRate(this.rate - RATE_UNIT) != true ) 			
		if( !changeRate(rate - RATE_UNIT) )	rate = 0.0f;
	}
	
	// 실수값의 평점 rate을 그래픽요소인 별표시로 출력하기 
	// ***** => ☆ ★    // ㅁ + 한자키로 찾아서..
	// 0.0 ~ 5.0 => rate을 6구간 대응 
	// ☆☆☆☆☆ 0.0 <= ~ < 0.5 반올림 기준?? (정하기 나름..)
	// ★☆☆☆☆ 0.5 <= ~ < 1.5 (1.4xxxx)
	// ★★☆☆☆ 1.5 <= ~ < 2.5 
	// ★★★☆☆ 2.5 <= ~ < 3.5
	// ★★★★☆ 3.5 <= ~ < 4.5
	// ★★★★★ 4.5 <= ~ <= 5.0
	// private은 클래스 내부에서만 오직 접근, 사용이 됨. (보여짐)
	//private String getStarRating() {
	public String getStarRating() { // 보여짐.
		String stars = new String(""); //"";
		final String RSTARS[] = {  // 0 ~ 5
				"☆☆☆☆☆", "★☆☆☆☆", "★★☆☆☆", 
				"★★★☆☆", "★★★★☆", "★★★★★"
		}; // 배열인덱스 선택으로 switch/case 분기를 대체하자.
		int starIndex = Math.round(rate);  // 반올림
		stars = RSTARS[starIndex];		
		return "<<"+stars+">>";
	}		
	
	
	private String getStarRating3() {
		String stars = new String(""); //"";
		int starIndex = Math.round(rate);  // 반올림
		// 0.0 ~ 5.0  
		// ==> 0 ~ 5  :  0, 1, 2, 3, 4, 5 여섯가지
		// 구간분리 체크
		switch (starIndex) {
			case 0: stars = "☆☆☆☆☆"; break;
			case 1: stars = "★☆☆☆☆"; break;
			case 2: stars = "★★☆☆☆"; break;
			case 3: stars = "★★★☆☆"; break;
			case 4: stars = "★★★★☆"; break;
			case 5: stars = "★★★★★"; break; 
				// case별 숫자가 검은별(채워진 별의 개수)
			default: stars = "error"; 
		}	
		
		return "["+stars+"]";
	}
	
	private String getStarRating2() {
		String stars = new String(""); //"";
		// 범위 체크...
		if( rate >= 0.0f && this.rate < 0.5f )
			stars = "☆☆☆☆☆";
		else if( rate >= 0.5f && this.rate < 1.5f )
			stars = "★☆☆☆☆";
		else if( this.rate < 2.5f )
			stars = "★★☆☆☆";
		else if( this.rate < 3.5f )
			stars =	"★★★☆☆";
		else if( this.rate < 4.5f )
			stars = "★★★★☆";
		else if( this.rate <= 5.0f )
			stars = "★★★★★";
		else 
			stars = "error";
		
		return stars;
	}
	
//	public void increaseRate() {
//		//this.rate = this.rate + RATE_UNIT; // 위험
//		float tempRate = this.rate + RATE_UNIT;
//		if( tempRate > 5.0f ) {
//			System.out.println(">> 점수  MAX 벗어남! 5.0상한처리");
//			this.rate = 5.0f;
//		} else
//			this.rate = tempRate;
//	}
//	
//	// 기존 평점 1.0 내리기? 
//	public void decreaseRate() {
////		this.rate -= RATE_UNIT;
//		float tempRate = this.rate - RATE_UNIT;
//		if( tempRate < 0.0f ) { // 하한 비교
//			System.out.println(">> 점수  MIN 벗어남! 0.0하한처리");
//			this.rate = 0.0f;
//		} else
//			this.rate = tempRate;		
//	}
	
	// 책 객체 내용 출력?
	public void printBook() {
		//System.out.println("도서관 책: #BK0000" + no);
		System.out.printf("도서관 책: #BK-%06d \n", no);
		System.out.println("제목: " + title);
		System.out.println("\t\t\t\t" + this.author +" 지음");
		//System.out.println("\t출판사: " + this.publisher );
		//System.out.println("\t출판사: " + PUB_NAMES[publisher] );		
		System.out.println("\t출판사: " +  
			( publisher >= 0 && publisher < PUB_NAMES.length ?
					PUB_NAMES[publisher] : "출판사모름") );
		
		System.out.println("\t커버표지: " + imgPath );
		System.out.println("\tISBN: " + this.ISBN );		
		//System.out.printf("\t\t 평점: %.2f pt \n", this.rate);
		String stars = this.getStarRating();
		System.out.printf("\t\t 평점: (%s) %.2f/5.0 pt \n", 
				stars, this.rate);
		
		System.out.printf("\t\t 리뷰: %s \n", comment);
		System.out.println("-----------------------------");

	}
}


