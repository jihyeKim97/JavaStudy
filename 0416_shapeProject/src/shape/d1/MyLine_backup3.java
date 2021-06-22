package shape.d1;
import shape.MyShape;
import shape.basic.MyPoint;
import shape.basic.MyPoint_backup1;
/*
### 선 Line 스키마
> shape.d1.MyLine
> 두 좌표점을 이어주는 선상을 표현. 일단 두 점을 잇는 직선만 표현 (곡선은 별도로 취급)
> 벡터 선은 아니며, 시작점이 있고, 끝점이 있음 (시작점 => 끝점)
- 시작점 위치 점객체			MyPoint sp // start point
- 끝점 위치 점객체			MyPoint ep // end point
- 선의 이름태그 문자열 		String tag
- 선의 상태표현으로써의 컬러		String color (RGB 컬러코드 16진법 문자열)
- 선의 종류 stroke,border types...   int strokeType
- 선의 두께 정수형...					  int width 
- 측정: 선객체를 이루는 두 점 사이의 최단거리 (길이) 
		실수형 수치값   double distance 

선의 종류
굵은 실선
가는 실선
파선
1점 쇄선
2점 쇄선
파형, 지그재그의 가는 실선
규칙적인 가는 빗금선

# Border Style

solid - Defines a solid border.
dotted - Defines a dotted border.
dashed - Defines a dashed border.
double - Defines a double border.
groove - Defines a 3D grooved border. ...
ridge - Defines a 3D ridged border. ...
inset - Defines a 3D inset border. ...
outset - Defines a 3D outset border.
		
 */
public class MyLine_backup3 {
	// 상수 필드
	public static final String TYPE = "선 LN";
//	// 선의 두께 상수들
//	public static final int DEF_WIDTH = 1; 
//	public static final int BOLD_WIDTH = 2;
//	public static final int BOLDER_WIDTH = 4;
//	// 선의 경계선타입 상수들
//	public static final int ST_SOLID = 0; // 실선 
//	public static final int ST_DOTTED = 1; // 점선
//	public static final int ST_DASHED = 2; // 대시
//	public static final int ST_DOUBLE = 3; // 이중선
//	public static final int ST_GROOVE = 4; // 구루브
//	public static final int ST_RIDGE = 5; // 릿지
//	public static final int ST_INSET = 6; // 인셋
//	public static final int ST_OUTSET = 7;  // 아웃셋
//	public static final String[] STROKES = {
//		"실선", "점선", "대시", "이중선",
//		"구루브", "릿지", "인셋", "아웃셋"
//	};
	public static final String DEF_LINE_TAG = "기본선";
	
	// 변수 필드
	private MyPoint sp; // start point
	private MyPoint ep; // end point
 	 // private 클래스 내부에서만 사용되게끔 보호(관리)되어 외부에서 직접 접근 안됨.
	public String tag; // 선의 이름태그 문자열
	public String color; // 직선의 상태표현으로써의 컬러
	public int strokeType; // 선의 종류 8가지..
	public int width; // 선의 두께 정수 
	private double distance; // 측정: 선객체를 이루는 두 점 사이의 최단거리 (길이)
	
	// 생성자들
//	public MyLine() {} // 기본 생성자
//	public MyLine() {
//		this.sp = null;
//		this.ep = null;
//		this.tag = null;
//		this.color = null;
//		this.strokeType = 0;
//		this.width = 0;
//		this.distance = 0.0;
//	} // 기본 생성자
	public MyLine_backup3() {
		//this(new MyPoint(), MyShape.ORIGIN_PT);
		this(new MyPoint(), MyShape.ORIGIN_PT,
			DEF_LINE_TAG, MyShape.COLOR_BLACK,
			MyShape.ST_SOLID, MyShape.DEF_WIDTH, 0.0); 
		
//		this.sp = new MyPoint(); // 원점 시작점 (원점 객체 생성)
//		this.ep = MyShape.ORIGIN_PT; // new MyPoint(); // 원점 끝점
//		this.tag = DEF_LINE_TAG;//MyShape.EMTPY_TAG;
//		this.color = MyShape.COLOR_BLACK;
//		this.strokeType = ST_SOLID;
//		this.width = DEF_WIDTH;
//		this.distance = 0.0;
	} // 기본 생성자
	
	// 중간 생성자들?
	// 시작점을 원점객체로 가정하고 끝점객체만 입력받아서 선 객체 생성
	// 끝점 객체 하나를 외부에서 이미 new 초기화로 완성된 것을 입력 받기
	public MyLine_backup3(MyPoint ep) {
		this(MyShape.ORIGIN_PT, ep);
		// 끝 점객체 널이 아니라고 믿고..
//		this.sp = MyShape.ORIGIN_PT; // new MyPoint();
//		this.ep = ep;
//		this.tag = DEF_LINE_TAG;//MyShape.EMTPY_TAG;
//		this.color = MyShape.COLOR_BLACK;
//		this.strokeType = ST_SOLID;
//		this.width = DEF_WIDTH;
//		this.distance = 0.0;
	}
	
