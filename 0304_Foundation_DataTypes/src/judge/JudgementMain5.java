package judge;

public class JudgementMain5 {

	public static final double SUCCESS_LEVEL = 62.0; 
	public static final double INCH_TO_CM = 2.54; 

	public static void main(String[] args) {

		double 광수_record = 20.0;
		double 재석_record = 55.78;
		double 하하_record = 24.21;
		double 종국_record = 0.0;
		// 반복문 loop =>특정 구간(블록)을 여러번 혹은 무한히 수행함
		// while(조건식){명령;}  =>조건식이 T이면 계속 실행

		
		boolean loopflag = true;
		/*++++++++++++++++++++   count  +++++++++++++++++++++++*/
		int count = 0; //4byte

		while (loopflag) {
			종국_record = Math.random() * 100;
			double 종국_cm = convertInchToCm(종국_record);
			count = count+1;
			System.out.println(count+"번째 --------------종국의cm : "+종국_cm+"cm\n+++++++++++++++++++++++++++");
//			if(종국_cm>200) {
//				loopflag = false;
//			}
			if(count == 5) { // loop Count제어
				loopflag = false;				
			}
		} //무한루프 - 루프를 실행한 뒤 변화된 값이 필요하다 순차적으로 어떤 패던으로 변하는게 있다면 기준점으로 삼는다
		
		
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
