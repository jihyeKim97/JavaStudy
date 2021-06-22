package shape.d2.round;

import shape.MyShape;
import shape.basic.MyPoint;

/*
#### �� Circle ��Ű��
> shape.d2.round.MyCircle
> ������ �� ������ �����Ÿ��� �����ϰ� ������ ��� ������ 
  ������ 2���� ������ �����
- �߽��� 				MyPoint ptCenter  
- ������ 				double radius; 
- ���� �̸��±� ���ڿ� 	String tag
- �� ���� ������ ä���� �÷�	String color (RGB �÷��ڵ� 16���� ���ڿ�)
- ����: ����(����)		double area
- ����: �ѷ�(����) 		double perimeter
*/
public class MyCircle {
	public static final double PI = Math.PI; // ������
	public static final double DEF_R = 25.0;
	
	public MyPoint ptCenter;  
	public double radius; 
	public String tag;
	public String color; // (RGB �÷��ڵ� 16���� ���ڿ�)
	public double area; // PI * R * R
	public double perimeter; // 2 * PI * R
	
	// �ѷ� ����
	public double measurePerimeter() {
//		this.perimeter = 2 * PI * radius;
//		return perimeter;
		return (this.perimeter = 2 * PI * radius);
	}	
	// ���� ����
	public double measureArea() {
		this.area = PI * radius * radius; // Math.pow(radius,2.0)
		return area;
	}	
	
	public void printCircle() {
		System.out.println(this.toString());
	}
	
	@Override
	public String toString() {
		return "MyCircle �� [ptCenter=" + ptCenter + ", radius=" + radius + ", tag=" + tag + ", color=" + color + ", area="
				+ this.area + ", perimeter=" + perimeter + "]";
	}

	public MyCircle() {
		this(MyShape.ORIGIN_PT, DEF_R);
	}
	
	public MyCircle(int ptCX, int ptCY, double radius) {
		this(new MyPoint(ptCX, ptCY), radius);
	}
	
	public MyCircle(MyPoint ptCenter, double radius) {
		this(ptCenter, radius, 
				MyShape.EMTPY_TAG,
				MyShape.COLOR_BLACK,
				0.0, 0.0);
//		super();
//		this.ptCenter = ptCenter;
//		this.radius = radius;
	}

	public MyCircle(MyPoint ptCenter, double radius, 
			String tag, String color, double area, double perimeter) {
		super();
		this.ptCenter = ptCenter;
		this.radius = radius;
		this.tag = tag;
		this.color = color;
		this.area = area;
		this.perimeter = perimeter;
	}
	
	
}
