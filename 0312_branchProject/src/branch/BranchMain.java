package branch;

import java.util.Date;
// 임포트를 통해서 이 소스코드 클래스 BranchMain8 안에서 날자시간을 처리하는 기능을 Date에 빌려쓰겠다는 선언.

// 마일리지 적립 및 등급 판정 프로그램 
/* 
 PLATINUM 등급 100000~ 이상 
 DIAMOND 등급 40000 ~ 100000 미만 
 GOLD 등급 20000 ~ 40000	
 SILVER 등급 12000 이상 ~ 20000 미만
 BRONZE 등급 5000 이상 ~ 12000 미만
 BASIC 기본등급 0(이상) ~ 5000미만
 */

public class BranchMain {
	public static final String NO_RANK = "등급 없음";
	public static final int BASIC = 0,DEF_POINT = 3000,BRONZE = 5000,SILVER = 12000,GOLD = 20000,DIAMOND = 40000,PLATINUM = 100000; 
	static final int ACTION_NO_ACT = 0,ACTION_LOGIN = 1,ACTION_WRITE = 2,ACTION_READ = 3,ACTION_LIKE = 4,ACTION_PURCHASE = 5,ACTION_SERVICE = 6,EXIT_ACTION_LIMIT = 20; 

	public static int getPurchaseMileage(int price) {
		int purchaseMile = 0;
		
		// 구매 활동에 대한 보상 => 구매상품 가격의 1.x ~ 3.0% 적립(반올림)
		double percent = Math.random() * 3.0 + 1.0;
		if (percent > 3.0)
			percent = 3.0; // 상한 보정 (최대값)

		// int purchaseMile = (int)(price * 0.01);  // 1%
		// purchaseMile = (int) Math.round(price * 0.01);
		purchaseMile = (int) (Math.round(price * percent / 100.0));// 백분율(%)

		System.out.println("\t상품 구매액: " + price + "원");
		System.out.println("\tpercent = " + percent + "% 적립률");
		System.out.println("\tpurchaseMile " + purchaseMile + "pt");

		return purchaseMile;
	}

	public static void main(String[] args) {
		String name = "재욱";
		int mileage = DEF_POINT; 
		int activity = ACTION_NO_ACT;
		// => 포인트를 발생시키는 회원 활동들... (시간, 인증 등을 고려)
		int count = 1;
		boolean flag = true;

		while (flag) {
			// ;
			activity = (int) (Math.random() * 6) + 1;
			System.out.printf(">> %d 회차 활동: ", count);

			// 회차 활동 언제 실행되었나? 날자 시간..
			Date actTime = new Date(); // 날자시간 객체 생성 // java.util.Date JVM이 실행중인 OS의 지역 시간을 가져옴.
			String actStamp = " [" + actTime + "] ";

			if (activity == ACTION_LOGIN) {
				System.out.print("ACTION 로그인 실행");
				mileage += 50;
			} else if (activity == ACTION_WRITE) {
				System.out.print("ACTION 글쓰기 실행");
				mileage += 100;
			} else if (activity == ACTION_READ) {
				System.out.print("ACTION 글읽기 실행");
				mileage += 10;
			} else if (activity == ACTION_LIKE) {
				System.out.print("ACTION 좋아요 실행");
				mileage += 500;
			} else if (activity == ACTION_PURCHASE) {
				System.out.print("ACTION 상품구매 실행");
				int price = (int) (Math.random() * 100000);
				mileage += getPurchaseMileage(price);
			} else if (activity == ACTION_SERVICE) {
				System.out.print("ACTION 부가서비스가입 실행");
				int addSvc = (int) (Math.random() * 4); // 0 ~ 3
				int[] ptsAddSvc = { 5000, 10000, 20000, 30000 };
				String[] namesAddSvc = { "웹툰서비스", "오디오북", "비디오스트리밍", "무조건특가반값할인" }; // 배열 Array -- 같은 종류 여러 데이터들을 단 하나의 대표이름으로 묶음.// 배열은 ptsAddSvc[0] 사용...
				System.out.println("\n~~~ 가입한 부가 서비스 이름: " + namesAddSvc[addSvc]);
				System.out.println("~~~ 부가서비스 적립pt: " + ptsAddSvc[addSvc]);
				int addSvcMile = ptsAddSvc[addSvc];
				mileage += addSvcMile;
			} else {
				System.out.println(">> 예상치 못한 activity: " + activity);
			}
			System.out.printf(" 이번 활동으로 누적된 총 마일리지: %d pt\n", mileage);
			String thisRank = getMemberRank5(mileage);
			System.out.printf(" 현재 멤버 등급: %s\n", thisRank);
			System.out.println("--활동에 대한 적립 시간 : " + actStamp+"\n~~~~~~~~~~~~~~~~");

			// 종료 조건
			if (count >= EXIT_ACTION_LIMIT)
				flag = false;
			count++;
		}

		// 등급 판정 - pt가 어느 구간에 속하는지?
		String rank = NO_RANK; 
		if (mileage < 0) {
			System.out.println("[에러] 처리할 수 없는 마일리지 발견! - " + mileage);
		} else {
			rank = getMemberRank5(mileage);
			System.out.println("-----------------\n"+" ** 최종 등급 판정:  "+"\n-----------------"+"\n>> 회원 이름: " + name+"\n>> 회원 마일리지: " + mileage + "pt"+"\n>> 회원 등급: " + rank+"\n-----------------");
		}
	}

