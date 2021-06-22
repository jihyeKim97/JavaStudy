package newbook.library;

import newbook.Book;

public class Library3 {

	public static void main(String[] args) {
//		Book bk1 = new Book();
//		bk1.no = 101;
//		bk1.printBook();
		//
		Book bk2 = new Book("이상한나라앨리스", "재욱씨", 1);
		bk2.no = 102;
		bk2.printBook();
		//
		Book bk3 = new Book(103, "황금알을 낳는 거위씨", "재욱씨", 1);
		bk3.imgPath = "jaewook/goose.png";
		bk3.ISBN = "0000000000123";
		bk3.comment = Book.NO_COMMENT; // 클래스 상수로 초기화.
		bk3.printBook();
		
		Book bk4 = new Book("꽁쥐팥쥐전", "규진");
		bk4.no = 104;
		bk4.rate = 4.33f;
		bk4.printBook();
		
		Book bk5 = new Book(
				"부자 아빠 가난한 아빠 20주년 특별 기념판", 
				"기요사키", 2, 
				"giyo/richdad.jpg",
				"8908098200123", 
				105, 3.45f, "부자되고 싶은데...");
		bk5.printBook();
		
		Book bk6 = new Book(
				"안녕 앤 - 어린시절 앤의 이야기", 
				"윌슨", 3, 
				"red/book/ann.gif",
				"8908098111222", 
				106, 5.00f, "추억이 새록새록 좋아요! ^_^");
		bk6.printBook();
	}

}

/*
도서관 책: #BK-000102 
제목: 이상한나라앨리스
				재욱씨 지음
	출판사: 1
	커버표지: null
	ISBN: null
		 평점: 0.00 pt 
		 리뷰: null 
-----------------------------
도서관 책: #BK-000103 
제목: 황금알을 낳는 거위씨
				재욱씨 지음
	출판사: 1
	커버표지: jaewook/goose.png
	ISBN: 0000000000123
		 평점: 0.00 pt 
		 리뷰: 댓글없음 
-----------------------------
도서관 책: #BK-000104 
제목: 꽁쥐팥쥐전
				규진 지음
	출판사: 0
	커버표지: default/dummy.png
	ISBN: 9876543210123
		 평점: 4.33 pt 
		 리뷰: 댓글없음 
-----------------------------
도서관 책: #BK-000105 
제목: 부자 아빠 가난한 아빠 20주년 특별 기념판
				기요사키 지음
	출판사: 2
	커버표지: giyo/richdad.jpg
	ISBN: 8908098200123
		 평점: 3.45 pt 
		 리뷰: 부자되고 싶은데... 
-----------------------------
도서관 책: #BK-000106 
제목: 안녕 앤 - 어린시절 앤의 이야기
				윌슨 지음
	출판사: 3
	커버표지: red/book/ann.gif
	ISBN: 8908098111222
		 평점: 5.00 pt 
		 리뷰: 추억이 새록새록 좋아요! ^_^ 
-----------------------------
*/