package HomeWork_0427;

import java.util.Scanner;

/*
 * https://translate.google.com
  (상속/문자열) 실습과제: 

 1. 인사말 클래스 구현 
   class MessageKorean 정의하여 아래처럼 실행함.
   (args[]를 이용하여 이용하여 문자열 입력을 받음) 
   
   arge[0] =  "kr";
   
   
 	args[0] "kr" 입력의 경우
 	0. 안녕하세요?
 	1. 안녕히 주무셨어요?
 	2. 안녕히 주무세요.
 	3. 식사 하셨습니까?
 	4. 잘 지내셨습니까?
 	5. 오랜만입니다. 
 	6. 처음뵙겠습니다.
 	7. 다음에 또봅시다.
 	
 	"kr" => args[0]
 	"0" => args[1] 
 	"kr" "0" 입력의 경우
 	0. 안녕하세요?
 	
 	"kr" "1" 입력의 경우
 	1. 안녕히 주무셨어요?
 	
 	"kr" "6" 입력의 경우 	
 	6. 처음뵙겠습니다.
 	 	
  2a. 

  위 1번을 응용하여 메시지세트가 다국어(나라별로 8개 메시지 배열로 저장)로 확장.
    즉, MessageEnglish "en", MessageJapanese "jp", 
    MessageGerman "de", MessageFrance "fr", 
    MessageChinese "ch"... 
    5개의 다국어 메시지 클래스들을 모두 정의 
 	(Scanner next()를 이용하여 문자열 입력을 받음)
 	아래 처럼 반복 루프를 실행...  exit를 입력시 종료.
 	
 	* 인사말 선택 입력: en1
 	en1 => Good Morning? 
 	
 	* 인사말 선택 입력: jp1
 	jp1 => おはようございます
 	
 	* 인사말 선택 입력: kr
 	0. 안녕하세요?
 	1. 안녕히 주무셨어요?
 	2. 안녕히 주무세요.
 	3. 식사 하셨습니까?
 	4. 잘 지내셨습니까?
 	5. 오랜만입니다. 
 	6. 처음뵙겠습니다.
 	7. 다음에 또봅시다.
 	

  2b. 

 	* 인사말 선택 입력: jp1,kr4
 	jp1 => おはようございます
 	kr4 => 잘 지내셨습니까?

 	* 인사말 선택 입력: jp1,jp1,en3,kr4,jp4,fr7,de(모두출력)
 	jp1 => おはようございます
 	jp1 => おはようございます
 	en3 => Have you eaten? (Full?) 
 	kr4 => 잘 지내셨습니까?
 	jp4 => 元気でしたか？
 	fr7 => A la prochaine fois.
 	de0 => ..
 	de1 =>..
 	...
 	de7 =>..
 	
 	* 인사말 선택 입력: exit
 	<종료>
 	
 3. 위 2번을 활용하여 구현하되, 메시지세트의 길이가
    13개로 증가...
    0. 안녕하세요?
 	1. 안녕히 주무셨어요?
 	2. 안녕히 주무세요.
 	3. 식사 하셨습니까?
 	4. 잘 지내셨습니까?
 	5. 오랜만입니다. 
 	6. 처음뵙겠습니다.
 	7. 다음에 또봅시다.
 	8. 안녕!
 	9. 고생하셨습니다.
 	10. 반갑습니다. 
 	12. 메리 크리스마스.
 	11. 새해 복 많이 받으세요!
    
 	(상속 기반으로 2번을 재구현하여 동일 실행
 	  UML 클래스 다이어그램 그려보기를 권장.)
 	Message 상위 클래스를 구현 (공통)
 		  MessageKorean 하위클래스
 		  MessageEnglish 하위클래스
 		  MessageJapanese 하위클래스
 		  MessageGerman 하위클래스
 		  MessageChinese 하위클래스
 		  MessageFrance 하위클래스
 	
    (Scanner next()를 이용하여 문자열 
    	입력을 받으며 영문대소문자 구분없음)
    
    * 인사말 선택 입력: jp12,JP1,En10,kR11
 	jp12 => おはようございます
 	JP1 => おはようございます
 	En10 => Have you eaten? (Full?) 
 	kR11 => 잘 지내셨습니까?
 	
 	* 인사말 선택 입력: exit 혹은 Exit 혹은 EXIT
 	<종료>
    
*/

public class HomeMain {

	public static final String[] KR_LEG = { "안녕하세요?", "안녕히 주무셨어요?", "안녕히 주므세요", "식사 하셨나요?", "잘 지내셨습니까?", "오랜만입니다",
			"처음뵙겠습니다", "다음에 또 봅시다", "안녕?", "고생하셨습니다", "반갑습니다.", "새해 복 많이 받으세요!", "메리 크리스마스" };
	public static final String[] EN_LEG = { "Hello", "Good morning?", "Good night", "Have you eaten?", "How are you?",
			"Long time no see.", "Nice to meet you.", "See you next time.", "Hi?" };
	public static final String[] JP_LEG = { "こんにちは", "よく眠っていた?", "おやすみ", "ご飯食べた?", "元気だった?", "久しぶりだ.", "はじめまして.",
			"次またましょう." };
	public static final String[] CH_LEG = { "你好", "早上好?", "晚安", "你吃了没?", "你好吗?", "好久不见.", "很高兴认识你.", "下次见." };
	public static final String[] FR_LEG = { "salut", "Bonjour?", "bonne nuit", "Avez-vous mangé?", "Comment ça va?",
			"Ça fait longtemps.", "Ravi de vous rencontrer.", "À plus tard." };
	public static final String[] LAG = { "kr", "en", "ch", "jp", "fr" };

	public static void main(String[] args) {
		/*-------------------------------- 1번 -----------------------------------------------*/
		String kr = "kr";
		for (String e : args) {
			if (e.equals(kr)) {
				for (int i = 0; i < KR_LEG.length; i++) {
					System.out.println(i + ". " + KR_LEG[i]);
				}
				System.out.println("---------------");
			}
			Scanner sc = new Scanner(System.in);
			System.out.print("Q. 다음 보기중 원하는 번호를 선택 하시오. : ");
			int number = sc.nextInt();
			for (int i = 0; i < KR_LEG.length; i++) {
				if (number == i) {
					System.out.println(i + ". " + KR_LEG[i]);
				}
			}
		}
	}
}
