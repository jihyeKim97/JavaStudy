package branch.vote;

//2016년 미국 대선 투표 시뮬레이션
public class voteMain {
	public static final int MAX_VOTES = 538, WIN_VOTES = 270, GAP = 40; // 최대 선거인단 투표수뭉 and 당선확실 선거인단 득표수
	public static final char DONALFD_PARTY = 'D', HILARY_PARTY = 'H', ETC_PARTY = 'E';

	public static void main(String[] args) {
		int voteCountDonald = 0, voteCountHilary = 0, voteCountEtc = 0; // 1~48 => 'D' //49~96 => 'H' //4% => 'E' -> 48
		int vorder = 1; // 투표 회차수 카운터 (순서 번호)
		char winLose;
		boolean bAlmostWin = false;

		while (vorder <= MAX_VOTES) {
			char party = voteToParty();

			if (party == DONALFD_PARTY) {
				voteCountDonald++;
			} else if (party == HILARY_PARTY) {
				voteCountHilary++;
			} else {
				voteCountEtc++;
			}
			
			if( voteCountDonald == WIN_VOTES )
				System.out.println(
					" @@@ 도널드트럼프 당선 유력 @@@ " + vorder + "회차까지 " + voteCountDonald + "득표!");
			if( voteCountHilary == WIN_VOTES )
				System.out.println(" @@@ 힐러리클린턴 당선 유력 @@@ "+ vorder + "회차까지 " + voteCountDonald + "득표!");
			
			if (vorder % GAP == 0) {
				System.out.printf("\n-- %.2f%% -- Donald %d표  VS  Hilary %d표  (기타:%d표)---------\r\n", (double)vorder / MAX_VOTES * 100.0, voteCountDonald,vorder,voteCountDonald, voteCountHilary, voteCountEtc);
				double donaldRatio = (double) voteCountDonald / MAX_VOTES * 100.0;
				double hilaryRatio = (double) voteCountHilary / MAX_VOTES * 100.0;
				
//				System.out.printf("\t\t\t##[ %d 회차 ] 선거인단 투표 >>>> \t %c \n", vorder, party);
				if (voteCountDonald > voteCountHilary) {
					winLose = '>';
				}else if (voteCountDonald < voteCountHilary) {
					winLose = '<';
				}else {
					winLose = '=';
				}
				System.out.printf("\t---- [유력 후보] ---- 도널드 %.002f%% %c 힐러리 %.002f%% -------\n\n", donaldRatio, winLose,hilaryRatio);
			}
			++vorder; // vorder += 1; // vorder = vorder+1;
		}
		
		System.out.println("\t\t□□□□□	선거투표가 종료 되었습니다	□□□□□\n");
		if (voteCountDonald > voteCountHilary) {
			System.out.printf("   최동득표한 사람은!!!!! Donald %d표  VS  Hilary %d표  (기타: %d표)\r\n", voteCountDonald,
					voteCountHilary, voteCountEtc);
			System.out.println("\t\t★★★★★★★★★   DONALD WIN   ★★★★★★★★★");
		} else if (voteCountDonald < voteCountHilary) {
			System.out.printf("   최동득표한 사람은!!!!!  Donald %d표  VS  Hilary %d표  (기타: %d표)\r\n", voteCountDonald,
					voteCountHilary, voteCountEtc);
			System.out.println("\t\t★★★★★★★★★   HILARY WIN   ★★★★★★★★★");
		} else if (voteCountDonald == voteCountHilary) {
			System.out.printf(" Donald %d표  VS  Hilary %d표  (기타: %d표)\r\n", voteCountDonald, voteCountHilary,
					voteCountEtc);
			System.out.println("\t\t -----------------  DARW  -----------------");
		}
	}

	private static char voteToParty() { // 랜덤한 숫자를 함수에서 실행할때 마다 문자라는 상징적인 의미로 만들어 지는 함수
		char party;
		int ranVote = (int) ((Math.random() * 100) + 1);

		if (ranVote >= 1 && ranVote <= 48) {
			party = DONALFD_PARTY;
		} else if (ranVote <= 96) {
			party = HILARY_PARTY;
		} else {
			party = ETC_PARTY;
		}
		return party;
	}

}
