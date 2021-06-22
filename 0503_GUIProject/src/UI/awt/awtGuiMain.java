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
		// client ����
		// ���������� â = ������
		Frame frm1 = new Frame("java sample gui comment");
		frm1.setLocation(100, 100);
		frm1.setSize(640, 480);
		frm1.setLayout(new FlowLayout());// FlowLayout���� add ���� �߿�!

		final Color crPink = Color.pink;
		final Color crBlue = Color.BLUE;
		final Color crGreen = Color.GREEN;
		final Color crOrange = Color.ORANGE;
		final Color crRed = new Color(0xFF, 0, 0);

		Font ftNormal = new Font("����", Font.ITALIC, 30);
		Font ftBig = new Font("�ü�ü", Font.BOLD, 80);

		Label lbTilte = new Label("** �λ��ϱ�!");
		Label lbHello = new Label("Hello GUI!");
		Label lbHello2 = new Label("�ȳ�?��");

		lbTilte.setFont(ftBig);
		lbTilte.setForeground(crGreen); // �����
		
		lbHello.setFont(ftNormal);
		
		lbHello2.setFont(ftNormal);
		
		TextField txtHello = new TextField(20); //  input 
		TextField txtHuman = new TextField("Mr.P",14);
		txtHello.setFont(ftNormal);
		txtHuman.setFont(ftNormal);
		txtHuman.setForeground(crRed);
		txtHuman.setBackground(crBlue);
 
		// ������Ʈ ��ü (Button)
		Button btnGreet = new Button("Greet"); //  ����, ��ŵ��..
		btnGreet.setForeground(crPink);
		btnGreet.setFont(new Font("Serif",Font.PLAIN,22)); // �����̳� ���
		
		// ������Ʈ ��ü 
		// ���� ���̺� ��ü�� ���� ���� ǥ��
		frm1.add(lbTilte); // �����̳� ������Ʈ
		frm1.add(lbHello);
		frm1.add(lbHello2);

		frm1.add(txtHello);
		frm1.add(txtHuman);
		frm1.add(btnGreet);

		frm1.setBackground(crOrange);
		frm1.setVisible(true); // AWTâ�� Close X��ư �ν���

	}
}
