package book2;

// Ŭ���� class ���� == java���� Ŭ������ '���ο� Ÿ��'�� ����� ��.
// 		���赵...? 
//     ��ü�������� ���󿡼�... (�� ������ ��ü������ ���������� 3����)  
// ��ü object��� ���� Ŭ������ ������ ��ü���� ���� ������� ����.
// 'å'�̶�� ����(��Ű�� Schema)�� Ŭ������ ǥ��..
//  �ش� ��Ű���� Ư¡���� Ŭ������ ������� ��ƾ� ��. 
//  å�� ���ø���... ����, �о�(�帣), ����, ���ǻ�, �ʼ�, ���� (���ڵ�), ǥ��..
// Ŭ������ �̷� Ư¡�� ���� ������� ǥ������ �ʰ�, �� �������� �ϳ��� Ŭ���� ���� ����.
// ���⿡ ��Ű���� ó���� ����� ��ɵ��� �Լ��ν� �ش� Ŭ���� �����ؼ� ������.
// ��, Ŭ������ ���� ������ �������(�ʵ�,�Ӽ�property) + ���� ��� (�Լ�;�޼ҵ�)��� ǥ����. 
// class = fields + methods
// ���� �������, ��� �������, �Լ� �������(�޼ҵ�)
// Ŭ������ ���ο� Ÿ���� ���� "������ + ���"�� �ϳ��� ���� ���� ����. (blueprint)
// java������ Ư�� Ŭ������ ��ü�� �ڹ� JVM�޸� ���� �¾�� �ϱ� ���� 
// �ݵ�� new�� ������ ��ġ��... new �������μ���Ǹ� ��ü�� Ȱ����.

// book2.MyBook Ÿ�� ����   !=  book.MyBook �ٸ�..

// å��Ű�� ǥ�� (���赵)
public class MyBook_backup4 {	
	// ������ ǥ�� (�ʵ�) ------------
	// (����) ��� �ʵ�
	public static final int DEF_PRICE = 2900; 
	public static final String DEF_GENRE = "�Ҽ�";
	public static final String DEF_TITLE = "�������";// null���� ����..
	public static final String DEF_AUTHOR = "���ھ���";
	public static final int DEF_PUB = 0;
	public static final String DEF_ISBN = "0000000000123";
	public static final String NO_COMMENT = "��۾���";
	
	// ���� �ʵ� (�������) // v1.0
	// public ���� �����ϸ� ��Ű���� �ٸ� Ŭ�����鿡���� ��밡����.
	public int no; // ��ȣ numeric order
	//int no; // ��ȣ numeric order
	public String bookTitle; // ����
	public String bookGenre; // �о�(�帣)
	public String bookAuthor; // ����(�̸�)
	public int bookPages; // �ʼ� (pp)
	public int bookPrice; // ���� (��)
	// ��Ű�� �����... // v1.1
	public int publisher; // ���ǻ� (��ȣ)
	public String ISBN; // ���ڵ�/����ǥ�ؼ�����ȣ(�ε��� 13�ڸ�..)
	public float rate; // ���� 5������ ô�� 0.0 ~ 5.0
	public String comment; // �ڸ�Ʈ
	
	
	// ������ �Լ� ���� (Ŭ������ �̸��� �����ϸ鼭 �ݵ�� new�� ȣ��Ǵ� �Լ���, 
	//      ������ �޸��� ��ü�� �ʵ�� ���� �ʱ�ȭ�ϴ� ����)
	//   Ŭ������ Ư�� ��ü�� ������ �� ���� �� �ѹ��� ȣ���.
	// ������ �Լ��� �������� ����.. ������..!! 
	// ������ �Լ��� �ݵ�� ���� ��  �ʱ�ȭ�� ��ģ ��ü�� �ּҸ� ���������� ������. 
//	public MyBook() { 
//		// ���� ������ �Լ� (dummy) - �⺻ ������
//		// 
//		// Ŭ������ new�� ������� ������ ��ü�� �� �ʵ����� �⺻������ �ڵ��ʱ�ȭ ��.
//		// ������ 0, long 0L, �Ǽ��� 0.0, float 0.0f, ������ '\0', 
//		// ���� false, ���۷�����(Ŭ������, �迭��...) null �� �ʱ�ȭ.
//	}
	
