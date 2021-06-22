package data.realnum;

public class RealCalMain {

	public static void main(String[] args) {
		int a = 3;
		long b = 3L;
		long c = 3;
		double x = 3.14f;
		double y = Math.PI; // static 상수 PI 𝜋
		
		// 산술연산
		double z1 = x+y;
		double z2 = x-y;
		double z3 = x*y;
		double z4 = x/y;
		
		System.out.println(z1);
		System.out.println(z2);
		System.out.println(z3);
		System.out.println(z4);
	
		// printf 포맷 형식 format을 가지고 출력
		// %f 같은 서식자는 나중에 변하는 값이나 변수 같은 데이터가 서식자에 위치에 출력
			// %f는 실수형 소수점 자리수 데이터를 출력해주는 서식자임
			// %.3f == 소수점 3번째 자리까지 출력
		
		System.out.printf("%f+%f=%f \n",3.14,0.99,1.00);
		System.out.printf("%.2f+%.2f=%.2f",3.14,0.99,1.00);
		
		System.out.printf("%.2f+%.2f=%.2f \n",10.0,20.123,1.333335);
		System.out.printf("%.2f+%.2f=%.2f \n",x,y,z1);
		System.out.printf("%.2f-%.2f=%f \n",x,y,z2);
		System.out.printf("%.2f*%.2f=%.2f \n",x,y,z3);
		System.out.printf("%.2f/%.2f=%f \n",x,y,z4);
	}

}
