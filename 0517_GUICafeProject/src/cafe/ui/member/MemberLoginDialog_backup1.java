package cafe.ui.member;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cafe.ui.CafeMainFrame;

import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class MemberLoginDialog_backup1 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtLogin;
	private JPasswordField pwLogin;
	CafeMainFrame frm;
	MemberLoginDialog_backup1 dlg;
	/**
	 * Create the dialog.
	 */
	public MemberLoginDialog_backup1(CafeMainFrame frm) {
		super(frm, true); // modal 
		this.frm = frm;
		this.dlg = this;
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			// x버튼으로 이 대화상자만 닫히고 사라지게..
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\cup_key.png"));
		setTitle("My CAFE :: \uD68C\uC6D0 \uB85C\uADF8\uC778");
		setBounds(100, 100, 293, 190);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 255, 204));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(33, 10, 205, 86);
		contentPanel.add(panel);
		panel.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("\uB85C\uADF8\uC778\uBA85:");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		txtLogin = new JTextField();
		txtLogin.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				System.out.println("focus get");
				dlg.txtLogin.setForeground(Color.black);
				dlg.txtLogin.setBackground(Color.yellow);
				if( dlg.txtLogin.getText()
						.equals("계정명 입력") )
					dlg.txtLogin.setText(""); // 안내 문구일 때만 지움.
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				System.out.println("focus lost");
				dlg.txtLogin.setForeground(Color.LIGHT_GRAY);
				dlg.txtLogin.setBackground(Color.WHITE);
				if( dlg.txtLogin.getText()
						.isEmpty() ) 
					dlg.txtLogin.setText("계정명 입력");
			}
		});
		txtLogin.setForeground(Color.LIGHT_GRAY);
		txtLogin.setText("\uACC4\uC815\uBA85 \uC785\uB825");
		txtLogin.setFont(new Font("굴림", Font.PLAIN, 16));
		panel.add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\uD328\uC2A4\uC6CC\uB4DC:");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		pwLogin = new JPasswordField();
		pwLogin.setColumns(10);
		pwLogin.setFont(new Font("굴림", Font.PLAIN, 16));
		panel.add(pwLogin);
		
		JLabel lbLoginResult = new JLabel("");
		lbLoginResult.setFont(new Font("굴림", Font.BOLD, 16));
		lbLoginResult.setBounds(53, 103, 176, 15);
		contentPanel.add(lbLoginResult);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new BorderLayout(0, 0));
			{
				JButton btnLogin = new JButton("\uB85C\uADF8\uC778");
				btnLogin.setActionCommand("OK");
				buttonPane.add(btnLogin, BorderLayout.EAST);
				getRootPane().setDefaultButton(btnLogin);
			}
			{
				JLabel lbMemberJoin = new JLabel("\uD68C\uC6D0\uAC00\uC785");
				buttonPane.add(lbMemberJoin, BorderLayout.WEST);
			}
		}
	}

//	public MemberLoginDialog(CafeMainFrame frm) {
//		// TODO Auto-generated constructor stub
//	}
}
