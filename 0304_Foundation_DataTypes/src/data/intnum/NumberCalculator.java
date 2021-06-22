package data.intnum;

public class NumberCalculator {

	public static void main(String[] args) {
		// 정수 계열의 변수들 나열
		// 부호 signed
		int numA = 100;
		int numB = (int)((Math.random()*1000)/10);
		// 산술연산자 (Arithmetic operator)
		// + - * /
		int sumVal, diffVal, mulVal, divVal = 0;
		
		sumVal = numA + numB;
		diffVal = numA - numB;
		mulVal = numA * numB;
		
//		if(numB > 0) {
		if(numB != 0) {
			divVal = numA / numB;
			System.out.println(">>나눗셈 실행");
		}else {
			System.out.println("0은 나눌수 없음");
		}
		
		// 나머지 연산자
		int modVal =0;
		modVal = numA % numB;
		// 나머지 연산자도 0이 아닐때만 
		
		//0으로 나눗셈을 수행하면 예외가(실시간 에러) 발생
		
		System.out.println(numA +"+"+ numB+"="+ sumVal);
		System.out.println(numA +"-"+ numB+"="+ diffVal);
		System.out.println(numA +"*"+ numB+"="+ mulVal);
		System.out.println(numA +"/"+ numB+"="+ divVal);
		System.out.println(numA +"%"+ numB+"="+ modVal);
		
	}

}
                                                                                         