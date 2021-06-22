package memo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;

public class JMemoFrame extends JFrame {

	private JPanel contentPane;
	JTextArea textArea; // �ʵ�ȭ

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JMemoFrame frame = new JMemoFrame();
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
	public JMemoFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\dev2021\\java_ws\\GUIMemoProject\\icons\\script_edit.png"));
		setTitle("My \uBA54\uBAA8\uC7A5");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lbTitle = new JLabel("My �޸���::");
		lbTitle.setFont(new Font("���� ���", Font.BOLD, 16));
		contentPane.add(lbTitle, BorderLayout.NORTH);
		
		JLabel lbStatus = new JLabel("���¹�::");
		lbStatus.setFont(new Font("�޸ո���ü", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lbStatus, BorderLayout.SOUTH);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		//JTextArea textArea = new JTextArea(); // ����
		textArea = new JTextArea(); // �ʵ�ȭ
		textArea.setFont(new Font("����", Font.PLAIN, 18));
		scrollPane.setViewportView(textArea); 
			// ��ũ�������� ����Ʈ ������ �ؽ�Ʈ���� ��ġ
	}

}
