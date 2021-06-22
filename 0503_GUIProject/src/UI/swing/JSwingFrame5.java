package UI.swing;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.border.EtchedBorder;

public class JSwingFrame5 extends JFrame
			implements ActionListener
{
	int first;  // 100 => btnNum1 연결...
	int second; // 50
	JButton btnNum1, btnNum2, btnOP, btnCal, btnReset;
	JLabel lbStatus;
	
	// 옵션버튼 (체크박스버튼)
	JToggleButton tgBtn1,tgBtn2,tgBtn3,tgBtn4;
//	JToggleButton[] tgBtns;
	
	// 라디오버튼 (배타적 선택) -- 연산자 선택 (단 한개만 선택된 상태)
	JRadioButton[] rdBtns; // 배열
	
	public JSwingFrame5() {
//		super();
//		this.setTitle("무명 프레임");
//		super("무명 프레임");
		this("무명 프레임");
	}
	
	public JSwingFrame5(String title) {		
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setSize(800, 400);
//		this.setLocation(100, 100);
		this.setBounds(100, 100, 800, 400);
		
		// 배치관리자
//		this.setLayout(new BorderLayout()); // 생략
			// BorderLayout EWSN + C 5영역..
		
		JLabel lb1 = new JLabel("스윙 버튼 테스트",
				JLabel.CENTER);
		lb1.setFont(new Font("굴림", Font.BOLD, 40));
		
		//this.add(lb1, BorderLayout.NORTH);
		this.getContentPane().add(lb1,BorderLayout.NORTH);
		
//		JButton btn = new JButton("+"); // add op 덧셈 버튼
//		this.getContentPane().add(btn, BorderLayout.SOUTH);
		
		// 수치값 2개, 연산자, =계산, 리셋 버튼들 5개...
//		JButton btnNum1, btnNum2, btnOP, btnCal, btnReset;
		
		this.first = 100; this.second = 50; 
		btnNum1 = new JButton(""+first);
		btnNum2 = new JButton(String.valueOf(second));
//		btnNum1 = new JButton("100");
//		btnNum2 = new JButton("50");
		
		// 아이콘 파일은 http://famfamfam.com/lab/icons/ 에서...
		// https://thenounproject.com/
		// https://fontawesome.com/icons?d=gallery&p=2
		ImageIcon icNum1 = 
				new ImageIcon("./icons/bell.png");
		ImageIcon icNum2 =
				new ImageIcon("./icons/bug.png");
		btnNum1.setIcon(icNum1); 
		btnNum2.setIcon(icNum2);
		
		ImageIcon icPlus = 
				new ImageIcon("./icons/add.png"); 
		btnOP = new JButton("");
		btnOP.setIcon(icPlus);
		
		btnCal = new JButton("", 
		new ImageIcon("./icons/calculator.png"));
		
		btnReset = new JButton("",
		new ImageIcon("./icons/arrow_refresh.png"));
//		btnReset.setToolTipText("리셋 기능!");
		
		Font btFnt = new Font("궁서", Font.BOLD, 26);
		
//		JPanel pn1 = new JPanel();
//		pn1.setLayout(new FlowLayout());
		JPanel pn1 = new JPanel(
			new FlowLayout(FlowLayout.CENTER,
					20, 10));
		pn1.setBackground(Color.ORANGE);
		pn1.setBorder(
			new EtchedBorder(Color.RED, Color.darkGray));
		// 패널에 에칭효과 경계선(border) 설정.
		
		
		// 패널 하나에 버튼 객체 5개를 묶어서 표현
		JButton[] btns = {
			btnNum1, btnOP, btnNum2, btnCal, btnReset			
		};		
		String[]  tooltips = {
			"수치1", "연산자", "수치2", "계산하기", "리셋하기"	
		};
//		pn1.add(btnNum1);
		int i = 0; 
		for (JButton jbtn : btns) {
			jbtn.setFont(btFnt);
			//jbtn.setToolTipText(tooltips[i++]);
			jbtn.setToolTipText(tooltips[i]);
			pn1.add(jbtn);			
			i++;
		}
		
		getContentPane().add(pn1, BorderLayout.CENTER);
		
//		getContentPane()
//		.add(btnNum1, BorderLayout.WEST);
//		getContentPane()
//		.add(btnNum2, BorderLayout.EAST);
		
		//JLabel lbStatus = new JLabel("상태바:: ", // 지역변수
		this.lbStatus = new JLabel("상태바:: ", // 필드
				icNum1, JLabel.LEADING); 
		lbStatus.setFont(new Font("궁서", Font.PLAIN, 24));
		
		getContentPane().add(lbStatus, BorderLayout.SOUTH);
		
		//Font tgFont = new Font("궁서", Font.PLAIN, 24);
		Font tgFont = lbStatus.getFont(); 
			// 레이블에 이미 적용된 폰트를 참조함..
		
		// 결과값을 더 증가시켜주는 4개의 옵션 버튼들...
		// JToggleButton 토글버튼: 상태 선택(눌러짐)/비선택(올라옴)
		// == 스위치 on/off, up/down, left/right, true/false
		this.tgBtn1 = new JToggleButton("+100");
		tgBtn1.setFont(tgFont);
		this.tgBtn2 = new JToggleButton("x2");
		tgBtn2.setFont(tgFont);
		this.tgBtn3 = new JToggleButton("x10");
		tgBtn3.setFont(tgFont);
		this.tgBtn4 = new JToggleButton("x100");
		tgBtn4.setFont(tgFont);
		
		//JPanel pn2 = new JPanel(); // flowlayout 수평적으로 버튼 4개 배치
		JPanel pn2 = new JPanel(
//			new GridLayout(2, 2, 20, 10)); // 2 x 2
			new GridLayout(4, 1, 20, 10)); // 4 x 1			
			// 그리드 배치 (행x열) 동일 크기의 칸(테이블셀)들이 여러개 있고, 순서대로 배치
		pn2.setBackground(Color.GREEN);
		pn2.add(tgBtn1); // grid cell (0,0)칸
		pn2.add(tgBtn2); // grid cell (1,0)칸
		pn2.add(tgBtn3); // grid cell (2,0)칸
		pn2.add(tgBtn4); // grid cell (3,0)칸
		
		getContentPane().add(pn2, BorderLayout.WEST);
		
		// 연산자 한개 선택을 라디오 버튼들 초기화
		final int rdLen = 4; // 사칙연산
		String opIconNames[] = {
			"add", "delete", "cross", "cut"	
		}; // 더하기 add.png 파일, 빼기, 곱하기, 나누기(cut??  divide?)
		// "./icons/add.png" 
		// "./icons/" + "add" + ".png"
		this.rdBtns = new JRadioButton[rdLen];
		final ImageIcon selV = 
				new ImageIcon("./icons/tick.png"); 
					// v체크 => 선택된 상태
//		JPanel pn3 = new JPanel(); // flowlayout		
		JPanel pn3 = new JPanel(new GridLayout(4, 1));
		
		ButtonGroup rdGroup = new ButtonGroup();
		// 라디오버튼들을 동일 그룹으로 묶어서 하나의 UI처럼 동작하게 만듬.
		// 즉, 배타성을 통해서 오직 한 순간에 그룹에서는 하나의 라디오버튼만 true로 선택됨.
		
		for (int j = 0; j < opIconNames.length; j++) {
			ImageIcon ic = new ImageIcon(
					"./icons/" + opIconNames[j] + ".png");
			JRadioButton rd = 
					new JRadioButton(opIconNames[j], ic);
			rd.setSelectedIcon(selV); // 선택상태의 이미지 설정
			rdBtns[j] = rd;
			pn3.add(rd);
			rdGroup.add(rd);
		}
		getContentPane().add(pn3, BorderLayout.EAST);		
		
		// 이벤트 연동 처리 --  이벤트 리스너 등록
		btnCal.addActionListener(this);		
			// ActionListener 인터페이스 구현한 객체가 인자 자격
		btnNum1.addActionListener(this);
		btnNum2.addActionListener(this);
		
		this.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		JSwingFrame5 frm = new JSwingFrame5();
//		frm.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton evBtn = (JButton)e.getSource();
		if( evBtn == btnNum1 ) { // 주소까지 동일한 버튼?
			// btnNum1 경우
			int r = (int)(Math.random()*1000)+1;
			System.out.println("first 랜덤수: " + r);
			this.first = r;
			this.btnNum1.setText(""+first);
			btnNum1.setToolTipText("first 랜덤수: " + r);
		} else if( evBtn == btnNum2 ) {		
			// btnNum2 경우
			int r2 = (int)(Math.random()*1000)+1;
			System.out.println("second 랜덤수: " + r2);
			second = r2;
			btnNum2.setText(String.valueOf(r2));
			btnNum2.setToolTipText("second 랜덤수: " + r2);
		} else if( evBtn == btnCal ) { // 계산하기
			// btnCal 경우
			int	result = this.first + this.second;
			System.out.printf(" %d + %d = %d \n", first, 
					second, result);
			
			// 옵션버튼들 처리 +100, x2, x10, x100
			// 각 토글 버튼들이 눌렸나? isSelected() true인지?
			if( this.tgBtn1.isSelected() == true ) {
				result += 100;
				System.out.println(">> 옵션 +100 : " + result);
			}
			if( this.tgBtn2.isSelected() == true ) {
				result *= 2;
				System.out.println(">> 옵션 x2 : " + result);
			}
			if( this.tgBtn3.isSelected() == true ) {
				result *= 10;
				System.out.println(">> 옵션 x10 : " + result);
			}
			if( this.tgBtn4.isSelected() == true ) {
				result *= 100;
				System.out.println(">> 옵션 x100 : " + result);
			}			
			
			this.lbStatus.setText("+ 연산 결과 : " + result);
			
		} else if( evBtn == btnOP ) { // 연산자
			System.out.println("TBD 구현 예정");
		} else if( evBtn == btnReset ) { // reset
			System.out.println("TBD 구현 예정");
		}
		else {
			System.out.println("처리못하는 버튼???");
		}
	}
}
