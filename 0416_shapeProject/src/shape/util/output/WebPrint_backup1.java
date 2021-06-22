package shape.util.output;
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
public class WebPrint_backup1 {
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
	
	public static void main(String[] args) {
		printDummyTriangle();
	}
	
	

}
