package soeulmetro.subway;

import java.util.Arrays;

/*
 * 독립적인 하나의 지하철 노선을 표현한 스키마 클래스
 *  > 경로에 속한 모든 스테이션들을 연결한 구간들의 총합
 * - 노선 이름
 * - 노선 고유번호
 * - 노선 색상
 * - 노선 총경로길이
 * - 노선 구성하는 모든 역의 개수(스테이션 수) 
 * - 노선 구성하는 스테이션들 Station
 * - 노선 구성하는 구간들  RailWay
 * - 출발역
 * - 종착역   (환승역은 추후 구현..)
 * - 만약 평균 속도로 지하철이 운행된다면 전체 노선 운행 시간도 측정.
 */
//public class SubwayLine extends Object {
public class SubwayLine {
	public static final int MIN_STATIONS = 4;
	//
	public String sbName;//	 * - 노선 이름
	public int sbOrder; //	 * - 노선 고유번호
	public String sbColor; //	 * - 노선 색상
	public double sbTotalDist; //	 * - 노선 총경로길이
	public int sbNumberOfStations;//* - 노선 구성하는 모든 역의 개수(스테이션 수) 
//	 * - 노선 구성하는 스테이션들 Station
	public Station[] sbStations; // 역들
//	 * - 노선 구성하는 구간들  RailWay
	public RailWay[] sbRailways; // 구간들
	public Station sbStartSt;//	 * - 출발역
	public Station sbEndSt;//	 * - 종착역   (환승역은 추후 구현..)
		// 2호선같은 루프노선(순환선)은 출발역 == 종착역...
	
	public SubwayLine() {
		this.sbNumberOfStations = MIN_STATIONS; //4 
		this.sbStations = new Station[sbNumberOfStations];
		this.sbRailways = new RailWay[sbNumberOfStations-1];
	}

	
	public SubwayLine(String sbName, int sbOrder, 
			String sbColor, int sbNumberOfStations) {
		super();
		this.sbName = sbName;
		this.sbOrder = sbOrder;
		this.sbColor = sbColor;
//		this.sbTotalDist = computeTotalDist();
		if( sbNumberOfStations < MIN_STATIONS ) 
			sbNumberOfStations = MIN_STATIONS;
		this.sbNumberOfStations = sbNumberOfStations;
		this.sbStations = new Station[sbNumberOfStations];		
		this.sbRailways = new RailWay[sbNumberOfStations-1];
		this.sbStartSt = sbStations[0];
		this.sbEndSt = sbStations[sbNumberOfStations-1];
		this.sbTotalDist = computeTotalDist();
	}	
	public double computeTotalDist() {
		double total = 0.0;
		for (RailWay rw : sbRailways) {
			if( rw != null) // 널처리!!
				total += rw.getDistance(); // MyLine::getDistance()
		}
		this.sbTotalDist = total;
		return total;
	}


	public SubwayLine(String sbName, int sbOrder, String sbColor, double sbTotalDist, int sbNumberOfStations,
			Station[] sbStations, RailWay[] sbRailways, Station sbStartSt, Station sbEndSt) {
		super();
		this.sbName = sbName;
		this.sbOrder = sbOrder;
		this.sbColor = sbColor;
//		this.sbTotalDist = sbTotalDist;
		this.sbNumberOfStations = sbNumberOfStations;
		this.sbStations = sbStations;
		this.sbRailways = sbRailways;
		this.sbStartSt = sbStartSt;
		this.sbEndSt = sbEndSt;
		this.sbTotalDist = computeTotalDist();
	}


	@Override
	public String toString() {
		return "SubwayLine [sbName=" + sbName
				+ ", sbOrder=" + sbOrder 
				+ ", sbColor=" + sbColor 
				+ ", sbTotalDist="
				+ sbTotalDist + ", sbNumberOfStations="
				+ sbNumberOfStations + ", sbStations="
				+ Arrays.toString(sbStations) 
				+ ", sbRailways=" 
				+ Arrays.toString(sbRailways) 
				+ ", sbStartSt=" + sbStartSt + 
				", sbEndSt=" + sbEndSt +
				", computeTotalDist()=" + computeTotalDist() + "]";
	}

	
	
	
}
