package collective.lists;

import java.util.ArrayList;

public class ListMain3 {

	public static void main(String[] args) {
		ArrayList<Integer> yearList = new ArrayList<>();
//		yearList.add() // ���� Create
//		yearList.get() // ��ȸ read
//		yearList.set() // ���� update
//		yearList.remove() // ���� delete

		yearList.add(2021);
		yearList.add(2030);

		for (int i = 0; i < 20; i++) {
			Integer year = (int) (Math.random() * 1000) + 1583;
			yearList.add(1, year);
		}
//		for (Integer year : yearList) {
//			System.out.println(year);
//		}
		/*-------------------------------------------------------*/
		ArrayList<MyYear> myList = new ArrayList<>();
//		MyYear my = new MyYear(1999);
//		myList.add(my);

		for (int year : yearList) {
			MyYear my = new MyYear(year); // auto - unboxing
			myList.add(my);
		}
		final int MY_YEARS = myList.size();
		System.out.println("�⵵ �Ѱ��� : "+MY_YEARS);
		int lyCnt = 0;
		for (int i = 0; i < MY_YEARS; i++) {
			MyYear my = myList.get(i);
			System.out.println(my);
			if(my.isbLeap()) {
				lyCnt++;
			}
		}
		System.out.println("���� ���� : "+ lyCnt);
	}
}
