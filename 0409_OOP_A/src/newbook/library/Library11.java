package newbook.library;
import newbook.human.Librarian;
import newbook.Book;
import java.util.Date;

public class Library11 {

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
		
		Librarian man3 = new Librarian("스파이더맨",
				29, Librarian.GENDER_FEMALE);
		man3.libNum = 3;
		man3.major = "부정 열람/대여 감시 등";
		
//		man1.printLibrarian();
//		man2.printLibrarian();
		man1.printLibrarian(true);
		man2.printLibrarian(true);
		man3.printLibrarian(false);
		
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
	}

}

/*
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
** 사서:: LIB_HUMAN_3
	 * 이름: 스파이더맨
	 * 나이: 29세
	 * 성별: [여성]
	 * 주소: null
	 * 입사일: 날자모름
	 * 직급: null
	 * 담당직무: 부정 열람/대여 감시 등
------------------------------
============================
[] 사서 1 : 이름 동현 (23세) - 직급 대리 
[] 사서 2 : 이름 스파이더맨 (29세) - 직급 미정 
[] 사서 3 : 이름 안나 (17세) - 직급 미정 
[] 사서 4 : 이름 엘사 (19세) - 직급 견습 
[] 사서 5 : 이름 아이언맨 (46세) - 직급 수석 

*/