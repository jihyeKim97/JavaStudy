package compare;

public class StringCompareMain3 {
	static double MyPI = 3.141592;
	public static void main(String[] args) {		
		// 문자 비교, 문자 배열(객체) 비교, 문자열 객체 비교
		String a = "데이터베이스";
		String b = "JAVA";
		System.out.printf("a(%s) == b(%s) -->  %s\n",
				a, b, (a == b));
		System.out.printf("a(%s) eqauls b(%s) -->  %s\n",
				a, b, (a.equals(b)));
		
		String c = a;
		// c == a 두 객체의 주소와 내용이 모두 동일함 (동일성 비교)
		System.out.printf("c(%s) == a(%s) -->  %s\n",
				c, a, (c == a));
		// c.equals(a) 두 객체의 내용이 일치함 (동등성 비교)
		System.out.printf("c(%s) eqauls a(%s) -->  %s\n",
				c, a, (c.equals(a)));
		
		String d = new String(a);
			// new를 통해서 새로운 주소의 객체 할당
		System.out.printf("d(%s) == a(%s) -->  %s\n",
				d, a, (d == a));
		System.out.printf("d(%s) eqauls a(%s) -->  %s\n",
				d, a, (d.equals(a)));
		
//		char []aArr = a.toCharArray();
		char []aArr = {'데','이','터','베','이','스'};
//		StringCompareMain2.compareCharArrays(aArr, d.toCharArray());
		String e = new String(aArr);
		System.out.printf("e(%s) == a(%s) -->  %s\n",
				e, a, (e == a));
		System.out.printf("e(%s) eqauls a(%s) -->  %s\n",
				e, a, (e.equals(a)));
		
		String f = "데이터베이스"; // 객체 상수의 주소가 동일
		System.out.printf("f(%s) == a(%s) -->  %s\n",
				f, a, (f == a));
		System.out.printf("f(%s) eqauls a(%s) -->  %s\n",
				f, a, (f.equals(a)));
		
		String g = new String("데이터베이스");
		System.out.printf("g(%s) == a(%s) -->  %s\n",
				g, a, (g == a));
		System.out.printf("g(%s) eqauls a(%s) -->  %s\n",
				g, a, (g.equals(a)));
	}

}


/*
 a(데이터베이스) == b(JAVA) -->  false
a(데이터베이스) eqauls b(JAVA) -->  false
c(데이터베이스) == a(데이터베이스) -->  true
c(데이터베이스) eqauls a(데이터베이스) -->  true
d(데이터베이스) == a(데이터베이스) -->  false
d(데이터베이스) eqauls a(데이터베이스) -->  true
e(데이터베이스) == a(데이터베이스) -->  false
e(데이터베이스) eqauls a(데이터베이스) -->  true
f(데이터베이스) == a(데이터베이스) -->  true
f(데이터베이스) eqauls a(데이터베이스) -->  true
g(데이터베이스) == a(데이터베이스) -->  false
g(데이터베이스) eqauls a(데이터베이스) -->  true

*/