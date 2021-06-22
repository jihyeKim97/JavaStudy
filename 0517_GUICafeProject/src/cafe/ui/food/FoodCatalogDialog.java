package cafe.ui.food;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.data.Food;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JTextArea;

public class FoodCatalogDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	FoodMenuFrame frm;
	Food fd;
	//
	JLabel lbFoodName;
	JLabel lbFoodCate;
	JLabel lbFoodImage;
	JTextArea taFoodDesc;
	JLabel lbFoodPrice;
	JLabel lbFoodHotIce;
	// 
	public FoodCatalogDialog(FoodMenuFrame frm,
			 Food food) {
		super(frm, false); // modaless
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("\uC74C\uC2DD \uC0C1\uC138\uBCF4\uAE30 \uCE74\uD0C8\uB85C\uADF8");
		this.frm = frm;
		this.fd = food;
		setBounds(100, 100, 450, 347);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lbFoodName = new JLabel("\uB354\uBBF8");
			lbFoodName.setHorizontalAlignment(SwingConstants.CENTER);
			lbFoodName.setFont(new Font("휴먼매직체", Font.PLAIN, 22));
			lbFoodName.setBounds(22, 10, 179, 25);
			contentPanel.add(lbFoodName);
		}
		{
			lbFoodCate = new JLabel("\uC885\uB958");
			lbFoodCate.setHorizontalAlignment(SwingConstants.CENTER);
			lbFoodCate.setFont(new Font("굴림", Font.BOLD, 18));
			lbFoodCate.setBounds(287, 0, 102, 26);
			contentPanel.add(lbFoodCate);
		}
		{
			lbFoodImage = new JLabel("");
			lbFoodImage.setBorder(new BevelBorder(BevelBorder.RAISED, Color.YELLOW, null, Color.ORANGE, null));
			lbFoodImage.setBounds(22, 32, 188, 182);
			contentPanel.add(lbFoodImage);
		}
		
		taFoodDesc = new JTextArea();
		taFoodDesc.setBounds(234, 32, 188, 182);
		contentPanel.add(taFoodDesc);
		
		lbFoodPrice = new JLabel("\uAC00\uACA9: 1000\uC6D0");
		lbFoodPrice.setFont(new Font("굴림", Font.BOLD, 18));
		lbFoodPrice.setBounds(32, 226, 159, 15);
		contentPanel.add(lbFoodPrice);
		
		lbFoodHotIce = new JLabel("HOT");
		lbFoodHotIce.setHorizontalAlignment(SwingConstants.CENTER);
		lbFoodHotIce.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 18));
		lbFoodHotIce.setForeground(Color.RED);
		lbFoodHotIce.setBounds(301, 224, 57, 15);
		contentPanel.add(lbFoodHotIce);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton btnNewButton_3 = new JButton("<<");
			buttonPane.add(btnNewButton_3);
			
			JButton btnNewButton_2 = new JButton(">>");
			buttonPane.add(btnNewButton_2);
			
			JButton btnNewButton_1 = new JButton("\uC88B\uC544\uC694");
			buttonPane.add(btnNewButton_1);
			
			JButton btnNewButton = new JButton("\uC8FC\uBB38\uD558\uAE30");
			buttonPane.add(btnNewButton);
		}
		
		// ui에 data 반영하기 
		showFoodDataToUI(fd);
	}
	
	public  void showFoodDataToUI(Food fd) {
		this.lbFoodName.setText(fd.getName());
		this.lbFoodCate.setText(fd.getCategory());
		
		//String filename = fd.getImagePath();
		String filename = fd.getImagePath()
				.replace("thumb", "detail");
		ImageIcon ic = new ImageIcon(filename);
		// 이미지를 재스케일링
		Image scaled = ic.getImage()
			.getScaledInstance(lbFoodImage.getWidth(),
					lbFoodImage.getHeight(), 
					Image.SCALE_FAST); 
		ic.setImage(scaled);
		this.lbFoodImage.setIcon(ic);
		this.lbFoodImage.repaint(); // 중요!!
		
		this.taFoodDesc.setText(fd.getDescription());
		this.lbFoodPrice.setText("가격: " +fd.getPrice()+"원");
		this.lbFoodHotIce.setText( 
			fd.getHotIce() == Food.TEMP_HOT ? "HOT": "ICE" );
		this.lbFoodHotIce.setForeground(
			fd.getHotIce() == Food.TEMP_HOT ? 
					Color.red : Color.blue	);
	}
}



