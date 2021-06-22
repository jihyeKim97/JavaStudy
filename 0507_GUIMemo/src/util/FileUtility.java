package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// 파일의 종류 => 텍스트파일(문자셋으로 표현되는 데이터만으로 구성),
//					txt, java, html, sql, ...
//			   바이너리파일(1/0의 비트 이진데이터로 구성됨 => 포맷구조필요)
//					hwp, jpg, exe, png, mov, doc, ...

// 파일 읽기, 저장 유틸리티 클래스 
public class FileUtility {

	public static void main(String[] args) {
		final String testFilePath = "./test2.txt";  //1.txt";
		String testMemo = "Hello Elsa!! \n How are you doing??";
		//String testMemo = "Hello!! \n Anna~~~~ \n 점심 뭐먹지?? \n 그러게.";
		if( saveMemoToFile(testMemo, testFilePath) ) {
			System.out.println("test2.txt 파일 저장 성공!");
		}
		
		String memo = loadMemoFromFile(testFilePath);
		System.out.println("------------------------");
		System.out.println(memo);
		System.out.println("------------------------");
	}
	
	// 텍스트 파일 저장하기 (권한, 용량 믿고...)
	public static boolean saveMemoToFile(
			String memo, String filePath) {
		if( memo == null || memo.isEmpty() ) return false;
		if( filePath == null || filePath.isEmpty() ) return false;
		FileWriter fw;
		try {
			fw = new FileWriter(filePath, false);
//			fw = new FileWriter(filePath, true);
			// true 이어쓰기 append 모드 파일을 저장
			// false 덮어쓰기 overwrite 모드 파일로 저장
			fw.write(memo);
			fw.close();
			return true;
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println(filePath+"에 저장 실패!!");
		} 			
		return false;
	}
	
	// 텍스트 파일 읽어오기
	public static String loadMemoFromFile(String filePath) {
		if( filePath == null || filePath.isEmpty() ) return null;
		
		String memo = "";
		try {
			FileReader fr = new FileReader(filePath);
//			fr.read() // 글자
//			fr.read(array) // 글자들?
			BufferedReader br = new BufferedReader(fr);
				// 버퍼링/스트리밍?
			String line = null;
//			while(true) {
//				line = br.readLine(); // 한줄(행)단위 읽어옴
//				memo += line; // 한줄씩 누적하기
//				if( line == null ) break;
//			}
			while( (line = br.readLine()) != null ) {				
				//memo += line; // 한줄씩 누적하기
				memo += line + "\r\n"; // 한줄씩 누적하기 + 개행문자
			}
			br.close();
			fr.close();
			return memo;
		} catch (IOException e) {
			System.out.println(filePath +"에서 읽기 실패!!");
		}
		
		return null;
	}
	
}

