package UI.awt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetButtonHandler implements ActionListener {	
	AwtGuiMain7 frm;	
	public ResetButtonHandler(AwtGuiMain7 frm) {
		this.frm = frm;// 프레임창의 주소를 필드에 기억시킴.
	}	
	// 버튼 눌릴 때(이벤트) 마다 자동으로 호출되는 이벤트 처리함수(핸들러) 
	@Override
	public void actionPerformed(ActionEvent e) {		
		String oldHello = frm.txtHello.getText(); // 기존 텍스트
		String oldHuman = frm.txtHuman.getText();
		System.out.println(">> 리셋 버튼 눌렸음!! 기존내용 : " + 
				oldHello + " " + oldHuman);
		// 두 개의 텍스트 필드를 비우기 ""
		frm.txtHello.setText("");
		frm.txtHuman.setText("");
	}

}
