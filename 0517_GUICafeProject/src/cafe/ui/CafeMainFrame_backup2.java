package cafe.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIDefaults;
import javax.swing.border.EmptyBorder;

import cafe.ui.components.ImagePanel;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CafeMainFrame_backup2 extends JFrame {

//	private JPanel contentPane; // �Ϲ� �г�
	ImagePanel contentPane; // ���� ��� �г�
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CafeMainFrame_backup2 frame = new CafeMainFrame_backup2();
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
	public CafeMainFrame_backup2() {
		setResizable(false);
		setTitle("\uB9C8\uC774 \uCE74\uD398: \uC8FC\uBB38\uC2DC\uC2A4\uD15C");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\cup_key.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 379, 538);
		
		//contentPane = new JPanel();
		ImageIcon icBack = 
				new ImageIcon("./images/bg/bg1.jpg");
		Image bgImg = icBack.getImage();
		contentPane = new ImagePanel(
				bgImg, "bg1.jpg", 380, 540);
				//bgImg, "bg1.jpg");
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbLogo = new JLabel("");
		lbLogo.setForeground(Color.ORANGE);
		lbLogo.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\GUICafeProject\\images\\logo\\coffee_logo.png"));
		lbLogo.setBounds(37, 10, 64, 64);
		contentPane.add(lbLogo);
		
		JLabel lbTitle = new JLabel("My CAFE");
		lbTitle.setForeground(Color.ORANGE);
		lbTitle.setFont(new Font("Chiller", Font.BOLD, 50));
		lbTitle.setBounds(135, 10, 171, 64);
		contentPane.add(lbTitle);
		
		JLabel lbBeverage = new JLabel("BEVERAGES");
		lbBeverage.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
//				super.mouseClicked(e);
				System.out.println("���� īŻ�α�... ����");
			}
			//			@Override
//			public void mouseClicked(MouseEvent e) {
//				//this.
//				System.out.println("���� īŻ�α�... ����");
//			}
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("���� īŻ�α�... ����");
				lbBeverage.setOpaque(true);// ��� ������ ����
				lbBeverage.setBackground(Color.ORANGE); // ����
//				lbBeverage.setForeground(Color.ORANGE); // ���ڻ�
			}
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("���� īŻ�α�... ��Ż");
				lbBeverage.setOpaque(false);
				lbBeverage.setBackground(
						new Color(0, 0, 0, 128));
//				lbBeverage.setForeground(Color.GRAY);
			}
		});
		lbBeverage.setFont(new Font("Gabriola", Font.BOLD, 28));
		lbBeverage.setBounds(192, 176, 159, 39);
		contentPane.add(lbBeverage);
		
		JLabel lbFood = new JLabel("FOODS");
		lbFood.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("���� īŻ�α�... ����");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("���� īŻ�α�... ����");
				lbFood.setOpaque(true);// ��� ������ ����
				lbFood.setBackground(Color.ORANGE); // ����
//				lbFood.setForeground(Color.ORANGE); // ���ڻ�
			}
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("���� īŻ�α�... ��Ż");
				lbFood.setOpaque(false);
				lbFood.setBackground(
						new Color(0, 0, 0, 128));
//				lbFood.setForeground(Color.GRAY);
			}
		});
		lbFood.setFont(new Font("Gabriola", Font.BOLD, 28));
		lbFood.setBounds(192, 241, 159, 31);
		contentPane.add(lbFood);
		
		JLabel lbOrder = new JLabel("ORDERS");
		lbOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("�ֹ� ����... ����");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("�ֹ� ����... ����");
				lbOrder.setOpaque(true);// ��� ������ ����
				lbOrder.setBackground(Color.ORANGE); // ����
//				lbOrder.setForeground(Color.ORANGE); // ���ڻ�
			}
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("�ֹ� ����... ��Ż");
				lbOrder.setOpaque(false);
				lbOrder.setBackground(
						new Color(0, 0, 0, 128));
//				lbOrder.setForeground(Color.GRAY);
			}
		});
		lbOrder.setFont(new Font("Gabriola", Font.BOLD, 28));
		lbOrder.setBounds(192, 303, 159, 31);
		contentPane.add(lbOrder);
		
		JLabel lbLogin = new JLabel("LOGIN");
		lbLogin.setFont(new Font("����", Font.PLAIN, 20));
		lbLogin.setBounds(12, 454, 55, 22);
		contentPane.add(lbLogin);
		
		JLabel lbAdmin = new JLabel("ADMIN");
		lbAdmin.setFont(new Font("����", Font.PLAIN, 20));
		lbAdmin.setBounds(296, 454, 55, 22);
		contentPane.add(lbAdmin);
	}
}
