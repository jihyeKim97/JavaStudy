package shape.util.output;
/*
## Util ��ƿ��Ƽ Ŭ����
> ���� ���� ��ɵ�...
### ���  shape.util.output
> shape.util.output.WebPrint  (HTML/canvas)

 Shape �������� ��ü�� �ϳ� �ԷµǸ� web ������, �� 
 html ������ ���� ĵ����(Canvas) ������...
  �ش� ���� ��ü�� �׷��� ��ҷν� ���(������)�ϴ� ��� Ŭ����
  
  ** ������ ��� firefox (mozilla)
  https://developer.mozilla.org/ko/docs/Web/HTML/Canvas/Tutorial/Basic_usage
  https://developer.mozilla.org/ko/docs/Web/API/Canvas_API/Tutorial/Drawing_shapes
  // �ڹٽ�ũ��Ʈ 
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
		<title> ������ ���� </title>
	</head>
	<body> 
		<h1>�� ����(page)�� ����</h1>
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
		"		<title> ���� �׸��� Test </title>\r\n" + 
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
		"		<h1>���� �ﰢ�� ĵ������ ǥ��</h1>\r\n" + 
		"		<canvas id=\"canvas\" \r\n" + 
		"		  width='1200' height='880' ></canvas>\r\n" + 
		"	</body>\r\n" + 
		"</html>";
	
	// dummy �ﰢ�� 
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
