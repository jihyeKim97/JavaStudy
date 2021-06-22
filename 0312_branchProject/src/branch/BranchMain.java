package branch;

import java.util.Date;
// ����Ʈ�� ���ؼ� �� �ҽ��ڵ� Ŭ���� BranchMain8 �ȿ��� ���ڽð��� ó���ϴ� ����� Date�� �������ڴٴ� ����.

// ���ϸ��� ���� �� ��� ���� ���α׷� 
/* 
 PLATINUM ��� 100000~ �̻� 
 DIAMOND ��� 40000 ~ 100000 �̸� 
 GOLD ��� 20000 ~ 40000	
 SILVER ��� 12000 �̻� ~ 20000 �̸�
 BRONZE ��� 5000 �̻� ~ 12000 �̸�
 BASIC �⺻��� 0(�̻�) ~ 5000�̸�
 */

public class BranchMain {
	public static final String NO_RANK = "��� ����";
	public static final int BASIC = 0,DEF_POINT = 3000,BRONZE = 5000,SILVER = 12000,GOLD = 20000,DIAMOND = 40000,PLATINUM = 100000; 
	static final int ACTION_NO_ACT = 0,ACTION_LOGIN = 1,ACTION_WRITE = 2,ACTION_READ = 3,ACTION_LIKE = 4,ACTION_PURCHASE = 5,ACTION_SERVICE = 6,EXIT_ACTION_LIMIT = 20; 

	public static int getPurchaseMileage(int price) {
		int purchaseMile = 0;
		
		// ���� Ȱ���� ���� ���� => ���Ż�ǰ ������ 1.x ~ 3.0% ����(�ݿø�)
		double percent = Math.random() * 3.0 + 1.0;
		if (percent > 3.0)
			percent = 3.0; // ���� ���� (�ִ밪)

		// int purchaseMile = (int)(price * 0.01);  // 1%
		// purchaseMile = (int) Math.round(price * 0.01);
		purchaseMile = (int) (Math.round(price * percent / 100.0));// �����(%)

		System.out.println("\t��ǰ ���ž�: " + price + "��");
		System.out.println("\tpercent = " + percent + "% ������");
		System.out.println("\tpurchaseMile " + purchaseMile + "pt");

		return purchaseMile;
	}

	public static void main(String[] args) {
		String name = "���";
		int mileage = DEF_POINT; 
		int activity = ACTION_NO_ACT;
		// => ����Ʈ�� �߻���Ű�� ȸ�� Ȱ����... (�ð�, ���� ���� ���)
		int count = 1;
		boolean flag = true;

		while (flag) {
			// ;
			activity = (int) (Math.random() * 6) + 1;
			System.out.printf(">> %d ȸ�� Ȱ��: ", count);

			// ȸ�� Ȱ�� ���� ����Ǿ���? ���� �ð�..
			Date actTime = new Date(); // ���ڽð� ��ü ���� // java.util.Date JVM�� �������� OS�� ���� �ð��� ������.
			String actStamp = " [" + actTime + "] ";

			if (activity == ACTION_LOGIN) {
				System.out.print("ACTION �α��� ����");
				mileage += 50;
			} else if (activity == ACTION_WRITE) {
				System.out.print("ACTION �۾��� ����");
				mileage += 100;
			} else if (activity == ACTION_READ) {
				System.out.print("ACTION ���б� ����");
				mileage += 10;
			} else if (activity == ACTION_LIKE) {
				System.out.print("ACTION ���ƿ� ����");
				mileage += 500;
			} else if (activity == ACTION_PURCHASE) {
				System.out.print("ACTION ��ǰ���� ����");
				int price = (int) (Math.random() * 100000);
				mileage += getPurchaseMileage(price);
			} else if (activity == ACTION_SERVICE) {
				System.out.print("ACTION �ΰ����񽺰��� ����");
				int addSvc = (int) (Math.random() * 4); // 0 ~ 3
				int[] ptsAddSvc = { 5000, 10000, 20000, 30000 };
				String[] namesAddSvc = { "��������", "�������", "������Ʈ����", "������Ư���ݰ�����" }; // �迭 Array -- ���� ���� ���� �����͵��� �� �ϳ��� ��ǥ�̸����� ����.// �迭�� ptsAddSvc[0] ���...
				System.out.println("\n~~~ ������ �ΰ� ���� �̸�: " + namesAddSvc[addSvc]);
				System.out.println("~~~ �ΰ����� ����pt: " + ptsAddSvc[addSvc]);
				int addSvcMile = ptsAddSvc[addSvc];
				mileage += addSvcMile;
			} else {
				System.out.println(">> ����ġ ���� activity: " + activity);
			}
			System.out.printf(" �̹� Ȱ������ ������ �� ���ϸ���: %d pt\n", mileage);
			String thisRank = getMemberRank5(mileage);
			System.out.printf(" ���� ��� ���: %s\n", thisRank);
			System.out.println("--Ȱ���� ���� ���� �ð� : " + actStamp+"\n~~~~~~~~~~~~~~~~");

			// ���� ����
			if (count >= EXIT_ACTION_LIMIT)
				flag = false;
			count++;
		}

		// ��� ���� - pt�� ��� ������ ���ϴ���?
		String rank = NO_RANK; 
		if (mileage < 0) {
			System.out.println("[����] ó���� �� ���� ���ϸ��� �߰�! - " + mileage);
		} else {
			rank = getMemberRank5(mileage);
			System.out.println("-----------------\n"+" ** ���� ��� ����:  "+"\n-----------------"+"\n>> ȸ�� �̸�: " + name+"\n>> ȸ�� ���ϸ���: " + mileage + "pt"+"\n>> ȸ�� ���: " + rank+"\n-----------------");
		}
	}

