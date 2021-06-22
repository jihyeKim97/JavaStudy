package data.realnum;

public class RealCalMain4 {

	public static final float ZERODIV_ERROR = -0.00001f; //클래스 공통 상수 정의 (클래스 상수, 스태틱상수)
	public static void main(String[] args) {

		//3.14f
		float x = 20.3633f , y = (float)(Math.PI);
		float z = 0.0f; // 4byte 실수형으로 변환
		
		//실수 나눗셈 실행후 출력하는 함수
//		dividePrint(x,y);
		dividePrint(145.0F,123.4F);
		
		final float ZERODIV_ERROR = -0.0012f;
		y=0.0f;
		z= divideRetrun(z, y);
		if(z == ZERODIV_ERROR) {
			System.out.println("errroorr");
		}else {
			System.out.println("z="+z);
		}

		
		float reult = divideRetrun(divideRetrun(100.0f,33f),0.6f);
		System.out.println(reult +"= reult");
		//함수의 실행 결과 리턴 값이 연이어서 다시 함수의 입력으로 사용
		
		float temp = divideRetrun(100.0f, 33f); // 임시기억하여
		float result1= divideRetrun(temp, 2.0f);
		System.out.println(result1 +"= result1");
		System.out.println(temp +"= temp ");
		
	}//main end
	
	private static float divideRetrun(float a, float b) {
		if(b == 0.0f) {
			System.out.println("err");
			return ZERODIV_ERROR; // 리턴을 만나면 함수는 바로 종료
			//	다만, viod리턴형이기에 리턴값은 없음
			
		}
			float c = a/b;
			System.out.printf("실수 나눗셈 : %f ÷ %f = %f \n",a,b,c);
			 // %같은 서식자에는 데이터나 변수가  "순서, 개수, 타입"이 일치하면 문제 없음; 
		
		return c;
	}
	private static void dividePrint(float x, float y) {
		if(y == 0.0f) {
			System.out.println("err");
			return; // 리턴을 만나면 함수는 바로 종료
			//	다만, viod리턴형이기에 리턴값은 없음
			
		}else {
			float z = x/y;
			System.out.printf("실수 나눗셈 : %f ÷ %f = %f \n",x,y,z);
			// %같은 서식자에는 데이터나 변수가  "순서, 개수, 타입"이 일치하면 문제 없음; 
		}
	}
}
