package UI.awt;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.nio.Buffer;

public class awtGuiMain {
	public static void main(String[] args) {

		// border
		// title bar
		// client 영역
		// 리사이져블 창 = 반응형
		Frame frm1 = new Frame("java sample gui comment");
		frm1.setLocation(100, 100);
		frm1.setSize(640, 480);
		frm1.setLayout(new FlowLayout());// FlowLayout에서 add 순서 중요!

		final Color crPink = Color.pink;
		final Color crBlue = Color.BLUE;
		final Color crGreen = Color.GREEN;
		final Color crOrange = Color.ORANGE;
		final Color crRed = new Color(0xFF, 0, 0);

		Font ftNormal = new Font("돋음", Font.ITALIC, 30);
		Font ftBig = new Font("궁서체", Font.BOLD, 80);

		Label lbTilte = new Label("** 인사하기!");
		Label lbHello = new Label("Hello GUI!");
		Label lbHello2 = new Label("안녕?ㅎ");

		lbTilte.setFont(ftBig);
		lbTilte.setForeground(crGreen); // 전경색
		
		lbHello.setFont(ftNormal);
		
		lbHello2.setFont(ftNormal);
		
		TextField txtHello = new TextField(20); //  input 
		TextField txtHuman = new TextField("Mr.P",14);
		txtHello.setFont(ftNormal);
		txtHuman.setFont(ftNormal);
		txtHuman.setForeground(crRed);
		txtHuman.setBackground(crBlue);
 
		// 컴포넌트 객체 (Button)
		Button btnGreet = new Button("Greet"); //  연산, 통신등등..
		btnGreet.setForeground(crPink);
		btnGreet.setFont(new Font("Serif",Font.PLAIN,22)); // 컨테이너 요소
		
		// 컴포넌트 객체 
		// 제목 레이블 객체를 가장 먼저 표시
		frm1.add(lbTilte); // 컨테이너 컴포넌트
		frm1.add(lbHello);
		frm1.add(lbHello2);

		frm1.add(txtHello);
		frm1.add(txtHuman);
		frm1.add(btnGreet);

		frm1.setBackground(crOrange);
		frm1.setVisible(true); // AWT창의 Close X버튼 부실행

	}
}
