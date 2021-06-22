package traffic.land;
import traffic.Vehicle;

/*
### 자전거류 ByCycle 스키마 클래스 
>  traffic.land.ByCycle 자전거류
> Vehicle의 직계 자식 클래스, 바퀴 2개..., 페달...  구동방식??
*/
// Object > Vehicle > ByCycle 
public class ByCycle extends Vehicle {
	public static final int WHEEL_CNT = 2; // 바퀴 2개..., 페달...
	public static final String DEF_PEDAL = "나무 페달";
	public static final String ADV_PEDAL = "철제 페달";
	public static final String[] IM_TYPES = {
		"부모님밀기", "어린이발수동",
		"페달수동", "기어페달수동", "오토페달" 	
	};	
	public String pedal; // 페달
	public int immobility; // 구동방식?
	
	public ByCycle() {
		this(Vehicle.NO_BRAND, 0); // 부모님밀기
	}

	public ByCycle(String brand, int immobility) {
		this(brand, 1, DEF_PEDAL, immobility);
	}
	
	public ByCycle(String brand, int seats, 
			String pedal, int immobility) {
		super( WHEEL_CNT, 
//				TYPE_BYCYCLE,
				Vehicle.TYPE_BYCYCLE, 
				brand, seats);
			// Vehicle(wheel, type, brand, seats) 생성자..
		this.pedal = pedal;
		this.immobility = immobility;
	}
	
	public ByCycle(int wheel, int type, 
			String brand, int seats, 
			String pedal, int immobility) {
		super( wheel,type, 
				brand, seats);
			// Vehicle(wheel, type, brand, seats) 생성자..
		this.pedal = pedal;
		this.immobility = immobility;
	}

	@Override
	public String toString() {
		return 
		"Vehicle [wheel=" + wheel + ", type=" + type 
		+ ", brand=" + brand + ", seats=" + seats + 		
		"\n ByCycle [pedal=" + pedal + 
		", immobility=" + immobility + "]";
	}

//	@Override
//	public String toString() {
//		return "ByCycle [pedal=" + pedal + ", immobility=" + immobility + ", wheel=" + wheel + ", type=" + type
//				+ ", brand=" + brand + ", seats=" + seats + ", speed=" + speed + ", distance=" + distance
//				+ ", handleType=" + handleType + ", fuel=" + fuel + "]";
//	}
	
	
	
	
}
