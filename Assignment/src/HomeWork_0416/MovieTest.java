package HomeWork_0416;

import java.util.Scanner;

import HomeWork_0416.MyTheater;

/*
// 실습 3). MyTheater 클래스를 작성
// 	  극장 개념을 설계한 클래스...
//   이름, 주소(문자열)
//   극장개봉관크기(상영관 개수)
//   상영관 개수 만큼의 MyMoive 배열을 준비
//   생성자함수에는 각 상영관이 "비어있음"
//   극장 출력 printTheater() 함수는
//   모든 상영관의 현재 상영중인 영화의 제목과 장르 등 표시..
//   addMoiveToTheater(상영관 번호, 영화 객체)함수를 구현...
//   addMoiveToTheater(1, 겨울왕국2);

/* 미래CGV (성동구 11번지...)
 * 	 [1관] 비어있음.
 *	 [2관] 비어있음.
 *   [3관] 비어있음.  
 * 
 * 
 * 미래CGV (성동구 11번지...)
 * 	 [1관] '겨울왕국2', 환타지/애니
 *	 [2관] '터미네이터 ', 액션
 *   [3관] '홍길동 ', 스릴러
 */
/*
 * 실습 4). MyMoive에 '시청가능연령대' => 관람등급 level를 
// 적용하는 필드를 추가하고 적절한(초기화, 생성자, 프린트..) 처리. 
 * 영화객체를 7~10개정도 만들고, 각 영화의  
 * 	    관람등급 level을 영화마다 다르게 4 ~ 40 설정...
 * 	MyTheater 클래스에 final 상수로 관람등급 정의
 *  MAX_LEVEL = 19;
 *  상영관 배치를 위한 영화 객체들은 입력배열에 저장.
 *  addMoiveToTheater() 함수에서 MAX_LEVEL 이상인
 *  영화만 상영관에 배치합니다.
 *  단, 입력배열의 모든 영화를 상영관 배치 판정 하기 전에
 *  해당 영화관의 배열, 즉 상영관이 꽉차였다면 바로 중지.
 *   
 *   상영관 배치
 *   1. 피터팬 		12세 => 배치 안함
 *   2. 겨울왕국2		20세 => 1관에 배치
 *   3. 터미네이터   	30세 => 2관에 배치
 *   4. 뽀뽀로		6세   => 배치 안함
 *   5. 뿡뿡이       	4세   => 배치 안함
 *   6. 홍길동       	33세 => 3관에 배치
 *   7. 돌아온 짱구	22세 => 배치 안함 
 *   
 *   미래CGV (성동구 11번지...)
 * 	 [1관] '겨울왕국2', 환타지/애니, 4.5점
 *	 [2관] '터미네이터 ', 액션, 2.4점
 *   [3관] '홍길동 ', 스릴러, 1.0점
 */

public class MovieTest {

	public static void main(String[] args) {
		MyTheater cgv = new MyTheater();
		MyMovie[] movie = { new MyMovie("피터팬", 12, 2.5f), new MyMovie("겨울왕국2", 20, 4.7f),
				new MyMovie("터미네이터", 30, 3.2f), new MyMovie("뽀로로", 6, 2.5f), new MyMovie("뿡뿡이", 4, 5.0f),
				new MyMovie("홍길동", 33, 4.0f), new MyMovie("돌아온 짱구", 22, 3.1f), };
		addMoiveToTheater(cgv, movie);

	}

	private static void addMoiveToTheater(MyTheater cgv, MyMovie[] movie) {
		cgv = new MyTheater();
		int count = 0;
		for (int i = 0; i < movie.length; i++) {
			if (count < 3) {
				if (movie[i].level >= MyTheater.MAX_LEVEL) {
					System.out.printf("%d. %s\t%d세 => %d관에 배치\n", i + 1, movie[i].name, movie[i].level, count + 1);
					cgv.mov[count] = movie[i];
					count++;
				} else
					System.out.printf("%d. %s\t%d세 => 관람등급 낮아서 배치안함\n", i + 1, movie[i].name, movie[i].level);
			} else
				System.out.printf("%d. %s\t%d세 => 상영관 꽉 차서 배치안함\n", i + 1, movie[i].name, movie[i].level);
		}
		cgv.printTheater();
	}

	private static MyMovie addMoiveToTheater() {
		Scanner sc = new Scanner(System.in);
		System.out.println(">> 영화 내용을 입력해주세요!");
		System.out.println("영화 이름: ");
		String name = sc.next();
		System.out.println("영화 등급: ");
		int level = sc.nextInt();
		System.out.println("영화 평점: ");
		float score = sc.nextFloat();

		MyMovie mv = new MyMovie(name, level, score);
		return mv;
	}

}
