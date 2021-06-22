package HomeWork_0402;

import java.util.Scanner;

/*   인형토이 뽑기 머신 프로그램 ( NC, NEXON, NETMARBLE? 사행성?)
===========================================================


1)   주어진 확률범위에서 Toy 아이템 1개를 뽑는 
// getRandomHero() 함수를 구현.
등급별 확률
5%   LEGEND  
   "뽀로로", "크롱", "포비", "페티"
   "에디", "해리", "통통이", "루피"
15%   SUPER   
   "아이언맨", "스파이더맨", 
   "캡틴Am.", "토르", "헐크"
30%   RARE
   "엘사", "안나", "울라프"
50%   NORMAL
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
         NORMAL: 18회 (70.00%)

--------------------------------------
               
3)   * 사용자에게 안내문구를 통해 Toy들을 뽑기 위한 금액을 입력받는다.
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
 LEGEND: 6회 (70.00%)  
 
 
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
 LEGEND: 9회 (70.00%)  
 
 
 
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
 LEGEND: 10회 (70.00%)
 + 보너스: 2회  
      
*/

public class ToyDoll_end {

   public static final String[] LEGENDITEM = { "뽀로로", "크롱", "포비", "페티", "에디", "해리", "통통이", "루피" };// 5%
   public static final String[] SUPERITEM = { "아이언맨", "스파이더맨", "캡틴Am.", "토르", "헐크" };// 15%
   public static final String[] RAREITEM = { "엘사", "안나", "올라프" };// 30%
   public static final String[] NORMALITEM = { "라바", "옐로", "레드", "핑크" };// 50%   
   public static int countLegend = 0, countSuper = 0, countRare = 0, countNormal = 0;
   public static int MIN_COIN = 500;

   public static void main(String[] args) {
      System.out.println("***뽑기프로그램: ");
      Scanner sc = new Scanner(System.in);
      System.out.println("금액을 입력하세요: ");
      int input = sc.nextInt();
      int count = 0;
      final int BONUS = input / 5000 ; //입력한 값의 나누기 5000(10회차 마다) ex)10000 = 2
      final int LIMIT = (input / 500) + BONUS;
      boolean ten = false; // 10연차 진행중 플래그
      int bi = 0; // 0 ~ 9 일괄 10연차 뽑기 과정인덱스
      int b = 0; // 보너스 처리 카운터
      
      for (int i = 0; i <LIMIT; i++) { // 입력수에 따른 뽑기 횟수         
         int hundredCases = (int) (Math.random() * 100); // 0~99
         count++;         
         System.out.printf("ten = %s, b = %d, BONUS = %d,bi = %d, count = %d \n", ten, b,BONUS, bi, count); // 디버그용
         if (BONUS != 0 && b < BONUS && ten == false ) { 
            System.out.println(">>10회 일괄진행...");
            ten = true;
            bi = 0;
         }               
         if( ten == false || (ten == true && bi <= 9) ) {
            input -= 500;
            if (ten == true && bi < 9) 
               System.out.printf("%d 회차 %s\n", count, getRandomHero(hundredCases));
            else 
               System.out.printf("%d 회차 %s (남은 금액: %d)\n", count, getRandomHero(hundredCases), input);            
            if ( ten == false && input < MIN_COIN) System.out.println("잔액이 부족함!!A");         
         } 
         if(ten == true && bi == 10) {            
            System.out.printf("<FREE 보너스!>%d 회차 %s\n", count , getRandomHero(hundredCases));
            ten = false;
            b++;
            if (input < MIN_COIN) System.out.println("잔액이 부족함!!B");            
         }
         if( ten == true ) bi++;                     
      }
      System.out.println("-----------------------");
      System.out.println("총 " + count + "회 뽑기");
      System.out.printf("LEGEND: %d회 (%.2f%%) \n", countLegend, ((double) countLegend / count) * 100);
      System.out.printf("SUPER: %d회 (%.2f%%) \n", countSuper, ((double) countSuper / count) * 100);
      System.out.printf("RARE: %d회 (%.2f%%) \n", countRare, ((double) countRare / count) * 100);
      System.out.printf("NORMAL: %d회 (%.2f%%) \n", countNormal, ((double) countNormal / count) * 100);
      System.out.println("보너스: " + b +"회");
   }

   public static String getRandomHero(int input) {
      if (input <= 5) {
         countLegend++;
         return ("Legend " + LEGENDITEM[(int) (Math.random() * LEGENDITEM.length)]);
      } else if (input >= 5 && input <= 20) {
         countSuper++;
         return ("Super " + SUPERITEM[(int) (Math.random() * SUPERITEM.length)]);
      } else if (input >= 20 && input <= 50) {
         countRare++;
         return ("Rare " + RAREITEM[(int) (Math.random() * RAREITEM.length)]);
      } else if (input >= 50 && input <= 100) {
         countNormal++;
         return ("Normal " + NORMALITEM[(int) (Math.random() * NORMALITEM.length)]);
      } else
         return "error";
   }
}