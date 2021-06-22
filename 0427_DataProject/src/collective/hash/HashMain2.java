package collective.hash;

import java.util.HashMap;
import java.util.Set;

public class HashMain2 {

	// 문자키 -> 문자 벨류 대응 hashmap
	public static void main(String[] args) {
		String src = "Rather than dropping in popularity, superyachts"
				+ " have been more in demand than ever during global "
				+ "pandemic.But the same can't be said for passenger "
				+ "jet airplanes. In fact, global business jet deliveries "
				+ "dropped by 20.4% in 2020, while hundreds of airplanes "
				+ "have been decommissioned, with some likely to never fly again.";
		// 'A' -> "airplanes"
		HashMap<Character, String> hm = new HashMap<Character, String>();
		// src긴 문자열을 모둔 대문자화(toUpperCase)하고, 이후 단어들로 쪼개기(split)
		String words[] = src.toUpperCase().split(" ");
		System.out.println("MBD 뉴스 기사 단어 수 : " + words.length);
		for (String word : words) {
			System.out.println(word);
		}

		for (char c = 'A'; c <= 'Z'; c++) {
			for (int i = 0; i < words.length; i++) {
				String word = words[i];
				if (c == word.charAt(0)) {
					hm.put(c, word);
				}
			}
			// 해당 알파벳으로 시작하는 단어가 하나도 없을때
			if(hm.containsKey(c) == false) {
				hm.put(c, " ");
			}
		}
		
//		java.lang.StringIndexOutOfBoundsException -> 오류 나서 확인해 보니 src의 첫 문자가 띄어 쓰기여서 안됨
		System.out.println("-----------------");
		// 문자 키 들의 집합
		Set<Character> keys = hm.keySet();
		for (Character c : keys) {
			System.out.printf("%c - > %s\n",c, hm.get(c)); // 오토 언박싱
		}
		System.out.println("========================");
	

		
		
		
	}
}
