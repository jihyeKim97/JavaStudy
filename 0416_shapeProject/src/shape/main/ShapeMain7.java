package shape.main;

import shape.basic.MyPoint;
import shape.d2.tri.MyTriangle;

public class ShapeMain7 {

	public static void main(String[] args) {
		MyPoint ptA = new MyPoint();
		MyPoint ptB = new MyPoint(100, true);
		//MyPoint ptC = new MyPoint(100, false);
		MyPoint ptC = new MyPoint(0, 100);
		MyTriangle tr1 = new MyTriangle(ptA, ptB, ptC);
		tr1.measurePerimeter();
		double angleA = tr1.getAngleCA_AB();
		System.out.println("angleA = " + angleA + "rad 라디안 단위");
		System.out.println("angleA = " + 
				(angleA * 180.0 / Math.PI)+ "도 단위?");
		System.out.println("angleA = " + 
				Math.toDegrees(angleA)+ "degree 단위?");
	} // PI 라디안 == 180 도 
	/*	angleA = 1.5707963267948966 단위?
		angleA = 90.0 단위? */
}
