package ui.calendar.main.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ui.calendar.main.GuiCalendarFrame6;
import ui.calendar.main.db.TodoDBMgr;
import ui.calendar.main.db.data.Member;
import ui.calendar.main.db.data.Todo;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TodoDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
//	public TodoDialog() {
//		
//	}
	
	GuiCalendarFrame6 frm;
	TodoDialog dlg;
	JTextArea taNewTodo;
	JComboBox comboTodoType;
	JTextArea textArea; // read-only
	
	public TodoDialog(GuiCalendarFrame6 frm, 
			String dbResult, String strDate, int nTdSize) {
		super(frm, true); // modal mode
		this.frm = frm; // 오우너 윈도우프레임 주소
		this.dlg = this; // 대화상자 자신
		setTitle(strDate + " 투두리스트: " +  
				 nTdSize + "개"	);
		setBounds(100, 100, 519, 239);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				//JTextArea textArea = new JTextArea();
				textArea = new JTextArea();
				textArea.setBackground(new Color(100, 149, 237));
				textArea.setLineWrap(true); // 행자동 줄바꿈
				textArea.setEditable(false); // 읽기전용
				scrollPane.setViewportView(textArea);
				textArea.setText(dbResult);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.LEFT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
//				JTextArea taNewTodo = new JTextArea();
				taNewTodo = new JTextArea();
				taNewTodo.setColumns(26);
				taNewTodo.setRows(2);
				buttonPane.add(taNewTodo);
			}
			{
//				JComboBox comboTodoType = new JComboBox();
				comboTodoType = new 
						JComboBox(
					new DefaultComboBoxModel<>(Todo.MTYPES));				
					// 	배열기반 모델 콤보 초기화
				buttonPane.add(comboTodoType);
				comboTodoType.setSelectedIndex(Todo.MT_PURCHASE);//3
			}
			{
				JButton btnTodoAdd = new JButton("\uD22C\uB450 \uB4F1\uB85D");
				btnTodoAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// 신규 투두 DB등록 처리
						String memo = dlg.taNewTodo.getText();
						String userName = Member.loggedIn; // dummy elsa 
						int memoType = 
								dlg.comboTodoType
									.getSelectedIndex(); 
//						String strDate;
						
						TodoDBMgr tdMgr = new TodoDBMgr();
						
						boolean b = tdMgr.insertNewTodoOnDay(memo, userName,
									memoType, strDate);
						
						if( b ) { // insert로 추가된 todo 레코드를 포함해서 다시 조회...
							System.out.println("todo 추가!! success");
							ArrayList<Todo> tdList = tdMgr.selectAllTodos(strDate);						
							System.out.println("todo 실패!! fail");
							String temp = "";
							if( tdList != null && tdList.size() > 0 ) {
								for(Todo td : tdList) {
									temp += td.toList() + "\n";
								}
								int nTempTdSize = tdList.size(); //++
								dlg.textArea.setText(temp);
								dlg.setTitle(strDate + " 투두리스트: " +  
										nTempTdSize + "개"	);
							} else {
								dlg.textArea.setText(strDate +
										" 날자에는 Todos 테이블 DB 레코드가 없음");
							}
						}
						
						tdMgr.endConnection();
					}
				});
				btnTodoAdd.setFont(new Font("휴먼엑스포", Font.BOLD, 14));
				btnTodoAdd.setActionCommand("OK");
				buttonPane.add(btnTodoAdd);
				getRootPane().setDefaultButton(btnTodoAdd);
			}
		}
	}

//	public TodoDialog(GuiCalendarFrame6 frm, 
//			String dbResult, int nTdSize) {
//		// TODO Auto-generated constructor stub
//	}

}
