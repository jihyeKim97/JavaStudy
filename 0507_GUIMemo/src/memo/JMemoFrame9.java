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
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class JMemoFrame9 extends JFrame {
	// �÷� ���� 
	public static final Color CR_WHITE = Color.WHITE;
	public static final Color CR_BLACK = Color.black;
	public static final Color CR_GRAY = Color.gray;
	public static final Color CR_RED = Color.red;
	public static final Color CR_GREEN = Color.GREEN;
	public static final Color CR_BLUE = Color.BLUE;
	public static final Color CR_ORANGE = new Color(247, 222, 220); // colorzilla 
	
	// ���� �޸��忡 Ȱ��ȭ�� �÷��� ����ϴ� �ʵ�
	Color activeColor;
	
	// �÷� ���� ��ư�� ���� ���� �̺�Ʈ �ڵ鷯 ���� Ŭ����
	// (����Ŭ������ �ܺ� Ŭ������ ��� �ڿ��� ������ �ȴ�.)
	private class ColorSelectHandler implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			JRadioButton rdColor = (JRadioButton)e.getItemSelectable();
			if( rdColor.isSelected() ) {
				System.out.println("���� �ȷ�Ʈ ����: " 
						+ rdColor.getText());
				// �÷� �̸� ���ڿ� �� (���) 
//				if(  rdColor.getText().equals("����")) {}
				switch ( rdColor.getText()) {
				case "����": activeColor = CR_BLACK;	break;
				case "���": activeColor = CR_WHITE;	break;
				case "ȸ��": activeColor = CR_GRAY;	break;
				case "����": activeColor = CR_RED;	break;
				case "�Ķ�": activeColor = CR_BLUE;	break;
				case "�ʷ�": activeColor = CR_GREEN;	break;
				case "��Ȳ": activeColor = CR_ORANGE;	break;
				default:
					System.out.println("���� �÷� �̸�!");
					break;
				}
			}
		}
		
	}
	
	
	// ��Ʈ
	public static final String[] FONT_NAMES = {
		"Arial", "Book Antiqua", "Georgia", "Courier New",
		"�������", "����", "����", "�ü�", "�����ٸ���"
	};
	public static final int DEF_SEL_FONT = 5; // Gulim
	public static final int DEF_FONTSIZE = 18; 
	public static final int DEF_FONT_OPT = Font.PLAIN;
	
	public Font[] fonts; // ��Ʈ������ �迭
	JComboBox comboFonts; // �ʵ�ȭ
 
	
	private JPanel contentPane;
	JTextArea textArea; // �ʵ�ȭ
	private final ButtonGroup btnGrpColors = new ButtonGroup();
	private JTextField txtFontSize;
	// ������ư �÷����� ���� �׷�.

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JMemoFrame9 frame = new JMemoFrame9();
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
	public JMemoFrame9() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\dev2021\\java_ws\\GUIMemoProject\\icons\\script_edit.png"));
		setTitle("My \uBA54\uBAA8\uC7A5");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		// �ʱ� �÷� ����
		this.activeColor = CR_BLACK;
		
		// ��Ʈ �迭 ����
		this.fonts = new Font[FONT_NAMES.length];
		for (int i = 0; i < FONT_NAMES.length; i++) {
			fonts[i] = new Font(FONT_NAMES[i],
					DEF_FONT_OPT, DEF_FONTSIZE);
		}
		
		JLabel lbStatus = new JLabel("���¹�::");
		lbStatus.setFont(new Font("�޸ո���ü", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lbStatus, BorderLayout.SOUTH);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		//JTextArea textArea = new JTextArea(); // ����
		textArea = new JTextArea(); // �ʵ�ȭ
		//textArea.setFont(new Font("����", Font.PLAIN, 18));
		textArea.setFont(new Font(
				FONT_NAMES[DEF_SEL_FONT],
				DEF_FONT_OPT, DEF_FONTSIZE)); // �⺻��Ʈ �Ӽ���
		scrollPane.setViewportView(textArea);// ��ũ�������� ����Ʈ ������ �ؽ�Ʈ���� ��ġ 
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		contentPane.add(panel, BorderLayout.WEST);
		//panel.setLayout(new GridLayout(6, 1, 0, 0)); // 6�� 1��
		panel.setLayout(new GridLayout(0, 1, 0, 0)); // N�� 1��
		// ���ʿ��� �������ٸ� jpanel�� ������... �׸��� 
		
		JButton btnNewButton = new JButton("");
		// addActionListener �̺�Ʈ ó���� ������ ���
		// �͸�ü (�������̽��ϳ����� ������ �̸����� ��ü�� ��� �����Ǿ� 
		// ���ڷ� �Էµ�) ==> �� ��ư���� ���� �̺�Ʈ ó�� ��ü�� ��ϵ�.
		btnNewButton.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("����� ����: " + activeColor);
					//this. // �͸�ü �ڽ�
					textArea.setForeground(activeColor);
				}
			}
		);
		btnNewButton.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\GUIMemoProject\\icons\\style_edit.png"));
		btnNewButton.setToolTipText("\uC804\uACBD\uC0C9 \uBCC0\uACBD");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("���� ����: " + activeColor);
				textArea.setBackground(activeColor);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\GUIMemoProject\\icons\\paintcan.png"));
		btnNewButton_1.setToolTipText("\uBC30\uACBD\uC0C9 \uBCC0\uACBD");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\GUIMemoProject\\icons\\book_open.png"));
		btnNewButton_2.setToolTipText("\uBA54\uBAA8 \uC77D\uC5B4\uC624\uAE30");
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\GUIMemoProject\\icons\\script_save.png"));
		btnNewButton_3.setToolTipText("\uBA54\uBAA8 \uC800\uC7A5\uD558\uAE30");
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("");
		panel.add(lblNewLabel);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\GUIMemoProject\\icons\\heart.png"));
		btnNewButton_4.setToolTipText("My\uBA54\uBAA8\uC7A5 \uB300\uD558\uC5EC...");
		panel.add(btnNewButton_4);
		
		JPanel panelTop = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelTop.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelTop.setBackground(Color.CYAN);
		contentPane.add(panelTop, BorderLayout.NORTH);
		
		JLabel label = new JLabel("My \uBA54\uBAA8\uC7A5::");
		label.setFont(new Font("���� ���", Font.BOLD, 16));
		panelTop.add(label);
		
		//JComboBox comboFonts = new JComboBox();// ���������̳� ���� �޺�
		this.comboFonts = new JComboBox();
		// ��Ʈ �޺��ڽ� ���� �̺�Ʈ ó�� 
		comboFonts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox combo = (JComboBox)e.getSource();
				System.out.println("��Ʈ �޺� ����: " 
						+ combo.getSelectedIndex() 
						+ "��° ���  => " 
						+ combo.getSelectedItem());
				//
				Font activeFont = 
						fonts[combo.getSelectedIndex()];
				textArea.setFont(activeFont);
			}
		});
		comboFonts.setMaximumRowCount(4); // 4�� ���̰�..
		comboFonts.setModel(
				new DefaultComboBoxModel(FONT_NAMES));
