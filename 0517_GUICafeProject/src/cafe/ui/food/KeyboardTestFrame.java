package cafe.ui.food;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardTestFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KeyboardTestFrame frame = new KeyboardTestFrame();
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
	public KeyboardTestFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\uD0A4\uBCF4\uB4DC \uC774\uBCA4\uD2B8 \uD14C\uC2A4\uD2B8");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 18));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JTextArea textArea = new JTextArea();
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
//				System.out.println("키 눌림...");
			}			
			
			@Override			
			public void keyReleased(KeyEvent e) {
				int code = e.getKeyCode();
				System.out.println("키 놓임... 키코드값: " + code); 
				// 카드 레이아웃 탐색...
				switch (code) {
				case KeyEvent.VK_LEFT:
					 System.out.println("왼쪽 커서방향 키");
					break;
				case KeyEvent.VK_RIGHT:
					 System.out.println("오른쪽 커서방향 키");
					break;
				case KeyEvent.VK_UP:
					 System.out.println("위쪽 커서방향 키");
					break;
				case KeyEvent.VK_DOWN:
					 System.out.println("아래쪽 커서방향 키");
					break;	
				case KeyEvent.VK_SPACE:
					 System.out.println("스페이스 키");
					break;						
				default:
					break;
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
//				char c = e.getKeyChar();
//				System.out.println("키 타이핑... " + c);				
			}
			
			
		});
		textArea.setFont(new Font("함초롬바탕", Font.PLAIN, 18));
		contentPane.add(textArea, BorderLayout.CENTER);
	}

}


/*
키 놓임... 키코드값: 65
키 놓임... 키코드값: 66
키 놓임... 키코드값: 67
키 놓임... 키코드값: 68
키 놓임... 키코드값: 69
키 놓임... 키코드값: 68
키 놓임... 키코드값: 70
키 놓임... 키코드값: 65
키 놓임... 키코드값: 10
키 놓임... 키코드값: 65
키 놓임... 키코드값: 16
키 놓임... 키코드값: 10
키 놓임... 키코드값: 65
키 놓임... 키코드값: 39
키 놓임... 키코드값: 37
키 놓임... 키코드값: 39
키 놓임... 키코드값: 38
키 놓임... 키코드값: 40
키 놓임... 키코드값: 10
키 놓임... 키코드값: 37
키 놓임... 키코드값: 39
키 놓임... 키코드값: 32
키 놓임... 키코드값: 38
키 놓임... 키코드값: 40
키 놓임... 키코드값: 27
키 놓임... 키코드값: 16
키 놓임... 키코드값: 16
키 놓임... 키코드값: 17
키 놓임... 키코드값: 18
키 놓임... 키코드값: 9
키 놓임... 키코드값: 20
키 놓임... 키코드값: 20
키 놓임... 키코드값: 8
키 놓임... 키코드값: 524
키 놓임... 키코드값: 27

키 놓임... 키코드값: 37
왼쪽 커서방향 키
키 놓임... 키코드값: 38
위쪽 커서방향 키
키 놓임... 키코드값: 39
오른쪽 커서방향 키
키 놓임... 키코드값: 40
아래쪽 커서방향 키
키 놓임... 키코드값: 32
스페이스 키
키 놓임... 키코드값: 10
키 놓임... 키코드값: 10
키 놓임... 키코드값: 83
키 놓임... 키코드값: 70
키 놓임... 키코드값: 68
키 놓임... 키코드값: 10
키 놓임... 키코드값: 68
키 놓임... 키코드값: 83
키 놓임... 키코드값: 70
키 놓임... 키코드값: 10
키 놓임... 키코드값: 68
키 놓임... 키코드값: 70
키 놓임... 키코드값: 83
키 놓임... 키코드값: 10
키 놓임... 키코드값: 68
키 놓임... 키코드값: 70
키 놓임... 키코드값: 83
키 놓임... 키코드값: 10
키 놓임... 키코드값: 37
왼쪽 커서방향 키
키 놓임... 키코드값: 38
위쪽 커서방향 키
키 놓임... 키코드값: 39
오른쪽 커서방향 키
키 놓임... 키코드값: 40
아래쪽 커서방향 키
키 놓임... 키코드값: 32
스페이스 키

*/