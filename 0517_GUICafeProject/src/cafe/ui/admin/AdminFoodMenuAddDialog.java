package cafe.ui.admin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.data.Food;
import db.mgr.FoodDBMgr;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminFoodMenuAddDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JLabel lbMenuImgDetail;
	JComboBox comboCate;
	JLabel lbMenuImgPath;
	JSpinner spinMenuPrice;
	JTextArea taMenuDesc;
	JRadioButton rdFoodHot; // hot select.
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			AdminFoodMenuAddDialog dialog = new AdminFoodMenuAddDialog();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	CafeAdminFrame frm;
	private JTextField txtFoodName;
	private final ButtonGroup grpHotIce = new ButtonGroup();
	AdminFoodMenuAddDialog dlg;
	
	
	public AdminFoodMenuAddDialog(CafeAdminFrame frm) {
		super(frm, true);
		setTitle("\uC2E0\uADDC \uC74C\uC2DD \uBA54\uB274 \uCD94\uAC00");
		this.frm = frm;
		this.dlg = this;
		setBounds(100, 100, 615, 501);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.6);
		splitPane.setOneTouchExpandable(true);
		getContentPane().add(splitPane, BorderLayout.CENTER);
		
		//getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(6, 2, 0, 0));
		splitPane.setLeftComponent(contentPanel);
		{
			JLabel lblNewLabel = new JLabel("\uBA54\uB274 \uC774\uB984:");
			contentPanel.add(lblNewLabel);
		}
		{
			txtFoodName = new JTextField();
			contentPanel.add(txtFoodName);
			txtFoodName.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("\uBA54\uB274 \uCE74\uD14C\uACE0\uB9AC:");
			contentPanel.add(lblNewLabel_1);
		}
		{
			//JComboBox comboCate = new JComboBox();
			comboCate = new JComboBox();
			comboCate.setMaximumRowCount(3);
			comboCate.setModel(new DefaultComboBoxModel(new String[] {"\uC74C\uC2DD", "\uC74C\uB8CC", "\uCEE4\uD53C"}));
			comboCate.setSelectedIndex(0);
			contentPanel.add(comboCate);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("\uBA54\uB274 \uC0AC\uC9C4:");
			contentPanel.add(lblNewLabel_2);
		}
		{
			JPanel pnMenuImage = new JPanel();
			pnMenuImage.setBackground(Color.PINK);
			contentPanel.add(pnMenuImage);
			pnMenuImage.setLayout(new BorderLayout(0, 0));
			
			JLabel lbMenuImg = new JLabel("");
			pnMenuImage.add(lbMenuImg, BorderLayout.CENTER);
			
			{
				//JLabel lbMenuImgPath = new JLabel("no path");
				lbMenuImgPath = new JLabel("no path");
				lbMenuImgPath.setToolTipText("\uD074\uB9AD \uD558\uC5EC \uC774\uBBF8\uC9C0 \uC120\uD0DD\uD558\uAE30...");
				lbMenuImgPath.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// 음식 메뉴의 사진 이미지 파일 경로 얻어오기...
						final String currentDirPath
						 = "./images/menu_thumb";
						final String currentDirPathDetail
						 = "./images/menu_detail";
						JFileChooser openDlg // 공용 파일대화상자
						 = new JFileChooser(currentDirPath);
//						openDlg.showOpenDialog(parent); // 읽기 
//						openDlg.showSaveDialog(parent); // 쓰기					
						if( openDlg.showOpenDialog(dlg) 
								== JFileChooser.APPROVE_OPTION ) {
							File imgFile = openDlg.getSelectedFile();
								// 선택된 파일
							System.out.println("선택된 파일명: " +  imgFile.getName());
							System.out.println("선택된 파일경로명: " +  imgFile.getPath());
							
							String dbImgPath
								= currentDirPath + "/" + imgFile.getName();
							lbMenuImgPath.setText(dbImgPath);
							lbMenuImgPath.setToolTipText("이미지 경로: " + imgFile.getPath());
							// 42x42 아이콘
							ImageIcon ic = new ImageIcon(imgFile.getPath());
							Image icImg = ic.getImage()
								.getScaledInstance(42, 42, Image.SCALE_SMOOTH);
							ic.setImage(icImg);
							lbMenuImg.setIcon(ic);
							lbMenuImg.repaint();
							// 오리지널 상세 이미지 detail
							dlg.lbMenuImgDetail.setText("");
							dlg.lbMenuImgDetail.setIcon(
									new ImageIcon(currentDirPathDetail 
											+ "/" + imgFile.getName()));
							dlg.lbMenuImgDetail.repaint();
							
						} else {
							System.out.println("파일 선택 못함...안함..");
							lbMenuImgPath.setText("no image!!");
							dlg.lbMenuImgDetail.setText("이미지 없음");
							dlg.lbMenuImgDetail.setIcon(null);// 이미지표시x
							dlg.lbMenuImgDetail.repaint();
						}
					}
				});
				lbMenuImgPath.setForeground(Color.GREEN);
				pnMenuImage.add(lbMenuImgPath, BorderLayout.SOUTH);
			}
