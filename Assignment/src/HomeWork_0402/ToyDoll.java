package HomeWork_0402;

import java.util.Scanner;

/*   인형토이 뽑기 머신 프로그램 ( NC, NEXON, NETMARBLE? 사행성?)
===========================================================

1)	주어진 확률범위에서 Toy 아이템 1개를 뽑는 
// getRandomHero() 함수를 구현.
등급별 확률
5%	LEGEND  
	"뽀로로", "크롱", "포비", "페티"
	"에디", "해리", "통통이", "루피"-
15%	SUPER	
	"아이언맨", "스파이더맨", 
	"캡틴Am.", "토르", "헐크"
30%	RARE
	"엘사", "안나", "울라프"
50%	NORMAL
	"라바", "옐로", "레드", "핑크"
	
--------------------------------------
2) 	
- 반복문을 통해서 위 Toy를 30회 랜덤 뽑기하는 루프를 구현.
- 루프를 다 실행 후, 아래 처럼 출력

  1회차 LEGEND 크롱
  2회차 RARE 울라프 
  ...
  30회차 NORMAL 라바
  -----------------
  30회 총합 결과: 
   	   LEGEND: 3회 (10.00%)
   	   SUPER: 6회 (20.00%)
   	   RARE: 3회 (10.00%)
   	   NORMAL: 18회 (60.00%)

--------------------------------------
   	   	   
3)	* 사용자에게 안내문구를 통해 Toy들을 뽑기 위한 금액을 입력받는다.
그 금액으로 뽑기 1회를 진행할 때마다 금액이 일정 차감됩니다.
모두 차감되어 금액이 0이되거나 (음수 아님...), 
단 1회도 뽑을 수 없게 돈이 남아있지 않으면 반복을 종료함.	
여기서, Toy 1개당 뽑기 1회 금액의 상수는 500원(동전)으로 한다. 

===============================
** 단 10회 이상을 뽑을 수 있는 상태의 금액이라면, 
한 번에 10회 연속 유료뽑기를 무조건 진행하며, 
이 때는 ** 고객 사은 보너스로 1회의 '무료'뽑기를 추가로 더 진행해 준다. (즉 11회 연속 뽑기)
-------------------------------

* 뽑기프로그램: 
  금액을 입력하세요: 6400
 >> 입력된 금액: 총 6400원 
 
 1회차 LEGEND 크롱 (남은 금액: 5900원)
 2회차 RARE 울라프  (남은 금액: 5400원)
  ...
 12회차 NORMAL 라바 (남은 금액: 400원)
 <뽑기 금액 부족!!!> 
 
 LEGEND: 1회 (10.00%)
 SUPER: 2회 (20.00%)
 RARE: 3회 (10.00%)
 NORMAL: 18회 (60.00%) 
 
 
 ** 뽑기프로그램: 
  금액을 입력하세요: 6550
 >> 입력된 금액: 총 6550원 
 
 >> 10회 일괄뽑기 진행....
 1회차 LEGEND 크롱 
 2회차 RARE 울라프 
  ...
 10회차 NORMAL 라바 (남은 금액: 1550원)
                                                                                                                                                                                                                                                                                                                                                       
 11회차 NORMAL 라바 (남은 금액: 1050원)
 12회차 NORMAL 라바 (남은 금액: 550원)
 13회차 NORMAL 라바 (남은 금액: 50원)
 <뽑기 금액 부족!!!>
 	 
 LEGEND: 1회 (10.00%)
 SUPER: 3회 (20.00%)
 RARE: 0회 (10.00%)
 NORMAL: 18회 (60.00%) 
 
 
 
 *** 뽑기프로그램:  
  금액을 입력하세요: 11550  
 >> 입력된 금액: 총 11550원 
  
 >> 10회 일괄뽑기 진행....
 1회차 LEGEND 크롱 
 2회차 RARE 울라프 
  ...
 10회차 NORMAL 라바 (남은 금액: 6550원)
 <FREE 보너스> 11회차 LEGEND 뽀로로
   
 >> 10회 일괄뽑기 진행....
 12회차 LEGEND 크롱 
 13회차 RARE 울라프 
  ...
 21회차 NORMAL 라바 (남은 금액: 1550원)
 <FREE 보너스> 22회차 RARE 안나  
   
 23회차 NORMAL 라바 (남은 금액: 1050원)
 24회차 NORMAL 라바 (남은 금액: 550원)
 25회차 NORMAL 라바 (남은 금액: 50원)
 <뽑기 금액 부족!!!>
 	 
 LEGEND: 5회 (10.00%)
 SUPER: 5회 (20.00%)
 RARE: 5회 (10.00%)
 NORMAL: 18회 (60.00%)
 + 보너스: 2회  
   	
*/

