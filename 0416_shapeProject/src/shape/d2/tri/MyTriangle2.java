package shape.d2.tri;

import shape.MyShape;
import shape.basic.MyPoint;
import shape.basic.MyPoint_backup1;
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
public class MyTriangle2 {
	// 필드
	public static final String TYPE = "삼각형 TA";
//	public MyPoint ptA; // rw 꼭지점 A ~ C
//	public MyPoint ptB; // rw
//	public MyPoint ptC; // rw
//	public MyLine lnAB; // read only ptA-ptB 연결하는 선분
//	public MyLine lnBC; // r ptB-ptC 연결하는 선분
//	public MyLine lnCA; // r ptC-ptA 연결하는 선분
	protected MyPoint ptA; // rw 꼭지점 A ~ C
	protected MyPoint ptB; // rw
	protected MyPoint ptC; // rw
	protected MyLine lnAB; // read only ptA-ptB 연결하는 선분
	protected MyLine lnBC; // r ptB-ptC 연결하는 선분
	protected MyLine lnCA; // r ptC-ptA 연결하는 선분	
	public String tag;
	public String color;
	private double area; // r 넓이
	private double perimeter; // r 둘레
	private double angleCA_AB; // r A점 내각
	private double angleAB_BC; // r B점 내각
	private double angleBC_CA; // r C점 내각
	
	// 세터(설정자)/ 게터(참조자)
	// 필드명의 첫글자를 대문자로 하고 set, get을 붙이면 됨.
	// setter 수동
	public void setPtA(MyPoint ptA) { // write
		this.ptA = ptA; // 널이 아니라고 믿고..
	}
	// getter 수동
	public MyPoint getPtA() { // read
		return this.ptA;
	}
	
	// 이클립스 setter/getter 자동 정의  shiht_alt_s
	public MyPoint getPtB() {
		return ptB;
	}
	public void setPtB(MyPoint ptB) {
		this.ptB = ptB;
	}
	public MyPoint getPtC() {
		return ptC;
	}
	public void setPtC(MyPoint ptC) {
		this.ptC = ptC;
	}
	public MyLine getLnAB() {
		return lnAB;
	}
	public MyLine getLnBC() {
		return lnBC;
	}
	public MyLine getLnCA() {
		return lnCA;
	}
	
	// 삼각형의 넓이(면적) m^2 => 일반 삼각형의 넓이 공식 
	// https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=1%ED%8F%89
	// https://ko.wikipedia.org/wiki/%ED%97%A4%EB%A1%A0%EC%9D%98_%EA%B3%B5%EC%8B%9D
	// 헤론의 공식
	// 세변의 길이 a, b, c라고 하고,
	// 둘레의 절반 hp = (a + b + c) / 2.0
	// 넓이 = sqrt( hp * (hp-a) * (hp-b) * (hp-c) )
	public double getArea() { // 측정치는 read-only
		double hp = this.perimeter / 2.0;
		double lnABDif = hp - this.lnAB.getDistance();
		double lnBCDif = hp - this.lnBC.getDistance();
		double lnCADif = hp - this.lnCA.getDistance();
		double area = Math.sqrt(hp * lnABDif * lnBCDif 
				* lnCADif );
		this.area = area;
		return area;
	}
	
	// public double measureArea() {}
	
	// 삼각형의 바깥둘레
	// 세 변(선분)의 길이의 합
	public double getPerimeter() {// 측정치는 read-only
		return perimeter;
		//return this.perimeter;
	}
	public double measurePerimeter() {
		double perimeter = 
				this.lnAB.getDistance() +
				this.lnBC.getDistance() + 
				this.lnCA.getDistance();
		this.perimeter = perimeter;
		return this.perimeter;
	}
	
