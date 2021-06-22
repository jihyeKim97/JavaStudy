package soeulmetro;

import shape.util.output.SubwayPrint;
//import soeulmetro.subway.Station;
//import soeulmetro.subway.RailWay;
//import soeulmetro.subway.SubwayLine;
import soeulmetro.subway.*;

/* 서울 지하철 공사에 수주를 받아.. 노선도 프로젝트 
 https://ko.wikipedia.org/wiki/%EC%8B%A0%EB%B6%84%EB%8B%B9%EC%84%A0
 https://www.sisul.or.kr/open_content/skydome/introduce/pop_subway.jsp
 http://seoulmetro.co.kr/kr/cyberStation.do#stationInfo
 
 각 호선별로 각 역을 연결하여 하나의 경로로 표현하는 문제.
 
 
 출발역  ~ 종착역까지의 전체 구간 = 경로  SubwayLine (8호선)
 그 경로를 구성하는 각 지하철역을 Station  (MyCircle/MyPoint)
 역과 역을 연결하는 작은(단일) 구간 RailWay (MyLine)

 => 요구되는 기획사항을 모두 담아 표현하는 스키마 클래스들...

** 신분당선 

D07	강남	Gangnam	江南	● 서울 지하철 2호선	-	0.0	서울특별시	강남구
D08	양재(서초구청)	Yangjae
(Seocho-gu Office)	良才(瑞草區廳)	● 수도권 전철 3호선	1.5	1.5	서초구
D09	양재시민의숲(매헌)	Yangjae Citizen's Forest
(Maeheon)	良才市民의숲(梅軒)		1.6	3.1
D10	청계산입구	Cheonggyesan	淸溪山入口		2.9	6.0
D11	판교(판교테크노밸리)	Pangyo
(Pangyo Techno Valley)	板橋(板橋테크노밸리)	● 수도권 전철 경강선	8.2	14.2	경기도	성남시
D12	정자	Jeongja	亭子	● 수도권 전철 수인·분당선	3.1	17.3
D13	미금(분당서울대병원)	Migeum(Seoul National University Bundang Hospital)	美金	● 수도권 전철 수인·분당선	1.9	19.2
D14	동천	Dongcheon	東川		1.6	20.8	용인시
D15	수지구청	Suji-gu Office	水枝區廳		2.1	22.9
D16	성복	Seongbok	星福		1.7	24.6
D17	상현	Sanghyeon	上峴		2.1	26.7
D18	광교중앙(아주대)	Gwanggyo Jungang
(Ajou University)	光敎中央(亞洲大)		2.4	29.1	수원시
D19	광교(경기대)	Gwanggyo
(Kyonggi University)	光敎(京畿大)		1.9

*/
public class MetroMain {

