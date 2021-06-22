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
public class MyBook_backup1 {	
	// ������ ǥ�� (�ʵ�) ------------
	// (����) ��� �ʵ�
	public static final int DEF_PRICE = 2900; 
	public static final String DEF_GENRE = "�Ҽ�";
	
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





