package newbook.library;

import newbook.Book;

public class Library {

	public static void main(String[] args) {
		//Book bk1; // 선언		
		//newbook.Book bk1; // 완전한정이름 (FQN)
		// 객체는 반드시 클래스(설계도)에 따라서
		// new 생성자함수()호출로만 메모리에 생성됨
		// (생성자함수 == 클래스와 동일이름함수)
		Book bk1 = new Book(); 
			// new를 통해 Book 타입 객체가 만들어진 공간,
			// JVM 메모리가 확보되고, 그 공간에 
			// 생성자 Book() 함수를 통해 필드변수 등이 초기화됨.
			// 마지막에 이 책객체의 주소(위치)를 bk1에 알려줌
			// (지금 생성된 책 객체가 어디 있는지 저장함)
		//System.out.println(bk1); 
			// newbook.Book@33909752
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
*/