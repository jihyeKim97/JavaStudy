package array;

public class ArrayMain {

	public static void main(String[] args) {
		// array = List의 한종류
		// '동일한 데이터형'요소들을 다 수개 대표이름으로 묶음
		// index로써 배열의 가가요소 접근, 변경등의 관리 가능
		// 요수 개수 = 배열크기 = lenght '상수'
		// 배열의 크기는 상수 이므로 한번 정의된 배열의 크기 변환 불가능

		int[] intArr = { 0, 356, -45, 115, 27845 }; // 선언+초기화 = 정의
		byte[] byteArr = { -128, 0, -1, 127, 128 - 1 };
		short[] shortArr = { 0, -1, -32000, -65536 / 2, 65535 / 2 };
		long[] longArr = { 0, 0L, 2200000000L, -2100000000, (long) 2200000000L };

		float[] floatArr = { 0f, 0.0f, 1.2451f, (float) -52.2, 3.141592f };
		double[] doubleArr = { 3.14256, 54.57, 855.5, 0.0f, 1.25d, 0L };

		char[] charArr = { 'a', 97, 'A', 65, 'a' - 'A', 'E', '홍' - 1, '\0', 'b' };
		char c = '엘';
		char[] charArr2 = { 'A', 65, 'a', 97, ' ', 32, 'a' - 'A', '홍' - 1, (char) (c + 1), charArr[2],(char) (charArr[2] - 1) };
		String[] stringArr = { "ABC", "abc", "apple" };
		
		System.out.println("charArr2 배열의 크기: " + charArr2.length + "글자수");

		for (int i = 0; i < charArr2.length; i++) {
			System.out.printf("%d번째 문자 요소 = %c [%d] \n", i, charArr2[i], (int) (charArr2[i]));
		}
		
		boolean flag = true;
		boolean[] boolArr = { 33 != 0, 100 > 300, flag, !flag, false, true, charArr2.length % 2 == 0 }; // 조건식의 항상 논리값으로 결론
		
	}

}
