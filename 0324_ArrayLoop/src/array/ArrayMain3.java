package array;

public class ArrayMain3 { // 배열차원존재, 차원은 기준축이 존재 하며 인덱스축으로 순서번호 변화됨

	public static void main(String[] args) {

		// 1차원 i축 선상에 요소 나열
		// 행렬 matrix,백터 vector , 행 row , 열 column
		int arr1D[] = { 2, 4, 6, 8, 10 }; // 1D empty array

		// 2차원배열 = 배열의배열 -> 1차원배열을 그 요소로 가지는 배열이 2차원 배열
		int arr2D[][] = { { 1, 2, 3 }, { 4, 5, 6, -1, 0, }, { 7, -2, 8, 9 }, { 155 } }; // 행 번호 범위(0~2) // 열 번호 범위 (0~2)  // 3X3배열

		System.out.println("arr2D의 첫번째 요소 => " + arr2D[0][0]);
		System.out.println("arr2D의 마지막 요소 => " + arr2D[2][2]);
		System.out.println();

		for (int row = 0; row < arr2D.length; row++) { // row loop
			int colLen = arr2D[row].length;
			for (int column = 0; column < colLen; column++) { // row 행 마다 별도의 column loop 실행
				System.out.print("(" + row + ", " + column + ") ====> " + arr2D[row][column] + " \t");
			}
			System.out.println();
		}

	}

}
