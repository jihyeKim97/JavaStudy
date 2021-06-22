package UI.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Point;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

// Object > Component > Container > Window
// 		> Frame > AwtGuiMain5
public class AwtGuiMain7 extends Frame 
					implements ActionListener
{
	// GUI 창의 공통상수 자원(컬러,폰트,크기,위치,경계,이미지..)
	public static final Color crPink = Color.PINK;
	public static final Color crBlue = Color.BLUE;
	public static final Color crGreen = Color.GREEN;
	public static final Color crOrangle = Color.orange;
	public static final Color crRed = new Color(255, 0, 0);
	public static final Font ftNormal =
				new Font("굴림", Font.ITALIC, 30);
	public static final Font ftBig 
				= new Font("궁서체", Font.BOLD, 60);
	public static final Font ftLabel = 
				new Font("바탕", Font.PLAIN, 32); 
	public static final Font ftButton = 
				new Font("굴림", Font.BOLD | Font.ITALIC, 40);	
	
	// ui 컴포넌트 필드 선언 (멤버필드화)
	TextField txtHello; // 필드화 - 기본값 null !!!!
	TextField txtHuman;  
	Label lbResult; // 버튼 이벤트의 결과를 이 레이블에도 표시
	
	// 생성자 (프레임창 초기화)
	public AwtGuiMain7() {
//		super();
//		this.setTitle("제목없음 창");
		super("제목없음 창");
	}
	
	public AwtGuiMain7(String title) {		
		// frame 창 설정 초기화 
//		super();
//		this.setTitle(title);
		super(title); // 부모 Frame(title) 생성자 호출 초기화 
		
		// frame 창의 위치와 크기 조정 (디바이스/OS의 화면 해상도/밀도..?)
//		setLocation(100, 100);
		this.setLocation(new Point(100, 100));
		// 화면의 좌상단(top-left corner) 지점으로 오프셋을 기준점 
//		this.setSize(800, 480); // 가로 x 세로 (크기)
		setSize(new Dimension(800, 400));
		
		// frame 창의 클라이언트영역에 컴포넌트들을 배치하기위한 
		// 배치 관리자 설정
		//setLayout(new FlowLayout()); 
			// 플로우레이아웃: 컴포넌트들을 가로방향으로 채워 나가다가 
			// 현재 행에서 경계를 만나면 다음 행(아래로) 다음 컴포넌트들을 배치
			// word-wrapping과 비슷.. (
//		setLayout(new BorderLayout()); // Frame창의 기본 배치관리자 설정
		// Frame 창의 기본 레이아웃매니져는 BorderLayout이 기본설정됨(생략).
			// 보더레이아웃(동서남북+중앙): 상하좌우와 중앙의 
			// 5개의 영역으로 창을 분할하여 컴포넌트를 직접배치함.
			// North ~ South, West ~ East, Center.
			// NSWE는 네 개의 창경계(border)에 직접 붙어서 연동크기가 변함
			// Center영역은 남아있는 모든 영역을 우선적으로 모두 채워나감.
		
		// * 배치관리자는 오직 컨테이너에만 존재함.
		
		// 이 프레임창을 꾸며줄 UI컴포넌트들을 준비하기
		// 정적인 텍스트 표현하는 레이블 준비
		Label lbTitle = new Label("*** 인사 하기 ***");
		lbTitle.setFont(ftBig);
		lbTitle.setForeground(crBlue); // 전경색
		Label lbHello = new Label("Hello GUI!!");
		lbHello.setFont(ftNormal);
		Label lbHello2 = new Label("안녕하세요?");
		lbHello2.setFont(ftNormal);  //ftBig);
		
		// 사용자의 키보드 텍스트 입력인 텍스트필드 준비
		this.lbResult = new Label("결과: ", Label.LEFT);
		lbResult.setFont(new Font("바탕", 
				Font.BOLD | Font.ITALIC, 
				38));
		lbResult.setBackground(Color.YELLOW);
		
//		TextField txtHello = new TextField(20);
		this.txtHello = new TextField(20);
		txtHello.setFont(ftNormal);
		txtHuman = new TextField("Mr. Park", 14);
		txtHuman.setFont(ftNormal);
		txtHuman.setForeground(Color.CYAN);
		txtHuman.setBackground(Color.DARK_GRAY);
		
		// 사용자의 이벤트(동작)를 처리할 수있는 button 컴포넌트 준비
		Button btnGreet = new Button("GREET!");
		btnGreet.setForeground(crPink);
		btnGreet.setFont(new Font("Serif", Font.PLAIN, 22));
		
		Button btnReset = new Button("리셋!"); 
			// 두 개의 텍스트필드 내용을 모두 ""빈문자열로 지워버리는 동작
		btnReset.setFont(ftButton);
		btnReset.setForeground(crRed);
		
		// ** 이벤트 리스너 등록: 특정 이벤트가 발생되는지를 감시(모니터링) 등록..
		// => 해당 이벤트가 발생되자마자 바로 연결된 이벤트처리메소드(핸들러)를 실행.
		// 이 버튼에 이벤트핸들러와 이벤트을 연동 
		btnGreet.addActionListener(this);
		
		ResetButtonHandler resetHandler
				= new ResetButtonHandler(this);
			// this를 생성자에 넘겨줌으로써 Frame 창객체의 정보를 
			// ResetButtonHandler 객체가 사용할 수 있게 연결해줌!!!
			// 리셋버튼 전용 ActionListener 이벤트를 처리하는 객체를 생성
		btnReset.addActionListener(resetHandler); // ?
		//프레임 자식창 자기자신객체는 actionPerformed() 구현한 객체로 인자가 됨.
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
		
		// Pane, Panel은 작은 컨테이너 (html 웹에서 div태그와 비슷)
		// Panel 컨테이너로써 기본적으로 FlowLayout 배치관리자를 갖는다.
		Panel pn = new Panel(); // 패널의 기본배치는 flowLayout 
		pn.add(lbHello); // flowlayout에서는 add 순서가 중요.
		pn.add(lbHello2);		
		pn.add(txtHello);
		pn.add(txtHuman);
		
		// 컨테이너인 Frame 창에 자식 컴포넌트들을 (배치관리자에 따라서) 배치
		add(pn, BorderLayout.CENTER); // 패널을 중앙에 배치
		add(lbTitle, BorderLayout.NORTH);
		add(btnGreet, BorderLayout.EAST);
		add(lbResult, BorderLayout.SOUTH);
		this.add(btnReset, BorderLayout.WEST);
		
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
		System.out.println(">> 인사하기 " +  strHello 
				+ " " + strHumanName + "~!!!"); // 콘솔창 출력
		this.lbResult.setText(">> 인사하기 " +  strHello 
				+ " " + strHumanName + "~!!!");
	}
	
	public static void main(String[] args) {
//		AwtGuiMain5 frm1 = new AwtGuiMain5(); 
		AwtGuiMain7 frm1 = new AwtGuiMain7("인사 잘하기 GREET 프로그램");
		frm1.setVisible(true); // show, hide
	}



}
