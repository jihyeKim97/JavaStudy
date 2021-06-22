package shape.main;

import shape.MyShape;
import shape.basic.MyPoint;
import shape.d2.tri.MyTriangle;

public class ShapeMain6 {

	public static void main(String[] args) {
		MyPoint ptA = new MyPoint(0, 0, "�п�", MyShape.COLOR_RED);
		MyPoint ptB = new MyPoint(180, 20, "������û", MyShape.COLOR_GREEN);
		MyPoint ptC = new MyPoint(-200, -90, "���ٹ�", MyShape.COLOR_BLUE);
		MyPoint ptD = new MyPoint(-100, 80, "��ü��", MyShape.COLOR_PURPLE);
		
		MyTriangle ta1 = new MyTriangle(ptA, ptB, ptC);
		ta1.tag = "Ŀ�� ���ô� ����";
		//ta1.printTriange();
		ta1.measurePerimeter(); // ���� ����..
		System.out.println("Ŀ�� ���� �ﰢ�� �ѷ� ����: "
			+ ta1.getPerimeter() + "m");
		System.out.println("Ŀ�� ���� �ﰢ�� ���� ����: "
				+ ta1.getArea() + "m^2");
		
		MyPoint pts[] = { ptD, ptB, ptC };
		MyTriangle ta2 = new MyTriangle(pts);
		ta2.tag = "�����ϴ� ����";
		//ta2.printTriange();
		double peri = ta2.measurePerimeter(); // ���� ����..
		System.out.println("���� ���� �ﰢ�� �ѷ� ����: "
			+ peri + "m");
		System.out.println("���� ���� �ﰢ�� ���� ����: "
				+ ta2.getArea() + "m^2");		
		System.out.println("���� ���� �ﰢ�� ���� ����: "
			+ ta2.getArea()*0.000247 + " ac ����Ŀ");
		// 1���� ���� == 0.000247����Ŀ(ac)
		// https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=1%ED%8F%89
	}

}

/*
Ŀ�� ���� �ﰢ�� �ѷ� ����: 796.0256336544111m
Ŀ�� ���� �ﰢ�� ���� ����: 6099.999999999995m^2
���� ���� �ﰢ�� �ѷ� ����: 879.1880593957369m
���� ���� �ﰢ�� ���� ����: 26799.999999999996m^2
���� ���� �ﰢ�� ���� ����: 6.619599999999998 ac ����Ŀ

*/