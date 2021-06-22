package string;

public class StringTest3 {
// https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#method.summary
	public static void main(String[] args) {
		// 문자열 분리의 일반화
		String ex = "I am a girl.";  // 12자?
		String ex2 = "I am a boy.";  // 11
		// 7 인덱스위치로 분리..
		String front = ex.substring(0, 7); // 앞의 7개 글자들 부분 문자열
		String back = ex.substring(7); // 7위치를 포함하며 뒤의 '남은' 문자들..
		System.out.println(front);
		System.out.println(back);
		String[] strs = separateString(ex2, 7);
		for (String s : strs) {
			System.out.println(s);
		}
		
		String childDay = "1016 – Edmund Ironside "
				+ "(pictured) became King of England,"
				+ " reigning for only seven months "
				+ "before the country was conquered "
				+ "by Cnut the Great.";
		//String[] cds = childDay.separateus()
		//String[] cds = separateStringforKeyword(childDay, "King");
		String[] cds = separateStringforKeyword(childDay, "the country");
		
		if( cds != null) {
			System.out.println(cds[0]);
			System.out.println(cds[1]);
		}
		
		// 긴 문자열을을 여러개의 부분문자열들로 분리하기
		String[] words = childDay.split(" "); 
			// split()은 정규식 문자열을 취급함에 주의!!!!!!!!!! regex 
		for (String word : words) {
			System.out.println(word);
		}
		
		// ??
		String msgs = "abc,defg,12345,49038x,yzAQW!!,4";
		String[] units = msgs.split(",");
		for (String unit : units) {
			System.out.println(unit);
		}
		
		String msgs2 = 
			" el sa, an  na, o  laf,   abc  ,  "
			+ " defg  ,123   45,49  03 8x,y zA   QW! !,4";
		String units2[] = msgs2.split(",");
		for (String unit : units2) {
//			System.out.println(unit);
			System.out.println(unit.trim()); // 문자열 좌우공백없애기
		}
		
		// 문자열 대체처리하기 (바꿔치기) 
		for (String unit : units2) {
			String trimStr = unit.trim();
//			String reStr = trimStr.replace(" ", ""); // empty
			String reStr = trimStr.replace(" ", "-"); // hypeun
			System.out.println(reStr);
		}
	}

	// 긴 문자열의 특정 단어 전과 후의 두 개로 분리하는 함수
	public static String[]
			separateStringforKeyword(String src, String kw) {
		int breakPt = -1;
		if( src != null && kw != null
			&& !src.isEmpty() && kw.isEmpty() == false ) {
			breakPt = src.indexOf(kw);
		}
		return separateString(src, breakPt); 
	}
	
	// 긴 문자열을 중단점 위치 기준으로 앞과 뒤의 
	// 두 개의 부분문자열로 분리하고 이를 배열로 리턴하기.
	public static String[] separateString(String src, int breakPt) {
		if( src == null || src.isEmpty() || 
//			breakPt < 0 || src.length() <= breakPt ) {
			breakPt < 0 || src.length() < breakPt ) {
			System.out.println("문자열 분리 불가능! ");
			return null;
		}		
		String front, back;
		front = src.substring(0, breakPt);
		back = src.substring(breakPt); 
//		String[] ret = new String[2];
//		ret[0] = front; ret[1] = back;
//		return ret;
		return new String[] {front, back};
	}
}
