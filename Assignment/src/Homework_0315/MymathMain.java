package Homework_0315;

/*
1) ���� �Լ� �ݿø�, ����, ������ 3�� ���� ���� �� ������ ��� ��� 

2) ���� �� 0.0 ~ 100.00 �������� ����Ͽ� ��� ��� 

��� ��) 

*** �Ǽ� ��ġ�� ������ȯ ***

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
myRound(������) => ����������??
myFloor(������) => ����������??
myCeil(������) => ����������??

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