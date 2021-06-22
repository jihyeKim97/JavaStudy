package LP.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import LP.ui.components.ImagePanel;
import LP.ui.LPMainFrame;
import db.data.Member;
import db.mgr.MemberDBMgr;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class LPMemberJoinFrame extends JFrame {

	JPanel contentPane;
	
	private JPanel contentPane_1_1;
	
	LPMainFrame frm;
	private JTextField txtMemberName;
	private JTextField txtMemberLogin;
	private JPasswordField pwFirst;
	private JPasswordField pwSecond;
	private JTextField MemberAge;
	private JTextField EmailText;
	private JTextField PhoneText;
	
	MemberDBMgr mgr;
	JLabel lbJoinResult;
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public LPMemberJoinFrame(LPMainFrame frm) {
		this.mgr = new MemberDBMgr();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frm = frm;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 460, 500);
		contentPane_1_1 = new JPanel();
		contentPane_1_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		ImageIcon icBack = 
				new ImageIcon("C:\\dev2021\\java_ws\\LP\\src\\images\\bg.jpg");
		Image bgImg = icBack.getImage();
		contentPane_1_1 = new ImagePanel(
				bgImg, "bg.jpg", 600, 600);
		setContentPane(contentPane_1_1);
		contentPane_1_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 22));
		lblNewLabel.setBounds(167, 30, 92, 26);
		contentPane_1_1.add(lblNewLabel);
		
		pwFirst = new JPasswordField();
		pwFirst.setToolTipText("");
		pwFirst.setBounds(97, 154, 228, 36);
		contentPane_1_1.add(pwFirst);
		pwFirst.setFont(new Font("����", Font.BOLD, 14));
		
		pwSecond = new JPasswordField();
		
		JLabel lbJoinResult = new JLabel("");
		lbJoinResult.setFont(new Font("Dialog", Font.BOLD, 15));
		lbJoinResult.setBounds(97, 328, 228, 36);
		contentPane_1_1.add(lbJoinResult);
		
		pwSecond.setBounds(97, 188, 228, 36);
		contentPane_1_1.add(pwSecond);
		pwSecond.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				String strPw1 = new String(
					pwFirst.getPassword());// ���ڹ迭 => ���ڿ�
				if( strPw1.isEmpty() ) {
					lbJoinResult.setText("ù��° �н����� �Է��ϼ���.");
					lbJoinResult.setForeground(Color.RED);
					pwFirst.requestFocusInWindow();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				String strPw1 = new String(
						pwFirst.getPassword());
				String strPw2 = new String(
						pwSecond.getPassword());
				if( strPw1.length() > 0 && strPw2.isEmpty() ) {
					lbJoinResult.setText("�ι�° �н����� �Է��ϼ���.");
					lbJoinResult.setForeground(Color.RED);
				} else {
					if( strPw1.length() > 0 &&
							strPw2.length() > 0 ) {
						// �ΰ� ��ȣ �ʵ尪�� ���� �� ��ġ/����ġ
						if( strPw2.equals(strPw1) ) {
							System.out.println("��ȣ ��ġ");
							lbJoinResult.setText("��ȣ ��ġ ");
							lbJoinResult.setForeground(Color.blue);
							
							// ���Թ�ư Ȱ��ȭ �Ǵ� �Լ�
							checkJoinAvailable();
						} else {
							System.out.println("��ȣ ����ġ");
							lbJoinResult.setText("��ȣ ����ġ ");
							lbJoinResult.setForeground(Color.red);
							pwFirst.requestFocusInWindow();
						}
					}
				}
				
				
			}
		});
		
	
		
		btnMemberJoin = new JButton("");
		btnMemberJoin.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\LP\\src\\images\\images.button\\join1.jpg"));
		btnMemberJoin.setBounds(130, 364, 153, 41);
		contentPane_1_1.add(btnMemberJoin);
		
		btnMemberJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ȸ�� ���� DB ó��..
				//mgr.insertNewMember(name, login, pw, age, gender)
				String name = txtMemberName.getText(); 
				String login = txtMemberLogin.getText();
				String pw = new String( pwFirst.getPassword() ); 
				int age = Integer.parseInt(MemberAge.getText());
				String email = EmailText.getText();
				int phone = Integer.parseInt(PhoneText.getText());
			
				Member newMB = new Member(name, login, pw, age, email,phone);
				boolean r = mgr.insertNewMember(newMB);
				if( r ) {
					lbJoinResult.setText("ȸ�� ���� ����!!");
				} else {
					lbJoinResult.setText("ȸ�� ���� ����!!");
				}
			}
		});
		
		txtMemberName = new JTextField();
		txtMemberName.setFont(new Font("����", Font.BOLD, 15));
		txtMemberName.setForeground(Color.LIGHT_GRAY);
		txtMemberName.setToolTipText("");
		txtMemberName.setBounds(97, 84, 228, 36);
		txtMemberName.setColumns(10);
		contentPane_1_1.add(txtMemberName);
		
		txtMemberName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				System.out.println("focus get");
				txtMemberName.setForeground(Color.black);
				if( txtMemberName.getText()
						.equals("�Ǹ��� �Է��ϼ���") )
					txtMemberName.setText("");
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				System.out.println("focus lost");
				txtMemberName.setForeground(Color.LIGHT_GRAY);
				if( txtMemberName.getText()
						.isEmpty() ) 
					txtMemberName.setText("�Ǹ��� �Է��ϼ���");
				checkJoinAvailable();				
			}
		});
		
		txtMemberLogin = new JTextField();
		txtMemberLogin.setForeground(Color.LIGHT_GRAY);
		txtMemberLogin.setFont(new Font("����", Font.BOLD, 15));
		txtMemberLogin.setColumns(10);
		txtMemberLogin.setText("ID�� �Է��ϼ���.");
		txtMemberLogin.setBounds(97, 119, 228, 36);
		contentPane_1_1.add(txtMemberLogin);
		
		txtMemberLogin.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				System.out.println("focus get");
				txtMemberLogin.setForeground(Color.black);
				if( txtMemberLogin.getText()
						.equals("ID�� �Է��ϼ���.") )
					txtMemberLogin.setText(""); // �ȳ� ������ ���� ����.
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				System.out.println("focus lost");
				txtMemberLogin.setForeground(Color.LIGHT_GRAY);
				if( txtMemberLogin.getText()
						.isEmpty() ) 
					txtMemberLogin.setText("ID�� �Է��ϼ���.");
				checkJoinAvailable();				
			}
		});
		
		MemberAge = new JTextField();
		MemberAge.setText("���̸� �Է��ϼ���.");
		MemberAge.setFont(new Font("����", Font.BOLD, 15));
		MemberAge.setForeground(Color.LIGHT_GRAY);
		MemberAge.setToolTipText("");
		MemberAge.setColumns(10);
		MemberAge.setBounds(97, 223, 228, 36);
		contentPane_1_1.add(MemberAge);
		
		MemberAge.addFocusListener(new FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
			System.out.println("focus get");
			MemberAge.setForeground(Color.black);
			if( MemberAge.getText()
					.equals("���̸� �Է��ϼ���.") )
				MemberAge.setText(""); // �ȳ� ������ ���� ����.
		}
		
		@Override
		public void focusLost(FocusEvent e) {
			System.out.println("focus lost");
			MemberAge.setForeground(Color.LIGHT_GRAY);
			if( MemberAge.getText()
					.isEmpty() ) 
				MemberAge.setText("���̸� �Է��ϼ���.");
			checkJoinAvailable();				
		}
	});
		

		EmailText = new JTextField();
		EmailText.setForeground(Color.LIGHT_GRAY);
		EmailText.setText("�̸����� �Է��ϼ���.");
		EmailText.setFont(new Font("����", Font.BOLD, 15));
		EmailText.setColumns(10);
		EmailText.setBounds(97, 258, 228, 36);
		contentPane_1_1.add(EmailText);
		
		EmailText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				System.out.println("focus get");
				EmailText.setForeground(Color.black);
				if( EmailText.getText()
						.equals("�̸����� �Է��ϼ���.") )
					EmailText.setText(""); // �ȳ� ������ ���� ����.
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				System.out.println("focus lost");
				EmailText.setForeground(Color.LIGHT_GRAY);
				if( EmailText.getText()
						.isEmpty() ) 
					EmailText.setText("�̸����� �Է��ϼ���.");
				checkJoinAvailable();				
			}
		});
		
		PhoneText = new JTextField();
		PhoneText.setForeground(Color.LIGHT_GRAY);
		PhoneText.setFont(new Font("����", Font.BOLD, 15));
		PhoneText.setText("��ȭ��ȣ�� �Է��ϼ���.");
		PhoneText.setColumns(10);
		PhoneText.setBounds(97, 293, 228, 36);
		contentPane_1_1.add(PhoneText);
		
		JButton btnDupCheck = new JButton("");
		btnDupCheck.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\LP\\src\\images\\images.button\\1.jpg"));
		btnDupCheck.setToolTipText("������ �ߺ�üũ");
		btnDupCheck.setBounds(337, 124, 60, 23);
		contentPane_1_1.add(btnDupCheck);
		
		btnDupCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String inLogin = txtMemberLogin.getText();
				Member mb = mgr.selectOneMemberByLogin(inLogin);
				if( mb == null ) { // ��밡��
					bLoginAvail = true;// �ϴ� ���� �ߺ�x
					lbJoinResult.setText("��밡���� ���̵��Դϴ�.");
					lbJoinResult.setForeground(Color.blue);
					checkJoinAvailable();
				} else {
					bLoginAvail = false;
					lbJoinResult.setText("�ߺ��� ���̵��Դϴ�.");
					lbJoinResult.setForeground(Color.red);
				}
			}
		});
		
		btnDupCheck2 = new JButton("");
		btnDupCheck2.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\LP\\src\\images\\images.button\\1.jpg"));
		btnDupCheck2.setToolTipText("�̸��� �ߺ�üũ");
		btnDupCheck2.setBounds(337, 265, 60, 23);
		contentPane_1_1.add(btnDupCheck2);
		
		btnDupCheck2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String inLogin = EmailText.getText();
				Member mb = mgr.selectOneMemberByLogin(inLogin);
				if( mb == null ) { // ��밡��
					bLoginAvail = true;// �ϴ� ���� �ߺ�x
					lbJoinResult.setText("��밡���� �̸����Դϴ�.");
					lbJoinResult.setForeground(Color.blue);
					checkJoinAvailable();
				} else {
					bLoginAvail = false;
					lbJoinResult.setText("�ߺ��� �̸����Դϴ�.");
					lbJoinResult.setForeground(Color.red);
				}
			}
		});
		
		btnDupCheck3 = new JButton("");
		btnDupCheck3.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\LP\\src\\images\\images.button\\1.jpg"));
		btnDupCheck3.setToolTipText("��ȭ��ȣ �ߺ�üũ");
		btnDupCheck3.setBounds(337, 300, 60, 23);
		contentPane_1_1.add(btnDupCheck3);
		
		btnDupCheck3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String inLogin = PhoneText.getText();
				Member mb = mgr.selectOneMemberByLogin(inLogin);
				if( mb == null ) { // ��밡��
					bLoginAvail = true;// �ϴ� ���� �ߺ�x
					lbJoinResult.setText("��밡���� ��ȭ��ȣ�Դϴ�.");
					lbJoinResult.setForeground(Color.blue);
					checkJoinAvailable();
				} else {
					bLoginAvail = false;
					lbJoinResult.setText("�ߺ��� ��ȭ��ȣ�Դϴ�.");
					lbJoinResult.setForeground(Color.red);
				}
			}
		});
		
		
		
		
		
		PhoneText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				System.out.println("focus get");
				PhoneText.setForeground(Color.black);
				if( PhoneText.getText()
						.equals("��ȭ��ȣ�� �Է��ϼ���.") )
					PhoneText.setText(""); // �ȳ� ������ ���� ����.
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				System.out.println("focus lost");
				PhoneText.setForeground(Color.LIGHT_GRAY);
				if( PhoneText.getText()
						.isEmpty() ) 
					PhoneText.setText("��ȭ��ȣ�� �Է��ϼ���.");
				checkJoinAvailable();				
			}
		});
		
	}
