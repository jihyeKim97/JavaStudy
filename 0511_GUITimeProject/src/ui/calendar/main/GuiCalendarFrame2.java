package ui.calendar.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;

public class GuiCalendarFrame2 extends JFrame {
	public static final Font ftDAY = 
				new Font("Gulim", Font.PLAIN, 20);
	public static final Font ftSDAY = 
				new Font("Gulim", Font.BOLD, 20);
	private JPanel contentPane;
	private JTextField txtYear;
	private JTextField txtMonth;
	JLabel lbStatus;
	JLabel[] lbDayOfWeek; // 요일 레이블 배열	 7
	JButton[] btnDays;  // 날자 버튼 배열 42 (6주 분량)
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiCalendarFrame2 frame = new GuiCalendarFrame2();
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
	public GuiCalendarFrame2() {
		setTitle("GUI \uCE98\uB9B0\uB354");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\dev2021\\java_ws\\GUIMemoProject\\icons\\calendar.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnTop = new JPanel();
		contentPane.add(pnTop, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("\uB144:");
		pnTop.add(lblNewLabel);
		
		txtYear = new JTextField();
		pnTop.add(txtYear);
		txtYear.setColumns(4);
		
		JLabel lblNewLabel_1 = new JLabel("\uC6D4:");
		pnTop.add(lblNewLabel_1);
		
		txtMonth = new JTextField();
		pnTop.add(txtMonth);
		txtMonth.setColumns(2);
		
		JLabel lblNewLabel_2 = new JLabel("          ");
		pnTop.add(lblNewLabel_2);
		
		JToolBar toolBar = new JToolBar();
		pnTop.add(toolBar);
		
		JButton bthShow = new JButton("");
		bthShow.setToolTipText("\uB2EC\uB825 \uBCF4\uAE30");
		bthShow.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\GUIMemoProject\\icons\\eye.png"));
		toolBar.add(bthShow);
		
		JButton btnToday = new JButton("");
		btnToday.setToolTipText("\uC624\uB298 \uB0A0\uC790\uD45C\uC2DC");
		toolBar.add(btnToday);
		btnToday.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\GUIMemoProject\\icons\\calendar_view_day.png"));
		
		JButton btnPrevMonth = new JButton("");
		btnPrevMonth.setToolTipText("\uC774\uC804 \uB2EC \uD45C\uC2DC");
		toolBar.add(btnPrevMonth);
		btnPrevMonth.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\GUIMemoProject\\icons\\arrow_left.png"));
		
		JButton btnNextMonth = new JButton("");
		btnNextMonth.setToolTipText("\uB2E4\uC74C \uB2EC \uD45C\uC2DC");
		toolBar.add(btnNextMonth);
		btnNextMonth.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\GUIMemoProject\\icons\\arrow_right.png"));
		
		JPanel pnCenter = new JPanel();
		contentPane.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(new GridLayout(7, 7, 0, 0));
			// 49칸의 달력 영역
			// 1행 7칸열을 요일헤더 레이블로 채움..
		
		
		JLabel lbSunday = new JLabel("SUN");
		lbSunday.setFont(new Font("Broadway", Font.BOLD, 20));
		lbSunday.setHorizontalAlignment(SwingConstants.CENTER);
		lbSunday.setForeground(Color.RED);
		pnCenter.add(lbSunday);
		
		JLabel lbMonday = new JLabel("MON");
		lbMonday.setFont(new Font("Broadway", Font.BOLD, 20));
		lbMonday.setHorizontalAlignment(SwingConstants.CENTER);
		pnCenter.add(lbMonday);
		
		JLabel lbTuesday = new JLabel("TUE");
		lbTuesday.setFont(new Font("Broadway", Font.BOLD, 20));
		lbTuesday.setHorizontalAlignment(SwingConstants.CENTER);
		pnCenter.add(lbTuesday);
		
		JLabel lbWednesday = new JLabel("WED");
		lbWednesday.setFont(new Font("Broadway", Font.BOLD, 20));
		lbWednesday.setHorizontalAlignment(SwingConstants.CENTER);
		pnCenter.add(lbWednesday);
		
		JLabel lbThursday = new JLabel("THU");
		lbThursday.setFont(new Font("Broadway", Font.BOLD, 20));
		lbThursday.setHorizontalAlignment(SwingConstants.CENTER);
		pnCenter.add(lbThursday);
		
		JLabel lbFriday = new JLabel("FRI");
		lbFriday.setFont(new Font("Broadway", Font.BOLD, 20));
		lbFriday.setHorizontalAlignment(SwingConstants.CENTER);
		pnCenter.add(lbFriday);
		
		JLabel lbSaturday = new JLabel("SAT");
		lbSaturday.setFont(new Font("Broadway", Font.BOLD, 20));
		lbSaturday.setHorizontalAlignment(SwingConstants.CENTER);
		lbSaturday.setForeground(Color.BLUE);
		pnCenter.add(lbSaturday);
		
		// 요일 레이블 배열	 7
		this.lbDayOfWeek = new JLabel[] {
			lbSunday, lbMonday, lbTuesday, lbWednesday,
			lbThursday, lbFriday, lbSaturday
		};		
		
		// 날자 버튼 배열 42 (6주 분량)
		final int BTN_LIMIT = 42;
		this.btnDays = new JButton[BTN_LIMIT];
		for (int i = 0; i < btnDays.length; i++) {//0~41
			JButton btnDay = new JButton("0"); // 날자배치없는상태버튼
//			JButton btnDay = new JButton(""); // 날자배치없는상태버튼
			btnDay.setHorizontalAlignment(JButton.CENTER);			
			if( i % 7 == 0 ) {
				btnDay.setForeground(Color.RED); // sunday
				btnDay.setFont(ftSDAY);
			} else if (i % 7 == 6) {
				btnDay.setForeground(Color.BLUE); // saturday
				btnDay.setFont(ftSDAY);
			} else {
				btnDay.setForeground(Color.BLACK);
				btnDay.setFont(ftDAY);
			}
			btnDays[i] = btnDay;
			pnCenter.add(btnDay);// gridlayout 7 ~ 48번 칸
		}
		
		JPanel pnBottom = new JPanel();
		contentPane.add(pnBottom, BorderLayout.SOUTH);
		
		//JLabel lbStatus = new JLabel("\uC0C1\uD0DC\uBC14:");
		lbStatus = new JLabel("\uC0C1\uD0DC\uBC14:");
		pnBottom.add(lbStatus);
	}

}
