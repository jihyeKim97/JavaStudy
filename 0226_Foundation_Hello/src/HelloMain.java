public class HelloMain {


	public static void main(String[] args) {
		
		// main �Լ� (function) -- ���α׷� ���� ��ġ
		
		System.out.print("�ȳ��ϼ���");
		System.out.println("Hello java!!!!!!!!!");
		System.out.println("Happy new " + 2021 + " year!!");
		
		// text  - �޸� ������ > ���ڿ� string 
		// ���ͷ� ��ȣ �� ""(���������̼�)�� ��� �Ͽ� ���ڿ��� ǥ��.
		// "�� �����ؼ� "�� ������ ���ڿ����� �Ϸ��� ����
		// "xyz" , "ABCDF" , "12345(����+���ڷ� �̷��� ���ڿ�)" , "���ӽ� �ƴ� ����"
		// 12345 : ���Ǽ���
		System.out.println( "���ӽ� �ƴ� ����");

		String who = "���";
		// data type �⺻��VS����
		// type == String 
		// ����(��) == who
		// �Ҵ�(����)������ == =
		// ���ڿ������� == "���ӽ� �ƴ� ����"
		// ����ǳ� == ;
		int age = 15;
		// ���� Ÿ�� (��ġ�� , ��)
		System.out.println(who +"�̴� "+ age +"�� �̴�"); // ���� ����
		
		 who = "��â��";
		 age = 55;
		 // ���� : ���ϴ� ��
		 // os���� ����� �þƼ� �޸� ������ ������ ���� �޸� ������ �о� �´�
		 System.out.println(who +"�� "+ age +"�� �̴�"); // ���� ����
		 
		
	
	}
}
	
