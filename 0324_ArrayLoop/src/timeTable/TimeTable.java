package timeTable;

import utility.ScanUtill;

public class TimeTable {

	public static final int DAY_MON = 0;
	public static final int DAY_TUE = 1;
	public static final int DAY_WED = 2;
	public static final int DAY_THR = 3;
	public static final int DAY_FRI = 4;

	public static final String[] DAY_OF_WEEKS_KR = { "월", "화", "수", "목", "금" };
	public static final String[] DAY_OF_WEEKS_EN = { "Mon", "Tue", "Wed", "Thu", "Fri" };

	public static final int SUBJECT_NONE = 0;
	public static final int SUBJECT_KOREAN = 1;
	public static final int SUBJECT_ENGLISH = 2;
	public static final int SUBJECT_MATH = 3;
	public static final int SUBJECT_CODING = 4;
	public static final int SUBJECT_SCIENCE = 5;
	public static final int SUBJECT_MUSIC = 6;
	public static final int SUBJECT_ART = 7;

	public static final String[] SUBJECTS_KR = { "    ", "국어", "영어", "수학", "코딩", "과학", "음악", "미술" };

	public static final String[] SUBJECTS_EN = { "    ", "KOREAN", "ENGLISH", "MATH", "CODING", "SCIENCE", "MUSIC",
			"ART" };

	public static final String[] SUBJECTS_JP = { "    ", "韓国語", "英語", "数学", "コーディング", "科学", "音楽", "アート" };

	public static void main(String[] args) {
		int[][] timeTable = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };

		String name = ScanUtill.userInputToString(">> 시간표 사용자 이름: ");
		int count = 0;

		do {
			int meun = ScanUtill.userInputToIntInRange("메뉴 :: 1(신규과정시간표배정)   ,, 2(종료=> 선택 : ", 1, 2);
			if (meun == 2)break;
			System.out.println(++count + "번째 과목 배정 시작~!");
			int yoil = ScanUtill.userInputToIntInRange(">> 요일선택(0월~4금): ", DAY_MON, DAY_FRI);
			int gyosi = ScanUtill.userInputToIntInRange(">> 교시선택(1~7교시): ", 1, 7);

			String strSub = makeSubjectGuideMsg(SUBJECTS_EN, "!!");

			int gwamok = ScanUtill.userInputToIntInRange(strSub, SUBJECT_KOREAN, SUBJECT_ART);
			System.out.println("\n" + name + "님이 " + SUBJECTS_KR[gwamok] + " 과목을 시간표에 " + DAY_OF_WEEKS_KR[yoil] + "요일 "
					+ gyosi + "교시에 추가 합니다.");
			timeTable[gyosi - 1][yoil] = gwamok;
		} while (true);

		System.out.printf("*** '%s'님의 시간표 ***\n", name);
		System.out.println(lineDraw("~~@~~.", 6));
		System.out.print("|시간\\요일|");
		for (int w = 0; w < DAY_OF_WEEKS_KR.length; w++) {
			System.out.print("  " + DAY_OF_WEEKS_KR[w] + " |");
		}
		System.out.println();
		System.out.println(lineDraw("----", 10));

		for (int i = 0; i < timeTable.length; i++) {
			System.out.print("|  " + (i + 1) + "교시  |");
			for (int j = 0; j < DAY_OF_WEEKS_KR.length; j++) {
				System.out.printf(" %s |", SUBJECTS_KR[timeTable[i][j]]);
			}
			System.out.println();
		}
		System.out.println(lineDraw("=", 40));

	}

	private static String makeSubjectGuideMsg(String[] subjects, String sep) {
		String strSub = "";
		strSub += ">> **과목선택(";
		int q = 0;
		for (q = 0; q < subjects.length; q++) {
			System.out.println(q);
			if (q > 0) {
				strSub += (q + "." + subjects[q] + (q < subjects.length - 1 ? sep : ""));
			}
		}
		strSub += ") 입력: ";
		return strSub;
	}

	// 다수개의 문자열을 받아 한꺼번에 합치는 처리 함수
	private static String makeSubjectGuideMsg(String[] subjectsKr) {
		String strSub = "";
		strSub += ">> ****과목선택(";
		int q = 0;
		for (q = 0; q < subjectsKr.length; q++) {
			System.out.println(q);
			if (q > 0) {
				strSub += (q + "." + subjectsKr[q] + (q < subjectsKr.length - 1 ? ", " : ""));
			}
		}
		strSub += ") 입력: ";
		return strSub;
	}

	public static String lineDraw(String patten, int length) {
		String line = "";
		for (int i = 0; i < length; i++) {
			line += patten;
		}
		return line;
	}
}
