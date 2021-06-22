package wrap;

//�������� �������� ��ȣ�ϰ� �ܺο��� ����� ó������ ����
//�ڹ��� �⺻�� 8������ ������������ ��� �ڽŸ��� ���� Ŭ������ ����
//�⺻�� primitives 8������ ���� Ŭ������ ����
//	�ڹ� �⺻�� 	--------------	���� Ŭ������
//		byte 			-------------- 		Byte
//		short 		-------------- 		Short
//		int				-------------- 		Integer (int �ƴ�)
//		ong 			-------------- 		Long
//		float 			-------------- 		Float
//		double		-------------- 		Double
//		boolean 	-------------- 		Boolean
//		character 	-------------- 		Character
public class BasicWrapper {

	public static void main(String[] args) {
		int a = 2; // �⺻�� ������ 4byte
		Integer b = 2; // ����Ŭ���� ���� ��ü(�ּ�) ūbyte ->> �޼ҵ尡 ���� �ϸ� �ϳ��� ��ü��

		/* 4byte���� 5���� ������ ���� ���� �迭 */ int num[] = { 1, 2, 3, 4, 5 };
		/* ���� ��ü ��� 3���� ���� �迭 */ Integer num2[] = { 10, 20, 30 };
		System.out.println("------------byte-------------");
		System.out.println("byte size (��Ʈ��)= " + Byte.SIZE);
		System.out.println("byte bytes (��Ʈ��)= " + Byte.BYTES);
		System.out.println("byte min (�ּ�)= " + Byte.MIN_VALUE);
		System.out.println("byte max (�ִ�)= " + Byte.MAX_VALUE);
		System.out.println();

		System.out.println("------------short-------------");
		System.out.println("short size (��Ʈ��)= " + Short.SIZE);
		System.out.println("short bytes (��Ʈ��)= " + Short.BYTES);
		System.out.println("short min (�ּ�)= " + Short.MIN_VALUE);
		System.out.println("short max (�ִ�)= " + Short.MAX_VALUE);
		System.out.println();

		System.out.println("------------int-------------");
		System.out.println("int size (��Ʈ��)= " + Integer.SIZE);
		System.out.println("int ints (��Ʈ��)= " + Integer.BYTES);
		System.out.println("int min (�ּ�)= " + Integer.MIN_VALUE);
		System.out.println("int max (�ִ�)= " + Integer.MAX_VALUE);
		System.out.println();

		System.out.println("------------long-------------");
		System.out.println("long size (��Ʈ��)= " + Long.SIZE);
		System.out.println("long bytes (��Ʈ��)= " + Long.BYTES);
		System.out.println("long min (�ּ�)= " + Long.MIN_VALUE);
		System.out.println("long max (�ִ�)= " + Long.MAX_VALUE);
		System.out.println();

		System.out.println("------------float-------------");
		System.out.println("float size (��Ʈ��)= " + Float.SIZE);
		System.out.println("float bytes (��Ʈ��)= " + Float.BYTES);
		System.out.println("float min (�ּ�)= " + Float.MIN_VALUE);
		System.out.println("float max (�ִ�)= " + Float.MAX_VALUE);
		System.out.println("float not a number = " + Float.NaN);
		System.out.println();

		System.out.println("------------double-------------");
		System.out.println("double size (��Ʈ��)= " + Double.SIZE);
		System.out.println("double bytes (��Ʈ��)= " + Double.BYTES);
		System.out.println("double min (�ּ�)= " + Double.MIN_VALUE);
		System.out.println("double max (�ִ�)= " + Double.MAX_VALUE);
		System.out.println("double not a number = " + Double.NaN);

		System.out.println("------------char-------------");
		System.out.println("char size (��Ʈ��)= " + Character.SIZE);
		System.out.println("char bytes (��Ʈ��)= " + Character.BYTES);
		System.out.println("char min (�ּ�)= " + (int) Character.MIN_VALUE);
		System.out.println("char max (�ִ�)= " + (int) Character.MAX_VALUE);
		
		System.out.println("------------boolean-------------");
		System.out.println("boolean ������ ��= " + Boolean.TRUE);
		System.out.println("boolean ������ ����= " + Boolean.FALSE);
		
		

	}

}
