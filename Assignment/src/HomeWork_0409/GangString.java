package HomeWork_0409;

import java.util.Arrays;
import java.util.Scanner;

// Scanner 사용하여 가변 문자열 문장 입력해도 좋아요. (nextLine())
//			a의 첫위치 => 13번 등장
//			b의 첫위치 => 없음(-1)
//			c의 첫위치 => 40번 등장
//			d의 첫위치 => 33번 등장
//			. . .
//			y의 첫위치 => 123번 등장
//			z의 첫위치 => 213번 등장
public class GangString {

	public static void main(String[] args) {
		// The Coterel gang
		// The Coterel gang was an armed group in the English North Midlands that roamed
		// across the countryside in the late 1320s and early 1330s, a period of
		// political upheaval and lawlessness. Despite repeated attempts by the crown to
		// suppress James Coterel and his band, they committed murder, extortion and
		// kidnapping across the Peak District.

		Scanner sc = new Scanner(System.in);
		System.out.print("문자 입력 : ");
		String inputVal = sc.nextLine();
		int valueArr[] = new int[inputVal.length()];

		/*------------------1번 문제------------------*/
//		for (int i = inputVal.length() - 1; i >= 0; i--) {
//			valueArr[i] = inputVal.charAt(i);
//			if ((int) valueArr[i] == 32) {
//				System.out.println("Space Bar 감지");
//			} else {
//				System.out.println("'" + valueArr[i] + "'" + "(" + (int) valueArr[i] + ")   ");
//			}
//		}
		/*------------------2번 문제------------------*/

//		for (int i = inputVal.length()-1; i>=0; i--){
//			valueArr[i] = inputVal.charAt(i);
//			if( valueArr[i]== 32) {
//				System.out.println("없음(-1)");
//			}else {
//				System.out.println((char)valueArr[i]+"("+valueArr[i]+")");
//			}
//        }

		/*------------------3번 문제------------------*/

		for (int i = 0; i < valueArr.length; i++) {
			valueArr[i] = inputVal.charAt(i);
		}
		System.out.println();
		for (int i = 97; i <=122; i++) {
			for (int j = 0; j < valueArr.length; j++) {
				if(i == valueArr[j]) {
					System.out.println((char) valueArr[j]+" : "+(j+1)+"번째");
				}
			}
		}
	}
}
