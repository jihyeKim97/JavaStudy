package UI.store;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import UI.store.event.iceFlavorHandler;

public class IcecreamStoreFrame extends JFrame implements ActionListener, ItemListener {

	public static final Font ftIce = new Font("굴림", Font.ITALIC, 24);
	public static final Font ftBig = new Font("굴림", Font.BOLD, 24);
	public static final String[] ICE_NAMES = { "러브미", "메이플", "블랙소르배", "슈팅스타", "아빠는딸바봉", "아이스홈런볼", "엄마는외계인", "오레오쿠키",
			"치즈러브", "트리플민초", "해피버스데이" };
	public static final String[] ICE_BUNDLE_NAMES = { "싱글콘", "더블콘", "트리플컵", "쿼터컵", "패미리컵", "해프갤론컵" };
	public static final int[] ICE_BUNDLE_LIMITS = { 1, 2, 3, 4, 6, 8 };
	public static final int DEF_BUNDLE = 1;

	JLabel lbTitle;
	public JLabel lbStatus;
	JButton btnCheckOut; // 주문하기/결제 버튼
	public JCheckBox[] cbIceFlavors;
	JRadioButton[] rdBundles;
	int nBundle;
	public ArrayList<Integer> selIcecreamList;
	JLabel lbIceBundle;