public class ToyDoll {
	public static final int BROKEN_PRI = 500;
	public static final String LEGEND = "LEGEND";
	public static final String SUPER = "SUPER";
	public static final String RARE = "RARE";
	public static final String NORMAL = "NORMAL";

	public static void main(String[] args) {
		String[] dollName = { "뽀로로", "크롱", "포비", "페티", "에디", "해리", "통통이", "루피", "아이언맨", "스파이더맨", "캡틴Am.", "토르", "헐크",
				"엘사", "안나", "울라프", "라바", "옐로", "레드", "핑크" };

		System.out.println("****뽑기 프로그램(1 회당 500원)");
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.print("금액 입력 : ");
			int price = sc.nextInt();
			if (price < 500 || price > 30000) {
				System.out.println("금액 범위는 500원부터 30000원 까지 입니다 다시 입력 ㄱㄱ");
			} else {
				System.out.printf(">> 입력된 금액 : %d원\n", price);
				int cal = price / BROKEN_PRI;
				System.out.printf(">> %d원으로 뽑을수 있는 횟수는 %d회입니다\n\n", price, cal);
				int bonusC = 0, legendC = 0, superC = 0, rareC = 0, namalC = 0;
				double legendP = 0, superP = 0, rareP = 0, nomalP = 0;
				for (int i = 0; i < cal; i++) {
					int ran = (int) (Math.random() * dollName.length);
					if (i % 10 == 0 && i != 1 && i != 0) {
						System.out.printf("\n[보.너.스!!] %d회차 %s을 뽑았어요!! \n\n",i+1, dollName[ran]);
						bonusC++;
						i++;
					}
					if (ran >= 0 && ran <= 8) {
						System.out.printf("%d회차 LEGEND : %s <남은 금액 :: %d원>\n", i + 1, dollName[ran],
								price -= BROKEN_PRI);
						legendC++;
					} else if (ran >= 9 && ran <= 13) {
						System.out.printf("%d회차 SUPER : %s <남은 금액 :: %d원>\n", i + 1, dollName[ran],
								price -= BROKEN_PRI);
						superC++;
					} else if (ran >= 14 && ran <= 16) {
						System.out.printf("%d회차 RARE : %s <남은 금액 :: %d원>\n", i + 1, dollName[ran], price -= BROKEN_PRI);
						rareC++;
					} else if (ran >= 17 && ran <= 20) {
						System.out.printf("%d회차 NORMAL : %s <남은 금액 :: %d원>\n", i + 1, dollName[ran],
								price -= BROKEN_PRI);
						namalC++;
					}
					legendP = ((double) legendC / (double) cal) * 100.0;
					superP = ((double) superC / (double) cal) * 100.0;
					rareP = ((double) rareC / (double) cal) * 100.0;
					nomalP = ((double) namalC / (double) cal) * 100.0;

				}
				System.out.print(" -------뽑기 금액 부족!!뽑기 종료!\n");
//				System.out.print("LEGEND : " + legendC + "회 ("+legendP+"%)\n SUPER : " + superC + "회("+superP+"%)\n RARE : " 
//				+ rareC+ "회("+rareP+"%)\n NOMAL : " + namalC + "회("+nomalP+"%)\n BONUS : " + bonusC + "번");
				System.out.printf("LEGEND : %d회 (%.2f %%)\n",legendC ,legendP);
				System.out.printf("SUPER : %d회 (%.2f %%)\n",superC ,superP);
				System.out.printf("RARE : %d회 (%.2f %%)\n",rareC ,rareP);
				System.out.printf("NOMAL : %d회 (%.2f %%)\n",namalC ,nomalP);
				System.out.printf("BONUS : %d회 \n",bonusC);
				
				
				break;
			}
		}
	}
}
