package Homework_0312;
/*
 * �ǽ����� :  
 
    === ��ǻ�� ������ ������ ������ ��ȯ�� ===
	
	 �Է�: 
		100 �ް�����Ʈ(MB)
			=>
	 ��ȯ ���: 		 
		838860800 ��Ʈ(bit)
		104857600 ����Ʈ(B)
		102400 ų�ι���Ʈ(KB)
		0.097656 �Ⱑ����Ʈ(GB)	
		0.000095 �׶����Ʈ(TB)
    =====================================
    
     https://search.naver.com/search.naver?where=nexearch&sm=tab_etc&query=%EB%8D%B0%EC%9D%B4%ED%84%B0%EC%96%91%EB%B3%80%ED%99%98
 */
public class DataConverter {
	
	public static final int BIT_RATIO = 8; // 8bits�� 1Byte�ϱ�
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

		System.out.println(" === ��ǻ�� ������ ������ ������ ��ȯ�� ===");
		System.out.printf(" INPUIT : %f MB\n", dataMByte);
		System.out.println("������������������������");
		System.out.printf(" OUTPUIT : %.12f bit\n", mbTobit(dataMByte));
		System.out.printf(" OUTPUIT : %.12f byte\n", mbTobyte(dataMByte));
		System.out.printf(" OUTPUIT : %.12f KB\n", mbTokb(dataMByte));
		System.out.printf(" OUTPUIT : %.12f GB\n", mbTogb(dataMByte));
		System.out.printf(" OUTPUIT : %.12f TB\n", mbTotb(dataMByte));
		System.out.println("=================================");
	}
}