	public static void main(String[] args) {
		// 신분당선 
		String sbName = "신분당선"; // 노선 고유 이름
		int sbOrder = 7; // 노선 고유번호  d07~d19번 노선도
		String sbColor = "FF0000"; // 노선 고유 컬러
		String[] stNames = {
				"강남", 
				"양재(서초구청)",
				"양재시민의숲(매헌)",
				"청계산입구",
				"판교(판교테크노밸리)",
				"정자",
				"미금(분당서울대병원)",
				"동천",
				"수지구청",
				"성복",
				"상현",
				"광교중앙(아주대)",
				"광교(경기대)"
		}; // 이 노선을 구성하는 역들의 이름 배열
		String[] stNamesEn = {
				"Gangnam", 
				"Yangjae",
				"Yangjae Citizen's Forest",
				"Cheonggyesan",
				"Pangyo",
				"Jeongja",
				"Migeum",
				"Dongcheon",
				"Suji-gu Office",
				"Seongbok",
				"Sanghyeon",
				"Gwanggyo Jungang",
				"Gwanggyo"
		}; 
		final int sbStationNumber = stNamesEn.length; //13
		//
//		Station[] stations = {new Station()};
//		RailWay[] railways = {};
		Station[] stations = new Station[sbStationNumber];
			// null 각각 초기화된 13개의 공간을 가진 배열
		RailWay[] railways = new RailWay[sbStationNumber-1]; //12
		
		// 실제 역을 공사하여 역배열에 배치, 실제 철로를 공사하여 구간배열에 배치 루프.
		for (int i = 0; i < stations.length; i++) {
			Station st = new Station(
					(int)(60*i+10+Station.DEF_ST_RADIUS),
					(int)(60*i+10+Station.DEF_ST_RADIUS),
//					stNames[i], // kr
					stNamesEn[i], // eng
					i + sbOrder, 
					sbColor, sbOrder);
			stations[i] = st; // 배열 배치
			if( i > 0 ) { // 첫번째 역을 제외하고...
				RailWay rw = 
				 new RailWay(stations[i-1], stations[i],
					sbColor, sbOrder, i-1);
				railways[i-1] = rw; // 배열 배치
			}
		}
		Station sbStartSt = stations[0]; // 시작역
		Station sbEndSt = stations[stations.length-1]; // 종착역
		SubwayLine sbShinBundang
			= new SubwayLine(sbName, sbOrder, sbColor,
					0.0, sbStationNumber,
				stations, railways, sbStartSt, sbEndSt);
//		sbShinBundang.computeTotalDist();
//		System.out.println(sbShinBundang); // toString()자동호출
		SubwayPrint.printSubwayLine(sbShinBundang, 4);// html출력
	}
// 도스창에서.. 
// c:\dev2021\java_ws\ShapeProject\bin>java soeulmetro.MetroMain > subway_신분당선1.html
}

