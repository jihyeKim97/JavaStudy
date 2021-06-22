package db.data;

import java.util.Date;

/*

### 음식(음료) Food (대상 컨텐트)
> CAFE.foods TBL
> db.data.Food 데이터 클래스
> db.mgr.FoodDBMgr 데이터 DB중개자 클래스
> https://www.fromheartscoffee.com/Bakery 메뉴

- id 관리번호 (DB 기준 생성, 중복x, not null-NN) 
	int <<PK>> + 시퀀스(CAFE.food_seq 시퀀스 적용)
- name 음식/음료 이름 (관리자가 UI 입력)  varchar2 32 NN <<UQ>>
- category 종류카테고리 (관리자가 UI 입력)  varchar2 32 기본 '음료'
- imagePath (관리자가 UI 입력/선택) 음식/음료 사진 파일 경로 varchar 512
- price 가격 (관리자가 UI 입력) int 1000원 기본
- hotIce 핫아이스 (관리자가 UI 입력/선택) int  1 HOT 2 ICE
- regDate 등록날자(개시) (관리자가 UI 입력/선택) date 
- like_members 좋아요한회원들 id (login) 기억... String... 
- like_count 좋아요한회원명수 int 
 */
public class Food_backup1 {
	public static final String DEF_CATEGORY= "음료";
	public static final int DEF_PRICE = 1000;
	public static final int TEMP_HOT = 1;
	public static final int TEMP_ICE = 2;
	private int id; // 관리번호 (DB 기준 생성, 중복x, not null-NN) 
				//int <<PK>> + 시퀀스(CAFE.food_seq 시퀀스 적용)
	private String name;// 음식/음료 이름 (관리자가 UI 입력)  varchar2 32 NN <<UQ>>
	private String  category;// 종류카테고리 (관리자가 UI 입력)  varchar2 32 기본 '음료'
	private String  imagePath;// (관리자가 UI 입력/선택) 음식/음료 사진 파일 경로 varchar 512
	private int  price;// 가격 (관리자가 UI 입력) int 1000원 기본
	private int  hotIce;// 핫아이스 (관리자가 UI 입력/선택) int  1 HOT 2 ICE
	private Date regDate;// 등록날자(개시) (관리자가 UI 입력/선택) date 
	private String  likeMembers;// 좋아요한회원들 id (login) 기억... String... 
	private int likeCount;// 좋아요한회원명수 int
	
	public Food_backup1() {}
	
	public Food_backup1(String name, String category, String imagePath, int price, int hotIce) {
		super();
		this.name = name;
		this.category = category;
		this.imagePath = imagePath;
		this.price = price;
		this.hotIce = hotIce;
	}

	public Food_backup1(int id, String name, String category, String imagePath, int price, int hotIce, Date regDate,
			String likeMembers, int likeCount) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.imagePath = imagePath;
		this.price = price;
		this.hotIce = hotIce;
		this.regDate = regDate;
		this.likeMembers = likeMembers;
		this.likeCount = likeCount;
	}

	@Override
	public String toString() {
		return "Food [id=" + id + ", name=" + name + ", category=" + category + ", imagePath=" + imagePath + ", price="
				+ price + ", hotIce=" + hotIce + ", regDate=" + regDate + ", likeMembers=" + likeMembers
				+ ", likeCount=" + likeCount + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getHotIce() {
		return hotIce;
	}

	public void setHotIce(int hotIce) {
		this.hotIce = hotIce;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getLikeMembers() {
		return likeMembers;
	}

	public void setLikeMembers(String likeMembers) {
		this.likeMembers = likeMembers;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	
	
	
}
