package judge;

public class JudgementMain {

	// Ŭ���� ������ �����Ǵ� ��� ����
	// Ŭ���������� ����ƽ ��� (static constant)
	public static final double SUCCESS_LEVEL = 62.0; // 62 cm,  62.0D;
	public static final double INCH_TO_CM = 2.54; 
	
	
	public static void main(String[] args) {
		double ����_record = 20.0;
		double �缮_record = 55.78;
		double ����_record = 24.21;
		double ����_record = 0.0;

		double ����_cm = ����_record * INCH_TO_CM;
		double �缮_cm = �缮_record * INCH_TO_CM;
		double ����_cm = ����_record * INCH_TO_CM;
		double ����_cm = ����_record * INCH_TO_CM;
		
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

}
