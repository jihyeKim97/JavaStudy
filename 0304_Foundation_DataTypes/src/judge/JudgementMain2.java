package judge;

public class JudgementMain2 {

	// 클래스 내에서 모든 함수안에서 공유되는 상수 정의
	// 클래스수준의 스태틱 상수 (static constant)
	public static final double SUCCESS_LEVEL = 62.0; // 62 cm,  62.0D;
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
		
		System.out.println("== 런닝맨 제자리 멀리뛰기 판정 프로그램 ==");
		String runningMan = "광수";
		System.out.println("R멤버 이름: " + runningMan);
		System.out.printf("\t레코드: %.2f inch ==> %.2f cm \n", 광수_record, 광수_cm);
		
		if( 광수_cm >= SUCCESS_LEVEL ) { 
			System.out.println("<<< 유효 SUCCESS >>> ");
		}else { 
			System.out.println("<<< 탈락 FAILURE >>> ");
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
