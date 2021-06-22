package cafe.ui.food;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cafe.ui.components.ImagePanel;
import db.data.Food;
import db.mgr.FoodDBMgr;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.border.MatteBorder;
import javax.swing.ScrollPaneConstants;

public class FoodMenuFrame_backup3 extends JFrame {

	//private JPanel contentPane;
	ImagePanel contentPane;
	public ArrayList<Food> foodMenuList;
	FoodDBMgr mgr; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FoodMenuFrame_backup3 frame = new FoodMenuFrame_backup3();
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
	public FoodMenuFrame_backup3() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\cup_go.png"));
		setTitle("MyCafe :: \uC74C\uC2DD \uBA54\uB274\uD310");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 456);
		Image bg = Toolkit.getDefaultToolkit()
				.getImage("./images/bg/bg2.jpg");
		contentPane = new ImagePanel(
				bg, "bg2.jpg", 526, 456);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select Foods!");
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setFont(new Font("Brush Script MT", Font.BOLD, 32));
		lblNewLabel.setBounds(34, 37, 186, 40);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(131, 113, 335, 294);
		scrollPane.setOpaque(false);// 투명
		scrollPane.setBackground(new Color(0, 255, 0, 255));
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(3, 2, 1, 1, 
				(Color) Color.PINK));
		//panel.setBackground(new Color(0, 255, 0));
		panel.setBackground(new Color(0, 255, 0, 255));
		panel.setOpaque(false);
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
//		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		// DB 로딩
		this.mgr = new FoodDBMgr();
		this.foodMenuList = mgr.selectAllFoods();
		
		
		FoodMenuHandler foodHanlder = new FoodMenuHandler(this);
//		for (int i = 0; i < 7; i++) {
		for (int i = 0; i < foodMenuList.size(); i++) {
			//String text = "메뉴 "+i;
//			String text = "메뉴: "+ "아메리카노" +"\n" 
//					+ "("+"커피"+") " + "\n"
//					+ 1000 + "원";
//			String text = 
//				"<html> <b style='color:blue'>"+ "아메리카노" +"</b><br>" 
//				+ "<i style='font-size: 10pt;color:orange'> ("
//							+"커피"+") </i> <br>" 
//				+ "<small><i>" + 1000 + "원" + "</i></small></html>";
			
			Food food = foodMenuList.get(i);
			String text = 
		"<html> <b style='color:blue'>"+ food.getName() +"</b><br>" 
		+ "<i style='font-size: 10pt;color:orange'> ("
					+ food.getCategory() +") </i> <br>" 
		+ "<small><i>" + food.getPrice() + "원" + "</i></small></html>";
			
			ImageIcon icon = new 
				ImageIcon(food.getImagePath());
				//ImageIcon("./images/menu_thumb/아메리카노.PNG");
			JLabel lbFoodMenu = 
				new JLabel(text, icon, JLabel.CENTER);
			lbFoodMenu.setToolTipText(food.getName() + " 클릭 상세보기");
			//lbFoodMenu.setToolTipText("아메리카노" + " 클릭 상세보기");
			lbFoodMenu.setPreferredSize(
					new Dimension(lbFoodMenu.getWidth(),
							140));
			lbFoodMenu.setBackground(
				new Color(128, 128, 128, 128)); //255));
			lbFoodMenu.setOpaque(false); // 투명모드
			lbFoodMenu.addMouseListener(foodHanlder);// 이벤트 리스너 등록
			panel.add(lbFoodMenu);
		}
	}
	
	// 푸두메뉴 레이블 이벤트 처리 내부클래스
	public class FoodMenuHandler extends MouseAdapter {

		FoodMenuFrame_backup3 frm;
		
		public FoodMenuHandler(FoodMenuFrame_backup3 frm) {
			this.frm = frm;
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			JLabel foodMenu = (JLabel) e.getSource();
//			System.out.println(">> 메뉴 선택: " 
//					+ foodMenu.getText());
			
			for (int i = 0; i < frm.foodMenuList.size(); i++) {
				Food food = frm.foodMenuList.get(i);
				if( foodMenu.getText()
						.contains(food.getName()) ) {
					System.out.println("선택된 음식: " 
							+ food);
//					순서 번호 i
//					db관리 번호 food.id
//					유일 이름 food.name
					FoodCatalogDialog fcDlg
						= new FoodCatalogDialog(frm, food);
						//= new FoodCatalogDialog(frm, i);
						//= new FoodCatalogDialog(frm, food.getId()); //PK
						//= new FoodCatalogDialog(frm, food.getName()); //UQ
					Point pt = foodMenu.getLocationOnScreen();
					fcDlg.setLocation(
							(int)(foodMenu.getWidth()*0.8)+pt.x
							, pt.y+60);
					fcDlg.setVisible(true);
				}
			} 
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			JLabel foodMenu = (JLabel) e.getSource();
			foodMenu.setOpaque(true);
			foodMenu.setBackground(Color.yellow);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			JLabel foodMenu = (JLabel) e.getSource();
			foodMenu.setOpaque(false);
			foodMenu.setBackground(new Color(0, 0, 0, 255));
		}
		
		
	}
}




