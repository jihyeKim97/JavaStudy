package cafe.ui.food;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cafe.ui.components.FoodCardPanel;
import db.data.Food;

import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JSlider;
import java.awt.Color;
import javax.swing.JToolBar;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class CustomFoodCatalogDialog_bcckup3 extends JDialog {

//	private final JPanel pnMenu = new JPanel();
	JPanel pnMenu;
	CardLayout cdlay; // 카드 레이아웃
	JToolBar toolBar;
	Food selFood; // 현재 대화창에 선택된 음식
	CustomFoodCatalogDialog_bcckup3 cdlg;
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			CustomFoodCatalogDialog dialog = new CustomFoodCatalogDialog();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	// 키 이벤트 처리 내장 클래스
	class MenuKeyHandler extends KeyAdapter {

		@Override
		public void keyReleased(KeyEvent e) {
			int code = e.getKeyCode();
			System.out.println("대화창 키보드 이벤트! " + code);
			switch (code) {
			case KeyEvent.VK_LEFT:
				 System.out.println("왼쪽 커서방향 키");
				 cdlay.previous(pnMenu); // 이전카드
				break;
			case KeyEvent.VK_RIGHT:
				 System.out.println("오른쪽 커서방향 키");
				 cdlay.next(pnMenu); // 다음카드
				break;			
			case KeyEvent.VK_SPACE:
				 System.out.println("스페이스 키");
				 cdlay.first(pnMenu); // 처음카드?
				break;						
			default:
				break;
			}
		}
		
	}
	
	/**
	 * Create the dialog.
	 */
	public CustomFoodCatalogDialog_bcckup3(FoodMenuFrame frm,
			 Food food) {
		super(frm, false); // modaless
		this.selFood = food; // 현재 선택된 음식
		this.cdlg = this;
		//
		// 대화상자 키보드 이벤트
		this.setFocusable(true);// 대화창이 포커스를 갖을 수 있게..
		this.setFocusTraversalKeysEnabled(false);
		//
		this.addKeyListener(new MenuKeyHandler());
				// KeyAdpater 상속?
//		this.addKeyListener(new KeyAdapter() {
//
//			@Override
//			public void keyReleased(KeyEvent e) {
//				// TODO Auto-generated method stub
//				super.keyReleased(e);
//			}
//			
//		});
		
		//
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\cup_go.png"));
		setResizable(false);
		setTitle("\uCEE4\uC2A4\uD140 \uD478\uB4DC\uBA54\uB274 \uCE74\uD0C8\uB85C\uADF8");
		setBounds(100, 100, 484, 385);
		getContentPane().setLayout(new BorderLayout());
		
		pnMenu = new JPanel();
		
		pnMenu.setBackground(Color.PINK);
		pnMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnMenu, BorderLayout.CENTER);
		this.cdlay = new CardLayout(0, 0);// 카드레이아웃
		pnMenu.setLayout(cdlay);
		
		// fooddbmgr로 조회도 되지만...
		ArrayList<Food> fdList = frm.foodMenuList;
		// 이 사이즈의 개수 만큼의 푸드카드패널을 카드레이아웃에 하나씩 붙이고
		// 단 하나의 카드를 우선 표시함.
		for (int i = 0; i < fdList.size(); i++) {
			Food mnfd = fdList.get(i);
			FoodCardPanel fdCard = new FoodCardPanel(mnfd);
			//pnMenu.add(fdCard, i);
			pnMenu.add(fdCard, "card"+mnfd.getId()); //PK
//			pnMenu.add(fdCard, "card"+mnfd.getName()); //UQ
		}
		cdlay.show(pnMenu, "card"+food.getId());
			// "card"+음식PK의 키를 가진 카드패널이 표시
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnPrevCard = new JButton("<<");
				btnPrevCard.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("이전 카드 표시");
						cdlay.previous(pnMenu);
						// 대화상자에게 포커스 이동
						cdlg.requestFocus();
					}
				});
				buttonPane.add(btnPrevCard);
			}
			{
				JButton btnNextCard = new JButton(">>");
				btnNextCard.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("다음  카드 표시");
						cdlay.next(pnMenu);
//						cdlay.first(pnMenu);
//						cdlay.last(pnMenu);
//						cdlay.previous(pnMenu);
//						cdlay.show(parent, name);
						// 대화상자에게 포커스 이동
						cdlg.requestFocus();
					}
				});
				buttonPane.add(btnNextCard);
			}
			{
				JSlider sliderUnit = new JSlider();
				buttonPane.add(sliderUnit);
			}
			{
				JButton btnNewButton_1 = new JButton("\uC88B\uC544\uC694");
				buttonPane.add(btnNewButton_1);
			}
			{
				JButton btnNewButton = new JButton("\uC8FC\uBB38");
				buttonPane.add(btnNewButton);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.GREEN);
			getContentPane().add(panel, BorderLayout.NORTH);
			{
//				JToolBar toolBar = new JToolBar();
				toolBar = new JToolBar();
				panel.add(toolBar);
				//
				ToolBarSelectHandler tbHandler
				 = new ToolBarSelectHandler(frm, this);
				for (int i = 0; i < fdList.size(); i++) {
					Food tbFood = fdList.get(i);					
					JButton tbBtn; // 음식의 툴바용 썸네일네임					
					ImageIcon tbIc = 
							new ImageIcon(tbFood.getImagePath());
					// 툴바아이콘 32x32 재크기
					Image tbIcImg = tbIc.getImage()
						.getScaledInstance(32, 32, Image.SCALE_FAST);
					tbIc.setImage(tbIcImg);					
					tbBtn = new JButton(tbIc);
					tbBtn.repaint();
					tbBtn.setToolTipText(tbFood.getName());
					toolBar.add(tbBtn);
					tbBtn.addActionListener(tbHandler);
				}
			}
		}
	}
	
	// 툴바 이벤트 처리 용 핸들러 클래스
	class ToolBarSelectHandler implements ActionListener {
		FoodMenuFrame frm;
		CustomFoodCatalogDialog_bcckup3 dlg;
		public ToolBarSelectHandler(FoodMenuFrame frm, 
				CustomFoodCatalogDialog_bcckup3 dlg) {
			this.frm = frm;
			this.dlg = dlg;
		}		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
//			System.out.println(
//				"툴바 음식 아이콘 선택!~ " + btn.getToolTipText());
			// btn.getToolTipText() 음식의 이름 <<UQ>>
			int selFdPKId = 0;
			for (Food fd : frm.foodMenuList ) {
				if( fd.getName().equals(btn.getToolTipText()) ) {
					System.out.println(
						"툴바 선택 음식:" + fd);
					selFdPKId = fd.getId(); // <<PK>>
					dlg.selFood = fd; // 현재 선택된 음식
					break;
				}
			} 
			if( selFdPKId != 0 ) {
				dlg.cdlay.show(
					dlg.pnMenu, "card"+selFdPKId);
				// "card"+음식PK의 키를 가진 카드패널이 표시
			}
			// 대화상자에게 포커스 이동
			dlg.requestFocus();
		}
		
	}

}
