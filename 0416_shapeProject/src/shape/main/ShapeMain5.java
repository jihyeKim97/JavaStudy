package shape.main;

import shape.MyShape;
import shape.basic.MyPoint;
import shape.d2.tri.MyTriangle;

public class ShapeMain5 {

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
		
		MyPoint pts[] = { ptD, ptB, ptC };
		MyTriangle ta2 = new MyTriangle(pts);
		ta2.tag = "�����ϴ� ����";
		//ta2.printTriange();
		double peri = ta2.measurePerimeter(); // ���� ����..
		System.out.println("���� ���� �ﰢ�� �ѷ� ����: "
			+ peri + "m");
	}

}

/*
�ﰢ�� TA MyTriangle [ptA=�� PT(0,0) �±�: �п�[�÷�: FF0000] 
, ptB=�� PT(180,20) �±�: ������û[�÷�: 00FF00] 
, ptC=�� PT(-200,-90) �±�: ���ٹ�[�÷�: 0000FF] 
, lnAB=MyLine [sp=�� PT(0,0) �±�: �п�[�÷�: FF0000] 
, ep=�� PT(180,20) �±�: ������û[�÷�: 00FF00] 
, tag=�ﰢ�� ���� AB, color=000000, strokeType=0, width=1, distance=181.10770276274835], lnBC=MyLine [sp=�� PT(180,20) �±�: ������û[�÷�: 00FF00] 
, ep=�� PT(-200,-90) �±�: ���ٹ�[�÷�: 0000FF] 
, tag=�ﰢ�� ���� BC, color=000000, strokeType=0, width=1, distance=395.60080889704966], lnCA=MyLine [sp=�� PT(-200,-90) �±�: ���ٹ�[�÷�: 0000FF] 
, ep=�� PT(0,0) �±�: �п�[�÷�: FF0000] 
, tag=�ﰢ�� ���� CA, color=000000, strokeType=0, width=1, distance=219.31712199461307], tag=Ŀ�� ���ô� ����, color=000000, area=0.0m^2 ����, perimeter=0.0m �ѷ�, angleCA_AB=0.0�� ����, angleAB_BC=0.0�� ����, angleBC_CA=0.0�� ����]
�ﰢ�� TA MyTriangle [ptA=�� PT(-100,80) �±�: ��ü��[�÷�: FF00FF] 
, ptB=�� PT(180,20) �±�: ������û[�÷�: 00FF00] 
, ptC=�� PT(-200,-90) �±�: ���ٹ�[�÷�: 0000FF] 
, lnAB=MyLine [sp=�� PT(-100,80) �±�: ��ü��[�÷�: FF00FF] 
, ep=�� PT(180,20) �±�: ������û[�÷�: 00FF00] 
, tag=�ﰢ�� ���� AB, color=000000, strokeType=0, width=1, distance=286.35642126552705], lnBC=MyLine [sp=�� PT(180,20) �±�: ������û[�÷�: 00FF00] 
, ep=�� PT(-200,-90) �±�: ���ٹ�[�÷�: 0000FF] 
, tag=�ﰢ�� ���� BC, color=000000, strokeType=0, width=1, distance=395.60080889704966], lnCA=MyLine [sp=�� PT(-200,-90) �±�: ���ٹ�[�÷�: 0000FF] 
, ep=�� PT(-100,80) �±�: ��ü��[�÷�: FF00FF] 
, tag=�ﰢ�� ���� CA, color=000000, strokeType=0, width=1, distance=197.2308292331602], tag=�����ϴ� ����, color=000000, area=0.0m^2 ����, perimeter=0.0m �ѷ�, angleCA_AB=0.0�� ����, angleAB_BC=0.0�� ����, angleBC_CA=0.0�� ����]

*/