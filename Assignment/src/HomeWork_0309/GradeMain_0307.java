package HomeWork_0309;
/*
┌─────────────────────────┐
 성적 출력 프로그램 -- ver 1.0
===========================
* 학생명: 안나
---------------------------
* [프로그래밍 언어] 점수: 13점 
* [전자계산기 구조] 점수: 59점 
* [데이터베이스] 점수: 40점 
* [알고리즘] 점수: 100점 
---------------------------
 총합 점수: 212점 (4 과목) 
---------------------------
 평균 점수: 53.00점 
===========================
 불합격 ㅠㅠ 
└─────────────────────────┘

┌─────────────────────────┐
 성적 출력 프로그램 -- ver 1.0
===========================
* 학생명: 안나
---------------------------
* [프로그래밍 언어] 점수: 13점 
* [전자계산기 구조] 점수: 59점 
* [데이터베이스] 점수: 68점 
* [알고리즘] 점수: 100점 
---------------------------
 총합 점수: 240점 (4 과목) 
---------------------------
 평균 점수: 60.00점 
===========================
 ★★★ 합격 ★★★
└─────────────────────────┘


*/

// 과제.... 

public class GradeMain_0307 {

	public static void main(String[] args) {
		// 자격증에 대한 성적 평가 프로그램
		// 최종 평균점수가 60.0 이상이면 합격, 미만이면 불합격... 판정.
		
		// 상수 정의부 ------
		final int NUMBER_OF_SUBJECTS = 4; // 과목수
		final String TITLE = " 성적 출력 프로그램 -- ver 1.0";
		final String BEGIN_ROW = "┌─────────────────────────┐";
		final String END_ROW = "└─────────────────────────┘";
		final String DOUBLE_ROW = "===========================";
		final String SINGLE_ROW = "---------------------------";		

		// 변수 선언부 (초기화) ------
//		String name = "엘사"; // 응시자
//		String subject1 = "프로그래밍 언어"; // 과목명 1 
//		int subScore1 = 100; // 과목1 점수 
//		String subject2 = "전자계산기 구조"; // 과목명 2
//		int subScore2 = 40; // 과목2 점수 
//		String subject3 = "데이터베이스"; 	// 과목명 3
//		int subScore3 = 60; // 과목3 점수 
//		String subject4 = "알고리즘";		// 과목명 4
//		int subScore4 = 83; // 과목4 점수 
		
		String name = "안나"; // 응시자
		String subject1 = "프로그래밍 언어"; // 과목명 1 
		int subScore1 = 13; // 과목1 점수 
		String subject2 = "전자계산기 구조"; // 과목명 2
		int subScore2 = 59; // 과목2 점수 
		String subject3 = "데이터베이스"; 	// 과목명 3
		int subScore3 = 40+28;// +27;// 27.6; // 39.6; // 과목3 점수 
		String subject4 = "알고리즘";		// 과목명 4
		int subScore4 = 100; // 과목4 점수 
		
		int totalScore = 0; // 총합 점수 결과 저장용
		double averageScore = 0.0;	// 평균 점수 결과 저장용 (산술평균)
		
		// 계산 처리부 (알고리즘 수행) ------
		// 총합
		totalScore = getSumScores(subScore1, 
				subScore2, subScore3, subScore4);
//		totalScore = subScore1 + subScore2 
//					+ subScore3 + subScore4;
//		totalScore = (((subScore1 + subScore2) 
//				+ subScore3) + subScore4); // 연산순서..
		// 평균 (산술평균)
//		averageScore = (subScore1 + subScore2 
//				+ subScore3 + subScore4) / 4; // 정수끼리 연산은 결과도 정수.
//		averageScore = (subScore1 + subScore2 
//				+ subScore3 + subScore4) / 4.0; // 실수로 나눔
//		averageScore = (subScore1 + subScore2 
//				+ subScore3 + subScore4) / (double)4;
//										// 실수로 캐스팅하여 나눔
//		averageScore = (double)(subScore1 + subScore2 
//				+ subScore3 + subScore4) / 4;
//										// 실수로 캐스팅하여 나눔
//		averageScore = (double)(subScore1 + subScore2 
//				+ subScore3 + subScore4) / (double)4;
//										// 실수로 캐스팅하여 나눔
//		averageScore = (double) ( (subScore1 + subScore2 
//				+ subScore3 + subScore4) / 4 );	
//						// 데이터 손실 후 캐스팅임... 주의!!! 	
//		averageScore = (double)totalScore 
//							/ NUMBER_OF_SUBJECTS;
		averageScore = getAvgScore(subScore1, 
				subScore2, subScore3, subScore4);
		
		// 출력부 ------
		System.out.println(BEGIN_ROW);
		System.out.println(TITLE);
		System.out.println(DOUBLE_ROW);
		System.out.println("* 학생명: " + name );
		System.out.println(SINGLE_ROW);
		System.out.printf("* [%s] 점수: %d점 \n", subject1, subScore1);
		System.out.printf("* [%s] 점수: %d점 \n", subject2, subScore2);
		System.out.printf("* [%s] 점수: %d점 \n", subject3, subScore3);
		System.out.printf("* [%s] 점수: %d점 \n", subject4, subScore4);
		//System.out.printf("* [%s] 점수: %d점 \n", "", 0);
		System.out.println(SINGLE_ROW);
		
		System.out.printf(" 총합 점수: %d점 (%d 과목) \n",
						totalScore, 4);
		System.out.println(SINGLE_ROW);
		System.out.printf(" 평균 점수: %.2f점 \n", averageScore);
		System.out.println(DOUBLE_ROW);
		
		// 합격유무 판정 출력부
//		final double PASS_SCORE = 60.0;
//		//if( averageScore >= PASS_SCORE ) // 이상
//		if( averageScore >= PASS_SCORE && averageScore <= 100.0 )
//			System.out.println(" ★★★ 합격 ★★★");
//		else // 미만 averageScore < 60...
//			System.out.println(" 불합격 ㅠㅠ ");
		String passMsg = "";
		passMsg = getPassMark(averageScore);
		System.out.println(passMsg);
		System.out.println(END_ROW);
	}

	
	
	private static String getPassMark(double averageScore) {
		// TODO 평균 점수를 입력받아 합격/불합격을 판정하여 문자열 리턴하는 함수
		String msg = "";
		
		return msg;
	}

	private static double getAvgScore(int subScore1, int subScore2, int subScore3, int subScore4) {
		// TODO 평균 점수 리턴하는 함수 구현
		return 0.0;
	}

	private static int getSumScores(int subScore1, int subScore2, int subScore3, int subScore4) {
		// TODO 총점을 리턴하는 함수 구현 
		return 0;
	}

}
