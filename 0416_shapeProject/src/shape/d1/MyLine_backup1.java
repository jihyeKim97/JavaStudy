package shape.d1;
import shape.basic.MyPoint;
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
public class MyLine_backup1 {
	// 상수 필드
	public static final String TYPE = "선 LN";
	public static final int DEF_WIDTH = 1; // 선의 두께 상수들
	public static final int BOLD_WIDTH = 2;
	public static final int BOLDER_WIDTH = 4;
	// 선의 경계선타입 상수들
	public static final int ST_SOLID = 0; // 실선 
	public static final int ST_DOTTED = 1; // 점선
	public static final int ST_DASHED = 2; // 대시
	public static final int ST_DOUBLE = 3; // 이중선
	public static final int ST_GROOVE = 4; // 구루브
	public static final int ST_RIDGE = 5; // 릿지
	public static final int ST_INSET = 6; // 인셋
	public static final int ST_OUTSET = 7;  // 아웃셋
	public static final String[] STROKES = {
		"실선", "점선", "대시", "이중선",
		"구루브", "릿지", "인셋", "아웃셋"
	};
	
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
	public MyLine_backup1() {} // 기본 생성자
	
	// 풀 생성자
	public MyLine_backup1(MyPoint sp, MyPoint ep, String tag, String color, int strokeType, int width, double distance) {
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
	}

	
}


