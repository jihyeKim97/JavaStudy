package HomeWork_0309;
/* 
	?„­?”¨    <==>   ?™”?”¨   ?˜¨?„ ë³??™˜ê¸? 

	https://ko.wikipedia.org/wiki/%EC%84%AD%EC%94%A8

1) ?˜¨?„ ?‹¨?œ„ ë³??™˜ ?•¨?ˆ˜ cToF(), fToC() êµ¬í˜„?•˜?—¬ ?‹¤?–‰
  
2) ì¶œë ¥?•¨?ˆ˜ printResult() ë³„ë„ êµ¬í˜„. 
	ëª¨ë“  ?‹¤?ˆ˜ float ?ž…? ¥ê³? ì¶œë ¥?? ?†Œ?ˆ˜?  2?žë¦¬ê¹Œì§? ?‘œ?‹œ.

// ì¶œë ¥ ?˜ˆ
// 
//========= ?˜¨?„ë³??™˜ê¸? ===========
//	?ž…? ¥: 36.50C (?„­?”¨) 
//	ê²°ê³¼: ??.??F (?™”?”¨)
//-----------------------------			
//	?ž…? ¥: 80.00F (?™”?”¨) 
//	ê²°ê³¼: ??.??C (?„­?”¨)
//=============================

3) inputC?? inputFë¥? ?žœ?¤?•œ ë²”ìœ„?˜ ?˜¨?„ê°? ?ž…? ¥?•˜?—¬ ?‹¤?–‰?•´ë³´ê¸°. 
	Math.random() ?‚¬?š©, 
	?„­?”¨ ë²”ìœ„: -20.00 ~ +40.00 (?ƒ?•œ ë¯¸í¬?•¨) 
	?™”?”¨ ë²”ìœ„: 4.00 ~ 104.00 (ë¯¸ë§Œ)

*/
public class TemperatureMain_0309 {

	public static void main(String[] args) {
		float inputC = 36.50f; //?„­?”¨
		float inputF = 80.00f; //?™”?”¨
		float inputCR = (float)((Math.random()*60)-20); //?„­?”¨
		float inputFR = (float)((Math.random()*100)+4); //?™”?”¨
		
		printResult(inputC,inputF);
		printResult(inputCR,inputFR);
	}

	private static void printResult(float inputC,float inputF) {
		System.out.println("========= ?˜¨?„ë³??™˜ê¸? ===========");
		System.out.printf("?ž…? ¥: %.2fC (?„­?”¨)\n",inputC);
		System.out.printf("ê²°ê³¼: %.2fF (?™”?”¨)\n",cToF(inputC));
		System.out.println("--------------------------------");
		System.out.printf("ê²°ê³¼: %.2fF (?™”?”¨)\n",inputF);
		System.out.printf("?ž…? ¥: %.2fC (?„­?”¨)\n",fToC(inputF));
		System.out.println("=============================");
	}

	/*++++++++     Â°F -> Â°C (?„­?”¨->?™”?”¨)     ++++++++*/      
	public static float cToF(float c) {
		float f = 0.0f;
		f = (float)(c * 1.8 + 32) ; // Â°F = Â°C Ã— 1.8 + 32
		return f;
	}
	
	/*++++++++     Â°C -> Â°F (?™”?”¨->?„­?”¨)    ++++++++*/      
	public static float fToC(float f) {
		float c = 0.0f;
		 c = (float)((f - 32) / 1.8f); // Â°C = (Â°F ?ˆ’ 32) / 1.8
		return c;
	}
}

