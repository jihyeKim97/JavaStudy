package newbook;
// ������ �������� ������Ʈ
// �䱸�������ǹ��� SRS: SW ��ǰ(������Ʈ)�� �ʿ��� ��� ������ ����� ��ȹ��...
// ���丮�� �����ϴ� ��� ����� �߿���...  �ֿ� ����� �м��ϰ�, 
// ���⿡ �ʿ��� ��� ������� ��Ű��(Schema)�� ǥ���ϰ� �̸� ���� Ŭ������ ����.

// 'å'�̶�� ����(��Ű��)�� �������� '�Ӽ�'��� ������.
// ����, ����, ���ǻ�, ����, Ŀ���̹���, �Ⱓ/����⵵, �ʼ�, ISBN, �帣, ..
// + ������ȣ(�԰����), ����, �ڸ�Ʈ(����), �̷°���..

// Ŭ������ ���ο� Ÿ�� (���赵), 
// Ŭ���� = ������(�ʵ�=���/����) + ���(�Լ�;�޼ҵ�)
public class Book_backup1 {
	// ����, ����, ���ǻ�, ����, Ŀ���̹���, �Ⱓ/����⵵, �ʼ�, ISBN, �帣, ..
	// + ������ȣ(�԰����), ����, �ڸ�Ʈ(����), �̷°���..
	
	// ��� �ʵ�
	public static final String NO_TITLE = "�������";
	public static final String NO_AUTHOR = "���ھ���";
	public static final int DEF_PUB = 0 ; //���� ���ǻ�?
	public static final String DUMMY_COVER = "default/dummy.png";
	public static final String DUMMY_ISBN = "9876543210123";
	public static final String NO_COMMENT = "��۾���"; //"";
	// ���� �ʵ�
	public String title; // ����
	public String author; // ����
//	public String publisher; // ���ǻ��?
	public int publisher; // ���ǻ��Ϲ�ȣ?
//	public int price; // ����
	//public Image cover; // åǥ������? png, jpg, 
	public String imgPath; // åǥ�� Ŀ���̹��� ������ ���ϸ�/��θ� ���ڿ�
	public String ISBN; // ���ڵ�
	// 
	public int no;// ������ȣ(�԰����) 0 �ڵ��ʱ�ȭ
	public float rate; // ���� (5�� ô��?) 0.0f �ڵ��ʱ�ȭ
	public String comment; // �ڸ�Ʈ(����)
	
	// �����ڵ�
	// �������Լ�(Ŭ�������ϸ�; constructor) 
	// => new�� ���� ��������� ��ü�� �ʱ�ȭ�� ���.
	// => �������� ����... ��ü�� ������� �ʱ�ȭ�� ��������.. 
	//    �� ���� ��ü�� �޸𸮻��� ��ġ����(�ּ� address; ��heap����)�� ������.
	
	// �⺻������(���̻�����) -- �ڵ����� ���ǵǴ� �������Լ�
//	public Book() {} // �⺻�����ڴ� (Ŭ������ �����ڰ� �ϳ��� ���� �� ��������)
	public Book_backup1() {} // �� �����ʵ���� �ڽ��� Ÿ���� �⺻������ �ڵ��ʱ�ȭ..

	// �߰� ������ (�ʵ���� �Ϻθ� ������ ��ü�� �켱 �����)
	public Book_backup1(String atitle, String aauthor,int apublisher) {
		title = atitle;
		author = aauthor;
		publisher = apublisher;
//		imgPath = null; // ���� �� �ڵ��ʱ�ȭ��.
//		ISBN = null; // �ڵ��ʱ�ȭ��.
//		no = 0; // �ڵ��ʱ�ȭ��.
//		rate = 0.0f; // �ڵ��ʱ�ȭ��.
//		comment = null;// �ڵ��ʱ�ȭ��.
	}	
	
	public Book_backup1(int no, String atitle, String aauthor,
			int apublisher) {
		title = atitle;
		author = aauthor;
		publisher = apublisher;
		// ��ü�ʵ庯�� = ��������(����)
		// this.�ʵ庯�� = ��������(����)
//		imgPath = null; // �ڵ��ʱ�ȭ��.
//		ISBN = null; // �ڵ��ʱ�ȭ��.
		// no = no;  // ?? 		
		this.no = no;  // OK �ڽſ��� ���� no ���� �ʵ忡 ���� no�� �Ҵ�.
		// this�� ��ü �ڽ��� �ּ� (�ڱ��ڽ�) ==> �̸������� ����.
//		rate = 0.0f; // �ڵ��ʱ�ȭ��.
//		comment = null;// �ڵ��ʱ�ȭ��.
	}	
	
	
	
	// Ǯ ������ (��� �ʵ� �ʱ�ȭ ����)
	public Book_backup1(String atitle, String aauthor,int apublisher, 
			String aimgPath, String aISBN, int ano, 
			float arate, String acomment )
	{
		title = atitle;
		author = aauthor;
		publisher = apublisher;
		imgPath = aimgPath;
		ISBN = aISBN;
		no = ano;
		rate = arate;
		comment = acomment;
	}
	
	
	// �޼ҵ��
	public void printBook() {
		//System.out.println("������ å: #BK0000" + no);
		System.out.printf("������ å: #BK-%06d \n", no);
		System.out.println("����: " + title);
		System.out.println("\t\t\t\t" + this.author +" ����");
		System.out.println("\t���ǻ�: " + this.publisher );
		System.out.println("\tĿ��ǥ��: " + imgPath );
		System.out.println("\tISBN: " + this.ISBN );
		System.out.printf("\t\t ����: %.2f pt \n", this.rate);
		System.out.printf("\t\t ����: %s \n", comment);
		System.out.println("-----------------------------");

	}
}


