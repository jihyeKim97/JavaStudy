package greet.mutleple;


public class Step3_Random_SayHelloMain {
	
	public static void main(String[] args) {
		  
		 //���� ȣ���
//		 sayGreetingMsgToName("��ħ ����",  "������");
//		 sayGreetingMsgToName("���� ����",  "��Ƴ�");
//		 sayGreetingMsgToName("���� ����",  "�鼳����");
//		 sayGreetingMsgToName("���� ����",  "�ŵ�����");
	 
		 //������� (����, �������)
		 //�����Լ� �ȿ����� ����Ҽ� �ִ� ������� (���Ҵ� �Ұ�)
		 final String PREFIX = "HAPPY_";
		 final String SAY_A = PREFIX + "���� ��ħ";
		 //	final String SAY_A = PREFIX(���ξ�) + "���� ��ħ"; // ���ξ ���� ���·� ��� �ʱ�ȭ, ����
		 final String SAY_B = PREFIX + "���� ����";
		 final String SAY_C = PREFIX + "���� ����";
		 final String SAY_D = PREFIX + "���� ����";
		 
		 final String TITLE = "����";
		 
		 // ���� ����
		 String queen = "������";
		 
		 // �λ縻 ����
		 
		 // �������� ���� �Ͽ� ���ù�ȣ�� �Է�

		 // double PI = 3.141592;  
		 // int myPi = 3.14; // �Ҽ����� ǥ�� �ϴ� ������ Ÿ�� = error
		 
		 double ran = Math.random(); //�Ҽ����� ǥ�� �Ҽ� �ִ� �Ǽ��� double Ÿ��
		  System.out.println("���� �Ǽ�(�Ҽ���) = "+ ran);
		 // returns a double 
		 // 0.0 ~ 0.xxxxx ~ 0.999xxx����
		 // 0.0 �̻� �׸��� 1.0�̸��� ������ ������ �Ǽ�(�Ҽ��� �ִ�)�� �߻�
		 // double ������ ���� �Ǽ��� ����

		 
		 double ran1 = 0.33225; //�Ҽ����� ǥ�� �Ҽ� �ִ� �Ǽ��� double Ÿ��
		 System.out.println("�Ǽ�(�Ҽ���) = "+ ran1);

		 // ���� �Ǽ� �Ҽ������� ������ ��ȯ
		 int ran2 = (int) ((Math.random()*100)/10); // ������ �������� Ÿ���� �����ϴ� "type casting(Ÿ�� ĳ����)"
		 System.out.println("0~10�߿� 1���� ���� �߻� = "+ ran2); //0~10�߿� 1���� ���� �߻�
		 
		// ���� �Ǽ� �Ҽ������� ������ ��ȯ
		 int ran3 = (int) ((Math.random()*1000)/10); // ������ �������� Ÿ���� �����ϴ� "type casting(Ÿ�� ĳ����)"
		 System.out.println("0~100�߿� 1���� ���� �߻� "+ ran3); //0~100�߿� 1���� ���� �߻�
		 
		 // ���� �Ǽ� �Ҽ������� ������ ��ȯ
		 int ran4 = (int) ((Math.random()*10000)/10); // ������ �������� Ÿ���� �����ϴ� "type casting(Ÿ�� ĳ����)"
		 System.out.println("0~1000�߿� 1���� ���� �߻� = "+ ran4); //0~1000�߿� 1���� ���� �߻�
		 
		
		 int seletion = (int)(ran * 4); // 0, 1, 2, 3 => 0~3
		 System.out.println("seletion= "+ seletion);
		 int seletion1 = (int)(ran * 4) + 1; // 0,1, 2, 3 +1 => 1~4
		 System.out.println("seletion1= "+ seletion1);
		 
		 // �б⹮(if ���Ǻκб⹮)
		 // ���� ���� (1 - 4)(SAY_A - SAY_D)
		 if(seletion1 == 1 ) {
			 sayGreetingMsgToName(SAY_A,  queen+TITLE);			 
		 }else if(seletion1 == 2 ){
			 queen = "��Ƴ�";
			 sayGreetingMsgToName(SAY_B,  queen+TITLE);			 
		 }else if(seletion1 == 3 ) {
			 queen = "�鼳����";
			 sayGreetingMsgToName(SAY_C,  queen+TITLE);			 
		 }else if(seletion1 == 4 ) {
			 queen = "�ŵ�����";
			 sayGreetingMsgToName(SAY_D,  queen+TITLE);			 
		 }else {
			 System.out.println("���� ���� �Դϴ�");
		 }
		 
	}
	
	//�Լ� ���Ǻ�
	private static void sayGreetingMsgToName(String msgGreeting, String toName) {
		
		final String TAB = "\t";
		final String PUNC = "!!";
		final String SEP = "+++++++++++++++++++++++++++";
		final String END = "\r\n";

		System.out.println(msgGreeting + TAB + toName + PUNC);
		System.out.println(SEP);
		System.out.println(END); // ASCII, UNICODE
		
	}
	
}
