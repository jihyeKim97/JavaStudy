package HomeWork_0416;

//극장 클래스 작성
public class MyTheater extends MyMovie {

	public static final int MAX_MOVIE = 3;
	public static final int MAX_LEVEL = 19;
	public static final String TITLE = "CGV";
	public static final String LOCATE = "왕십리점";

	String title;
	String locate;
	public int movSize;
	MyMovie[] mov;

	public MyTheater() {
		movSize = MAX_MOVIE;
		mov = new MyMovie[MAX_MOVIE];
		this.title = TITLE;
		this.locate = LOCATE;
	}

	public MyTheater(String title, String locate, MyMovie[] mov) {
		super();
		movSize = MAX_MOVIE;
		mov = new MyMovie[movSize];
		this.title = title;
		this.locate = locate;
		this.mov = mov;
	}

	public void printTheater() {
		System.out.println(title + "(" + locate + ")");
		for (int i = 0; i < mov.length; i++) {
			if (mov[i] == null)
				System.out.printf("[%d관] 비어있음 \n", i + 1);
			else
				System.out.printf("[%d관] '%s', %s, %.1f점\n", i + 1, mov[i].name, mov[i].genre, mov[i].score);
		}
	}

}