package oop;

//public class InheritMain extends Object { // ����
public class InheritMain {

	public static void main(String[] args) {
		// ���: inherit (�θ�Ŭ������ �ڿ�-�ʵ�/�޼ҵ��� �����޾� ����)
		// 		Object�� �ֻ��� �ڹ� Ŭ�����ν� �Ͻ������� ����� 
		//		��� Ŭ������ ������
		//		=> Object�� �� ���� �Ϲ�ȭ, ���� ��¡ȭ�� �ֻ��� �з�.
		//		- ��ü���... �������ϴ� �ּ��� �Ϲ� ����� ���� ���� Object��.
		//		1. ��ü �ڽ��� ������ ǥ���� �� �ִ�. toString() 
		//		2. ��ü�鰣�� ��/�Ǵ��� ���� �� �� �ִ�. equals() 
		//      3. ��ü�� ������ȣ�� ���� �� �ִ�. hashCode()
		InheritMain in = new InheritMain();
//		System.out.println(in); // toString()
		System.out.println(in.toString());
		System.out.println(in.hashCode());
		InheritMain in2 = new InheritMain();
		System.out.println(in2.toString());
		System.out.println(in2.hashCode());
		
//		if( in == in2 ) 
//			System.out.println("�츮�� ���� ���ƿ�!!");
//		else // in != in2
//			System.out.println("�츮�� ���� �޶��..");
		System.out.println("���� ����? " + (in == in2));
		System.out.println("���� �ٸ���? " + (in != in2));
//		System.out.println("���� �ٸ���? " + ((in == in2)==false));
		if( in.equals(in2) == true )
			System.out.println("�츮�� �ѹ���!");
		else
			System.out.println("�츮�� �ٹ���!!!");
		//
//		Object obj = new Object(); // Ÿ��?
//		obj.toString();
		
		Object ob1 = in; // ��� ������
		Object ob2 = in2;
		Object ob3 = "abcd";
		Object ob4 = 3.14;
		Object ob5 = 'A'; 
		// Object Ÿ�� �������� �ڹ��� ��� �����͸� ���� �� ����.
		// � Ÿ���� �����͵��� Object���� �����.
		
		
	}

}
