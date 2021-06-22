package collective;
import java.util.HashSet;

public class DataMain2 {

	public static void main(String[] args) {
		// 문자(객체)들의 집합 -- Character 객체
		HashSet hs = new HashSet();
		hs.add('X');
		char c = 'Y'; //new Character('Y');
		hs.add(c);
		
		for (Object ch : hs) {
			char p = (char)ch;
//			System.out.printf(" 문자 하나 %c \n", ch);
			System.out.printf(" 문자 하나 %c (%d) \n", p,(int)p);			
		}
		System.out.println("----------------");
		
		String xyz = "XYZ";
		hs.add(xyz.charAt(xyz.length()-1)); //'Z'
		
		hs.add('a'); hs.add('b'); hs.add('c');
		hs.add('가'); hs.add('바'); hs.add('하');
		
		for (Object ch : hs) {
			char p = (char)ch;
			System.out.printf(" 문자 하나 %c (%d) \n", p,(int)p);			
		}
		// 집합은 순서에 의미가 없어...서   순서가 중요한 처리라면
		// 집합 데이터를 배열/리스트로 복제하여 정렬을 처리해야 함. 
	}

}

/*
문자 하나 X (88) 
문자 하나 Y (89) 
----------------
문자 하나 가 (44032) 
문자 하나 a (97) 
문자 하나 b (98) 
문자 하나 c (99) 
문자 하나 바 (48148) 
문자 하나 X (88) 
문자 하나 하 (54616) 
문자 하나 Y (89) 
문자 하나 Z (90) 
*/