//			{
//				JLabel lbMenuImg = new JLabel("");
//				pnMenuImage.add(lbMenuImg, BorderLayout.CENTER);
//			}
		}
		{
			JLabel lblNewLabel_3 = new JLabel("\uBA54\uB274 \uC124\uBA85:");
			contentPanel.add(lblNewLabel_3);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane);
			{
				//JTextArea taMenuDesc = new JTextArea();
				taMenuDesc = new JTextArea();
				scrollPane.setViewportView(taMenuDesc);
			}
		}
		{
			JLabel lblNewLabel_4 = new JLabel("\uBA54\uB274 \uAC00\uACA9:");
			contentPanel.add(lblNewLabel_4);
		}
		{
			//JSpinner spinMenuPrice = new JSpinner();
			spinMenuPrice = new JSpinner();
			spinMenuPrice.setModel(new SpinnerNumberModel(new Integer(1000), new Integer(100), null, new Integer(100)));
			contentPanel.add(spinMenuPrice);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("\uD56B/\uC544\uC774\uC2A4:");
			contentPanel.add(lblNewLabel_5);
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(new GridLayout(1, 2, 0, 0));
			{
//				JRadioButton rdFoodHot = new JRadioButton("HOT");
				rdFoodHot = new JRadioButton("HOT");
				rdFoodHot.setSelected(true);
				grpHotIce.add(rdFoodHot);
				rdFoodHot.setHorizontalAlignment(SwingConstants.CENTER);
				rdFoodHot.setForeground(Color.RED);
				panel.add(rdFoodHot);
			}
			{
				JRadioButton rdFoodIce = new JRadioButton("ICE");
				grpHotIce.add(rdFoodIce);
				rdFoodIce.setHorizontalAlignment(SwingConstants.CENTER);
				rdFoodIce.setForeground(Color.BLUE);
				panel.add(rdFoodIce);
			}
		}
		{
			JPanel panel = new JPanel();
			splitPane.setRightComponent(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				//JLabel lbMenuImgDetail = new JLabel("\uC774\uBBF8\uC9C0 \uC5C6\uC74C");
				lbMenuImgDetail = new JLabel("\uC774\uBBF8\uC9C0 \uC5C6\uC74C");
				lbMenuImgDetail.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lbMenuImgDetail, BorderLayout.CENTER);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnFoodAdd = new JButton("\uBA54\uB274 \uCD94\uAC00");
				btnFoodAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// food 재료 (입력값들)를 ui에서 가져오기
						String fdname = dlg.txtFoodName.getText();
						String fdcategory = 
								(String) dlg.comboCate.getSelectedItem();
						String fdimagePath = dlg.lbMenuImgPath.getText();
						int fdprice = (int) dlg.spinMenuPrice.getValue();
						int fdhotIce = dlg.rdFoodHot
								.isSelected() ? Food.TEMP_HOT: Food.TEMP_ICE;
						String fddescription = dlg.taMenuDesc.getText();
						// 재료들을 중간 생성자로 묶어서 하나의 데이터 객체로 저장..
						Food fd = new Food(fdname, 
								fdcategory, fdimagePath, 
								fdprice, fdhotIce, fddescription); 
						// db 중개자를 통해 실제 db에 데이터 객체를 SQL로 변환하여 insert 하기
						FoodDBMgr mgr = new FoodDBMgr();
						if( mgr.addNewOneFood(fd) ) {
							System.out.println("추가 성공! " + fd);
							dlg.setVisible(false);
							frm.showFoodTableUIFromDB(); 
							 // 새로 추가된 음식 레코드 포함한 foods 테이블을 조회하여 
							 // UI table에 다시 표시해주세요..  
							dlg.dispose();
						} else {
							; // ??
						}
					}
				});
				btnFoodAdd.setActionCommand("OK");
				buttonPane.add(btnFoodAdd);
				getRootPane().setDefaultButton(btnFoodAdd);
			}
			{
				JButton cancelButton = new JButton("\uCDE8\uC18C");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}


/*
파일 선택 못함...안함..
선택된 파일명: 흑당밀크티.PNG
선택된 파일경로명: C:\dev2021\java_ws\GUICafeProject\images\menu_thumb\흑당밀크티.PNG
*/