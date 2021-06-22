package collective;
import java.util.HashSet;

public class DataMain2 {

	public static void main(String[] args) {
		// ����(��ü)���� ���� -- Character ��ü
		HashSet hs = new HashSet();
		hs.add('X');
		char c = 'Y'; //new Character('Y');
		hs.add(c);
		
		for (Object ch : hs) {
			char p = (char)ch;
//			System.out.printf(" ���� �ϳ� %c \n", ch);
			System.out.printf(" ���� �ϳ� %c (%d) \n", p,(int)p);			
		}
		System.out.println("----------------");
		
		String xyz = "XYZ";
		hs.add(xyz.charAt(xyz.length()-1)); //'Z'
		
		hs.add('a'); hs.add('b'); hs.add('c');
		hs.add('��'); hs.add('��'); hs.add('��');
		
		for (Object ch : hs) {
			char p = (char)ch;
			System.out.printf(" ���� �ϳ� %c (%d) \n", p,(int)p);			
		}
		// ������ ������ �ǹ̰� ����...��   ������ �߿��� ó�����
		// ���� �����͸� �迭/����Ʈ�� �����Ͽ� ������ ó���ؾ� ��. 
	}

}

/*
���� �ϳ� X (88) 
���� �ϳ� Y (89) 
----------------
���� �ϳ� �� (44032) 
���� �ϳ� a (97) 
���� �ϳ� b (98) 
���� �ϳ� c (99) 
���� �ϳ� �� (48148) 
���� �ϳ� X (88) 
���� �ϳ� �� (54616) 
���� �ϳ� Y (89) 
���� �ϳ� Z (90) 
*/