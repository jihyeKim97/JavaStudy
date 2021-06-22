package judge;

public class JudgementMain2 {

	// Ŭ���� ������ ��� �Լ��ȿ��� �����Ǵ� ��� ����
	// Ŭ���������� ����ƽ ��� (static constant)
	public static final double SUCCESS_LEVEL = 62.0; // 62 cm,  62.0D;
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
		
		System.out.println("== ���׸� ���ڸ� �ָ��ٱ� ���� ���α׷� ==");
		String runningMan = "����";
		System.out.println("R��� �̸�: " + runningMan);
		System.out.printf("\t���ڵ�: %.2f inch ==> %.2f cm \n", ����_record, ����_cm);
		
		if( ����_cm >= SUCCESS_LEVEL ) { 
			System.out.println("<<< ��ȿ SUCCESS >>> ");
		}else { 
			System.out.println("<<< Ż�� FAILURE >>> ");
		}
	}


	private static double convertInchToCm(double inch) {
		double resultCm = 0.0;
		resultCm = inch * INCH_TO_CM; 
		return resultCm;
	}
	
	public static double convertCmToInch(double cm) {
		double resultInch = 0.0;
		resultInch = cm / INCH_TO_CM;
		return resultInch; 
	}
	
}
