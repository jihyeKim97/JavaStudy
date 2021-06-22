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
public class MyTriangle_backup2 {
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
	public MyTriangle_backup2() {
	
	}
	
	// 중간 생성자들
	// 점객체 3개 외부에서 하나의 배열로 받아서 삼각형 초기화 하기
	// (주어진 3개 점객들로 구성된 선분 객체 3개를 동적으로 new 생성)
	// 배열의 길이가 3이상이 아니면.. 에러!!
	public MyTriangle_backup2(MyPoint[] pts) {
		this(pts[0], pts[1], pts[2]);
//		this(pts[0], pts[1], pts[2], 
//				new MyLine(pts[0], pts[1], "삼각형 선분 AB"),
//				new MyLine(pts[1], pts[2], "삼각형 선분 BC"),
//				new MyLine(pts[2], pts[0], "삼각형 선분 CA"));
	}
	
	
	// 삼각형의 꼭지점 3개를 각각 이루는 좌표정수쌍, 6개의 정수 받아서 초기화
	// 생성자 내부에서 점객체 3개를 우선 생성 후... 나중에
	// 이 점객체를 이용하여 선객체 3개를 또 생성 초기화.
	public MyTriangle_backup2(int ptAX, int ptAY, 
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
	public MyTriangle_backup2(MyPoint ptA, MyPoint ptB, MyPoint ptC) {
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
	
	public MyTriangle_backup2(MyPoint ptA, MyPoint ptB, MyPoint ptC,
			MyLine lnAB, MyLine lnBC, MyLine lnCA) {
//		this(ptA, ptB, ptC, lnAB, lnBC, lnCA, 
//			MyShape.EMTPY_TAG, MyShape.COLOR_BLACK,
//			0.0, 0.0, 0.0, 0.0, 0.0);
		this(ptA, ptB, ptC, lnAB, lnBC, lnCA, 
				MyShape.EMTPY_TAG, MyShape.COLOR_BLACK);
	}
	
	public MyTriangle_backup2(MyPoint ptA, MyPoint ptB, MyPoint ptC,
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
	public MyTriangle_backup2(MyPoint ptA, MyPoint ptB, MyPoint ptC, MyLine lnAB, MyLine lnBC, MyLine lnCA, String tag,
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