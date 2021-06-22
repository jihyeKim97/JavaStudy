package inherit;
// ������ �������� ������Ʈ
// �䱸�������ǹ��� SRS: SW ��ǰ(������Ʈ)�� �ʿ��� ��� ������ ����� ��ȹ��...
// ���丮�� �����ϴ� ��� ����� �߿���...  �ֿ� ����� �м��ϰ�, 
// ���⿡ �ʿ��� ��� ������� ��Ű��(Schema)�� ǥ���ϰ� �̸� ���� Ŭ������ ����.

// 'å'�̶�� ����(��Ű��)�� �������� '�Ӽ�'��� ������.
// ����, ����, ���ǻ�, ����, Ŀ���̹���, �Ⱓ/����⵵, �ʼ�, ISBN, �帣, ..
// + ������ȣ(�԰����), ����, �ڸ�Ʈ(����), �̷°���..

// Ŭ������ ���ο� Ÿ�� (���赵), 
// Ŭ���� = ������(�ʵ�=���/����) + ���(�Լ�;�޼ҵ�)
public class Book {
	// ����, ����, ���ǻ�, ����, Ŀ���̹���, �Ⱓ/����⵵, �ʼ�, ISBN, �帣, ..
	// + ������ȣ(�԰����), ����, �ڸ�Ʈ(����), �̷°���..
	
	// ��� �ʵ� (Ŭ������ ���� ���� ���)
	public static final String NO_TITLE = "�������";
	public static final String NO_AUTHOR = "���ھ���";
	public static final int DEF_PUB = 0 ; //���� ���ǻ�?
	public static final String DUMMY_COVER = "default/dummy.png";
	public static final String DUMMY_ISBN = "9876543210123";
	public static final String NO_COMMENT = "��۾���"; //"";
	//
	public static final String[] PUB_NAMES = {
		"�������ǻ�", "�����", "�������л�", 
		"�������", "�������ǻ�"   // 0 ~ 4
		, "�Ϻ���ȭ��"
	}; // publisher�� PUB_NAMES�� ������ȣ..
	
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
	
	// �������� �԰� ó���� ���� �ʵ�
	public boolean stamp; // false �԰� ��, true ������ ������ �԰� �Ϸ�
	
	// �����ڵ�
	// �������Լ�(Ŭ�������ϸ�; constructor) 
	// => new�� ���� ��������� ��ü�� �ʱ�ȭ�� ���.
	// => �������� ����... ��ü�� ������� �ʱ�ȭ�� ��������.. 
	//    �� ���� ��ü�� �޸𸮻��� ��ġ����(�ּ� address; ��heap����)�� ������.
	
	// �⺻������(���̻�����) -- �ڵ����� ���ǵǴ� �������Լ�
//	public Book() {} // �⺻�����ڴ� (Ŭ������ �����ڰ� �ϳ��� ���� �� ��������)
	public Book() {} // �� �����ʵ���� �ڽ��� Ÿ���� �⺻������ �ڵ��ʱ�ȭ..

	// �߰� ������ (�ʵ���� �Ϻθ� ������ ��ü�� �켱 �����)
	
	public Book(String title, String author ) {
		this.title = title;
		this.author = author; 
		this.comment = Book.NO_COMMENT;
		this.imgPath = DUMMY_COVER; // Book.DUMMY_COVER;
		publisher = DEF_PUB;
		this.no = 0; // ?
		this.rate = 0.0f;
		this.ISBN = DUMMY_ISBN;
	}
	public Book(String atitle, String aauthor,int apublisher) {
		title = atitle;
		author = aauthor;
		publisher = apublisher;
//		imgPath = null; // ���� �� �ڵ��ʱ�ȭ��.
//		ISBN = null; // �ڵ��ʱ�ȭ��.
//		no = 0; // �ڵ��ʱ�ȭ��.
//		rate = 0.0f; // �ڵ��ʱ�ȭ��.
//		comment = null;// �ڵ��ʱ�ȭ��.
	}	
	
