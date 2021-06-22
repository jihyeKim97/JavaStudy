package newbook.library;
import newbook.human.Librarian;
import newbook.Book;
import java.util.Date;
import newbook.library.tools.Bookshelf;

public class Library15 {
	
	// ������ �缭�� ������ å�忡 �԰�ó���ϴ�.
	// �԰�ó���ϸ�...
	// �ش� ������ ���°� '������ ������' stamp �ʵ尡 true�� �����.
	// + �׸��� comment �ʵ忡 �ش� ������ �԰��� ��� �缭�� �̸��� �԰����� ��ϵ�.
	// ���� ��ü�� �缭 ��ü�� �����Ǵ� �Լ�...
	public static void registerNewBookToLibrary(
			Book newBook, Librarian man) {
		if( newBook == null || man == null ) {
			System.out.println(">> å�� ���ų� �缭�� ��� �԰�ó�� ����!!");
			return;
		}
		//if( newBook.stamp == false ) { // �԰� �� å�̶��...
		if( newBook.isBookRegister() == false ) {
			newBook.stamp = true; // ���� ��� (���� �ٲ�)
			//newBook.comment = "[�԰���] ��ǰ å�Դϴ�. by "
			newBook.comment += "\n[�԰���] ��ǰ å�Դϴ�. by "
					+ man.name +"("+ man.libNum+") "
					+ "/ó���ð�  - " + new Date();
		} else {
			System.out.println(">> �̹� �԰�� å�̳׿�!!");
			// �̹� ���� ������ ������ ���� å�̳׿�!
		}
	}
	
	
	public static void main(String[] args) {
		Book bk1 = new Book(
				"���� �ƺ� ������ �ƺ� 20�ֳ� Ư�� �����", 
				"����Ű", 4, 
				"giyo/richdad.jpg",
				"8908098200123", 
				101, 3.45f, "���ڵǰ� ������...");
		
		Book bk2 = new Book(
				"�ȳ� �� - ����� ���� �̾߱�",				 
				"����", 5,				
				"red/book/ann.gif",
				"8908098111222", 
				102, 5.00f, "�߾��� ���ϻ��� ���ƿ�! ^_^");
	
		// å ���� �迭�� å���� �ӽ÷� �ϴ� ��Ƶ���..
		Book[] bookBox = {
				new Book(104, "�Ϻ��� ù����","�Ϻ���Ƹ�", 4),
				bk1, bk2, new Book("����", "� ���̺�� �ҷο�", 
				2, "classic/walden.png", 
				"8908098111332", 103, 4.37f, "���� ���ƿ�!"),
				new Book("ȫ�浿��", "���")
		}; // ���� 5���� ǥ���� �迭... 
		
		// å �ڽ� ���� Ȯ�� 
		for(Book book : bookBox) {
			System.out.println("#"+ book.no 
					+ ", ����: " + book.title 
					+ ", ����: " + book.author +" ��" );
		}
				
		// �缭(Actor) ����
		Librarian man1 = new Librarian();// �⺻������
		man1.name = "����";
		man1.age = 19;
		man1.gender = Librarian.GENDER_FEMALE; //1;
		//System.out.println(man1); // newbook.human.Librarian@33909752

		Librarian man2 = new Librarian( // Ǯ������
				"����", 23, Librarian.GENDER_MALE, 
				"����� �սʸ�", 2, 
				new Date(), 
				Librarian.LIB_POS[Librarian.LIB_POS_�븮], 
				"�뿩���� ��� 3��"); 
				//"��������", major); // ����, ����, Ÿ��
		
		Librarian man3 = new Librarian("�����̴���",
				29, Librarian.GENDER_FEMALE);
		man3.libNum = 3;
		man3.major = "���� ����/�뿩 ���� ��";

		// å�� ��ġ... 
		Bookshelf bs1 = new Bookshelf(1001, 
				"����/ 2010�� - �ι�/����A", 1); // 4�� ���뷮		
		Bookshelf bs2 = new Bookshelf(1004,
				"ö��, 2020�� - IT/����", 2, 10); // 10��..
		Bookshelf bs3 = new Bookshelf(1011, 
				"�ö�ƽ, 2021�� - �԰�/���� ����",
				3, bookBox.length, bookBox); // å�ڽ��迭��°�� �Է�.
		bs1.printBookshelf();
		System.out.println();
		bs2.printBookshelf();
		System.out.println();
		bs3.printBookshelf();
		//
		bs3.books[2] = Bookshelf.EMPTY; 
			// �ȳ� ���� �ٸ� �缭�� ���������� ��� å�忡�� �̾Ƽ� ���� ����..
		bs3.printBookshelf();
	}

}
/*
#104, ����: �Ϻ��� ù����, ����: �Ϻ���Ƹ� ��
#101, ����: ���� �ƺ� ������ �ƺ� 20�ֳ� Ư�� �����, ����: ����Ű ��
#102, ����: �ȳ� �� - ����� ���� �̾߱�, ����: ���� ��
#103, ����: ����, ����: � ���̺�� �ҷο� ��
#0, ����: ȫ�浿��, ����: ��� ��
��������������������������������
1001�� å��:: <1>��
	 ���̺�: ����/ 2010�� - �ι�/����A
	 ���� ���뷮: 4~�Ǳ��� ����
������������������������������
[1]  -- slot ����� -- 
[2]  -- slot ����� -- 
[3]  -- slot ����� -- 
[4]  -- slot ����� -- 
��������������������������������

��������������������������������
1004�� å��:: <2>��
	 ���̺�: ö��, 2020�� - IT/����
	 ���� ���뷮: 10~�Ǳ��� ����
������������������������������
[1]  -- slot ����� -- 
[2]  -- slot ����� -- 
[3]  -- slot ����� -- 
[4]  -- slot ����� -- 
[5]  -- slot ����� -- 
[6]  -- slot ����� -- 
[7]  -- slot ����� -- 
[8]  -- slot ����� -- 
[9]  -- slot ����� -- 
[10]  -- slot ����� -- 
��������������������������������

��������������������������������
1011�� å��:: <3>��
	 ���̺�: �ö�ƽ, 2021�� - �԰�/���� ����
	 ���� ���뷮: 5~�Ǳ��� ����
������������������������������
[1] �Ϻ��� ù���� [�Ϻ���Ƹ�] <<�١١١١�>>
[2] ���� �ƺ� ������ �ƺ� 20�ֳ� Ư�� ����� [����Ű] <<�ڡڡڡ١�>>
[3] �ȳ� �� - ����� ���� �̾߱� [����] <<�ڡڡڡڡ�>>
[4] ���� [� ���̺�� �ҷο�] <<�ڡڡڡڡ�>>
[5] ȫ�浿�� [���] <<�١١١١�>>
��������������������������������
��������������������������������
1011�� å��:: <3>��
	 ���̺�: �ö�ƽ, 2021�� - �԰�/���� ����
	 ���� ���뷮: 5~�Ǳ��� ����
������������������������������
[1] �Ϻ��� ù���� [�Ϻ���Ƹ�] <<�١١١١�>>
[2] ���� �ƺ� ������ �ƺ� 20�ֳ� Ư�� ����� [����Ű] <<�ڡڡڡ١�>>
[3]  -- slot ����� -- 
[4] ���� [� ���̺�� �ҷο�] <<�ڡڡڡڡ�>>
[5] ȫ�浿�� [���] <<�١١١١�>>
��������������������������������

*/ 
