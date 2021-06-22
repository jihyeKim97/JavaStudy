package membership.data;
import java.util.Date;
/* 
 * 회원제 가입형 서비스 *
 
   회원 스키마 (Member) 
   - 써클, 동아리, 학회 가입? 
   - 관리번호(고유값 체계적), 이름, 나이, 이메일, 생년월일, 가입날자, 마일리지 등...
   + 계정명(ID 고유한 문자열) / 암호(password) 
 
*/

// DATA	CLASS	=> VO-value object/DTO-data transfer object
// Member VO는 회원 1명의 스키마의 내용을 담은 그릇같은 회원객체
public class Member {
	private int no; // 관리번호(고유값 체계적), 
	private String name;// 이름, 
	private int age; //나이, 
	private String email; // 이메일, 
	private double mileage; // 마일리지 
	private String id; // 계정명(ID 고유한 문자열)
	private String password; // 암호(password)
	private Date birthDay; //생년월일, 
	private Date joinDay; //가입날자, 
	
	public static final int DEF_AGE = 18;
	public static final double DEF_MILE = 1000.0;
	public static int order = 0; // 관리번호의 기준값
	
	
	
	
	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public double getMileage() {
		return mileage;
	}


	public void setMileage(double mileage) {
		this.mileage = mileage;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Date getBirthDay() {
		return birthDay;
	}


	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}


	public Date getJoinDay() {
		return joinDay;
	}


	public void setJoinDay(Date joinDay) {
		this.joinDay = joinDay;
	}


	public Member() {}


	public Member(String name, String email,
			String id, String password, Date birthDay) {
		this(++order, name, DEF_AGE, email, DEF_MILE, 
				id, password, birthDay, new Date());
	}
	
	public Member(int no, String name, int age,
			String email, double mileage, String id, 
			String password, Date birthDay,
			Date joinDay) {
		super();
		this.no = no;
		this.name = name;
		this.age = age;
		this.email = email;
		this.mileage = mileage;
		this.id = id;
		this.password = password;
		this.birthDay = birthDay;
		this.joinDay = joinDay;
	}

	@Override
	public String toString() {
		return no + ", " + name + ", " + age + 
				", " + email + ", " + mileage
				+ ", " + id + ", " + password +
				", " + birthDay + ", " + joinDay;
	}

//	@Override
//	public String toString() {
//		return "Member [no=" + no + ", name=" + name + ", age=" + age + ", email=" + email + ", mileage=" + mileage
//				+ ", id=" + id + ", password=" + password + ", birthDay=" + birthDay + ", joinDay=" + joinDay + "]";
//	}
	
	
}
