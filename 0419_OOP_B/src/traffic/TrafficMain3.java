package traffic;

import traffic.land.ByCycle;
import traffic.land.Car;

public class TrafficMain3 {

	// 자동차(류의 객체) 하나 받아서 그 내용을 출력하기
	public static void printCar(Car vh) {
		System.out.println("==== 탈것  ====");
		// 탈것 공통 정보 출력 -------------
		System.out.printf("<<VH>> %d개의 바퀴를 장착한 %s 이름의 \n\t %d인승  '%s'종류의 탈것 \n", vh.wheel, vh.brand, vh.seats,
				Vehicle.TYPES[vh.type]);
		System.out.println("-------------");
		// 탈것 중에서도 자동차의 정보 출력 -------------
		System.out.printf("\t+ %s 바퀴를 탑재, 구동방식 %s 식 made by %s!\n", vh.tire, Car.IMWD[vh.immobility], vh.maker);
		System.out.println("=============");
	}

	// 탈것 하나 받아서 그 내용을 출력하기
// v2
	public static void printVehicle(Vehicle vh) {
		// 탈것 공통 정보 출력 -------------
		System.out.println("==== 탈것  ====");
		System.out.printf("<<VH>> %d개의 바퀴를 장착한 %s 이름의 \n\t %d인승  '%s'종류의 탈것 \n", vh.wheel, vh.brand, vh.seats,
				Vehicle.TYPES[vh.type]);
		System.out.println("-------------");

		// 하위 탈것의 상세(특수) 정보 출력 -------------
		// 탈것의 종류 필드 type의 값에 따라 객체를 분류하여 상세부가 정보 출력
		switch (vh.type) {
		case Vehicle.TYPE_CAR: // 자동차 타입의 객체가 vh
			// 탈것 중에서도 자동차의 정보 출력 -------------
			// 객체지향형 "클래스타입 캐스팅"!!
			// 보통....! 상속 관계에 있는 객체들끼리 클래스 타입캐스팅이 가능함.
			// (타입캐스팅 == 자료형 강제로 변환)
			System.out.printf("\t+ %s 바퀴를 탑재, 구동방식 %s 식 made by %s!\n", ((Car) vh).tire,
					Car.IMWD[((Car) vh).immobility], ((Car) vh).maker);
			System.out.println("=============");
			break;

		case Vehicle.TYPE_BYCYCLE: // 자전거 타입의 객체가 vh
			System.out.printf("\t+ %s 페달 적용, 구동방식 %s 식\n", ((ByCycle) vh).pedal,
					ByCycle.IM_TYPES[((ByCycle) vh).immobility]);
			System.out.println("=============");
			break;
		case Vehicle.TYPE_MOTORBIKE: // 오토바이 타입의 객체가 vh

			break;
		default:
			System.out.println("!! 알 수 없는 교통수단 발견.");
			break;
		}
	}

// v1	
//	public static void printVehicle(Vehicle vh) {
//		System.out.println("==== 탈것  ====");
//		System.out.printf(
// "<<VH>> %d개의 바퀴를 장착한 %s 이름의 \n\t %d인승  '%s'종류의 탈것 \n", 
//		 vh.wheel, vh.brand, vh.seats, 
//		 Vehicle.TYPES[vh.type] );
//		System.out.println("-------------");
//	}

	public static void main(String[] args) {
		Vehicle vh1 = new Vehicle(2, Vehicle.TYPE_ZERO, "탈것 시제품1", 1);
//		System.out.println(vh1); // toString()
//		vh1.printVehicle(); // x
		// TrafficMain.printVehicle(vh1);
		printVehicle(vh1);

		ByCycle bc1 = new ByCycle("삼천리2021K(보조바퀴)", 1); // 어린이 수동?
//		System.out.println(bc1);
		printVehicle(bc1);
		// 자전거도 탈것의 한 종류로써 담긴담.. 상속다형성

		ByCycle bc2 = new ByCycle("레스포", 2, ByCycle.ADV_PEDAL, 2);
//		System.out.println(bc1);
		printVehicle(bc2);

		Car cr1 = new Car(); // 더미카
//		System.out.println(cr1);
		printVehicle(cr1); // v2
		// 자동차도 탈것의 한 종류로써 담긴담.. 상속다형성
//		printCar(cr1);

	}

}

/*
 * ==== 탈것 ==== <<VH>> 2개의 바퀴를 장착한 탈것 시제품1 이름의 1인승 '뼈대 프레임만 있는 탈것'종류의 탈것
 * ------------- ==== 탈것 ==== <<VH>> 2개의 바퀴를 장착한 삼천리2021K(보조바퀴) 이름의 1인승
 * '자전거류'종류의 탈것 ------------- ==== 탈것 ==== <<VH>> 2개의 바퀴를 장착한 레스포 이름의 2인승
 * '자전거류'종류의 탈것 ------------- ==== 탈것 ==== <<VH>> 4개의 바퀴를 장착한 제조사 모름 이름의 4인승
 * '승용차류'종류의 탈것 ------------- + 일반 고무타이어A 바퀴를 탑재, 구동방식 2륜 구동차 식 made by OEM!
 * =============
 * 
 */