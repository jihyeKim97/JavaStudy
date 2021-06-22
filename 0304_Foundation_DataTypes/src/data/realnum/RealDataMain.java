package data.realnum;

public class RealDataMain {

	public static void main(String[] args) {
		// 자바의 수치형 데이터 표현(셀수있음, 양)
		// 정수(byte,short,int,long) 혹은 실수(float,double)
			//float == 4바이트
			//실수형은 수치값의 크기 및 양의 개념 x
			// real number 는 실수, 소수점 ==> precision (정밀도) 문제를 다룸
			// 0(4바이트), 0L(8바이트) , 0l(8바이트), 0,0F(4바이트), 0.0f(4바이트)
			// f,F 수치값 끝에 붙이면 4바이트 실수형 float형 데이터로 변환
		
		// 정수표현 : 자바의 기본은 무조건 int형 취급(4바이트 int) 123,		100,		5,		0
		// 실수(소수점)표현 : 자바의 기본 double형 퀴급(8바이크 double),0.0		0.2	1.0	3.141592
		
		
		
		double num1 = 3.141592;
		double num2 = 3.141592653589793;
		double num3 = 3.1415926536897932384626433832795028841971;
		double PI = Math.PI;
		
		System.out.println("PI = "+PI); // 원주와 지름의 비율 인 파이에 가장 가까운 double 값입니다.
		System.out.println("num1 = "+ num1);
		System.out.println("num2 = "+num2);
		System.out.println("num3 = "+num3);
		
		
		float num4 = 3.14f;
		float num5 = 3.141592653589793f;
		float num6 = 3.1415926536897932384626433832795028841971f;
		
		System.out.println("num4 = "+num4); 
		System.out.println("num5 = "+num5); 
		System.out.println("num6 = "+num6); 
		
		float num7 = (float)num3;
		System.out.println("num7(데이터캐스팅) = "+num7);
		
		
	}

}
