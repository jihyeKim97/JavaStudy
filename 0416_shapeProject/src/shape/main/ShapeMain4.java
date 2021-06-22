package shape.main;

import shape.MyShape;
import shape.basic.MyPoint;
import shape.d1.MyLine;

public class ShapeMain4 {

	public static void main(String[] args) {
		MyLine ln1 = 
				new MyLine(20, 10, 500, -150);
		ln1.tag = "광화문역 5번출구에서 이순신장군 동상까지의 경로";
		//ln1.sp; // 안보임, 접근 불가능한 필드? private
		MyPoint sp = ln1.getStartPoint();
		MyPoint ep = ln1.getEp(); // 게터 메소드로 접근.
		System.out.println(sp.toString());
		System.out.println(ep); // toString()
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
		ln1.updateStartPoint(
				new MyPoint(-20, -38, 
					"광화문역 3번출구", MyShape.COLOR_RED));
		ln1.printLine();
		
		//ln1.distance // err
		double path1 = ln1.getDistance();
		// 거리의 단위를 1.0 실제에서 미터법 1미터 대응하는 척도 (scale)
		System.out.printf(">> 경로 '%s'의 거리: %.2fm 입니다.\n",
				ln1.tag, ln1.getDistance());
	}

}

/*
점 PT(20,10) 태그: 없음[컬러: 000000] 

점 PT(500,-150) 태그:  광화문역 5번출구에서 이순신장군 동상까지의 경로 선객체의 끝점[컬러: 000000] 

~~~~~~~~~~~~~~~~~~~~~~
MyLine [sp=점 PT(-20,-38) 태그: 광화문역 3번출구[컬러: FF0000] 
, ep=점 PT(500,-150) 태그:  광화문역 5번출구에서 이순신장군 동상까지의 경로 선객체의 끝점[컬러: 000000] 
, tag=광화문역 5번출구에서 이순신장군 동상까지의 경로, color=000000, strokeType=0, width=1, distance=531.9248067161373]
>> 경로 '광화문역 5번출구에서 이순신장군 동상까지의 경로'의 거리: 531.92m 입니다.
*/