package soeulmetro.subway;

import shape.d1.MyLine;

// 지하철의 두 개 역을 이어주는 짧은 구간 스키마
// 노선의 각 역들을 잇는 작은 구간...
// 스테이션이 두 개 필요함.   시작역 => 끝역 연결되는 짧은 구간. 
// 역 2개(시작/끝), 구간 이름, 구간 색상, 구간 선종류..,
// 구간의 거리, 소속된 노선의 고유번호, 구간 자신의 순서번호...
public class RailWay extends MyLine {
	public Station rwSs; // 역 2개(시작/끝) start station ss
	public Station rwEs; 
	//public String rwName; // 구간 이름
	public String rwColor; // 구간 색상   //  구간 선종류..
	public double rwDist; //구간의 거리  (실측상지도거리, 노선상픽셀길이)
	public int rwSubwayLineNumber; // 소속된 노선의 고유번호
	public int rwOrder; // 구간 자신의 순서번호
	
	public RailWay() {
		// TODO Auto-generated constructor stub
	}
	
	

	public RailWay(Station rwSs, Station rwEs, 
			String rwColor, int rwSubwayLineNumber, 
			int rwOrder) {
		super();
		this.rwSs = rwSs;
		this.rwEs = rwEs;
		this.updateStartPoint(rwSs.ptCenter);
		this.setEp(rwEs.ptCenter);
		this.rwColor = rwColor;		
		this.rwSubwayLineNumber = rwSubwayLineNumber;
		this.rwOrder = rwOrder;
		this.rwDist = this.getDistance();
	}



	public RailWay(Station rwSs, Station rwEs, String rwColor, double rwDist, int rwSubwayLineNumber, int rwOrder) {
		super();
		this.rwSs = rwSs;
		this.rwEs = rwEs;
		this.rwColor = rwColor;
		this.rwDist = rwDist;
		this.rwSubwayLineNumber = rwSubwayLineNumber;
		this.rwOrder = rwOrder;
	}



	@Override
	public String toString() {
		return "RailWay [rwSs=" + rwSs + ", rwEs=" + rwEs + ", rwColor=" + rwColor + ", rwDist=" + rwDist
				+ ", rwSubwayLineNumber=" + rwSubwayLineNumber + ", rwOrder=" + rwOrder + ", tag=" + tag + ", color="
				+ color + ", strokeType=" + strokeType + ", width=" + width + ", getDistance()=" + getDistance() + "]";
	}
	
	
	
	
}