	// 선분CA와 선분AB에 연결되어 있는 꼭지점 A를 사이에 둔 내각 구하기
	// 삼각함수 공식 중에서 '제2코사인 법칙'을 역으로 응용하면... 각도를 구할 수 있다.	
	// angleA = arccos( (b^2 + c^2 - a^2) / (2*b*c) ); 
	public double getAngleCA_AB() {// 측정치는 read-only
		double angleA = 0.0;
		// 꼭지점과 마주보는 변(선분)
		double a = this.lnBC.getDistance();
		double b = this.lnCA.getDistance();
		double c = this.lnAB.getDistance();
		double cosA = (b*b + c*c - a*a) / (2.0 * b * c);
		angleA = Math.acos(cosA);
			// Returns the arc cosine of a value; 
			// the returned angle is 
			// in the range 0.0 through pi.
		this.angleCA_AB = angleA;
		return angleCA_AB;
	}
	
	public double getAngleAB_BC() {// 측정치는 read-only
		return angleAB_BC;
	}
	public double getAngleBC_CA() {// 측정치는 read-only
		return angleBC_CA;
	}

	
	
	// 더미 생성자
	public MyTriangle2() {
	
	}
	
	// 중간 생성자들
	// 점객체 3개 외부에서 하나의 배열로 받아서 삼각형 초기화 하기
	// (주어진 3개 점객들로 구성된 선분 객체 3개를 동적으로 new 생성)
	// 배열의 길이가 3이상이 아니면.. 에러!!
	public MyTriangle2(MyPoint[] pts) {
		this(pts[0], pts[1], pts[2]);
//		this(pts[0], pts[1], pts[2], 
//				new MyLine(pts[0], pts[1], "삼각형 선분 AB"),
//				new MyLine(pts[1], pts[2], "삼각형 선분 BC"),
//				new MyLine(pts[2], pts[0], "삼각형 선분 CA"));
	}
	
	
	// 삼각형의 꼭지점 3개를 각각 이루는 좌표정수쌍, 6개의 정수 받아서 초기화
	// 생성자 내부에서 점객체 3개를 우선 생성 후... 나중에
	// 이 점객체를 이용하여 선객체 3개를 또 생성 초기화.
	public MyTriangle2(int ptAX, int ptAY, 
			int ptBX, int ptBY,	int ptCX, int ptCY ) {
		this.ptA = new MyPoint(ptAX, ptAY, 
				"꼭지점 A", MyShape.COLOR_RED);
		this.ptB = new MyPoint(ptBX, ptBY, 
				"꼭지점 B", MyShape.COLOR_GREEN);
		this.ptC = new MyPoint(ptCX, ptCY, 
				"꼭지점 C", MyShape.COLOR_BLUE);
		this.lnAB = new MyLine(this.ptA, this.ptB); // 거리측정
		this.lnAB.tag = "삼각형 선분 AB";
		this.lnBC = new MyLine(ptB, ptC); // 거리측정
		this.lnBC.tag = "삼각형 선분 BC";
		this.lnCA = new MyLine(ptC, ptA); // 거리측정
		this.lnCA.tag = "삼각형 선분 CA";
		this.tag = MyShape.EMTPY_TAG;
		this.color = MyShape.COLOR_BLACK;
		this.area = 0.0;
		this.perimeter = 0.0;
		this.angleCA_AB = 0.0;
		this.angleAB_BC = 0.0;
		this.angleBC_CA = 0.0;
	}
	
	// 점객체 3개 외부에서 받아서 삼각형 초기화 하기
	// (주어진 3개 점객들로 구성된 선분 객체 3개를 동적으로 new 생성)
	public MyTriangle2(MyPoint ptA, MyPoint ptB, MyPoint ptC) {
		this(ptA, ptB, ptC, 
				new MyLine(ptA, ptB, "삼각형 선분 AB"),
				new MyLine(ptB, ptC, "삼각형 선분 BC"),
				new MyLine(ptC, ptA, "삼각형 선분 CA"));
//		this(ptA, ptB, ptC, new MyLine(ptA, ptB),
//			new MyLine(ptB, ptC), new MyLine(ptC, ptA));
//		this.lnAB.tag = "삼각형 선분 AB";
//		this.lnBC.tag = "삼각형 선분 BC";
//		this.lnCA.tag = "삼각형 선분 CA";
		//
//		this.ptA = ptA;
//		this.ptB = ptB;
//		this.ptC = ptC;
//		this.lnAB = new MyLine(ptA, ptB); // 거리측정
//		this.lnAB.tag = "삼각형 선분 AB";
//		this.lnBC = new MyLine(ptB, ptC); // 거리측정
//		this.lnBC.tag = "삼각형 선분 BC";
//		this.lnCA = new MyLine(ptC, ptA); // 거리측정
//		this.lnCA.tag = "삼각형 선분 CA";
//		this.tag = MyShape.EMTPY_TAG;
//		this.color = MyShape.COLOR_BLACK;
//		this.area = 0.0;
//		this.perimeter = 0.0;
//		this.angleCA_AB = 0.0;
//		this.angleAB_BC = 0.0;
//		this.angleBC_CA = 0.0;
	}
	
