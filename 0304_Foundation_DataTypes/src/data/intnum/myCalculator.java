package data.intnum;

public class myCalculator {

	public static void main(String[] args) {
		// �� ������ ���ؼ� ��Ģ����, �������� ��� ������ �Լ��μ� ����
		int numA = 100, numB = 47;

		myCalsubtrAction(numA,numB);
		myCalSubtraction(numA,numB);
		myCalMultiplication(numA,numB);
		myCalDivision(numA,numB);
		myCalModulus(numA,numB);
		myCalModulus2(numA,numB);
	}
	
	
	private static void myCalsubtrAction(int x, int y) {
		int z = 0; // �ӽ� 4byte ����
		z = x + y ; 
		System.out.println("[����]"+x+"+"+y+"="+z);
	}

	private static void myCalSubtraction(int x, int y) {
		int z = 0; // �ӽ� 4byte ����
		z = x - y ; 
		System.out.println("[����]"+x+"-"+y+"="+z);
		
	}
	
	private static void myCalMultiplication(int x, int y) {
		int z = 0; // �ӽ� 4byte ����
		z = x * y ; 
		System.out.println("[����]"+x+"*"+y+"="+z);
	}
	
	private static void myCalDivision(int x, int y) {
		
		if(y == 0) {
			System.out.println("y �� 0�̱⿡ ������ �����ϴ�");
			return;
		}else {
			int z = 0; // �ӽ� 4byte ����
			z = x / y ; 
			System.out.println("[������]"+x+"/"+y+"="+z);			
		}
	}
	
	private static void myCalModulus(int x, int y) { //return�� ������
		
		if(y == 0) {
			System.out.println("y �� 0�̱⿡ ������ �����ϴ�");
			return;
		}
		int z = 0; // �ӽ� 4byte ����
		z = x % y ; 
		System.out.println("[������]"+x+"%"+y+"="+z);			
	}
	
	private static void myCalModulus2(int x, int y) { //return�� ���� else�� ������
		
		if(y == 0) {
			System.out.println("y �� 0�̱⿡ ������ �����ϴ�");
		}else {
			int z = 0; // �ӽ� 4byte ����
			z = x % y ; 
			System.out.println("[������]"+x+"%"+y+"="+z);			
		}
	}

}
