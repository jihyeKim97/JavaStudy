package cafe.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;

public class CafeMainFrame_backup1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CafeMainFrame_backup1 frame = new CafeMainFrame_backup1();
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
	public CafeMainFrame_backup1() {
		setResizable(false);
		setTitle("\uB9C8\uC774 \uCE74\uD398: \uC8FC\uBB38\uC2DC\uC2A4\uD15C");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\cup_key.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 379, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbLogo = new JLabel("");
		lbLogo.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\GUICafeProject\\images\\logo\\coffee_logo.png"));
		lbLogo.setBounds(37, 10, 64, 64);
		contentPane.add(lbLogo);
		
		JLabel lbTitle = new JLabel("My CAFE");
		lbTitle.setFont(new Font("Chiller", Font.BOLD, 50));
		lbTitle.setBounds(135, 10, 171, 64);
		contentPane.add(lbTitle);
		
		JLabel lbBeverage = new JLabel("BEVERAGES");
		lbBeverage.setFont(new Font("Gabriola", Font.BOLD, 28));
		lbBeverage.setBounds(205, 193, 146, 22);
		contentPane.add(lbBeverage);
		
		JLabel lbFood = new JLabel("FOODS");
		lbFood.setFont(new Font("Gabriola", Font.BOLD, 28));
		lbFood.setBounds(205, 250, 146, 22);
		contentPane.add(lbFood);
		
		JLabel lbOrder = new JLabel("ORDERS");
		lbOrder.setFont(new Font("Gabriola", Font.BOLD, 28));
		lbOrder.setBounds(205, 312, 146, 22);
		contentPane.add(lbOrder);
		
		JLabel lbLogin = new JLabel("LOGIN");
		lbLogin.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lbLogin.setBounds(12, 454, 55, 22);
		contentPane.add(lbLogin);
		
		JLabel lbAdmin = new JLabel("ADMIN");
		lbAdmin.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lbAdmin.setBounds(296, 454, 55, 22);
		contentPane.add(lbAdmin);
	}
}
