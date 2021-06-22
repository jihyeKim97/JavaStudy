package cafe.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIDefaults;
import javax.swing.border.EmptyBorder;

import cafe.ui.admin.CafeAdminFrame;
import cafe.ui.components.ImagePanel;
import cafe.ui.food.FoodMenuFrame;
import cafe.ui.member.MemberLoginDialog;
import db.util.OracleDBUtil;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CafeMainFrame extends JFrame {

	// 로그인 상태 처리 
	public JLabel lbLogin;
	private static String loggedIn = null; 
		// 널이면 비로그인상태 혹은 로그아웃 상태
		// 널이아니면 그 계정명이 로그인 중인 상태
	// readonly getter
	public static String getLoggedIn() {
		return loggedIn;
	}
	public static boolean isWhoLoggedIn() {
		return loggedIn != null; // true: false;
	}
	
	public void changeLoginState(boolean bState,
					String login) {
		if(bState == true)  { // login 상태
			loggedIn = login;
			System.out.println(login + "로 로그인 중...");
			lbLogin.setText(login + " 로그인 중");
			lbLogin.setForeground(Color.GREEN);
			lbLogin.setToolTipText("클릭 시 로그아웃..");
		} else { // logout 상태 혹은 before login 상태
			loggedIn = null;
			System.out.println(login + " 로그아웃됨...");
			lbLogin.setText("login");
			lbLogin.setForeground(Color.yellow);
			lbLogin.setToolTipText("로그인 창 표시..");
		}
	}
	
//	private JPanel contentPane; // 일반 패널
	ImagePanel contentPane; // 사진 배경 패널
	CafeMainFrame frm;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CafeMainFrame frame = new CafeMainFrame();
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
	public CafeMainFrame() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// 창이 닫히는 중...
				OracleDBUtil.endConnection(); // DB 연결 해제..
				System.out.println("프로그램 종료... 및 DB 연결 해제");
			}
		});
		setResizable(false);
		this.frm = this;
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
				System.out.println("음료 카탈로그... 선택");
				FoodMenuFrame fmFrm = new FoodMenuFrame(frm);
				Point fPt = frm.getLocationOnScreen();
				fmFrm.setLocation(fPt.x+frm.getWidth()+20,fPt.y);
					// 옆에 나란히 창이 표시됨.
				fmFrm.setVisible(true);	
			}
			//			@Override
//			public void mouseClicked(MouseEvent e) {
//				//this.
//				System.out.println("음료 카탈로그... 선택");
//			}
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("음료 카탈로그... 진입");
				lbBeverage.setOpaque(true);// 배경 불투명도 조정
				lbBeverage.setBackground(Color.ORANGE); // 배경색
//				lbBeverage.setForeground(Color.ORANGE); // 글자색
			}
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("음료 카탈로그... 이탈");
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
				System.out.println("음식 카탈로그... 선택");
				// 음식만 표시할 수 있음.. db에서 가져올때 
				FoodMenuFrame fmFrm = new FoodMenuFrame(frm);
				Point fPt = frm.getLocationOnScreen();
				fmFrm.setLocation(fPt.x+frm.getWidth()+20,fPt.y);
					// 옆에 나란히 창이 표시됨.
				fmFrm.setVisible(true);							
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("음식 카탈로그... 진입");
				lbFood.setOpaque(true);// 배경 불투명도 조정
				lbFood.setBackground(Color.ORANGE); // 배경색
//				lbFood.setForeground(Color.ORANGE); // 글자색
			}
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("음식 카탈로그... 이탈");
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
				System.out.println("주문 내역... 선택");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("주문 내역... 진입");
				lbOrder.setOpaque(true);// 배경 불투명도 조정
				lbOrder.setBackground(Color.ORANGE); // 배경색
//				lbOrder.setForeground(Color.ORANGE); // 글자색
			}
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("주문 내역... 이탈");
				lbOrder.setOpaque(false);
				lbOrder.setBackground(
						new Color(0, 0, 0, 128));
//				lbOrder.setForeground(Color.GRAY);
			}
		});
		lbOrder.setFont(new Font("Gabriola", Font.BOLD, 28));
		lbOrder.setBounds(192, 303, 159, 31);
		contentPane.add(lbOrder);
		
//		JLabel lbLogin = new JLabel("LOGIN");
		lbLogin = new JLabel("LOGIN");
		lbLogin.setFont(new Font("굴림", Font.PLAIN, 20));
		lbLogin.setBounds(12, 454, 159, 22);
		contentPane.add(lbLogin);
		lbLogin.setForeground(Color.YELLOW);
		lbLogin.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if( loggedIn == null ) {
					System.out.println("login..");
					MemberLoginDialog loginDlg 
						= new MemberLoginDialog(frm);
					// 모윈도우의 중앙에 대화상자 띄우기
					Point pt = frm.getLocationOnScreen();
					int dx = pt.x + frm.getWidth()/2
								- loginDlg.getWidth()/2; 
					int dy = pt.y + frm.getHeight()/2
								- loginDlg.getHeight()/2;
					loginDlg.setLocation(dx, dy);
					loginDlg.setVisible(true);
				} else {
					changeLoginState(false, loggedIn);
					// 로그아웃...
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lbLogin.setForeground(Color.CYAN);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lbLogin.setForeground(Color.YELLOW);
			}
			
		});
		
		JLabel lbAdmin = new JLabel("ADMIN");
		lbAdmin.setFont(new Font("굴림", Font.PLAIN, 20));
		lbAdmin.setBounds(268, 454, 83, 22);
		contentPane.add(lbAdmin);
		lbAdmin.setForeground(Color.yellow);
		lbAdmin.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("admin..");
				CafeAdminFrame adminDlg 
				= new CafeAdminFrame();
				// 모윈도우의 중앙에 대화상자 띄우기
				Point pt = frm.getLocationOnScreen();
				int dx = pt.x + frm.getWidth()/2
							- adminDlg.getWidth()/2; 
				int dy = pt.y + frm.getHeight()/2
							- adminDlg.getHeight()/2;
				adminDlg.setLocation(dx, dy);
				adminDlg.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lbAdmin.setForeground(Color.CYAN);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lbAdmin.setForeground(Color.YELLOW);
			}
			
		});
	}


}
