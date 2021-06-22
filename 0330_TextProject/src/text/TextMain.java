package text;

public class TextMain {
	public static void main(String[] args) {
		char c1 = 'A';
		Character c2 = 65;
		char c3 = c2.charValue();
		char c4 = 0x0041;
		char c5 = '\u0041';
		char c6 = 0;
		char c7 = '��';
		char c8 = '��';

		// ���� �迭(char Array ) != ���ڿ�(String)
		// �ѹ� ���ǵ� �迭�� ũ�� = lenght �� ���� ���� ���� �Ұ���( �����)
		char[] cArr1 = { 'X', 'Z', 'Y' };
		char a = cArr1[2];
		char e = cArr1[cArr1.length - 1];
		for (int i = 0; i < cArr1.length; i++) {
			char az = cArr1[i];
			System.out.printf("%d��° ���� �ϳ� %c[%d, 0x%x]\n", i, az, (int) az, (int) cArr1[i]);
		}
		char[] name1 = {}; // length�� 0�� �� �迭 empty array
		char[] name2 = { '��', '��', '��' };
		char[] name3 = { 51076, 44221, 51652 };
		char[] name3b = { 0xC784, 0xACBD, 0xC9C4 };
		char[] name3c = { 0b1100_0111_1000_0100, 0xACBD, 0xC9C4 };
		char[] name3d = { '\uC784', '\uACBD', '\uC9C4' };

		char nameN1[] = new char[3];
		char nameN2[] = { '\0', '\0', '\0' };
		nameN1[0] = '��';
		nameN1[0] = 0b1100_0111_1000_0100; // '��'
		nameN1[1] = 44221;
		nameN1[2] = 0xC9C4;
		nameN2[0] = '\uC784';
		nameN2[3 - 3] = 0xACBD;
		nameN2[3 - 2] = 0xACBD;
		nameN2[3 - 1] = '��';
		nameN2[nameN2.length - 1] = nameN1[2];

		// ���ڿ��� String Ŭ���� Ÿ�� ->��ü ������
		// reference�� ������ ������ �� ��ü�� �����°� �ƴϰ�, Ư�� �������� ��ġ�� ����Ű�� �ּ� ���� ����
		// ���ڿ� ���� ���ڹ迭 ó�� �ټ����� ���ڵ��� ǥ���ϰ� ����
		String kname1 = "������"; // ���ڿ� ��ü ����
		String kname2 = new String("������"); // ->>���� ��ü �ļ� �� �ʱ�ȭ.

		char kName[] = { '��', '��', '��' };
		System.out.println(kname1);
		System.out.println(kname2);
		// kname1.length() = ���
		for (int i = 0; i < kName.length; i++) {
			System.out.printf("�ѱ��ھ� => %c \n", kName[i]);
		}
		// kname1.length() == lenght �Լ� �޼ҵ� : ���ڿ� �� ������ ��ä�� ������ ���ڼ�(�����ڵ� ���� ��)
		for (int i = 0; i < kname1.length(); i++) {
			// char c = kname1.charAt(i);
			// ���ڿ��� ��ü���� ������� ���Ե�
			// ���� �ϳ��� char������ �������ִ� �Լ�
			// System.out.printf("�� ���� �� => %c \n", c);
			System.out.printf("�� ���� �� => %c \n", kname1.charAt(i));
		}

		String princess = "Anna ����"; // 7����; 0 ~ 6 ������ȣ..
		System.out.printf(" %c => %c \n", princess.charAt(0), princess.charAt(6));
		// 'A' => '��'
		System.out.printf(" %c => %c \n", princess.charAt(0), princess.charAt(princess.length() - 1));

	}
}