	// 시작점을 원점객체로 가정하고 끝점객체만 입력받아서 선 객체 생성
	// 끝점 객체를 생성할 재료 좌표 정수 2개를 입력받아 생성자 내부에서
	// 끝점객체 신규 생성하기
	public MyLine_backup3(int epx, int epy) {
		this(MyShape.ORIGIN_PT, new MyPoint(epx, epy));
//		this.sp = MyShape.ORIGIN_PT; // new MyPoint();
//		//this.ep = new MyPoint(epx, epy);
//		this.ep = new MyPoint(epx, epy,
//					"끝점", MyShape.COLOR_RED);
//		this.tag = DEF_LINE_TAG;//MyShape.EMTPY_TAG;
//		this.color = MyShape.COLOR_BLACK;
//		this.strokeType = ST_SOLID;
//		this.width = DEF_WIDTH;
//		this.distance = 0.0;
	}
	
	

	// 두 점 객체들을 배열로 묶어서 받아서 선객체 초기화 하기
	// !!! 외부에서 new 초기화가 끝난 두 점 객체를 입력 받음.
	public MyLine_backup3(MyPoint[] pts) { // pts.length == 2 조건..
//		this(pts[0], pts[1], DEF_LINE_TAG, 
//				MyShape.COLOR_BLACK, ST_SOLID, 
//				DEF_WIDTH, 0.0);
		this(pts[0], pts[1]); // 여러번 거치는 this() 생성자 위임??
		
		// pts가 null이 아니고, pts.length >= == 2 ...
//		MyPoint psp = pts[0]; // null 아님...
//		MyPoint pep = pts[1]; // null 아님...
//		this.sp = psp;
//		this.ep = pep;
		//
//		this.sp = pts[0]; this.ep = pts[1];
//		this.tag = DEF_LINE_TAG;//MyShape.EMTPY_TAG;
//		this.color = MyShape.COLOR_BLACK;
//		this.strokeType = ST_SOLID;
//		this.width = DEF_WIDTH;
//		this.distance = 0.0;
	}
	
	// 두 점 객체들을 각각 받아서 선객체 초기화 하기
	// !!! 외부에서 new 초기화가 끝난 두 점 객체를 입력 받음.
	public MyLine_backup3(MyPoint sp, MyPoint ep) {
		this(sp, ep, DEF_LINE_TAG, 
				MyShape.COLOR_BLACK, MyShape.ST_SOLID, 
				MyShape.DEF_WIDTH, 0.0);
		// 두 점객체 모두 널이 아니라고 믿고..
//		this.sp = sp;
//		this.ep = ep;
//		this.tag = DEF_LINE_TAG;//MyShape.EMTPY_TAG;
//		this.color = MyShape.COLOR_BLACK;
//		this.strokeType = ST_SOLID;
//		this.width = DEF_WIDTH;
//		this.distance = 0.0;
	}
	
	// 두 점을 만들기 위해 좌표정수 4개를 각각 받아서 선객체 초기화 하기
	// sp(x1,y1) => ep(x2,y2)
	// !!! 점객체를 만들 재료(정수4개)를 받아서, 생성자 내부에서 
	// new 초기화를 각각 진행하여 시작점, 끝점 객체를 생성해야 함.
	public MyLine_backup3(int x1, int y1, int x2, int y2) {
//		this.sp = new MyPoint(x1, y1);
//		this.ep = new MyPoint(x2, y2);
//		this.tag = DEF_LINE_TAG;//MyShape.EMTPY_TAG;
//		this.color = MyShape.COLOR_BLACK;
//		this.strokeType = ST_SOLID;
//		this.width = DEF_WIDTH;
//		this.distance = 0.0;
		// this. (포인터) 객체 자신의 주소를 가리킴
		// this() 생성자 호출 (위임 패턴의 한 예)
//		this.tag = "앞에요!";  // this() 생성자 앞에서 아무것도 하지말라.
//		int x = 3; // this() 가장 처음 실행해야 함.
//		this(new MyPoint(x1, y1), new MyPoint(x2, y2));
		this(new MyPoint(x1, y1), new MyPoint(x2, y2),
				DEF_LINE_TAG, MyShape.COLOR_BLACK,
				MyShape.ST_SOLID, MyShape.DEF_WIDTH, 0.0);
		// 다른 생성자(여기선  full 생성자)를 호출하여 자신의 초기화 작업을
		// "위임"한다. 
		this.tag += " 좋아요!"; 
	}	
	
	// 풀 생성자 (초기화 로직을 잘 정리해둔 유일한 진짜 생성자)
	public MyLine_backup3(MyPoint sp, MyPoint ep, String tag, String color, int strokeType, int width, double distance) {
		super();
		this.sp = sp;
		this.ep = ep;
		this.tag = tag;
		this.color = color;
		this.strokeType = strokeType;
		this.width = width;
		this.distance = distance;
	}
		
	// 측정 함수
	
	// 출력 함수
	// @ annotation 어노테이션.. 부가기능?
	// @Override 어노테이션은 함수 앞에 선언함.
	//   이 어노테이션은 해당 함수가 부모 클래스로 부터 정말로 이 형식으로 
	//   해당 함수를 물려 받아서 재정의할 수 있는지를 사전 체크함.
	@Override
//	public String toMyString() { // error
//	public String toString(int age) { // error
	public String toString() {
		return "MyLine [sp=" + sp + 
		", ep=" + ep + ", tag=" + tag 
		+ ", color=" + color + ", strokeType=" + strokeType
		+ ", width=" + width + ", distance=" + distance + "]";
	}
	
	public void printLine() {
//		System.out.println(this.toString());
		System.out.println(this); // this.toString() 자동 호출 
//		String line = this.toString();
//		System.out.println(line);
		//this.tag
//		this(); // this() 생성자는 생성자 함수 안에서만  호출됨.
	}

	
}


