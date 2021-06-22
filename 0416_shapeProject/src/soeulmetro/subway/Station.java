package soeulmetro.subway;

import shape.basic.MyPoint;
import shape.d2.round.MyCircle;
// 지하철 역의 개념 스키마 클래스 
/* 
 	점이나 원 도형으로 역을 표현이 가능.
 	역의 이름(한/영), 역의 순서번호, 역의 색상(노선의 색상)
 	역이 속한 노선의 고유번호,
 	(주변정보, 출구 정보, 연계 교통버스, 위도/경도 지도.., 행정구역)
 */

//public class Station { // extends MyCircle { // 상속으로 표현
//MyCircle cc; // 필드로 표현
public class Station extends MyCircle {
	public static final double DEF_ST_RADIUS = 20.0;
	public String stName; // 역의 이름(한/영)
	public int stOrder;//역의 순서번호
	public String stColor; // 역의 색상(노선의 색상)
	public int stSubwayLineNumber;//  	역이 속한 노선의 고유번호
	
	
	
	@Override
	public String toString() {
		return "Station [stName=" + stName + ", stOrder=" + stOrder + ", stColor=" + stColor + ", stSubwayLineNumber="
				+ stSubwayLineNumber + ", ptCenter=" + ptCenter + ", radius=" + radius + ", tag=" + tag + ", color="
				+ color + ", area=" + area + ", perimeter=" + perimeter + "]";
	}

	public Station() {
		//super(); // 호출
	}

	public Station(int ptX, int ptY, 
			String stName, int stOrder, String stColor,
			int stSubwayLineNumber) {
		super(ptX, ptY, DEF_ST_RADIUS);
		//
		this.stName = stName;
		this.stOrder = stOrder;
		this.stColor = stColor;
		super.color = stColor;
		this.stSubwayLineNumber = stSubwayLineNumber;
		//super.tag = "<" + stName + ">역";
		this.tag = "<" + stName + ">역";
	}	
	
	public Station(MyPoint ptCenter, 
			String stName, int stOrder, String stColor,
			int stSubwayLineNumber) {
		super(ptCenter, DEF_ST_RADIUS); // MyCircle 부모 초기화
//		super();
//		this.ptCenter = ptCenter;
//		this.radius = DEF_ST_RADIUS;
		this.stName = stName;
		this.stOrder = stOrder;
		this.stColor = stColor;
		this.stSubwayLineNumber = stSubwayLineNumber;
	}
	
	public Station(MyPoint ptCenter, double radius, 
			String stName, int stOrder, String stColor,
			int stSubwayLineNumber) {
		super(ptCenter, radius); // MyCircle 부모 초기화
		this.stName = stName;
		this.stOrder = stOrder;
		this.stColor = stColor;
		this.stSubwayLineNumber = stSubwayLineNumber;
	}

	
	
//	public Station(String stName, int stOrder, 
//			String stColor, int stSubwayLineNumber) {
//		super();
//		this.stName = stName;
//		this.stOrder = stOrder;
//		this.stColor = stColor;
//		this.stSubwayLineNumber = stSubwayLineNumber;
//	}
	
	
}