	public Book(int no, String atitle, String aauthor,
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
	
	
	
	// old Ǯ ������ (��� �ʵ� �ʱ�ȭ ����)
	public Book(String atitle, String aauthor,int apublisher, 
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
		//this.stamp = false; // �ڵ��ʱ�ȭ
	}
	
	
	
	
	// �޼ҵ��
	// ���� �ʵ� ���� ���  (���� ó��)
	// 0.0~5.0 ���� ����?
//	public void changeRate(float rate) {
//		this.rate = rate; 
//	}
	//public void changeRate(float rate) {
	
	// �԰� �������� Ǯ ������
	public Book(String title, String author, int publisher, String imgPath, String iSBN, int no, float rate,
			String comment, boolean stamp) {
//		super();
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.imgPath = imgPath;
		ISBN = iSBN;
		this.no = no;
		this.rate = rate;
		this.comment = comment;
		this.stamp = stamp;
	}
	
	// �԰� ������ �Ǵ��Ͽ� ����ϰ� �� ���µ� �������ִ� �Լ�
	public boolean isBookRegister() {
//		if( stamp == true ) {
//			System.out.println(this.title +" å�� �԰� �Ǿ����ϴ�.");
//			//return stamp; //return true;
//		} else {
//			System.out.println(this.title +" å�� �԰� �� �Դϴ�.");
//			//return stamp; //return false;
//		}
		System.out.println( this.title +" å�� " +
			(stamp ? " �԰� �Ǿ����ϴ�." : " �԰� �� �Դϴ�.")
		);
		return stamp;
	}

	// ���� ������ ������ �������� �缳��
	public boolean changeRate(float rate) {
		if( rate >= 0.0f && rate <= 5.0f ) {			
			this.rate = rate; 
			System.out.println(
			">> ���� [" + this.title + "]��  ������ "
			+ this.rate +"���� ����Ǿ����ϴ�."	);
			return true;
		} else {
			System.out.println(
				">> ���� ���� ��� ����: " + rate);
			return false;
		}
	}
	
	// ���� ���� 1.0, 0.5, 0.1... ������ŭ �ø���? // ����, ����
	public static final float RATE_UNIT = .5f; //.1f; //1.0f;
	
	public void increaseRate() { 
		if( this.changeRate(this.rate + RATE_UNIT) == false ) 			
			this.rate = 5.0f;
	}
	
	public void decreaseRate() {
		//if( this.changeRate(this.rate - RATE_UNIT) != true ) 			
		if( !changeRate(rate - RATE_UNIT) )	rate = 0.0f;
	}
	
	// �Ǽ����� ���� rate�� �׷��ȿ���� ��ǥ�÷� ����ϱ� 
	// ***** => �� ��    // �� + ����Ű�� ã�Ƽ�..
	// 0.0 ~ 5.0 => rate�� 6���� ���� 
	// �١١١١� 0.0 <= ~ < 0.5 �ݿø� ����?? (���ϱ� ����..)
	// �ڡ١١١� 0.5 <= ~ < 1.5 (1.4xxxx)
	// �ڡڡ١١� 1.5 <= ~ < 2.5 
	// �ڡڡڡ١� 2.5 <= ~ < 3.5
	// �ڡڡڡڡ� 3.5 <= ~ < 4.5
	// �ڡڡڡڡ� 4.5 <= ~ <= 5.0
	// private�� Ŭ���� ���ο����� ���� ����, ����� ��. (������)
	//private String getStarRating() {
	public String getStarRating() { // ������.
		String stars = new String(""); //"";
		final String RSTARS[] = {  // 0 ~ 5
				"�١١١١�", "�ڡ١١١�", "�ڡڡ١١�", 
				"�ڡڡڡ١�", "�ڡڡڡڡ�", "�ڡڡڡڡ�"
		}; // �迭�ε��� �������� switch/case �б⸦ ��ü����.
		int starIndex = Math.round(rate);  // �ݿø�
		stars = RSTARS[starIndex];		
		return "<<"+stars+">>";
	}		
	
	
	private String getStarRating3() {
		String stars = new String(""); //"";
		int starIndex = Math.round(rate);  // �ݿø�
		// 0.0 ~ 5.0  
		// ==> 0 ~ 5  :  0, 1, 2, 3, 4, 5 ��������
		// �����и� üũ
		switch (starIndex) {
			case 0: stars = "�١١١١�"; break;
			case 1: stars = "�ڡ١١١�"; break;
			case 2: stars = "�ڡڡ١١�"; break;
			case 3: stars = "�ڡڡڡ١�"; break;
			case 4: stars = "�ڡڡڡڡ�"; break;
			case 5: stars = "�ڡڡڡڡ�"; break; 
				// case�� ���ڰ� ������(ä���� ���� ����)
			default: stars = "error"; 
		}	
		
		return "["+stars+"]";
	}
	
	private String getStarRating2() {
		String stars = new String(""); //"";
		// ���� üũ...
		if( rate >= 0.0f && this.rate < 0.5f )
			stars = "�١١١١�";
		else if( rate >= 0.5f && this.rate < 1.5f )
			stars = "�ڡ١١١�";
		else if( this.rate < 2.5f )
			stars = "�ڡڡ١١�";
		else if( this.rate < 3.5f )
			stars =	"�ڡڡڡ١�";
		else if( this.rate < 4.5f )
			stars = "�ڡڡڡڡ�";
		else if( this.rate <= 5.0f )
			stars = "�ڡڡڡڡ�";
		else 
			stars = "error";
		
		return stars;
	}
	
//	public void increaseRate() {
//		//this.rate = this.rate + RATE_UNIT; // ����
//		float tempRate = this.rate + RATE_UNIT;
//		if( tempRate > 5.0f ) {
//			System.out.println(">> ����  MAX ���! 5.0����ó��");
//			this.rate = 5.0f;
//		} else
//			this.rate = tempRate;
//	}
//	
//	// ���� ���� 1.0 ������? 
//	public void decreaseRate() {
////		this.rate -= RATE_UNIT;
//		float tempRate = this.rate - RATE_UNIT;
//		if( tempRate < 0.0f ) { // ���� ��
//			System.out.println(">> ����  MIN ���! 0.0����ó��");
//			this.rate = 0.0f;
//		} else
//			this.rate = tempRate;		
//	}
	
	// å ��ü ���� ���?
	public void printBook() {
		//System.out.println("������ å: #BK0000" + no);
		System.out.printf("������ å: #BK-%06d \n", no);
		System.out.println("����: " + title);
		System.out.println("\t\t\t\t" + this.author +" ����");
		//System.out.println("\t���ǻ�: " + this.publisher );
		//System.out.println("\t���ǻ�: " + PUB_NAMES[publisher] );		
		System.out.println("\t���ǻ�: " +  
			( publisher >= 0 && publisher < PUB_NAMES.length ?
					PUB_NAMES[publisher] : "���ǻ��") );
		
		System.out.println("\tĿ��ǥ��: " + imgPath );
		System.out.println("\tISBN: " + this.ISBN );		
		//System.out.printf("\t\t ����: %.2f pt \n", this.rate);
		String stars = this.getStarRating();
		System.out.printf("\t\t ����: (%s) %.2f/5.0 pt \n", 
				stars, this.rate);
		
		System.out.printf("\t\t ����: %s \n", comment);
		System.out.println("-----------------------------");

	}
}


