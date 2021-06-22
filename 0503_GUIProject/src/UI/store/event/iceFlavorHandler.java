package UI.store.event;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;
import javax.swing.JCheckBox;
import UI.store.IcecreamStoreFrame;

public class iceFlavorHandler implements ItemListener {

	IcecreamStoreFrame frm;

	public iceFlavorHandler(IcecreamStoreFrame frm) {
		this.frm = frm;
	}

	@Override
	public void itemStateChanged(ItemEvent ie) {
//		System.out.println("������ ���°� �ٲ�����ϴ�! " + new Date());
		JCheckBox cb = (JCheckBox) ie.getItemSelectable();
		for (int i = 0; i < frm.cbIceFlavors.length; i++) {
			if (cb == frm.cbIceFlavors[i]) { // ���ϼ� ��
				System.out.print(i + "��° ���̽�ũ�� üũ�ڽ� ");
				if (ie.getStateChange() == ItemEvent.SELECTED) {
					System.out.println(IcecreamStoreFrame.ICE_NAMES[i] + " ��ٱ��Ͽ� �߰���~~~~");
					frm.selIcecreamList.add(i);
				} else if (ie.getStateChange() == ItemEvent.DESELECTED) {
					System.out.println(IcecreamStoreFrame.ICE_NAMES[i] + " ��ٱ��Ͽ� ������~~~~");
					int rmPos = -1;
					rmPos = frm.selIcecreamList.indexOf(i);
					frm.selIcecreamList.remove(rmPos);
				} else {
					System.out.println("????");
				}
				frm.lbStatus.setText(">> ���õ� ���̽�ũ�� ����: " + frm.selIcecreamList.size() + "��");
			}
		}
	}
}
