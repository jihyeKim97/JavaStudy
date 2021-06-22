package operation;

public class OpMain6 {

	public static void main(String[] args) {

		char c = 'Z'; //90
		System.out.println(c);
		System.out.println((int)c);
		c = (char)(c-11);
		System.out.println(c);
		System.out.println((int)c);
		c--;
		System.out.println(c);
		System.out.println((int)c);
		 
//		if( --c>'M' && --c > 65) {    =======> c=M NO
//		if( --c>='M' && --c > 65) { =======> c=L YES 
//		if( --c >= 'M' && --c <= 76) {   =======> c=L YES 
//		if( --c >= 'M' &&  --c <= 76) {   =======> c=L YES 
		if( --c >= 'M' ||  --c <= 76) {   //------->c=M [77] YES 
			System.out.printf("c=%c [%d] YES \n",c,(int)c);
		}else {
			System.out.printf("c=%c [%d] NO \n",c,(int)c);
		}
		
		if(1 == 1) {
//			if(2==2 && c-- <=76 && c>75){  ---->c=L [76] NO 
			if(2==2 && (c-- <=76 || c-- >75)){  //------->c=K [75] YES 
				System.out.printf("c=%c [%d] YES \n",c,(int)c);
			}else {
				System.out.printf("c=%c [%d] NO \n",c,(int)c);
			}
		}
			
	
		
	}

}
