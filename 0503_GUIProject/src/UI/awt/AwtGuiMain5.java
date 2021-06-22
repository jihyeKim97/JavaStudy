package UI.awt;

import java.awt.*;
import java.awt.event.*;

// Object > Component > Container > Window
// 		> Frame > AwtGuiMain5
public class AwtGuiMain5 extends Frame implements ActionListener {
	// GUI â�� ������ �ڿ�(�÷�,��Ʈ,ũ��,��ġ,���,�̹���..)

	// GUI â�� ������ �ڿ�(�÷�,��Ʈ,ũ��,��ġ,���,�̹���..)
	public static final Color crPink = Color.PINK;
	public static final Color crBlue = Color.BLUE;
	public static final Color crGreen = Color.GREEN;
	public static final Color crOrangle = Color.orange;
	public static final Color crRed = new Color(255, 0, 0);
	public static final Font ftNormal = new Font("����", Font.ITALIC, 30);
	public static final Font ftBig = new Font("�ü�ü", Font.BOLD, 60);
	public static final Font ftLabel = new Font("����", Font.PLAIN, 32);
	public static final Font ftButton = new Font("����", Font.BOLD | Font.ITALIC, 40);

	// ui ������Ʈ �ʵ� ���� (����ʵ�ȭ)
	TextField txtHello; 
	TextField txtHuman;
	Label lbResult; 

	// ������ (������â �ʱ�ȭ)
	public AwtGuiMain5() {
		//	super();
		// this.setTitle("������� â");
		super("������� â");
	}

	public AwtGuiMain5(String title) {

		// frame â ���� �ʱ�ȭ
		super(title); // �θ� frame������ ȣ�� �ʱ�ȭ
		
		// frame â�� ��ġ�� ũ�� ����
		setLocation(100, 100); // �»�� �������� �������� ������
		this.setSize(800, 480);
		
		//frame â�� Ŭ���̾�Ʈ ������ ������Ʈ�� ��ġ�ϱ����� ��ġ������ ����
		// �÷ο췹�̾ƿ� :  ������Ʈ���� ���� �������� ä�� �����ٰ� ���� �࿡�� ��Ը� ������ ���� �� ���� ������Ʈ���� ��ġ
		
		setLayout(new BorderLayout());

		Label lbTitle = new Label("*** �λ� �ϱ� ***");
		lbTitle.setFont(ftBig);
		lbTitle.setForeground(crBlue); 
		Label lbHello = new Label("Hello GUI!!");
		lbHello.setFont(ftNormal);
		Label lbHello2 = new Label("�ȳ��ϼ���?");
		lbHello2.setFont(ftNormal);

		this.lbResult = new Label("���: ", Label.LEFT);
		lbResult.setFont(new Font("����", Font.BOLD | Font.ITALIC, 38));
		lbResult.setBackground(Color.YELLOW);

//		TextField txtHello = new TextField(20);
		this.txtHello = new TextField(20);
		txtHello.setFont(ftNormal);
		txtHuman = new TextField("Mr. Park", 14);
		txtHuman.setFont(ftNormal);
		txtHuman.setForeground(Color.CYAN);
		txtHuman.setBackground(Color.DARK_GRAY);

		// button ������Ʈ
		Button btnGreet = new Button("GREET!");
		btnGreet.setForeground(crPink);
		btnGreet.setFont(new Font("Serif", Font.PLAIN, 22));

		// �� ��ư�� �̺�Ʈ�ڵ鷯�� �̺�Ʈ�� ����
		btnGreet.addActionListener(this);// ������ �ڽ�â �ڱ��ڽŰ�ü
		// ActionListener �̺�Ʈ �ڵ鷯 �Լ�
		// actionPerformed()�� ������ ��ü�� ���ڷ�...

//		this.add(lbTitle); // ���� ���̺� ��ü�� ���� ���� ǥ��
//		add(lbHello); // flowlayout������ add ������ �߿�.
//		this.add(lbHello2);		
//		this.add(txtHello);
//		add(txtHuman);
//		this.add(btnGreet);
//		add(lbResult);
		// this�� ������ �ڽ�â �ڱ��ڽŰ�ü

		Panel pn = new Panel(); // �г��� �⺻��ġ�� flowLayout
		pn.add(lbHello); // flowlayout������ add ������ �߿�.
		pn.add(lbHello2);
		pn.add(txtHello);
		pn.add(txtHuman);

		add(pn, BorderLayout.CENTER); // �г��� �߾ӿ� ��ġ
		add(lbTitle, BorderLayout.NORTH);
		add(btnGreet, BorderLayout.EAST);
		add(lbResult, BorderLayout.SOUTH);

		this.setBackground(crOrangle); // ����
//		this.setVisible(true); // AWTâ�� close x��ư ���� �ȵ�.
	}

	// ��ư Ŭ�� �̺�Ʈ ó��(handler) �Լ� (�̺�Ʈ�� ���� ��ι� �������̽��� �����ؾ� ��.)
	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println("Greet! ��ư�� �������!!" + new Date());
		// ��ư Ŭ��..
		String strHello = this.txtHello.getText();
		String strHumanName = this.txtHuman.getText();
		System.out.println(">> �λ��ϱ� " + strHello + " " + strHumanName + "~!!!"); // �ܼ�â ���
		this.lbResult.setText(">> �λ��ϱ� " + strHello + " " + strHumanName + "~!!!");
	}

	public static void main(String[] args) {
		AwtGuiMain5 frm1 = new AwtGuiMain5();
		frm1.setVisible(true); // show, hide
	}

}
