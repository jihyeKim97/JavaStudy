package Homework_0315;

/*
1) 수학 함수 반올림, 절상, 절하의 3개 직접 구현 및 고정값 결과 출력 

2) 랜덤 수 0.0 ~ 100.00 랜덤수를 사용하여 결과 출력 

출력 예) 

*** 실수 수치값 정수변환 ***

myRound(3.141592) => 3
myRound(5.50) => 6
myRound(3.99) => 4

myFloor(3.141592) => 3
myFloor(5.50) => 5
myFloor(3.99) => 3

myCeil(3.141592) => 4
myCeil(5.50) => 6
myCeil(3.99) => 4
==================== 0~100.0
myRound(랜덤값) => 랜덤값정수??
myFloor(랜덤값) => 랜덤값정수??
myCeil(랜덤값) => 랜덤값정수??

*/
public class MymathMain {

	public static void main(String[] args) {
		double input1 =-4.5;
		double douNum = input1-(int)input1;

		if(0.0 > input1) {
			if(0.5 <= Math.abs(douNum)) {
				input1 = ((int)input1-1);
			}else{
				input1 = (int)input1;
			}
		}else if(0.0 <= input1) {
			if(0.5 <= douNum) {
				input1 = (input1-douNum)+1;
			}else if(0.5 > douNum) {
				douNum = 0;
				input1 = (int)input1+douNum;
			}
		}
		System.out.println(input1);				
	}
	
	
}