	class BundleSizeHanlder implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			// 내부 / 내장 클래스 정의 (inner class/ nested class)
			// this. // 여기서의 디스는 이너 오브젝트의 디스임
			JRadioButton rd = (JRadioButton) e.getItemSelectable();
			// if(e.getStateChange() == ItemEvent.SELECTED){
			// System.out.println(rd.getText()); // 배타성
			// }
			if (rd.isSelected() == true) {
				System.out.println(rd.getText());
				ChangeBundleSize(rd.getText());
			}
		}
	}

	public void ChangeBundleSize(String bundleName) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("싱글콘", "Single");
		map.put("더블콘", "Double");
		map.put("트리플컵", "Triple");
		map.put("쿼터컵", "Quarter");
		map.put("패미리컵", "Family");
		map.put("해프갤론컵", "Half-Gallon");

		String changedBundleName;
		String cntBundel = "";
		if (map.containsKey(bundleName)) {
			changedBundleName = map.get(bundleName);
			int limit = 0;
			for (int i = 0; i < ICE_BUNDLE_NAMES.length; i++) {
				String name = ICE_BUNDLE_NAMES[i];
				if (name.equals(bundleName)) {
					this.nBundle = i;
					limit = ICE_BUNDLE_LIMITS[i];
					break;
				}
			}
			cntBundel = limit + "가지 맛";
		} else {
			System.out.println(">> 없는 번들키: " + bundleName);
			changedBundleName = "double";
			cntBundel = "2가지 맛";
			this.nBundle = DEF_BUNDLE;
		}
		String filename = "./store/bundle/" + changedBundleName + ".PNG";
		ImageIcon icBundle = new ImageIcon(filename);
		lbIceBundle.setIcon(icBundle);
		lbIceBundle.setText(changedBundleName + " " + cntBundel);

	}

	public IcecreamStoreFrame() {
		super("마이 아이스크림 스토어");
		setBounds(100, 100, 1200, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImageIcon icLogo = new ImageIcon("./store/logo2.PNG");
		this.lbTitle = new JLabel("크림 주문하기");
		lbTitle.setFont(ftBig);
		lbTitle.setHorizontalAlignment(JLabel.CENTER);
		lbTitle.setIcon(icLogo);

		JPanel pnBundles = new JPanel(new GridLayout(1, 2));
		pnBundles.setBackground(Color.pink);
		pnBundles.setBorder(new LineBorder(Color.orange, 3, true));
		rdBundles = new JRadioButton[ICE_BUNDLE_NAMES.length];
		JPanel pnLeft = new JPanel(new BorderLayout());
		JPanel pnRight = new JPanel(new BorderLayout());
		JPanel pnIces = new JPanel(new GridLayout(2, 3));
		ButtonGroup rdGrp = new ButtonGroup();
		BundleSizeHanlder bundleSizeHanlder = new BundleSizeHanlder();

		for (int i = 0; i < ICE_BUNDLE_NAMES.length; i++) {
			JRadioButton bundle = new JRadioButton(ICE_BUNDLE_NAMES[i]);
			bundle.setFont(ftBig);
			bundle.setToolTipText(ICE_BUNDLE_LIMITS[i] + "가지의 맛!");
			pnIces.add(bundle);
			rdBundles[i] = bundle;
			rdGrp.add(bundle);

			bundle.addItemListener(bundleSizeHanlder);
		}
		JLabel lbSubTitle = new JLabel(":: 번들 종류 ::");
		lbSubTitle.setFont(ftIce);
		lbSubTitle.setHorizontalAlignment(JLabel.CENTER);
		pnLeft.add(lbSubTitle, BorderLayout.NORTH);
		pnLeft.add(pnIces, BorderLayout.CENTER);
		this.nBundle = DEF_BUNDLE;
		ImageIcon icDouble = new ImageIcon("./store/bundle/double.PNG");
		lbIceBundle = new JLabel("double 2가지맛", icDouble, JLabel.CENTER);
		rdBundles[nBundle].setSelected(true);
		JLabel lbSubBundle = new JLabel(":: 번들 종류(맛의 수) ::");
		lbSubBundle.setHorizontalAlignment(JLabel.CENTER);
		lbSubBundle.setFont(ftIce);
		pnRight.add(lbSubBundle, BorderLayout.NORTH);
		pnRight.add(lbIceBundle, BorderLayout.CENTER);
		pnBundles.add(pnLeft);
		pnBundles.add(pnRight);

		JPanel pnIcecreams = new JPanel(new GridLayout(4, 3, 6, 6));
		pnIcecreams.setBackground(Color.CYAN);
		pnIcecreams.setBorder(new EtchedBorder());
		cbIceFlavors = new JCheckBox[ICE_NAMES.length];

		for (int i = 0; i < ICE_NAMES.length; i++) {
			JCheckBox iceChk = new JCheckBox(ICE_NAMES[i]);
			iceChk.setFont(ftIce);
			iceChk.setIcon(new ImageIcon("./store/icecreams_sized/" + ICE_NAMES[i] + ".png"));
			iceChk.setSelectedIcon(new ImageIcon("./store/icecreams_sel/" + ICE_NAMES[i] + ".png"));
			pnIcecreams.add(iceChk);
			this.cbIceFlavors[i] = iceChk;
		}

		this.lbStatus = new JLabel("상태바 ::");
		this.setFont(new Font("굴림", Font.PLAIN, 22));
		this.btnCheckOut = new JButton("아이스크림 주문!!");

		JPanel pnCenter = new JPanel(new BorderLayout(5, 5));

		pnCenter.add(pnBundles, BorderLayout.NORTH);
		pnCenter.add(pnIcecreams, BorderLayout.CENTER);
		pnCenter.add(btnCheckOut, BorderLayout.SOUTH);
		add(lbTitle, BorderLayout.NORTH);
		add(pnCenter, BorderLayout.CENTER);
		add(lbStatus, BorderLayout.SOUTH);

		this.selIcecreamList = new ArrayList<>();
		lbStatus.setText(">> 선택된 아이스크림 개수: 0개");

		iceFlavorHandler ifh = new iceFlavorHandler(this);

		btnCheckOut.addActionListener(this);
		for (int i = 0; i < cbIceFlavors.length; i++) {
			JCheckBox cbIceF = cbIceFlavors[i];
			cbIceF.addItemListener(ifh);
		}

		setVisible(true);
	}

	public static void main(String[] args) {
		IcecreamStoreFrame store = new IcecreamStoreFrame();
	}
	public static  final int BUNDLE_OVER = 1;
	public static  final int BUNDLE_MATCH= 2;
	public static  final int BUNDLE_UNDER= 3;
	
	public int compareBundleSizeForLimit() {
		int bdSize = this.selIcecreamList.size();
		int bdList = ICE_BUNDLE_LIMITS[nBundle];
		System.out.println("( 장바구니 : " +bdSize+"    /    리미트 : "+bdList+")");
		if(bdSize > bdList) {
			System.out.println("장바구니 넘침");
			return BUNDLE_OVER;
		}else if(bdSize < bdList) {
			System.out.println("장바구니 부족");
			return BUNDLE_UNDER;
		}else {
			System.out.println("주문가능~!");
			return BUNDLE_MATCH;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int comp = compareBundleSizeForLimit();
		if(comp == BUNDLE_MATCH) {
			System.out.println("-----------------------------");
			System.out.println("주문 번호 : "+(long)Math.random()*10000000L);
			System.out.println("주문 일시: "+new Date());
			System.out.println(">> 장바구니 크기: " + selIcecreamList.size());
			lbStatus.setText(">> 선택된 아이스크림 개수: " + selIcecreamList.size() + "개");
			for (int selIceOrder : selIcecreamList) {
				System.out.println(selIceOrder + " : " + ICE_NAMES[selIceOrder]);
			}
			System.out.println("-----------------------------");
		}else {
			System.out.println("**********아이스크림의 맛의 수에 맞게 담아주세여");
		}
	}

	@Override
	public void itemStateChanged(ItemEvent ie) {
		System.out.println("아이템 상태가 바뀌었습니다! " + new Date());
		JCheckBox cb = (JCheckBox) ie.getItemSelectable();
		for (int i = 0; i < cbIceFlavors.length; i++) {
			if (cb == cbIceFlavors[i]) { // 동일성 비교
				System.out.print(i + "번째 아이스크림 체크박스 ");
				if (ie.getStateChange() == ItemEvent.SELECTED) {
					System.out.println(ICE_NAMES[i] + " 장바구니에 추가됨.");
					selIcecreamList.add(i);
				} else if (ie.getStateChange() == ItemEvent.DESELECTED) {
					System.out.println(ICE_NAMES[i] + " 장바구니에 삭제됨.");
					int rmPos = -1;
					rmPos = selIcecreamList.indexOf(i);
					selIcecreamList.remove(rmPos);
				} else {
					System.out.println("????");
				}
				lbStatus.setText(">> 선택된 아이스크림 개수: " + selIcecreamList.size() + "개");
			}
		}
	}

}
