package newbook.library;
import newbook.human.Librarian;
import newbook.Book;
import java.util.Date;

public class Library10 {

	public static void main(String[] args) {
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
		
//		man1.printLibrarian();
//		man2.printLibrarian();
		man1.printLibrarian(true);
		man2.printLibrarian(true);
	}

}

/*

** �缭:: LIB_HUMAN_0
 * �̸�: ����
 * ����: 19��
 * ����: 1
 * �ּ�: �ּҹ���
 * �Ի���: Wed Apr 07 13:29:56 KST 2021
 * ����: �߽�
 * �������: å �԰� ����
------------------------------
** �缭:: LIB_HUMAN_2
 * �̸�: ����
 * ����: 23��
 * ����: 2
 * �ּ�: ����� �սʸ�
 * �Ի���: Wed Apr 07 13:29:56 KST 2021
 * ����: �븮
 * �������: �뿩���� ��� 3��
------------------------------


** �缭:: LIB_HUMAN_0
	 * �̸�: ����
	 * ����: 19��
	 * ����: [����]
	 * �ּ�: �ּҹ���
	 * �Ի���: Wed Apr 07 13:39:26 KST 2021
	 * ����: �߽�
	 * �������: å �԰� ����
------------------------------
** �缭:: LIB_HUMAN_2
	 * �̸�: ����
	 * ����: 23��
	 * ����: [����]
	 * �ּ�: ����� �սʸ�
	 * �Ի���: Wed Apr 07 13:39:26 KST 2021
	 * ����: �븮
	 * �������: �뿩���� ��� 3��
------------------------------



** �缭:: LIB_HUMAN_0
	 * �̸�: ����
	 * ����: 19��
	 * ����: [����]
	 * �ּ�: �ּҹ���
	 * �Ի���: 2021�� 04�� 07��
	 * ����: �߽�
	 * �������: å �԰� ����
------------------------------
** �缭:: LIB_HUMAN_2
	 * �̸�: ����
	 * ����: 23��
	 * ����: [����]
	 * �ּ�: ����� �սʸ�
	 * �Ի���: 2021�� 04�� 07��
	 * ����: �븮
	 * �������: �뿩���� ��� 3��
------------------------------



*/