	public MyTriangle2(MyPoint ptA, MyPoint ptB, MyPoint ptC,
			MyLine lnAB, MyLine lnBC, MyLine lnCA) {
//		this(ptA, ptB, ptC, lnAB, lnBC, lnCA, 
//			MyShape.EMTPY_TAG, MyShape.COLOR_BLACK,
//			0.0, 0.0, 0.0, 0.0, 0.0);
		this(ptA, ptB, ptC, lnAB, lnBC, lnCA, 
				MyShape.EMTPY_TAG, MyShape.COLOR_BLACK);
	}
	
	public MyTriangle2(MyPoint ptA, MyPoint ptB, MyPoint ptC,
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
		
	// 풀 생성자 shift + alt + s
	public MyTriangle2(MyPoint ptA, MyPoint ptB, MyPoint ptC, MyLine lnAB, MyLine lnBC, MyLine lnCA, String tag,
			String color, double area, double perimeter, double angleCA_AB, double angleAB_BC, double angleBC_CA) {
		super();
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
	
	@Override
	//public String toString(int a) {
	public String toString() {
		return "MyTriangle [ptA=" + ptA 
			+ ", ptB=" + ptB + ", ptC=" + ptC.toString() 
			+ ", lnAB=" + lnAB.toString() 
			+ ", lnBC=" + lnBC
			+ ", lnCA=" + lnCA + ", tag=" + tag 
			+ ", color=" + color 
			+ ", area=" + area + "m^2 면적"
			+ ", perimeter=" + perimeter + "m 둘레"
			+ ", angleCA_AB=" + angleCA_AB + "㎭ 각도" 
			+ ", angleAB_BC=" + angleAB_BC + "㎭ 각도"
			+ ", angleBC_CA=" + angleBC_CA + "㎭ 각도"+ "]";
	}

	public void printTriange() {
		System.out.println(TYPE + " " +this.toString());
	}
	
}

/*
삼각형 TA MyTriangle [ptA=점 PT(0,0) 태그: 학원[컬러: FF0000] 
, ptB=점 PT(180,20) 태그: 성동구청[컬러: 00FF00] 
, ptC=점 PT(-200,-90) 태그: 별다방[컬러: 0000FF] 
, lnAB=MyLine [sp=점 PT(0,0) 태그: 학원[컬러: FF0000] 
, ep=점 PT(180,20) 태그: 성동구청[컬러: 00FF00] 
, tag=삼각형 선분 AB, color=000000, strokeType=0, width=1, distance=181.10770276274835], lnBC=MyLine [sp=점 PT(180,20) 태그: 성동구청[컬러: 00FF00] 
, ep=점 PT(-200,-90) 태그: 별다방[컬러: 0000FF] 
, tag=삼각형 선분 BC, color=000000, strokeType=0, width=1, distance=395.60080889704966], lnCA=MyLine [sp=점 PT(-200,-90) 태그: 별다방[컬러: 0000FF] 
, ep=점 PT(0,0) 태그: 학원[컬러: FF0000] 
, tag=삼각형 선분 CA, color=000000, strokeType=0, width=1, distance=219.31712199461307], tag=커피 마시는 영역, color=000000, area=0.0m^2 면적, perimeter=0.0m 둘레, angleCA_AB=0.0㎭ 각도, angleAB_BC=0.0㎭ 각도, angleBC_CA=0.0㎭ 각도]
*/