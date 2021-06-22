package data.realnum;

public class RealCalMain3 {

	public static void main(String[] args) {
		double a=3, b=4.0;
		
		double c;
		if(b != 0){ //전처리
			c = a/b;			
		}else {
			c = -9.33565351; //Infinity == error
		}
		System.out.println("a / b = c");
		System.out.printf("%.2f / %.2f = %.4f\n",a,b,c);
		System.out.printf("%.2f / %.2f = %.4f\n",a,b,a/b);
		System.out.printf("%% ~ %.2f / %.2f = %.4f\n",a,b,a/b); // %%는 '%'기호 하나임.
		
		
//		int  t = 34.0; //error
//		long  e = 34.0L; //error
		
		//%d == 정수 수치형 10진법 서식자ㄲ
		double d = 345.0;
		System.out.printf("%d / %d = %04d\n",(int)a,(int)b,(int)c);  //절하(내림 flow)절상(오름)
		
		
	}
	public static void numberng() {
		
	}
}
