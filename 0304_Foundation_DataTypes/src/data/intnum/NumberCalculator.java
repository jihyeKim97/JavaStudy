package data.intnum;

public class NumberCalculator {

	public static void main(String[] args) {
		// ���� �迭�� ������ ����
		// ��ȣ signed
		int numA = 100;
		int numB = (int)((Math.random()*1000)/10);
		// ��������� (Arithmetic operator)
		// + - * /
		int sumVal, diffVal, mulVal, divVal = 0;
		
		sumVal = numA + numB;
		diffVal = numA - numB;
		mulVal = numA * numB;
		
//		if(numB > 0) {
		if(numB != 0) {
			divVal = numA / numB;
			System.out.println(">>������ ����");
		}else {
			System.out.println("0�� ������ ����");
		}
		
		// ������ ������
		int modVal =0;
		modVal = numA % numB;
		// ������ �����ڵ� 0�� �ƴҶ��� 
		
		//0���� �������� �����ϸ� ���ܰ�(�ǽð� ����) �߻�
		
		System.out.println(numA +"+"+ numB+"="+ sumVal);
		System.out.println(numA +"-"+ numB+"="+ diffVal);
		System.out.println(numA +"*"+ numB+"="+ mulVal);
		System.out.println(numA +"/"+ numB+"="+ divVal);
		System.out.println(numA +"%"+ numB+"="+ modVal);
		
	}

}
                                                                                         