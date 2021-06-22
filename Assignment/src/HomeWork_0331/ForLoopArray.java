package HomeWork_0331;
/*
	문자 배열 alphabets를 길이 26으로 만듭니다.
	alphabets를 모두 0으로 초기화합니다.
	(alphabets를 모두 '\0'으로 초기화합니다.)
	0 ~ 25까지의 순서번호로 요소를 접근
	length는 26.
	항상 for문을 사용하여 배열에 내용을 표시합니다.
	--------------------------------------
	1. for() 루프를 사용하여 alphabets 배열을 
	'A' 부터 차례대로 'Z'까지 채워줍니다.
	채워진 alphabets 배열을 화면에 출력합니다.    	
	1번 배열내용: A B C D E F G ... X Y Z
	
	2. for() 루프를 사용하여 alphabets 배열을 
	'z' 부터 차례대로 'a'까지 채워줍니다.
	채워진 alphabets 배열을 화면에 출력합니다.    	
	2번 배열내용: z y x w v ... d c b a
	
	3. 	for() 루프를 사용하여 alphabets 배열을
	임의의 랜덤한 대문자 ?로 채워줍니다.
	'A' ~ 'Z' 사이중에서 한 글자!!
	3번 배열내용: A C C F F X X Y W ... A B C
	
	4. 	for() 루프를 사용하여 alphabets 배열을
	임의의 랜덤한 소문자 ?로 채워줍니다.
	'a' ~ 'z' 사이중에서 한 글자!!
	단, 매번 배열에 새로운 랜덤 소문자를 입력하기 전에...
	기존까지 입력된 소문자들과 중복되는 경우라면, 
	제외하고 다시 신규 랜덤 소문자를 생성하여 입력 시도.
	그리고 재시도 내용을 모두 프린트!!
	4번 배열내용: 
			     8회차에 c가 중복 생성!
			     12회차에 w가 중복 생성!
			     ...   			     
			     c b a x y z w h y q d .. e f   
*/

public class ForLoopArray {

	public static void main(String[] args) {
		System.out.print("1번배열내용 : ");
		char alphabetsSmall[] = new char[26];
		for (int i = 0; i < alphabetsSmall.length; i++) {
			alphabetsSmall[i] = (char) (97 + i);
			System.out.print(alphabetsSmall[i] + " ");
		}
		System.out.println();
		System.out.print("2번배열내용 : ");
		char alphabetsLarge[] = new char[26];
		for (int i = 0; i < alphabetsLarge.length; i++) {
			alphabetsLarge[i] = (char) (65 + i);
			System.out.print(alphabetsLarge[i] + " ");
		}

		System.out.println();
		System.out.print("3번배열내용 : ");
		char ranAlphabetsLarge[] = new char[26];
		for (int i = 0; i < ranAlphabetsLarge.length; i++) {
			ranAlphabetsLarge[i] = (char) (65 + ((int) (Math.random() * 26)));
			System.out.print(ranAlphabetsLarge[i]+" ");
		}
		
		System.out.println();
		System.out.print("4번배열내용 - \n");
		char ranAlphabetsSmall[] = new char[26];
		boolean filter = false;
		for (int i = 0; i < ranAlphabetsSmall.length; i++) {
			int ran = (int) (Math.random() * 26);
			ranAlphabetsSmall[i] = (char) (97 + ran);
			if(ranAlphabetsSmall[i] == (char)(97+ran)) {
				filter = true;
			}
			System.out.printf("%d회차 알파벳 : %c \n",i+1,ranAlphabetsSmall[i]);
			if(filter == true) {
				System.out.println("중복알파벳 : "+ranAlphabetsSmall[i]);
			}
			
		}

	}

}
