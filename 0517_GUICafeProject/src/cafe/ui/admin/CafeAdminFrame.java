package cafe.ui.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Label;
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

import cafe.ui.components.FoodCardPanel;
import db.data.Food;
import db.data.Order;
import db.mgr.FoodDBMgr;
import db.mgr.OrderDBMgr;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;

public class CafeAdminFrame extends JFrame {

	private JPanel contentPane;
	private JTable tableFoods;
	CafeAdminFrame frm;
	ArrayList<Food> fdList; // �ʵ�ȭ�ؼ� ����� ����.
	
	CardLayout clyRight;
	// ī����� ����ϴ� �ؽø���...
	HashMap<String, JPanel> cards;
	private JTable tableMembers;
	private JTable tableOrders;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CafeAdminFrame frame = new CafeAdminFrame();
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
	public CafeAdminFrame() {
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
		
		JTabbedPane tabbedPane = 
				new JTabbedPane(JTabbedPane.BOTTOM);
		splitPane.setLeftComponent(tabbedPane);
		
		JPanel pnLeft = new JPanel(); // pnLeft�� ���ĸ޴�������?
//		splitPane.setLeftComponent(pnLeft);
		tabbedPane.addTab("���ĸ޴�����", pnLeft);		
		tabbedPane.setBackgroundAt(0, Color.ORANGE);
		tabbedPane.setIconAt(0, new ImageIcon("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\sport_football.png"));
		pnLeft.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		pnLeft.add(toolBar, BorderLayout.NORTH);
		
		JButton btnFoodShow = new JButton("\uC74C\uC2DD \uB9AC\uC2A4\uD2B8\uC870\uD68C");
		btnFoodShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// DB���� foods ���̺��� �ٽ� select�Ͽ�
				// ui�� tableFoods�� �ٽ� �ݿ��϶�.
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
		
		JPanel pnRight = new JPanel(); // �̵�
		
		tableFoods = new JTable();
		tableFoods.addMouseListener(new MouseAdapter() {
			@Override			
			public void mouseClicked(MouseEvent e) {
				// �� ����(single ���� ���) ���̺�
				int selRow = tableFoods.getSelectedRow();
				// table���� ���õ� ���ȣ(-1�� ������ ���� ����; 0 ~ row-1)
//				final String columnNames[] = {
//					"��ȣ", "�̸�", "ī�װ�", "�̹������", 
//					"���� (��)", "Hot/Ice", "��ϳ���", "����"
//				}; // 8	
				int selFdId = (int) tableFoods
						.getValueAt(selRow, 0);
				String selFdName = (String) tableFoods
						.getValueAt(selRow, 1);
//				System.out.println(
//						">> table ���õ� #"+selFdId 
//						+" ���ĸ�: " + selFdName);
				Food selFd = fdList.get(selRow);// ���������� �����ٴ� ���� ��...
				
				System.out.println(
					">> table ���õ� ���� :" + selFd );
				
				clyRight.show(pnRight, "showFood");
//				FoodCardPanel pnSelFdCard
//					= new FoodCardPanel(selFd); 
				// �ű� �������� �޸� ����?
				FoodCardPanel pnSelFdCard
					= (FoodCardPanel) cards.get("showFood");
				// ������ �ʿ� �ִ� ī���г��� ����... 
				// ���ĵ����� ���ο� ���� ��ü ǥ��
				pnSelFdCard.showFoodDataToUI(selFd);				
			}
		});
		tableFoods.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
		
		JPanel pnMembers = new JPanel();
		tabbedPane.addTab("\uD68C\uC6D0\uAD00\uB9AC", new ImageIcon("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\group.png"), pnMembers, null);
		pnMembers.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar_1 = new JToolBar();
		pnMembers.add(toolBar_1, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("\uD68C\uC6D0\uB9AC\uC2A4\uD2B8 \uC870\uD68C");
		toolBar_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uD68C\uC6D0 \uCD94\uAC00");
		toolBar_1.add(btnNewButton_1);
		
		JButton btnNewButton_4 = new JButton("\uD68C\uC6D0 \uAC80\uC0C9");
		toolBar_1.add(btnNewButton_4);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		pnMembers.add(scrollPane_1, BorderLayout.CENTER);
		
		tableMembers = new JTable();
		scrollPane_1.setViewportView(tableMembers);
		
		JPanel pnOrders = new JPanel();
		tabbedPane.addTab("\uC8FC\uBB38\uAD00\uB9AC", new ImageIcon("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\transmit_go.png"), pnOrders, null);
		pnOrders.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar_2 = new JToolBar();
		pnOrders.add(toolBar_2, BorderLayout.NORTH);
		
		JButton btnNewButton_5 = new JButton("\uC8FC\uBB38\uB0B4\uC5ED\uC870\uD68C");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderDBMgr odMgr = new OrderDBMgr();
				ArrayList<Order> odList
							= odMgr.selectAllOrders();
				int odCnt = odList.size();
				final String []odColumnNames = {
					"id", "orderNum", "memberId", 
					"memberLogin", "foodId", 
					"foodName", "orderedAt",
					"unit", "totalPrice"							
				};
				//Object[][] odData = { {}, {} }; // 2��
				Object[][] odData 
					= new Object[odCnt][odColumnNames.length];
				//for (int row = 0; row < odData.length; row++) {
				for (int row = 0; row < odCnt; row++) {
					Order od = odList.get(row);
					odData[row][0] = od.getId(); // id
					odData[row][1] = od.getOrderNum();
					odData[row][2] = od.getMemberId();
					odData[row][3] = od.getMemberLogin();
					odData[row][4] = od.getFoodId();
					odData[row][5] = od.getFoodName();
					odData[row][6] = od.getOrderedAt(); // sdf
					odData[row][7] = od.getUnit()+"��";
					odData[row][8] = od.getTotalPrice() +"��";
				}
				
				// �ֹ� ���� ��ȸ
				DefaultTableModel dtm
					= new DefaultTableModel(
							odData, odColumnNames);
				tableOrders.setModel(dtm);
			}
		});
		btnNewButton_5.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\control_stop.png"));
		toolBar_2.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("\uC8FC\uBB38 \uAC80\uC0C9");
		btnNewButton_6.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\computer_add.png"));
		toolBar_2.add(btnNewButton_6);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		pnOrders.add(scrollPane_2, BorderLayout.CENTER);
		
		tableOrders = new JTable();
		scrollPane_2.setViewportView(tableOrders);
		
		JPanel pnStats = new JPanel();
		tabbedPane.addTab("\uD1B5\uACC4\uB9AC\uD3EC\uD2B8", new ImageIcon("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\contrast.png"), pnStats, null);
		pnStats.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar_3 = new JToolBar();
		pnStats.add(toolBar_3, BorderLayout.NORTH);
		
		JButton btnNewButton_7 = new JButton("\uC8FC\uBB38\uD1B5\uACC4");
		toolBar_3.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("\uC88B\uC544\uC694 \uD1B5\uACC4");
		toolBar_3.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("New button");
		toolBar_3.add(btnNewButton_9);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		pnStats.add(panel, BorderLayout.CENTER);
		
		this.cards = new HashMap<>();
		
		//JPanel pnRight = new JPanel();
		pnRight.setBackground(Color.GREEN);
		splitPane.setRightComponent(pnRight);
		this.clyRight = new CardLayout(0, 0);
		pnRight.setLayout(clyRight);
		//pnRight.setLayout(new CardLayout(0, 0));
		//pnRight.getLayout()
		// ���� �г�ī�� ���� ���� �ϴ� ǥ��
		JPanel dummy = new JPanel();
		dummy.add(new Label("�ȳ��ϼ���! ^^"));
		pnRight.add(dummy, "start");
		cards.put("start", dummy);
		//
		FoodCardPanel dummyFdCard
			= new FoodCardPanel(
				new Food("����Ŀ��", "Ŀ��", 
			"./images/menu_thumb/�Ƹ޸�ī��.PNG", 500, 1));
		pnRight.add(dummyFdCard, "showFood");
		cards.put("showFood", dummyFdCard);
		//
