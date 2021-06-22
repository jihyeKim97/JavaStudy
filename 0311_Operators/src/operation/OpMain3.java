package operation;

public class OpMain3 {

	public static void main(String[] args) {
		// ����������:  ����++ ����-- '��������' incremental, decrease 
		// pre ++A --B, post C++ D--
		int one = 10, two = 20;
		int nResult = 0;
		//nResult = one++; // ++one; 
		//nResult = one--; //--one;
		nResult = ++one + two--; // 11 + 20 = 31
		// ++one; => one = one + 1; 
		// one++; => one = one + 1;
		// --one; => one = one - 1; 
		// one--; => one = one - 1;
		System.out.println("one = " + one); // 11
		System.out.println("two = " + two); // 19
		System.out.println("nResult = " + nResult); // 31
		//
		nResult = 0;
		//nResult = one-- * 10 + ++two; // �Ʒ� 4��� ����..
		nResult = one * 10;
		one = one - 1;
		two = two + 1;
		nResult = nResult + two;
		System.out.println("one = " + one); // 10
		System.out.println("two = " + two); // 20
		System.out.println("nResult = " + nResult); // 130
		
		//
		nResult = 0;
		nResult = (one-- + two--) / ++one;
		System.out.println("one = " + one); // 10
		System.out.println("two = " + two); // 19
		System.out.println("nResult = " + nResult); // 3
		
		// ���������ڴ� ��� ���տ������� �� ���� (Composite Operator)
		int x = 10;
		x++; // 
		++x;
		x = x + 1;
		x += 1; // ���� ����
		x -= 1; // x = x -1; x--; --x;
		x = x + 5;
		x += 5; 
		x *= 3; // x = x * 3;
		x /= 2; // x = x / 2; 
		x %= 2; // ������ ������   x = x % 2;		
	}

}







