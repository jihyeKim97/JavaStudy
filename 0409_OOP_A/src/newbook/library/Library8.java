package newbook.library;
//import newbook.Book; // 명시적으로 Book 타입을 참조하겠다는 선언.
import newbook.*; // newbook 패키지 안의 모든 타입들을 참조해서 사용하겠다고 선언.

public class Library8 {

	public static void main(String[] args) {
		Book bk1 = new Book("4월 이야기", "김상", 
				5, "japan/aprilstory.png", 
				"4789666611300", 1, 
				4.01f, Book.NO_COMMENT);
//		double e = Math.E;
		
		Book bk2 = new Book("봄 이야기", "재욱", 
				1, "jaewook/springstory.png", 
				"4789666611302", 2, 
				3.43f, Book.NO_COMMENT);
		
		Book bk3 = new Book("여름 이야기", "재욱", 
				1, "jaewook/springstory.png", 
				"4789666611303",3, 
				1.02f, Book.NO_COMMENT);
		
		Book bk4 = new Book("가을 이야기", "재욱", 
				1, "jaewook/springstory.png", 
				"4789666611304", 4, 
				5.00f, "대박 났어요...!");
		
		Book bk5 = new Book("겨울 이야기", "재욱", 
				1, "jaewook/springstory.png", 
				"4789666611305", 5, 
				2.82f, Book.NO_COMMENT);
		//
		// 같은 타입 Book 타입 객체가 5개.. 모두 같은 함수 printBook()를
		// 실행하는 동일 구조. 그리고 변수명의 1~5까지의 순서번호가 보이는 패턴.
		// => 배열로 묶을 수 있네!!
		//String[] strarr = { "aaa", "eee", "bbbb" };
//		String[] strarr = { 
//				new String("aaa"),
//				new String("eee"), 
//				new String("bbbb")
//		};
		Book[] books = {  // 배열로 책들을 하나로 묵어버림.. 
			bk1, bk2, bk3, bk4, bk5,
			new Book("공정한선거하기", "정부")
		}; // 0 ~ 5
		//Book bk6 = books[5]; // 마지막 책
//		Book bk6 = books[books.length-1]; // 마지막 책
//		bk6.no = 6;
//		bk6.increaseRate();	
		books[books.length-1].no = 6;
		books[books.length-1].increaseRate();
		
		// 책 리스트 간이 출력
		System.out.println("=== 도서관 입고 예정 서적 리스트 ("+books.length+"권) ===");
		System.out.println("-----------------------------");
		System.out.println("|  번호   |    제목          |  저자     |  평점    |");
		System.out.println("-----------------------------");
		for (int i = 0; i < books.length; i++) {
			System.out.printf("| #%03d번 | ", i+1);
			System.out.print(
					books[i].title + " | "  +
					books[i].author + " 지음 | " +
					books[i].rate + "점 | "
					);
			System.out.println();
		}
		System.out.println("-----------------------------");
		
		// 책 배열 상세보기 나열.... 
//		for (int i = 0; i < books.length; i++) {
//			System.out.printf("Library%03d번 서적: ", i+1);
//			books[i].printBook();
////			Book bk = books[i]; //배열의 i번째 책 객체가 차례로 bk 변수에 잠시 기억됨.
////			bk.printBook();
//		}
		
//		bk1.printBook();
//		bk2.printBook();
//		bk3.printBook();
//		bk4.printBook();
//		bk5.printBook();
	}

}

/*

=== 도서관 입고 예정 서적 리스트 (6권) ===
-----------------------------
|  번호   |    제목          |  저자     |  평점    |
-----------------------------
| #001번 | 4월 이야기 | 김상 지음 | 4.01점 | 
| #002번 | 봄 이야기 | 재욱 지음 | 3.43점 | 
| #003번 | 여름 이야기 | 재욱 지음 | 1.02점 | 
| #004번 | 가을 이야기 | 재욱 지음 | 5.0점 | 
| #005번 | 겨울 이야기 | 재욱 지음 | 2.82점 | 
| #006번 | 공정한선거하기 | 정부 지음 | 0.5점 | 
-----------------------------


>> 도서 [공정한선거하기]의  평점이 0.5으로 변경되었습니다.
Library001번 서적: 도서관 책: #BK-000001 
제목: 4월 이야기
				김상 지음
	출판사: 일본문화사
	커버표지: japan/aprilstory.png
	ISBN: 4789666611300
		 평점: (<<★★★★☆>>) 4.01/5.0 pt 
		 리뷰: 댓글없음 
-----------------------------
Library002번 서적: 도서관 책: #BK-000002 
제목: 봄 이야기
				재욱 지음
	출판사: 재욱도서
	커버표지: jaewook/springstory.png
	ISBN: 4789666611302
		 평점: (<<★★★☆☆>>) 3.43/5.0 pt 
		 리뷰: 댓글없음 
-----------------------------
Library003번 서적: 도서관 책: #BK-000003 
제목: 여름 이야기
				재욱 지음
	출판사: 재욱도서
	커버표지: jaewook/springstory.png
	ISBN: 4789666611303
		 평점: (<<★☆☆☆☆>>) 1.02/5.0 pt 
		 리뷰: 댓글없음 
-----------------------------
Library004번 서적: 도서관 책: #BK-000004 
제목: 가을 이야기
				재욱 지음
	출판사: 재욱도서
	커버표지: jaewook/springstory.png
	ISBN: 4789666611304
		 평점: (<<★★★★★>>) 5.00/5.0 pt 
		 리뷰: 대박 났어요...! 
-----------------------------
Library005번 서적: 도서관 책: #BK-000005 
제목: 겨울 이야기
				재욱 지음
	출판사: 재욱도서
	커버표지: jaewook/springstory.png
	ISBN: 4789666611305
		 평점: (<<★★★☆☆>>) 2.82/5.0 pt 
		 리뷰: 댓글없음 
-----------------------------
Library006번 서적: 도서관 책: #BK-000006 
제목: 공정한선거하기
				정부 지음
	출판사: 국영출판사
	커버표지: default/dummy.png
	ISBN: 9876543210123
		 평점: (<<★☆☆☆☆>>) 0.50/5.0 pt 
		 리뷰: 댓글없음 
-----------------------------
*/