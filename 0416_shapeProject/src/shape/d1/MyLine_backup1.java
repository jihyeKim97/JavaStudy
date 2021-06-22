package shape.d1;
import shape.basic.MyPoint;
/*
### �� Line ��Ű��
> shape.d1.MyLine
> �� ��ǥ���� �̾��ִ� ������ ǥ��. �ϴ� �� ���� �մ� ������ ǥ�� (��� ������ ���)
> ���� ���� �ƴϸ�, �������� �ְ�, ������ ���� (������ => ����)
- ������ ��ġ ����ü			MyPoint sp // start point
- ���� ��ġ ����ü			MyPoint ep // end point
- ���� �̸��±� ���ڿ� 		String tag
- ���� ����ǥ�����ν��� �÷�		String color (RGB �÷��ڵ� 16���� ���ڿ�)
- ���� ���� stroke,border types...   int strokeType
- ���� �β� ������...					  int width 
- ����: ����ü�� �̷�� �� �� ������ �ִܰŸ� (����) 
		�Ǽ��� ��ġ��   double distance 

���� ����
���� �Ǽ�
���� �Ǽ�
�ļ�
1�� �⼱
2�� �⼱
����, ��������� ���� �Ǽ�
��Ģ���� ���� ���ݼ�

# Border Style

solid - Defines a solid border.
dotted - Defines a dotted border.
dashed - Defines a dashed border.
double - Defines a double border.
groove - Defines a 3D grooved border. ...
ridge - Defines a 3D ridged border. ...
inset - Defines a 3D inset border. ...
outset - Defines a 3D outset border.
		
 */
public class MyLine_backup1 {
	// ��� �ʵ�
	public static final String TYPE = "�� LN";
	public static final int DEF_WIDTH = 1; // ���� �β� �����
	public static final int BOLD_WIDTH = 2;
	public static final int BOLDER_WIDTH = 4;
	// ���� ��輱Ÿ�� �����
	public static final int ST_SOLID = 0; // �Ǽ� 
	public static final int ST_DOTTED = 1; // ����
	public static final int ST_DASHED = 2; // ���
	public static final int ST_DOUBLE = 3; // ���߼�
	public static final int ST_GROOVE = 4; // �����
	public static final int ST_RIDGE = 5; // ����
	public static final int ST_INSET = 6; // �μ�
	public static final int ST_OUTSET = 7;  // �ƿ���
	public static final String[] STROKES = {
		"�Ǽ�", "����", "���", "���߼�",
		"�����", "����", "�μ�", "�ƿ���"
	};
	
	// ���� �ʵ�
	private MyPoint sp; // start point
	private MyPoint ep; // end point
 	 // private Ŭ���� ���ο����� ���ǰԲ� ��ȣ(����)�Ǿ� �ܺο��� ���� ���� �ȵ�.
	public String tag; // ���� �̸��±� ���ڿ�
	public String color; // ������ ����ǥ�����ν��� �÷�
	public int strokeType; // ���� ���� 8����..
	public int width; // ���� �β� ���� 
	private double distance; // ����: ����ü�� �̷�� �� �� ������ �ִܰŸ� (����)
	
	// �����ڵ�
	public MyLine_backup1() {} // �⺻ ������
	
	// Ǯ ������
	public MyLine_backup1(MyPoint sp, MyPoint ep, String tag, String color, int strokeType, int width, double distance) {
		super();
		this.sp = sp;
		this.ep = ep;
		this.tag = tag;
		this.color = color;
		this.strokeType = strokeType;
		this.width = width;
		this.distance = distance;
	}
		
	// ���� �Լ�
	
	// ��� �Լ�
	// @ annotation ������̼�.. �ΰ����?
	// @Override ������̼��� �Լ� �տ� ������.
	//   �� ������̼��� �ش� �Լ��� �θ� Ŭ������ ���� ������ �� �������� 
	//   �ش� �Լ��� ���� �޾Ƽ� �������� �� �ִ����� ���� üũ��.
	@Override
//	public String toMyString() { // error
//	public String toString(int age) { // error
	public String toString() {
		return "MyLine [sp=" + sp + 
		", ep=" + ep + ", tag=" + tag 
		+ ", color=" + color + ", strokeType=" + strokeType
		+ ", width=" + width + ", distance=" + distance + "]";
	}
	
	public void printLine() {
//		System.out.println(this.toString());
		System.out.println(this); // this.toString() �ڵ� ȣ�� 
//		String line = this.toString();
//		System.out.println(line);
	}

	
}


