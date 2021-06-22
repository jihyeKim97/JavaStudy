package branch.vote;
// 2016년도 미국 대선 투표 시뮬레이션 
// https://ko.wikipedia.org/wiki/2016%EB%85%84_%EB%AF%B8%EA%B5%AD_%EB%8C%80%ED%86%B5%EB%A0%B9_%EC%84%A0%EA%B1%B0
// https://namu.wiki/w/2016%EB%85%84%20%EB%AF%B8%EA%B5%AD%20%EB%8C%80%ED%86%B5%EB%A0%B9%20%EC%84%A0%EA%B1%B0
// https://ww.namu.la/s/28813ddfc7dc7c38c07003f9b20a79b8492da9d171794eb6ae40fe19de385b50ea70ccb95cbfcf2c3b84112e9a372d581767e695c67f2e9dd629469e862d86fb1cadb604521d984fa1c3586daf348895a4739172b863a9b519e53dc7d1b4e40796e23f1757cd5437f6fd584a7b5975dc
// 보수 vs. 진보 진영
// donald trump vs. hilary cliton
// 선거인단 538개 (투표, 개표하는 총 범위이 최대치)
// '당선 확실'하게 되는 선거인단의 득표수... 약 270개 

public class voteMain2 {

	// 상수 정의 
	public static final int MAX_VOTES = 538; // 최대 선거인단 투표수
	public static final int WIN_VOTES = 270; // 당선확실 선거인단 득표수
	public static final char DONALD_PARTY = 'D';
	public static final char HILARY_PARTY = 'H';
	public static final char ETC_PARTY = 'E'; // 군소 후보들?
	public static final int GAP = 30; // 60; //40; //30; //50; //20; // 구간
	
	
	// html로 출력을 보여주기위한 함수 추가 
	public static void printHTMLStart() {
		final String HTML_START 
			= "<!DOCTYPE html>"
			+ "<html>"
				+ "<head>"
//				+ "<meta charset=\"EUC-KR\" />" // \" 큰따옴표 문자자체
				+ "<meta charset='EUC-KR' />"
					+ "<title> 2016년도 미국대선 결과 </title>"
				+ "</head>"
				+ "<body>"
					+ "<h1>2016년도 미국대선 시뮬레이션</h1>"
					+ "<img src='USA_vote2016.png' width='60%'>" 
					+ "<hr>";
		System.out.println(HTML_START);				
	}
	public static void printHTMLEnd() {
		final String HTML_END = 
				  "</body>"
			+ "</html>";
		System.out.println(HTML_END);
	}

	
	public static void main(String[] args) {
		printHTMLStart();
		
		// 변수 정의 - 정당 party 후보별 득표수 카운터 변수 
		int voteCountDonald = 0;// = 0; // 48% == 1 ~ 48 => 'D'
		int voteCountHilary = 0; // 48% == 49 ~ 96 => 'H'
		int voteCountEtc = 0; // 4% => 'E'
		
		// 선거인단이 개별 투표를 하다() 
		// => 1개의 투표가 진행, 개표를 통해 득표를 올려야 됨 
		
		int vorder = 1; // vote order 투표 회차수 카운터 (순서번호)
		boolean bAlmostWin = false; // 과반수 당선확정 '유력' 발표 유무
		//final int GAP = 30; //50; //20; // 구간
		//int status = GAP; // 구간 상태 변수 30, 60, 90,...
		//while(bFlag == true) {
		// 종료조건식 
		System.out.println("<ul>");
		while(vorder <= MAX_VOTES) { // vorder <= 538
			// 랜덤하게 선거인단이 투표함.
			// 48 : 48 : 4   =>   3개 party 분할
			char party = voteToParty(); // 'D', 'H', 'E'
			
			// 득표수 누적 집계 D, H, E
			if( party == DONALD_PARTY ) // 'D')
				voteCountDonald++; // 도널드당 득표 1+
			else if( party == HILARY_PARTY )
				voteCountHilary++;
			else 
				voteCountEtc++;
			
//			System.out.printf("[%d 회차] 선거인단 투표 => %c \n", 
//					vorder, party); // 순서, 개수, 타입 일치...
			
			// 과반수 '당선확정' 처리!!  
			if( bAlmostWin == false ) {
				if( voteCountDonald == WIN_VOTES ) {
					System.out.println(
						"<div style='color: green; padding: 20px;"
						+ "border: solid 2px gray'> "
						+ "@@@ 도널드트럼프 당선 유력 당선확정 @@@ " + vorder 
							+ "회차까지 " + voteCountDonald + "득표!");
					bAlmostWin = true;
					System.out.println("</div>");
				}
				if( voteCountHilary == WIN_VOTES ) {
					System.out.println(
						"<div style='color: pink; padding: 20px;"
						+ "border: solid 2px gray'> "
						+ " @@@ 힐러리클린턴 당선 유력 당선확정 @@@ "+ vorder 
							+ "회차까지 " + voteCountHilary + "득표!");
					bAlmostWin = true;
					System.out.println("</div>");
				}
			}
			// GAP ==> 30회 주기로 구간별 누적득표상황 표시
			//if( vorder == GAP ) {
			//if( vorder == status ) {
			if( vorder % GAP == 0 ) { // 구간 시작
				System.out.println("<li>");
				// 나머지 연산자로.. 약수연산처럼.. 긴 구간을 일정한 나머지 이하구간으로 반복함
				System.out.printf(
				//"[%3d 회차] 득표상황: Donald %d표 vs. Hilary %d표 (기타: %d표)\r\n",
				//"[%03d 회차] 득표상황: Donald %d표 vs. Hilary %d표 (기타: %d표)\r\n",						
				"<b style='color: blue'>[개표 진행률 %.2f%%] 득표상황:</b> <br> Donald %d표 vs. Hilary %d표 (기타: %d표)\r\n",						
				(double)vorder / MAX_VOTES * 100.0, 
				voteCountDonald, voteCountHilary,
				voteCountEtc);
//				status += GAP;  //status = status + GAP;
				
				// 이번 구간 까지의 우세 판정
				double donaldRatio = 
					(double)voteCountDonald / MAX_VOTES * 100.0;
							
				System.out.println("<br>");
				System.out.println("\t=== 우세 판정 ===");
				char winLose; // ><=
				if( voteCountDonald > voteCountHilary )
					winLose = '>';
					//System.out.println("\t 도널드가 winning~~~");
//					System.out.printf("\t 도널드 %.2f%% > 힐러리 %.2f%% \n", 
//							donaldRatio, 
//							(double)voteCountHilary /MAX_VOTES * 100.0 );
				else if( voteCountDonald < voteCountHilary )
					winLose = '<';
//					System.out.println("\t 힐러리가 winning~~~");
//					System.out.printf("\t 도널드 %.2f%% < 힐러리 %.2f%% \n", 
//							donaldRatio, 
//							(double)voteCountHilary /MAX_VOTES * 100.0 );
				else 
					winLose = '=';
//					System.out.println("\t 두 후보들이 무승부 중~~~");
//					System.out.printf("\t 도널드 %.2f%% = 힐러리 %.2f%% \n", 
//							donaldRatio, 
//							(double)voteCountHilary /MAX_VOTES * 100.0 );
				
					// %% => '%' 문자로 출력
				System.out.printf("\t 도널드 %.2f%% %c 힐러리 %.2f%% \n", // '>' '<' '=' 
						donaldRatio, 
						winLose,
						(double)voteCountHilary /MAX_VOTES * 100.0 );
				System.out.println("</li>");
			} // 구간 끝
			
			
			//			
			++vorder; //vorder++; //vorder += 1;  // vorder = vorder + 1;
		} // loop exit
		System.out.println("</ul>");
		
		System.out.println(" ===  선거 인단 투표 및 개표 끝 === ");
		
		// 최종 결과 출력 
		System.out.println("\n\n <h2>--- 최종 투표 결과 ---</h2> ");
		System.out.printf(
			"\t최종 득표상황: Donald %d표 vs. Hilary %d표 (기타: %d표)\r\n",
				voteCountDonald, voteCountHilary,
				voteCountEtc);
		// 당선인 결정하여 출력 d, h (기타는 무시함)
		System.out.print("\t <p style='color: orange'> <b>****** 당선자 : ");
		if(voteCountDonald > voteCountHilary) // trump win
			System.out.println(" 도널드 트럼프!!!");
		else if(voteCountDonald < voteCountHilary) // clinton win
			System.out.println(" 힐러리 클린턴!!!");
		else // draw 동일 
			System.out.println(" 무승부! 선거 다시!!");
		System.out.println("</b> </p>");	
		printHTMLEnd();
	}

