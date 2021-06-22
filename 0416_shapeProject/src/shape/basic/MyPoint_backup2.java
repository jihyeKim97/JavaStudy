package shape.basic;

import shape.MyShape;

/*
### �� Point ��Ű�� 
> shape.basic.MyPoint Ŭ����
> 2���� ��ǥ�� ��� ���� �� ��(Ư�� ��ġ)���� ��ǥ������ ǥ�� (x,y)
- ������ ���� ��ġ x ����		int x
- ������ ���� ��ġ y ����		int y
- ���� �̸��±� ���ڿ� 		String tag
- ���� ����ǥ�����ν��� �÷�		String color (RGB �÷��ڵ� 16���� ���ڿ�)
	// ���߿��� MyColor Ŭ������ ǥ�� ���� 
 */
public class MyPoint_backup2 {
	// ��� �ʵ�
	public static final String TYPE = "�� PT";
	public static final String DEF_TAG = "����";
	public static final String ORIGIN_TAG = "����";
	public static final String DEF_COLOR = MyShape.COLOR_BLACK;  
				//"000000";
	// ���� �ʵ�
	public int		x;
	public int	 	y;
	public String	tag;
	public String 	color;
	// �����ڵ�
	//public MyPoint() {} // ���� ��ü
//	public MyPoint() {
//		this.x = 0; 
//		this.y = 0;
//		this.tag = null;
//		this.color = null;
//	} // ���� ��ü
	public MyPoint_backup2() {
		this.x = 0; 
		this.y = 0;
		this.tag = ORIGIN_TAG;
		this.color = DEF_COLOR; // black 0x000000
	} // ���� ��ü	
	
	// �߰� �����ڵ�
	// ���� �ִ� ���� �� ��ǥ����...
	public MyPoint_backup2(int x, int y) {
		this.x = x; 
		this.y = y;
		this.tag = MyShape.EMTPY_TAG;  // "";
		this.color = MyShape.COLOR_BLACK;
	}
	
	// axis �� �� ��ġ�� ���� x, y �� �� �ϳ��� 0��.
	// ������ x-axis �� ���� true�� ����..
	public MyPoint_backup2( int p, boolean isXAxis ) {
		if( isXAxis ) { // == true )
			this.x = p; this.y = 0;
		} // y�� ���� ��... 
		else {
			this.y = p; this.x = 0; // ������ ���� ��..
		}
		this.tag = MyShape.EMTPY_TAG;  // "";
		this.color = MyShape.COLOR_BLACK;
	}
	
	// ���� copy, clone ������ (����ü�� �̿��Ͽ� ����ü�� �ʱ�ȭ)
	public MyPoint_backup2( MyPoint_backup2 pt ) {
		this.x = pt.x;
		this.y = pt.y;
		this.tag = pt.tag;
		this.color = pt.color;
		System.out.println(pt+"�� ���� �Ϸ���..");
	}
	
	// vector�� ���� ǥ������.. 
	// (��ǥ���� �ƴ϶� ���� ���� ����(����), ũ��(�Ÿ�)�� �� �����ڸ� ���� 
	public MyPoint_backup2( double angle, double distance ) {
		// ?
	}
	
	// full ������
	public MyPoint_backup2(int x, int y, String tag, String color) {
		//super(); // ��������
		this.x = x;
		this.y = y;
		//this.tag = tag;
		if( tag != null ) this.tag = tag;
		else this.tag = "";
		
		//this.color = color;
		this.color = color != null ? color : DEF_COLOR;
	}
	
	
	// �޼ҵ�
	public void printPoint() {
		System.out.printf("%s(%d,%d) �±�: %s[�÷�: %s] \n",
				TYPE, this.x, this.y, 
			tag == null || tag.isEmpty() ? DEF_TAG: tag
				, color);
	}
//	public void printPoint() {
//		System.out.printf("%s(%d,%d) \n", TYPE, 
//				this.x, this.y);
//	}



}


