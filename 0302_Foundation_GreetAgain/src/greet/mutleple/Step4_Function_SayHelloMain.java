package greet.mutleple;


public class Step4_Function_SayHelloMain {
	
	public static void main(String[] args) {
		
		int seletion = (int)(Math.random() * 4)+1;  //1~4
		
		//	pickAndShowMessage(seletion);
		pickAndShowMessageRandemly();
		pickAndShowMessageRandemly();
		pickAndShowMessageRandemly();
		pickAndShowMessageRandemly();
		pickAndShowMessageRandemly();
	 
	}
	
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
