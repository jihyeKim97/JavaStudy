package wrap;

public class BasicWrapper2 {

	public static void main(String[] args) {
		// �⺻���� ����Ŭ���������� ����...
		int num1 = 365 + 1;
		Integer num2 = 365 + 1;
		num2 = num1; // �ڵ��ڽ�
		num1 = num2.intValue() + 3; // ������ڽ� 
		num1 = num2 - 5; // �ڵ���ڽ�
		
		Integer num3 = new Integer(365); // ���� �ڽ�
			// 4����Ʈ ��ġ�����Ͱ� ��üȭ�� ǥ��
		Integer num4 = 365; // new Integer(365);
			// ����������... new Integer(nnn)�� ������ �� ����
			// AutoBoxing ����ڽ� (�ڵ����� �ڽ�, ��, ����Ŭ���������� ��´�.)
			// �⺻�� �����͸� �ڵ����� �˾Ƽ� ��ü�� ���������� ��ȯ��.
		//num4.toString()
		int num5 = num3.intValue(); 
			// (����) ��ڽ�  manual unboxing
			// ���۰�ü �ȿ� �ִ� �⺻������ �����ϱ�
		int num6 = num4; // num3; // �ڵ���ڽ� (AutoUnboxing)
		//
		
		float f = new Float(3.14f);
		Float f2 = 3.141592F;
		Float f3 = num3.floatValue(); // 365.0f 
			// ������ü���� �Ǽ������� ���渮�ϵǾ��ٰ� 
			// �ٷ� �ٽ� �Ǽ���ü�ο���ڽ�
		
		char c = 'A'; 
		Character c2 = 'B'; // ����ڽ�
		Character c3 = new Character('C');
		char c4 = new Character('C');
		char c5 = c3.charValue();
		char c6 = c2.charValue();
		// c5, c6�� ���� �ڵ尪..
		
		char inputC = '\u0020'; 
				//0x20;// 32; //' ';// '3';//'b';//'A';
		Character objectC = new Character(inputC); 
						// manual-boxing.. 'A';
		//Character objectC = inputC; // autoboxing.. 'A';
		// ������ ���ڴ�? ������ҹ��� ������ ���ھ�??? 
		if( Character.isAlphabetic(objectC) == true )
			System.out.println(objectC + " ������ҹ���(���ĺ�)��.");
		else if( Character.isDigit(objectC) )
			System.out.println(objectC + " ���� ���� ��.");
		else if( Character.isWhitespace(objectC) )
			System.out.println(objectC + " ���� ���� ��.");
		else 
			System.out.println("ó�����ؿ�....");
	}

}




