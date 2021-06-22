package loop;

public class ColorLoop2 {

	public static final int COLOR_BLACK = 1;
	public static final int COLOR_WHITE = 2;
	public static final int COLOR_RED = 3;
	public static final int COLOR_GREEN = 4;
	public static final int COLOR_BLUE = 5;
	public static final int COLOR_YELLOW = 6;
	public static final int COLOR_PURPLE = 7;
	public static final int COLOR_CYAN = 8;
	public static final int COLOR_NAVY = 9;
	public static final int COLOR_ORANGE = 0x0A; //10;
	public static final int COLOR_BROWN = 0x0B; //11;
	public static final int COLOR_PINK = 0x0C; //12;
	public static final int COLOR_GOLD = 0x0D; // 13;

	
	public static void main(String[] args) {
		// 배열 Array
		// 동일한 타입의 데이터를 다수개 여러개의 변수들이 필요함.
		// 동일한 타입의 다수 데이터들을 단 하나의 배열변수로 묶어서 표현함.
		// 배열은 단 하나의 대표 이름을 변수(Array 타입)명으로 설정
		// 배열은 그 요소(element)들의 타입으로 선언함. 
		// 배열은 요소를 넣을 수 있는 "메모리 공간"임.
		//String[] colors; // 문자열 여러개를 묶은 배열변수 colors 선언.
		//String []colors;
		//String colors[]; // 대표이름 colors인 배열을 선언.
		//String[] colors = {}; // 배열 초기화 -- empty array 빈 배열
		// 배열 변수 선언 및 초기화
		String[] colors = {
			"black", "white", "red", "green",  // 0, 1, 2, 3
			"blue", "yellow", "purple", "cyan", // 4, 5, 6, 7
			"navy", "orange", "brown", "pink", // 8, 9, 10, 11 
			"gold"  						   // 12	
		};
		// 배열의 데이터(요소)가 총 13개인 배열을 정의.
		// 배열은 데이터, 즉 각 요소에 대한 접근을 반드시 순서번호(index)로 해야함.
		// 자바의 배열 인덱스, 즉 순서번호는 0부터 시작하여 마지막 인덱스 N-1.
		// 즉, 마지막 순서번호는 배열의 총요소개수 - 1임.
		// 배열의 크기 (길이) = 요소의 총 개수 = 배열명.length
		// 배열은 한번 정의되면 그 요소개수가 절대 변할 수 업다.
		
		// 컬러 배열을 이용하여 랜덤한 순서번호기반 컬러이름을 선택함.
		//int ranCr = (int)(Math.random() * 13); // 0 ~ 12
//		int ranCr = (int)(Math.random() * colors.length); 
//					// 0 ~ length-1
//		String ranColor = colors[ranCr];
//		System.out.printf("랜덤컬러[%d] = %s \n", 
//					ranCr, ranColor);
		int ranCr = (int)(Math.random() * colors.length) + 1;
					// 1 ~ 13
		
//		if( ranCr > COLOR_BLUE ) // YELLOW 6 ~ GOLD 13
//			System.out.println("아직 처리 못하는 컬러!");
//		else
//			System.out.println(colors[ranCr-1]); 
//			// 배열의 다 수개의 요소 중에 하나를 선택함. == 다중분기문?
		
		if( ranCr <= COLOR_BLUE ) 
			System.out.println(colors[ranCr-1]);
		else				
			System.out.println("아직 처리 못하는 컬러!");
					
//		switch(ranCr) {
//			case COLOR_BLACK: 
//				//System.out.println("black"); break;
//				//System.out.println(colors[0]); break;
//				System.out.println(colors[COLOR_BLACK-1]); break;
//			case COLOR_WHITE: 
//				//System.out.println("white"); break;	
//				//System.out.println(colors[1]); break;
//				System.out.println(colors[COLOR_WHITE-1]); break;
//			case COLOR_RED: 
//				//System.out.println("red"); break;	
//				//System.out.println(colors[2]); break;
//				System.out.println(colors[COLOR_RED-1]); break;
//			case COLOR_GREEN: 
//				//System.out.println("green"); break;
////				System.out.println(colors[3]); break;
//				System.out.println(colors[COLOR_GREEN-1]); break;
//			case COLOR_BLUE: 
////				System.out.println("blue"); break;
////				System.out.println(colors[4]); break;
//				System.out.println(colors[COLOR_BLUE-1]); break;
//			default: // COLOR_YELLOW 6 ~ GOLD 13
//				System.out.println("아직 처리 못하는 컬러!");
//				//break;
//		}
	}

}

/*
colors.length = 13
첫번째 color[0] = black
마지막 color[12] = gold
컬러 이름: black
컬러 이름: white
컬러 이름: red
컬러 이름: green
컬러 이름: blue
컬러 이름: yellow
컬러 이름: purple
컬러 이름: cyan
컬러 이름: navy
컬러 이름: orange
컬러 이름: brown
컬러 이름: pink
컬러 이름: gold
0번 컬러 이름: black 
1번 컬러 이름: white 
2번 컬러 이름: red 
3번 컬러 이름: green 
4번 컬러 이름: blue 
5번 컬러 이름: yellow 
6번 컬러 이름: purple 
7번 컬러 이름: cyan 
8번 컬러 이름: navy 
9번 컬러 이름: orange 
10번 컬러 이름: brown 
11번 컬러 이름: pink 
12번 컬러 이름: gold 
*/ 
