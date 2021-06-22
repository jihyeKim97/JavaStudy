package shape.util.output;

import shape.MyShape;
import shape.basic.MyPoint;
import shape.d1.MyLine;
import shape.d2.round.MyCircle;
import shape.d2.tri.MyTriangle;

/*
## Util 유틸리티 클래스
> 도형 보조 기능들...
### 출력  shape.util.output
> shape.util.output.WebPrint  (HTML/canvas)

 Shape 도형류의 객체가 하나 입력되면 web 페이지, 즉 
 html 페이지 상의 캔버스(Canvas) 영역에...
  해당 도형 객체를 그래픽 요소로써 출력(렌더링)하는 기능 클래스
  
  ** 모질라 재단 firefox (mozilla)
  https://developer.mozilla.org/ko/docs/Web/HTML/Canvas/Tutorial/Basic_usage
  https://developer.mozilla.org/ko/docs/Web/API/Canvas_API/Tutorial/Drawing_shapes
  // 자바스크립트 
	function draw() {
	  var canvas = document.getElementById('canvas');
	  if (canvas.getContext) {
	    var ctx = canvas.getContext('2d');
	
	    ctx.beginPath();
	    ctx.moveTo(75, 50);
	    ctx.lineTo(100, 75);
	    ctx.lineTo(100, 25);
	    ctx.fill();
	  }
	}  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR" />
		<title> 문서의 제목 </title>
	</head>
	<body> 
		<h1>웹 문서(page)의 내용</h1>
		<hr>	
	</body>
</html>
*/
public class WebPrint {
	public static final String HEAD 
		= "<!DOCTYPE html>\r\n" + 
		"<html>\r\n" + 
		"	<head>\r\n" + 
		"		<meta charset=\"EUC-KR\" />\r\n" + 
		"		<title> 도형 그리기 Test </title>\r\n" + 
		"		<script type=\"application/javascript\">\r\n" + 
		"			function draw() {\r\n" + 
		"			  var canvas = document.getElementById('canvas');\r\n" + 
		"			  if (canvas.getContext) {\r\n" + 
		"			    var ctx = canvas.getContext('2d');";
	
	public static final String TAIL
		= "}\r\n" + 
		"			}\r\n" + 
		"		</script>\r\n" + 
		"	</head>\r\n" + 
		"	<body onload='draw();'> \r\n" + 
		"		<h1>도형 삼각형 캔버스에 표시</h1>\r\n" + 
		"		<canvas id=\"canvas\" \r\n" + 
		"		  width='1200' height='880' ></canvas>\r\n" + 
		"	</body>\r\n" + 
		"</html>";
	
	public static final String TAIL2
	= "}\r\n" + 
		"			}\r\n" + 
		"		</script>\r\n" + 
		"	</head>\r\n" + 
		"	<body onload='draw();'> \r\n" + 
		"		<h1>도형: %s</h1>\r\n" + 
		"		<canvas id=\"canvas\" \r\n" + 
		"		  width='1200' height='880' ></canvas>\r\n" + 
		"	</body>\r\n" + 
		"</html>";
	
	// dummy 삼각형 
	public static void printDummyTriangle() {
		String dummy = "ctx.beginPath();\r\n" + 
		"			    ctx.moveTo(75, 150);\r\n" + 
		"			    ctx.lineTo(100, 300);\r\n" + 
		"			    ctx.lineTo(200, 525);\r\n" + 
		"			    ctx.fill();";
		System.out.println(HEAD);
		System.out.println(dummy);
		System.out.println(TAIL);
	}
	
	// 임의의 Shape::MyTriangle 입력받아서 fill 삼각형 출력  
	public static void printMyTriangle(MyTriangle tr) {
		MyPoint ptA = tr.getPtA();
		MyPoint ptB = tr.getPtB();
		MyPoint ptC = tr.getPtC();
		String dummy = "ctx.beginPath();\r\n" + 
		"	    ctx.moveTo("+ptA.x+", "+ptA.y+");\r\n" + 
		"	    ctx.lineTo("+ptB.x+", "+ptB.y+");\r\n" + 
		"	    ctx.lineTo("+ptC.x+", "+ptC.y+");\r\n" + 
		"	    ctx.fill();";
		System.out.println(HEAD);
		System.out.println(dummy);
		//System.out.println(TAIL);
		System.out.printf(TAIL2, 
				tr.tag == null || tr.tag.isEmpty()
				? "삼각형" : tr.tag
			);
	}	
	