//		clyRight.show(pnRight, "start");
		clyRight.first(pnRight);

//		clyRight.show(pnRight, "showFood");
	}

	// DB���� foods ���̺��� �ٽ� select�Ͽ�
	// ui�� tableFoods�� �ٽ� �ݿ��϶�.	
	public void showFoodTableUIFromDB() {
		final String columnNames[] = {
			"��ȣ", "�̸�", "ī�װ�", "�̹������", 
			"���� (��)", "Hot/Ice", "��ϳ���", "����"
		}; // 8		
		
		//String data[][]= {{}}; // ���ڿ����Ǵ� 2���� �迭 
//		Object data[][]= {{}}; // ��� �޴� 2���� �迭
//		Object data[][]= {
//				{1, "�ֵ���", "����", "./images/hotdog.png", 
//				 1500, 1, "2020-12-10", "���� �ֵ���"	}
//		}; // 1�� 8���� ���� 2���� ������ �迭
		
		// ���� DB���� ��ȸ...
		// foods ���̺��� ���� ���ڵ� ����
		FoodDBMgr mgr = new FoodDBMgr();
		//ArrayList<Food> fdList = mgr.selectAllFoods();
		fdList = mgr.selectAllFoods();
		if( fdList == null || fdList.isEmpty() ) return;
		final int nDBSize = fdList.size(); // ���ڵ� ���� ==> ���̺��� ���
		Object data[][] = new Object[nDBSize][columnNames.length];
		
		for (int i = 0; i < nDBSize; i++) {
			Food fd = fdList.get(i);
			// �࿭ ��ȣ�� ���̺� �����ͼ� ä���
			data[i][0] = fd.getId();  
			data[i][1] = fd.getName();
			data[i][2] = fd.getCategory();
			data[i][3] = fd.getImagePath();
			data[i][4] = fd.getPrice() + "��";
			data[i][5] = fd.getHotIce()
					== Food.TEMP_HOT ? "hot": "ice";
			SimpleDateFormat sdf = 
					new SimpleDateFormat("yyyy�� MM�� dd��");
			data[i][6] = sdf.format(fd.getRegDate());
			data[i][7] = fd.getDescription();
		}
		
		DefaultTableModel dtm = 
				new DefaultTableModel(data, columnNames);
		// �⺻���̺� �� = ������(��/��) 2�����迭, ���̸���� 1�����迭
		this.tableFoods.setModel(dtm);		
	}

}
