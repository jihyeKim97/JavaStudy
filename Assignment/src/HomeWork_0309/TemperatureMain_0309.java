package HomeWork_0309;
/* 
	?��?��    <==>   ?��?��   ?��?�� �??���? 

	https://ko.wikipedia.org/wiki/%EC%84%AD%EC%94%A8

1) ?��?�� ?��?�� �??�� ?��?�� cToF(), fToC() 구현?��?�� ?��?��
  
2) 출력?��?�� printResult() 별도 구현. 
	모든 ?��?�� float ?��?���? 출력?? ?��?��?�� 2?��리까�? ?��?��.

// 출력 ?��
// 
//========= ?��?���??���? ===========
//	?��?��: 36.50C (?��?��) 
//	결과: ??.??F (?��?��)
//-----------------------------			
//	?��?��: 80.00F (?��?��) 
//	결과: ??.??C (?��?��)
//=============================

3) inputC?? inputF�? ?��?��?�� 범위?�� ?��?���? ?��?��?��?�� ?��?��?��보기. 
	Math.random() ?��?��, 
	?��?�� 범위: -20.00 ~ +40.00 (?��?�� 미포?��) 
	?��?�� 범위: 4.00 ~ 104.00 (미만)

*/
public class TemperatureMain_0309 {

	public static void main(String[] args) {
		float inputC = 36.50f; //?��?��
		float inputF = 80.00f; //?��?��
		float inputCR = (float)((Math.random()*60)-20); //?��?��
		float inputFR = (float)((Math.random()*100)+4); //?��?��
		
		printResult(inputC,inputF);
		printResult(inputCR,inputFR);
	}

	private static void printResult(float inputC,float inputF) {
		System.out.println("========= ?��?���??���? ===========");
		System.out.printf("?��?��: %.2fC (?��?��)\n",inputC);
		System.out.printf("결과: %.2fF (?��?��)\n",cToF(inputC));
		System.out.println("--------------------------------");
		System.out.printf("결과: %.2fF (?��?��)\n",inputF);
		System.out.printf("?��?��: %.2fC (?��?��)\n",fToC(inputF));
		System.out.println("=============================");
	}

	/*++++++++     °F -> °C (?��?��->?��?��)     ++++++++*/      
	public static float cToF(float c) {
		float f = 0.0f;
		f = (float)(c * 1.8 + 32) ; // °F = °C × 1.8 + 32
		return f;
	}
	
	/*++++++++     °C -> °F (?��?��->?��?��)    ++++++++*/      
	public static float fToC(float f) {
		float c = 0.0f;
		 c = (float)((f - 32) / 1.8f); // °C = (°F ?�� 32) / 1.8
		return c;
	}
}