	public static char voteToParty() {
		char party;
		int ranVote = (int)(Math.random() * 100) + 1; // 1 ~ 100
		if( ranVote >= 1 && ranVote <= 48 ) 
			party = DONALD_PARTY; // 'D'; // 도날드가 한표 얻음.		
		//else if( ranVote > 48 && ranVote <= 96 )
		else if( ranVote <= 96 )
			party = HILARY_PARTY; //'H'
		else 	
			party = ETC_PARTY; // 'E'
		
		return party;
	}

}

/*
[개표 진행률 5.58%] 득표상황: Donald 12표 vs. Hilary 17표 (기타: 1표)
	=== 우세 판정 ===
	 도널드 2.23% < 힐러리 3.16% 
[개표 진행률 11.15%] 득표상황: Donald 31표 vs. Hilary 27표 (기타: 2표)
	=== 우세 판정 ===
	 도널드 5.76% > 힐러리 5.02% 
[개표 진행률 16.73%] 득표상황: Donald 43표 vs. Hilary 45표 (기타: 2표)
	=== 우세 판정 ===
	 도널드 7.99% < 힐러리 8.36% 
[개표 진행률 22.30%] 득표상황: Donald 57표 vs. Hilary 59표 (기타: 4표)
	=== 우세 판정 ===
	 도널드 10.59% < 힐러리 10.97% 
[개표 진행률 27.88%] 득표상황: Donald 74표 vs. Hilary 70표 (기타: 6표)
	=== 우세 판정 ===
	 도널드 13.75% > 힐러리 13.01% 
[개표 진행률 33.46%] 득표상황: Donald 87표 vs. Hilary 83표 (기타: 10표)
	=== 우세 판정 ===
	 도널드 16.17% > 힐러리 15.43% 
[개표 진행률 39.03%] 득표상황: Donald 108표 vs. Hilary 91표 (기타: 11표)
	=== 우세 판정 ===
	 도널드 20.07% > 힐러리 16.91% 
[개표 진행률 44.61%] 득표상황: Donald 124표 vs. Hilary 104표 (기타: 12표)
	=== 우세 판정 ===
	 도널드 23.05% > 힐러리 19.33% 
[개표 진행률 50.19%] 득표상황: Donald 136표 vs. Hilary 118표 (기타: 16표)
	=== 우세 판정 ===
	 도널드 25.28% > 힐러리 21.93% 
[개표 진행률 55.76%] 득표상황: Donald 151표 vs. Hilary 133표 (기타: 16표)
	=== 우세 판정 ===
	 도널드 28.07% > 힐러리 24.72% 
[개표 진행률 61.34%] 득표상황: Donald 167표 vs. Hilary 146표 (기타: 17표)
	=== 우세 판정 ===
	 도널드 31.04% > 힐러리 27.14% 
[개표 진행률 66.91%] 득표상황: Donald 182표 vs. Hilary 159표 (기타: 19표)
	=== 우세 판정 ===
	 도널드 33.83% > 힐러리 29.55% 
[개표 진행률 72.49%] 득표상황: Donald 201표 vs. Hilary 170표 (기타: 19표)
	=== 우세 판정 ===
	 도널드 37.36% > 힐러리 31.60% 
[개표 진행률 78.07%] 득표상황: Donald 219표 vs. Hilary 182표 (기타: 19표)
	=== 우세 판정 ===
	 도널드 40.71% > 힐러리 33.83% 
[개표 진행률 83.64%] 득표상황: Donald 238표 vs. Hilary 193표 (기타: 19표)
	=== 우세 판정 ===
	 도널드 44.24% > 힐러리 35.87% 
[개표 진행률 89.22%] 득표상황: Donald 248표 vs. Hilary 212표 (기타: 20표)
	=== 우세 판정 ===
	 도널드 46.10% > 힐러리 39.41% 
[개표 진행률 94.80%] 득표상황: Donald 262표 vs. Hilary 225표 (기타: 23표)
	=== 우세 판정 ===
	 도널드 48.70% > 힐러리 41.82% 
 @@@ 도널드트럼프 당선 유력 당선확정 @@@ 528회차까지 270득표!
 ===  선거 인단 투표 및 개표 끝 === 


 --- 최종 투표 결과 --- 
	최종 득표상황: Donald 275표 vs. Hilary 238표 (기타: 25표)
	 ****** 당선자 :  도널드 트럼프!!!
 
 */