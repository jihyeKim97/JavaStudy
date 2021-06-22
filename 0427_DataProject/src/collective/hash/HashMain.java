package collective.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
	https://ko.wikipedia.org/wiki/%ED%95%B4%EC%8B%9C_%ED%85%8C%EC%9D%B4%EB%B8%94
	https://ko.wikipedia.org/wiki/%ED%95%B4%EC%8B%9C_%ED%95%A8%EC%88%98
	해시 테이블(맵), 해시 함수
	
	해시(Hash, 맵Map, 사전Dictionary)
	: 대응(mapping) 관계를 표현한 자료구조의 대표형.	
 	영어사전:  key(hat 단어이름) => value(모자란 뜻에 대응)
 	지도:     key(위도/경도) => value(지도상 한 위치)
 	이름 => 사물,  태그 => 데이터,   키 => 자물쇠
 	
 	key => value 대응관계가 해시의 기본 단위. 
 	대응관계를 자바에서는 MapEntry라고 함. (키,밸류)의 쌍으로 Pair라고함.
 	pair들의 집합을 해시맵이라고 함.
 	
 	엄밀히보면, 해시맵은 집합처럼 순서가 없음.. 그냥 pair들의 집합임. 
 	
 	반드시 Key는 '고유'해야함. (중복 x), Key들은 나중에 정렬이 가능함...
 	다만, Value는 고유하지 않아도 되며(중복 o), 심지어 null도 됨.
 	java.util.Map 인터페이스, 이를 구현한 java.util.HashMap
*/

public class HashMain {

	public static void main(String[] args) {
		/*---------------------------------------- [1번] ---------------------------------------*/
//		 Map<K, V> 인터페이스 구현
//		 = new HashMap<String, Integer>();
//		HashMap<String, Integer> hm
//				= new HashMap<>(); // 해시맵 size 0 생성
//		// 해시맵: 쌍(pair)의 요소타입을 제한 generic(타입파라미터 제한)
//		// 키타입을 문자열로 제한, 밸류타입을 정수로 제한.
//		// 학생이름 문자열 키 => 나이 정수 대응
//		hm.put("사헌", 26); // size++
//		hm.put("주현", 24);
//		hm.put("경진", new Integer(28));
//		hm.put(""+123, 33);
//		hm.put(String.valueOf(123), 24);
//
//		System.out.println("** 해시맵의 크기(학생수): " + hm.size());
//		System.out.println("사헌씨의 나이 :   사헌   =>  " + hm.get("사헌"));
//		// READ 고유키에 대응하는 벨류가 리턴
//		System.out.println("경진씨의 나이 :   경진   =>  " + hm.get("경진")+"세");
//		System.out.println("주현씨의 나이 :   주현   =>  " + hm.get("주현")+"세");
//		System.out.println("영주씨의 나이 :   영주   =>  " + hm.getOrDefault("영주ORI", 23)+"세"); // 기본값이 옵션으로 제공
		/*---------------------------------------- [2번] ---------------------------------------*/
		HashMap<String, Integer> hm = new HashMap<>();

		String[] keys = null;
		keys = new String[] { "석준", "동근", "주현", "경진", "영주", "수현", "지혜", "지원", "진영", "종세" };
		// Values list ready
		ArrayList<Integer> values = new ArrayList<>();
		for (int i = 0; i < keys.length; i++) {
			Integer age = (int) (Math.random() * 100) + 1;
			values.add(age);
		}
		// mapping loop : 10개의 각 Pair가 만들어지고 모두 해쉬맵의 요소가됨
		// key 배열 -> valueslist에 키의 순서에 따라 순타적으로 대응 루프
		for (int i = 0; i < keys.length; i++) {
			hm.put(keys[i], values.get(i)); // 맵엔크리, 페어
		}
		// 맵의 키들의 순서대로 키를 중심으로 루프를 탐색하면서 pair를 출력

		for (int i = 0; i < keys.length; i++) {
			String keey = keys[i];
			Integer valuee = hm.get(keey);
			System.out.println("키 : " + keey + "학생 " + "->> 벨류 : " + hm.get(keys[i]) + "세");
		}
		System.out.println("----------------");
		for (int i = keys.length - 1; i >= 0; i--) {
			String keey = keys[i];
			Integer valuee = hm.get(keey);
			System.out.println("키 : " + keey + "학생 " + "->> 벨류 : " + hm.get(keys[i]) + "세");
		}
		/*---------------------------------------- [3번] ---------------------------------------*/
		// 맵의 키들을 한번에 얻어오기
//		hm.put("+재육",24);
//		hm.put("+만섭",28);
		Set<String> keySet = hm.keySet();
		// 인터페이스 Set타입으로 해쉬맵의 모든 키들을 묶어서 하나의 집합으로 리턴
		// Set 인터페이스를 구현한 객체가 리턴
		// 인터페이스 다형성 : 인터페이스를 구현한 모든 클래스의 객페들은 해당 인터페이스형 변수에 담을수 있다.
		// 키 들의 집합이라 순서가 개념이 없다
		System.out.println("----------------");
		System.out.println("해시맵의 크기(학생수)" + hm.size());
		hm.remove("-동근");
		hm.remove("-석준");
		for (String key : keySet) {
			System.out.println("키 : " + key + "학생 " + "->> 벨류 : " + hm.get(key) + "세");
		}
		/*---------------------------------------- [4번] ---------------------------------------*/
//		hm.clear();
//		// 동시성 위배 에러() ---------------------1번
//		for (String key : keySet) {
//			// 지워진 벨류가 리턴
//			Integer oldValue = hm.remove(key);
//			System.out.println("-----------remove---------");
//			System.out.println("키 : " + key + "학생 " + "->> 벨류 : " + oldValue + "세");
//			
//		}
//		// 동시성 위배 에러() ---------------------2번
//		for (String key : keySet) {
//			// 맵에 해당키가 포함 되었는지 확인
//			if(hm.containsKey(key) == true) {
//				Integer oldValue = hm.remove(key);
//				System.out.println("-----------remove---------");
//				System.out.println("키 : " + key + "학생 " + "->> 벨류 : " + oldValue + "세");
//			}
//		}
//		// 동시성 위배 에러()방지 코드 ---------------------3번
		// keySet 집합을 이용항뎌 이터레이션 수행
		// iterator 인터페이스: 한번에 하나씩 반복적으로 수행 / 어떤 특정한 기간동안 하나씩 처리함
		// 제너릭이 포함

		// 수동으로 표현한 iterator
		Iterator<String> it = keySet.iterator();
		// 단방향 iterator
		// it.hasNext(); -->> 집합에서 탐색할 다음 요소가 있는지 ? T : F
		while (it.hasNext() == true) { // iterator 가 false가 될때까지 = 더이상 요소가 없을때 까지 루프 실행
			// it.next(); -->> 요소 하나를 리턴
			String key = it.next();
			if (hm.containsKey(key)) {
				System.out.println("키 : " + key + "학생 " + "->> 벨류 : " + hm.get(key) + "세");
				it.remove(); //  iterator자체를 삭제
			}
		}
		printStydentAgeMap(hm);

	}

	private static void printStydentAgeMap(HashMap<String, Integer> hm) {
		if (hm == null) {
			System.out.println("맵이 null!!");
			return;
		}
		System.out.println("** 해시맵의 크기(학생수): " + hm.size());
		if (hm.isEmpty()) {
			System.out.println("학생이 없네요!!");
		} else {
			Set<String> keySet = hm.keySet();
			for (String key : keySet) {
				System.out.println(" 키: " + key + " 학생" + " => 밸류: " + hm.get(key) + "세");
			}
		}
	}

}
