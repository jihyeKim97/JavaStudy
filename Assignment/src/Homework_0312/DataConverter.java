package Homework_0312;
/*
 * 실습과제 :  
 
    === 컴퓨터 디지털 데이터 사이즈 변환기 ===
	
	 입력: 
		100 메가바이트(MB)
			=>
	 변환 출력: 		 
		838860800 비트(bit)
		104857600 바이트(B)
		102400 킬로바이트(KB)
		0.097656 기가바이트(GB)	
		0.000095 테라바이트(TB)
    =====================================
    
     https://search.naver.com/search.naver?where=nexearch&sm=tab_etc&query=%EB%8D%B0%EC%9D%B4%ED%84%B0%EC%96%91%EB%B3%80%ED%99%98
 */
public class DataConverter {
	
	public static final int BIT_RATIO = 8; // 8bits가 1Byte니까
	public static final double DATA_RATIO = Math.pow(2, 10); // 1024 = 2^10
	
	public static void main(String[] args) {
		printDataSize();
	}

	public static double mbTobit(double mb) {return mbTobyte(mb)*BIT_RATIO;} //MB -> bit	
	public static double mbTobyte(double mb) {return mbTokb(mb)*DATA_RATIO;}	//MB -> byte	
	public static double mbTokb(double mb) {return mb*DATA_RATIO;}	//MB -> KB
	public static double mbTogb(double mb) {return mb/DATA_RATIO;}	//MB -> GB	
	public static double mbTotb(double mb) {return mbTogb(mb)/DATA_RATIO;}	//MB -> TB	

	public static void printDataSize() {
		double dataMByte = 100; 

		System.out.println(" === 컴퓨터 디지털 데이터 사이즈 변환기 ===");
		System.out.printf(" INPUIT : %f MB\n", dataMByte);
		System.out.println("▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽");
		System.out.printf(" OUTPUIT : %.12f bit\n", mbTobit(dataMByte));
		System.out.printf(" OUTPUIT : %.12f byte\n", mbTobyte(dataMByte));
		System.out.printf(" OUTPUIT : %.12f KB\n", mbTokb(dataMByte));
		System.out.printf(" OUTPUIT : %.12f GB\n", mbTogb(dataMByte));
		System.out.printf(" OUTPUIT : %.12f TB\n", mbTotb(dataMByte));
		System.out.println("=================================");
	}
}
