package newbook.library;
import newbook.human.Librarian;
import newbook.Book;
import java.util.Date;

public class Library10 {

	public static void main(String[] args) {
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
		
//		man1.printLibrarian();
//		man2.printLibrarian();
		man1.printLibrarian(true);
		man2.printLibrarian(true);
	}

}

/*

** 사서:: LIB_HUMAN_0
 * 이름: 엘사
 * 나이: 19세
 * 성별: 1
 * 주소: 주소미정
 * 입사일: Wed Apr 07 13:29:56 KST 2021
 * 직급: 견습
 * 담당직무: 책 입고 관리
------------------------------
** 사서:: LIB_HUMAN_2
 * 이름: 동현
 * 나이: 23세
 * 성별: 2
 * 주소: 서울시 왕십리
 * 입사일: Wed Apr 07 13:29:56 KST 2021
 * 직급: 대리
 * 담당직무: 대여관리 경력 3년
------------------------------


** 사서:: LIB_HUMAN_0
	 * 이름: 엘사
	 * 나이: 19세
	 * 성별: [여성]
	 * 주소: 주소미정
	 * 입사일: Wed Apr 07 13:39:26 KST 2021
	 * 직급: 견습
	 * 담당직무: 책 입고 관리
------------------------------
** 사서:: LIB_HUMAN_2
	 * 이름: 동현
	 * 나이: 23세
	 * 성별: [남성]
	 * 주소: 서울시 왕십리
	 * 입사일: Wed Apr 07 13:39:26 KST 2021
	 * 직급: 대리
	 * 담당직무: 대여관리 경력 3년
------------------------------



** 사서:: LIB_HUMAN_0
	 * 이름: 엘사
	 * 나이: 19세
	 * 성별: [여성]
	 * 주소: 주소미정
	 * 입사일: 2021년 04월 07일
	 * 직급: 견습
	 * 담당직무: 책 입고 관리
------------------------------
** 사서:: LIB_HUMAN_2
	 * 이름: 동현
	 * 나이: 23세
	 * 성별: [남성]
	 * 주소: 서울시 왕십리
	 * 입사일: 2021년 04월 07일
	 * 직급: 대리
	 * 담당직무: 대여관리 경력 3년
------------------------------



*/