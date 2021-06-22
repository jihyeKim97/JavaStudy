package collective.hash;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMain9 {

	public static void main(String[] args) {
		// ÇÑ±Û ¹®ÀÚ ¸®½ºÆ®?
		ArrayList<Character> cList1
						= new ArrayList<>();
		for(char c = '°¡'; c <= 'ÆR'; c++ ) {
//			cList1.add( new Character(c));
			cList1.add(c);
		}
		for (int i = 0; i < cList1.size(); i++) {
			System.out.print(cList1.get(i) +" ");
			if( (i + 1) % 10 == 0)
				System.out.println();
		}
		
		// ¿µ¿õÆÀ¸Ê: ¸ÊÀÇ ¿ä¼Ò°¡ ¸®½ºÆ®ÀÎ °æ¿ì
		// ¸®½ºÆ®ÀÇ ¿ä¼Ò°¡ ¸ÊÀÎ °æ¿ì..?
		
		// ¹®ÀÚ¿­Å°  => ¹®ÀÚ¹ë·ù ¸ÊÀ» Ç¥Çö 
		// ¸®½ºÆ®ÀÇ ¿ä¼Ò·Î½á ÀÌ ¸ÊÀ» ¼ø¼­´ë·Î ÀúÀå.
		
		// ¿µ¹® ¹®ÀÚ¸Ê(?) ¸®½ºÆ®
		// ¿µ¹® ¹®ÀÚ¸Ê °´Ã¼ ¿ä¼ÒÀÇ Å°´Â String°ªÀº ¸ðµåÀÌ¸§
		//		https://www.compart.com/en/unicode/U+0041
		// 		¿µ¹® ´ë¹®ÀÚUPPER ¸ðµå,  
		//  	https://www.compart.com/en/unicode/U+0061
		//		¿µ¹® ¼Ò¹®ÀÚLOWER ¸ðµå...
		//		
		// 		¿µ¹® ¼­Å¬¹®ÀÚ CIRCLE ¸ðµå...
		//
		//		¿µ¹® ½ºÄù¾î¹®ÀÚ SQUARE ¸ðµå...
		
		ArrayList<HashMap<String,Character>>
			cList2 = new ArrayList<>();
		
		// ¿µ¹® ´ë¹®ÀÚ Å½»ö ·çÇÁ A ~ Z
		for (char c = 'A'; c <= 'Z'; c++) {
			HashMap<String,Character>
			 eng = new HashMap<String,Character>();
			eng.put("UPPER", c); // 'A'
			eng.put("LOWER", (char)(c+' ')); // 'a' = 'A' + 32
			//
			cList2.add(eng);
		}
	}

}

