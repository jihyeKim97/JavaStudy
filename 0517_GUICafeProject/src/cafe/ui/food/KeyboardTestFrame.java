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
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 18));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JTextArea textArea = new JTextArea();
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
//				System.out.println("Ű ����...");
			}			
			
			@Override			
			public void keyReleased(KeyEvent e) {
				int code = e.getKeyCode();
				System.out.println("Ű ����... Ű�ڵ尪: " + code); 
				// ī�� ���̾ƿ� Ž��...
				switch (code) {
				case KeyEvent.VK_LEFT:
					 System.out.println("���� Ŀ������ Ű");
					break;
				case KeyEvent.VK_RIGHT:
					 System.out.println("������ Ŀ������ Ű");
					break;
				case KeyEvent.VK_UP:
					 System.out.println("���� Ŀ������ Ű");
					break;
				case KeyEvent.VK_DOWN:
					 System.out.println("�Ʒ��� Ŀ������ Ű");
					break;	
				case KeyEvent.VK_SPACE:
					 System.out.println("�����̽� Ű");
					break;						
				default:
					break;
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
//				char c = e.getKeyChar();
//				System.out.println("Ű Ÿ����... " + c);				
			}
			
			
		});
		textArea.setFont(new Font("���ʷҹ���", Font.PLAIN, 18));
		contentPane.add(textArea, BorderLayout.CENTER);
	}

}


/*
Ű ����... Ű�ڵ尪: 65
Ű ����... Ű�ڵ尪: 66
Ű ����... Ű�ڵ尪: 67
Ű ����... Ű�ڵ尪: 68
Ű ����... Ű�ڵ尪: 69
Ű ����... Ű�ڵ尪: 68
Ű ����... Ű�ڵ尪: 70
Ű ����... Ű�ڵ尪: 65
Ű ����... Ű�ڵ尪: 10
Ű ����... Ű�ڵ尪: 65
Ű ����... Ű�ڵ尪: 16
Ű ����... Ű�ڵ尪: 10
Ű ����... Ű�ڵ尪: 65
Ű ����... Ű�ڵ尪: 39
Ű ����... Ű�ڵ尪: 37
Ű ����... Ű�ڵ尪: 39
Ű ����... Ű�ڵ尪: 38
Ű ����... Ű�ڵ尪: 40
Ű ����... Ű�ڵ尪: 10
Ű ����... Ű�ڵ尪: 37
Ű ����... Ű�ڵ尪: 39
Ű ����... Ű�ڵ尪: 32
Ű ����... Ű�ڵ尪: 38
Ű ����... Ű�ڵ尪: 40
Ű ����... Ű�ڵ尪: 27
Ű ����... Ű�ڵ尪: 16
Ű ����... Ű�ڵ尪: 16
Ű ����... Ű�ڵ尪: 17
Ű ����... Ű�ڵ尪: 18
Ű ����... Ű�ڵ尪: 9
Ű ����... Ű�ڵ尪: 20
Ű ����... Ű�ڵ尪: 20
Ű ����... Ű�ڵ尪: 8
Ű ����... Ű�ڵ尪: 524
Ű ����... Ű�ڵ尪: 27

Ű ����... Ű�ڵ尪: 37
���� Ŀ������ Ű
Ű ����... Ű�ڵ尪: 38
���� Ŀ������ Ű
Ű ����... Ű�ڵ尪: 39
������ Ŀ������ Ű
Ű ����... Ű�ڵ尪: 40
�Ʒ��� Ŀ������ Ű
Ű ����... Ű�ڵ尪: 32
�����̽� Ű
Ű ����... Ű�ڵ尪: 10
Ű ����... Ű�ڵ尪: 10
Ű ����... Ű�ڵ尪: 83
Ű ����... Ű�ڵ尪: 70
Ű ����... Ű�ڵ尪: 68
Ű ����... Ű�ڵ尪: 10
Ű ����... Ű�ڵ尪: 68
Ű ����... Ű�ڵ尪: 83
Ű ����... Ű�ڵ尪: 70
Ű ����... Ű�ڵ尪: 10
Ű ����... Ű�ڵ尪: 68
Ű ����... Ű�ڵ尪: 70
Ű ����... Ű�ڵ尪: 83
Ű ����... Ű�ڵ尪: 10
Ű ����... Ű�ڵ尪: 68
Ű ����... Ű�ڵ尪: 70
Ű ����... Ű�ڵ尪: 83
Ű ����... Ű�ڵ尪: 10
Ű ����... Ű�ڵ尪: 37
���� Ŀ������ Ű
Ű ����... Ű�ڵ尪: 38
���� Ŀ������ Ű
Ű ����... Ű�ڵ尪: 39
������ Ŀ������ Ű
Ű ����... Ű�ڵ尪: 40
�Ʒ��� Ŀ������ Ű
Ű ����... Ű�ڵ尪: 32
�����̽� Ű

*/