package shape.main;
import shape.MyShape;
import shape.basic.MyPoint;
import shape.d1.MyLine;

public class ShapeMain2 {

	public static void main(String[] args) {		
		MyPoint pt = new MyPoint(100, -100); 
			// 4��и�? �ݽð��������  
		//pt.printPoint();
		System.out.println(pt); // ��ü�� ������ ���ڿ��� ���?
		// Object �ְ� ����Ŭ������ toString()�� �ڵ� ȣ���..
//		System.out
//		 .println(pt.toString());
//		String test = "" + pt;
//		System.out.println(test);
	
	// �� PT(100,-100) �±�: ����[�÷�: 000000] 
	
	// �� �׽�Ʈ  // pt(100,-100) => pt2(200,200)
	MyLine ln1 = new MyLine(); // ���� ����? 
	MyPoint pt2 = new MyPoint(200, 200);
//	MyLine ln2 = new MyLine(pt, pt2,
//			"�п����� ������CU ������ �ִܰŸ�",
//			MyShape.COLOR_GREEN,
//			MyLine.ST_DOTTED,
//			MyLine.BOLD_WIDTH, 0.0);
//	ln1.printLine();
//	ln2.printLine();
  }
}
/* MyLine [sp=�� PT(100,-100) �±�: ����[�÷�: 000000] 
, ep=�� PT(200,200) �±�: ����[�÷�: 000000] 
, tag=�п����� ������CU ������ �ִܰŸ�, color=00FF00,
 strokeType=1, width=2, distance=0.0]
*/