	// 임의의 Shape::MyTriangle 입력받아서 스타일로 stroke 삼각형 출력
	// https://developer.mozilla.org/ko/docs/Web/API/Canvas_API/Tutorial/Applying_styles_and_colors
	public static void printMyTriangleWithStyle(MyTriangle tr) {
		MyPoint ptA = tr.getPtA();
		MyPoint ptB = tr.getPtB();
		MyPoint ptC = tr.getPtC();
		String lnColor = tr.color; // tr.getLnAB().color;
		//String dummy = "ctx.beginPath();\r\n" +
		//String dummy = "ctx.strokeStyle = '#000000';";
		String dummy = "ctx.strokeStyle = '#"+lnColor +"';\r\n" +
		"    ctx.lineWidth = "+tr.getLnAB().width +";\r\n" +
		"    ctx.moveTo("+ptA.x+", "+ptA.y+");\r\n" + 
		"    ctx.lineTo("+ptB.x+", "+ptB.y+");\r\n" + 
		"    ctx.lineTo("+ptC.x+", "+ptC.y+");\r\n" +
		"    ctx.lineTo("+ptA.x+", "+ptA.y+");\r\n" +
		"    ctx.stroke();";
//		"    ctx.fill();";
		System.out.println(HEAD);
		System.out.println(dummy);
		//System.out.println(TAIL);
		System.out.printf(TAIL2, 
				tr.tag == null || tr.tag.isEmpty()
				? "삼각형" : tr.tag
			);
	}
	
