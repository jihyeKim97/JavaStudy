package grade;

public class GradeMain {

	public static void main(String[] args) {
		gradesCard(1, "�ȳ�", 13, 70, 60, 55);
	}
	
	// �ڰ����� ���� ���� �� ���α׷�		
	public static void gradesCard( int num,String name,int subScore1 ,int subScore2,int subScore3,int subScore4) {

		final String TITLE = " ���� ��� ���α׷� -- ver 1.0";
		final String BEGIN_ROW = "����������������������������������";
		final String END_ROW = "����������������������������������";
		final String DOUBLE_ROW = "========================";
		final String SINGLE_ROW = "---------------------------";		
		
		String subject1 = "���α׷��� ���"; 
		String subject2 = "���ڰ��� ����"; 
		String subject3 = "�����ͺ��̽�"; 	
		String subject4 = "�˰���";		

		System.out.println(BEGIN_ROW+"\n"+TITLE+"\n"+DOUBLE_ROW);
		System.out.println("* NO.: " + num );
		System.out.println("* �л���: " + name );
		System.out.println(SINGLE_ROW);
		System.out.printf("* [%s] ���� : %d��  \n",subject1,subScore1);
		System.out.printf("* [%s] ���� : %d��  \n",subject2,subScore2);
		System.out.printf("* [%s] ���� : %d��  \n",subject3,subScore3);
		System.out.printf("* [%s] ���� : %d��  \n",subject4,subScore4);
		System.out.println(SINGLE_ROW);
		System.out.printf("���� ���� : %d�� (4 ����) \n",getSumScores(subScore1, subScore2, subScore3, subScore4));
		System.out.println(SINGLE_ROW);
		System.out.printf("��� ���� : %.2f�� \n",getAverageScores(getSumScores(subScore1, subScore2, subScore3, subScore4))) ;
		System.out.println(DOUBLE_ROW);
		System.out.println(getPasssMark(getAverageScores(getSumScores(subScore1, subScore2, subScore3, subScore4))));
		System.out.println(END_ROW + "\n\n");
	}
	//+++++++++++++++++++++++++++++++������ ���ϴ� �Լ�+++++++++++++++++++++++++++++++
	public static int getSumScores(int subScore1 ,int subScore2,int subScore3,int subScore4) {
		int totalScore = subScore1 + subScore2 + subScore3 + subScore4;
		return totalScore;
	}
	// +++++++++++++++++++++++++++++++����� ���ϴ� �Լ�+++++++++++++++++++++++++++++++
	public static double getAverageScores( int totalScore) {
		double averageScore = totalScore / (double)4;
		return averageScore;
	}
	// +++++++++++++++++++++++++++++++�հ� ���θ� �˸��� �Լ�+++++++++++++++++++++++++++++++
	public static String getPasssMark(double averageScore) {
		String passmsg ="";
		if(averageScore < 60.00) {
			passmsg = "��������  ���հ�  ��������";
		}else {
			passmsg = "�ݢݢݢݢݢݢ�  �հ�  �ݢݢݢݢݢݢ�";
		}	
		return passmsg;
	}
}
