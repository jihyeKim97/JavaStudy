package db.data;

import java.util.ArrayList;
import java.util.Date;

public class Member {

	private int id; // <<PK>>
	public String name;
	public String login; // <<UQ>>
	public String pw;
	public int age;
	public String email;
	public int phone;
	public String rentBook[] = new String[3];
	public Date joinedAt; // members.joined_at 컬럼에 대응
	
	public static ArrayList<Member> list = new ArrayList<Member>();
	
	
	
	public Member(String name, String login,int age, String email, int phone,String rentBook1, String rentBook2, String rentBook3) {
		super();
		this.name = name;
		this.login = login;
		this.age = age;
		this.email = email;
		this.phone = phone;
		rentBook[0] = rentBook1;
		rentBook[1] = rentBook2;
		rentBook[2] = rentBook3;
		
	}
	
	
	public Member(String name, String login, String pw, int age, String email, int phone) {
		super();
		this.name = name;
		this.login = login;
		this.pw = pw;
		this.age = age;
		this.email = email;
		this.phone = phone;
	}

	public Member(int id,String name, String login, String pw, int age, String email, int phone, Date joinedAt) {
		super();
		this.id = id;
		this.name = name;
		this.login = login;
		this.pw = pw;
		this.age = age;
		this.email = email;
		this.phone = phone;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getPhone() {
		return phone;
	}


	public void setPhone(int phone) {
		this.phone = phone;
	}


	public Date getJoinedAt() {
		return joinedAt;
	}


	public void setJoinedAt(Date joinedAt) {
		this.joinedAt = joinedAt;
	}


	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", login=" + login + ", pw=" + pw + ", age=" + age + ", email="
				+ email + ", phone=" + phone + ", joinedAt=" + joinedAt + "]";
	}
	
	
	
}

	