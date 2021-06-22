package newbook.library;
import newbook.human.Librarian;
import newbook.Book;
import java.util.Date;

public class Library12 {

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
		int libIdx = 1;
		for(Librarian human : libMans) { // ���������� for��
			System.out.print("�缭�� #" + libIdx++);
			String name = human.name;
			System.out.println("�̸�: " + name 
				+ ", ����: " + 
					(human.gender
						!= Librarian.GENDER_FEMALE ?
							"Male" : "Female")
				+ ", �ּ�: " + 
					(human.address == null ? "�����!": human.address) 
				);
		}
//		for(Librarian human : libMans) { // ���������� for��
//			System.out.print("�缭�� #" + libIdx++);
//			human.printLibrarian(true);
//			//libIdx++;
//		}
	}

}

/*
============================
[] �缭 1 : �̸� ���� (23��) - ���� �븮 
[] �缭 2 : �̸� �����̴��� (29��) - ���� ���� 
[] �缭 3 : �̸� �ȳ� (17��) - ���� ���� 
[] �缭 4 : �̸� ���� (19��) - ���� �߽� 
[] �缭 5 : �̸� ���̾�� (46��) - ���� ���� 

============================
�缭�� #1�̸�: ����, ����: Male, �ּ�: ����� �սʸ�
�缭�� #2�̸�: �����̴���, ����: Female, �ּ�: �����!
�缭�� #3�̸�: �ȳ�, ����: Female, �ּ�: �����!
�缭�� #4�̸�: ����, ����: Female, �ּ�: �ּҹ���
�缭�� #5�̸�: ���̾��, ����: Male, �ּ�: �����!

*/