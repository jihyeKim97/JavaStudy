package judge;

public class JudgementMain {

	// 클래스 내에서 공유되는 상수 정의
	// 클래스수준의 스태틱 상수 (static constant)
	public static final double SUCCESS_LEVEL = 62.0; // 62 cm,  62.0D;
	public static final double INCH_TO_CM = 2.54; 
	
	
	public static void main(String[] args) {
		double 광수_record = 20.0;
		double 재석_record = 55.78;
		double 하하_record = 24.21;
		double 종국_record = 0.0;

		double 광수_cm = 광수_record * INCH_TO_CM;
		double 재석_cm = 재석_record * INCH_TO_CM;
		double 하하_cm = 하하_record * INCH_TO_CM;
		double 종국_cm = 종국_record * INCH_TO_CM;
		
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

}
