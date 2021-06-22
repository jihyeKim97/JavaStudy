package ui.calendar.main.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ui.calendar.main.GuiCalendarFrame6;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;

public class TodoDialog_backup1 extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
//	public TodoDialog() {
//		
//	}
	
	GuiCalendarFrame6 frm;
	
	
	public TodoDialog_backup1(GuiCalendarFrame6 frm, 
			String dbResult, String strDate, int nTdSize) {
		super(frm, true); // modal mode
		//this.frm = frm;
		setTitle(strDate + " 투두리스트: " +  
				 nTdSize + "개"	);
		setBounds(100, 100, 386, 190);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				JTextArea textArea = new JTextArea();
				textArea.setBackground(new Color(100, 149, 237));
				textArea.setLineWrap(true);
				textArea.setEditable(false);
				scrollPane.setViewportView(textArea);
				textArea.setText(dbResult);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

//	public TodoDialog(GuiCalendarFrame6 frm, 
//			String dbResult, int nTdSize) {
//		// TODO Auto-generated constructor stub
//	}

}