private boolean bLoginAvail; // false(�ߺ�)
private JButton btnMemberJoin;
private JButton btnDupCheck2;
private JButton btnDupCheck3;



	
	protected void checkJoinAvailable() {
		// ���� ������ ������ �Էµ��� �غ�Ǿ����� üũ...
		// ����, �ߺ�����, ����, ����.. üũ  => ���� validation (���͸�)
		
		String strPw1 = new String(
				pwFirst.getPassword());
		String strPw2 = new String(
				pwSecond.getPassword());
		if( (strPw1.length() > 0 &&
				strPw2.length() > 0) && bLoginAvail == true
				&& 
				(!txtMemberLogin.getText().isEmpty() 
				 &&	txtMemberLogin.getText()
				 	.equals("ID�� �Է��ϼ���") == false	) 
				&&
				(txtMemberName.getText().isEmpty() == false 
				 && txtMemberName.getText()
				 	.equals("�Ǹ��� �Է��ϼ���") == false)
				&&
				(EmailText.getText().isEmpty() == false 
				 && txtMemberName.getText()
				 	.equals("�Ǹ��� �Է��ϼ���") == false)	
				&&
				(PhoneText.getText().isEmpty() == false 
				 && PhoneText.getText()
				 	.equals("�Ǹ��� �Է��ϼ���") == false)	
				) {
			// �ΰ� ��ȣ �ʵ尪�� ���� �� ��ġ/����ġ
			if( strPw2.equals(strPw1) ) {
				btnMemberJoin.setEnabled(true);		
			} else {
				btnMemberJoin.setEnabled(false);				
			}
		}
	}
}
