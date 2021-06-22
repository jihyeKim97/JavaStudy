package HomeWork_0416;

/* 
실습 1) 

homework.film 패키지 생성
 MyMoive 클래스 정의
 '영화' 도메인  영화 스키마 개념...을 표현하는
 MyMoive 클래스를 작성 합니다.
 필드나 상수를 포함하고 (적어도 6개 이상의 필드들), 
 영화객체의 내용을 출력하는 메소드를 작성함.
 영화객체를 생성하는 생성자함수를 
 적어도 3가지 방식으로 함수오버로딩화해서 작성

실습 2)

MovieTest 클래스의 main() 함수에서... 

Scanner를 사용하여, 영화 객체를 생성한 후 출력하는 문제

>> 영화 내용을 입력해주세요! 
* 영화 이름: aaaa
* 영화 장르: bbbbb
* 영화 개봉년도: 2019
* 영화 관객수: 300
* 영화 평점: 3.4
* . . . 
* 영화 객체를 생성합니다.
* (printMyMoive를 실행하여 출력)
*/

public class MyMovie {
	public static final String NAME = "제목 없음";
	public static final String GENRE = "장르 없음";
	public static final String DIRECTER = "감독 없음";

	public String name;
	public String genre;
	public String directer;
	public int year;
	public int guests;
	public int level;
	public float score;

	public MyMovie() {
		this.name = NAME;
		this.genre = GENRE;
		this.directer = DIRECTER;
	}

	public MyMovie(String name) {
		this.name = name;

	}

	public MyMovie(String name, int level) {
		this.name = name;
		this.genre = GENRE;
		this.directer = DIRECTER;
		this.year = 0;
		this.guests = 0;
		this.level = level;
		this.score = 0;
	}

	public MyMovie(String name, int level, float score) {
		this.name = name;
		this.genre = GENRE;
		this.directer = DIRECTER;
		this.year = 0;
		this.guests = 0;
		this.level = level;
		this.score = score;
	}

	public MyMovie(String name, String directer, int year) {
		this.name = name;
		this.directer = directer;
		this.year = year;

	}

	public MyMovie(String name, String genre, String directer, int year, int guests, int level, float score) {
		this.name = name;
		this.genre = genre;
		this.directer = directer;
		this.year = year;
		this.guests = guests;
		this.level = level;
		this.score = score;
	}

	public void printMyMovie() {
		System.out.println("영화 이름: " + name + "\n" + "영화 장르: " + genre + "\n" + "영화 감독: " + directer + "\n"
				+ "영화 개봉 년도: " + year + "년" + "\n" + "영화 관객 수: " + guests + "명" + "\n" + "영화 등급: " + level + "\n"
				+ "영화 평점: " + score + "점");
	}

}
