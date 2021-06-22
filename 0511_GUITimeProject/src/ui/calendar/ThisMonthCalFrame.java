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
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ThisMonthCalFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtYear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThisMonthCalFrame frame = new ThisMonthCalFrame();
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
	public ThisMonthCalFrame() {
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
		
		JComboBox comboMonth = new JComboBox();
		comboMonth.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
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
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JPanel pnBottom = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnBottom.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		pnBottom.setBackground(Color.YELLOW);
		contentPane.add(pnBottom, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("\uC0C1\uD0DC\uBC14");
		lblNewLabel.setFont(new Font("ÈÞ¸Õ¿¾Ã¼", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		pnBottom.add(lblNewLabel);
	}

}
