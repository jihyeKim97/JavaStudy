package collective.lists.pop;

import java.util.ArrayList;
import java.util.HashSet;

//년도 (MyPopYear) 스키마 클래스
//윤년판단을 목적으로 정의?
//년도값(수치형), 윤년판단유무(논리형), era 기원전/기원후/서기
class MyPopYear {
	private boolean AD; // BC -> AD (기원후 true, 기원전 false)
	private int year;
	private boolean bLeap; // true면 윤년
	//
	public long popul; // 그 해에 출생수

	public MyPopYear() {
	}

	public MyPopYear(int year) {
		super();
		this.year = year;
		AD = this.year > 0 ? true : false;
		// "서기 AD" : "기원전 BC";
		this.bLeap = isLeapYear(this.year); // 윤년 true
		this.popul = (long) (Math.random() * 1000000000l) + 1L;// 10억
	}

	public MyPopYear(int year, long popul) {
		super();
		this.year = year;
		AD = this.year > 0 ? true : false;
		// "서기 AD" : "기원전 BC";
		this.bLeap = isLeapYear(this.year); // 윤년 true
		this.popul = popul;
	}

	// true 윤년 false 평년
	private boolean isLeapYear(int year) {
		boolean result = false; // 평년이 대다수이므로 기본.
		if (year % 4 == 0)
			result = true; // 윤년 후보?
		if (year % 4 == 0 && year % 100 == 0)
			result = false; // 윤년일듯 하였으나 평년 후보..
		if (year % 4 == 0 && year % 100 == 0 && year % 400 == 0)
			result = true;
		//// 윤년일듯 하였으나 평년 이었다가 최종 윤년으로 확정.
		return result;
	}

	public MyPopYear(boolean AD, int year, boolean bLeap) {
		super();
		this.AD = AD;
		this.year = year;
		this.bLeap = bLeap;
		// popul = 0L;
	}

	public MyPopYear(boolean aD, int year, boolean bLeap, long popul) {
		super();
		AD = aD;
		this.year = year;
		this.bLeap = bLeap;
		this.popul = popul;
	}

	// Read/Write
	public boolean isAD() {
		return AD;
	}

	public void setAD(boolean aD) {
		AD = aD;
	}

	// Readonly
	public int getYear() {
		return year;
	}

	// Readonly
	public boolean isbLeap() {
		// boolean 타입의 필드의 getter는 is-- 시작하는 이름
		return bLeap;
	}

	@Override
	public String toString() {
		return (AD ? "서기 AD " : "기원전 BC ") + year + "년도 => " + (bLeap == true ? "<<<윤년>>>" : "  평년   ") + " / 출생수: "
				+ this.popul + "명";
	}

}

// 년도별 인구수 관리 클래스 
class PopAdmin {
	public String name;
	public double avg;
//	public MyPopYear[] ppy; // 배열: 불변 , 순서o
	public ArrayList<MyPopYear> pyList; // 리스트: 가변, 순서o
//	public HashSet<MyPopYear> pySet; // 집합: 가변, 순서x

	public PopAdmin() {
		// TODO Auto-generated constructor stub
	}

	public PopAdmin(String name) {
		super();
		this.name = name;
		this.avg = 0.0;
		this.pyList = new ArrayList<>();
	}

	public PopAdmin(String name, double avg, ArrayList<MyPopYear> pyList) {
		super();
		this.name = name;
		this.avg = avg;
		this.pyList = pyList;
	}

	@Override
	public String toString() {
		return "PopAdmin [name=" + name + ", avg=" + avg + ", pyList=" + pyList + "]";
	}

	// 최소 년도, 최대 년도 ??
	// 최대 출생수, 최대 출생수의 년도
	// 최소 출생수, 최소 출생수의 년도
	// 평균 출생수 (분산, 표준편차..)
	// 윤년 vs 평년 비율, 윤년 vs 평년 출생비율
	// CRUD.. 신규 MyPopYear 추가, 삭제, 편집/갱신, 조회/검색

