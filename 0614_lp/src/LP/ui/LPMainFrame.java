package LP.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LP.ui.components.ImagePanel;
import db.mgr.MemberDBMgr;
import db.util.OracleDBUtil;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JPasswordField;

public class LPMainFrame extends JFrame {
	LPMainFrame frm;
	
	private JPanel contentPane_1 = new JPanel();
	private JPanel contentPane_1_1;
	private JTextField txtLogin;
	
	public JLabel lbLogin;
	private static String loggedIn = null; 
	private JPasswordField pwlogin;

	public static String getLoggedIn() {
		return loggedIn;
	}
	public static boolean isWhoLoggedIn() {
		return loggedIn != null; // true: false;
	}
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LPMainFrame frame = new LPMainFrame();
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
	
	public LPMainFrame() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				OracleDBUtil.endConnection();
				System.out.println("프로그램 종료... 및 DB 연결 해제");
			}
		});
		this.frm =this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 550);
		contentPane_1 = new JPanel();
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		ImageIcon icBack = 
				new ImageIcon("C:\\dev2021\\java_ws\\LP\\src\\images\\bg.jpg");
		Image bgImg = icBack.getImage();
		contentPane_1_1 = new ImagePanel(
				bgImg, "bg.jpg", 600, 600);

		contentPane_1_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_1_1);
		contentPane_1_1.setLayout(null);
		
		JLabel lbLogo = new JLabel("");
		lbLogo.setBounds(141, 34, 156, 140);
		contentPane_1_1.add(lbLogo);
		lbLogo.setBackground(Color.PINK);
		lbLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lbLogo.setForeground(Color.DARK_GRAY);
		lbLogo.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\LP\\src\\images\\LPlogo.jpg"));
		lbLogo.setPreferredSize(new Dimension(150,150));
		
		JLabel lbIDLabel = new JLabel("");
		lbIDLabel.setBounds(115, 218, 39, 43);
		contentPane_1_1.add(lbIDLabel);
		lbIDLabel.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\LP\\src\\images\\Idlogo.jpg"));
		
		JLabel lbPWLabel = new JLabel("");
		lbPWLabel.setBounds(115, 271, 39, 43);
		contentPane_1_1.add(lbPWLabel);
		lbPWLabel.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\LP\\src\\images\\Pwlogo.jpg"));
		
		
		
		JLabel lbLoginResult = new JLabel("");
		lbLoginResult.setBounds(115, 326, 211, 23);
		contentPane_1_1.add(lbLoginResult);
		
		pwlogin = new JPasswordField();
		pwlogin.setBounds(153, 276, 173, 38);
		contentPane_1_1.add(pwlogin);
		
		JButton btnLogin = new JButton("");
		btnLogin.setBounds(115, 353, 211, 43);
		contentPane_1_1.add(btnLogin);
		btnLogin.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\LP\\src\\images\\images.button\\login.jpg"));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 로그인
				String login = txtLogin.getText();
				String pw = new String(
						pwlogin.getPassword());
				
				// db 인증
				MemberDBMgr mgr = new MemberDBMgr();
				int r = mgr.loginProcess(login, pw);
				switch (r) {
				case MemberDBMgr.LOGIN_SUCCESS:
					lbLoginResult.setForeground(Color.green);
					lbLoginResult.setText("로그인 인증 성공!!");
					// 메인창에 로그인 성공 결과를 남김...
					break;
				case MemberDBMgr.LOGIN_FAIL_NOT_FOUND:
					lbLoginResult.setForeground(Color.red);
					lbLoginResult.setText("계정명이 존재하지 않습니다.");
					break;
				case MemberDBMgr.LOGIN_FAIL_PW_MISMATCH:
					lbLoginResult.setForeground(Color.red);
					lbLoginResult.setText("암호가 일치하지 않습니다.");
					break;
				case MemberDBMgr.LOGIN_ERROR:	
					lbLoginResult.setForeground(Color.pink);
					lbLoginResult.setText("로그인 인증 입력/DB에러");
					break;	
				default:
					System.out.println("지원하지않습니다.");
					break;
				}
//				OracleDBUtil.endConnection();
			}
		});
		
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				LPBookMainFrame joinbFrm
						= new LPBookMainFrame(frm);
				Point fPt = frm.getLocationOnScreen();
				joinbFrm.setLocation(fPt.x+frm.getWidth()+20,fPt.y);
					// 옆에 나란히 창이 표시됨.
				frm.setVisible(false);
				joinbFrm.setVisible(true);
				frm.dispose();
			}	
			
		});
		
		
		
		
		
		
		JButton lbMemberJoin = new JButton("");
		lbMemberJoin.setBounds(115, 408, 97, 23);
		contentPane_1_1.add(lbMemberJoin);
		lbMemberJoin.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\LP\\src\\images\\images.button\\join.jpg"));
		lbMemberJoin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 로그인 대화창을 숨기고(제거)
				
				// 회원 가입폼 프레임 창 생성 표시
				LPMemberJoinFrame joinFrm
						= new LPMemberJoinFrame(frm);
				
				Point fPt = frm.getLocationOnScreen();
				joinFrm.setLocation(fPt.x+frm.getWidth()+20,fPt.y);
					// 옆에 나란히 창이 표시됨.
				frm.setVisible(false);
				joinFrm.setVisible(true);
				frm.dispose();
			}	
			
		});
		
		
		
		
		JButton btnIDPWButton = new JButton("");
		btnIDPWButton.setBounds(226, 408, 97, 23);
		contentPane_1_1.add(btnIDPWButton);
		btnIDPWButton.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\LP\\src\\images\\images.button\\idpw.jpg"));
		
		
		
		
		
		txtLogin = new JTextField();
		txtLogin.setColumns(10);
		txtLogin.setBounds(153, 218, 173, 43);
		contentPane_1_1.add(txtLogin);
		
		txtLogin.setForeground(Color.LIGHT_GRAY);
		txtLogin.setText("\uACC4\uC815\uBA85 \uC785\uB825");
		txtLogin.setFont(new Font("굴림", Font.PLAIN, 16));
		txtLogin.setColumns(10);
		txtLogin.addFocusListener(new FocusAdapter() {
			
			@Override
			public void focusGained(FocusEvent e) {
				System.out.println("focus get");
				frm.txtLogin.setForeground(Color.black);
				if( frm.txtLogin.getText()
						.equals("계정명 입력") )
					frm.txtLogin.setText(""); 
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				System.out.println("focus lost");
				frm.txtLogin.setForeground(Color.LIGHT_GRAY);
				if( frm.txtLogin.getText()
						.isEmpty() ) 
					frm.txtLogin.setText("계정명 입력");
			}	
			
			
		});
		
	
		
		
		
		
		
		
		
		
	
	}
}
