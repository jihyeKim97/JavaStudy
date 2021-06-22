package shape.main;
import shape.MyShape;
import shape.basic.MyPoint;
import shape.d1.MyLine;

public class ShapeMain2 {

	public static void main(String[] args) {		
		MyPoint pt = new MyPoint(100, -100); 
			// 4사분면? 반시계방향으로  
		//pt.printPoint();
		System.out.println(pt); // 객체의 내용을 문자열로 출력?
		// Object 최고 조상클래스의 toString()가 자동 호출됨..
//		System.out
//		 .println(pt.toString());
//		String test = "" + pt;
//		System.out.println(test);
	
	// 점 PT(100,-100) 태그: 없음[컬러: 000000] 
	
	// 선 테스트  // pt(100,-100) => pt2(200,200)
	MyLine ln1 = new MyLine(); // 더미 라인? 
	MyPoint pt2 = new MyPoint(200, 200);
//	MyLine ln2 = new MyLine(pt, pt2,
//			"학원에서 편의점CU 까지의 최단거리",
//			MyShape.COLOR_GREEN,
//			MyLine.ST_DOTTED,
//			MyLine.BOLD_WIDTH, 0.0);
//	ln1.printLine();
//	ln2.printLine();
  }
}
/* MyLine [sp=점 PT(100,-100) 태그: 없음[컬러: 000000] 
, ep=점 PT(200,200) 태그: 없음[컬러: 000000] 
, tag=학원에서 편의점CU 까지의 최단거리, color=00FF00,
 strokeType=1, width=2, distance=0.0]
*/


