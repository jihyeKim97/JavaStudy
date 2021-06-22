package collective.lists;

import java.util.ArrayList;

// �⵵ (Year) ��Ű�� Ŭ����
//  �����Ǵ��� �������� ����?
// �⵵��(��ġ��), �����Ǵ�����(����), era �����/�����/����
class MyYear {
	private boolean AD; // BC -> AD (����� true, ����� false)
	private int year;
	private boolean bLeap; // true�� ����

	public MyYear() {
	}

	public MyYear(int year) {
		super();
		this.year = year;
		AD = this.year > 0 ? true : false;
		// " ���� AD " : " ����� BC "
		this.bLeap = isLeapYear(this.year); // ���� T
	}

	// ���� T / ��� F
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
		// boolean Ÿ���� �ʵ��� getter�� is-- �����ϴ� �̸�
		return bLeap;
	}

	@Override
	public String toString() {
		return (AD ? "���� AD" : "����� BC") + year + "�⵵ -> " + (bLeap == true ? "leap year" : "common year");
	}

}

public class ListMain4 {

	public static void main(String[] args) {
		ArrayList<Integer> yearList = new ArrayList<>();

		yearList.add(2021); // 0
		yearList.add(2030); // 1

		// �׷�����(1583��)���� ���� �⵵�� ����Ʈ�� �߰�
		for (int i = 0; i < 20; i++) {
			Integer year = (int) (Math.random() * 1000) + 1583;
			// yearList.add(year);
			yearList.add(1, year); // ������ �� ��° ��ġ�� �߰�
			// 0��° (ù��°) ��Ҵ� ����!
			// 2030�� ���� �ι�° ��ġ ������... ������..
		}

//		for (Integer year : yearList) {
//			System.out.println(year);
//		}
	}

}
