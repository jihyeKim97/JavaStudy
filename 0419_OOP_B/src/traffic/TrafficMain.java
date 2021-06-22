package traffic;

import traffic.land.ByCycle;
import traffic.land.Car;

public class TrafficMain {

	// Ż�� �ϳ� �޾Ƽ� �� ������ ����ϱ�
	public static void printVehicle(Vehicle vh) {
		System.out.println("==== Ż��  ====");
		System.out.printf(
 "<<VH>> %d���� ������ ������ %s �̸��� \n\t %d�ν�  '%s'������ Ż�� \n", 
		 vh.wheel, vh.brand, vh.seats, 
		 Vehicle.TYPES[vh.type] );
		System.out.println("-------------");
	}
	
	public static void main(String[] args) {
		Vehicle vh1 = new Vehicle(2, Vehicle.TYPE_ZERO,
				"Ż�� ����ǰ1", 1);
//		System.out.println(vh1); // toString()
//		vh1.printVehicle(); // x
		//TrafficMain.printVehicle(vh1);
		printVehicle(vh1);
	
		ByCycle bc1 = new ByCycle("��õ��2021K(��������)"
				, 1); // ��� ����?
//		System.out.println(bc1);
		printVehicle(bc1);
			// �����ŵ� Ż���� �� �����ν� ����.. ��Ӵ�����
		
		ByCycle bc2 = new ByCycle("������", 2,
				ByCycle.ADV_PEDAL, 2);
//		System.out.println(bc1);
		printVehicle(bc2);
		
		Car cr1 = new Car(); // ����ī
//		System.out.println(cr1);
		printVehicle(cr1); 
			// �ڵ����� Ż���� �� �����ν� ����.. ��Ӵ�����
		
	}	

}

/*
==== Ż��  ====
<<VH>> 2���� ������ ������ Ż�� ����ǰ1 �̸��� 
	 1�ν�  '���� �����Ӹ� �ִ� Ż��'������ Ż�� 
-------------
==== Ż��  ====
<<VH>> 2���� ������ ������ ��õ��2021K(��������) �̸��� 
	 1�ν�  '�����ŷ�'������ Ż�� 
-------------
==== Ż��  ====
<<VH>> 2���� ������ ������ ������ �̸��� 
	 2�ν�  '�����ŷ�'������ Ż�� 
-------------
==== Ż��  ====
<<VH>> 4���� ������ ������ ������ �� �̸��� 
	 4�ν�  '�¿�����'������ Ż�� 
-------------

*/