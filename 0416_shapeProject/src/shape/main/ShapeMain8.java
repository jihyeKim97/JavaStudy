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
//		isoTr.printTriange(); // 에러
		
		MyIsoTriangle isoTr2 
			= new MyIsoTriangle(new MyPoint(), 
					new MyPoint(80, 0), new MyPoint(0, 80));
				//new MyPoint(300, 10), new MyPoint(0, 80));
		isoTr2.measurePerimeter();
		isoTr2.getArea();
		isoTr2.getAngleCA_AB();
//		isoTr2.printTriange();
//		System.out.println(isoTr2.toString()); 
//		System.out.println(isoTr2); // toString() 자동호출
		isoTr2.printIsoTriangle();
		
//		MyTriangle2 test = new MyTriangle2();
//		test. // 프로텍션이라 안보임..
	}

}

/*
삼각형 TA MyIsoTriangle [shapeType=이등변 삼각형, ptA=점 PT(0,0) 태그: 원점[컬러: 000000] 
, ptB=점 PT(80,0) 태그: 없음[컬러: 000000] 
, ptC=점 PT(0,80) 태그: 없음[컬러: 000000] 
, lnAB=MyLine [sp=점 PT(0,0) 태그: 원점[컬러: 000000] 
, ep=점 PT(80,0) 태그: 없음[컬러: 000000] 
, tag=삼각형 선분 AB, color=000000, strokeType=0, width=1, distance=80.0], lnBC=MyLine [sp=점 PT(80,0) 태그: 없음[컬러: 000000] 
, ep=점 PT(0,80) 태그: 없음[컬러: 000000] 
, tag=삼각형 선분 BC, color=000000, strokeType=0, width=1, distance=113.13708498984761], lnCA=MyLine [sp=점 PT(0,80) 태그: 없음[컬러: 000000] 
, ep=점 PT(0,0) 태그: 원점[컬러: 000000] 
, tag=삼각형 선분 CA, color=000000, strokeType=0, width=1, distance=80.0], tag=, color=000000]

삼각형 TA MyIsoTriangle [shapeType=이등변 삼각형 정품인증? 가짜!, ptA=점 PT(0,0) 태그: 원점[컬러: 000000] 
, ptB=점 PT(300,10) 태그: 없음[컬러: 000000] 
, ptC=점 PT(0,80) 태그: 없음[컬러: 000000] 
, lnAB=MyLine [sp=점 PT(0,0) 태그: 원점[컬러: 000000] 
, ep=점 PT(300,10) 태그: 없음[컬러: 000000] 
, tag=삼각형 선분 AB, color=000000, strokeType=0, width=1, distance=300.1666203960727], lnBC=MyLine [sp=점 PT(300,10) 태그: 없음[컬러: 000000] 
, ep=점 PT(0,80) 태그: 없음[컬러: 000000] 
, tag=삼각형 선분 BC, color=000000, strokeType=0, width=1, distance=308.05843601498725], lnCA=MyLine [sp=점 PT(0,80) 태그: 없음[컬러: 000000] 
, ep=점 PT(0,0) 태그: 원점[컬러: 000000] 
, tag=삼각형 선분 CA, color=000000, strokeType=0, width=1, distance=80.0], tag=, color=000000]

*/