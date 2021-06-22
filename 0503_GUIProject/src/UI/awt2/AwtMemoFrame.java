package UI.awt2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.TextField;

public class AwtMemoFrame extends Frame {
	// ��� ����
	public static final Font ftNormal = new Font("����", Font.PLAIN, 24);
	public static final Font ftMedium = new Font("����", Font.PLAIN | Font.ITALIC, 32);
	public static final Font ftBig = new Font("����", Font.BOLD, 48);
	public static final Color crAccent = Color.ORANGE;
	public static final Color crSub = new Color(128, 0, 200);

	// �ʵ� ���� (UI ������Ʈ)
	// ���� ���̺�
	private Label lbTitle;
	// �߾� �ؽ�Ʈ �Է�?
	private TextField txtMemo;
	// �ϴ� ���� ���̺�
	private Label lbStatus; // �������ͽ� ��

	public AwtMemoFrame() {
		super("�������");
	}

	public AwtMemoFrame(String title) {
		// ������ â ����....
		super(title);
//		this.setSize(480, 480); // ũ��
//		this.setLocation(100, 100); // ��ġ
		this.setBounds(100, 100, 480, 480);
		// setSize() + setLocation() �� ����... �ٿ��~
//		setBounds(new Rectangle(100, 100, 480, 480));
		setBackground(Color.gray);
		setResizable(false); // â ũ�� ���� �Ұ��� ����

		// â (��ġ) ���̾ƿ� ������
		// Frame�� ���ο� �⺻ ��ġ�����ڷ� Borderlayout ����.1
//		this.setLayout(new BorderLayout()); // ����

		// ������Ʈ �غ� Ȥ�� ����
		this.lbTitle = new Label("����: ");
		txtMemo = new TextField("�޸� �Է��ϼ���!", 40);
		this.lbStatus = new Label("���¹�: ", Label.LEFT);

		lbTitle.setFont(ftBig);
		txtMemo.setFont(ftNormal);
		txtMemo.setFont(ftMedium);

		// â�� ������Ʈ���� ��ġ
		this.add(lbTitle, BorderLayout.NORTH);
		this.add(txtMemo, BorderLayout.CENTER);
		this.add(lbStatus, BorderLayout.SOUTH);

		// â ���̱�
		this.setVisible(true);
	}

	public static void main(String[] args) {
		AwtMemoFrame frm = new AwtMemoFrame("���� �޸���1");
		// frm.setVisible(true);
	}

}
