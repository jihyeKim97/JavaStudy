package HomeWork_0420;
/*
 식당처럼 다수의 사용자들이 한정된 테이블에 좌석하는 문제
 손님은 Guest 타입, 이름/나이/선호맛 등의 필드로 구성.
 테이블은 Table 타입, 이름/구분번호/테이블사이즈/요리맛 등의 필드로 구성.

1. 4개 좌석이 준비된 기본맛 '찌게테이블 FoodTable'을 생성
   4명까지의 손님들을 테이블에 배석처리후 출력함.
   (3명의 손님이 대기중..)
   -------------------------
   1번 '찌게테이블' - 기본맛! 
     [0] 홍길동, 20세, 기본맛
     [1] 안나, 17세, 기본맛
     [2] 울라프, 16세, 기본맛
     [3] 자리 비었음.
     
2. 위 1번을 응용하여, '찌게테이블'에 4명까지 
	동일하게 배석하되, 7명의 대기중인 손님들중
	'기본맛'을 선호하는 손님만 테이블에 좌석에 앉힘.
	(매운맛, 달콤한맛, 짠맛 등을 선호하면 제외..,
	 손님들의 대기 순서는 유지하며 배석해야함..) 
	-------------------------
   1번 '찌게테이블' - 기본맛! 
     [0] 홍길동, 20세, 기본맛      		
     		>> 조안, 12세, 달콤한맛 제외됨.
     		>> 엘사, 18세, 짠맛 제외됨.      		
     [1] 안나, 17세, 기본맛
     		>> 존, 12세, 달콤한맛 제외됨.
     [2] 울라프, 16세, 기본맛
     		>> 빌, 22세, 매운맛 제외됨.
     [3] 자리 비었음.
     
3. 26명의 손님을 생성하여 랜덤하게 4가지 정도 맛으로 초기화..
      테이블 A ~ 테이블 D까지 분류하여 좌석 배치함.
        테이블 A는 기본맛 4석
        테이블 B는 달콤한맛 10석
        테이블 C는 짠맛 6석        
        테이블 D는 매운맛 6석
        
	A번 '찌게테이블' - 기본맛! 
     [0] 홍길동, 20세 
     [1] 안나, 17세 
     [2] 울라프, 16세
     [3] 자리 비었음.         
	B번 '찌게테이블' - 달콤한맛! 
     [0] 홍길동, 20세 
     [1] 안나, 17세 
     [2] 울라프, 16세
     [3] 자리 비었음. 
     ...
     [9] 자리 비었음.  
   C번 '찌게테이블' - 짠맛! 
     [0] 홍길동, 20세 
     [1] 안나, 17세 
     [2] 자리 비었음.
     ...
     [5] 자리 비었음.  
   D번 '찌게테이블' - 매운맛! 
     [0] 홍길동, 20세 
     [1] 안나, 17세 
     [2] 울라프, 16세
     ...
     [5] 울라프2, 26세
     	스벤, 2세 - 제외됨, 자리 꽉찼음.
   		안나, 23세 - 제외됨, 자리 꽉찼음.      
*/


class Guest {
	// 이름/나이/선호맛
	public int flavor; 
}

class FoodTable {
	public static final int FLAVOR_BAISC = 0;
	public static final int FLAVOR_SWEET = 1;
	public static final int FLAVOR_SALTY = 2;
	public static final int FLAVOR_HOT = 3;

	//이름/구분번호/테이블사이즈/요리맛
	public int flavor; 
	public int size;
	public Guest[] chairs;
	
	public FoodTable(int size) {
		this.size = size;
		this.chairs = new Guest[this.size];
	}
}

public class Restaurant {

	public static void main(String[] args) {

	}

}
