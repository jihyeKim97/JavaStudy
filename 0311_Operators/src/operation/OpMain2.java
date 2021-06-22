package operation;

public class OpMain2 {

	public static void main(String[] args) {
		// 나머지 연산자 
		// % rem mod
		int r = 300 % 99; // 3
		// 뽑기? pick
		boolean flag = true;
		while( flag ) {
			r = (int)(Math.random() * 100) + 1;
			// 1 ~ 100  =>  1 ~ 30 
			r = (r % 30) + 1; // 수치형 입력 범위가 좁게 제한...
			if( r == 1 ) { // 1
				System.out.println("특등상 !!");
				flag = false; // 유일 종료 조건
			} else if( r >= 2 && r <= 6 ) // 2 ~ 6
				System.out.println("우수상 " + r);
			else if( r > 6 && r <= 16 ) // 7 ~ 16 
				System.out.println("장려상 " + r);
			else // 꽝
				System.out.println("꽝!!!");
		}
		// 
		System.out.println(" -- pick 게임 종료 -- ");
	}

}







