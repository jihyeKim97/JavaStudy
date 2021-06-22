package HomeWork_0331;
/*
	���� �迭 alphabets�� ���� 26���� ����ϴ�.
	alphabets�� ��� 0���� �ʱ�ȭ�մϴ�.
	(alphabets�� ��� '\0'���� �ʱ�ȭ�մϴ�.)
	0 ~ 25������ ������ȣ�� ��Ҹ� ����
	length�� 26.
	�׻� for���� ����Ͽ� �迭�� ������ ǥ���մϴ�.
	--------------------------------------
	1. for() ������ ����Ͽ� alphabets �迭�� 
	'A' ���� ���ʴ�� 'Z'���� ä���ݴϴ�.
	ä���� alphabets �迭�� ȭ�鿡 ����մϴ�.    	
	1�� �迭����: A B C D E F G ... X Y Z
	
	2. for() ������ ����Ͽ� alphabets �迭�� 
	'z' ���� ���ʴ�� 'a'���� ä���ݴϴ�.
	ä���� alphabets �迭�� ȭ�鿡 ����մϴ�.    	
	2�� �迭����: z y x w v ... d c b a
	
	3. 	for() ������ ����Ͽ� alphabets �迭��
	������ ������ �빮�� ?�� ä���ݴϴ�.
	'A' ~ 'Z' �����߿��� �� ����!!
	3�� �迭����: A C C F F X X Y W ... A B C
	
	4. 	for() ������ ����Ͽ� alphabets �迭��
	������ ������ �ҹ��� ?�� ä���ݴϴ�.
	'a' ~ 'z' �����߿��� �� ����!!
	��, �Ź� �迭�� ���ο� ���� �ҹ��ڸ� �Է��ϱ� ����...
	�������� �Էµ� �ҹ��ڵ�� �ߺ��Ǵ� �����, 
	�����ϰ� �ٽ� �ű� ���� �ҹ��ڸ� �����Ͽ� �Է� �õ�.
	�׸��� ��õ� ������ ��� ����Ʈ!!
	4�� �迭����: 
			     8ȸ���� c�� �ߺ� ����!
			     12ȸ���� w�� �ߺ� ����!
			     ...   			     
			     c b a x y z w h y q d .. e f   
*/

public class ForLoopArray {

	public static void main(String[] args) {
		System.out.print("1���迭���� : ");
		char alphabetsSmall[] = new char[26];
		for (int i = 0; i < alphabetsSmall.length; i++) {
			alphabetsSmall[i] = (char) (97 + i);
			System.out.print(alphabetsSmall[i] + " ");
		}
		System.out.println();
		System.out.print("2���迭���� : ");
		char alphabetsLarge[] = new char[26];
		for (int i = 0; i < alphabetsLarge.length; i++) {
			alphabetsLarge[i] = (char) (65 + i);
			System.out.print(alphabetsLarge[i] + " ");
		}

		System.out.println();
		System.out.print("3���迭���� : ");
		char ranAlphabetsLarge[] = new char[26];
		for (int i = 0; i < ranAlphabetsLarge.length; i++) {
			ranAlphabetsLarge[i] = (char) (65 + ((int) (Math.random() * 26)));
			System.out.print(ranAlphabetsLarge[i]+" ");
		}
		
		System.out.println();
		System.out.print("4���迭���� - \n");
		char ranAlphabetsSmall[] = new char[26];
		boolean filter = false;
		for (int i = 0; i < ranAlphabetsSmall.length; i++) {
			int ran = (int) (Math.random() * 26);
			ranAlphabetsSmall[i] = (char) (97 + ran);
			if(ranAlphabetsSmall[i] == (char)(97+ran)) {
				filter = true;
			}
			System.out.printf("%dȸ�� ���ĺ� : %c \n",i+1,ranAlphabetsSmall[i]);
			if(filter == true) {
				System.out.println("�ߺ����ĺ� : "+ranAlphabetsSmall[i]);
			}
			
		}

	}

}
