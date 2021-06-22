package shape.d2.tri;
/*
#### MyIsoTriangle 이등변삼각형 (isosceles 구체화 삼각형1)
> shape.d2.tri.MyIsoTriangle 클래스 (MyTriangle 자식/하위/파생 클래스)
> 2개의 선분(변)의 길이가 동일하다는 제약조건 (특성)
- 자신의 종류를 표현하는 String shapeType "이등변 삼각형"
*/

import shape.basic.MyPoint;

// 언어 마다 상속처리는 매우 다름... 자바는 순수 OOP에 따라 단일 상속만 오직 지원함.
// 즉, 자식 클래스는 오직 단 하나의 부모 클래스만을 가질 수 있습니다. 
// x public class MyIsoTriangle  extends MyTriangle, MyRectangle {
public class MyIsoTriangle_backup1 extends MyTriangle {
	public String shapeType;// "이등변 삼각형"
	public MyIsoTriangle_backup1() {
		//super(); // 생략이 가능함.
		this.shapeType = "이등변 삼각형"; 
	}
	public MyIsoTriangle_backup1(MyPoint ptA, 
			MyPoint ptB, MyPoint ptC) {
		// this. 객체 자신 안에 있는 필드/메소드 접근
		// this() 다른 생성자를 호출하여 초기화 위임
		//this.shapeType; // 자식 객체만의 것
		//super.shapeType; // 자식 클래스것이고, 부모 클래스것이 아니라서..
		//super(); // 부모클래스  MyTriangle() 생성자 호출..
		//super(); // 자동호출..
		super(ptA, ptB, ptC); 
			// 부모클래스가 물려주는 모든 필드 초기화를 먼저 수행
			// 부모클래스  MyTriangle(ptA, ptB, ptC) 생성자 호출..
		this.shapeType = "이등변 삼각형"; // 자식클래스 필드만 별도로 초기화
		
		//this.getLnAB()??
		//super(ptA, ptB, ptC); // 부모클래스의 생성자를 호출하여 초기화.
	}
}
