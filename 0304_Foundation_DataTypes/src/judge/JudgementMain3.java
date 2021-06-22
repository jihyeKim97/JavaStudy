package judge;

public class JudgementMain3 {

	public static final double SUCCESS_LEVEL = 62.0; 
	public static final double INCH_TO_CM = 2.54; 

	public static void main(String[] args) {

		double ����_record = 20.0;
		double �缮_record = 55.78;
		double ����_record = 24.21;
		double ����_record = 0.0;
		

		double ����_cm = convertInchToCm(����_record);
		double �缮_cm = convertInchToCm(�缮_record);
		double ����_cm = convertInchToCm(����_record);
		double ����_cm = convertInchToCm(����_record);

		
		printJudgement("����", ����_record, ����_cm);
		printJudgement("����", ����_record, ����_cm);
		printJudgement("�缮", �缮_record, �缮_cm);
	}


	public static void printJudgement(String runningMan, double record, double cm) {
		System.out.println("== ���׸� ���ڸ� �ָ��ٱ� ���� ���α׷� ==");
		System.out.println("[R��� �̸�]: " + runningMan);
		System.out.printf("\t���ڵ�: %.2f inch ==> %.2f cm \n", record, cm);
		
		if( cm >= SUCCESS_LEVEL ) {
			System.out.println("<<< ��ȿ SUCCESS >>>\n-----------------------------\n ");
		}else { 
			System.out.println("<<< Ż�� FAILURE >>>\n-----------------------------\n ");
		}
	}


	private static double convertInchToCm(double inch) {
		double resultCm = inch * INCH_TO_CM; 
		return resultCm; 
	}
	
	public static double convertCmToInch(double cm) {
		double resultInch = cm / INCH_TO_CM;
		return resultInch;
	}
	
}
