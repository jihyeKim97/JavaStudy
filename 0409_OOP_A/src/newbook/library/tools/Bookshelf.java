package newbook.library.tools;
// 신규 스키마 (개념)
// - 속성: 서재, 책꽂이, 책상자, 책장.. , 북스탠드
// .. 책 수용량(개수), 재질, 크기(디메션), 
// .. 일련번호(관리), 위치정보 (층), 라벨스티커??, 카테고리..
// + 구매 날자, 제조사, 가격, 담당자사서명, ...
// - 기능: 
//		책을 하나를 비치할 수 있다. (책배열필드에 하나의 요소공간(slot)에 책 객체 추가)
//      책들의 정보를 순차적으로 출력할 수 있다.
//  .. 서재의 임의 책 하나를 꺼내 수 있다.(책개체를 배열에서 제거?)
//  .. 책을 하나 갱신(교환)할 수 있다.
//  .. 모든 책을 다 비울 수 있다. 
//  책꽂이의 상태(현재 수용량)을 확인할 수 있다.(다 비웠음, 일부 비워져 있음, 
//  모두 꽉채워져 있음(더 이상 신규 책을 비치할 수 없는 상태..)

import newbook.Book;

public class Bookshelf {
	public static final Book EMPTY = null; // 책장 속 배열의 빈칸 표현
	public static final int DEF_SIZE = 4; 
	// 최소 4권 부터 수용해야 도서관 책장의 자격이 있음.
	
	public int no; //일련번호(관리)
	public String label; //라벨스티커??, 카테고리. 재질..
	public int floor; // 층 번호
	public int size; // 책 수용량 개수 (volume)
	public Book[] books; // 실제 책들이 위치할 공간 확보.. /배열타입 필드
	// 책장이 비워져 있다? 어떻게 표현? 처음에 책장이 들어오면 공간이 비었음?
	
	// 기본생성자 
	public Bookshelf() { 
		// 필드마다 자신의 기본값으로 자동초기화됨...
	}
	
	// 중간 생성자들
	public Bookshelf(int no, String label, int floor) {		
		this.no = no;
		this.label = label;
		this.floor = floor;
		this.size = DEF_SIZE;
		this.books = new Book[this.size]; 
			// 사이즈 4짜리 고정 배열을 동적 메모리 할당..
//		this.books = new Book[]{ null, null, null, null };
//		this.books = new Book[]{ EMPTY, EMPTY, EMPTY, EMPTY };
	} 
	
	// 책장의 크기만 명시하면... 생성자 내부에서 책장의 공간을 배열생성으로 동적확보.
	// --- 아직은 이해가 어려움!!!!!!!!! 
	public Bookshelf(int no, String label, int floor,int size) {		
		this.no = no;
		this.label = label;
		this.floor = floor;
		this.size = size;
		this.books = new Book[size]; // size가 4 ~ 100? 안전범위.
		// books는 책객체들을 다수개 즉, size개수만큼 최대한 배치할 수 있는
		// 책장객체의 공간인 배열로 표현.
		// 배열 변수 필드 books 자체는 레퍼런스형이라서 반드시 
		// 단 한번의 new로 생성처리를 해야 비로소 공간을 갖는다.
		// 그리고 그 배열의 요소 공간 모두는 각각 null로 자동초기화됨.
	} 
		
	// 풀생성자
	// 외부에서 책들을 배치할 공간인 배열을 '미리' 만들어서 가져와 책장을 초기화
	public Bookshelf(int no, String label, int floor,
			int size, Book[] books) {		
		this.no = no;
		this.label = label;
		this.floor = floor;
		this.size = size;
		this.books = books;
	} 
	
	
	// 책장 내용 상세출력하기 - 책장 속 배열공간에 비치된 책객체들을 차례차례 표시
	// 함수오버로딩
	public void printBookshelf(boolean detail) {
		System.out.println("┌──────────────┐");  // ㅂ + 한자키
		System.out.println(this.no +"번 책장:: <" + floor +">층");
		System.out.println("\t 레이블: " + label);
		System.out.println("\t 도서 수용량: "+ this.size + "~권까지 가능");
		System.out.println("───────────────");
		//for (int i = 0; i < books.length; i++) {
		int slot = 0;
		for( Book book :   this.books ) {
			System.out.print("["+ (++slot) +"] ");
			// 책장의 이번 회차 슬롯공간에 책이 없어?
			if( book == EMPTY ) // null )
				System.out.println(" -- slot 비었음 -- ");		
			else {
				System.out.print( detail == true ? 
						"BKNUM::" + book.no : "" );
				System.out.print(book.title);
				System.out.print(" ["+book.author+"] ");
				System.out.print( " 도장: " 
				+ (detail == true && book.stamp ? 
						"◎reg " : "없음 " ) );
				
				//System.out.println( book.getStarRating());// private 에러
				System.out.println( book.getStarRating()); // public 보임/접근/사용
				//book.printBook();
			}
		}
		
		System.out.println("└──────────────┘"); 
	}
	

	
	
