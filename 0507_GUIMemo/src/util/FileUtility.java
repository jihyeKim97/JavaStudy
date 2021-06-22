package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// ������ ���� => �ؽ�Ʈ����(���ڼ����� ǥ���Ǵ� �����͸����� ����),
//					txt, java, html, sql, ...
//			   ���̳ʸ�����(1/0�� ��Ʈ ���������ͷ� ������ => ���˱����ʿ�)
//					hwp, jpg, exe, png, mov, doc, ...

// ���� �б�, ���� ��ƿ��Ƽ Ŭ���� 
public class FileUtility {

	public static void main(String[] args) {
		final String testFilePath = "./test2.txt";  //1.txt";
		String testMemo = "Hello Elsa!! \n How are you doing??";
		//String testMemo = "Hello!! \n Anna~~~~ \n ���� ������?? \n �׷���.";
		if( saveMemoToFile(testMemo, testFilePath) ) {
			System.out.println("test2.txt ���� ���� ����!");
		}
		
		String memo = loadMemoFromFile(testFilePath);
		System.out.println("------------------------");
		System.out.println(memo);
		System.out.println("------------------------");
	}
	
	// �ؽ�Ʈ ���� �����ϱ� (����, �뷮 �ϰ�...)
	public static boolean saveMemoToFile(
			String memo, String filePath) {
		if( memo == null || memo.isEmpty() ) return false;
		if( filePath == null || filePath.isEmpty() ) return false;
		FileWriter fw;
		try {
			fw = new FileWriter(filePath, false);
//			fw = new FileWriter(filePath, true);
			// true �̾�� append ��� ������ ����
			// false ����� overwrite ��� ���Ϸ� ����
			fw.write(memo);
			fw.close();
			return true;
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println(filePath+"�� ���� ����!!");
		} 			
		return false;
	}
	
	// �ؽ�Ʈ ���� �о����
	public static String loadMemoFromFile(String filePath) {
		if( filePath == null || filePath.isEmpty() ) return null;
		
		String memo = "";
		try {
			FileReader fr = new FileReader(filePath);
//			fr.read() // ����
//			fr.read(array) // ���ڵ�?
			BufferedReader br = new BufferedReader(fr);
				// ���۸�/��Ʈ����?
			String line = null;
//			while(true) {
//				line = br.readLine(); // ����(��)���� �о��
//				memo += line; // ���پ� �����ϱ�
//				if( line == null ) break;
//			}
			while( (line = br.readLine()) != null ) {				
				//memo += line; // ���پ� �����ϱ�
				memo += line + "\r\n"; // ���پ� �����ϱ� + ���๮��
			}
			br.close();
			fr.close();
			return memo;
		} catch (IOException e) {
			System.out.println(filePath +"���� �б� ����!!");
		}
		
		return null;
	}
	
}

