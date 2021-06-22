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
	// 컬러 선택 
	public static final Color CR_WHITE = Color.WHITE;
	public static final Color CR_BLACK = Color.black;
	public static final Color CR_GRAY = Color.gray;
	public static final Color CR_RED = Color.red;
	public static final Color CR_GREEN = Color.GREEN;
	public static final Color CR_BLUE = Color.BLUE;
	public static final Color CR_ORANGE = new Color(247, 222, 220); // colorzilla 
	
	// 현재 메모장에 활성화된 컬러를 기억하는 필드
	Color activeColor;
	
	// 컬러 라디오 버튼들 전용 공통 이벤트 핸들러 내부 클래스
	// (내부클래스는 외부 클래스의 모든 자원에 접근이 된다.)
	private class ColorSelectHandler implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			JRadioButton rdColor = (JRadioButton)e.getItemSelectable();
			if( rdColor.isSelected() ) {
				System.out.println("색상 팔레트 선택: " 
						+ rdColor.getText());
				// 컬러 이름 문자열 비교 (동등성) 
//				if(  rdColor.getText().equals("검정")) {}
				switch ( rdColor.getText()) {
				case "검정": activeColor = CR_BLACK;	break;
				case "흰색": activeColor = CR_WHITE;	break;
				case "회색": activeColor = CR_GRAY;	break;
				case "빨강": activeColor = CR_RED;	break;
				case "파랑": activeColor = CR_BLUE;	break;
				case "초록": activeColor = CR_GREEN;	break;
				case "주황": activeColor = CR_ORANGE;	break;
				default:
					System.out.println("없는 컬러 이름!");
					break;
				}
			}
		}
		
	}
	
	
	// 폰트
	public static final String[] FONT_NAMES = {
		"Arial", "Book Antiqua", "Georgia", "Courier New",
		"나눔고딕", "굴림", "바탕", "궁서", "나눔바른펜"
	};
	public static final int DEF_SEL_FONT = 5; // Gulim
	public static final int DEF_FONTSIZE = 18; 
	public static final int DEF_FONT_OPT = Font.PLAIN;
	
	public Font[] fonts; // 폰트관리용 배열
	JComboBox comboFonts; // 필드화
 
	
	private JPanel contentPane;
	JTextArea textArea; // 필드화
	private final ButtonGroup btnGrpColors = new ButtonGroup();
	private JTextField txtFontSize;
	// 라디오버튼 컬러들을 묶는 그룹.

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
		
		// 초기 컬러 설정
		this.activeColor = CR_BLACK;
		
		// 폰트 배열 설정
		this.fonts = new Font[FONT_NAMES.length];
		for (int i = 0; i < FONT_NAMES.length; i++) {
			fonts[i] = new Font(FONT_NAMES[i],
					DEF_FONT_OPT, DEF_FONTSIZE);
		}
		
		JLabel lbStatus = new JLabel("상태바::");
		lbStatus.setFont(new Font("휴먼매직체", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lbStatus, BorderLayout.SOUTH);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		//JTextArea textArea = new JTextArea(); // 지역
		textArea = new JTextArea(); // 필드화
		//textArea.setFont(new Font("굴림", Font.PLAIN, 18));
		textArea.setFont(new Font(
				FONT_NAMES[DEF_SEL_FONT],
				DEF_FONT_OPT, DEF_FONTSIZE)); // 기본폰트 속성들
		scrollPane.setViewportView(textArea);// 스크롤페인의 뷰포트 영역에 텍스트에어리어를 배치 
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		contentPane.add(panel, BorderLayout.WEST);
		//panel.setLayout(new GridLayout(6, 1, 0, 0)); // 6행 1열
		panel.setLayout(new GridLayout(0, 1, 0, 0)); // N행 1열
		// 왼쪽영역 세로툴바를 jpanel로 구현중... 그리드 
		
		JButton btnNewButton = new JButton("");
		// addActionListener 이벤트 처리용 리스너 등록
		// 익명객체 (인터페이스하나만을 구현한 이름없는 객체가 즉시 생성되어 
		// 인자로 입력됨) ==> 이 버튼만의 전용 이벤트 처리 객체가 등록됨.
		btnNewButton.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("전경색 변경: " + activeColor);
					//this. // 익명객체 자신
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
				System.out.println("배경색 변경: " + activeColor);
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
		label.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		panelTop.add(label);
		
		//JComboBox comboFonts = new JComboBox();// 스윙디자이너 지역 콤보
		this.comboFonts = new JComboBox();
		// 폰트 콤보박스 선택 이벤트 처리 
		comboFonts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox combo = (JComboBox)e.getSource();
				System.out.println("폰트 콤보 선택: " 
						+ combo.getSelectedIndex() 
						+ "번째 요소  => " 
						+ combo.getSelectedItem());
				//
				Font activeFont = 
						fonts[combo.getSelectedIndex()];
				textArea.setFont(activeFont);
			}
		});
		comboFonts.setMaximumRowCount(4); // 4개 보이게..
		comboFonts.setModel(
				new DefaultComboBoxModel(FONT_NAMES));
