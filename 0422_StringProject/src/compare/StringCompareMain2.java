package compare;

public class StringCompareMain2 {

	public static void main(String[] args) {
		char c = 'A'; //65
		String s1; // 문자여러개를 묶어서 문자열 객체로 표현
			// s1은 객체의 주소를 담을 수 있는 변수로 선언.
		s1 = "ABCDE"; // 문자열 객체를 s1에 저장(주소를 저장)
		//String s2 = "ABCDE";
		String s2 = new String("ABCDE");
			// 동적으로 생성된 문자열 객체를 s2에 그 주소를 저장
		//
		char[] cArr1 = s1.toCharArray();
		char[] cArr2 = myToCharArray(s2);
		char[] cArr3 = new char[5]; // {0,0,0,0,0} // null;
		char[] cArr4 = {'A', 'B', 'C', 'D', 'E'};
		char[] cArr5 = new char[]{'A', 'B', 'C', 'D', 'E'};
		for (int i = 0; i < cArr3.length; i++) {
			cArr3[i] = (char)('A'+i);
		}
		System.out.println(cArr1);
		System.out.println(cArr2);
		System.out.println(cArr3);
		System.out.println(cArr4);
		System.out.println(cArr5);
		
		char temp[] = new char[] {'A','B','X','Y','E'};
//		char temp[] = new char[] {'A','B','C','D','E'};
//		char temp[] = new char[] {'A','B','C','D'};
//		char temp[] = new char[] {'A','B','X'};
//		char temp[] = null;
		//
		System.out.println(" 두 배열이 동일한지? " + (cArr1 == temp));
		int ret = compareCharArrays(cArr1, temp);
		switch (ret) {
			case COMPARE_NULL_INPUT:
				System.out.println("두 문자 배열들이 NULL 에러!");
				break;
			case COMPARE_DIFF_LENGTH:
				System.out.println("두 문자 배열들이 길이(글자수)가 다른 에러!");
				break;
			case COMPARE_MATCH:
				System.out.println("두 문자 배열들이 서로 내용이 동일함!");
				break;
			case COMPARE_MISMATCH:
				System.out.println("두 문자 배열들이 서로 내용이 다름!");
				break;				
			default:
				break;
		}
	}
	
	// 두 개의 문자 배열들을 받아서 그 내용이 동일한지 비교하기
	public static final int COMPARE_NULL_INPUT = 0;
	public static final int COMPARE_DIFF_LENGTH = 1;
	public static final int COMPARE_MISMATCH = 2;
	public static final int COMPARE_MATCH = 3;
	// 배열도 객체임. 그리고 객체지향의 비교판단은 상대적임(문맥/필요에 따라 정의하기 나름)
	public static int compareCharArrays(
			char[] cArrA, char[] cArrB) {
		// 널체크
		if( cArrA == null || cArrB == null ) 
			return COMPARE_NULL_INPUT;
		
		// 길이가 동일한지 사이즈 비교
		if( cArrA.length != cArrB.length )
			return COMPARE_DIFF_LENGTH; 
		
		// 이제서야 문자요소 개별적으로 비교할 조건이 성립...
		for (int i = 0; i < cArrB.length; i++) {
			if( cArrA[i] != cArrB[i]  ) {
				return COMPARE_MISMATCH; 
				// FM 글자 요소가 만약 단 하나라도 다르다면!! 즉시 끝..
//				break;
			}
		}
		
		return COMPARE_MATCH; // 두 배열의 모든 문자요소가 순서와 값이 일치!
	}
	

	private static char[] myToCharArray(String s2) {
		final int len = s2.length();
		char[] arr = new char[len]; // { '\0', '\0', '\0', '\0','\0'}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = s2.charAt(i);
		}
		return arr;
	}

}



