package HomeWork_0304;

public class StudentMain_0302 {

	
	public static void main(String[] args) {
		System.out.println("=== �л� ���� ��� ===");
		System.out.println();
		
		
		printStudent(1, "ȫ�浿", 18, "JAVA",true);
		printStudent(2, "�Ż��Ӵ�", 84, "C++",true);
		printStudent(3, "�������", 99, "PHP",true);
		printStudent(4, "���ߵ���", 56, "Android",false);
		
		
	}

	
	private static void printStudent(int i, String name, int age, String major,boolean isEnd) {
		
		System.out.println( "* �л���ȣ  "+ i );
		 System.out.println("	�̸� : "+ name );
		 System.out.println("	���� : "+ age + "��");
		 System.out.println("	���� : "+ major);

		 if(isEnd) {
			 System.out.println("---------------------");
			 
		 }else {
			 System.out.println("====================");
			 
		 }
	}
	
}
