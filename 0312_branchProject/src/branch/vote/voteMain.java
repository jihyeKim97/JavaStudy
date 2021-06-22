package branch.vote;

//2016�� �̱� �뼱 ��ǥ �ùķ��̼�
public class voteMain {
	public static final int MAX_VOTES = 538, WIN_VOTES = 270, GAP = 40; // �ִ� �����δ� ��ǥ���� and �缱Ȯ�� �����δ� ��ǥ��
	public static final char DONALFD_PARTY = 'D', HILARY_PARTY = 'H', ETC_PARTY = 'E';

	public static void main(String[] args) {
		int voteCountDonald = 0, voteCountHilary = 0, voteCountEtc = 0; // 1~48 => 'D' //49~96 => 'H' //4% => 'E' -> 48
		int vorder = 1; // ��ǥ ȸ���� ī���� (���� ��ȣ)
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
					" @@@ ���ε�Ʈ���� �缱 ���� @@@ " + vorder + "ȸ������ " + voteCountDonald + "��ǥ!");
			if( voteCountHilary == WIN_VOTES )
				System.out.println(" @@@ ������Ŭ���� �缱 ���� @@@ "+ vorder + "ȸ������ " + voteCountDonald + "��ǥ!");
			
			if (vorder % GAP == 0) {
				System.out.printf("\n-- %.2f%% -- Donald %dǥ  VS  Hilary %dǥ  (��Ÿ:%dǥ)---------\r\n", (double)vorder / MAX_VOTES * 100.0, voteCountDonald,vorder,voteCountDonald, voteCountHilary, voteCountEtc);
				double donaldRatio = (double) voteCountDonald / MAX_VOTES * 100.0;
				double hilaryRatio = (double) voteCountHilary / MAX_VOTES * 100.0;
				
//				System.out.printf("\t\t\t##[ %d ȸ�� ] �����δ� ��ǥ >>>> \t %c \n", vorder, party);
				if (voteCountDonald > voteCountHilary) {
					winLose = '>';
				}else if (voteCountDonald < voteCountHilary) {
					winLose = '<';
				}else {
					winLose = '=';
				}
				System.out.printf("\t---- [���� �ĺ�] ---- ���ε� %.002f%% %c ������ %.002f%% -------\n\n", donaldRatio, winLose,hilaryRatio);
			}
			++vorder; // vorder += 1; // vorder = vorder+1;
		}
		
		System.out.println("\t\t������	������ǥ�� ���� �Ǿ����ϴ�	������\n");
		if (voteCountDonald > voteCountHilary) {
			System.out.printf("   �ֵ���ǥ�� �����!!!!! Donald %dǥ  VS  Hilary %dǥ  (��Ÿ: %dǥ)\r\n", voteCountDonald,
					voteCountHilary, voteCountEtc);
			System.out.println("\t\t�ڡڡڡڡڡڡڡڡ�   DONALD WIN   �ڡڡڡڡڡڡڡڡ�");
		} else if (voteCountDonald < voteCountHilary) {
			System.out.printf("   �ֵ���ǥ�� �����!!!!!  Donald %dǥ  VS  Hilary %dǥ  (��Ÿ: %dǥ)\r\n", voteCountDonald,
					voteCountHilary, voteCountEtc);
			System.out.println("\t\t�ڡڡڡڡڡڡڡڡ�   HILARY WIN   �ڡڡڡڡڡڡڡڡ�");
		} else if (voteCountDonald == voteCountHilary) {
			System.out.printf(" Donald %dǥ  VS  Hilary %dǥ  (��Ÿ: %dǥ)\r\n", voteCountDonald, voteCountHilary,
					voteCountEtc);
			System.out.println("\t\t -----------------  DARW  -----------------");
		}
	}

	private static char voteToParty() { // ������ ���ڸ� �Լ����� �����Ҷ� ���� ���ڶ�� ��¡���� �ǹ̷� ����� ���� �Լ�
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
