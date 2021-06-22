package newbook.library.tools;
// �ű� ��Ű�� (����)
// - �Ӽ�: ����, å����, å����, å��.. , �Ͻ��ĵ�
// .. å ���뷮(����), ����, ũ��(��޼�), 
// .. �Ϸù�ȣ(����), ��ġ���� (��), �󺧽�ƼĿ??, ī�װ�..
// + ���� ����, ������, ����, ����ڻ缭��, ...
// - ���: 
//		å�� �ϳ��� ��ġ�� �� �ִ�. (å�迭�ʵ忡 �ϳ��� ��Ұ���(slot)�� å ��ü �߰�)
//      å���� ������ ���������� ����� �� �ִ�.
//  .. ������ ���� å �ϳ��� ���� �� �ִ�.(å��ü�� �迭���� ����?)
//  .. å�� �ϳ� ����(��ȯ)�� �� �ִ�.
//  .. ��� å�� �� ��� �� �ִ�. 
//  å������ ����(���� ���뷮)�� Ȯ���� �� �ִ�.(�� �����, �Ϻ� ����� ����, 
//  ��� ��ä���� ����(�� �̻� �ű� å�� ��ġ�� �� ���� ����..)

import newbook.Book;

public class Bookshelf_backup1 {
	public static final Book EMPTY = null; // å�� �� �迭�� ��ĭ ǥ��
	public static final int DEF_SIZE = 4; 
	// �ּ� 4�� ���� �����ؾ� ������ å���� �ڰ��� ����.
	
	public int no; //�Ϸù�ȣ(����)
	public String label; //�󺧽�ƼĿ??, ī�װ�. ����..
	public int floor; // �� ��ȣ
	public int size; // å ���뷮 ���� (volume)
	public Book[] books; // ���� å���� ��ġ�� ���� Ȯ��.. /�迭Ÿ�� �ʵ�
	// å���� ����� �ִ�? ��� ǥ��? ó���� å���� ������ ������ �����?
	
	// �⺻������ 
	public Bookshelf_backup1() { 
		// �ʵ帶�� �ڽ��� �⺻������ �ڵ��ʱ�ȭ��...
	}
	
	// �߰� �����ڵ�
	public Bookshelf_backup1(int no, String label, int floor) {		
		this.no = no;
		this.label = label;
		this.floor = floor;
		this.size = DEF_SIZE;
		this.books = new Book[this.size]; 
			// ������ 4¥�� ���� �迭�� ���� �޸� �Ҵ�..
//		this.books = new Book[]{ null, null, null, null };
//		this.books = new Book[]{ EMPTY, EMPTY, EMPTY, EMPTY };
	} 
	
	// å���� ũ�⸸ ����ϸ�... ������ ���ο��� å���� ������ �迭�������� ����Ȯ��.
	// --- ������ ���ذ� �����!!!!!!!!! 
	public Bookshelf_backup1(int no, String label, int floor,int size) {		
		this.no = no;
		this.label = label;
		this.floor = floor;
		this.size = size;
		this.books = new Book[size]; // size�� 4 ~ 100? ��������.
		// books�� å��ü���� �ټ��� ��, size������ŭ �ִ��� ��ġ�� �� �ִ�
		// å�尴ü�� ������ �迭�� ǥ��.
		// �迭 ���� �ʵ� books ��ü�� ���۷������̶� �ݵ�� 
		// �� �ѹ��� new�� ����ó���� �ؾ� ��μ� ������ ���´�.
		// �׸��� �� �迭�� ��� ���� ��δ� ���� null�� �ڵ��ʱ�ȭ��.
	} 
		
	// Ǯ������
	// �ܺο��� å���� ��ġ�� ������ �迭�� '�̸�' ���� ������ å���� �ʱ�ȭ
	public Bookshelf_backup1(int no, String label, int floor,
			int size, Book[] books) {		
		this.no = no;
		this.label = label;
		this.floor = floor;
		this.size = size;
		this.books = books;
	} 
	
	
	// å�� ���� ������ϱ� - å�� �� �迭������ ��ġ�� å��ü���� �������� ǥ�� 
	public void printBookshelf() {
		System.out.println("��������������������������������");  // �� + ����Ű
		System.out.println(this.no +"�� å��:: <" + floor +">��");
		System.out.println("\t ���̺�: " + label);
		System.out.println("\t ���� ���뷮: "+ this.size + "~�Ǳ��� ����");
		System.out.println("������������������������������");
		//for (int i = 0; i < books.length; i++) {
		int slot = 0;
		for( Book book :   this.books ) {
			System.out.print("["+ (++slot) +"] ");
			// å���� �̹� ȸ�� ���԰����� å�� ����?
			if( book == EMPTY ) // null )
				System.out.println(" -- slot ����� -- ");		
			else {
				System.out.print(book.title);
				System.out.print(" ["+book.author+"] ");
				//System.out.println( book.getStarRating());// private ����
				System.out.println( book.getStarRating()); // public ����/����/���
				//book.printBook();
			}
		}
		
		System.out.println("��������������������������������"); 
	}
	
	// å�� ���� ��������ϱ�
}




