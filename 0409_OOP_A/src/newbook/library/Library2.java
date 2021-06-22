package newbook.library;

import newbook.Book;

public class Library2 {

	public static void main(String[] args) {
		Book bk1 = new Book(); 
		bk1.printBook();
		//
		Book bk2 = new Book("�̻��ѳ���ٸ���", "���", 1);
		bk2.printBook();
		//
		Book bk3 = new Book(127, "Ȳ�ݾ��� ���� ������", "���", 1);
		bk3.imgPath = "jaewook/goose.png";
		bk3.ISBN = "0000000000123";
		bk3.comment = Book.NO_COMMENT; // Ŭ���� ����� �ʱ�ȭ.
		bk3.printBook();
		
		Book bk4 = new Book("����������", "����");
		bk4.printBook();
	}

}

/*
������ å: #BK-000000 
����: null
				null ����
	���ǻ�: 0
	Ŀ��ǥ��: null
	ISBN: null
		 ����: 0.00 pt 
		 ����: null 
-----------------------------
������ å: #BK-000000 
����: �̻��ѳ���ٸ���
				��� ����
	���ǻ�: 1
	Ŀ��ǥ��: null
	ISBN: null
		 ����: 0.00 pt 
		 ����: null 
-----------------------------
������ å: #BK-000127 
����: Ȳ�ݾ��� ���� ������
				��� ����
	���ǻ�: 1
	Ŀ��ǥ��: jaewook/goose.png
	ISBN: 0000000000123
		 ����: 0.00 pt 
		 ����: ��۾��� 
-----------------------------
������ å: #BK-000000 
����: ����������
				���� ����
	���ǻ�: 0
	Ŀ��ǥ��: default/dummy.png
	ISBN: 9876543210123
		 ����: 0.00 pt 
		 ����: ��۾��� 
-----------------------------

*/