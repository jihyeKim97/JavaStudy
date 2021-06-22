package shape.d1;
import shape.MyShape;
import shape.basic.MyPoint;
import shape.basic.MyPoint_backup1;
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
public class MyLine_backup3 {
	// ��� �ʵ�
	public static final String TYPE = "�� LN";
//	// ���� �β� �����
//	public static final int DEF_WIDTH = 1; 
//	public static final int BOLD_WIDTH = 2;
//	public static final int BOLDER_WIDTH = 4;
//	// ���� ��輱Ÿ�� �����
//	public static final int ST_SOLID = 0; // �Ǽ� 
//	public static final int ST_DOTTED = 1; // ����
//	public static final int ST_DASHED = 2; // ���
//	public static final int ST_DOUBLE = 3; // ���߼�
//	public static final int ST_GROOVE = 4; // �����
//	public static final int ST_RIDGE = 5; // ����
//	public static final int ST_INSET = 6; // �μ�
//	public static final int ST_OUTSET = 7;  // �ƿ���
//	public static final String[] STROKES = {
//		"�Ǽ�", "����", "���", "���߼�",
//		"�����", "����", "�μ�", "�ƿ���"
//	};
	public static final String DEF_LINE_TAG = "�⺻��";
	
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
//	public MyLine() {} // �⺻ ������
//	public MyLine() {
//		this.sp = null;
//		this.ep = null;
//		this.tag = null;
//		this.color = null;
//		this.strokeType = 0;
//		this.width = 0;
//		this.distance = 0.0;
//	} // �⺻ ������
	public MyLine_backup3() {
		//this(new MyPoint(), MyShape.ORIGIN_PT);
		this(new MyPoint(), MyShape.ORIGIN_PT,
			DEF_LINE_TAG, MyShape.COLOR_BLACK,
			MyShape.ST_SOLID, MyShape.DEF_WIDTH, 0.0); 
		
//		this.sp = new MyPoint(); // ���� ������ (���� ��ü ����)
//		this.ep = MyShape.ORIGIN_PT; // new MyPoint(); // ���� ����
//		this.tag = DEF_LINE_TAG;//MyShape.EMTPY_TAG;
//		this.color = MyShape.COLOR_BLACK;
//		this.strokeType = ST_SOLID;
//		this.width = DEF_WIDTH;
//		this.distance = 0.0;
	} // �⺻ ������
	
	// �߰� �����ڵ�?
	// �������� ������ü�� �����ϰ� ������ü�� �Է¹޾Ƽ� �� ��ü ����
	// ���� ��ü �ϳ��� �ܺο��� �̹� new �ʱ�ȭ�� �ϼ��� ���� �Է� �ޱ�
	public MyLine_backup3(MyPoint ep) {
		this(MyShape.ORIGIN_PT, ep);
		// �� ����ü ���� �ƴ϶�� �ϰ�..
//		this.sp = MyShape.ORIGIN_PT; // new MyPoint();
//		this.ep = ep;
//		this.tag = DEF_LINE_TAG;//MyShape.EMTPY_TAG;
//		this.color = MyShape.COLOR_BLACK;
//		this.strokeType = ST_SOLID;
//		this.width = DEF_WIDTH;
//		this.distance = 0.0;
	}
	
	// �������� ������ü�� �����ϰ� ������ü�� �Է¹޾Ƽ� �� ��ü ����
	// ���� ��ü�� ������ ��� ��ǥ ���� 2���� �Է¹޾� ������ ���ο���
	// ������ü �ű� �����ϱ�
	public MyLine_backup3(int epx, int epy) {
		this(MyShape.ORIGIN_PT, new MyPoint(epx, epy));
//		this.sp = MyShape.ORIGIN_PT; // new MyPoint();
//		//this.ep = new MyPoint(epx, epy);
//		this.ep = new MyPoint(epx, epy,
//					"����", MyShape.COLOR_RED);
//		this.tag = DEF_LINE_TAG;//MyShape.EMTPY_TAG;
//		this.color = MyShape.COLOR_BLACK;
//		this.strokeType = ST_SOLID;
//		this.width = DEF_WIDTH;
//		this.distance = 0.0;
	}
	
	

