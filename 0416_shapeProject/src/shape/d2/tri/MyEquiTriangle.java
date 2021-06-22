package shape.d2.tri;

import shape.basic.MyPoint;
import shape.d1.MyLine;

/*
#### MyEquiTriangle 정삼각형 (equilateral 구체화 삼각형2)
> shape.d2.tri.MyEquiTriangle 클래스
> 3개의 선분(변)의 길이가 동일하고 3개 내각도 동일함 제약조건 (특성)
- 자신의 종류를 표현하는 String shapeType "정 삼각형"
 
 */
//public class MyEquiTriangle extends Object {
public class MyEquiTriangle extends MyTriangle2 {
	public static final String TR_NAME = "정 삼각형";
	
	public String shapeType; // = TR_NAME; 여기서 초기화 말것!
	
	// 3개의 선분(변)의 길이가 동일하고 3개 내각도 동일함 제약조건 (특성)
	private boolean isEquiTriangle() {
		return
			this.lnAB.getDistance() == this.lnBC.getDistance() 
			&& 
			this.lnBC.getDistance() == this.lnCA.getDistance();
			
	}
	
	public void printEquiTriangle() {
//		System.out.println(this.toString());
//		System.out.println(toString());
		System.out.println(this);// toString() 자동호출..
	}
	
	@Override
	public String toString() {
		return "MyEquiTriangle [shapeType=" + shapeType + ", ptA=" + ptA + ", ptB=" + ptB + ", ptC=" + ptC + ", lnAB="
				+ lnAB + ", lnBC=" + lnBC + ", lnCA=" + lnCA + ", tag=" + tag + ", color=" + color + ", getArea()="
				+ getArea() + ", getPerimeter()=" + getPerimeter() + ", getAngleCA_AB()=" + getAngleCA_AB() + "]";
	}

	// 하위클래스 생성자 중 더미생성자는 필수적 정의
	public MyEquiTriangle() { 
		this.shapeType = shapeType;
	}
	
	public MyEquiTriangle(
			MyPoint ptA, MyPoint ptB, MyPoint ptC) {
		super(ptA, ptB, ptC);
		this.shapeType = shapeType;
	}

	public MyEquiTriangle(MyPoint ptA, MyPoint ptB, MyPoint ptC, MyLine lnAB, MyLine lnBC, MyLine lnCA, String tag,
			String color, double area, double perimeter, double angleCA_AB, double angleAB_BC, double angleBC_CA,
			String shapeType) {
		super(ptA, ptB, ptC, lnAB, lnBC,
			lnCA, tag, color, area,
			perimeter, angleCA_AB,
			angleAB_BC, angleBC_CA);
		this.shapeType = shapeType;
	}
	
	
}



