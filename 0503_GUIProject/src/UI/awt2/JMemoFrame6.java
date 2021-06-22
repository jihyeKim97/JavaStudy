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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

// about 버튼 전용 이벤트 처리 클래스 정의
//class AboutButtonHandler implements ActionListener {
//	JMemoFrame6 frm;
//	public AboutButtonHandler(JMemoFrame6 frm) {
//		this.frm = frm; // 핸들러를 호출한 프레임창의 주소를 기억함.
//	}
//	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		System.out.println(">> About 정보 표시...");
//		String about = "Information:: ";
//		about += frm.getTitle();
//		
//		JDialog aboutDlg =  // 대화상자도 하나의 컨테이너
////			new JDialog(frm, "info 대화상자..", true); // 모달 modal
//			new JDialog(frm, "info 대화상자..", false); // 모달리스 modaless
//		aboutDlg.setSize(240, 240);
//		aboutDlg.setLocation(100, 100); // 나중에는 화면 중앙, 부모창 중앙??
//		
//		JLabel lbInfo = new JLabel(about, 
//				JLabel.CENTER);
////		lbInfo.setFont(frm.ftMedium);
//		aboutDlg.add(lbInfo);
//		
//		aboutDlg.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
//		
//		aboutDlg.setVisible(true);
//	}
//	
//}

// 클래스의 이름 J시작하는 GUI클래스면 SWING 기술에 포함.
public class JMemoFrame6 extends JFrame implements ActionListener {
	// 상수 선언
	public static final Font ftNormal = new Font("굴림", Font.PLAIN, 24);
	public static final Font ftMedium = new Font("굴림", Font.PLAIN | Font.ITALIC, 32);
	public static final Font ftBig = new Font("바탕", Font.BOLD, 48);
	public static final Color crAccent = Color.ORANGE;
	public static final Color crSub = new Color(128, 0, 200);

	// 필드 선언 (UI 컴포넌트)
	// 제목 레이블
	private JLabel lbTitle;
	// 중앙 텍스트 입력?
//	private JTextField txtMemo; // 한 줄 짜리 문자열 입력
	private JTextArea txtMemo;
	// 다중 행 문자열 입력; 행 x 열... 엔터키, 스크롤바
	// 하단 상태 레이블
	private JLabel lbStatus; // 스테이터스 바

	// 버튼 4개 추가 - 정보, 폰트배경색상반전, 메모저장, 메모읽기
	private JButton btnAbout;
	private JButton btnChangeColor; // FG <=> BG
	private JButton btnSave;
	private JButton btnLoad;

	private JPanel pnBottom; // south 위치에 배치할 패널(작은 컨테이너)

	boolean bColorBlackOnWhite; // 컬러 반전 플래그 필드 (상태변수)

	public JMemoFrame6() {
		super("제목없음");
	}

	public JMemoFrame6(String title) {
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
		this.lbTitle = new JLabel("제목: ");
//		txtMemo = new JTextField("메모를 입력하세요!", 40);
		this.txtMemo = new JTextArea("메모를 입력하세요!", 40, 40); // 행, 렬
		this.lbStatus = new JLabel("상태바: oooooooo", Label.LEFT);
		lbTitle.setFont(ftBig);
		lbStatus.setFont(ftNormal);
		txtMemo.setFont(ftMedium);

		// 정보, 폰트배경색상반전, 메모저장, 메모읽기
		btnAbout = new JButton("info");
		btnLoad = new JButton("load");
		btnSave = new JButton("save");
		btnChangeColor = new JButton("F<->B"); // inversion
		this.bColorBlackOnWhite = true; // B/W <==> W/B

		// 패널 생성(배치 관리자도 동시 생성설정)
//		this.pnBottom = new Panel(); // flowLayout 기본 적용
//		FlowLayout pnLayout = 
//			new FlowLayout(FlowLayout.LEFT, 0, 0);
		BorderLayout pnLayout = new BorderLayout();
		this.pnBottom = new JPanel(pnLayout); // 동서남북중앙

		// 패널에 컴포넌트들을 배치
		pnBottom.add(lbStatus, BorderLayout.CENTER);
		// pnBottom.add(new Label(" ")); // 공백레이블 객체를 여백

		JPanel pnBtns = new JPanel();// flowLayout 기본 적용
		pnBtns.add(btnAbout);
		pnBtns.add(new Label(" "));
		pnBtns.add(btnLoad);
		pnBtns.add(btnSave);
		pnBtns.add(btnChangeColor);
		pnBottom.add(pnBtns, BorderLayout.EAST);
		// 패널에 한 영역에 작은 다른 패널을 배치

		// 창에 컴포넌트들을 배치
		this.add(lbTitle, BorderLayout.NORTH);
		this.add(txtMemo, BorderLayout.CENTER);
		this.add(pnBottom, BorderLayout.SOUTH);
//		this.add(lbStatus, BorderLayout.SOUTH);//상태바

		// 이벤트 설정
		// (이벤트들과 ui컴포넌트들을 핸들러 함수와 연동 시킴 => 리스너 등록)
		btnChangeColor.addActionListener(this);
		// ActionListener 이벤트(인터페이스)를 처리할 수 있는
		// 객체를 입력받음..
		// 처리한다는 것은 핸들러 함수인 이벤트인터페이스의 추상메소드를
		// 구현했다는 것임.. 즉 actionPerformed() 구현해야함.

//		AboutButtonHandler aboutHandler = new AboutButtonHandler(this);
//		btnAbout.addActionListener(aboutHandler);

		// JFrame의 기능... 창을 기본 닫기 가능하게...
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 프로그램 즉시 종료...

		// 창 보이기
		this.setVisible(true);
	}

	public static void main(String[] args) {
		JMemoFrame6 frm = new JMemoFrame6("나의 메모장2");
		// frm.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("컬런 반전 버튼 눌렸음!!");

		if (bColorBlackOnWhite) { // == true B/W
			System.out.println("컬러반전: to W/B");
			lbStatus.setText("컬러반전: to W/B");
			this.txtMemo.setForeground(Color.WHITE); // 전경
			this.txtMemo.setBackground(Color.black); // 배경
			bColorBlackOnWhite = false;
		} else { // false W/B 상태..
			System.out.println("컬러반전: to B/W");
			lbStatus.setText("컬러반전: to B/W");
			this.txtMemo.setForeground(Color.BLACK); // 전경
			this.txtMemo.setBackground(Color.white); // 배경
			bColorBlackOnWhite = true;
		}
//		bColorBlackOnWhite = !bColorBlackOnWhite;

	}

}
