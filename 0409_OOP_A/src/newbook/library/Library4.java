package newbook.library;

import newbook.Book;

public class Library4 {

	public static void main(String[] args) {
		Book bk2 = new Book("이상한나라앨리스", "재욱씨", 1);
		bk2.no = 102;
		bk2.changeRate(2.44f); // 안전 보장!
		//bk2.rate = 2.44f;
		//bk2.rate = 10.44f; // ? 안전 x? 
		bk2.printBook();
		//
		Book bk3 = new Book(103, "황금알을 낳는 거위씨", "재욱씨", 1);
		bk3.imgPath = "jaewook/goose.png";
		bk3.ISBN = "0000000000123";
		bk3.comment = Book.NO_COMMENT; // 클래스 상수로 초기화.
		bk3.changeRate(1.26f);
		bk3.printBook();
		bk3.changeRate(3.99f);
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
		//bk5.rate = bk5.rate - 5.0f; // -1.55f?
		//bk5.changeRate(bk5.rate - 5.0f);
		//bk5.changeRate(-1.55f);
		//boolean b = bk5.changeRate(-1.55f);
		//if( b == true )
		//if( b ) {} else {}
		if( bk5.changeRate(-1.55f) == true )
			bk5.printBook();
		else	
			System.out.println(
					"!! 평점 처리에 문제 발생(사서 호출): " 
					+ bk5.no + "번 책 - " + bk5.title);
		
		
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
>> 도서 [이상한나라앨리스]의  평점이 2.44으로 변경되었습니다.
도서관 책: #BK-000102 
제목: 이상한나라앨리스
				재욱씨 지음
	출판사: 1
	커버표지: null
	ISBN: null
		 평점: 2.44 pt 
		 리뷰: null 
-----------------------------
>> 도서 [황금알을 낳는 거위씨]의  평점이 1.26으로 변경되었습니다.
도서관 책: #BK-000103 
제목: 황금알을 낳는 거위씨
				재욱씨 지음
	출판사: 1
	커버표지: jaewook/goose.png
	ISBN: 0000000000123
		 평점: 1.26 pt 
		 리뷰: 댓글없음 
-----------------------------
>> 도서 [황금알을 낳는 거위씨]의  평점이 3.99으로 변경되었습니다.
도서관 책: #BK-000103 
제목: 황금알을 낳는 거위씨
				재욱씨 지음
	출판사: 1
	커버표지: jaewook/goose.png
	ISBN: 0000000000123
		 평점: 3.99 pt 
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
>> 평점 범위 벗어난 에러: -1.55
!! 평점 처리에 문제 발생(사서 호출): 105번 책 - 부자 아빠 가난한 아빠 20주년 특별 기념판
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