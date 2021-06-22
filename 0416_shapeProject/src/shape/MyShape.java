package shape;

import shape.basic.MyPoint;

// 도형 프로젝트의 모든 상수를 모아둔 공통상수클래스
public class MyShape {
	// 색상 상수들 -- RGB 컬러 16진법
	public static final String COLOR_BLACK = "000000"; 
	public static final String COLOR_WHITE = "FFFFFF";
	public static final String COLOR_RED = "FF0000";
	public static final String COLOR_GREEN = "00FF00";
	public static final String COLOR_BLUE = "0000FF";
	public static final String COLOR_YELLOW = "FFFF00";
	public static final String COLOR_CYAN = "00FFFF";
	public static final String COLOR_PURPLE = "FF00FF";	
	
	// 태그 상수
	public static final String EMTPY_TAG = "";
	
	// 점 상수
	public static final MyPoint ORIGIN_PT = new MyPoint();
		// 원점을 표시하는 점객체 상수
	
	// 선 상수...
	// 선의 두께 상수들
	public static final int DEF_WIDTH = 1; 
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
}