	// 윤년만의 평균?
	public double getAvgPopForLeapYear() { // 산술평균
		long sum = 0L;
		double tmpAvg = 0.0;
		int lyCnt = 0;
		for (MyPopYear mpy : pyList) {
			if (mpy.isbLeap()) { // leap only
				sum += mpy.popul;
				lyCnt++;
			}
		}
		tmpAvg = (double) sum / lyCnt;
		this.avg = tmpAvg;
		return this.avg;
	}

	// 모든 년도
	public double getAvgPop() { // 산술평균
		long sum = 0L;
		double tmpAvg = 0.0;
		for (MyPopYear mpy : pyList) {
			sum += mpy.popul;
		}
		tmpAvg = (double) sum / pyList.size();
		this.avg = tmpAvg;
		return this.avg;
	}

	public void printMaXPopAndYear2() {
		MyPopYear max = pyList.get(0);
		for (int i = 1; i < pyList.size(); i++) {
			if (pyList.get(i).popul > max.popul) {
				max = pyList.get(i);
			} // 비교 판단을 필드 하나로 하되, 저장은 객체를 통째로..
		}
		System.out.println(">> 최대 출생수, 최대 출생수의 년도::");
		System.out.printf("\t최대 출생수: %10d 명\n", max.popul);
		System.out.printf("\t최대 출생수의 년도: %d 년\n", max.getYear());
		System.out.printf("\t최대 출생수의 년도 윤년판단: %s \n", max.isbLeap() ? "윤년" : "평년");
	}

	public void printMaXPopAndYear() {
		long maxPop = pyList.get(0).popul;// 0L;
		int maxPopYear = pyList.get(0).getYear();
		boolean maxPopYearLeap = pyList.get(0).isbLeap();
		for (int i = 1; i < pyList.size(); i++) {
			// get(i) null 아님...믿음.
			if (pyList.get(i).popul > maxPop) {
				maxPop = pyList.get(i).popul;
				maxPopYear = pyList.get(i).getYear();
				maxPopYearLeap = pyList.get(i).isbLeap();
			}
		}
		System.out.println(">> 최대 출생수, 최대 출생수의 년도::");
		System.out.printf("\t최대 출생수: %10d 명\n", maxPop);
		System.out.printf("\t최대 출생수의 년도: %d 년\n", maxPopYear);
		System.out.printf("\t최대 출생수의 년도 윤년판단: %s \n", maxPopYearLeap ? "윤년" : "평년");
		// 최대 출생수의 윤년 유무?
		// 최대 출생수의 OO?? .... 많다.
	}
}

// 인구 (출생) 통계를 list로 표현 -- 그래프 ?
public class Population {

	public static void main(String[] args) {
		MyPopYear ppy[] = new MyPopYear[10];
		for (int i = 0; i < ppy.length; i++) {
			ppy[i] = new MyPopYear((int) (Math.random() * 101) + 1970);
			// 현재 년도도 기준으로 과거 50 ~ 미래 50년간..
		}

		for (int i = 0; i < ppy.length; i++) {
			MyPopYear mpy = ppy[i];
			System.out.println(mpy);
		}
		// 배열에서 리스트로 옮기기..
		ArrayList<MyPopYear> pyList = new ArrayList<>(); // size 0
		for (MyPopYear mpy : ppy) {
			pyList.add(mpy); // size++
		}
		System.out.println("----------------");
		for (int i = 0; i < pyList.size(); i++) {
			MyPopYear mpy = pyList.get(i);
			System.out.println(mpy);
		}

		PopAdmin pa = new PopAdmin("엘사어드민", 0.0, pyList);
		pa.printMaXPopAndYear2();
		System.out.printf(">> %d 년치 평균 출생수: %.2f명\n", pa.pyList.size(), pa.getAvgPop());
		System.out.printf(">> %d 년 동안의 윤년들의 평균 출생수: %.2f명\n", pa.pyList.size(), pa.getAvgPopForLeapYear());
	}

}
