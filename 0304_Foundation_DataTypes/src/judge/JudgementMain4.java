package judge;

public class JudgementMain4 {

	public static final double SUCCESS_LEVEL = 62.0; 
	public static final double INCH_TO_CM = 2.54; 

	public static void main(String[] args) {

		double 광수_record = 20.0;
		double 재석_record = 55.78;
		double 하하_record = 24.21;
		double 종국_record = 0.0;

		printJudgementForInch("하하", 하하_record);
		printJudgementForInch("광수", 광수_record);
		printJudgementForInch("재석", 재석_record);
		printJudgementForInch("종국", 종국_record);
	}


	public static void printJudgementForInch(String runningMan, double record) {
		//recode 정상 범위 체크
		double cm = convertInchToCm(record);
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
