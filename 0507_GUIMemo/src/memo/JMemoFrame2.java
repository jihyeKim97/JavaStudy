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

public class JMemoFrame2 extends JFrame {

	private JPanel contentPane;
	JTextArea textArea; // 필드화

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JMemoFrame2 frame = new JMemoFrame2();
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
	public JMemoFrame2() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\dev2021\\java_ws\\GUIMemoProject\\icons\\script_edit.png"));
		setTitle("My \uBA54\uBAA8\uC7A5");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lbTitle = new JLabel("My 메모장::");
		lbTitle.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		contentPane.add(lbTitle, BorderLayout.NORTH);
		
		JLabel lbStatus = new JLabel("상태바::");
		lbStatus.setFont(new Font("휴먼매직체", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lbStatus, BorderLayout.SOUTH);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		//JTextArea textArea = new JTextArea(); // 지역
		textArea = new JTextArea(); // 필드화
		textArea.setFont(new Font("바탕", Font.PLAIN, 18));
		scrollPane.setViewportView(textArea);// 스크롤페인의 뷰포트 영역에 텍스트에어리어를 배치 
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(6, 1, 0, 0)); // 6행 1열
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\0507_GUIMemo\\icons\\application_add.png"));
		btnNewButton.setToolTipText("\uC804\uACBD\uC0C9 \uBCC0\uACBD");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\0507_GUIMemo\\icons\\add.png"));
		btnNewButton_1.setToolTipText("\uBC30\uACBD\uC0C9 \uBCC0\uACBD");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\0507_GUIMemo\\icons\\application_home.png"));
		btnNewButton_2.setToolTipText("\uBA54\uBAA8 \uC77D\uC5B4\uC624\uAE30");
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\0507_GUIMemo\\icons\\application_key.png"));
		btnNewButton_3.setToolTipText("\uBA54\uBAA8 \uC800\uC7A5\uD558\uAE30");
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("");
		panel.add(lblNewLabel);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\0507_GUIMemo\\icons\\application_view_icons.png"));
		btnNewButton_4.setToolTipText("My\uBA54\uBAA8\uC7A5 \uB300\uD558\uC5EC...");
		panel.add(btnNewButton_4);
			// 왼쪽영역 세로툴바를 jpanel로 구현중... 그리드 
		
		
	}

}
