package collective.hash;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMain9 {

	public static void main(String[] args) {
		// �ѱ� ���� ����Ʈ?
		ArrayList<Character> cList1
						= new ArrayList<>();
		for(char c = '��'; c <= '�R'; c++ ) {
//			cList1.add( new Character(c));
			cList1.add(c);
		}
		for (int i = 0; i < cList1.size(); i++) {
			System.out.print(cList1.get(i) +" ");
			if( (i + 1) % 10 == 0)
				System.out.println();
		}
		
		// ��������: ���� ��Ұ� ����Ʈ�� ���
		// ����Ʈ�� ��Ұ� ���� ���..?
		
		// ���ڿ�Ű  => ���ڹ�� ���� ǥ�� 
		// ����Ʈ�� ��ҷν� �� ���� ������� ����.
		
		// ���� ���ڸ�(?) ����Ʈ
		// ���� ���ڸ� ��ü ����� Ű�� String���� ����̸�
		//		https://www.compart.com/en/unicode/U+0041
		// 		���� �빮��UPPER ���,  
		//  	https://www.compart.com/en/unicode/U+0061
		//		���� �ҹ���LOWER ���...
		//		
		// 		���� ��Ŭ���� CIRCLE ���...
		//
		//		���� ������� SQUARE ���...
		
		ArrayList<HashMap<String,Character>>
			cList2 = new ArrayList<>();
		
		// ���� �빮�� Ž�� ���� A ~ Z
		for (char c = 'A'; c <= 'Z'; c++) {
			HashMap<String,Character>
			 eng = new HashMap<String,Character>();
			eng.put("UPPER", c); // 'A'
			eng.put("LOWER", (char)(c+' ')); // 'a' = 'A' + 32
			//
			cList2.add(eng);
		}
	}

}

