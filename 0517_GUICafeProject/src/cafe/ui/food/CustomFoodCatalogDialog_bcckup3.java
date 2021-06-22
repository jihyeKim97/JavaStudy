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
	CardLayout cdlay; // ī�� ���̾ƿ�
	JToolBar toolBar;
	Food selFood; // ���� ��ȭâ�� ���õ� ����
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

	// Ű �̺�Ʈ ó�� ���� Ŭ����
	class MenuKeyHandler extends KeyAdapter {

		@Override
		public void keyReleased(KeyEvent e) {
			int code = e.getKeyCode();
			System.out.println("��ȭâ Ű���� �̺�Ʈ! " + code);
			switch (code) {
			case KeyEvent.VK_LEFT:
				 System.out.println("���� Ŀ������ Ű");
				 cdlay.previous(pnMenu); // ����ī��
				break;
			case KeyEvent.VK_RIGHT:
				 System.out.println("������ Ŀ������ Ű");
				 cdlay.next(pnMenu); // ����ī��
				break;			
			case KeyEvent.VK_SPACE:
				 System.out.println("�����̽� Ű");
				 cdlay.first(pnMenu); // ó��ī��?
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
		this.selFood = food; // ���� ���õ� ����
		this.cdlg = this;
		//
		// ��ȭ���� Ű���� �̺�Ʈ
		this.setFocusable(true);// ��ȭâ�� ��Ŀ���� ���� �� �ְ�..
		this.setFocusTraversalKeysEnabled(false);
		//
		this.addKeyListener(new MenuKeyHandler());
				// KeyAdpater ���?
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
		this.cdlay = new CardLayout(0, 0);// ī�巹�̾ƿ�
		pnMenu.setLayout(cdlay);
		
		// fooddbmgr�� ��ȸ�� ������...
		ArrayList<Food> fdList = frm.foodMenuList;
		// �� �������� ���� ��ŭ�� Ǫ��ī���г��� ī�巹�̾ƿ��� �ϳ��� ���̰�
		// �� �ϳ��� ī�带 �켱 ǥ����.
		for (int i = 0; i < fdList.size(); i++) {
			Food mnfd = fdList.get(i);
			FoodCardPanel fdCard = new FoodCardPanel(mnfd);
			//pnMenu.add(fdCard, i);
			pnMenu.add(fdCard, "card"+mnfd.getId()); //PK
//			pnMenu.add(fdCard, "card"+mnfd.getName()); //UQ
		}
		cdlay.show(pnMenu, "card"+food.getId());
			// "card"+����PK�� Ű�� ���� ī���г��� ǥ��
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnPrevCard = new JButton("<<");
				btnPrevCard.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("���� ī�� ǥ��");
						cdlay.previous(pnMenu);
						// ��ȭ���ڿ��� ��Ŀ�� �̵�
						cdlg.requestFocus();
					}
				});
				buttonPane.add(btnPrevCard);
			}
			{
				JButton btnNextCard = new JButton(">>");
				btnNextCard.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("����  ī�� ǥ��");
						cdlay.next(pnMenu);
//						cdlay.first(pnMenu);
//						cdlay.last(pnMenu);
//						cdlay.previous(pnMenu);
//						cdlay.show(parent, name);
						// ��ȭ���ڿ��� ��Ŀ�� �̵�
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
					JButton tbBtn; // ������ ���ٿ� ����ϳ���					
					ImageIcon tbIc = 
							new ImageIcon(tbFood.getImagePath());
					// ���پ����� 32x32 ��ũ��
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
	
	// ���� �̺�Ʈ ó�� �� �ڵ鷯 Ŭ����
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
//				"���� ���� ������ ����!~ " + btn.getToolTipText());
			// btn.getToolTipText() ������ �̸� <<UQ>>
			int selFdPKId = 0;
			for (Food fd : frm.foodMenuList ) {
				if( fd.getName().equals(btn.getToolTipText()) ) {
					System.out.println(
						"���� ���� ����:" + fd);
					selFdPKId = fd.getId(); // <<PK>>
					dlg.selFood = fd; // ���� ���õ� ����
					break;
				}
			} 
			if( selFdPKId != 0 ) {
				dlg.cdlay.show(
					dlg.pnMenu, "card"+selFdPKId);
				// "card"+����PK�� Ű�� ���� ī���г��� ǥ��
			}
			// ��ȭ���ڿ��� ��Ŀ�� �̵�
			dlg.requestFocus();
		}
		
	}

}
