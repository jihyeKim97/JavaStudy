package cafe.ui.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import db.data.Food;
import db.mgr.FoodDBMgr;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CafeAdminFrame_backup1 extends JFrame {

	private JPanel contentPane;
	private JTable tableFoods;
	CafeAdminFrame_backup1 frm;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CafeAdminFrame_backup1 frame = new CafeAdminFrame_backup1();
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
	public CafeAdminFrame_backup1() {
		this.frm = this;
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\cup_error.png"));
		setTitle("MyCafe :: \uAD00\uB9AC\uC790 \uBAA8\uB4DC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		splitPane.setOneTouchExpandable(true);
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		JPanel pnLeft = new JPanel();
		splitPane.setLeftComponent(pnLeft);
		pnLeft.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		pnLeft.add(toolBar, BorderLayout.NORTH);
		
		JButton btnFoodShow = new JButton("\uC74C\uC2DD \uB9AC\uC2A4\uD2B8\uC870\uD68C");
		btnFoodShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// DB에서 foods 테이블을 다시 select하여
				// ui의 tableFoods에 다시 반영하라.
				frm.showFoodTableUIFromDB();
			}
		});
		btnFoodShow.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\find.png"));
		toolBar.add(btnFoodShow);
		
		JLabel lblNewLabel = new JLabel("   ");
		toolBar.add(lblNewLabel);
		
		JButton btnFoodAdd = new JButton("\uC74C\uC2DD \uCD94\uAC00");
		btnFoodAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminFoodMenuAddDialog addDlg
					= new AdminFoodMenuAddDialog(frm);
				Point pt = btnFoodAdd.getLocationOnScreen();
				addDlg.setLocation(pt);
				addDlg.setVisible(true);
			}
		});
		btnFoodAdd.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\ruby_add.png"));
		toolBar.add(btnFoodAdd);
		
		JButton btnNewButton_2 = new JButton("\uC74C\uC2DD\uC0AD\uC81C");
		btnNewButton_2.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\wrench_orange.png"));
		toolBar.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\uC74C\uC2DD \uAC80\uC0C9");
		btnNewButton_3.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\zoom.png"));
		toolBar.add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		pnLeft.add(scrollPane, BorderLayout.CENTER);
		
		tableFoods = new JTable();
		tableFoods.setModel(new DefaultTableModel(
			new Object[][] {
				{"11", "11111", "aaaa", "elsa", "2902-09-22"},
				{"12", "3333", "ddd", "olaf", "2902-09-22"},
				{"13", "33433", "3e3e33", "anna", null},
			},
			new String[] {
				"\uBC88\uD638", "\uAC00\uACA9", "\uC774\uBBF8\uC9C0", "\uC774\uB984", "\uB0A0\uC790"
			}
		));
		scrollPane.setViewportView(tableFoods);
		
		JPanel pnRight = new JPanel();
		pnRight.setBackground(Color.GREEN);
		splitPane.setRightComponent(pnRight);
	}

	// DB에서 foods 테이블을 다시 select하여
	// ui의 tableFoods에 다시 반영하라.	
	public void showFoodTableUIFromDB() {
		final String columnNames[] = {
			"번호", "이름", "카테고리", "이미지경로", 
			"가격 (원)", "Hot/Ice", "등록날자", "설명문"
		}; // 8		
		
		//String data[][]= {{}}; // 문자열만되는 2차원 배열 
//		Object data[][]= {{}}; // 모든 받는 2차원 배열
//		Object data[][]= {
//				{1, "핫도그", "음식", "./images/hotdog.png", 
//				 1500, 1, "2020-12-10", "옛날 핫도그"	}
//		}; // 1행 8열의 더미 2차원 데이터 배열
		
		// 실제 DB에서 조회...
		// foods 테이블의 실제 레코드 개수
		FoodDBMgr mgr = new FoodDBMgr();
		ArrayList<Food> fdList = mgr.selectAllFoods();
		if( fdList == null || fdList.isEmpty() ) return;
		final int nDBSize = fdList.size(); // 레코드 개수 ==> 테이블의 행수
		Object data[][] = new Object[nDBSize][columnNames.length];
		
		for (int i = 0; i < nDBSize; i++) {
			Food fd = fdList.get(i);
			// 행열 번호로 테이블 데이터셀 채우기
			data[i][0] = fd.getId();  
			data[i][1] = fd.getName();
			data[i][2] = fd.getCategory();
			data[i][3] = fd.getImagePath();
			data[i][4] = fd.getPrice() + "원";
			data[i][5] = fd.getHotIce()
					== Food.TEMP_HOT ? "hot": "ice";
			SimpleDateFormat sdf = 
					new SimpleDateFormat("yyyy년 MM월 dd일");
			data[i][6] = sdf.format(fd.getRegDate());
			data[i][7] = fd.getDescription();
		}
		
		DefaultTableModel dtm = 
				new DefaultTableModel(data, columnNames);
		// 기본테이블 모델 = 데이터(행/열) 2차원배열, 열이름헤더 1차원배열
		this.tableFoods.setModel(dtm);		
	}

}
