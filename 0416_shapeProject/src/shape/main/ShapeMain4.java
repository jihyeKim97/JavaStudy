package shape.main;

import shape.MyShape;
import shape.basic.MyPoint;
import shape.d1.MyLine;

public class ShapeMain4 {

	public static void main(String[] args) {
		MyLine ln1 = 
				new MyLine(20, 10, 500, -150);
		ln1.tag = "��ȭ���� 5���ⱸ���� �̼����屺 ��������� ���";
		//ln1.sp; // �Ⱥ���, ���� �Ұ����� �ʵ�? private
		MyPoint sp = ln1.getStartPoint();
		MyPoint ep = ln1.getEp(); // ���� �޼ҵ�� ����.
		System.out.println(sp.toString());
		System.out.println(ep); // toString()
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
		ln1.updateStartPoint(
				new MyPoint(-20, -38, 
					"��ȭ���� 3���ⱸ", MyShape.COLOR_RED));
		ln1.printLine();
		
		//ln1.distance // err
		double path1 = ln1.getDistance();
		// �Ÿ��� ������ 1.0 �������� ���͹� 1���� �����ϴ� ô�� (scale)
		System.out.printf(">> ��� '%s'�� �Ÿ�: %.2fm �Դϴ�.\n",
				ln1.tag, ln1.getDistance());
	}

}

/*
�� PT(20,10) �±�: ����[�÷�: 000000] 

�� PT(500,-150) �±�:  ��ȭ���� 5���ⱸ���� �̼����屺 ��������� ��� ����ü�� ����[�÷�: 000000] 

~~~~~~~~~~~~~~~~~~~~~~
MyLine [sp=�� PT(-20,-38) �±�: ��ȭ���� 3���ⱸ[�÷�: FF0000] 
, ep=�� PT(500,-150) �±�:  ��ȭ���� 5���ⱸ���� �̼����屺 ��������� ��� ����ü�� ����[�÷�: 000000] 
, tag=��ȭ���� 5���ⱸ���� �̼����屺 ��������� ���, color=000000, strokeType=0, width=1, distance=531.9248067161373]
>> ��� '��ȭ���� 5���ⱸ���� �̼����屺 ��������� ���'�� �Ÿ�: 531.92m �Դϴ�.
*/