package shape.main;

import shape.MyShape;
import shape.basic.MyPoint;
import shape.d2.tri.MyTriangle;

public class ShapeMain5 {

	public static void main(String[] args) {
		MyPoint ptA = new MyPoint(0, 0, "학원", MyShape.COLOR_RED);
		MyPoint ptB = new MyPoint(180, 20, "성동구청", MyShape.COLOR_GREEN);
		MyPoint ptC = new MyPoint(-200, -90, "별다방", MyShape.COLOR_BLUE);
		MyPoint ptD = new MyPoint(-100, 80, "우체국", MyShape.COLOR_PURPLE);
		
		MyTriangle ta1 = new MyTriangle(ptA, ptB, ptC);
		ta1.tag = "커피 마시는 영역";
		//ta1.printTriange();
		ta1.measurePerimeter(); // 측정 실행..
		System.out.println("커피 성지 삼각형 둘레 길이: "
			+ ta1.getPerimeter() + "m");
		
		MyPoint pts[] = { ptD, ptB, ptC };
		MyTriangle ta2 = new MyTriangle(pts);
		ta2.tag = "공부하는 영역";
		//ta2.printTriange();
		double peri = ta2.measurePerimeter(); // 측정 실행..
		System.out.println("공부 성지 삼각형 둘레 길이: "
			+ peri + "m");
	}

}

/*
삼각형 TA MyTriangle [ptA=점 PT(0,0) 태그: 학원[컬러: FF0000] 
, ptB=점 PT(180,20) 태그: 성동구청[컬러: 00FF00] 
, ptC=점 PT(-200,-90) 태그: 별다방[컬러: 0000FF] 
, lnAB=MyLine [sp=점 PT(0,0) 태그: 학원[컬러: FF0000] 
, ep=점 PT(180,20) 태그: 성동구청[컬러: 00FF00] 
, tag=삼각형 선분 AB, color=000000, strokeType=0, width=1, distance=181.10770276274835], lnBC=MyLine [sp=점 PT(180,20) 태그: 성동구청[컬러: 00FF00] 
, ep=점 PT(-200,-90) 태그: 별다방[컬러: 0000FF] 
, tag=삼각형 선분 BC, color=000000, strokeType=0, width=1, distance=395.60080889704966], lnCA=MyLine [sp=점 PT(-200,-90) 태그: 별다방[컬러: 0000FF] 
, ep=점 PT(0,0) 태그: 학원[컬러: FF0000] 
, tag=삼각형 선분 CA, color=000000, strokeType=0, width=1, distance=219.31712199461307], tag=커피 마시는 영역, color=000000, area=0.0m^2 면적, perimeter=0.0m 둘레, angleCA_AB=0.0㎭ 각도, angleAB_BC=0.0㎭ 각도, angleBC_CA=0.0㎭ 각도]
삼각형 TA MyTriangle [ptA=점 PT(-100,80) 태그: 우체국[컬러: FF00FF] 
, ptB=점 PT(180,20) 태그: 성동구청[컬러: 00FF00] 
, ptC=점 PT(-200,-90) 태그: 별다방[컬러: 0000FF] 
, lnAB=MyLine [sp=점 PT(-100,80) 태그: 우체국[컬러: FF00FF] 
, ep=점 PT(180,20) 태그: 성동구청[컬러: 00FF00] 
, tag=삼각형 선분 AB, color=000000, strokeType=0, width=1, distance=286.35642126552705], lnBC=MyLine [sp=점 PT(180,20) 태그: 성동구청[컬러: 00FF00] 
, ep=점 PT(-200,-90) 태그: 별다방[컬러: 0000FF] 
, tag=삼각형 선분 BC, color=000000, strokeType=0, width=1, distance=395.60080889704966], lnCA=MyLine [sp=점 PT(-200,-90) 태그: 별다방[컬러: 0000FF] 
, ep=점 PT(-100,80) 태그: 우체국[컬러: FF00FF] 
, tag=삼각형 선분 CA, color=000000, strokeType=0, width=1, distance=197.2308292331602], tag=공부하는 영역, color=000000, area=0.0m^2 면적, perimeter=0.0m 둘레, angleCA_AB=0.0㎭ 각도, angleAB_BC=0.0㎭ 각도, angleBC_CA=0.0㎭ 각도]

*/