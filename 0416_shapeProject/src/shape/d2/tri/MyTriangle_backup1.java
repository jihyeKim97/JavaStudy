package shape.d2.tri;

import shape.MyShape;
import shape.basic.MyPoint;
import shape.d1.MyLine;

/*
##### MyTriange 스키마 (일반삼각형)
> shape.d2.tri.MyTriangle 클래스
> 2차원 평면상에서 3개의 떨어진 점들로, 혹은 세개의 서로 이어지는 선들로 모두 연결되는 폐공간 구성. 
- 점(vertex 꼭지점) 3개     	MyPoint a, b, c;
- 선(line 선분) 3개		MyLine ab, bc, ca;
- 삼각형의 이름태그 문자열 		String tag
- 삼각형 내부 영역에 채워진 컬러	String color (RGB 컬러코드 16진법 문자열)
- 측정: 면적 (넓이) double area;
- 측정: 둘레 (길이 = 모든 선분들의 길이의 총합) double perimeter; 
- 측정: 각도들 (선분과 선분 사이의 내각, degree, radian; 
	선분 AB와 선분 BC 사이의 내각) double angleAB_BC; 
 */
public class MyTriangle_backup1 {
	// 필드
	public static final String TYPE = "삼각형 TA";
	private MyPoint ptA; // 꼭지점 A ~ C
	private MyPoint ptB;
	private MyPoint ptC;
	private MyLine lnAB; // ptA-ptB 연결하는 선분
	private MyLine lnBC; // ptB-ptC 연결하는 선분
	private MyLine lnCA; // ptC-ptA 연결하는 선분
	public String tag;
	public String color;
	private double area; // 넓이
	private double perimeter; // 둘레
	private double angleCA_AB; // A점 내각
	private double angleAB_BC; // B점 내각
	private double angleBC_CA; // C점 내각
	
	// 더미 생성자
	public MyTriangle_backup1() {
	
	}

	// 중간 생성자들
	public MyTriangle_backup1(MyPoint ptA, MyPoint ptB, MyPoint ptC,
			MyLine lnAB, MyLine lnBC, MyLine lnCA) {
//		this(ptA, ptB, ptC, lnAB, lnBC, lnCA, 
//			MyShape.EMTPY_TAG, MyShape.COLOR_BLACK,
//			0.0, 0.0, 0.0, 0.0, 0.0);
		this(ptA, ptB, ptC, lnAB, lnBC, lnCA, 
				MyShape.EMTPY_TAG, MyShape.COLOR_BLACK);
	}
	
	public MyTriangle_backup1(MyPoint ptA, MyPoint ptB, MyPoint ptC,
			MyLine lnAB, MyLine lnBC, MyLine lnCA,
			String tag,	String color) {
		this(ptA, ptB, ptC, lnAB, lnBC, lnCA, tag, color,
			0.0, 0.0, 0.0, 0.0, 0.0);
//		super();
//		this.ptA = ptA;
//		this.ptB = ptB;
//		this.ptC = ptC;
//		this.lnAB = lnAB;
//		this.lnBC = lnBC;
//		this.lnCA = lnCA;
//		this.tag = tag;
//		this.color = color;
	}
		
	// 풀 생성자
	public MyTriangle_backup1(MyPoint ptA, MyPoint ptB, MyPoint ptC, MyLine lnAB, MyLine lnBC, MyLine lnCA, String tag,
			String color, double area, double perimeter, double angleCA_AB, double angleAB_BC, double angleBC_CA) {
//		super();
		this.ptA = ptA;
		this.ptB = ptB;
		this.ptC = ptC;
		this.lnAB = lnAB;
		this.lnBC = lnBC;
		this.lnCA = lnCA;
		this.tag = tag;
		this.color = color;
		this.area = area;
		this.perimeter = perimeter;
		this.angleCA_AB = angleCA_AB;
		this.angleAB_BC = angleAB_BC;
		this.angleBC_CA = angleBC_CA;
	}
	
//	@Override
	public String toString() {
		return "MyTriangle [ptA=" + ptA + ", ptB=" + ptB + ", ptC=" + ptC + ", lnAB=" + lnAB + ", lnBC=" + lnBC
				+ ", lnCA=" + lnCA + ", tag=" + tag + ", color=" + color + ", area=" + area + ", perimeter=" + perimeter
				+ ", angleCA_AB=" + angleCA_AB + ", angleAB_BC=" + angleAB_BC + ", angleBC_CA=" + angleBC_CA + "]";
	}

	public void printTriange() {
		System.out.println(TYPE + " " +this.toString());
	}
	
}
