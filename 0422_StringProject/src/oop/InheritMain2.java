package oop;

//class Dummy {}
//class Dummy extends Object {}
class Dummy {
	public void sayDummy() {
		System.out.println(this.toString());// oop.Dummy@3d4eac69
	}
	
	// 함수재정의 override 오버라이드
	public String toString() {
		return "더미족객체! " + super.toString();
	}
}

class Dummy2 {
	private int _myHashCode;
	public Dummy2( ) {
//		this._myHashCode = (int)(Math.random() * 10) + 1; // 1 ~ 10
		// 더미2족 객체들은 태어날 때 고유?번호를 부여 받는다.
		this._myHashCode = (int)(Math.random() * 60) + 1; // 1 ~ 60
	}
	
	public void sayDummy() {
		System.out.println("나를표현: " + this.toString());
		System.out.println("나의고유값: " + this.hashCode());
		System.out.println("나를 비교: " + this.equals(this));// true
	}

	@Override
	public int hashCode() {
		return this._myHashCode;
//		return (int)(Math.random() * 10) + 1; // 1 ~ 10
//		return super.hashCode();
	}

	// 객체지향 세계에서는 객체들 끼리의 동등성 비교는 정의하기 나름.
	// 즉, equals() 함수 재정의로 판단됨. true 같음, false 다름.
	@Override
	public boolean equals(Object obj) {
		//return true;
//		return (int)(Math.random() * 10) % 2 == 0;
		//return super.equals(obj);
		if( obj instanceof Dummy2 ) {
			int meHC = this.hashCode();
			int youHC = ((Dummy2)obj).hashCode();
			if( meHC == youHC ) return true;
			else return false;
		} else
			return false;
	}

	@Override // 부가기능 어노테이션
//	public String toString(int a) {
	public String toString() {
		return "더미족II객체! " + super.toString();
	}
	
	
	
	// 함수재정의 override 오버라이드
//	public String toString() {
//		return "더미족II객체! " + super.toString();
//	}
}

//public class InheritMain extends Object { // 생략
public class InheritMain2 {

	public static void main(String[] args) {
		// 상속: inherit (부모클래스의 자원-필드/메소드을 물려받아 재사용)
		// 		Object는 최상위 자바 클래스로써 암시적으로 상속이 
		//		모든 클래스에 생략됨
		//		=> Object는 즉 가장 일반화, 가장 상징화된 최상의 분류.
		//		- 객체라면... 가져야하는 최소의 일반 기능을 갖춘 것이 Object임.
		//		1. 객체 자신의 내용을 표현할 수 있다. toString() 
		//		2. 객체들간에 비교/판단을 수행 할 수 있다. equals() 
		//      3. 객체의 고유번호가 가질 수 있다. hashCode()
		InheritMain2 in = new InheritMain2();
//		System.out.println(in); // toString()
		System.out.println(in.toString());
		System.out.println(in.hashCode());
		InheritMain2 in2 = new InheritMain2();
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
		
//		Dummy d0 = new Dummy(); 
////		System.out.println(d0); // d0.toString()
//		d0.sayDummy();
		Dummy2 d2 = new Dummy2(); // 기준 더미
		d2.sayDummy();
//		System.out.println(d2.hashCode());
//		System.out.println(d2.hashCode());
//		System.out.println(d2.hashCode());
		
		Dummy2 da = new Dummy2();
		Dummy2 db = new Dummy2();
		Dummy2 dc = new Dummy2();
		Dummy2 dd = new Dummy2();
		Dummy2[] dms = { da, db, dc, dd };
		for (int i = 0; i < dms.length; i++) {
//			Dummy2 dmm = dms[i];
//			dmm.sayDummy();
			System.out.print(i+"번째 dmm => ");
			dms[i].sayDummy();
			if( d2.equals(dms[i]) == true ) 
				System.out.println("\t 동일한 더미네요!!!");
			else 
				System.out.println(">> 서로 다른 더미들..");
			System.out.println("-------------");
		}
	}

}
/*
oop.InheritMain2@33909752
865113938
oop.InheritMain2@55f96302
1442407170
서로 같지? false
서로 다르지? true
우리는 다민족!!!
나를표현: 더미족II객체! oop.Dummy2@2
나의고유값: 2
나를 비교: true
0번째 dmm => 나를표현: 더미족II객체! oop.Dummy2@a
나의고유값: 10
나를 비교: true
>> 서로 다른 더미들..
-------------
1번째 dmm => 나를표현: 더미족II객체! oop.Dummy2@6
나의고유값: 6
나를 비교: true
>> 서로 다른 더미들..
-------------
2번째 dmm => 나를표현: 더미족II객체! oop.Dummy2@1
나의고유값: 1
나를 비교: true
>> 서로 다른 더미들..
-------------
3번째 dmm => 나를표현: 더미족II객체! oop.Dummy2@2
나의고유값: 2
나를 비교: true
	 동일한 더미네요!!!
-------------

*/