////				new String[] {"\uC0AC\uACFC", 
////						"\uBC14\uB098\uB098", 
////						"\uB9DD\uACE0", 
////						"\uD30C\uC778\uC560\uD50C", 
////						"\uD3EC\uB3C4"}
//				));
		comboFonts.setFont(new Font("���� ���", Font.BOLD, 18));
		comboFonts.setSelectedIndex(DEF_SEL_FONT); // 5 ������ �޺��ڽ��� ó�� ���� ��ҷ�..
		panelTop.add(comboFonts);
		
		JPanel pnFontSize = new JPanel();
		panelTop.add(pnFontSize);
		pnFontSize.setLayout(new BorderLayout(0, 0));
		
		txtFontSize = new JTextField();
		txtFontSize.setFont(new Font("����", Font.BOLD, 18));
		txtFontSize.setHorizontalAlignment(SwingConstants.CENTER);
		pnFontSize.add(txtFontSize, BorderLayout.CENTER);
		txtFontSize.setColumns(2);
		txtFontSize.setText(""+DEF_FONTSIZE); // String.valueOf()
		txtFontSize.setEditable(false);// read-only �б�����
		
		JPanel pnFontButtons = new JPanel();
		pnFontSize.add(pnFontButtons, BorderLayout.EAST);
		pnFontButtons.setLayout(new GridLayout(3, 1, 0, 0));
		
		JButton btnFontsizeUp = new JButton("\u25B2");
		btnFontsizeUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ��Ʈ ������ �� ++
				String oldFontsize = txtFontSize.getText();
				int newSize = Integer.parseInt(oldFontsize);
					// "18" => 18
				if( newSize < 99 ) {
					newSize++;
					System.out.println("��Ʈ ������ ��++ " + newSize);
					txtFontSize.setText(String.valueOf(newSize));
				}
			}
		});
		btnFontsizeUp.setFont(new Font("���� ���", Font.BOLD, 8));
		pnFontButtons.add(btnFontsizeUp);
		
		JButton btnFontsizeReset = new JButton("\u25A0");
		btnFontsizeReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("��Ʈ ������ �ʱ�ȭ: " + DEF_FONTSIZE);
				txtFontSize.setText(""+DEF_FONTSIZE);
			}
		});
		btnFontsizeReset.setFont(new Font("���� ���", Font.BOLD, 8));
		pnFontButtons.add(btnFontsizeReset);
		
		JButton btnFontsizeDown = new JButton("\u25BC");
		btnFontsizeDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ��Ʈ ������ �ٿ� --
				String oldFontsize = txtFontSize.getText();
				int newSize = Integer.parseInt(oldFontsize);
					// "18" => 18
				if( newSize > 5 ) {
					newSize--;
					System.out.println("��Ʈ ������ �ٿ�-- " + newSize);
					txtFontSize.setText(String.valueOf(newSize));
				}
			}
		});
		btnFontsizeDown.setFont(new Font("���� ���", Font.BOLD, 8));
		pnFontButtons.add(btnFontsizeDown);
		
		
		// �÷���...
		
		JPanel pnColors = new JPanel();
		panelTop.add(pnColors);
		
		ColorSelectHandler crHalder = new ColorSelectHandler();
		
		JRadioButton rdBlack = new JRadioButton("\uAC80\uC815");		
