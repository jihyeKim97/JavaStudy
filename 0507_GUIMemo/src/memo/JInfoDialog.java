package memo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JInfoDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JInfoDialog dlg;
//	JMemoFrame11 frm;
	JMemoFrame12 frm;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			JInfoDialog dialog = new JInfoDialog();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	
	public JInfoDialog() {
		this(null);		
	}
	
//	public JInfoDialog(JMemoFrame11 owner) {
	public JInfoDialog(JMemoFrame12 owner) {
		super(owner, true); // modal
		this.frm = owner;
		this.dlg = this;
		
		int fontCount = frm.fonts.length; // �θ�â�� ��Ʈ ��
		setTitle("About My\uBA54\uBAA8\uC7A5.." 
				+ " ���� ��Ʈ ����: " + fontCount);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\dev2021\\java_ws\\GUIMemoProject\\icons\\information.png"));		
		setBounds(100, 100, 317, 202);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JTextArea txtrMyVersion = new JTextArea();
			txtrMyVersion.setBackground(UIManager.getColor("Label.background"));
			txtrMyVersion.setText("My \uBA54\uBAA8\uC7A5 version 1.0\r\n\r\n \uB77C\uC774\uC13C\uC2A4...\r\n \uAC1C\uBC1C\uC790....\r\n \uC774\uB825...\r\n \uC11C\uD3EC\uD2B8\uB4E4.....................");
			txtrMyVersion.setEditable(false);
			contentPanel.add(txtrMyVersion, BorderLayout.CENTER);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("Info ��ȭ���� ����..");
//						this.
						dlg.setVisible(false); 
							// ��ȭ���ڸ� �޸𸮿� ���ܵΰ� �Ⱥ��̰Ը� ��.
						dlg.dispose();
							// �� â�� ��� ���� �ڿ����� ��� �ǵ����� ����.. (release)
							// => �ڽ� ������Ʈ���� ��� ������..
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
