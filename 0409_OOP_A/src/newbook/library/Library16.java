package newbook.library;
import newbook.human.Librarian;
import newbook.Book;
import java.util.Date;
import newbook.library.tools.Bookshelf;

public class Library16 {
	
	// 도서를 사서가 도서관 책장에 입고처리하다.
	// 입고처리하면...
	// 해당 도서의 상태가 '도장이 찍혀서' stamp 필드가 true로 변경됨.
	// + 그리고 comment 필드에 해당 도서를 입고한 담당 사서의 이름과 입고내역이 기록됨.
	// 도서 객체와 사서 객체가 연동되는 함수...
	public static void registerNewBookToLibrary(
			Book newBook, Librarian man) {
		if( newBook == null || man == null ) {
			System.out.println(">> 책이 없거나 사서가 없어서 입고처리 못함!!");
			return;
		}
		//if( newBook.stamp == false ) { // 입고 전 책이라면...
		if( newBook.isBookRegister() == false ) {
			newBook.stamp = true; // 도장 찍기 (상태 바뀜)
			//newBook.comment = "[입고기록] 양품 책입니다. by "
			newBook.comment += "\n[입고기록] 양품 책입니다. by "
					+ man.name +"("+ man.libNum+") "
					+ "/처리시간  - " + new Date();
		} else {
			System.out.println(">> 이미 입고된 책이네요!!");
			// 이미 누가 이전에 도장은 찍은 책이네요!
		}
	}
	
	
	public static void main(String[] args) {
		Book bk1 = new Book(
				"부자 아빠 가난한 아빠 20주년 특별 기념판", 
				"기요사키", 4, 
				"giyo/richdad.jpg",
				"8908098200123", 
				101, 3.45f, "부자되고 싶은데...");
		
		Book bk2 = new Book(
				"안녕 앤 - 어린시절 앤의 이야기",				 
				"윌슨", 5,				
				"red/book/ann.gif",
				"8908098111222", 
				102, 5.00f, "추억이 새록새록 좋아요! ^_^");
	
		// 책 상자 배열에 책들을 임시로 일단 담아두자..
		Book[] bookBox = {
				new Book(104, "일본어 첫걸음","일본어동아리", 4),
				bk1, bk2, new Book("월든", "헨리 데이비드 소로우", 
				2, "classic/walden.png", 
				"8908098111332", 103, 4.37f, "고전 좋아요!"),
				new Book("홍길동뎐", "허균")
		}; // 도서 5권을 표현한 배열... 
		
		// 책 박스 내역 확인 
		for(Book book : bookBox) {
			System.out.println("#"+ book.no 
					+ ", 제목: " + book.title 
					+ ", 저자: " + book.author +" 님" );
		}
				
		// 사서(Actor) 등장
		Librarian man1 = new Librarian();// 기본생성자
		man1.name = "엘사";
		man1.age = 19;
		man1.gender = Librarian.GENDER_FEMALE; //1;
		//System.out.println(man1); // newbook.human.Librarian@33909752

		Librarian man2 = new Librarian( // 풀생성자
				"동현", 23, Librarian.GENDER_MALE, 
				"서울시 왕십리", 2, 
				new Date(), 
				Librarian.LIB_POS[Librarian.LIB_POS_대리], 
				"대여관리 경력 3년"); 
				//"프리랜서", major); // 순서, 개수, 타입
		
		Librarian man3 = new Librarian("스파이더맨",
				29, Librarian.GENDER_FEMALE);
		man3.libNum = 3;
		man3.major = "부정 열람/대여 감시 등";

		// 책장 배치... 
		Bookshelf bs1 = new Bookshelf(1001, 
				"나무/ 2010년 - 인문/교양A", 1); // 4권 수용량
		
//		bs1.books[1] = new Book("4월 이야기", "재욱", 2);
//		//bs1.books[2] = new Book("5월 이야기", "재욱", 2);
//		if( bs1.books[2] == Bookshelf.EMPTY )
//			bs1.books[2] = new Book("6월 이야기", "재욱", 2);
//		else
//			System.out.println("3번 슬롯에는 이미 책이 있어요!");
//		bs1.printBookshelf();
		
		bs1.printBookshelf();
		System.out.println(bs1.no + "번 책장은 " +
			//( bs1.isFull() ? "꽉찼네요.": "여유가 있네요." ) // private error
			( bs1.isFull2() ? "꽉찼네요.": "여유가 있네요." ) // public
				);
		//if( bs1.isFull2() != true ) {
		//if( bs1.isFull2() == false ) {
		if( !bs1.isFull2() ) {
			bs1.addBook(0, 
				new Book("라바 1", "EBS", 2) );
			bs1.addBook(1, 
					new Book("라바 2", "EBS", 2) );
			bs1.addBook(2, 
					new Book("라바 3", "EBS", 2) );
			//
			bs1.addBook(-1, new Book("톰과제리", "disney",
					4));
			bs1.addBook(5, new Book("톰과제리 again", "disney",
					4));
			bs1.addBook(2, new Book("톰과제리 zero", "disney",
					4));
		}
		bs1.printBookshelf();
		
		
		
		
		//-------
		
		Bookshelf bs2 = new Bookshelf(1004,
				"철제, 2020년 - IT/개발", 2, 10); // 10권..
		bs2.printBookshelf();
		System.out.println(bs2.no + "번 책장은 " +
				( bs2.isFull2() ? "꽉찼네요.": "여유가 있네요." ) 
					);
		for (int i = 0; i < 10; i++) {
			Book bk = new Book("고즐링의 자바이야기", // 10번의 new 실행
					"제임스 고즐링 guru", 1, 
					"origin/java.png", "0123456789000", 
					i+1, 2.0f, "자바 재미?");
			bs2.addBook(i, bk); 
		}
		bs2.printBookshelf();
		
		
		Bookshelf bs3 = new Bookshelf(1011, 
				"플라스틱, 2021년 - 입고/열람 대기용",
				3, bookBox.length, bookBox); // 책박스배열통째로 입력.
		bs3.printBookshelf();
		System.out.println(bs3.no + "번 책장은 " +
				( bs3.isFull2() ? "꽉찼네요.": "여유가 있네요." ) 
					);		
	}

}
/*
#104, 제목: 일본어 첫걸음, 저자: 일본어동아리 님
#101, 제목: 부자 아빠 가난한 아빠 20주년 특별 기념판, 저자: 기요사키 님
#102, 제목: 안녕 앤 - 어린시절 앤의 이야기, 저자: 윌슨 님
#103, 제목: 월든, 저자: 헨리 데이비드 소로우 님
#0, 제목: 홍길동뎐, 저자: 허균 님
┌──────────────┐
1001번 책장:: <1>층
	 레이블: 나무/ 2010년 - 인문/교양A
	 도서 수용량: 4~권까지 가능
───────────────
[1]  -- slot 비었음 -- 
[2]  -- slot 비었음 -- 
[3]  -- slot 비었음 -- 
[4]  -- slot 비었음 -- 
└──────────────┘

┌──────────────┐
1004번 책장:: <2>층
	 레이블: 철제, 2020년 - IT/개발
	 도서 수용량: 10~권까지 가능
───────────────
[1]  -- slot 비었음 -- 
[2]  -- slot 비었음 -- 
[3]  -- slot 비었음 -- 
[4]  -- slot 비었음 -- 
[5]  -- slot 비었음 -- 
[6]  -- slot 비었음 -- 
[7]  -- slot 비었음 -- 
[8]  -- slot 비었음 -- 
[9]  -- slot 비었음 -- 
[10]  -- slot 비었음 -- 
└──────────────┘

┌──────────────┐
1011번 책장:: <3>층
	 레이블: 플라스틱, 2021년 - 입고/열람 대기용
	 도서 수용량: 5~권까지 가능
───────────────
[1] 일본어 첫걸음 [일본어동아리] <<☆☆☆☆☆>>
[2] 부자 아빠 가난한 아빠 20주년 특별 기념판 [기요사키] <<★★★☆☆>>
[3] 안녕 앤 - 어린시절 앤의 이야기 [윌슨] <<★★★★★>>
[4] 월든 [헨리 데이비드 소로우] <<★★★★☆>>
[5] 홍길동뎐 [허균] <<☆☆☆☆☆>>
└──────────────┘
┌──────────────┐
1011번 책장:: <3>층
	 레이블: 플라스틱, 2021년 - 입고/열람 대기용
	 도서 수용량: 5~권까지 가능
───────────────
[1] 일본어 첫걸음 [일본어동아리] <<☆☆☆☆☆>>
[2] 부자 아빠 가난한 아빠 20주년 특별 기념판 [기요사키] <<★★★☆☆>>
[3]  -- slot 비었음 -- 
[4] 월든 [헨리 데이비드 소로우] <<★★★★☆>>
[5] 홍길동뎐 [허균] <<☆☆☆☆☆>>
└──────────────┘

*/ 
