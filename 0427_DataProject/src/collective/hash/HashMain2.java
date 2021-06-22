package collective.hash;

import java.util.HashMap;
import java.util.Set;

public class HashMain2 {

	// ����Ű -> ���� ���� ���� hashmap
	public static void main(String[] args) {
		String src = "Rather than dropping in popularity, superyachts"
				+ " have been more in demand than ever during global "
				+ "pandemic.But the same can't be said for passenger "
				+ "jet airplanes. In fact, global business jet deliveries "
				+ "dropped by 20.4% in 2020, while hundreds of airplanes "
				+ "have been decommissioned, with some likely to never fly again.";
		// 'A' -> "airplanes"
		HashMap<Character, String> hm = new HashMap<Character, String>();
		// src�� ���ڿ��� ��� �빮��ȭ(toUpperCase)�ϰ�, ���� �ܾ��� �ɰ���(split)
		String words[] = src.toUpperCase().split(" ");
		System.out.println("MBD ���� ��� �ܾ� �� : " + words.length);
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
			// �ش� ���ĺ����� �����ϴ� �ܾ �ϳ��� ������
			if(hm.containsKey(c) == false) {
				hm.put(c, " ");
			}
		}
		
//		java.lang.StringIndexOutOfBoundsException -> ���� ���� Ȯ���� ���� src�� ù ���ڰ� ��� ���⿩�� �ȵ�
		System.out.println("-----------------");
		// ���� Ű ���� ����
		Set<Character> keys = hm.keySet();
		for (Character c : keys) {
			System.out.printf("%c - > %s\n",c, hm.get(c)); // ���� ��ڽ�
		}
		System.out.println("========================");
	

		
		
		
	}
}
