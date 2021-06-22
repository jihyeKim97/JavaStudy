package shape.basic;
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
public class MyPoint_backup1 {
	// 상수 필드
	public static final String TYPE = "점 PT";
	public static final String DEF_TAG = "없음";
	public static final String ORIGIN_TAG = "원점";
	public static final String DEF_COLOR = "000000";
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
	public MyPoint_backup1() {
		this.x = 0; 
		this.y = 0;
		this.tag = ORIGIN_TAG;
		this.color = DEF_COLOR; // black 0x000000
	} // 원점 객체	
	
	
	// full 생성자
	public MyPoint_backup1(int x, int y, String tag, String color) {
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


