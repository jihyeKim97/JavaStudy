package shape.d2.tri;
/*
#### MyRightTriangle 직각삼각형 (구체화 삼각형3)
> shape.d2.tri.MyRightTriangle 클래스
> 각 하나가 직각 90 PI/2 이면됨...(구체화된 특성)
- 자신의 종류를 표현하는 String shapeType "직각 삼각형" 
 */
public class MyRightTriangle extends MyTriangle2 {
	private boolean isRightTriangle() {
		// > 각 하나가 직각 90 PI/2 이면됨...(구체화된 특성)
		// || 로 혹은... 3 내각 중에서 단 하나라도 90라면... 직각 삼각형..
		return false;
	}
}