	public MyBook_backup4() { // �⺻ ������.. default, basic, dummy
		bookTitle = DEF_TITLE; 
		bookAuthor = DEF_AUTHOR;
		bookGenre = DEF_GENRE; //"IT ����";		
		bookPrice = DEF_PRICE; //��		
		publisher = DEF_PUB;		
		ISBN = DEF_ISBN;
		comment = NO_COMMENT;
		bookPages = 0;// pp
		no = 0;
		rate = 0.0f;
		
		// ������ �����ϳ� ��������..
//		bookPages = 0;// pp
//		no = 0;
//		rate = 0.0f;
	}
	
	// ������ �Լ� �����ε� - ��� �ʵ� (Full) Ǯ������
	public MyBook_backup4(String newTitle, String newAuthor, 
			String newGenre, int newPages, int newPrice, 
			int newNo, int newPublisher, float newRate, 
			String newISBN, String newComment) {
		bookTitle = newTitle; 
		bookAuthor = newAuthor;
		bookGenre = newGenre; //"IT ����";
		bookPages = newPages;// pp
		bookPrice = newPrice; //��
		no = newNo;
		publisher = newPublisher;
		rate = newRate;
		ISBN = newISBN;
		comment = newComment;
	}
	
	
	
	// ��� ǥ�� (�޼ҵ�; ����Լ�)
//	public void printBook() {
//		//String bookTitle;
//		System.out.println("BOOK");
//		System.out.println("\t ����: " + bookTitle);
//		System.out.println("\t �о�: " + bookGenre);
//		System.out.println("\t ����(������): " + bookPrice +"won");
//		System.out.println("\t ����: '" + bookAuthor + "'��");
//		System.out.println("\t �ʼ�: " + bookPages + "pp");
//		System.out.println("-----------------------------");
//	}
	
	// ��ü�� �� �ʵ带 �⺻ �ʱ�ȭ�ϴ� �Լ� (��ü �ʱ�ȭ initialization �Լ�)
	public void init() {
		bookTitle = "�ڹٰ� ���� ������!"; 
		bookAuthor = "���ӽ� ����";
		bookGenre = DEF_GENRE; //"IT ����";
		bookPages = 500;// pp
		bookPrice = DEF_PRICE; //��
		no = 1;
		publisher = 5;
		rate = 4.12f;
		ISBN = "9876543210111";
		comment = "���� �ʾҾ��... ";
	}
	
	// �ʵ� �Է��� ��� �޾Ƽ� ��ü�� �ʱ�ȭ�ϴ� �Լ� 
	// �Լ� �����ε�(Overloading ������ -- �Լ� ȣ��� ������ ������ Ÿ������
	// �ش� �Լ� ���Ǹ� ����)
	public void init(String newTitle, String newAuthor, 
			String newGenre, int newPages, int newPrice, 
			int newNo, int newPublisher, float newRate, 
			String newISBN, String newComment) {
		bookTitle = newTitle; 
		bookAuthor = newAuthor;
		bookGenre = newGenre; //"IT ����";
		bookPages = newPages;// pp
		bookPrice = newPrice; //��
		no = newNo;
		publisher = newPublisher;
		rate = newRate;
		ISBN = newISBN;
		comment = newComment;
	}
	
	// ��ü�� �� �ʵ� ���� ��� �޼ҵ�(�Լ�)
	public void printBook() {
		//String bookTitle;
		System.out.println("BOOK " + no);
		System.out.println("\t ����: " + bookTitle);
		System.out.println("\t �о�: " + bookGenre);
		System.out.println("\t ����(������): " + bookPrice +"won");
		System.out.println("\t ����: '" + bookAuthor + "'��");
		System.out.println("\t �ʼ�: " + bookPages + "pp");
		System.out.println("\t ���ǻ� ��ȣ: " + publisher);
		System.out.println("\t ISBN: " + ISBN);
		System.out.println("\t ����: " + rate);
		System.out.println("\t �����ڸ�Ʈ: " + comment);
		System.out.println("-----------------------------");
	}
}





