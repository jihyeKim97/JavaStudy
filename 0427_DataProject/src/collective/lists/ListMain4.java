package collective.lists;

import java.util.ArrayList;

// 년도 (Year) 스키마 클래스
//  윤년판단을 목적으로 정의?
// 년도값(수치형), 윤년판단유무(논리형), era 기원전/기원후/서기
class MyYear {
	private boolean AD; // BC -> AD (기원후 true, 기원전 false)
	private int year;
	private boolean bLeap; // true면 윤년

	public MyYear() {
	}

	public MyYear(int year) {
		super();
		this.year = year;
		AD = this.year > 0 ? true : false;
		// " 서기 AD " : " 기원전 BC "
		this.bLeap = isLeapYear(this.year); // 윤년 T
	}

	// 윤년 T / 평년 F
	private boolean isLeapYear(int year) {
		boolean result = false;
		if (year % 4 == 0) {
			result = true;
		}
		if (year % 4 == 0 && year % 100 == 0) {
			result = false;
		}
		if (year % 4 == 0 && year % 100 == 0 && year % 400 == 0) {
			result = true;
		}
		return result;
	}

	public MyYear(boolean AD, int year, boolean bLeap) {
		super();
		this.AD = AD;
		this.year = year;
		this.bLeap = bLeap;
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
		return (AD ? "서기 AD" : "기원전 BC") + year + "년도 -> " + (bLeap == true ? "leap year" : "common year");
	}

}

public class ListMain4 {

	public static void main(String[] args) {
		ArrayList<Integer> yearList = new ArrayList<>();

		yearList.add(2021); // 0
		yearList.add(2030); // 1

		// 그레고리력(1583년)으로 랜덤 년도를 리스트에 추가
		for (int i = 0; i < 20; i++) {
			Integer year = (int) (Math.random() * 1000) + 1583;
			// yearList.add(year);
			yearList.add(1, year); // 무조건 두 번째 위치에 추가
			// 0번째 (첫번째) 요소는 고정!
			// 2030이 원래 두번째 위치 였으나... 끝으로..
		}

//		for (Integer year : yearList) {
//			System.out.println(year);
//		}
	}

}
