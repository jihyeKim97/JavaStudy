package greet.mutleple;


//class A {}
//class B {}
//src���� ���Ͽ��� sayHelloMain.java
//bin���� ���Ͽ���  sayHelloMain.class / a.class / b.class

public class Step1_Justice_SayHelloMain {
	
	public static void main(String[] args) {
//�Լ�ȭ �ܰ�

// 1�ܰ� �Լ�ȭ
		System.out.println("======�Լ�ȭ 1�ܰ�======");
		System.out.println("��ħ ����" + "\t" + "������" + "!!");
		System.out.println("+++++++++++++++++++++++++++");
		System.out.println("\n"); // ASCII, UNICODE
		
		System.out.println("���� ����" + "\t" + "��Ƴ�" + "!!");
		System.out.println("+++++++++++++++++++++++++++");
		System.out.println("\n"); // ASCII, UNICODE
		
		System.out.println("���� ����" + "\t" + "�鼳����" + "!!");
		System.out.println("+++++++++++++++++++++++++++");
		System.out.println("\n"); // ASCII, UNICODE
		
		System.out.println("���� ����" + "\t" + "�ŵ�����" + "!!");
		System.out.println("+++++++++++++++++++++++++++");
		System.out.println("\n"); // ASCII, UNICODE
		
		
		
		
		System.out.println("======�Լ�ȭ 2�ܰ�======");
//2�ܰ� ���ȭ (������� ������ �ʴ� ���� ������)
		 final String TAB = "\t";
		 final String PUNC = "!!";
		 final String SEP = "+++++++++++++++++++++++++++";
		 final String END = "\r\n";
		
		 System.out.println("��ħ ����" + TAB + "������" + PUNC);
		 System.out.println(SEP);
		 System.out.println(END); // ASCII, UNICODE
		 
		 System.out.println("���� ����" + TAB + "��Ƴ�" + PUNC);
		 System.out.println(SEP);
		 System.out.println(END); // ASCII, UNICODE
		 
		 System.out.println("���� ����" + TAB + "�鼳����" + PUNC);
		 System.out.println(SEP);
		 System.out.println(END); // ASCII, UNICODE
		 
		 System.out.println("���� ����" + TAB + "�ŵ�����" + PUNC);
		 System.out.println(SEP);
		 System.out.println(END); // ASCII, UNICODE

		 
		 
		 
		 System.out.println("======�Լ�ȭ 3�ܰ�======");
 //3�ܰ� ����ȭ ���� (������� �Ź� ����� ���� �Է����� ������ ���ϴ� ������)
		 String msgGreeting;
		 String toName;
		 
		msgGreeting = "��ħ ����";
		toName = "������";		 
		 System.out.println(msgGreeting + TAB + toName + PUNC);
		 System.out.println(SEP);
		 System.out.println(END); // ASCII, UNICODE
		 
		 msgGreeting = "���� ����";
		 toName = "��Ƴ�";		 
		 System.out.println(msgGreeting + TAB + toName + PUNC);
		 System.out.println(SEP);
		 System.out.println(END); // ASCII, UNICODE
		 
		 msgGreeting = "���� ����";
		 toName = "�鼳����";		 
		 System.out.println(msgGreeting + TAB + toName + PUNC);
		 System.out.println(SEP);
		 System.out.println(END); // ASCII, UNICODE
		 
		 msgGreeting = "���� ����";
		 toName = "�ŵ�����";		 
		 System.out.println(msgGreeting + TAB + toName + PUNC);
		 System.out.println(SEP);
		 System.out.println(END); // ASCII, UNICODE
		 
 //4�ܰ� �Լ�ȭ (����κ��� ����ص��� �ϳ��� ���� ������� ��� ����
		 //					+ ���ǵ� �Լ��� �� �̸����� ���� �ʿ� �ø��� ȣ��)
		 System.out.println("======�Լ�ȭ 4�ܰ�======");
		 sayGreetingMsgToName("��ħ ����",  "������");
		 sayGreetingMsgToName("���� ����",  "��Ƴ�");
		 sayGreetingMsgToName("���� ����",  "�鼳����");
		 sayGreetingMsgToName("���� ����",  "�ŵ�����");
		 
		 
		
	}
	// Ŭ���� �ȿ��� ���������� ��밡���� �Լ� = private
	// Ŭ���� �ۿ��� �����й��ϰ� ��밡���� �Լ� = public
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
