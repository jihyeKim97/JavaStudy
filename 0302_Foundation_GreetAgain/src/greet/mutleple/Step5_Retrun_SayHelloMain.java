package greet.mutleple;


public class Step5_Retrun_SayHelloMain {
	
	public static void main(String[] args) {
		
		/*�Լ� ȣ���*/
		
		int seletion = (int)(Math.random() * 4)+1;  //1~4
		System.out.println("1~4������ ���� ���ڴ� = "+seletion+"\t"+ pickAndReturnMessage(seletion));
	
		System.out.println( pickAndRetrunMessageRandemly());
		
	}
	
	
/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/	
	
	/*�Լ� ���Ǻ�*/	
	
	//�Լ� �ȿ��� �������� ���ڸ� �����Ͽ� �׿� �´� �ؽ�Ʈ�� ���� �Լ�
	private static String pickAndRetrunMessageRandemly() {
		
		int seletion = (int)(Math.random() * 4)+1;  //1~4
		//	System.out.println("seletion = "+ seletion);
		
		final String PREFIX = "HAPPY_";
		final String SAY_A = PREFIX + "���� ��ħ";
		final String SAY_B = PREFIX + "���� ����";
		final String SAY_C = PREFIX + "���� ����";
		final String SAY_D = PREFIX + "���� ����";
		
		if(seletion == 1 ) { return SAY_A; }
		else if(seletion == 2 ) { return SAY_B; }
		else if(seletion == 3 ) { return SAY_C; }
		else if(seletion == 4 ) { return SAY_D; }
		else { return "none"; }
		
	}
	
	
	// ���ڿ��� ��ȯ�ϴ� ���� �Լ� (String)	
	//���ϰ� = ���ڿ��� ��ȯ
	// �Լ� ����(ȣ��) ����� ���ڿ� ������ ���� 
	private static String  pickAndReturnMessage(int seletion) {
		
		final String PREFIX = "HAPPY_";
		final String SAY_A = PREFIX + "���� ��ħ";
		final String SAY_B = PREFIX + "���� ����";
		final String SAY_C = PREFIX + "���� ����";
		final String SAY_D = PREFIX + "���� ����";
		
		String retMsg = "";
		if(seletion == 1 ) { retMsg = SAY_A; }
		if(seletion == 2 ) { retMsg = SAY_B; }
		if(seletion == 3 ) { retMsg = SAY_C; }
		if(seletion == 4 ) { retMsg = SAY_D; } 
		
		return retMsg; // �Լ��� return�� ������ �ٷ� ����
		
	}
	
	
	
	//�Լ� �ȿ��� �������� ���ڸ� �����Ͽ� �׿� �´� �ؽ�Ʈ�� ���� �Լ�
	private static void pickAndShowMessageRandemly() {
		
		int seletion = (int)(Math.random() * 4)+1;  //1~4
		System.out.println("seletion = "+ seletion);
	
		final String PREFIX = "HAPPY_";
		final String SAY_A = PREFIX + "���� ��ħ";
		final String SAY_B = PREFIX + "���� ����";
		final String SAY_C = PREFIX + "���� ����";
		final String SAY_D = PREFIX + "���� ����";
		final String TITLE = "����";
		String queen = "������";
		
		
		if(seletion == 1 ) {
			sayGreetingMsgToName(SAY_A,  queen+TITLE);			 
		}else if(seletion == 2 ){
			queen = "��Ƴ�";
			sayGreetingMsgToName(SAY_B,  queen+TITLE);			 
		}else if(seletion == 3 ) {
			queen = "�鼳����";
			sayGreetingMsgToName(SAY_C,  queen+TITLE);			 
		}else if(seletion == 4 ) {
			queen = "�ŵ�����";
			sayGreetingMsgToName(SAY_D,  queen+TITLE);			 
		}else {
			System.out.println("���� ���� �Դϴ�");
		}
		
	}
	
	
	
	// �Լ��� ���ϴ� ���ڸ� �־� ���� �Լ�
	private static void pickAndShowMessage(int seletion) {
		
		final String PREFIX = "HAPPY_";
		final String SAY_A = PREFIX + "���� ��ħ";
		final String SAY_B = PREFIX + "���� ����";
		final String SAY_C = PREFIX + "���� ����";
		final String SAY_D = PREFIX + "���� ����";
		final String TITLE = "����";
		String queen = "������";
		
		if(seletion == 1 ) {
			sayGreetingMsgToName(SAY_A,  queen+TITLE);			 
		}else if(seletion == 2 ){
			queen = "��Ƴ�";
			sayGreetingMsgToName(SAY_B,  queen+TITLE);			 
		}else if(seletion == 3 ) {
			queen = "�鼳����";
			sayGreetingMsgToName(SAY_C,  queen+TITLE);			 
		}else if(seletion == 4 ) {
			queen = "�ŵ�����";
			sayGreetingMsgToName(SAY_D,  queen+TITLE);			 
		}else {
			System.out.println("���� ���� �Դϴ�");
		}
		
	}
	
	
	
	//���Ŀ� �´� �Լ��� ���� �Լ�
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
