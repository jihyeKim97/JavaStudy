package string;

public class StringTest2 {

	public static void main(String[] args) {
		// 문자열 분리 
		String wiki = "The pigeon guillemot (Cepphus columba)" 
				+ " is a seabird in the auk family, Alcidae."
				+ " It is dark brown with a black iridescent"
				+ " sheen and a distinctive wing patch "
				+ "broken by a brown-black wedge in breeding "
				+ "plumage.";
		
		String keyword = "wing"; //"seabird";
		int beginIndex = wiki.indexOf(keyword);
		int endIndex = beginIndex + keyword.length(); 
		System.out.println("beginIndex = " + beginIndex); //44
		System.out.println("endIndex = " + endIndex);
		for (int i = beginIndex; i < endIndex; i++) {
			System.out.printf("%c ", wiki.charAt(i));
		}		
		System.out.println("substring = " + 
		wiki.substring(beginIndex, endIndex));
		// 긴 문자열의 일부를 잘라낸 새로운 문자열을 부분문자열로 만들어 리턴
		// beginIndex 포함하여 endIndex 미포함까지의 부분 문자열..
		
		String data = "0123456789"+"ABCDEF";
		String numbers = data.substring(0,10);
		System.out.println("numbers = " + numbers);
		//String alphas = data.substring(10,16);  // 11 x 15 x
		String alphas = data.substring(10);
			// 10 인덱스(열한번째글자)부터 맨 뒤에까지 모든 글자들 ...
		System.out.println("alphas = " + alphas);
		
		String pname = "elsa3";
		String pname2 = "elsa11";
		String name = pname.substring(0, 4);
		//String number = pname.substring(4,5);	// 5-4	
		String number = pname.substring(4);	// 5-4
		System.out.println("선수 이름: " + name);
		System.out.println("선수 번호: " + number);
		String name2 = pname2.substring(0, 4);
		//String number2 = pname2.substring(4,6);		//6-4
		String number2 = pname2.substring(4);		//6-4
		System.out.println("선수 이름2: " + name2);
		System.out.println("선수 번호2: " + number2);
	}

}

/*
beginIndex = 145
endIndex = 149
w i n g substring = wing
numbers = 0123456789
alphas = ABCDEF
선수 이름: elsa
선수 번호: 3
선수 이름2: elsa
선수 번호2: 11
*/