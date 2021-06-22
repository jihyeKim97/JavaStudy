package UI.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class JSwingFrame1 extends JFrame {

	public JSwingFrame1() {
//		super();
//		this.setTitle("무명 프레임");
//		super("무명 프레임");
		this("무명 프레임");
	}

	public JSwingFrame1(String title) {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setSize(800, 400);
//		this.setLocation(100, 100);
		this.setBounds(100, 100, 800, 400);

		// 배치관리자
//		this.setLayout(new BorderLayout()); // 생략
		// BorderLayout EWSN + C 5영역..

		JLabel lb1 = new JLabel("스윙 버튼 테스트", JLabel.CENTER);
		lb1.setFont(new Font("굴림", Font.BOLD, 40));

		// this.add(lb1, BorderLayout.NORTH);
		this.getContentPane().add(lb1, BorderLayout.NORTH);

//		JButton btn = new JButton("+"); // add op 덧셈 버튼
//		this.getContentPane().add(btn, BorderLayout.SOUTH);

		// 수치값 2개, 연산자, =계산, 리셋 버튼들 5개...
		JButton btnNum1, btnNum2, btnOP, btnCal, btnReset;
		btnNum1 = new JButton("100");
		btnNum2 = new JButton("50");

		// 아이콘 파일은 http://famfamfam.com/lab/icons/ 에서...
		// https://thenounproject.com/
		// https://fontawesome.com/icons?d=gallery&p=2
		ImageIcon icNum1 = new ImageIcon("./icons/bell.png");
		ImageIcon icNum2 = new ImageIcon("./icons/bug.png");
		btnNum1.setIcon(icNum1);
		btnNum2.setIcon(icNum2);

		ImageIcon icPlus = new ImageIcon("./icons/add.png");
		btnOP = new JButton("");
		btnOP.setIcon(icPlus);

		btnCal = new JButton("", new ImageIcon("./icons/calculator.png"));

		btnReset = new JButton("", new ImageIcon("./icons/arrow_refresh.png"));
//		btnReset.setToolTipText("리셋 기능!");

		Font btFnt = new Font("궁서", Font.BOLD, 26);

//		JPanel pn1 = new JPanel();
//		pn1.setLayout(new FlowLayout());
		JPanel pn1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
		pn1.setBackground(Color.ORANGE);
		pn1.setBorder(new EtchedBorder(Color.RED, Color.darkGray));
		// 패널에 에칭효과 경계선(border) 설정.

		// 패널 하나에 버튼 객체 5개를 묶어서 표현
		JButton[] btns = { btnNum1, btnOP, btnNum2, btnCal, btnReset };
		String[] tooltips = { "수치1", "연산자", "수치2", "계산하기", "리셋하기" };
//		pn1.add(btnNum1);
		int i = 0;
		for (JButton jbtn : btns) {
			jbtn.setFont(btFnt);
			// jbtn.setToolTipText(tooltips[i++]);
			jbtn.setToolTipText(tooltips[i]);
			pn1.add(jbtn);
			i++;
		}

		getContentPane().add(pn1, BorderLayout.CENTER);

//		getContentPane()
//		.add(btnNum1, BorderLayout.WEST);
//		getContentPane()
//		.add(btnNum2, BorderLayout.EAST);

		JLabel lbStatus = new JLabel("상태바:: ", icNum1, JLabel.LEADING);
		lbStatus.setFont(new Font("궁서", Font.PLAIN, 24));

		getContentPane().add(lbStatus, BorderLayout.SOUTH);

		this.setVisible(true);
	}

	public static void main(String[] args) {
		JSwingFrame1 frm = new JSwingFrame1();
//		frm.setVisible(true);
	}
}
