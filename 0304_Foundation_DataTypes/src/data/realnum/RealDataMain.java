package data.realnum;

public class RealDataMain {

	public static void main(String[] args) {
		// �ڹ��� ��ġ�� ������ ǥ��(��������, ��)
		// ����(byte,short,int,long) Ȥ�� �Ǽ�(float,double)
			//float == 4����Ʈ
			//�Ǽ����� ��ġ���� ũ�� �� ���� ���� x
			// real number �� �Ǽ�, �Ҽ��� ==> precision (���е�) ������ �ٷ�
			// 0(4����Ʈ), 0L(8����Ʈ) , 0l(8����Ʈ), 0,0F(4����Ʈ), 0.0f(4����Ʈ)
			// f,F ��ġ�� ���� ���̸� 4����Ʈ �Ǽ��� float�� �����ͷ� ��ȯ
		
		// ����ǥ�� : �ڹ��� �⺻�� ������ int�� ���(4����Ʈ int) 123,		100,		5,		0
		// �Ǽ�(�Ҽ���)ǥ�� : �ڹ��� �⺻ double�� ����(8����ũ double),0.0		0.2	1.0	3.141592
		
		
		
		double num1 = 3.141592;
		double num2 = 3.141592653589793;
		double num3 = 3.1415926536897932384626433832795028841971;
		double PI = Math.PI;
		
		System.out.println("PI = "+PI); // ���ֿ� ������ ���� �� ���̿� ���� ����� double ���Դϴ�.
		System.out.println("num1 = "+ num1);
		System.out.println("num2 = "+num2);
		System.out.println("num3 = "+num3);
		
		
		float num4 = 3.14f;
		float num5 = 3.141592653589793f;
		float num6 = 3.1415926536897932384626433832795028841971f;
		
		System.out.println("num4 = "+num4); 
		System.out.println("num5 = "+num5); 
		System.out.println("num6 = "+num6); 
		
		float num7 = (float)num3;
		System.out.println("num7(������ĳ����) = "+num7);
		
		
	}

}
