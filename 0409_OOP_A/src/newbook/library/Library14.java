package newbook.library;
import newbook.human.Librarian;
import newbook.Book;
import java.util.Date;

public class Library14 {
	
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
				new Book(104, "�Ϻ��� ù����", 
						"�Ϻ���Ƹ�", 4),
				bk1, bk2, 
				new Book("����", "� ���̺�� �ҷο�", 
						2, "classic/walden.png", 
						"8908098111332", 
					103, 4.37f, "���� ���ƿ�!")				
		}; // ���� 4���� ǥ���� �迭... 
		
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
		
		// �缭 5�� ����...   �缭���� ��� �缭�迭�� ǥ��
		Librarian[] libMans = {
			man2, man3, 
			new Librarian("�ȳ�", 17, Librarian.GENDER_FEMALE), 
			man1, 
			new Librarian("���̾��", 46, Librarian.GENDER_MALE) 	
		};  // legnth 5, 0 ~ 4 
		Librarian lib = libMans[4];
		lib.pos = Librarian.LIB_POS[Librarian.LIB_POS_����];
		lib.major = "������ �Ѱ�����";
		
		System.out.println("============================");
		// �缭 ����Ʈ ���� ���
		for (int i = 0; i < libMans.length; i++) {
			System.out.printf(
					"[] �缭 %d : �̸� %s (%d��) - ���� %s \n",
					i+1, libMans[i].name, 
					libMans[i].age,
					libMans[i].pos == null ?
							"����": libMans[i].pos);
					//libMans[i].pos);
		}
		System.out.println();
		System.out.println("============================");
		// 2��° å�� 1�� �缭�� �԰�ó�� �ϱ� 
		Book targetBk = bookBox[1]; // ����..
		Librarian staffLib = libMans[0];// ����..
		System.out.println(" �԰�ó�� ::: ");
		registerNewBookToLibrary(targetBk, staffLib);
		if( targetBk.isBookRegister() ) {
//			System.out.println("�ش� ���� " +targetBk.title
//			+"�� �缭 " + staffLib.name +"�� ���� �������� �԰��.." );
			System.out.println("����: " + targetBk.comment);
		}
		
		// 4��° å�� 3�� �缭�� �԰�ó�� �ϱ� 
		Book targetBk2 = bookBox[3]; 
		Librarian staffLib2 = libMans[2];
		System.out.println(" �԰�ó�� ::: ");
		registerNewBookToLibrary(targetBk2, staffLib2);
		if( targetBk2.isBookRegister() ) {					
			System.out.println("����: " + targetBk2.comment);
		}
	}

}
/*
#104, ����: �Ϻ��� ù����, ����: �Ϻ���Ƹ� ��
#101, ����: ���� �ƺ� ������ �ƺ� 20�ֳ� Ư�� �����, ����: ����Ű ��
#102, ����: �ȳ� �� - ����� ���� �̾߱�, ����: ���� ��
#103, ����: ����, ����: � ���̺�� �ҷο� ��
============================
[] �缭 1 : �̸� ���� (23��) - ���� �븮 
[] �缭 2 : �̸� �����̴��� (29��) - ���� ���� 
[] �缭 3 : �̸� �ȳ� (17��) - ���� ���� 
[] �缭 4 : �̸� ���� (19��) - ���� �߽� 
[] �缭 5 : �̸� ���̾�� (46��) - ���� ���� 

============================
 �԰�ó�� ::: 
���� �ƺ� ������ �ƺ� 20�ֳ� Ư�� ����� å��  �԰� �� �Դϴ�.
���� �ƺ� ������ �ƺ� 20�ֳ� Ư�� ����� å��  �԰� �Ǿ����ϴ�.
����: ���ڵǰ� ������...
[�԰���] ��ǰ å�Դϴ�. by ����(2) /ó���ð�  - Thu Apr 08 11:04:44 KST 2021
 �԰�ó�� ::: 
���� å��  �԰� �� �Դϴ�.
���� å��  �԰� �Ǿ����ϴ�.
����: ���� ���ƿ�!
[�԰���] ��ǰ å�Դϴ�. by �ȳ�(0) /ó���ð�  - Thu Apr 08 11:04:44 KST 2021
*/ 
