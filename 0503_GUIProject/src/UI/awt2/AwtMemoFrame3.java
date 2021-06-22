package UI.awt2;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.TextArea;
import java.awt.TextField;

public class AwtMemoFrame3 extends Frame {
	// 상수 선언
	public static final Font ftNormal = new Font("굴림", Font.PLAIN, 24);
	public static final Font ftMedium = new Font("굴림", Font.PLAIN | Font.ITALIC, 32);
	public static final Font ftBig = new Font("바탕", Font.BOLD, 48);
	public static final Color crAccent = Color.ORANGE;
	public static final Color crSub = new Color(128, 0, 200);

	// 필드 선언 (UI 컴포넌트)
	// 제목 레이블
	private Label lbTitle;
	// 중앙 텍스트 입력?
//	private TextField txtMemo; // 한 줄 짜리 문자열 입력
	private TextArea txtMemo;
	// 다중 행 문자열 입력; 행 x 열... 엔터키, 스크롤바
	// 하단 상태 레이블
	private Label lbStatus; // 스테이터스 바

	// 버튼 4개 추가 - 정보, 폰트배경색상반전, 메모저장, 메모읽기
	private Button btnAbout;
	private Button btnChangeColor; // FG <=> BG
	private Button btnSave;
	private Button btnLoad;

	private Panel pnBottom; // south 위치에 배치할 패널(작은 컨테이너)

	public AwtMemoFrame3() {
		super("제목없음");
	}

	public AwtMemoFrame3(String title) {
		// 프레임 창 설정....
		super(title);
//		this.setSize(480, 480); // 크기
//		this.setLocation(100, 100); // 위치
		this.setBounds(100, 100, 480, 480);
		// setSize() + setLocation() 한 번에... 바운드~
//		setBounds(new Rectangle(100, 100, 480, 480));
		setBackground(Color.gray);
		setResizable(false); // 창 크기 변경 불가능 설정

		// 창 (배치) 레이아웃 관리자
		// Frame은 내부에 기본 배치관리자로 Borderlayout 설정.1
//		this.setLayout(new BorderLayout()); // 생략

		// 컴포넌트 준비 혹은 설정
		this.lbTitle = new Label("제목: ");
//		txtMemo = new TextField("메모를 입력하세요!", 40);
		this.txtMemo = new TextArea("메모를 입력하세요!", 40, 40, TextArea.SCROLLBARS_BOTH); // 행, 렬, 스크롤바
		this.lbStatus = new Label("상태바: ", Label.LEFT);
		lbTitle.setFont(ftBig);
		lbStatus.setFont(ftNormal);
		txtMemo.setFont(ftMedium);

		// 정보, 폰트배경색상반전, 메모저장, 메모읽기
		btnAbout = new Button("info");
		btnLoad = new Button("load");
		btnSave = new Button("save");
		btnChangeColor = new Button("F<->B"); // inversion

		// 패널생성(배피 관리자도 동시 생성설정)
//		this.pnBottom = new Panel();
		FlowLayout pnLayout = new FlowLayout(FlowLayout.LEFT, 0, 0);
		this.pnBottom = new Panel(pnLayout);

		// 패널 에 컴포넌트들을 배치
		pnBottom.add(lbStatus);
		pnBottom.add(btnAbout);
		pnBottom.add(btnLoad);
		pnBottom.add(btnSave);
		pnBottom.add(btnChangeColor);

		// 창에 컴포넌트들을 배치
		this.add(lbTitle, BorderLayout.NORTH);
		this.add(txtMemo, BorderLayout.CENTER);
		this.add(lbStatus, BorderLayout.SOUTH);

		// 창 보이기
		this.setVisible(true);
	}

	public static void main(String[] args) {
		AwtMemoFrame3 frm = new AwtMemoFrame3("나의 메모장1");
		// frm.setVisible(true);
	}

}
