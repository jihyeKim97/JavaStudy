package shape.main;

import shape.basic.MyPoint;
import shape.d2.tri.MyIsoTriangle;
import shape.d2.tri.MyTriangle;
import shape.d2.tri.MyTriangle2;

public class ShapeMain8 {

	public static void main(String[] args) {
//		MyIsoTriangle isoTr = new MyIsoTriangle();
//		isoTr.setPtA(new MyPoint());
//		isoTr.setPtB(new MyPoint(80, 0));
//		isoTr.setPtC(new MyPoint(0, 80));		
//		isoTr.printTriange(); // ����
		
		MyIsoTriangle isoTr2 
			= new MyIsoTriangle(new MyPoint(), 
					new MyPoint(80, 0), new MyPoint(0, 80));
				//new MyPoint(300, 10), new MyPoint(0, 80));
		isoTr2.measurePerimeter();
		isoTr2.getArea();
		isoTr2.getAngleCA_AB();
//		isoTr2.printTriange();
//		System.out.println(isoTr2.toString()); 
//		System.out.println(isoTr2); // toString() �ڵ�ȣ��
		isoTr2.printIsoTriangle();
		
//		MyTriangle2 test = new MyTriangle2();
//		test. // �����ؼ��̶� �Ⱥ���..
	}

}

/*
�ﰢ�� TA MyIsoTriangle [shapeType=�̵ �ﰢ��, ptA=�� PT(0,0) �±�: ����[�÷�: 000000] 
, ptB=�� PT(80,0) �±�: ����[�÷�: 000000] 
, ptC=�� PT(0,80) �±�: ����[�÷�: 000000] 
, lnAB=MyLine [sp=�� PT(0,0) �±�: ����[�÷�: 000000] 
, ep=�� PT(80,0) �±�: ����[�÷�: 000000] 
, tag=�ﰢ�� ���� AB, color=000000, strokeType=0, width=1, distance=80.0], lnBC=MyLine [sp=�� PT(80,0) �±�: ����[�÷�: 000000] 
, ep=�� PT(0,80) �±�: ����[�÷�: 000000] 
, tag=�ﰢ�� ���� BC, color=000000, strokeType=0, width=1, distance=113.13708498984761], lnCA=MyLine [sp=�� PT(0,80) �±�: ����[�÷�: 000000] 
, ep=�� PT(0,0) �±�: ����[�÷�: 000000] 
, tag=�ﰢ�� ���� CA, color=000000, strokeType=0, width=1, distance=80.0], tag=, color=000000]

�ﰢ�� TA MyIsoTriangle [shapeType=�̵ �ﰢ�� ��ǰ����? ��¥!, ptA=�� PT(0,0) �±�: ����[�÷�: 000000] 
, ptB=�� PT(300,10) �±�: ����[�÷�: 000000] 
, ptC=�� PT(0,80) �±�: ����[�÷�: 000000] 
, lnAB=MyLine [sp=�� PT(0,0) �±�: ����[�÷�: 000000] 
, ep=�� PT(300,10) �±�: ����[�÷�: 000000] 
, tag=�ﰢ�� ���� AB, color=000000, strokeType=0, width=1, distance=300.1666203960727], lnBC=MyLine [sp=�� PT(300,10) �±�: ����[�÷�: 000000] 
, ep=�� PT(0,80) �±�: ����[�÷�: 000000] 
, tag=�ﰢ�� ���� BC, color=000000, strokeType=0, width=1, distance=308.05843601498725], lnCA=MyLine [sp=�� PT(0,80) �±�: ����[�÷�: 000000] 
, ep=�� PT(0,0) �±�: ����[�÷�: 000000] 
, tag=�ﰢ�� ���� CA, color=000000, strokeType=0, width=1, distance=80.0], tag=, color=000000]

*/