	private static String getMemberRank5(int mileage) {
		if (mileage >= BASIC && mileage < BRONZE)return "Basic 등급";
		else if (mileage < SILVER)return "Bronze 등급";
		else if (mileage < GOLD)return "Silver 등급";
		else if (mileage < DIAMOND)return "Gold 등급";
		else if (mileage < PLATINUM)return "Diamond 등급";
		else return "PLATINUM 등급";
	}
	private static String getMemberRank4(int mileage) {
		if (mileage >= BASIC && mileage < BRONZE)return "Basic 등급";
		else if (mileage >= BRONZE && mileage < SILVER)return "Bronze 등급";
		else if (mileage >= SILVER && mileage < GOLD)return "Silver 등급";
		else if (mileage >= GOLD && mileage < DIAMOND)return "Gold 등급";
		else if (mileage >= DIAMOND && mileage < PLATINUM)return "Diamond 등급";
		else return "PLATINUM 등급";
	}
	private static String getMemberRank3(int mileage) {
		String rank = "PLATINUM 등급";
		if (mileage >= BASIC && mileage < BRONZE)rank = "Basic 등급";
		else if (mileage >= BRONZE && mileage < SILVER)rank = "Bronze 등급";
		else if (mileage >= SILVER && mileage < GOLD)rank = "Silver 등급";
		else if (mileage >= GOLD && mileage < DIAMOND)rank = "Gold 등급";
		else if (mileage >= DIAMOND && mileage < PLATINUM)rank = "Diamond 등급";
		return rank;
	}
	private static String getMemberRank2(int mileage) {
		String rank;
		if (mileage >= BASIC && mileage < BRONZE)rank = "Basic 등급";
		else if (mileage >= BRONZE && mileage < SILVER)rank = "Bronze 등급";
		else if (mileage >= SILVER && mileage < GOLD)rank = "Silver 등급";
		else if (mileage >= GOLD && mileage < DIAMOND)rank = "Gold 등급";
		else if (mileage >= DIAMOND && mileage < PLATINUM)rank = "Diamond 등급";
		else rank = "PLATINUM 등급";
		return rank;
	}
	private static String getMemberRank(int mileage) {
		String rank;
		if (mileage >= BASIC && mileage < BRONZE)rank = "Basic 등급";
		else if (mileage >= BRONZE && mileage < SILVER)rank = "Bronze 등급";
		else if (mileage >= SILVER && mileage < GOLD)rank = "Silver 등급";
		else if (mileage >= GOLD && mileage < DIAMOND)rank = "Gold 등급";
		else if (mileage >= DIAMOND && mileage < PLATINUM)rank = "Diamond 등급";
		else if (mileage >= PLATINUM)rank = "PLATINUM 등급";
		else rank = "처리할 수 없는 등급!!";
		return rank;
	}
}
