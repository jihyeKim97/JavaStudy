package judge;

public class JudgementMain3 {

	public static final double SUCCESS_LEVEL = 62.0; 
	public static final double INCH_TO_CM = 2.54; 

	public static void main(String[] args) {

		double 광수_record = 20.0;
		double 재석_record = 55.78;
		double 하하_record = 24.21;
		double 종국_record = 0.0;
		

		double 광수_cm = convertInchToCm(광수_record);
		double 재석_cm = convertInchToCm(재석_record);
		double 하하_cm = convertInchToCm(하하_record);
		double 종국_cm = convertInchToCm(종국_record);

		
		printJudgement("광수", 광수_record, 광수_cm);
		printJudgement("하하", 하하_record, 하하_cm);
		printJudgement("재석", 재석_record, 재석_cm);
	}


	public static void printJudgement(String runningMan, double record, double cm) {
		System.out.println("== 런닝맨 제자리 멀리뛰기 판정 프로그램 ==");
		System.out.println("[R멤버 이름]: " + runningMan);
		System.out.printf("\t레코드: %.2f inch ==> %.2f cm \n", record, cm);
		
		if( cm >= SUCCESS_LEVEL ) {
			System.out.println("<<< 유효 SUCCESS >>>\n-----------------------------\n ");
		}else { 
			System.out.println("<<< 탈락 FAILURE >>>\n-----------------------------\n ");
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
