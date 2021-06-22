package UI.awt;

import java.awt.*;
import java.awt.event.*;

// Object > Component > Container > Window
// 		> Frame > AwtGuiMain5
public class AwtGuiMain5 extends Frame implements ActionListener {
	// GUI 창의 공통상수 자원(컬러,폰트,크기,위치,경계,이미지..)

	// GUI 창의 공통상수 자원(컬러,폰트,크기,위치,경계,이미지..)
	public static final Color crPink = Color.PINK;
	public static final Color crBlue = Color.BLUE;
	public static final Color crGreen = Color.GREEN;
	public static final Color crOrangle = Color.orange;
	public static final Color crRed = new Color(255, 0, 0);
	public static final Font ftNormal = new Font("굴림", Font.ITALIC, 30);
	public static final Font ftBig = new Font("궁서체", Font.BOLD, 60);
	public static final Font ftLabel = new Font("바탕", Font.PLAIN, 32);
	public static final Font ftButton = new Font("굴림", Font.BOLD | Font.ITALIC, 40);

	// ui 컴포넌트 필드 선언 (멤버필드화)
	TextField txtHello; 
	TextField txtHuman;
	Label lbResult; 

	// 생성자 (프레임창 초기화)
	public AwtGuiMain5() {
		//	super();
		// this.setTitle("제목없음 창");
		super("제목없음 창");
	}

	public AwtGuiMain5(String title) {

		// frame 창 설정 초기화
		super(title); // 부모 frame생성자 호출 초기화
		
		// frame 창의 위치와 크기 조정
		setLocation(100, 100); // 좌상단 지점으로 오프셋을 기준점
		this.setSize(800, 480);
		
		//frame 창의 클라이언트 영역에 컴포넌트를 배치하기위한 배치관리자 실행
		// 플로우레이아웃 :  컴포넌트들을 가로 방향으로 채워 나가다가 현재 행에서 경게를 만나면 다음 행 다음 컴포넌트들을 배치
		
		setLayout(new BorderLayout());

		Label lbTitle = new Label("*** 인사 하기 ***");
		lbTitle.setFont(ftBig);
		lbTitle.setForeground(crBlue); 
		Label lbHello = new Label("Hello GUI!!");
		lbHello.setFont(ftNormal);
		Label lbHello2 = new Label("안녕하세요?");
		lbHello2.setFont(ftNormal);

		this.lbResult = new Label("결과: ", Label.LEFT);
		lbResult.setFont(new Font("바탕", Font.BOLD | Font.ITALIC, 38));
		lbResult.setBackground(Color.YELLOW);

//		TextField txtHello = new TextField(20);
		this.txtHello = new TextField(20);
		txtHello.setFont(ftNormal);
		txtHuman = new TextField("Mr. Park", 14);
		txtHuman.setFont(ftNormal);
		txtHuman.setForeground(Color.CYAN);
		txtHuman.setBackground(Color.DARK_GRAY);

		// button 컴포넌트
		Button btnGreet = new Button("GREET!");
		btnGreet.setForeground(crPink);
		btnGreet.setFont(new Font("Serif", Font.PLAIN, 22));

		// 이 버튼에 이벤트핸들러와 이벤트을 연동
		btnGreet.addActionListener(this);// 프레임 자식창 자기자신객체
		// ActionListener 이벤트 핸들러 함수
		// actionPerformed()를 구현한 객체를 인자로...

//		this.add(lbTitle); // 제목 레이블 객체를 가장 먼저 표시
//		add(lbHello); // flowlayout에서는 add 순서가 중요.
//		this.add(lbHello2);		
//		this.add(txtHello);
//		add(txtHuman);
//		this.add(btnGreet);
//		add(lbResult);
		// this는 프레임 자식창 자기자신객체

		Panel pn = new Panel(); // 패널의 기본배치는 flowLayout
		pn.add(lbHello); // flowlayout에서는 add 순서가 중요.
		pn.add(lbHello2);
		pn.add(txtHello);
		pn.add(txtHuman);

		add(pn, BorderLayout.CENTER); // 패널을 중앙에 배치
		add(lbTitle, BorderLayout.NORTH);
		add(btnGreet, BorderLayout.EAST);
		add(lbResult, BorderLayout.SOUTH);

		this.setBackground(crOrangle); // 배경색
//		this.setVisible(true); // AWT창의 close x버튼 동작 안됨.
	}

	// 버튼 클릭 이벤트 처리(handler) 함수 (이벤트는 거의 대부문 인터페이스를 구현해야 함.)
	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println("Greet! 버튼을 누루셨음!!" + new Date());
		// 버튼 클릭..
		String strHello = this.txtHello.getText();
		String strHumanName = this.txtHuman.getText();
		System.out.println(">> 인사하기 " + strHello + " " + strHumanName + "~!!!"); // 콘솔창 출력
		this.lbResult.setText(">> 인사하기 " + strHello + " " + strHumanName + "~!!!");
	}

	public static void main(String[] args) {
		AwtGuiMain5 frm1 = new AwtGuiMain5();
		frm1.setVisible(true); // show, hide
	}

}
