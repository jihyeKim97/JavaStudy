package hello;
// ��Ű�� ���� (���� �� ���� ���� ��ġ)
// �� �ҽ� ������ Ŭ���� ���� �� ��Ű���� �Ҽ�
// keyword ,reserved(Ű����, �����)


// Ŭ���� ���� (Class Definition)
public class GreetMain {  //Class ���� ����

	// �Լ��� Ŭ���� �ۿ� ������ �ȵ�
	// �Լ� ���� (Function  Definition) => ���
	// �ݺ����� ����̳� ���� ��ɸ� ���� �Ѵ�
	// main() ���� �Լ� -> ���α׷��� ���۰� ���� �����
	//									�帧���� �Լ�
	//entry point(���� ���� ��)
	public static void main(String[] args) { // ���� �Լ� ���� ���� main() ���α׷� ����
		
		String GREET_MESSAGE = "����"; // ������ ������ �Ҵ�
					// �Ҵ�(���� assign) ������
		System.out.println("mian() ���� ��"); // ���� = Statement ��� ������ �ּ� ����, �ݵ�� �����ݷ����� ����,
		System.out.println("�ȳ��ϼ���"); //����Ű (����Ű) -  ����
		System.out.println(GREET_MESSAGE+"��û��"); //���� ����
		System.out.println(GREET_MESSAGE+"����"); 
		System.out.println(GREET_MESSAGE+ "�鼳����" ); 
		
		GREET_MESSAGE = "����~?"; // ���ο� �����ͷ� �� �Ҵ�
		
		System.out.println(GREET_MESSAGE+"��û��"); //���� ����(�� �Ҵ�� ���ο� ������)
		System.out.println(GREET_MESSAGE+"����");
		System.out.println(GREET_MESSAGE+ "�鼳����" ); 
//		System.out.println(GREET_MESSAGE+"��û��"); //����Ű (����Ű) -  ����(���ڿ� ������ ->  ���)

	} // ���� �Լ� ���� �� mian() ���α׷� ��

} // Class ���� ��
