package newbook.human;

import java.util.Date;

/*
  ������ ���� ���α׷��� storyboard ��... 
  �����ι� ��Ű�� actor�� �߰�... 
    ���������� => �缭 Librarian (��Ű��)
    
  // ������/ �ʵ�  
    ������ν��� �Ӽ���: �̸�, ����, ����, �ּ�?... �ֹι�ȣ?
    �����ڷν��� �Ӽ���?: ������ȣ, �Ի糯��, ����, ����  
   
  // �޼ҵ�/ �Լ� 
    ��ɵ�:  å�� �԰� ��Ų��(������ �缭 �ڸ�Ʈ �߰��ϱ� ����). 
          å ��������, å �˻� ����, å �뿩����...  
   
 */
public class Librarian_backup1 {
	// ������/ ����ʵ�
	public static final String NO_NAME = "�̸�����";
	public static final int DEF_AGE = 18;
	public static final int GENDER_FEMALE = 1;
	public static final int GENDER_MALE = 2;
	public static final String NO_ADDR = "�ּҹ���";
	//
	public static final String PREFIX 
				= "LIB_HUMAN_";  // ������� ���� ��ȣ LIB_HUMAN_0078	
	public static final String[] LIB_POS = {
		"�߽�", "����", "�븮", "����",
		"����", "����", "����"    // 0 ~ 6
	}; // ��å�� �迭 ���.	
	public static final int LIB_POS_�߽� = 0;
	public static final int LIB_POS_���� = 1;
	public static final int LIB_POS_�븮 = 2; 
	public static final int LIB_POS_���� = 3; // ����
	public static final int LIB_POS_���� = 4; // å��
	public static final int LIB_POS_���� = 5;
	public static final int LIB_POS_���� = 6;
	
	public static final String DEF_JOB = "å �԰� ����"; // �⺻ ����
	
    // ������/ �����ʵ�  
//    ������ν��� �Ӽ���: �̸�, ����, ����, �ּ�?... �ֹι�ȣ? => ��ĺ���ġ �ʼ�
	public String name; //�̸�
	public int age; //����
	public int gender; // ����: 1 ���� female, 2 ���� male
	public String address; // �ּ�
	
//    �����ڷν��� �Ӽ���?: ������ȣ, �Ի糯��, ����, ����  
	public int libNum; // ������ȣ
	public Date joinDay; // �Ի糯��
	public String pos; // postion ����
	public String major; // ���� role? job? 
	
	// ������ �Լ� 
	// �⺻ �����ڴ� ������ ����
//	public Librarian() {}
//	public Librarian() {
//		this.name = null;
//		this.age = 0;
//		this.gender = 0;
//		this.address = null;
//		//
//		this.libNum = 0;
//		this.joinDay = null; 
//		this.pos = null; 
//		this.major = null;
//	} // �� �����ʵ带 ������ ���������� �⺻������ �ʱ�ȭ
	public Librarian_backup1() {
		this.name = NO_NAME;
		this.age = DEF_AGE;
		this.gender = GENDER_FEMALE;
		this.address = NO_ADDR;
		//
		this.libNum = 0;
		this.joinDay = new Date(); // GMT + 9; KST
			// ���� ��ü ����(JVM�� ���� OS�� �������ڽð��� ������- Ÿ����, ������) 
		this.pos = LIB_POS[LIB_POS_�߽�]; 
		this.major = DEF_JOB;
	}

	
	// Ǯ ������ (full - ��� �ʵ� �������� ��ü �ʱ�ȭ)
	// ��Ŭ�������� ������ �Լ� �ڵ����� �����... 
	// source �޴�/ Generate Constructor using Fields... ����
	// shift + alt + s ����Ű��... Ȥ�� ���콺 �����ʿ��� �޴�...
	public Librarian_backup1(String name, int age, int gender,
			String address, int libNum, 
			Date joinDay, String pos, String major) {		
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.libNum = libNum;
		this.joinDay = joinDay;
		this.pos = pos;
		this.major = major;
	}
	
	
//  // �޼ҵ�/ �Լ� 
//    ��ɵ�:  å�� �԰� ��Ų��(������ �缭 �ڸ�Ʈ �߰��ϱ� ����). 
//          å ��������, å �˻� ����, å �뿩����...
	
	// �缭 �ڽ��� ���� ��� ���
	public void printLibrarian() {
		System.out.println("** �缭:: " + PREFIX + this.libNum);
		System.out.println("\t * �̸�: " + this.name);
		System.out.println("\t * ����: " + this.age +"��");
		System.out.println("\t * ����: " + this.gender);
		System.out.println("\t * �ּ�: " + this.address);
		System.out.println("\t * �Ի���: " + this.joinDay);
		System.out.println("\t * ����: " + this.pos);
		System.out.println("\t * �������: " + this.major);
		System.out.println("------------------------------"); 
	}
	
}




