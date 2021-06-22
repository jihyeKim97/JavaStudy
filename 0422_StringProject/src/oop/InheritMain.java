package oop;

//public class InheritMain extends Object { // 생략
public class InheritMain {

	public static void main(String[] args) {
		// 상속: inherit (부모클래스의 자원-필드/메소드을 물려받아 재사용)
		// 		Object는 최상위 자바 클래스로써 암시적으로 상속이 
		//		모든 클래스에 생략됨
		//		=> Object는 즉 가장 일반화, 가장 상징화된 최상의 분류.
		//		- 객체라면... 가져야하는 최소의 일반 기능을 갖춘 것이 Object임.
		//		1. 객체 자신의 내용을 표현할 수 있다. toString() 
		//		2. 객체들간에 비교/판단을 수행 할 수 있다. equals() 
		//      3. 객체의 고유번호가 가질 수 있다. hashCode()
		InheritMain in = new InheritMain();
//		System.out.println(in); // toString()
		System.out.println(in.toString());
		System.out.println(in.hashCode());
		InheritMain in2 = new InheritMain();
		System.out.println(in2.toString());
		System.out.println(in2.hashCode());
		
//		if( in == in2 ) 
//			System.out.println("우리는 서로 같아요!!");
//		else // in != in2
//			System.out.println("우리는 서로 달라요..");
		System.out.println("서로 같지? " + (in == in2));
		System.out.println("서로 다르지? " + (in != in2));
//		System.out.println("서로 다르지? " + ((in == in2)==false));
		if( in.equals(in2) == true )
			System.out.println("우리는 한민족!");
		else
			System.out.println("우리는 다민족!!!");
		//
//		Object obj = new Object(); // 타입?
//		obj.toString();
		
		Object ob1 = in; // 상속 다형성
		Object ob2 = in2;
		Object ob3 = "abcd";
		Object ob4 = 3.14;
		Object ob5 = 'A'; 
		// Object 타입 변수에는 자바의 모든 데이터를 담을 수 있음.
		// 어떤 타입의 데이터든지 Object에는 저장됨.
		
		
	}

}
