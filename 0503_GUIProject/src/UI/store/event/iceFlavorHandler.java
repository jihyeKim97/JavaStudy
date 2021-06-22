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
//		System.out.println("아이템 상태가 바뀌었습니다! " + new Date());
		JCheckBox cb = (JCheckBox) ie.getItemSelectable();
		for (int i = 0; i < frm.cbIceFlavors.length; i++) {
			if (cb == frm.cbIceFlavors[i]) { // 동일성 비교
				System.out.print(i + "번째 아이스크림 체크박스 ");
				if (ie.getStateChange() == ItemEvent.SELECTED) {
					System.out.println(IcecreamStoreFrame.ICE_NAMES[i] + " 장바구니에 추가됨~~~~");
					frm.selIcecreamList.add(i);
				} else if (ie.getStateChange() == ItemEvent.DESELECTED) {
					System.out.println(IcecreamStoreFrame.ICE_NAMES[i] + " 장바구니에 삭제됨~~~~");
					int rmPos = -1;
					rmPos = frm.selIcecreamList.indexOf(i);
					frm.selIcecreamList.remove(rmPos);
				} else {
					System.out.println("????");
				}
				frm.lbStatus.setText(">> 선택된 아이스크림 개수: " + frm.selIcecreamList.size() + "개");
			}
		}
	}
}
