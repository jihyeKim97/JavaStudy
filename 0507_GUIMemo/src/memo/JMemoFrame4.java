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
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JMemoFrame4 extends JFrame {
	// �÷� ���� 
	public static final Color CR_WHITE = Color.WHITE;
	public static final Color CR_BLACK = Color.black;
	public static final Color CR_GRAY = Color.gray;
	public static final Color CR_RED = Color.red;
	public static final Color CR_GREEN = Color.GREEN;
	public static final Color CR_BLUE = Color.WHITE;
	public static final Color CR_ORANGE = new Color(247, 222, 220); // colorzilla 
	
	// ���� �޸��忡 Ȱ��ȭ�� �÷��� ����ϴ� �ʵ�
	Color activeColor;
	
	private JPanel contentPane;
	JTextArea textArea; // �ʵ�ȭ

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JMemoFrame4 frame = new JMemoFrame4();
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
	public JMemoFrame4() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\dev2021\\java_ws\\GUIMemoProject\\icons\\script_edit.png"));
		setTitle("My \uBA54\uBAA8\uC7A5");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		// �ʱ� �÷� ����
		this.activeColor = CR_BLACK;
		
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
		scrollPane.setViewportView(textArea);// ��ũ�������� ����Ʈ ������ �ؽ�Ʈ���� ��ġ 
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		contentPane.add(panel, BorderLayout.WEST);
		//panel.setLayout(new GridLayout(6, 1, 0, 0)); // 6�� 1��
		panel.setLayout(new GridLayout(0, 1, 0, 0)); // N�� 1��
		// ���ʿ��� �������ٸ� jpanel�� ������... �׸��� 
		
		JButton btnNewButton = new JButton("");
		// addActionListener �̺�Ʈ ó���� ������ ���
		// �͸� ��ü(�������̽� �ϳ����� ������ �̸� ���� ��ü�� ��� �����Ǿ� ���ڷ� �Է� : -> �� ��ư���� ���� �̹�Ʈ �۸� ��ü�� ��ϵ�)
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("����� ���� : "+activeColor);
//				this. �͸� ��ü �ڽ�
				textArea.setForeground(activeColor);
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\0507_GUIMemo\\icons\\style_edit.png"));
		btnNewButton.setToolTipText("\uC804\uACBD\uC0C9 \uBCC0\uACBD");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("���� ����: " + activeColor);
				textArea.setBackground(activeColor);
			}
		});

		btnNewButton_1.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\0507_GUIMemo\\icons\\paintcan.png"));
		btnNewButton_1.setToolTipText("\uBC30\uACBD\uC0C9 \uBCC0\uACBD");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\0507_GUIMemo\\icons\\book_open.png"));
		btnNewButton_2.setToolTipText("\uBA54\uBAA8 \uC77D\uC5B4\uC624\uAE30");
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\0507_GUIMemo\\icons\\script_save.png"));
		btnNewButton_3.setToolTipText("\uBA54\uBAA8 \uC800\uC7A5\uD558\uAE30");
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("");
		panel.add(lblNewLabel);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\0507_GUIMemo\\icons\\heart.png"));
		btnNewButton_4.setToolTipText("My\uBA54\uBAA8\uC7A5 \uB300\uD558\uC5EC...");
		panel.add(btnNewButton_4);
			
		
		
	}

}