	public static void 
		printMyTriangleWithStyle(
				MyTriangle tr, boolean black) {
		MyPoint ptA = tr.getPtA();
		MyPoint ptB = tr.getPtB();
		MyPoint ptC = tr.getPtC();
		String lnColor = black ? 
				MyShape.COLOR_BLACK: tr.color; // tr.getLnAB().color;
		//String dummy = "ctx.beginPath();\r\n" +
		//String dummy = "ctx.strokeStyle = '#000000';";
		String dummy = "ctx.strokeStyle = '#"+lnColor +"';\r\n" +
		"    ctx.lineWidth = "+tr.getLnAB().width +";\r\n" +
		"    ctx.moveTo("+ptA.x+", "+ptA.y+");\r\n" + 
		"    ctx.lineTo("+ptB.x+", "+ptB.y+");\r\n" + 
		"    ctx.lineTo("+ptC.x+", "+ptC.y+");\r\n" +
		"    ctx.lineTo("+ptA.x+", "+ptA.y+");\r\n" +
		"    ctx.stroke();";
		
		dummy += " ctx.font = '24px Serif';";
		//dummy += " ctx.fillText('Triangle', 100, 200);";		
		dummy += 
			" ctx.fillText('Triangle', "
					+tr.getPtC().x+"+20, "
					+tr.getPtC().y+"+20);";
		String fmtArea = String.format("%.2f p^2", tr.getArea());
		dummy += 
		//" ctx.fillText('     area: "+ tr.getArea() +" ', "
		" ctx.fillText('     area: "+ fmtArea +" ', "
						+tr.getPtC().x+"+20, "
						+tr.getPtC().y+"+50);";
		String fmtPeri = String.format("%.2f p", tr.getPerimeter());
		dummy += 
		" ctx.fillText('     perimeter: "+ fmtPeri +"', "
						+tr.getPtC().x+"+20, "
						+tr.getPtC().y+"+80);";

		System.out.println(HEAD);
		System.out.println(dummy);
		//System.out.println(TAIL);
		System.out.printf(TAIL2, 
				tr.tag == null || tr.tag.isEmpty()
				? "삼각형" : tr.tag
			);
	}	
	
	
	// 선객체 하나 받아서 html 출력
	public static void 
		printMyLine(MyLine ln, boolean black) {
		MyPoint ptS = ln.getStartPoint();
		MyPoint ptE = ln.getEp();
		
		String lnColor = black ? 
				MyShape.COLOR_BLACK: ln.color; 
		String dummy = "ctx.strokeStyle = '#"+lnColor +"';\r\n" +
		"    ctx.lineWidth = "+ln.width +";\r\n" +
		"    ctx.moveTo("+ptS.x+", "+ptS.y+");\r\n" + 
		"    ctx.lineTo("+ptE.x+", "+ptE.y+");\r\n" +
		"    ctx.stroke();";
		
		dummy += " ctx.font = '24px Serif';";
		//dummy += " ctx.fillText('Triangle', 100, 200);";		
		dummy += 
			" ctx.fillText('Line', "
					+ptE.x+"+20, "+ptE.y+"+20);";
		String fmtDist = String.format("%.2f cm",
					ln.getDistance());
		dummy += 
			" ctx.fillText('     distance: "+ fmtDist +" ', "
				+ptE.x+"+20, "	+ptE.y+"+50);";		
	
		System.out.println(HEAD);
		System.out.println(dummy);
		System.out.printf(TAIL2, 
				ln.tag == null || ln.tag.isEmpty()
				? "선" : ln.tag
			);
	}	
	
	
	// 원객체 하나 받아서 html 출력
	public static void 
		printMyCircle(MyCircle cc, boolean black, int width) {
		MyPoint ptC = cc.ptCenter;
		
		
		String lnColor = black ? 
				MyShape.COLOR_BLACK: cc.color; 
		String dummy = "ctx.strokeStyle = '#"+cc.color+"';\r\n" +
		"    ctx.lineWidth = "+width +";\r\n" +
		"    ctx.arc("+ptC.x +"," +ptC.y +","
			+ cc.radius + ", 0.0, Math.PI * 2, true);\r\n" + 
		"    ctx.stroke();";
		
		dummy += " ctx.font = '24px Serif';";
		dummy += 
			" ctx.fillText('Circle', "
					+ptC.x+"+20, "+ptC.y+"+20);";
		String fmtArea = String.format("%.2f ^m",
					cc.area);
		dummy += 
			" ctx.fillText('     Area: "+ fmtArea +" ', "
				+(ptC.x+cc.radius)+"+20, "
				+ptC.y+"+20);";	
		System.out.println(HEAD);
		System.out.println(dummy);
		System.out.printf(TAIL2, 
				cc.tag == null || cc.tag.isEmpty()
				? "원" : cc.tag
			);
	}	
		
	
	public static void main(String[] args) {
//		printDummyTriangle();
//		MyTriangle tr1 = 
//			new MyTriangle(200, 100, 
//					400, 340, 300, 60);
//		tr1.tag = "재욱씨 삼각형";
//		printMyTriangle(tr1);
		
//		MyTriangle tr2 = 
//			new MyTriangle(200, 20, 
//					400, 20, 300, 160);
//		tr2.measurePerimeter(); 
//		tr2.tag = "규진씨 삼각형3";
//		//tr2.color = "FF8826";// MyShape.COLOR_CYAN;
//		tr2.color = MyShape.COLOR_YELLOW;
//		MyLine ln = tr2.getLnAB();
//		ln.width = MyShape.BOLDER_WIDTH; // 4;
////		printMyTriangleWithStyle(tr2);
//		//printMyTriangleWithStyle(tr2, true); // BK
//		printMyTriangleWithStyle(tr2, false);
		
//		MyLine ln = new MyLine(
//				new MyPoint(40,20), 
//				new MyPoint(600, 440), "diagonal line");
//		ln.color = MyShape.COLOR_BLUE;
//		printMyLine(ln, false);

		MyCircle cc = new MyCircle(300, 300, 150.0);
		cc.measureArea();
		cc.tag = "last 원";
		cc.color = MyShape.COLOR_PURPLE;
		printMyCircle(cc, false, MyShape.BOLD_WIDTH);
		
	}
	
	

}
