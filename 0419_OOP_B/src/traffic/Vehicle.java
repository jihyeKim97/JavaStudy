package traffic;
/*
### 탈것 Vehicle 스키마 클래스   (DB vehicles TBL 테이블)
- 바퀴 (Wheel 1, 2, 3, 4, 6, ...) 개수 
- 차종
- 브랜드/이름
- 인원명수(탑승자수)
- 주행거리 
- 속도 
- 운전방식 (수동, 오토,... + 자율주행 4단계 시대?)
- 연료(석유/전기..)방식 
 */
public class Vehicle {
	public static final String[] TYPES = {
		"뼈대 프레임만 있는 탈것", "자전거류", "바이크류", 
		"승용차류", "버스류", "화물차류", "레일류"
	};
	public static final int TYPE_ZERO = 0;
	public static final int TYPE_BYCYCLE = 1;
	public static final int TYPE_MOTORBIKE = 2;
	public static final int TYPE_CAR = 3;
	public static final int TYPE_BUS = 4;
	public static final int TYPE_TRUCK = 5;
	public static final int TYPE_RAILS = 6;
	public static final int DEF_SEATS = 4; // 기본 좌석수
	public static final String NO_BRAND = "제조사 모름";
	public static final String MANUAL_HANDLE = "수동";
	public static final String AUTO_HANDLE = "오토";
	public static final String FUEL_OIL = "석유";
	public static final String FUEL_ELECTRIC = "전기";
	//
	public int wheel; //- 바퀴 (Wheel 1, 2, 3, 4, 6, ...) 개수 
	public int type; //- 차종번호 (TYPES인덱스)
	public String brand; //- 브랜드/메이커/이름..
	public int seats; // 좌석개수 - 인원명수(탑승자수)
	public float speed; // - 속력, 속도
	public long distance; // - 주행거리 
	public String handleType; //- 운전방식 (수동, 오토,... + 자율주행 4단계 시대?)
	public String fuel; // - 연료(석유/수소/전기/핵..)방식
	
	public Vehicle() {
		//super(); // Object 상위 클래스를 초기화.. 생략
		this(2, TYPE_ZERO);
	}

	public Vehicle(int wheel, int type) {
		this(wheel, type, NO_BRAND, DEF_SEATS);
	}
	
	public Vehicle(int wheel, int type, String brand, 
			int seats) {
		this(wheel, type, brand, seats, 
				0.0f, 0, MANUAL_HANDLE, FUEL_OIL);
//		super();
//		this.wheel = wheel;
//		this.type = type;
//		this.brand = brand;
//		this.seats = seats;
//		this.speed = 0.0f;
//		this.distance = 0;
//		this.handleType = MANUAL_HANDLE;
//		this.fuel = FUEL_OIL;
	}

	public Vehicle(int wheel, int type, String brand,
			int seats, float speed, long distance,
			String handleType,
			String fuel) {
		//super(); // Object 상위 클래스를 초기화..
		this.wheel = wheel;
		this.type = type;
		this.brand = brand;
		this.seats = seats;
		this.speed = speed;
		this.distance = distance;
		this.handleType = handleType;
		this.fuel = fuel;
	}

	// 오버라이딩(함수 재정의) - 부모의 물려준 기능을 자식이 변경/개선하여 재정의함.
	@Override
	public String toString() {
		return "Vehicle [wheel=" + wheel + ", type=" + type + ", brand=" + brand + ", seats=" + seats + ", speed="
				+ speed + ", distance=" + distance + ", handleType=" + handleType + ", fuel=" + fuel + "]";
	}
	
	
}




