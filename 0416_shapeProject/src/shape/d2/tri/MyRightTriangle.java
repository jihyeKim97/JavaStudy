package shape.d2.tri;
/*
#### MyRightTriangle �����ﰢ�� (��üȭ �ﰢ��3)
> shape.d2.tri.MyRightTriangle Ŭ����
> �� �ϳ��� ���� 90 PI/2 �̸��...(��üȭ�� Ư��)
- �ڽ��� ������ ǥ���ϴ� String shapeType "���� �ﰢ��" 
 */
public class MyRightTriangle extends MyTriangle2 {
	private boolean isRightTriangle() {
		// > �� �ϳ��� ���� 90 PI/2 �̸��...(��üȭ�� Ư��)
		// || �� Ȥ��... 3 ���� �߿��� �� �ϳ��� 90���... ���� �ﰢ��..
		return false;
	}
}