	// �� �� ��ü���� �迭�� ��� �޾Ƽ� ����ü �ʱ�ȭ �ϱ�
	// !!! �ܺο��� new �ʱ�ȭ�� ���� �� �� ��ü�� �Է� ����.
	public MyLine_backup3(MyPoint[] pts) { // pts.length == 2 ����..
//		this(pts[0], pts[1], DEF_LINE_TAG, 
//				MyShape.COLOR_BLACK, ST_SOLID, 
//				DEF_WIDTH, 0.0);
		this(pts[0], pts[1]); // ������ ��ġ�� this() ������ ����??
		
		// pts�� null�� �ƴϰ�, pts.length >= == 2 ...
//		MyPoint psp = pts[0]; // null �ƴ�...
//		MyPoint pep = pts[1]; // null �ƴ�...
//		this.sp = psp;
//		this.ep = pep;
		//
//		this.sp = pts[0]; this.ep = pts[1];
//		this.tag = DEF_LINE_TAG;//MyShape.EMTPY_TAG;
//		this.color = MyShape.COLOR_BLACK;
//		this.strokeType = ST_SOLID;
//		this.width = DEF_WIDTH;
//		this.distance = 0.0;
	}
	
	// �� �� ��ü���� ���� �޾Ƽ� ����ü �ʱ�ȭ �ϱ�
	// !!! �ܺο��� new �ʱ�ȭ�� ���� �� �� ��ü�� �Է� ����.
	public MyLine_backup3(MyPoint sp, MyPoint ep) {
		this(sp, ep, DEF_LINE_TAG, 
				MyShape.COLOR_BLACK, MyShape.ST_SOLID, 
				MyShape.DEF_WIDTH, 0.0);
		// �� ����ü ��� ���� �ƴ϶�� �ϰ�..
//		this.sp = sp;
//		this.ep = ep;
//		this.tag = DEF_LINE_TAG;//MyShape.EMTPY_TAG;
//		this.color = MyShape.COLOR_BLACK;
//		this.strokeType = ST_SOLID;
//		this.width = DEF_WIDTH;
//		this.distance = 0.0;
	}
	
	// �� ���� ����� ���� ��ǥ���� 4���� ���� �޾Ƽ� ����ü �ʱ�ȭ �ϱ�
	// sp(x1,y1) => ep(x2,y2)
	// !!! ����ü�� ���� ���(����4��)�� �޾Ƽ�, ������ ���ο��� 
	// new �ʱ�ȭ�� ���� �����Ͽ� ������, ���� ��ü�� �����ؾ� ��.
	public MyLine_backup3(int x1, int y1, int x2, int y2) {
//		this.sp = new MyPoint(x1, y1);
//		this.ep = new MyPoint(x2, y2);
//		this.tag = DEF_LINE_TAG;//MyShape.EMTPY_TAG;
//		this.color = MyShape.COLOR_BLACK;
//		this.strokeType = ST_SOLID;
//		this.width = DEF_WIDTH;
//		this.distance = 0.0;
		// this. (������) ��ü �ڽ��� �ּҸ� ����Ŵ
		// this() ������ ȣ�� (���� ������ �� ��)
//		this.tag = "�տ���!";  // this() ������ �տ��� �ƹ��͵� ��������.
//		int x = 3; // this() ���� ó�� �����ؾ� ��.
//		this(new MyPoint(x1, y1), new MyPoint(x2, y2));
		this(new MyPoint(x1, y1), new MyPoint(x2, y2),
				DEF_LINE_TAG, MyShape.COLOR_BLACK,
				MyShape.ST_SOLID, MyShape.DEF_WIDTH, 0.0);
		// �ٸ� ������(���⼱  full ������)�� ȣ���Ͽ� �ڽ��� �ʱ�ȭ �۾���
		// "����"�Ѵ�. 
		this.tag += " ���ƿ�!"; 
	}	
	
	// Ǯ ������ (�ʱ�ȭ ������ �� �����ص� ������ ��¥ ������)
	public MyLine_backup3(MyPoint sp, MyPoint ep, String tag, String color, int strokeType, int width, double distance) {
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
		//this.tag
//		this(); // this() �����ڴ� ������ �Լ� �ȿ�����  ȣ���.
	}

	
}


