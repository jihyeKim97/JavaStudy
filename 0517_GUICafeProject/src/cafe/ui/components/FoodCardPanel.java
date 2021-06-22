package cafe.ui.components;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import db.data.Food;

import java.awt.Color;
import javax.swing.JTextArea;

public class FoodCardPanel extends JPanel {
//public class FoodCardPanel extends ImagePanel {
	Food fd;
	//
	JLabel lbFoodName;
	JLabel lbFoodCate;
	JLabel lbFoodImage;
	JTextArea taFoodDesc;
	JLabel lbFoodPrice;
	JLabel lbFoodHotIce;
	
	public FoodCardPanel(Food fd) {
		this.fd = fd;
		setLayout(null);
		
		lbFoodName = new JLabel("\uB354\uBBF8");
		lbFoodName.setHorizontalAlignment(SwingConstants.CENTER);
		lbFoodName.setFont(new Font("휴먼매직체", Font.PLAIN, 22));
		lbFoodName.setBounds(22, 10, 179, 25);
		this.add(lbFoodName);
	
		lbFoodCate = new JLabel("\uC885\uB958");
		lbFoodCate.setHorizontalAlignment(SwingConstants.CENTER);
		lbFoodCate.setFont(new Font("굴림", Font.BOLD, 18));
		lbFoodCate.setBounds(287, 0, 102, 26);
		this.add(lbFoodCate);
	
		lbFoodImage = new JLabel("");
		lbFoodImage.setBorder(new BevelBorder(BevelBorder.RAISED, Color.YELLOW, null, Color.ORANGE, null));
		lbFoodImage.setBounds(22, 32, 188, 182);
		this.add(lbFoodImage);
				
		taFoodDesc = new JTextArea();
		taFoodDesc.setBounds(234, 32, 188, 182);
		this.add(taFoodDesc);
		
		lbFoodPrice = new JLabel("\uAC00\uACA9: 1000\uC6D0");
		lbFoodPrice.setFont(new Font("굴림", Font.BOLD, 18));
		lbFoodPrice.setBounds(32, 226, 159, 15);
		this.add(lbFoodPrice);
		
		lbFoodHotIce = new JLabel("HOT");
		lbFoodHotIce.setHorizontalAlignment(SwingConstants.CENTER);
		lbFoodHotIce.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 18));
		lbFoodHotIce.setForeground(Color.RED);
		lbFoodHotIce.setBounds(301, 224, 57, 15);
		this.add(lbFoodHotIce);

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
