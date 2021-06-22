package newbook.library;
import newbook.human.Librarian;
import newbook.Book;
import java.util.Date;

public class Library14 {
	
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
				new Book(104, "일본어 첫걸음", 
						"일본어동아리", 4),
				bk1, bk2, 
				new Book("월든", "헨리 데이비드 소로우", 
						2, "classic/walden.png", 
						"8908098111332", 
					103, 4.37f, "고전 좋아요!")				
		}; // 도서 4권을 표현한 배열... 
		
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
		
		// 사서 5명 모집...   사서들을 묶어서 사서배열로 표현
		Librarian[] libMans = {
			man2, man3, 
			new Librarian("안나", 17, Librarian.GENDER_FEMALE), 
			man1, 
			new Librarian("아이언맨", 46, Librarian.GENDER_MALE) 	
		};  // legnth 5, 0 ~ 4 
		Librarian lib = libMans[4];
		lib.pos = Librarian.LIB_POS[Librarian.LIB_POS_수석];
		lib.major = "도서관 총관리자";
		
		System.out.println("============================");
		// 사서 리스트 간이 출력
		for (int i = 0; i < libMans.length; i++) {
			System.out.printf(
					"[] 사서 %d : 이름 %s (%d세) - 직급 %s \n",
					i+1, libMans[i].name, 
					libMans[i].age,
					libMans[i].pos == null ?
							"미정": libMans[i].pos);
					//libMans[i].pos);
		}
		System.out.println();
		System.out.println("============================");
		// 2번째 책을 1번 사서가 입고처리 하기 
		Book targetBk = bookBox[1]; // 부자..
		Librarian staffLib = libMans[0];// 동현..
		System.out.println(" 입고처리 ::: ");
		registerNewBookToLibrary(targetBk, staffLib);
		if( targetBk.isBookRegister() ) {
//			System.out.println("해당 도서 " +targetBk.title
//			+"은 사서 " + staffLib.name +"에 의해 도서관에 입고됨.." );
			System.out.println("내역: " + targetBk.comment);
		}
		
		// 4번째 책을 3번 사서가 입고처리 하기 
		Book targetBk2 = bookBox[3]; 
		Librarian staffLib2 = libMans[2];
		System.out.println(" 입고처리 ::: ");
		registerNewBookToLibrary(targetBk2, staffLib2);
		if( targetBk2.isBookRegister() ) {					
			System.out.println("내역: " + targetBk2.comment);
		}
	}

}
/*
#104, 제목: 일본어 첫걸음, 저자: 일본어동아리 님
#101, 제목: 부자 아빠 가난한 아빠 20주년 특별 기념판, 저자: 기요사키 님
#102, 제목: 안녕 앤 - 어린시절 앤의 이야기, 저자: 윌슨 님
#103, 제목: 월든, 저자: 헨리 데이비드 소로우 님
============================
[] 사서 1 : 이름 동현 (23세) - 직급 대리 
[] 사서 2 : 이름 스파이더맨 (29세) - 직급 미정 
[] 사서 3 : 이름 안나 (17세) - 직급 미정 
[] 사서 4 : 이름 엘사 (19세) - 직급 견습 
[] 사서 5 : 이름 아이언맨 (46세) - 직급 수석 

============================
 입고처리 ::: 
부자 아빠 가난한 아빠 20주년 특별 기념판 책은  입고 전 입니다.
부자 아빠 가난한 아빠 20주년 특별 기념판 책은  입고 되었습니다.
내역: 부자되고 싶은데...
[입고기록] 양품 책입니다. by 동현(2) /처리시간  - Thu Apr 08 11:04:44 KST 2021
 입고처리 ::: 
월든 책은  입고 전 입니다.
월든 책은  입고 되었습니다.
내역: 고전 좋아요!
[입고기록] 양품 책입니다. by 안나(0) /처리시간  - Thu Apr 08 11:04:44 KST 2021
*/ 