////				new String[] {"\uC0AC\uACFC", 
////						"\uBC14\uB098\uB098", 
////						"\uB9DD\uACE0", 
////						"\uD30C\uC778\uC560\uD50C", 
////						"\uD3EC\uB3C4"}
//				));
		comboFonts.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		comboFonts.setSelectedIndex(DEF_SEL_FONT); // 5 굴림를 콤보박스의 처음 선택 요소로..
		panelTop.add(comboFonts);
		
		JPanel pnFontSize = new JPanel();
		panelTop.add(pnFontSize);
		pnFontSize.setLayout(new BorderLayout(0, 0));
		
		txtFontSize = new JTextField();
		txtFontSize.setFont(new Font("굴림", Font.BOLD, 18));
		txtFontSize.setHorizontalAlignment(SwingConstants.CENTER);
		pnFontSize.add(txtFontSize, BorderLayout.CENTER);
		txtFontSize.setColumns(2);
		txtFontSize.setText(""+DEF_FONTSIZE); // String.valueOf()
		txtFontSize.setEditable(false);// read-only 읽기전용
		
		JPanel pnFontButtons = new JPanel();
		pnFontSize.add(pnFontButtons, BorderLayout.EAST);
		pnFontButtons.setLayout(new GridLayout(3, 1, 0, 0));
		
		JButton btnFontsizeUp = new JButton("\u25B2");
		btnFontsizeUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 폰트 사이즈 업 ++
				String oldFontsize = txtFontSize.getText();
				int newSize = Integer.parseInt(oldFontsize);
					// "18" => 18
				if( newSize < 99 ) {
					newSize++;
					System.out.println("폰트 사이즈 업++ " + newSize);
					txtFontSize.setText(String.valueOf(newSize));
				}
			}
		});
		btnFontsizeUp.setFont(new Font("맑은 고딕", Font.BOLD, 8));
		pnFontButtons.add(btnFontsizeUp);
		
		JButton btnFontsizeReset = new JButton("\u25A0");
		btnFontsizeReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("폰트 사이즈 초기화: " + DEF_FONTSIZE);
				txtFontSize.setText(""+DEF_FONTSIZE);
			}
		});
		btnFontsizeReset.setFont(new Font("맑은 고딕", Font.BOLD, 8));
		pnFontButtons.add(btnFontsizeReset);
		
		JButton btnFontsizeDown = new JButton("\u25BC");
		btnFontsizeDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 폰트 사이즈 다운 --
				String oldFontsize = txtFontSize.getText();
				int newSize = Integer.parseInt(oldFontsize);
					// "18" => 18
				if( newSize > 5 ) {
					newSize--;
					System.out.println("폰트 사이즈 다운-- " + newSize);
					txtFontSize.setText(String.valueOf(newSize));
				}
			}
		});
		btnFontsizeDown.setFont(new Font("맑은 고딕", Font.BOLD, 8));
		pnFontButtons.add(btnFontsizeDown);
		
		
		// 컬러들...
		
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
		rdBlack.setFont(new Font("휴먼아미체", Font.BOLD, 18));
		rdBlack.setForeground(Color.WHITE);
		rdBlack.setBackground(Color.BLACK);
		pnColors.add(rdBlack);
		rdBlack.setSelected(true);// 초기 선택된 상태
		rdBlack.addItemListener(crHalder);
		
		JRadioButton rdWhite = new JRadioButton("\uD770\uC0C9");
		btnGrpColors.add(rdWhite);
		rdWhite.setFont(new Font("휴먼아미체", Font.BOLD, 18));
		rdWhite.setBackground(Color.WHITE);
		pnColors.add(rdWhite);
		rdWhite.addItemListener(crHalder);
		
		JRadioButton rdGray = new JRadioButton("\uD68C\uC0C9");
		btnGrpColors.add(rdGray);
		rdGray.setFont(new Font("휴먼아미체", Font.BOLD, 18));
		rdGray.setBackground(Color.GRAY);
		pnColors.add(rdGray);
		rdGray.addItemListener(crHalder);
		
		JRadioButton rdRed = new JRadioButton("\uBE68\uAC15");
		btnGrpColors.add(rdRed);
		rdRed.setFont(new Font("휴먼아미체", Font.BOLD, 18));
		rdRed.setBackground(Color.RED);
		pnColors.add(rdRed);
		rdRed.addItemListener(crHalder);
		
		JRadioButton rdGreen = new JRadioButton("\uCD08\uB85D");
		btnGrpColors.add(rdGreen);
		rdGreen.setFont(new Font("휴먼아미체", Font.BOLD, 18));
		rdGreen.setBackground(Color.GREEN);
		pnColors.add(rdGreen);
		rdGreen.addItemListener(crHalder);
		
		JRadioButton rdBlue = new JRadioButton("\uD30C\uB791");
		btnGrpColors.add(rdBlue);
		rdBlue.setFont(new Font("휴먼아미체", Font.BOLD, 18));
		rdBlue.setBackground(Color.BLUE);
		pnColors.add(rdBlue);
		rdBlue.addItemListener(crHalder);
		
		JRadioButton rdOrange = new JRadioButton("\uC8FC\uD669");
		btnGrpColors.add(rdOrange);
		rdOrange.setFont(new Font("휴먼아미체", Font.BOLD, 18));
		rdOrange.setBackground(Color.ORANGE);
		pnColors.add(rdOrange);
		rdOrange.addItemListener(crHalder);
			
		
		
	}

}
