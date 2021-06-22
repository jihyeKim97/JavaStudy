package db.data;

import java.util.Date;

/*
### 회원 Member (액터)
> CAFE.members TBL 테이블
> db.data.Member 데이터 클래스
> db.mgr.MemberDBMgr 데이터 DB중개자 클래스

- id 관리번호 (DB 기준 생성, 중복x, not null-NN) 
	int <<PK>> + 시퀀스(CAFE.member_seq 시퀀스 적용)
- name 회원 실명 (UI 입력)  varchar2 24	
- login 로그인명 (UI 입력) varchar2 4~12 중복x unique <<UQ>>	NN
- pw 패스워드 (UI 입력) varchar2 4~12  NN	
- age 회원 나이  (UI 입력) int 18세 기본 18~50세..
- gender 회원 성별 (UI 입력) int 1 여성, 2 남성
- mileage 마일리지 활동포인트(DB 기준 생성) int 1000점 기본
- joinedAt 가입날자(DB 기준 생성) Date  
 */
public class Member {
	public static final int DEF_AGE = 18;
	public static final int DEF_MILEAGE = 1000;
	public static final int GENDER_FEMALE = 1;
	public static final int GENDER_MALE = 2;
	//
	private int id; // <<PK>>
	private String name;
	private String login; // <<UQ>>
	private String pw;
	private int age;
	private int gender;
	private int mileage;
	private Date joinedAt; // members.joined_at 컬럼에 대응
	
	//
	public Member() {}
	
	// 회원가입 폼에 동기화된 생성자
	public Member(String name, String login, String pw, int age, int gender) {
		this(0, name, login, pw, age, gender, DEF_MILEAGE, null);
//		super();
//		this.name = name;
//		this.login = login;
//		this.pw = pw;
//		this.age = age;
//		this.gender = gender;
		
	}

	public Member(int id, String name, String login,
			String pw, int age, int gender, int mileage,
			Date joinedAt) {
		super();
		this.id = id;
		this.name = name;
		this.login = login;
		this.pw = pw;
		this.age = age;
		this.gender = gender;
		this.mileage = mileage;
		this.joinedAt = joinedAt;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public Date getJoinedAt() {
		return joinedAt;
	}

	public void setJoinedAt(Date joinedAt) {
		this.joinedAt = joinedAt;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", login=" + login + ", pw=" + pw + ", age=" + age + ", gender="
				+ gender + ", mileage=" + mileage + ", joinedAt=" + joinedAt + "]";
	}
	
	
	
}