	private static String getMemberRank5(int mileage) {
		if (mileage >= BASIC && mileage < BRONZE)return "Basic ���";
		else if (mileage < SILVER)return "Bronze ���";
		else if (mileage < GOLD)return "Silver ���";
		else if (mileage < DIAMOND)return "Gold ���";
		else if (mileage < PLATINUM)return "Diamond ���";
		else return "PLATINUM ���";
	}
	private static String getMemberRank4(int mileage) {
		if (mileage >= BASIC && mileage < BRONZE)return "Basic ���";
		else if (mileage >= BRONZE && mileage < SILVER)return "Bronze ���";
		else if (mileage >= SILVER && mileage < GOLD)return "Silver ���";
		else if (mileage >= GOLD && mileage < DIAMOND)return "Gold ���";
		else if (mileage >= DIAMOND && mileage < PLATINUM)return "Diamond ���";
		else return "PLATINUM ���";
	}
	private static String getMemberRank3(int mileage) {
		String rank = "PLATINUM ���";
		if (mileage >= BASIC && mileage < BRONZE)rank = "Basic ���";
		else if (mileage >= BRONZE && mileage < SILVER)rank = "Bronze ���";
		else if (mileage >= SILVER && mileage < GOLD)rank = "Silver ���";
		else if (mileage >= GOLD && mileage < DIAMOND)rank = "Gold ���";
		else if (mileage >= DIAMOND && mileage < PLATINUM)rank = "Diamond ���";
		return rank;
	}
	private static String getMemberRank2(int mileage) {
		String rank;
		if (mileage >= BASIC && mileage < BRONZE)rank = "Basic ���";
		else if (mileage >= BRONZE && mileage < SILVER)rank = "Bronze ���";
		else if (mileage >= SILVER && mileage < GOLD)rank = "Silver ���";
		else if (mileage >= GOLD && mileage < DIAMOND)rank = "Gold ���";
		else if (mileage >= DIAMOND && mileage < PLATINUM)rank = "Diamond ���";
		else rank = "PLATINUM ���";
		return rank;
	}
	private static String getMemberRank(int mileage) {
		String rank;
		if (mileage >= BASIC && mileage < BRONZE)rank = "Basic ���";
		else if (mileage >= BRONZE && mileage < SILVER)rank = "Bronze ���";
		else if (mileage >= SILVER && mileage < GOLD)rank = "Silver ���";
		else if (mileage >= GOLD && mileage < DIAMOND)rank = "Gold ���";
		else if (mileage >= DIAMOND && mileage < PLATINUM)rank = "Diamond ���";
		else if (mileage >= PLATINUM)rank = "PLATINUM ���";
		else rank = "ó���� �� ���� ���!!";
		return rank;
	}
}
