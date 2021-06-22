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
		// �����-����-���� 
//		String strYear = frm.getTxtYear().getText();
		String strYear = frm.getTxtYearText().trim();
		String strMonth = frm.getTxtMonth().getText().trim();		
		String strDay = dayBtn.getText().trim();
		
		if( strMonth.length() == 1 ) strMonth = "0" + strMonth;
		if( strDay.length() == 1 ) strDay = "0" + strDay;
		String strDate = strYear + "-" 
					+ strMonth + "-" + strDay; 
		
		System.out.println("���� ��ư ������! " + strDate );
		
		// strDate Ư�� ���ڸ� DB�� ����!!
		
		TodoDBMgr tdMgr = new TodoDBMgr(); // beginConnection()
		
     	ArrayList<Todo> todos =	tdMgr.selectAllTodos();
     	for (Todo td : todos) {
     		System.out.println(td.toList());
     	}
     	tdMgr.endConnection();
	}

}

/*
���� ��ư ������! 2021-05-14
DB ���� ����! Fri May 14 13:07:22 KST 2021
DB���� ��ȸ�� todo ����: 9
[ ] #7 | �������� ������ũ �Ա� | 1. ��� | ���� | 2021-05-14 | 
[ ] #23 | ���ξ��� ���� | 3. ���� | ���� | 2021-05-14 | 
[ ] #50 | ���ξ��� ���� | 3. ���� | ���� | 2021-05-14 | 
[ ] #22 | ���� ���� | 3. ���� | ���� | 2021-05-14 | 
[ ] #21 | ���� ���� | 3. ���� | ���� | 2021-05-14 | 
[ ] #5 | ���� ���� | 3. ���� | ���� | 2021-05-13 | 
[ ] #6 | ���� ���� | 3. ���� | ���� | 2021-05-13 | 
[ ] #4 | ���� ���� | 3. ���� | ���� | 2021-05-13 | 
[ ] #3 | ���� ���� | 3. ���� | ���� | 2021-05-13 | 
DB ���� ����!!
���� ��ư ������! 2021-05-06
DB ���� ����! Fri May 14 13:07:34 KST 2021
DB���� ��ȸ�� todo ����: 9
[ ] #7 | �������� ������ũ �Ա� | 1. ��� | ���� | 2021-05-14 | 
[ ] #23 | ���ξ��� ���� | 3. ���� | ���� | 2021-05-14 | 
[ ] #50 | ���ξ��� ���� | 3. ���� | ���� | 2021-05-14 | 
[ ] #22 | ���� ���� | 3. ���� | ���� | 2021-05-14 | 
[ ] #21 | ���� ���� | 3. ���� | ���� | 2021-05-14 | 
[ ] #5 | ���� ���� | 3. ���� | ���� | 2021-05-13 | 
[ ] #6 | ���� ���� | 3. ���� | ���� | 2021-05-13 | 
[ ] #4 | ���� ���� | 3. ���� | ���� | 2021-05-13 | 
[ ] #3 | ���� ���� | 3. ���� | ���� | 2021-05-13 | 
DB ���� ����!!
*/