package cafe.ui.member;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cafe.ui.CafeMainFrame;
import cafe.ui.components.ImagePanel;
import db.data.Member;
import db.mgr.MemberDBMgr;

import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.border.LineBorder;
import javax.swing.SpinnerNumberModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberJoinFrame extends JFrame {

//	private JPanel contentPane;
	ImagePanel contentPane;
	JButton btnMemberJoin;
	CafeMainFrame frm;
	private JTextField txtMemberName;
	private JTextField txtMemberLogin;
	private JPasswordField pwFirst;
	private JPasswordField pwSecond;
	private final ButtonGroup genderGrp = new ButtonGroup();

	MemberDBMgr mgr;
	JLabel lbNoDup;
	JSpinner spinMemberAge;
	JRadioButton rdFemale, rdMale;
	JLabel lbJoinResult;
	
	/**
	 * Create the frame.
	 */
	public MemberJoinFrame(CafeMainFrame frm) {
		this.mgr = new MemberDBMgr();
		setTitle("My CAFE :: \uD68C\uC6D0 \uAC00\uC785 \uD3FC");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\cup_add.png"));
		setResizable(false);
		this.frm = frm;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 424, 447);
		ImageIcon icBg = new ImageIcon(".\\images\\bg\\bg3.jpg");
		Image bgImg = icBg.getImage(); 
//		contentPane = new ImagePanel(bgImg
//				.getScaledInstance(424, 448, Image.SCALE_SMOOTH)
//				, "bg3.jpg");
		contentPane = new ImagePanel(
				bgImg, "bg3.jpg", 424, 448); 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null); // 절대레이아웃
		
		JLabel lbTitle = new JLabel("My CAFE");
		lbTitle.setForeground(Color.ORANGE);
		lbTitle.setFont(new Font("Chiller", Font.BOLD, 50));
		lbTitle.setBounds(210, 10, 171, 64);
		contentPane.add(lbTitle);
		
		JLabel lbLogo = new JLabel("");
		lbLogo.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\GUICafeProject\\images\\logo\\coffee_logo.png"));
		lbLogo.setForeground(Color.ORANGE);
		lbLogo.setBounds(68, 10, 64, 64);
		contentPane.add(lbLogo);
		
		btnMemberJoin = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnMemberJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 회원 가입 DB 처리..
				//mgr.insertNewMember(name, login, pw, age, gender)
				String name = txtMemberName.getText(); 
				String login = txtMemberLogin.getText();
				String pw = new String( pwFirst.getPassword() ); 
				int age = (Integer)spinMemberAge.getValue();  
				int gender = rdFemale.isSelected() ? 
					Member.GENDER_FEMALE: Member.GENDER_MALE;
				Member newMB = new Member(name, login, pw, age, gender);
				boolean r = mgr.insertNewMember(newMB);
				if( r ) {
					lbJoinResult.setText("회원 가입 성공!!");
				} else {
					lbJoinResult.setText("회원 가입 실패!!");
				}
			}
		});
		btnMemberJoin.setEnabled(false);
		btnMemberJoin.setFont(new Font("휴먼옛체", Font.BOLD, 18));
		btnMemberJoin.setBounds(284, 380, 122, 28);
		contentPane.add(btnMemberJoin);
		
		//JLabel lbJoinResult = new JLabel("");
		lbJoinResult = new JLabel("");
		lbJoinResult.setBorder(new LineBorder(Color.GREEN, 1, true));
		lbJoinResult.setBackground(Color.GREEN);
		lbJoinResult.setBounds(12, 347, 394, 28);
		contentPane.add(lbJoinResult);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(121, 94, 262, 242);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(6, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0 \uC774\uB984:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		txtMemberName = new JTextField();
		txtMemberName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				System.out.println("focus get");
				txtMemberName.setForeground(Color.black);
				txtMemberName.setBackground(Color.yellow);
				if( txtMemberName.getText()
						.equals("실명을 입력하세요") )
					txtMemberName.setText(""); // 안내 문구일 때만 지움.
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				System.out.println("focus lost");
				txtMemberName.setForeground(Color.LIGHT_GRAY);
				txtMemberName.setBackground(Color.WHITE);
				if( txtMemberName.getText()
						.isEmpty() ) 
					txtMemberName.setText("실명을 입력하세요");
				checkJoinAvailable();				
			}
		});
		txtMemberName.setText("실명을 입력하세요");
		txtMemberName.setFont(new Font("굴림", Font.BOLD, 14));
		txtMemberName.setForeground(Color.LIGHT_GRAY);
		panel.add(txtMemberName);
		txtMemberName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\uD68C\uC6D0 \uACC4\uC815\uBA85:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		txtMemberLogin = new JTextField();
		txtMemberLogin.setForeground(Color.LIGHT_GRAY);
		txtMemberLogin.setText("ID를 입력하세요");
		txtMemberLogin.setFont(new Font("굴림", Font.BOLD, 14));
		panel.add(txtMemberLogin);
		txtMemberLogin.setColumns(10);
		txtMemberLogin.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				System.out.println("focus get");
				txtMemberLogin.setForeground(Color.black);
				txtMemberLogin.setBackground(Color.yellow);
				if( txtMemberLogin.getText()
						.equals("ID를 입력하세요") )
					txtMemberLogin.setText(""); // 안내 문구일 때만 지움.
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				System.out.println("focus lost");
				txtMemberLogin.setForeground(Color.LIGHT_GRAY);
				txtMemberLogin.setBackground(Color.WHITE);
				if( txtMemberLogin.getText()
						.isEmpty() ) 
					txtMemberLogin.setText("ID를 입력하세요");
				checkJoinAvailable();
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("\uD328\uC2A4\uC6CC\uB4DC:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_2);
		
		pwFirst = new JPasswordField();
		pwFirst.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				pwFirst.setBackground(Color.yellow);
			}
			@Override
			public void focusLost(FocusEvent e) {
				pwFirst.setBackground(Color.white);
			}
		});
		pwFirst.setFont(new Font("굴림", Font.BOLD, 14));
		panel.add(pwFirst);
		
		JLabel lblNewLabel_3 = new JLabel(" ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_3);
		
		pwSecond = new JPasswordField();
		pwSecond.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				pwSecond.setBackground(Color.yellow);
				String strPw1 = new String(
					pwFirst.getPassword());// 문자배열 => 문자열
				if( strPw1.isEmpty() ) {
					lbJoinResult.setText("첫번째 패스워드 입력 필요!!");
					lbJoinResult.setForeground(Color.RED);
					pwFirst.requestFocusInWindow();
						// 첫번째 pw필드로 포커스를 강제 이동 요청..  
						// 자동으로 두번쨰 pw필드의 focusLost()가 일어남..
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				pwSecond.setBackground(Color.white);
				String strPw1 = new String(
						pwFirst.getPassword());
				String strPw2 = new String(
						pwSecond.getPassword());
				if( strPw1.length() > 0 && strPw2.isEmpty() ) {
					lbJoinResult.setText("두번째 패스워드 입력 필요!!");
					lbJoinResult.setForeground(Color.PINK);
//					pwSecond.requestFocusInWindow();
						// 두번째 pw필드로 포커스를 강제 이동 요청..
				// } else if(글자수 최소, 최대...) {	
				} else {
					if( strPw1.length() > 0 &&
							strPw2.length() > 0 ) {
						// 두개 암호 필드값의 내용 비교 일치/불일치
						if( strPw2.equals(strPw1) ) {
							System.out.println("암호 일치");
							lbJoinResult.setText("암호 일치 ^^");
							lbJoinResult.setForeground(Color.blue);
							
							// 가입버튼 활성화 판단 함수
							checkJoinAvailable();
						} else {
							System.out.println("암호 불일치");
							lbJoinResult.setText("암호 불일치 !!");
							lbJoinResult.setForeground(Color.red);
							pwFirst.requestFocusInWindow();
						}
					}
				}
			}
		});
		pwSecond.setFont(new Font("굴림", Font.BOLD, 14));
		panel.add(pwSecond);
		
		JLabel lblNewLabel_4 = new JLabel("\uD68C\uC6D0 \uB098\uC774:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_4);
		
		//JSpinner spinMemberAge = new JSpinner();
		spinMemberAge = new JSpinner();
		spinMemberAge.setModel(new SpinnerNumberModel(18, 18, 60, 1));
		spinMemberAge.setFont(new Font("굴림", Font.BOLD, 18));
		panel.add(spinMemberAge);
		
		JLabel lblNewLabel_5 = new JLabel("\uD68C\uC6D0 \uC131\uBCC4: ");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_5);
		
		JPanel pnGender = new JPanel();
		pnGender.setBackground(Color.WHITE);
		panel.add(pnGender);
		pnGender.setLayout(new GridLayout(0, 2, 0, 0));
		
