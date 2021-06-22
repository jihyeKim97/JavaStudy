package shape.d2.tri;

import shape.MyShape;
import shape.basic.MyPoint;
import shape.d1.MyLine;

/*
##### MyTriange ��Ű�� (�Ϲݻﰢ��)
> shape.d2.tri.MyTriangle Ŭ����
> 2���� ���󿡼� 3���� ������ �����, Ȥ�� ������ ���� �̾����� ����� ��� ����Ǵ� ����� ����. 
- ��(vertex ������) 3��     	MyPoint a, b, c;
- ��(line ����) 3��		MyLine ab, bc, ca;
- �ﰢ���� �̸��±� ���ڿ� 		String tag
- �ﰢ�� ���� ������ ä���� �÷�	String color (RGB �÷��ڵ� 16���� ���ڿ�)
- ����: ���� (����) double area;
- ����: �ѷ� (���� = ��� ���е��� ������ ����) double perimeter; 
- ����: ������ (���а� ���� ������ ����, degree, radian; 
	���� AB�� ���� BC ������ ����) double angleAB_BC; 
 */
public class MyTriangle_backup1 {
	// �ʵ�
	public static final String TYPE = "�ﰢ�� TA";
	private MyPoint ptA; // ������ A ~ C
	private MyPoint ptB;
	private MyPoint ptC;
	private MyLine lnAB; // ptA-ptB �����ϴ� ����
	private MyLine lnBC; // ptB-ptC �����ϴ� ����
	private MyLine lnCA; // ptC-ptA �����ϴ� ����
	public String tag;
	public String color;
	private double area; // ����
	private double perimeter; // �ѷ�
	private double angleCA_AB; // A�� ����
	private double angleAB_BC; // B�� ����
	private double angleBC_CA; // C�� ����
	
	// ���� ������
	public MyTriangle_backup1() {
	
	}

	// �߰� �����ڵ�
	public MyTriangle_backup1(MyPoint ptA, MyPoint ptB, MyPoint ptC,
			MyLine lnAB, MyLine lnBC, MyLine lnCA) {
//		this(ptA, ptB, ptC, lnAB, lnBC, lnCA, 
//			MyShape.EMTPY_TAG, MyShape.COLOR_BLACK,
//			0.0, 0.0, 0.0, 0.0, 0.0);
		this(ptA, ptB, ptC, lnAB, lnBC, lnCA, 
				MyShape.EMTPY_TAG, MyShape.COLOR_BLACK);
	}
	
	public MyTriangle_backup1(MyPoint ptA, MyPoint ptB, MyPoint ptC,
			MyLine lnAB, MyLine lnBC, MyLine lnCA,
			String tag,	String color) {
		this(ptA, ptB, ptC, lnAB, lnBC, lnCA, tag, color,
			0.0, 0.0, 0.0, 0.0, 0.0);
//		super();
//		this.ptA = ptA;
//		this.ptB = ptB;
//		this.ptC = ptC;
//		this.lnAB = lnAB;
//		this.lnBC = lnBC;
//		this.lnCA = lnCA;
//		this.tag = tag;
//		this.color = color;
	}
		
	// Ǯ ������
	public MyTriangle_backup1(MyPoint ptA, MyPoint ptB, MyPoint ptC, MyLine lnAB, MyLine lnBC, MyLine lnCA, String tag,
			String color, double area, double perimeter, double angleCA_AB, double angleAB_BC, double angleBC_CA) {
//		super();
		this.ptA = ptA;
		this.ptB = ptB;
		this.ptC = ptC;
		this.lnAB = lnAB;
		this.lnBC = lnBC;
		this.lnCA = lnCA;
		this.tag = tag;
		this.color = color;
		this.area = area;
		this.perimeter = perimeter;
		this.angleCA_AB = angleCA_AB;
		this.angleAB_BC = angleAB_BC;
		this.angleBC_CA = angleBC_CA;
	}
	
//	@Override
	public String toString() {
		return "MyTriangle [ptA=" + ptA + ", ptB=" + ptB + ", ptC=" + ptC + ", lnAB=" + lnAB + ", lnBC=" + lnBC
				+ ", lnCA=" + lnCA + ", tag=" + tag + ", color=" + color + ", area=" + area + ", perimeter=" + perimeter
				+ ", angleCA_AB=" + angleCA_AB + ", angleAB_BC=" + angleAB_BC + ", angleBC_CA=" + angleBC_CA + "]";
	}

	public void printTriange() {
		System.out.println(TYPE + " " +this.toString());
	}
	
}
