package HomeWork_0304;

public class StudentMain_0303 {
	
	public static void main(String[] args) {
		randomPrint();
	}

	
	public static int  printStudent(int i, String name, String major,boolean isEnd) {
		
		int ranAge = (int)((Math.random() * 30)+10);
		if(ranAge < 19) {
			System.out.println( "* �л���ȣ  "+ i + "\n\t" + "�̸� : "+ name + "\n" +  "	���� : "+ ranAge + "��"+"\t"+"<û�ҳ�>" + "\n" +"	���� : "+ major);
		}else {			 
			System.out.println( "* �л���ȣ  "+ i + "\n\t" + "�̸� : "+ name + "\n" +  "	���� : "+ ranAge + "��"+"\t"+"<����>" + "\n" +"	���� : "+ major);
		}

		 if(isEnd) {
			 System.out.println("---------------------");
			 
		 }else {
			 System.out.println("====================");
			 
		 }
		return ranAge;
	}
	
	public static void randomPrint() {
		System.out.println("=== �л� ���� ��� ===\n");
		
		printStudent(1, "ȫ�浿", "JAVA",true);
		printStudent(2, "�Ż��Ӵ�", "C++",true);
		printStudent(3, "�������", "PHP",true);
		printStudent(4, "���ߵ���", "Android",false);
		
	}
}
