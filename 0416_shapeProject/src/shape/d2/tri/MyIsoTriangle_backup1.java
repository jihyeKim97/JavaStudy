package shape.d2.tri;
/*
#### MyIsoTriangle �̵�ﰢ�� (isosceles ��üȭ �ﰢ��1)
> shape.d2.tri.MyIsoTriangle Ŭ���� (MyTriangle �ڽ�/����/�Ļ� Ŭ����)
> 2���� ����(��)�� ���̰� �����ϴٴ� �������� (Ư��)
- �ڽ��� ������ ǥ���ϴ� String shapeType "�̵ �ﰢ��"
*/

import shape.basic.MyPoint;

// ��� ���� ���ó���� �ſ� �ٸ�... �ڹٴ� ���� OOP�� ���� ���� ��Ӹ� ���� ������.
// ��, �ڽ� Ŭ������ ���� �� �ϳ��� �θ� Ŭ�������� ���� �� �ֽ��ϴ�. 
// x public class MyIsoTriangle  extends MyTriangle, MyRectangle {
public class MyIsoTriangle_backup1 extends MyTriangle {
	public String shapeType;// "�̵ �ﰢ��"
	public MyIsoTriangle_backup1() {
		//super(); // ������ ������.
		this.shapeType = "�̵ �ﰢ��"; 
	}
	public MyIsoTriangle_backup1(MyPoint ptA, 
			MyPoint ptB, MyPoint ptC) {
		// this. ��ü �ڽ� �ȿ� �ִ� �ʵ�/�޼ҵ� ����
		// this() �ٸ� �����ڸ� ȣ���Ͽ� �ʱ�ȭ ����
		//this.shapeType; // �ڽ� ��ü���� ��
		//super.shapeType; // �ڽ� Ŭ�������̰�, �θ� Ŭ�������� �ƴ϶�..
		//super(); // �θ�Ŭ����  MyTriangle() ������ ȣ��..
		//super(); // �ڵ�ȣ��..
		super(ptA, ptB, ptC); 
			// �θ�Ŭ������ �����ִ� ��� �ʵ� �ʱ�ȭ�� ���� ����
			// �θ�Ŭ����  MyTriangle(ptA, ptB, ptC) ������ ȣ��..
		this.shapeType = "�̵ �ﰢ��"; // �ڽ�Ŭ���� �ʵ常 ������ �ʱ�ȭ
		
		//this.getLnAB()??
		//super(ptA, ptB, ptC); // �θ�Ŭ������ �����ڸ� ȣ���Ͽ� �ʱ�ȭ.
	}
}
