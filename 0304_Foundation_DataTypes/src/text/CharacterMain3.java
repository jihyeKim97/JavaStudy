package text;

public class CharacterMain3 {

	// ������
	public static final char SPC = ' ';
	
	// �빮�� �ϳ��� �Է¹޾� �ҹ��ڷ� �����Ͽ� �����ϴ� �Լ�
	public static char upperToLower(char big) {
		// big ������� �Է����� �ϰ�!!! 
		// big�� �빮���� ���� �����ڵ尪���� ����.
		char small = 0; // '\0'; //0;
				// '0'�� 48������ ���ȵ�..
		small = (char)(big + SPC);
		return small;
	}
	
	// �ҹ��� �ϳ��� �Է¹޾� �빮�ڷ� �����Ͽ� �����ϴ� �Լ� 
	public static char lowerToUpper(char small) {
		// small�� �ҹ����� ���� �����ڵ尪���� ����. 97~122
		char big = (char)(small - SPC); //'\0';
		return big;
	}
	
	public static char lowerToUpper2(char small) {		
		return (char)(small - SPC);
	}
	
	
	public static void main(String[] args) {
		
		printCharWithCode('W');
		printCharWithCode(upperToLower('W'));
		char conv = lowerToUpper('k'); // 'K' ����
		printCharWithCode(conv);

		char c = 65;// 'A'; 
		// �ڹ� char�� 0 ~ 65535 �ڵ尪 ���� => 0x0000 ~ 0xFFFF		
		final char SPACE = ' '; // ASCII �ڵ�ǥ���� 32��° ����..
		final char SPACE2 = 32;
		final char SPACE3 = 0x0020; // 0x20;// 32 = 16^1*2 + 16^0*0
		final char SPACE4 = 0b0000_0000_0010_0000;
		final char SPACE5 = '\u0020'; // unicode ���ͷ�
		
		//if( 'A' == 'B' ) {
//		if( 'A' != 'B' ) { // �ڵ尪�� ��
		//if( 'A'+1 == 'B' ) { // 64 + 1 == 65
		if( 'A'  > 'B' ) {
			System.out.println("�����!!!");
		} else 
			System.out.println("�����̳׿�!!!!");
		
		if( 'z' == 'a' + 25 ) // offset
			System.out.println("z ���̳׿�."); 
		
		if( 'A' < 'a' ) // �빮�ڵ��� �ҹ��ڵ麸�� �ڵ�ǥ�� �տ� ����..
			System.out.println("A < a ���̳׿�.");
		
		if( 'A' == 'a'-32 )
			System.out.println("A == a-32 ���̳׿�.");
		if( 'A'+32 == 'a' )
			System.out.println("A+32 == a ���̳׿�.");
		
		if( 'A'+SPACE == 'a' )
			System.out.println("A+SPACE == a ���̳׿�.");
	
	}

	private static void printCharWithCode(char c) {
		System.out.printf("���� %c => �ڵ尪 %d [0x%X] \n", 
				c, (int)c, (int)c); 
	}

}