//		rdBlack.addItemListener(new ItemListener() {
//			public void itemStateChanged(ItemEvent e) {
//				//activeColor = CR
//			}
//		});
		btnGrpColors.add(rdBlack);
		rdBlack.setFont(new Font("�޸վƹ�ü", Font.BOLD, 18));
		rdBlack.setForeground(Color.WHITE);
		rdBlack.setBackground(Color.BLACK);
		pnColors.add(rdBlack);
		rdBlack.setSelected(true);// �ʱ� ���õ� ����
		rdBlack.addItemListener(crHalder);
		
		JRadioButton rdWhite = new JRadioButton("\uD770\uC0C9");
		btnGrpColors.add(rdWhite);
		rdWhite.setFont(new Font("�޸վƹ�ü", Font.BOLD, 18));
		rdWhite.setBackground(Color.WHITE);
		pnColors.add(rdWhite);
		rdWhite.addItemListener(crHalder);
		
		JRadioButton rdGray = new JRadioButton("\uD68C\uC0C9");
		btnGrpColors.add(rdGray);
		rdGray.setFont(new Font("�޸վƹ�ü", Font.BOLD, 18));
		rdGray.setBackground(Color.GRAY);
		pnColors.add(rdGray);
		rdGray.addItemListener(crHalder);
		
		JRadioButton rdRed = new JRadioButton("\uBE68\uAC15");
		btnGrpColors.add(rdRed);
		rdRed.setFont(new Font("�޸վƹ�ü", Font.BOLD, 18));
		rdRed.setBackground(Color.RED);
		pnColors.add(rdRed);
		rdRed.addItemListener(crHalder);
		
		JRadioButton rdGreen = new JRadioButton("\uCD08\uB85D");
		btnGrpColors.add(rdGreen);
		rdGreen.setFont(new Font("�޸վƹ�ü", Font.BOLD, 18));
		rdGreen.setBackground(Color.GREEN);
		pnColors.add(rdGreen);
		rdGreen.addItemListener(crHalder);
		
		JRadioButton rdBlue = new JRadioButton("\uD30C\uB791");
		btnGrpColors.add(rdBlue);
		rdBlue.setFont(new Font("�޸վƹ�ü", Font.BOLD, 18));
		rdBlue.setBackground(Color.BLUE);
		pnColors.add(rdBlue);
		rdBlue.addItemListener(crHalder);
		
		JRadioButton rdOrange = new JRadioButton("\uC8FC\uD669");
		btnGrpColors.add(rdOrange);
		rdOrange.setFont(new Font("�޸վƹ�ü", Font.BOLD, 18));
		rdOrange.setBackground(Color.ORANGE);
		pnColors.add(rdOrange);
		rdOrange.addItemListener(crHalder);
			
		
		
	}

}
