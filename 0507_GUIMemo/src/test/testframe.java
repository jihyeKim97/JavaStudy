package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Button;
import java.awt.Color;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class testframe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testframe frame = new testframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public testframe() {
		setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		setTitle("asljkdnalalsdknmaldmasd");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Button button = new Button("\uACB0\uC81C\uD558\uAE30");
		button.setFont(new Font("Dialog", Font.PLAIN, 17));
		contentPane.add(button, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 182, 193));
		contentPane.add(panel, BorderLayout.CENTER);
		
		Button button_1 = new Button("첫번째 버튼");
		button_1.setBackground(new Color(135, 206, 235));
		panel.add(button_1);
		
		Button button_2 = new Button("두번째버튼");
		button_2.setBackground(new Color(102, 205, 170));
		button_2.setForeground(new Color(0, 0, 0));
		panel.add(button_2);
		
		Button button_3 = new Button("세번째버튼");
		button_3.setBackground(new Color(240, 230, 140));
		panel.add(button_3);
		
		Button button_4 = new Button("네번째 버튼");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out .print("버튼 누름~~~");
			}
		});
		button_4.setBackground(new Color(255, 165, 0));
		panel.add(button_4);
		
		Button button_5 = new Button("다섯번째 버튼");
		button_5.setBackground(new Color(255, 105, 180));
		panel.add(button_5);
	}

}
