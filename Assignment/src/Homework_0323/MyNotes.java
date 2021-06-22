package Homework_0323;

import java.util.Scanner;

/*
1)  1이 '도'' 변환, 2가 '레'로 변환시켜주는 
	whichNote()함수를 정의함. 

	whichNote(1) => "도"가 리턴되는 음표(Note) 대응 함수 임.  
	whichNote() 함수를 switch/case  
			혹은 if/elseif/else 다중분기분으로 구현	
	
	즉,  1 2  3 4 5 6  7  8  라면.. 
		도-레-미-파-솔-라-시-도' 출력
	
		8   7 6 5  4 3  2 1  이라면..
		도'-시-라-솔-파-미-레-도  출력	
		  
	* Scanner를 이용하여 임의의 정수를 마디수로 입력받아 출력 구현... 
	
	=== 계이름 출력 프로그램 === 
	마디 수 입력: 8 
	솔솔라라 | 솔솔미미 | 솔솔라라 | 솔솔미미   ||
	솔솔라라 | 솔솔미미 | 솔솔레레 | 도도도'도 ||
	
	마디 수 입력: 6 
	솔솔라라 | 솔솔미미 | 솔솔라라 | 솔솔미미 ||
	솔솔라라 | 솔솔미미 |
		
	마디 수 입력: 13 
	솔솔라라 | 솔솔미미 | 솔솔라라 | 솔솔미미 ||
	솔솔라라 | 솔솔미미 | 솔솔라라 | 솔솔미미 ||
	솔솔라라 | 솔솔미미 | 솔솔라라 | 솔솔미미 ||
	솔솔라라 | 
		  
	단, 랜덤하게 모든 음표를 생성합니다. 도 ~ 도'
	마디마다 반드시 4개 음표를 생성하여 표시.
	각 마디의 끝마다 "|"를 출력하여표시. 
	그리고 매 반복되는 4마디의 끝마다 "||"절로써 종료 표시.
	
	만약 마디 수 입력이 4 미만이면.. 
	"잘못된 마디 수"로 출력하고 다시 입력 받는 
	로직을 do / while 문으로 구현.
*/
public class MyNotes {

	public static void main(String[] args) {
		System.out.println("----계이름 출력 프로그램----");
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.print("마디수 입력 : ");
			int madi = sc.nextInt();
			if (madi < 4) {
				System.out.println("+++4미만의 숫자는 받지 않음 다시 임력 하셈");
			} else {
				for (int i = 1; i < madi + 1; i++) {
					for (int j = 1; j <= 4; j++) {
						int ran = (int) (Math.random() * 7) + 1;
						switch (ran) {
						case 1:
							System.out.print("도");
							break;
						case 2:
							System.out.print("레");
							break;
						case 3:
							System.out.print("미");
							break;
						case 4:
							System.out.print("파");
							break;
						case 5:
							System.out.print("솔");
							break;
						case 6:
							System.out.print("라");
							break;
						case 7:
							System.out.print("시");
							break;
						case 8:
							System.out.print("도#");
							break;
						}
					}
					if (i % 4 == 0) {
						System.out.print("||\t\n");
					} else {
						System.out.print("|\t");
					}
				}
				break;
			}
			System.out.println();
		}
	}
}