//		JRadioButton rdFemale = new JRadioButton("\uC5EC\uC131");
		rdFemale = new JRadioButton("\uC5EC\uC131");
		genderGrp.add(rdFemale);
		rdFemale.setSelected(true);
		rdFemale.setFont(new Font("휴먼아미체", Font.PLAIN, 18));
		rdFemale.setHorizontalAlignment(SwingConstants.CENTER);
		pnGender.add(rdFemale);
		
//		JRadioButton rdMale = new JRadioButton("\uB0A8\uC131");
		rdMale = new JRadioButton("\uB0A8\uC131");
		genderGrp.add(rdMale);
		rdMale.setFont(new Font("휴먼아미체", Font.PLAIN, 18));
		rdMale.setHorizontalAlignment(SwingConstants.CENTER);
		pnGender.add(rdMale);
		
		JButton btnDupCheck = new JButton("");
		btnDupCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String inLogin = txtMemberLogin.getText();
				Member mb = mgr.selectOneMemberByLogin(inLogin);
				if( mb == null ) { // 사용가능
					bLoginAvail = true;// 일단 더미 중복x
					lbJoinResult.setText("사용가능한 아이디 ^^");
					lbJoinResult.setForeground(Color.blue);
					lbNoDup.setVisible(true); // available
					checkJoinAvailable();
				} else {
					bLoginAvail = false;
					lbJoinResult.setText("이미 선점된 아이디 ^^;");
					lbJoinResult.setForeground(Color.red);
					lbNoDup.setVisible(false);
				}
			}
		});
		btnDupCheck.setToolTipText("\uACC4\uC815\uBA85 \uC911\uBCF5\uCCB4\uD06C");
		btnDupCheck.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\tick.png"));
		btnDupCheck.setBounds(386, 144, 32, 23);
		contentPane.add(btnDupCheck);
		
		//JLabel lbNoDup = new JLabel("available");
		lbNoDup = new JLabel("available");
		lbNoDup.setForeground(Color.ORANGE);
		lbNoDup.setFont(new Font("굴림", Font.BOLD, 14));
		lbNoDup.setBounds(33, 152, 76, 15);
		contentPane.add(lbNoDup);
		lbNoDup.setVisible(false);
	}

	private boolean bLoginAvail; // false(중복)
	
	protected void checkJoinAvailable() {
		// 가입 가능한 상태의 입력들이 준비되었는지 체크...
		// 길이, 중복유무, 범위, 구성.. 체크  => 검증 validation (필터링)
		
		String strPw1 = new String(
				pwFirst.getPassword());
		String strPw2 = new String(
				pwSecond.getPassword());
		if( (strPw1.length() > 0 &&
				strPw2.length() > 0) && bLoginAvail == true
				&& 
				(!txtMemberLogin.getText().isEmpty() 
				 &&	txtMemberLogin.getText()
				 	.equals("ID를 입력하세요") == false	) 
				&&
				(txtMemberName.getText().isEmpty() == false 
				 && txtMemberName.getText()
				 	.equals("실명을 입력하세요") == false)	
				) {
			// 두개 암호 필드값의 내용 비교 일치/불일치
			if( strPw2.equals(strPw1) ) {
				
				btnMemberJoin.setEnabled(true);		
//				lbJoinResult.setText("암호 일치 ^^");
//				lbJoinResult.setForeground(Color.blue);
			} else {
				btnMemberJoin.setEnabled(false);				
			}
		}
		
		
	}
}
