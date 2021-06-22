package judge;

public class JudgementMain4 {

	public static final double SUCCESS_LEVEL = 62.0; 
	public static final double INCH_TO_CM = 2.54; 

	public static void main(String[] args) {

		double ����_record = 20.0;
		double �缮_record = 55.78;
		double ����_record = 24.21;
		double ����_record = 0.0;

		printJudgementForInch("����", ����_record);
		printJudgementForInch("����", ����_record);
		printJudgementForInch("�缮", �缮_record);
		printJudgementForInch("����", ����_record);
	}


	public static void printJudgementForInch(String runningMan, double record) {
		//recode ���� ���� üũ
		double cm = convertInchToCm(record);
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
