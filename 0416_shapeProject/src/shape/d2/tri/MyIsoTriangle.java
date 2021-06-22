package shape.d2.tri;
/*
#### MyIsoTriangle 이등변삼각형 (isosceles 구체화 삼각형1)
> shape.d2.tri.MyIsoTriangle 클래스 (MyTriangle 자식/하위/파생 클래스)
> 2개의 선분(변)의 길이가 동일하다는 제약조건 (특성)
- 자신의 종류를 표현하는 String shapeType "이등변 삼각형"
*/

import shape.MyShape;
import shape.basic.MyPoint;
import shape.d1.MyLine;

// 언어 마다 상속처리는 매우 다름... 자바는 순수 OOP에 따라 단일 상속만 오직 지원함.
// 즉, 자식 클래스는 오직 단 하나의 부모 클래스만을 가질 수 있습니다. 
// x public class MyIsoTriangle  extends MyTriangle, MyRectangle {

// 상속에서 부모님의 private 자원들은 물려받을 수는 없다. 하지만 사용은 가능하다.
// public 필드/메소드는 부모클래스에서 상속이 바로 된다.

//public class MyIsoTriangle extends MyTriangle {
public class MyIsoTriangle extends MyTriangle2 {
	public String shapeType;// "이등변 삼각형"
	
	// > 2개의 선분(변)의 길이가 동일하다는 제약조건 (특성)
	// 스스로 이등변삼각형인지 체크하는 검증 함수 true면 이등변임! 
	private boolean isIsoTriangle() {
//		if( this.lnAB.getDistance() == this.lnBC.getDistance() 
//			|| this.lnBC.getDistance() == this.lnCA.getDistance()
//			|| this.lnCA.getDistance() == this.lnAB.getDistance()
//		) return true;
//		else 
//		  return false;
		// 삼항식
//	return this.lnAB.getDistance() == this.lnBC.getDistance() 
//		|| this.lnBC.getDistance() == this.lnCA.getDistance()
//		|| this.lnCA.getDistance() == this.lnAB.getDistance()
//		? true: false;
	return this.lnAB.getDistance() == this.lnBC.getDistance() 
		|| this.lnBC.getDistance() == this.lnCA.getDistance()
		|| this.lnCA.getDistance() == this.lnAB.getDistance();						
	}
	
	
	// 이클립스가 자동 toString()

	@Override
	public String toString() {
		return "MyIsoTriangle [shapeType=" + shapeType
				+ " 정품인증? " + 
			(this.isIsoTriangle() ? " 이등변인증!" : "가짜!")
				+ ", ptA=" + ptA + ", ptB=" 
				+ ptB + ", ptC=" + ptC + ", lnAB="
				+ lnAB + ", lnBC=" + lnBC 
				+ ", lnCA=" + lnCA + ", tag=" 
				+ tag + ", color=" + color + "]";
	}
	
	public void printIsoTriangle() {
		System.out.println(TYPE + " " + this.toString());
//		System.out.println(MyTriangle2.TYPE);
	}

	
//	@Override
//	public String toString() {
//		return "MyIsoTriangle [shapeType=" + shapeType + "]";
//	}
	
	// 이클립스가 자동으로 생성자 정의
	public MyIsoTriangle(MyPoint ptA, MyPoint ptB, MyPoint ptC, MyLine lnAB, MyLine lnBC, MyLine lnCA, String tag,
			String color, double area, double perimeter, double angleCA_AB, double angleAB_BC, double angleBC_CA,
			String shapeType) {
		super(ptA, ptB, ptC, lnAB, lnBC, lnCA, tag, color, area, perimeter, angleCA_AB, angleAB_BC, angleBC_CA);
		this.shapeType = shapeType;
	}

	




	public MyIsoTriangle() {
		//super(); // 생략이 가능함.
		this.shapeType = "이등변 삼각형"; 
	}
	
//	public MyIsoTriangle(MyPoint[] pts) {
//		super(pts[0], pts[1], pts[2]);
//		this.shapeType = "이등변 삼각형"; 
//	}
	public MyIsoTriangle(MyPoint[] pts) {
		this(pts[0], pts[1], pts[2]);
		this.shapeType = "이등변 삼각형"; 
	}
	
	
	public MyIsoTriangle(int x1, int y1,
			int x2, int y2, int x3, int y3, String name) {
		super(new MyPoint(x1, y1), 
				new MyPoint(x2, y2), 
					new MyPoint(x3, y3));
		this.shapeType = name;
//		this(new MyPoint(x1, y1), 
//				new MyPoint(x2, y2), 
//					new MyPoint(x3, y3));
//		this.shapeType = name;
		//
//		super(); // MyTriangle2()
//		this.ptA = new MyPoint(x1, y1);
//		this.ptB = new MyPoint(x2, y2);
//		this.ptC = new MyPoint(x3, y3);
//		this.lnAB = new MyLine(ptA, ptB);
//		this.lnBC = new MyLine(ptB, ptC);
//		this.lnCA = new MyLine(ptC, ptA);
//		this.color = MyShape.COLOR_BLACK;
//		this.tag = MyShape.EMTPY_TAG;
////		this.area = 0.0; // ?
////		this.perimeter = 0.0; // ?		
//		//
//		this.shapeType = name;
	}
	
//	public MyIsoTriangle(int x1, int y1,
//			int x2, int y2, int x3, int y3, String name) {
////		super(); // MyTriangle2()
//		this.ptA = new MyPoint(x1, y1);
//		this.ptB = new MyPoint(x2, y2);
//		this.ptC = new MyPoint(x3, y3);
//		this.lnAB = new MyLine(ptA, ptB);
//		this.lnBC = new MyLine(ptB, ptC);
//		this.lnCA = new MyLine(ptC, ptA);
//		this.color = MyShape.COLOR_BLACK;
//		this.tag = MyShape.EMTPY_TAG;
////		this.area = 0.0; // ?
////		this.perimeter = 0.0; // ?		
//		//
//		this.shapeType = name;
//	}
	
	public MyIsoTriangle(MyPoint ptA, 
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
//		this.ptA; // private -> public 
//		this.lnAB; // private -> public
		//MyPoint p = this.ptA; // 자식 객체에서 부모객체의 protected 필드에 접근 (상속)
		
		//this.getLnAB()??
		//super(ptA, ptB, ptC); // 부모클래스의 생성자를 호출하여 초기화.
	}
}
