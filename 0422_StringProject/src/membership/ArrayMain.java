package membership;

public class ArrayMain {

	public static void main(String[] args) {
		int a[] = { 3, 4, 5};
		
		try {
//			System.out.println(a[2]);
			System.out.println(a[5]);
		} catch(ArrayIndexOutOfBoundsException e) {
//			e.printStackTrace();
//java.lang.ArrayIndexOutOfBoundsException: 5
//			at membership.ArrayMain.main(ArrayMain.java:10)
			
			System.out.println("배열의 범위를 벗어남!!");			
		}

	}

}
