package text;

// 외국 (저작권 만료)
// https://www.gutenberg.org/ebooks/1342
// 구텐베르그 (오만과 편견)
// 
// 우리나라 (직지)
// http://projectgutenberg.kr/cate_view.php?cate_code1=02

public class WordMatch {

	public static void main(String[] args) {
		// https://www.gutenberg.org/files/1342/1342-h/1342-h.htm#link2HCH0001
		String text = "he" + 
				"It is a truth universally "
				+ "acknowledged, that a single man in "
				+ "possession of a good fortune, must be "
				+ "in want of a wife."  
				+ "However little known the feelings or"
				+ " views of such a man may be on his "
				+ "first entering a neighbourhood, this "
				+ "truth is so well fixed in the minds of"
				+ " the surrounding families, that he is "
				+ "considered the rightful property of "
				+ "some one or other of their daughters."
				+ "“My dear Mr. Bennet,” said his lady to "
				+ "him one day, “have you heard that "
				+ "Netherfield Park is let at last?”"
				+ "Mr. Bennet replied that he had not."  
				+ "“But it is,” returned she; “for Mrs. "
				+ "Long has just been here, and she told "
				+ "me all about it.”"
				+ "Mr. Bennet made no answer." 
				+ "“Do you not want to know who has taken it?” "
				+ "cried his wife impatiently." 				
				+ "“You want to tell me, and I have no "
				+ "objection to hearing it.”"
				+ "This was invitation enough."  
				+ "“Why, my dear, you must know, Mrs. "
				+ "Long says that Netherfield is taken "
				+ "by a young man of large fortune "
				+ "from the north of England; that he "
				+ "came down on Monday in a chaise "
				+ "and four to see the place, and was "
				+ "so much delighted with it, that he "
				+ "agreed with Mr. Morris immediately; "
				+ "that he is to take possession before "
				+ "Michaelmas, and some of his servants "
				+ "are to be in the house by the end of "
//				+ "next week.”";
//				+ "next week.”man"; // OK
				+ "next week.”ma"; // error 비교시 경계를 범위남
//				+ "next week.”m"; // error 비교시 경계를 범위남
				//+ "next week.”he";
//				+ "next week.”h";
		
//		int nLen = text.length();
		
		char[] cArrText = text.toCharArray(); // 1190개?
		
		// 단어 찾기? 
		final String target = "man"; //"he";//"OK";//"to";//"of";
		System.out.println(">> 찾을 단어: " + target); //키워드
		//int nLen = text.length() - 2;
		int nLen = text.length() - (target.length()-1);
		
		int countWord = 0; // 찾은 단어의 개수 카운터
		final int NOT_FOUND = -1;
		int firstFound = NOT_FOUND; 
			// 해당 단어를 처음 발견한 순서번호(위치)
//		for (int i = 0; i < cArrText.length; i++) {
		for (int i = 0; i < nLen; i++) {
			//if( cArrText[i] == target.charAt(0) )
//			if( cArrText[i+0] == 't'  //'o' 
//					&& cArrText[i+1] == 'o' ) { // 'f' ) {
			if( cArrText[i+0] == target.charAt(0)  //'o' 
					//&& cArrText[i+1] == target.charAt(1) ) { // 'f' ) {
					&& cArrText[i+1] == target.charAt(1) 
					&& cArrText[i+2] == target.charAt(2) ) {
				countWord++; // 발견카운트 증가!!
				if( firstFound == NOT_FOUND)
					firstFound = i; // 발견 위치 인덱스 기억..
			}
		}
		//
		System.out.println(target + " 단어의 발견회수: " + countWord);
		if( firstFound == NOT_FOUND)
			System.out.println(target + " 단어가 없어요!!!");
		else
			System.out.println("\t처음 발견된 위치: " + firstFound);
		
		System.out.println("he 처음 발견한 위치: "+text.indexOf("he"));
		System.out.println("Bennet 처음 발견한 위치: "+text.indexOf("Bennet"));
		System.out.println("Morris 처음 발견한 위치: "+text.indexOf("Morris"));
		System.out.println("daughters 처음 발견한 위치: "+text.indexOf("daughters"));
		System.out.println("king 처음 발견한 위치: "+text.indexOf("king"));
		System.out.println("k 처음 발견한 위치: "+text.indexOf("k"));
		System.out.println("k 처음 발견한 위치: "+text.indexOf('k'));
		/*
 			>> 찾을 단어: man
			man 단어의 발견회수: 3
				처음 발견된 위치: 56
			he 처음 발견한 위치: 0
			Bennet 처음 발견한 위치: 389
			Morris 처음 발견한 위치: 1050
			daughters 처음 발견한 위치: 366
			king 처음 발견한 위치: -1
			k 처음 발견한 위치: 30
			k 처음 발견한 위치: 30
			 
		 */
	}

}





