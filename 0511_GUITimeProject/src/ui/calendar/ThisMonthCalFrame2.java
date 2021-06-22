package ui.calendar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ThisMonthCalFrame2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtYear;
	JComboBox comboMonth;
	JTextArea textArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThisMonthCalFrame2 frame = new ThisMonthCalFrame2();
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
	public ThisMonthCalFrame2() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\dev2021\\java_ws\\GUIMemoProject\\icons\\calendar.png"));
		setTitle("This Month \uB2EC\uB825:");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnTop = new JPanel();
		pnTop.setBackground(Color.ORANGE);
		contentPane.add(pnTop, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("\uB144\uB3C4:");
		lblNewLabel_1.setFont(new Font("ÈÞ¸Õ¿¾Ã¼", Font.BOLD, 16));
		pnTop.add(lblNewLabel_1);
		
		txtYear = new JTextField();
		txtYear.setFont(new Font("ÈÞ¸Õ¿¾Ã¼", Font.BOLD, 16));
		pnTop.add(txtYear);
		txtYear.setColumns(4);
		
		JLabel lblNewLabel_2 = new JLabel("\uC6D4:");
		lblNewLabel_2.setFont(new Font("ÈÞ¸Õ¿¾Ã¼", Font.BOLD, 16));
		pnTop.add(lblNewLabel_2);
		
//		JComboBox comboMonth = new JComboBox();
		comboMonth = new JComboBox(); // ÇÊµåÈ­
		comboMonth.setModel(new DefaultComboBoxModel(
				new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboMonth.setMaximumRowCount(12);
		pnTop.add(comboMonth);
		
		JButton btnShowCal = new JButton("\uB2EC\uB825\uD45C\uC2DC");
		btnShowCal.setFont(new Font("ÈÞ¸Õ¿¾Ã¼", Font.BOLD, 16));
		pnTop.add(btnShowCal);
		
		JPanel pnCenter = new JPanel();
		pnCenter.setBackground(Color.MAGENTA);
		contentPane.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnCenter.add(scrollPane, BorderLayout.CENTER);
		
		//JTextArea textArea = new JTextArea();
		textArea = new JTextArea(); // ÇÊµåÈ­
		scrollPane.setViewportView(textArea);
		
		JPanel pnBottom = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnBottom.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		pnBottom.setBackground(Color.YELLOW);
		contentPane.add(pnBottom, BorderLayout.SOUTH);
		
		JLabel lbStatus = new JLabel("\uC0C1\uD0DC\uBC14");
		lbStatus.setFont(new Font("ÈÞ¸Õ¿¾Ã¼", Font.BOLD, 16));
		lbStatus.setHorizontalAlignment(SwingConstants.LEFT);
		pnBottom.add(lbStatus);
		
		// ¿À´Ã³¯ÀÚ (³â¿ù)  1) ´Þ·Â ¹æ½Ä
		Calendar cal = Calendar.getInstance();
		Date today =  cal.getTime();
		DateFormat df = DateFormat.getDateInstance();
		setTitle(getTitle() + " " + df.format(today) );
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		// 2) ¹®ÀÚ¿­ ÆÄ½Ì ¹æ½Ä
//		Date today = new Date();
//		System.out.println(today);
//		DateFormat df = DateFormat.getDateInstance();
//		//System.out.println(df.format(today)); // 
//		String todayStr =   //"2021. 5. 12"
//				df.format(today);
//		String temp[] = todayStr.split(". ");
//			// { "2021", "5", "12" }
////		for (String s : temp) {
////			System.out.println(s);
////		}
//		int year = Integer.parseInt(temp[0]);// "2021" => 2021
//		int month = Integer.parseInt(temp[1]);
		
		// 
		txtYear.setText( String.valueOf(year) );  //""+year)
		comboMonth.setSelectedIndex(month-1); // 4¹øÂ° "5"¿ù´Þ
	}

}
