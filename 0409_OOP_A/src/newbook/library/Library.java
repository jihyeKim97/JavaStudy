package newbook.library;

import newbook.Book;

public class Library {

	public static void main(String[] args) {
		//Book bk1; // ����		
		//newbook.Book bk1; // ���������̸� (FQN)
		// ��ü�� �ݵ�� Ŭ����(���赵)�� ����
		// new �������Լ�()ȣ��θ� �޸𸮿� ������
		// (�������Լ� == Ŭ������ �����̸��Լ�)
		Book bk1 = new Book(); 
			// new�� ���� Book Ÿ�� ��ü�� ������� ����,
			// JVM �޸𸮰� Ȯ���ǰ�, �� ������ 
			// ������ Book() �Լ��� ���� �ʵ庯�� ���� �ʱ�ȭ��.
			// �������� �� å��ü�� �ּ�(��ġ)�� bk1�� �˷���
			// (���� ������ å ��ü�� ��� �ִ��� ������)
		//System.out.println(bk1); 
			// newbook.Book@33909752
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
*/