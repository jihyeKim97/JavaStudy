package book2;

public class MyLibrary3 {

	public static void main(String[] args) {
//		MyBook book = null; // ���ο� Ÿ�� MyBook Ŭ������ ���� book ����.
//		System.out.println(book.toString());
		MyBook book = new MyBook(); 
			// Ŭ������ ������ �̸��� �Լ�(�������Լ� constructor)��
			// �ݵ��  new�� �Բ� �� ���� �����ؼ� ��ü�� ������ ��. 
			// ������� ��ü�� book ������ ����.
		// ��ü�� Ŭ������ ���·� ��������� .. �ϳ��� ������ ��.
		// ��, ��ü ���� �Լ���, ������, �������  ��ü��.OOO�� �������ٰ���.
		book.bookTitle = "�ڹٰ� ���� ������!"; 
		book.bookAuthor = "���ӽ� ����";
		book.bookGenre = "IT ����";
		book.bookPages = 500;// pp
		book.bookPrice = 30000; //��
		
		MyBook book2 = new MyBook();// ��ü�� �¾�� �ϱ� ����...
			// JVM�� �޸𸮸� Ȯ���ϰ�, ���� �����͸� �ʱ�ȭ�Ͽ� 
			// book2������ ��ü�� ����Ŵ
		book2.bookAuthor = "��� ��� ����޸�";		
		book2.bookTitle = "���� �Ӹ� ��";
		book2.bookGenre = "�Ҽ�/����";
		book2.bookPrice = 16800;
		book2.bookPages = 532;		
		
		//book.printBook();
		book2.printBook();
		book.printBook();
		
		MyBook book3 = new MyBook(); // ��ü ����
		book3.init(); // ��ü �ʱ�ȭ
		book3.printBook(); // ��ü ���
		
		MyBook book4 = new MyBook(); // ��ü ����
		book4.init(); // ��ü �ʱ�ȭ
		book4.printBook(); // ��ü ���
		
	}

}

/*
BOOK 0
����: ���� �Ӹ� ��
�о�: �Ҽ�/����
����(������): 16800won
����: '��� ��� ����޸�'��
�ʼ�: 532pp
���ǻ� ��ȣ: 0
ISBN: null
����: 0.0
�����ڸ�Ʈ: null
-----------------------------
BOOK 0
����: �ڹٰ� ���� ������!
�о�: IT ����
����(������): 30000won
����: '���ӽ� ����'��
�ʼ�: 500pp
���ǻ� ��ȣ: 0
ISBN: null
����: 0.0
�����ڸ�Ʈ: null
-----------------------------
BOOK 0
����: null
�о�: null
����(������): 0won
����: 'null'��
�ʼ�: 0pp
���ǻ� ��ȣ: 0
ISBN: null
����: 0.0
�����ڸ�Ʈ: null
-----------------------------



==>



BOOK 1
	 ����: �ڹٰ� ���� ������!
	 �о�: �Ҽ�
	 ����(������): 2900won
	 ����: '���ӽ� ����'��
	 �ʼ�: 500pp
	 ���ǻ� ��ȣ: 5
	 ISBN: 9876543210111
	 ����: 4.12
	 �����ڸ�Ʈ: ���� �ʾҾ��... 
-----------------------------




*/