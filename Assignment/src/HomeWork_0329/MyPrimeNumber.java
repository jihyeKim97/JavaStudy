package HomeWork_0329;

/*
소수(솟수; Prime Number) 구하기 '함수'를 구현  
=> 1과 자신의 수를 제외하고 약수가 없는 수

보통의 알고리즘:  2부터 숫자 N-1까지의 범위에서 반복적인 
			   자신을 나눌 수 있는 약수가 있는지를 체크하여
			   단 하나라도 약수가 발견되는 그수 N은 소수가 아님.

	문제 1) isPrimeNumber() 구현하여 아래처럼 출력.
	31은 소수.   isPrimeNumber(31)
	100은 합성수. isPrimeNumber(100)
	997은 ????. isPrimeNumber(997)
	
	문제 2) 스캐너나 main() args로 최대범위 정수를 입력받아 
	  해당 최대 범위 수까지의 모든 소수를 출력 합니다. 
	 그리고 마지막에  발견한 총 소수 개수를 출력함. 
	 (단, 5개 소수 발견마다 개행문자 출력함)   
   만번, 10만번? 100만번? 
    최대 범위를 입력하세요: 10000
  2 소수, 3 소수, 5 소수, 7 소수, 11 소수,
  13 소수, 17 소수, 19 소수, 23 소수, 29 소수,
  31 소수, ...,
  9997 소수??
	  ----------------------------------
	  2부터 10000까지의 소수의 총개수: OOO개
	   
*/


public class MyPrimeNumber {
	
	public static boolean isPrimeNumber(int num) {
		
		return false; 
		// 소수가 아니면 false, 소수면 true를 리턴 
	}
	
	public static void main(String[] args) {
		System.out.println("31 은 " + 
				(isPrimeNumber(31) ? "소수": "합성수") );
		System.out.println("100 은 " + 
				(isPrimeNumber(100) ? "소수": "합성수") );
		System.out.println("997 은 " + 
				(isPrimeNumber(997) ? "소수": "합성수") );
	}

}
