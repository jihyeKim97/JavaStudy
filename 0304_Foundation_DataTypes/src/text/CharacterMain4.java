package text;

public class CharacterMain4 {

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
		boolean flag = true;
		char start = 'A';
		int count = 0; // ī���� ���� ���� (�󵵼�, ���� ������ ������)
		//while(true) { // ���ѷ���
		//while(flag) {
		final int ALPHABETS = 26;
		while(flag == true) {		
			//count = count + 1;// 1�� �����ϴ� ī����
			count++; // �ڽ��� ���� 1�� ������Ŵ; 
			// ���������� incremental operator			
			//System.out.printf("%c \n", 'A');
			//System.out.printf("%c \n", 'B');
			//System.out.printf("%c \n", 'A'+1);
			//System.out.printf("%c \n", start+1);
			//System.out.printf("%c \n", start);
			System.out.printf("%d�� ���� => %c \n", count, start);
			start = (char)(start + 1);
			if( count == ALPHABETS ) flag = false;
		}
		System.out.println("���� ��� loop ����!!!");

		
	}
	


	private static void printCharWithCode(char c) {
		System.out.printf("���� %c => �ڵ尪 %d [0x%X] \n", 
				c, (int)c, (int)c); 
	}

}

