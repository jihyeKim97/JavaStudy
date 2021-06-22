package newbook.library;

import newbook.Book;

public class Library2 {

	public static void main(String[] args) {
		Book bk1 = new Book(); 
		bk1.printBook();
		//
		Book bk2 = new Book("이상한나라앨리스", "재욱씨", 1);
		bk2.printBook();
		//
		Book bk3 = new Book(127, "황금알을 낳는 거위씨", "재욱씨", 1);
		bk3.imgPath = "jaewook/goose.png";
		bk3.ISBN = "0000000000123";
		bk3.comment = Book.NO_COMMENT; // 클래스 상수로 초기화.
		bk3.printBook();
		
		Book bk4 = new Book("꽁쥐팥쥐전", "규진");
		bk4.printBook();
	}

}

/*
도서관 책: #BK-000000 
제목: null
				null 지음
	출판사: 0
	커버표지: null
	ISBN: null
		 평점: 0.00 pt 
		 리뷰: null 
-----------------------------
도서관 책: #BK-000000 
제목: 이상한나라앨리스
				재욱씨 지음
	출판사: 1
	커버표지: null
	ISBN: null
		 평점: 0.00 pt 
		 리뷰: null 
-----------------------------
도서관 책: #BK-000127 
제목: 황금알을 낳는 거위씨
				재욱씨 지음
	출판사: 1
	커버표지: jaewook/goose.png
	ISBN: 0000000000123
		 평점: 0.00 pt 
		 리뷰: 댓글없음 
-----------------------------
도서관 책: #BK-000000 
제목: 꽁쥐팥쥐전
				규진 지음
	출판사: 0
	커버표지: default/dummy.png
	ISBN: 9876543210123
		 평점: 0.00 pt 
		 리뷰: 댓글없음 
-----------------------------

*/