package traffic.land;

import traffic.Vehicle;

/*
### 카류 Car 스키마 클래스
>traffic.land.Car 자동차류
>	=> 경차, 세단, 중형, RV, SUV, 스포츠카
> Vehicle의 직계 자식 클래스, 바퀴 4개이상..., 구동방식, 타이어(재질), 메이커
 */
//Object > Vehicle > Car 
public class Car extends Vehicle {
	public static final int WHEEL_CNT = 4;//바퀴 4개이상..., 
	public static final String DEF_TIRE = "일반 고무타이어A";
	public static final String ADV_TIRE = "특수 고무타이어S";
	public static final int IM_2WD = 0; // 2륜 구동
	public static final int IM_4WD = 1; // 4륜 구동
	public static final String[] IMWD = {
			"2륜 구동차","4륜 구동차"  
	};
	public static final String DEF_MAKER = "OEM";
	//
	public int immobility; // 구동방식 2WD, 4WD, ...
	public String tire; // 타이어(재질)
	public String maker; // 메이커

	public Car() {
		//super();
		super.type = TYPE_CAR;
		//this.type = TYPE_CAR;
		this.wheel = WHEEL_CNT; // 4
		this.immobility = IM_2WD;
		this.tire = DEF_TIRE; 
		this.maker = DEF_MAKER;
	}

	public Car(String tire, String maker) {
		this(WHEEL_CNT, IM_2WD, tire, maker);
	}
	
	public Car(int wheel, 
			int immobility, String tire, String maker) {
		this.type = TYPE_CAR;
		this.brand = NO_BRAND;
		this.seats = DEF_SEATS;
		this.wheel = wheel; 
		this.immobility = immobility;
		this.tire = tire;
		this.maker = maker;		
	}
	
	public Car(int wheel, int type, 
			String brand, int seats, 
			int immobility, String tire, String maker) {
		super(wheel, type, brand, seats);
		this.immobility = immobility;
		this.tire = tire;
		this.maker = maker;		
	}

	public Car(int wheel, int type, String brand, 
			int seats, float speed, long distance,
			String handleType, String fuel,
			int immobility, String tire, String maker) {
		super(wheel, type, brand, seats,
				speed, distance, handleType, fuel);
		this.immobility = immobility;
		this.tire = tire;
		this.maker = maker;
	}

	@Override
	public String toString() {
		//return "Car [immobility=" + immobility +
		return "Car [immobility=" + IMWD[immobility] +
				", tire=" + tire + 
				", maker=" + maker + "]";
	}
	
	
}





