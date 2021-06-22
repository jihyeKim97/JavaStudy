package dbtest.data;
//데이터 스키마 중심 통신 
//DB corporations TBL <----> java Company 클래스 대응관계
// 레코드 하나						객체 하나
//  컬럼							 필드

/*
  테이블 스키마 TBL CORPORATIONS
  CREATE TABLE "DEVEL"."CORPORATIONS" 
   (	"ID" NUMBER(*,0) DEFAULT 0 NOT NULL ENABLE, 
	"NAME" VARCHAR2(64 BYTE) NOT NULL ENABLE, 
	"DOMAIN" VARCHAR2(64 BYTE) DEFAULT '비공개', 
	"CEO" VARCHAR2(32 BYTE) NOT NULL ENABLE, 
	"RATE" NUMBER(4,2) DEFAULT 5.0 NOT NULL ENABLE, 
	"RANK" VARCHAR2(16 BYTE) DEFAULT 'N' NOT NULL ENABLE, 
	 CONSTRAINT "CORPORATIONS_PK" PRIMARY KEY ("ID")
	 
 스키마 클래스 Company
 	  int id 관리번호  // <<PK>>
 	  String name 이름
 	  String domain 분야
 	  String ceo 대표이사
 	  float rate 평점 
 	  String rank 등급
 */
// 데이터 클래스 (스키마를 설계한 클래스; 모델 클래스, 엔티티 표현)
// 스키마의 내용을 담는 그룻으로써의 객체를 생성하는 설계클래스
// class CompanyVO (value object)
public class Company {
	public static final int DEF_ID = 0;
	public static final String DEF_DOMAIN = "비공개";
	public static final float DEF_RATE = 5.0f;
	public static final String DEF_RANK = "N"; // no rank
	//
	private int id;// 관리번호  <<PK>>
	private String name;// 이름
	private String domain;// 분야
	private String ceo;// 대표이사
	private float rate;// 평점 
	private String rank;// 등급
	//
	
	public Company() {
		// TODO Auto-generated constructor stub
	}
	
	// default, nullable

	public Company(int id, String name, String ceo) {
		//this(id, name, DEF_DOMAIN, ceo, DEF_RATE, DEF_RANK);
		this(id, name, DEF_DOMAIN, ceo);
//		super();
//		this.id = id;
//		this.name = name;
//		this.ceo = ceo;
	}

	public Company(int id, String name, String domain, String ceo) {
		this(id, name, domain, ceo, DEF_RATE, DEF_RANK);
//		super();
//		this.id = id;
//		this.name = name;
//		this.domain = domain;
//		this.ceo = ceo;
	}

	public Company(int id, String name, String domain, String ceo, float rate, String rank) {
		super();
		this.id = id;
		this.name = name;
		this.domain = domain;
		this.ceo = ceo;
		this.rate = rate;
		this.rank = rank;
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

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

//	@Override
//	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("Company [id=");
//		builder.append(id);
//		builder.append(", name=");
//		builder.append(name);
//		builder.append(", domain=");
//		builder.append(domain);
//		builder.append(", ceo=");
//		builder.append(ceo);
//		builder.append(", rate=");
//		builder.append(rate);
//		builder.append(", rank=");
//		builder.append(rank);
//		builder.append("]");
//		return builder.toString();
//	}

	@Override
	public String toString() {
		return "IT회사  : " + id + ", " + name 
				+ "," + domain + ", " + ceo 
			+ " 님, " + rate + " 점, " + rank + " 등급";
	}

	
	
}