/*
SubwayLine [sbName=신분당선, sbOrder=7, sbColor=FF0000, sbTotalDist=1018.2337649086285, sbNumberOfStations=13, sbStations=[Station [stName=강남, stOrder=7, stColor=FF0000, stSubwayLineNumber=7, ptCenter=점 PT(30,30) 태그: 없음[컬러: 000000] 
, radius=20.0, tag=<강남>역, color=FF0000, area=0.0, perimeter=0.0], Station [stName=양재(서초구청), stOrder=8, stColor=FF0000, stSubwayLineNumber=7, ptCenter=점 PT(90,90) 태그: 없음[컬러: 000000] 
, radius=20.0, tag=<양재(서초구청)>역, color=FF0000, area=0.0, perimeter=0.0], Station [stName=양재시민의숲(매헌), stOrder=9, stColor=FF0000, stSubwayLineNumber=7, ptCenter=점 PT(150,150) 태그: 없음[컬러: 000000] 
, radius=20.0, tag=<양재시민의숲(매헌)>역, color=FF0000, area=0.0, perimeter=0.0], Station [stName=청계산입구, stOrder=10, stColor=FF0000, stSubwayLineNumber=7, ptCenter=점 PT(210,210) 태그: 없음[컬러: 000000] 
, radius=20.0, tag=<청계산입구>역, color=FF0000, area=0.0, perimeter=0.0], Station [stName=판교(판교테크노밸리), stOrder=11, stColor=FF0000, stSubwayLineNumber=7, ptCenter=점 PT(270,270) 태그: 없음[컬러: 000000] 
, radius=20.0, tag=<판교(판교테크노밸리)>역, color=FF0000, area=0.0, perimeter=0.0], Station [stName=정자, stOrder=12, stColor=FF0000, stSubwayLineNumber=7, ptCenter=점 PT(330,330) 태그: 없음[컬러: 000000] 
, radius=20.0, tag=<정자>역, color=FF0000, area=0.0, perimeter=0.0], Station [stName=미금(분당서울대병원), stOrder=13, stColor=FF0000, stSubwayLineNumber=7, ptCenter=점 PT(390,390) 태그: 없음[컬러: 000000] 
, radius=20.0, tag=<미금(분당서울대병원)>역, color=FF0000, area=0.0, perimeter=0.0], Station [stName=동천, stOrder=14, stColor=FF0000, stSubwayLineNumber=7, ptCenter=점 PT(450,450) 태그: 없음[컬러: 000000] 
, radius=20.0, tag=<동천>역, color=FF0000, area=0.0, perimeter=0.0], Station [stName=수지구청, stOrder=15, stColor=FF0000, stSubwayLineNumber=7, ptCenter=점 PT(510,510) 태그: 없음[컬러: 000000] 
, radius=20.0, tag=<수지구청>역, color=FF0000, area=0.0, perimeter=0.0], Station [stName=성복, stOrder=16, stColor=FF0000, stSubwayLineNumber=7, ptCenter=점 PT(570,570) 태그: 없음[컬러: 000000] 
, radius=20.0, tag=<성복>역, color=FF0000, area=0.0, perimeter=0.0], Station [stName=상현, stOrder=17, stColor=FF0000, stSubwayLineNumber=7, ptCenter=점 PT(630,630) 태그: 없음[컬러: 000000] 
, radius=20.0, tag=<상현>역, color=FF0000, area=0.0, perimeter=0.0], Station [stName=광교중앙(아주대), stOrder=18, stColor=FF0000, stSubwayLineNumber=7, ptCenter=점 PT(690,690) 태그: 없음[컬러: 000000] 
, radius=20.0, tag=<광교중앙(아주대)>역, color=FF0000, area=0.0, perimeter=0.0], Station [stName=광교(경기대), stOrder=19, stColor=FF0000, stSubwayLineNumber=7, ptCenter=점 PT(750,750) 태그: 없음[컬러: 000000] 
, radius=20.0, tag=<광교(경기대)>역, color=FF0000, area=0.0, perimeter=0.0]], sbRailways=[RailWay [rwSs=Station [stName=강남, stOrder=7, stColor=FF0000, stSubwayLineNumber=7, ptCenter=점 PT(30,30) 태그: 없음[컬러: 000000] 
, radius=20.0, tag=<강남>역, color=FF0000, area=0.0, perimeter=0.0], rwEs=Station [stName=양재(서초구청), stOrder=8, stColor=FF0000, stSubwayLineNumber=7, ptCenter=점 PT(90,90) 태그: 없음[컬러: 000000] 
, radius=20.0, tag=<양재(서초구청)>역, color=FF0000, area=0.0, perimeter=0.0], rwColor=FF0000, rwDist=84.8528137423857, rwSubwayLineNumber=7, rwOrder=0, tag=기본선, color=000000, strokeType=0, width=1, getDistance()=84.8528137423857], RailWay [rwSs=Station [stName=양재(서초구청), stOrder=8, stColor=FF0000, stSubwayLineNumber=7, ptCenter=점 PT(90,90) 태그: 없음[컬러: 000000] 
, radius=20.0, tag=<양재(서초구청)>역, color=FF0000, area=0.0, perimeter=0.0], rwEs=Station [stName=양재시민의숲(매헌), stOrder=9, stColor=FF0000, stSubwayLineNumber=7, ptCenter=점 PT(150,150) 태그: 없음[컬러: 000000] 
, radius=20.0, tag=<양재시민의숲(매헌)>역, color=FF0000, area=0.0, perimeter=0.0], rwColor=FF0000, rwDist=84.8528137423857, rwSubwayLineNumber=7, rwOrder=1, tag=기본선, color=000000, strokeType=0, width=1, getDistance()=84.8528137423857], RailWay [rwSs=Station [stName=양재시민의숲(매헌), stOrder=9, stColor=FF0000, stSubwayLineNumber=7, ptCenter=점 PT(150,150) 태그: 없음[컬러: 000000] 
, radius=20.0, tag=<양재시민의숲(매헌)>역, color=FF0000, area=0.0, perimeter=0.0], rwEs=Station [stName=청계산입구, stOrder=10, stColor=FF0000, stSubwayLineNumber=7, ptCenter=점 PT(210,210) 태그: 없음[컬러: 000000] 
, radius=20.0, tag=<청계산입구>역, color=FF0000, area=0.0, perimeter=0.0], rwColor=FF0000, rwDist=84.8528137423857, rwSubwayLineNumber=7, rwOrder=2, tag=기본선, color=000000, strokeType=0, width=1, getDistance()=84.8528137423857], RailWay [rwSs=Station [stName=청계산입구, stOrder=10, stColor=FF0000, stSubwayLineNumber=7, ptCenter=점 PT(210,210) 태그: 없음[컬러: 000000] 
, radius=20.0, tag=<청계산입구>역, color=FF0000, area=0.0, perimeter=0.0], rwEs=Station [stName=판교(판교테크노밸리), stOrder=11, stColor=FF0000, stSubwayLineNumber=7, ptCenter=점 PT(270,270) 태그: 없음[컬러: 000000] 
, radius=20.0, tag=<판교(판교테크노밸리)>역, color=FF0000, area=0.0, perimeter=0.0], rwColor=FF0000, rwDist=84.8528137423857, rwSubwayLineNumber=7, rwOrder=3, tag=기본선, color=000000, strokeType=0, width=1, getDistance()=84.8528137423857], RailWay [rwSs=Station [stName=판교(판교테크노밸리), stOrder=11, stColor=FF0000, stSubwayLineNumber=7, ptCenter=점 PT(270,270) 태그: 없음[컬러: 000000] 
, radius=20.0, tag=<판교(판교테크노밸리)>역, color=FF0000, area=0.0, perimeter=0.0], rwEs=Station [stName=정자, stOrder=12, stColor=FF0000, stSubwayLineNumber=7, ptCenter=점 PT(330,330) 태그: 없음[컬러: 000000] 
, radius=20.0, tag=<정자>역, color=FF0000, area=0.0, perimeter=0.0], rwColor=FF0000, rwDist=84.8528137423857, rwSubwayLineNumber=7, rwOrder=4, tag=기본선, color=000000, strokeType=0, width=1, getDistance()=84.8528137423857], RailWay [rwSs=Station [stName=정자, stOrder=12, stColor=FF0000, stSubwayLineNumber=7, ptCenter=점 PT(330,330) 태그: 없음[컬러: 000000] 
, radius=20.0, tag=<정자>역, color=FF0000, area=0.0, perimeter=0.0], rwEs=Station [stName=미금(분당서울대병원), stOrder=13, stColor=FF0000, stSubwayLineNumber=7, ptCenter=점 PT(390,390) 태그: 없음[컬러: 000000] 
, radius=20.0, tag=<미금(분당서울대병원)>역, color=FF0000, area=0.0, perimeter=0.0], rwColor=FF0000, rwDist=84.8528137423857, rwSubwayLineNumber=7, rwOrder=5, tag=기본선, color=000000, strokeType=0, width=1, getDistance()=84.8528137423857], RailWay [rwSs=Station [stName=미금(분당서울대병원), stOrder=13, stColor=FF0000, stSubwayLineNumber=7, ptCenter=점 PT(390,390) 태그: 없음[컬러: 000000] 
, radius=20.0, tag=<미금(분당서울대병원)>역, color=FF0000, area=0.0, perimeter=0.0], rwEs=Station [stName=동천, stOrder=14, stColor=FF0000, stSubwayLineNumber=7, ptCenter=점 PT(450,450) 태그: 없음[컬러: 000000] 
, radius=20.0, tag=<동천>역, color=FF0000, area=0.0, perimeter=0.0], rwColor=FF0000, rwDist=84.8528137423857, rwSubwayLineNumber=7, rwOrder=6, tag=기본선, color=000000, strokeType=0, width=1, getDistance()=84.8528137423857], RailWay [rwSs=Station [stName=동천, stOrder=14, stColor=FF0000, stSubwayLineNumber=7, ptCenter=점 PT(450,450) 태그: 없음[컬러: 000000] 
, radius=20.0, tag=<동천>역, color=FF0000, area=0.0, perimeter=0.0], rwEs=Station [stName=수지구청, stOrder=15, stColor=FF0000, stSubwayLineNumber=7, ptCenter=점 PT(510,510) 태그: 없음[컬러: 000000] 
, radius=20.0, tag=<수지구청>역, color=FF0000, area=0.0, perimeter=0.0], rwColor=FF0000, rwDist=84.8528137423857, rwSubwayLineNumber=7, rwOrder=7, tag=기본선, color=000000, strokeType=0, width=1, getDistance()=84.8528137423857], RailWay [rwSs=Station [stName=수지구청, stOrder=15, stColor=FF0000, stSubwayLineNumber=7, ptCenter=점 PT(510,510) 태그: 없음[컬러: 000000] 
, radius=20.0, tag=<수지구청>역, color=FF0000, area=0.0, perimeter=0.0], rwEs=Station [stName=성복, stOrder=16, stColor=FF0000, stSubwayLineNumber=7, ptCenter=점 PT(570,570) 태그: 없음[컬러: 000000] 
, radius=20.0, tag=<성복>역, color=FF0000, area=0.0, perimeter=0.0], rwColor=FF0000, rwDist=84.8528137423857, rwSubwayLineNumber=7, rwOrder=8, tag=기본선, color=000000, strokeType=0, width=1, getDistance()=84.8528137423857], RailWay [rwSs=Station [stName=성복, stOrder=16, stColor=FF0000, stSubwayLineNumber=7, ptCenter=점 PT(570,570) 태그: 없음[컬러: 000000] 
, radius=20.0, tag=<성복>역, color=FF0000, area=0.0, perimeter=0.0], rwEs=Station [stName=상현, stOrder=17, stColor=FF0000, stSubwayLineNumber=7, ptCenter=점 PT(630,630) 태그: 없음[컬러: 000000] 
, radius=20.0, tag=<상현>역, color=FF0000, area=0.0, perimeter=0.0], rwColor=FF0000, rwDist=84.8528137423857, rwSubwayLineNumber=7, rwOrder=9, tag=기본선, color=000000, strokeType=0, width=1, getDistance()=84.8528137423857], RailWay [rwSs=Station [stName=상현, stOrder=17, stColor=FF0000, stSubwayLineNumber=7, ptCenter=점 PT(630,630) 태그: 없음[컬러: 000000] 
, radius=20.0, tag=<상현>역, color=FF0000, area=0.0, perimeter=0.0], rwEs=Station [stName=광교중앙(아주대), stOrder=18, stColor=FF0000, stSubwayLineNumber=7, ptCenter=점 PT(690,690) 태그: 없음[컬러: 000000] 
, radius=20.0, tag=<광교중앙(아주대)>역, color=FF0000, area=0.0, perimeter=0.0], rwColor=FF0000, rwDist=84.8528137423857, rwSubwayLineNumber=7, rwOrder=10, tag=기본선, color=000000, strokeType=0, width=1, getDistance()=84.8528137423857], RailWay [rwSs=Station [stName=광교중앙(아주대), stOrder=18, stColor=FF0000, stSubwayLineNumber=7, ptCenter=점 PT(690,690) 태그: 없음[컬러: 000000] 
, radius=20.0, tag=<광교중앙(아주대)>역, color=FF0000, area=0.0, perimeter=0.0], rwEs=Station [stName=광교(경기대), stOrder=19, stColor=FF0000, stSubwayLineNumber=7, ptCenter=점 PT(750,750) 태그: 없음[컬러: 000000] 
, radius=20.0, tag=<광교(경기대)>역, color=FF0000, area=0.0, perimeter=0.0], rwColor=FF0000, rwDist=84.8528137423857, rwSubwayLineNumber=7, rwOrder=11, tag=기본선, color=000000, strokeType=0, width=1, getDistance()=84.8528137423857]], sbStartSt=Station [stName=강남, stOrder=7, stColor=FF0000, stSubwayLineNumber=7, ptCenter=점 PT(30,30) 태그: 없음[컬러: 000000] 
, radius=20.0, tag=<강남>역, color=FF0000, area=0.0, perimeter=0.0], sbEndSt=Station [stName=광교(경기대), stOrder=19, stColor=FF0000, stSubwayLineNumber=7, ptCenter=점 PT(750,750) 태그: 없음[컬러: 000000] 
, radius=20.0, tag=<광교(경기대)>역, color=FF0000, area=0.0, perimeter=0.0], computeTotalDist()=1018.2337649086285]
*/ 
