package text;

public class UnicodeMain {
	

	public static void main(String[] args) {
		printCharWithCode('��');
		printCharWithCode('��');
		// ���� �� => �ڵ尪 54620 [0xD55C]
		// ���� �� => �ڵ尪 44544 [0xAE00]

		char c1 = '��';
		char c2 = '��';
		printCharWithCode(c1);
		printCharWithCode('��');
		
		boolean cccc = isKorean('��');

		if(cccc == true) {
			System.out.println("�ѱ��Դϴ�");
		}else {
			System.out.println("�ѱ��̾ƴմϴ�");
		}
	}

	// ������
	public static final char SPC = ' ';

	//���� �ϳ� �޾Ƽ� �ѱ����� �Ǻ� �ϴ� �Լ�
	public static boolean isKorean(char c) {
		return c >= '��' && c <= '�R';
	}
	public static boolean isKorean2(char c) {
		if(c >= '��' && c <= '�R')  return  true;
		return false;
	}
	public static boolean isKorean3(char c) {
		boolean anwer = false;
//		if(c >= 0xAC00 && c <= 0xD7A3) {
//		if(c >= '\uAC00' && c <= '\uD7A3') {
		if(c >= '��' && c <= '�R') {
			anwer = true;
			System.out.println("�ѱ��Դϴ�");
		}else {
			System.out.println("�ѱ��̾ƴմϴ�");
		}		
		return anwer;
	}
		

	// �빮�� �ϳ��� �Է¹޾� �ҹ��ڷ� �����Ͽ� �����ϴ� �Լ�
	public static char upperToLower(char big) {
		// big ������� �Է����� �ϰ�!!!
		// big�� �빮���� ���� �����ڵ尪���� ����.
		char small = 0; // '\0'; //0;
		// '0'�� 48������ ���ȵ�..
		small = (char) (big + SPC);
		return small;
	}

	// �ҹ��� �ϳ��� �Է¹޾� �빮�ڷ� �����Ͽ� �����ϴ� �Լ�
	public static char lowerToUpper(char small) {
		// small�� �ҹ����� ���� �����ڵ尪���� ����. 97~122
		char big = (char) (small - SPC); // '\0';
		return big;
	}

	public static char lowerToUpper2(char small) {
		return (char) (small - SPC);
	}

	// ����Լ� ����
	// ���� �ϳ��� �Է¹޾� �ش� ���ڰ� �����빮�ڶ�� �ҹ��ڷ� �����Ͽ� �����ϰ�,
	// ���� �ش� ���ڰ� �����ҹ��ڶ�� �빮�ڷ� �����Ͽ� �����ϴ� �Լ�
	public static char toggleCase(char c) {
		char convC = '\0'; // ���Ṯ��
		// ���� �빮�ڶ�� => �����ڵ尪�� ���ڼ¿��� �빮���� ������ ������..
		// if( c >= 65 && c <= 65+25 )
		if (c >= 65 && c <= 90) // �빮�� ����
			convC = (char) (c + SPC); // �� => ��
		if (c >= 97 && c <= 122) // �ҹ��� ���� ���� 97+25)
			convC = (char) (c - SPC); // �� => ��
		return convC;
	}

	public static char toggleCase2(char c) {
		char convC = '\0';
		if (c >= 65 && c <= 90) // ���� �빮�� ����
			convC = (char) (c + SPC); // �� => ��
		else if (c >= 97 && c <= 122) // ���� �ҹ��� ���� ���� 97+25)
			convC = (char) (c - SPC); // �� => ��
		else
			System.out.println(">> '" + c + "' �� ���� ��ҹ��ڰ� �ƴմϴ�!");
		return convC;
	}

	public static final char ERROR_CHAR = 0;// '\0';

	public static char toggleCase3(char c) {
		if (c >= 'A' && c <= 'Z') // 'A'+25 )
			return (char) (c + SPC); // �� => ��
		else if (c >= 'a' && c <= 'z')
			return (char) (c - SPC); // �� => ��
		else {
			System.out.println(">> '" + c + "' �� ���� ��ҹ��ڰ� �ƴմϴ�!");
			return ERROR_CHAR;
		}
	}

	public static char toggleCase4(char c) {
		if (c >= 'A' && c <= 'Z') // 'A'+25 )
			return upperToLower(c); // �� => ��
		else if (c >= 'a' && c <= 'z') {
			char t = lowerToUpper(c);
			return t; // �� => ��
		} else {
			System.out.println(">> '" + c + "' �� ���� ��ҹ��ڰ� �ƴմϴ�!");
			return ERROR_CHAR;
		}
	}

	private static void printCharWithCode(char c) {
		if (c == 0) // '\0'
			return;
		System.out.printf("���� %c => �ڵ尪 %d [0x%X] \n", c, (int) c, (int) c);
	}

}
