package grade;

public class GradeMain {

	public static void main(String[] args) {
		gradesCard(1, "안나", 13, 70, 60, 55);
	}
	
	// 자격증에 대한 성적 평가 프로그램		
	public static void gradesCard( int num,String name,int subScore1 ,int subScore2,int subScore3,int subScore4) {

		final String TITLE = " 성적 출력 프로그램 -- ver 1.0";
		final String BEGIN_ROW = "┌───────────────┐";
		final String END_ROW = "└───────────────┘";
		final String DOUBLE_ROW = "========================";
		final String SINGLE_ROW = "---------------------------";		
		
		String subject1 = "프로그래밍 언어"; 
		String subject2 = "전자계산기 구조"; 
		String subject3 = "데이터베이스"; 	
		String subject4 = "알고리즘";		

		System.out.println(BEGIN_ROW+"\n"+TITLE+"\n"+DOUBLE_ROW);
		System.out.println("* NO.: " + num );
		System.out.println("* 학생명: " + name );
		System.out.println(SINGLE_ROW);
		System.out.printf("* [%s] 점수 : %d점  \n",subject1,subScore1);
		System.out.printf("* [%s] 점수 : %d점  \n",subject2,subScore2);
		System.out.printf("* [%s] 점수 : %d점  \n",subject3,subScore3);
		System.out.printf("* [%s] 점수 : %d점  \n",subject4,subScore4);
		System.out.println(SINGLE_ROW);
		System.out.printf("총합 점수 : %d점 (4 과목) \n",getSumScores(subScore1, subScore2, subScore3, subScore4));
		System.out.println(SINGLE_ROW);
		System.out.printf("평균 점수 : %.2f점 \n",getAverageScores(getSumScores(subScore1, subScore2, subScore3, subScore4))) ;
		System.out.println(DOUBLE_ROW);
		System.out.println(getPasssMark(getAverageScores(getSumScores(subScore1, subScore2, subScore3, subScore4))));
		System.out.println(END_ROW + "\n\n");
	}
	//+++++++++++++++++++++++++++++++총합을 구하는 함수+++++++++++++++++++++++++++++++
	public static int getSumScores(int subScore1 ,int subScore2,int subScore3,int subScore4) {
		int totalScore = subScore1 + subScore2 + subScore3 + subScore4;
		return totalScore;
	}
	// +++++++++++++++++++++++++++++++평균을 구하는 함수+++++++++++++++++++++++++++++++
	public static double getAverageScores( int totalScore) {
		double averageScore = totalScore / (double)4;
		return averageScore;
	}
	// +++++++++++++++++++++++++++++++합격 여부를 알리는 함수+++++++++++++++++++++++++++++++
	public static String getPasssMark(double averageScore) {
		String passmsg ="";
		if(averageScore < 60.00) {
			passmsg = "▽▼▽▼▽▼▽  불합격  ▽▼▽▼▽▼▽";
		}else {
			passmsg = "♬♬♬♬♬♬♬  합격  ♬♬♬♬♬♬♬";
		}	
		return passmsg;
	}
}
