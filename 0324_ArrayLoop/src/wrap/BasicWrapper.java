package wrap;

//오리지날 콘텐츠를 보호하고 외부와의 입출력 처리들을 대행
//자바의 기본형 8가지의 데이터형들을 모두 자신만의 랩퍼 클래스를 가짐
//기본형 primitives 8가지의 랩퍼 클래스가 존재
//	자바 기본형 	--------------	랩퍼 클래스형
//		byte 			-------------- 		Byte
//		short 		-------------- 		Short
//		int				-------------- 		Integer (int 아님)
//		ong 			-------------- 		Long
//		float 			-------------- 		Float
//		double		-------------- 		Double
//		boolean 	-------------- 		Boolean
//		character 	-------------- 		Character
public class BasicWrapper {

	public static void main(String[] args) {
		int a = 2; // 기본형 정수값 4byte
		Integer b = 2; // 랩퍼클래스 정수 객체(주소) 큰byte ->> 메소드가 존재 하며 하나의 객체임

		/* 4byte정수 5개를 나열해 묶은 정수 배열 */ int num[] = { 1, 2, 3, 4, 5 };
		/* 정수 객체 요소 3개를 묶은 배열 */ Integer num2[] = { 10, 20, 30 };
		System.out.println("------------byte-------------");
		System.out.println("byte size (비트수)= " + Byte.SIZE);
		System.out.println("byte bytes (비트수)= " + Byte.BYTES);
		System.out.println("byte min (최소)= " + Byte.MIN_VALUE);
		System.out.println("byte max (최대)= " + Byte.MAX_VALUE);
		System.out.println();

		System.out.println("------------short-------------");
		System.out.println("short size (비트수)= " + Short.SIZE);
		System.out.println("short bytes (비트수)= " + Short.BYTES);
		System.out.println("short min (최소)= " + Short.MIN_VALUE);
		System.out.println("short max (최대)= " + Short.MAX_VALUE);
		System.out.println();

		System.out.println("------------int-------------");
		System.out.println("int size (비트수)= " + Integer.SIZE);
		System.out.println("int ints (비트수)= " + Integer.BYTES);
		System.out.println("int min (최소)= " + Integer.MIN_VALUE);
		System.out.println("int max (최대)= " + Integer.MAX_VALUE);
		System.out.println();

		System.out.println("------------long-------------");
		System.out.println("long size (비트수)= " + Long.SIZE);
		System.out.println("long bytes (비트수)= " + Long.BYTES);
		System.out.println("long min (최소)= " + Long.MIN_VALUE);
		System.out.println("long max (최대)= " + Long.MAX_VALUE);
		System.out.println();

		System.out.println("------------float-------------");
		System.out.println("float size (비트수)= " + Float.SIZE);
		System.out.println("float bytes (비트수)= " + Float.BYTES);
		System.out.println("float min (최소)= " + Float.MIN_VALUE);
		System.out.println("float max (최대)= " + Float.MAX_VALUE);
		System.out.println("float not a number = " + Float.NaN);
		System.out.println();

		System.out.println("------------double-------------");
		System.out.println("double size (비트수)= " + Double.SIZE);
		System.out.println("double bytes (비트수)= " + Double.BYTES);
		System.out.println("double min (최소)= " + Double.MIN_VALUE);
		System.out.println("double max (최대)= " + Double.MAX_VALUE);
		System.out.println("double not a number = " + Double.NaN);

		System.out.println("------------char-------------");
		System.out.println("char size (비트수)= " + Character.SIZE);
		System.out.println("char bytes (비트수)= " + Character.BYTES);
		System.out.println("char min (최소)= " + (int) Character.MIN_VALUE);
		System.out.println("char max (최대)= " + (int) Character.MAX_VALUE);
		
		System.out.println("------------boolean-------------");
		System.out.println("boolean 논리적인 참= " + Boolean.TRUE);
		System.out.println("boolean 논리적인 거짓= " + Boolean.FALSE);
		
		

	}

}
