package greet.mutleple;

public class Step6_RetrnTestMain {

	//main은 실행하지만 리턴 값은 없음
	public static void main(String[] args) {
		
		int wa = 60;
		int b = 100;
		int c = wa+ b;
		System.out.println("c =" + c);
		
		int d = add(wa, b);
		System.out.println("d = "+ d);;

		int e = add2(wa, b);
		System.out.println("e = "+ e);;

		System.out.println(dummyint());;
		System.out.println(dummyString());;
		
	}
	
	
	
	public static int add (int a, int b) {
		
		return a+b;
		
	}
	
	
	
	public static int add2 (int a, int b) {
		//임시로 값을 저장 하기 위해 임시 변수(temp)에서 사용
		int temp = a + b ;
		System.out.println("임시결과"+temp);
		return temp;
		
	}

	
	
	//리턴값 100 만 돌려줌
	public static int dummyint() {
		return 100;
		
	}
	
	
	//리턴값 100 만 돌려줌
	public static String dummyString() {
		return "dddd";
	}
	
}
