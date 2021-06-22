package shape.basic;

import shape.MyShape;

/*
### 점 Point 스키마 
> shape.basic.MyPoint 클래스
> 2차원 좌표계 평면 상의 한 점(특정 위치)으로 좌표값으로 표현 (x,y)
- 가로축 상의 위치 x 정수		int x
- 세로축 상의 위치 y 정수		int y
- 점의 이름태그 문자열 		String tag
- 점의 상태표현으로써의 컬러		String color (RGB 컬러코드 16진법 문자열)
	// 나중에는 MyColor 클래스로 표현 가능 
 */
public class MyPoint_backup2 {
	// 상수 필드
	public static final String TYPE = "점 PT";
	public static final String DEF_TAG = "없음";
	public static final String ORIGIN_TAG = "원점";
	public static final String DEF_COLOR = MyShape.COLOR_BLACK;  
				//"000000";
	// 변수 필드
	public int		x;
	public int	 	y;
	public String	tag;
	public String 	color;
	// 생성자들
	//public MyPoint() {} // 원점 객체
//	public MyPoint() {
//		this.x = 0; 
//		this.y = 0;
//		this.tag = null;
//		this.color = null;
//	} // 원점 객체
	public MyPoint_backup2() {
		this.x = 0; 
		this.y = 0;
		this.tag = ORIGIN_TAG;
		this.color = DEF_COLOR; // black 0x000000
	} // 원점 객체	
	
	// 중간 생성자들
	// 평면상에 있는 점의 두 좌표값만...
	public MyPoint_backup2(int x, int y) {
		this.x = x; 
		this.y = y;
		this.tag = MyShape.EMTPY_TAG;  // "";
		this.color = MyShape.COLOR_BLACK;
	}
	
	// axis 축 상에 위치한 점은 x, y 둘 중 하나가 0임.
	// 수평축 x-axis 상 점을 true로 보자..
	public MyPoint_backup2( int p, boolean isXAxis ) {
		if( isXAxis ) { // == true )
			this.x = p; this.y = 0;
		} // y축 상의 점... 
		else {
			this.y = p; this.x = 0; // 수직축 상의 점..
		}
		this.tag = MyShape.EMTPY_TAG;  // "";
		this.color = MyShape.COLOR_BLACK;
	}
	
	// 복제 copy, clone 생성자 (점객체를 이용하여 점객체를 초기화)
	public MyPoint_backup2( MyPoint_backup2 pt ) {
		this.x = pt.x;
		this.y = pt.y;
		this.tag = pt.tag;
		this.color = pt.color;
		System.out.println(pt+"를 복제 완료함..");
	}
	
	// vector로 점을 표현하자.. 
	// (좌표값이 아니라 원점 기준 방향(각도), 크기(거리)로 점 생성자를 정의 
	public MyPoint_backup2( double angle, double distance ) {
		// ?
	}
	
	// full 생성자
	public MyPoint_backup2(int x, int y, String tag, String color) {
		//super(); // 생략가능
		this.x = x;
		this.y = y;
		//this.tag = tag;
		if( tag != null ) this.tag = tag;
		else this.tag = "";
		
		//this.color = color;
		this.color = color != null ? color : DEF_COLOR;
	}
	
	
	// 메소드
	public void printPoint() {
		System.out.printf("%s(%d,%d) 태그: %s[컬러: %s] \n",
				TYPE, this.x, this.y, 
			tag == null || tag.isEmpty() ? DEF_TAG: tag
				, color);
	}
//	public void printPoint() {
//		System.out.printf("%s(%d,%d) \n", TYPE, 
//				this.x, this.y);
//	}



}


