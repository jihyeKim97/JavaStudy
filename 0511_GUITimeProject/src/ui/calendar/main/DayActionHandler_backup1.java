package ui.calendar.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import ui.calendar.main.db.TodoDBMgr;
import ui.calendar.main.db.data.Todo;

public class DayActionHandler_backup1 implements ActionListener {
	GuiCalendarFrame6 frm;
	
	public DayActionHandler_backup1(GuiCalendarFrame6 frm) {
		this.frm = frm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton dayBtn = (JButton) e.getSource();
		// 년년년년-월월-일일 
//		String strYear = frm.getTxtYear().getText();
		String strYear = frm.getTxtYearText().trim();
		String strMonth = frm.getTxtMonth().getText().trim();		
		String strDay = dayBtn.getText().trim();
		
		if( strMonth.length() == 1 ) strMonth = "0" + strMonth;
		if( strDay.length() == 1 ) strDay = "0" + strDay;
		String strDate = strYear + "-" 
					+ strMonth + "-" + strDay; 
		
		System.out.println("날자 버튼 눌렀음! " + strDate );
		
		// strDate 특정 날자만 DB에 적용!!
		
		TodoDBMgr tdMgr = new TodoDBMgr(); // beginConnection()
		
     	ArrayList<Todo> todos =	tdMgr.selectAllTodos();
     	for (Todo td : todos) {
     		System.out.println(td.toList());
     	}
     	tdMgr.endConnection();
	}

}

/*
날자 버튼 눌렀음! 2021-05-14
DB 접속 성공! Fri May 14 13:07:22 KST 2021
DB에서 조회한 todo 개수: 9
[ ] #7 | 만섭씨랑 스테이크 먹기 | 1. 약속 | 진영 | 2021-05-14 | 
[ ] #23 | 파인애플 구매 | 3. 구매 | 진영 | 2021-05-14 | 
[ ] #50 | 파인애플 구매 | 3. 구매 | 진영 | 2021-05-14 | 
[ ] #22 | 수박 구매 | 3. 구매 | 진영 | 2021-05-14 | 
[ ] #21 | 수박 구매 | 3. 구매 | 진영 | 2021-05-14 | 
[ ] #5 | 삼겹살 구매 | 3. 구매 | 진영 | 2021-05-13 | 
[ ] #6 | 삼겹살 구매 | 3. 구매 | 진영 | 2021-05-13 | 
[ ] #4 | 삼겹살 구매 | 3. 구매 | 진영 | 2021-05-13 | 
[ ] #3 | 삼겹살 구매 | 3. 구매 | 진영 | 2021-05-13 | 
DB 종료 성공!!
날자 버튼 눌렀음! 2021-05-06
DB 접속 성공! Fri May 14 13:07:34 KST 2021
DB에서 조회한 todo 개수: 9
[ ] #7 | 만섭씨랑 스테이크 먹기 | 1. 약속 | 진영 | 2021-05-14 | 
[ ] #23 | 파인애플 구매 | 3. 구매 | 진영 | 2021-05-14 | 
[ ] #50 | 파인애플 구매 | 3. 구매 | 진영 | 2021-05-14 | 
[ ] #22 | 수박 구매 | 3. 구매 | 진영 | 2021-05-14 | 
[ ] #21 | 수박 구매 | 3. 구매 | 진영 | 2021-05-14 | 
[ ] #5 | 삼겹살 구매 | 3. 구매 | 진영 | 2021-05-13 | 
[ ] #6 | 삼겹살 구매 | 3. 구매 | 진영 | 2021-05-13 | 
[ ] #4 | 삼겹살 구매 | 3. 구매 | 진영 | 2021-05-13 | 
[ ] #3 | 삼겹살 구매 | 3. 구매 | 진영 | 2021-05-13 | 
DB 종료 성공!!
*/