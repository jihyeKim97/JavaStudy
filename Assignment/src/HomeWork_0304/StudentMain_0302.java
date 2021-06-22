package HomeWork_0304;

public class StudentMain_0302 {

	
	public static void main(String[] args) {
		System.out.println("=== 학생 정보 출력 ===");
		System.out.println();
		
		
		printStudent(1, "홍길동", 18, "JAVA",true);
		printStudent(2, "신사임당", 84, "C++",true);
		printStudent(3, "세종대왕", 99, "PHP",true);
		printStudent(4, "배추도사", 56, "Android",false);
		
		
	}

	
	private static void printStudent(int i, String name, int age, String major,boolean isEnd) {
		
		System.out.println( "* 학생번호  "+ i );
		 System.out.println("	이름 : "+ name );
		 System.out.println("	나이 : "+ age + "세");
		 System.out.println("	전공 : "+ major);

		 if(isEnd) {
			 System.out.println("---------------------");
			 
		 }else {
			 System.out.println("====================");
			 
		 }
	}
	
}