	public void printBookshelf() {
		System.out.println("┌──────────────┐");  // ㅂ + 한자키
		System.out.println(this.no +"번 책장:: <" + floor +">층");
		System.out.println("\t 레이블: " + label);
		System.out.println("\t 도서 수용량: "+ this.size + "~권까지 가능");
		System.out.println("───────────────");
		//for (int i = 0; i < books.length; i++) {
		int slot = 0;
		for( Book book :   this.books ) {
			System.out.print("["+ (++slot) +"] ");
			// 책장의 이번 회차 슬롯공간에 책이 없어?
			if( book == EMPTY ) // null )
				System.out.println(" -- slot 비었음 -- ");		
			else {
				System.out.print(book.title);
				System.out.print(" ["+book.author+"] ");
				//System.out.println( book.getStarRating());// private 에러
				System.out.println( book.getStarRating()); // public 보임/접근/사용
				//book.printBook();
			}
		}
		
		System.out.println("└──────────────┘"); 
	}
	
	// 책장 내용 간이출력하기
	
	
	//	책을 하나를 비치할 수 있다. (책배열필드에 하나의 요소공간(slot)에 책 객체 추가)
	// 수동방식, 자동방식?
	// 널객체책, 장르불일치 책, 슬롯번호 비정상, 슬롯이 사용가능? empty?
	public boolean addBook(int slot, Book book) {
		if( book == null ) {
			System.out.println("책장에 넣을 책 자체가 없어요. null!");
			return false;
		}
		// 최소 1개 이상의 수용량이 보장되면 이후 진행..
		if( this.isFull() == true ) {
			System.out.println("해당 책장은 최대수용량 " + 
				this.size + "에 이미 도달하여서 더 이상 비치 못함!!");
			return false;
		}
		
		//if( slot >= 0 && slot <= this.books.length-1 )
		if( slot >= 0 && slot <= this.size - 1 ) {
			if( this.books[slot] == EMPTY ) {
				// 안전하게 책 배치 가능 영역
				books[slot] = book;  // 책꽂이 칸에 책 넣기
				return true;
			} else {
				Book anotherBook = this.books[slot];
				System.out.println(
					"해당 슬롯이 이미 사용중(다른책: "+ 
						anotherBook.title +")");
				return false;
			}
		} else {
			System.out.println("슬롯 번호가 범위를 벗어난 오류!! " 
						+ slot + " / " + size);
			return false;	
		}
	}

	//모두 꽉채워져 있음(더 이상 신규 책을 비치할 수 없는 상태..)을 체크하기
	private boolean isFull() { // 만칸?/ 비공개 함수(클래스 내부)
		boolean bFull = true;
		for (int i = 0; i < books.length; i++) {
			if( books[i] == EMPTY ) {
				// 맨 처음 만나는 단 하나의 빈칸은 FULL이 아님!! // 소수판별 (약수?)
				bFull = false;
				break;
			}
		}
		return bFull;
	}
	public boolean isFull2() { // 공개된 함수
		for (int i = 0; i < books.length; i++) {
			if( books[i] == EMPTY ) 
				// 맨 처음 만나는 단 하나의 빈칸은 FULL이 아님!! 
				return false;
		}
		return true;
	}
	
	//  책들의 정보를 순차적으로 출력할 수 있다.
	//.. 서재의 임의 책 하나를 꺼내 수 있다.(책개체를 배열에서 제거?)
	//.. 책을 하나 갱신(교환)할 수 있다.
	//.. 모든 책을 다 비울 수 있다. 
	//책꽂이의 상태(현재 수용량)을 확인할 수 있다.(다 비웠음, 일부 비워져 있음, 

}




