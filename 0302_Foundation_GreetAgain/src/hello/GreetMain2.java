package hello;

public class GreetMain2 {

	public static void main(String[] args) {
//		String GREET_MSG1 = ""; // �� ���ڿ� 
		String GREET_MSG1 = "�ȳ�??";  // ���� ����� ���ÿ� ������ �Ҵ� => �ʱ�ȭ
		
		// �ڹٿ��� ��������� ������ �Ҵ� �ش޶�� ��û
		String GREET_MSG2; 
		//���� ����(������� �غ��϶�� �˷���)
		GREET_MSG2 = "�ȳ� �ϼ���"; //����� �и��Ǿ� �ΰ��� �������� �ʱ�ȭ
		
		String person1 = "����";
		String person2 = "�ȳ�";
		System.out.println(GREET_MSG1 + " " + person1);
		
		person1 = person1 + "~!!!"; // ���� person1�� ���Ҵ��� �Ǿ� "����~!!!" (������ ���Ӱ� ���Ҵ�(����))
		// = �Ҵ� ��ȣ �������� person1 ������ ���� ���� ���� "����" �����͸� ���� ���� ��
		person2 = "princess!" + person2;
		System.out.println(GREET_MSG1 + " " + person1);
		System.out.println(GREET_MSG1 + " " + person2);

		person2 = person2 + "����";
		System.out.println(GREET_MSG1 + " " + person2);
		// person1 = person1;
		// �Ҵ� ��ȣ�� ������ �����ʿ� �ִ� ������ ���ʿ� ���� �ȴ�
		// System.out.println(GREET_MSG1 + " " + "ȫȫȫ");
		
		
	}

}
