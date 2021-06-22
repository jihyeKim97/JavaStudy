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
public class MyPoint {
	// 상수 필드
	public static final String TYPE = "점 PT";
	public static final String DEF_TAG = "없음";
	public static final String ORIGIN_TAG = "원점";
	public static final String DEF_COLOR = MyShape.COLOR_BLACK;  
				//"000000";
	// 변수 필드
	public int		x;
	public int	 	y;
	public int	 	z;
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
	public MyPoint() {
		this.x = 0; 
		this.y = 0;
		this.tag = ORIGIN_TAG;
		this.color = DEF_COLOR; // black 0x000000
	} // 원점 객체	
	
	// 중간 생성자들
	// 평면상에 있는 점의 두 좌표값만...
	public MyPoint(int x, int y) {
		this.x = x; 
		this.y = y;
		this.tag = MyShape.EMTPY_TAG;  // "";
		this.color = MyShape.COLOR_BLACK;
	}
	
	// axis 축 상에 위치한 점은 x, y 둘 중 하나가 0임.
	// 수평축 x-axis 상 점을 true로 보자..
	public MyPoint( int p, boolean isXAxis ) {
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
	public MyPoint( MyPoint pt ) {
		this.x = pt.x;
		this.y = pt.y;
		this.tag = pt.tag;
		this.color = pt.color;
		System.out.println(pt+"를 복제 완료함..");
	}
	
	// vector로 점을 표현하자.. 
	// (좌표값이 아니라 원점 기준 방향(각도), 크기(거리)로 점 생성자를 정의 
	public MyPoint( double angle, double distance ) {
		// ?
	}
	
	// full 생성자 - 자동으로 정의
	public MyPoint(int x, int y, String tag, String color) {
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
	
	// 점 객체 자신의 필드 등의 데이터를 문자열로 모두/적절하게 묶어서 리턴하는 함수
	// toString() 메소드는 사실.. 부모클래스로부터 상속받은 기능임.
	// 자바언어에서 최상위 조상 클래스는 Object라고 하는데... 
	// 이 Object 클래스의 메소드 toString()을 물려받은 것임.
//	public String toString() {
//		return TYPE + "객체 (" + this.x + "," + this.y + ") ";
//	}
	
	// 함수 재정의 == 오버라이딩 (Overriding)
	// toString을 MyPoint 객체의 목적에 맞도록 함수 재정의	
	@Override
	public String toString() {
		String obj = TYPE+ "("+ this.x 
				+","+ this.y +") 태그: "+ 
			(tag == null || tag.isEmpty() ? DEF_TAG: tag)
			+"[컬러: "+color+"] \n";
		return obj;
		//return super.toString();
	}
	
//	@Override
//	public String toString() {
//		return "MyPoint [x=" + x + ", y=" + y + ", tag=" + tag + ", color=" + color + "]";
//	}
	
	//@Override  // 오버라이드 (메소드를 재정의)
//	public String toString() {
//		//return "MyPoint [x=".concat(x) + x + ", y=" + y 
//		return "MyPoint [x=" + x + ", y=" + y
//				+ ", tag=" + tag 
//				+ ", color=" + color + "]";
//	}
	
	
	
//	@Override
//	public String toString() {
//		return "MyPoint [x=" + this.x + ", y=" + this.y 
//				+ ", tag=" + tag + ", color=" + color + "]";
//	}
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


