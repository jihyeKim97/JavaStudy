package HomeWork_0416;

/* 
�ǽ� 1) 

homework.film ��Ű�� ����
 MyMoive Ŭ���� ����
 '��ȭ' ������  ��ȭ ��Ű�� ����...�� ǥ���ϴ�
 MyMoive Ŭ������ �ۼ� �մϴ�.
 �ʵ峪 ����� �����ϰ� (��� 6�� �̻��� �ʵ��), 
 ��ȭ��ü�� ������ ����ϴ� �޼ҵ带 �ۼ���.
 ��ȭ��ü�� �����ϴ� �������Լ��� 
 ��� 3���� ������� �Լ������ε�ȭ�ؼ� �ۼ�

�ǽ� 2)

MovieTest Ŭ������ main() �Լ�����... 

Scanner�� ����Ͽ�, ��ȭ ��ü�� ������ �� ����ϴ� ����

>> ��ȭ ������ �Է����ּ���! 
* ��ȭ �̸�: aaaa
* ��ȭ �帣: bbbbb
* ��ȭ �����⵵: 2019
* ��ȭ ������: 300
* ��ȭ ����: 3.4
* . . . 
* ��ȭ ��ü�� �����մϴ�.
* (printMyMoive�� �����Ͽ� ���)
*/

public class MyMovie {
	public static final String NAME = "���� ����";
	public static final String GENRE = "�帣 ����";
	public static final String DIRECTER = "���� ����";

	public String name;
	public String genre;
	public String directer;
	public int year;
	public int guests;
	public int level;
	public float score;

	public MyMovie() {
		this.name = NAME;
		this.genre = GENRE;
		this.directer = DIRECTER;
	}

	public MyMovie(String name) {
		this.name = name;

	}

	public MyMovie(String name, int level) {
		this.name = name;
		this.genre = GENRE;
		this.directer = DIRECTER;
		this.year = 0;
		this.guests = 0;
		this.level = level;
		this.score = 0;
	}

	public MyMovie(String name, int level, float score) {
		this.name = name;
		this.genre = GENRE;
		this.directer = DIRECTER;
		this.year = 0;
		this.guests = 0;
		this.level = level;
		this.score = score;
	}

	public MyMovie(String name, String directer, int year) {
		this.name = name;
		this.directer = directer;
		this.year = year;

	}

	public MyMovie(String name, String genre, String directer, int year, int guests, int level, float score) {
		this.name = name;
		this.genre = genre;
		this.directer = directer;
		this.year = year;
		this.guests = guests;
		this.level = level;
		this.score = score;
	}

	public void printMyMovie() {
		System.out.println("��ȭ �̸�: " + name + "\n" + "��ȭ �帣: " + genre + "\n" + "��ȭ ����: " + directer + "\n"
				+ "��ȭ ���� �⵵: " + year + "��" + "\n" + "��ȭ ���� ��: " + guests + "��" + "\n" + "��ȭ ���: " + level + "\n"
				+ "��ȭ ����: " + score + "��");
	}

}
