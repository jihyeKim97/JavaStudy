package HomeWork_0304;

public class StudentMain_0303 {
	
	public static void main(String[] args) {
		randomPrint();
	}

	
	public static int  printStudent(int i, String name, String major,boolean isEnd) {
		
		int ranAge = (int)((Math.random() * 30)+10);
		if(ranAge < 19) {
			System.out.println( "* 학생번호  "+ i + "\n\t" + "이름 : "+ name + "\n" +  "	나이 : "+ ranAge + "세"+"\t"+"<청소년>" + "\n" +"	전공 : "+ major);
		}else {			 
			System.out.println( "* 학생번호  "+ i + "\n\t" + "이름 : "+ name + "\n" +  "	나이 : "+ ranAge + "세"+"\t"+"<성인>" + "\n" +"	전공 : "+ major);
		}

		 if(isEnd) {
			 System.out.println("---------------------");
			 
		 }else {
			 System.out.println("====================");
			 
		 }
		return ranAge;
	}
	
	public static void randomPrint() {
		System.out.println("=== 학생 정보 출력 ===\n");
		
		printStudent(1, "홍길동", "JAVA",true);
		printStudent(2, "신사임당", "C++",true);
		printStudent(3, "세종대왕", "PHP",true);
		printStudent(4, "배추도사", "Android",false);
		
	}
}
