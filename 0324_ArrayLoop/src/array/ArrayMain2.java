package array;

public class ArrayMain2 {

	public static void main(String[] args) {

		int[] intArr = { 0, 0, 0, 0, 0 }; // 4*5 = 20byte 요소공간에 5개를 요소로써 배치
		int temparr[] = {1,2,5,3,4};
		System.out.println("베열크기 = " + intArr.length);

		printIntArray(intArr);
		intArr[0]=1;
		printIntArray(temparr);
	}
	

	public static void printIntArray(int[] intArr) {
		for (int i = 0; i < intArr.length; i++) {
			System.out.printf("intArr[%d] => %d \n", i, intArr[i]);
		}
	}

	public static int toDouble2(int num) {
		return times(num, 2);
	}

	public static int times(int num, int time) {
		System.out.println(time + "배율함수 실행");
		return time * num;
	}

	public static int toDouble(int num) {
		return 2 * num;
	}
}
