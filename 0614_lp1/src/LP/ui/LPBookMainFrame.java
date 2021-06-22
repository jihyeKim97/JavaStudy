package LP.ui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import db.mgr.BookDBMgr;


public class  LPBookMainFrame extends JFrame { 
	public static DefaultTableModel model;
	
	public LPBookMainFrame(LPMainFrame frm)  {
		JFrame frame = new JFrame("도서관리 프로그램");
		frame.setLocation(130, 100);
		frame.setPreferredSize(new Dimension(800,500));
		Container contentPane = frame.getContentPane();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		JButton addBookButton = new JButton("도서추가");
		JButton deleteBookButton = new JButton("도서삭제");
		JButton rentalBookButton = new JButton("대여");
		JButton returnBookButton = new JButton("반납");
		JButton rentalListButton = new JButton("대여리스트");
		JButton allListButton = new JButton("전체리스트");
		JTextField title = new JTextField(11);
		JTextField writer = new JTextField(4);
		JTextField publisher = new JTextField(9);
		JTextField code = new JTextField(4);
		JButton indexButton = new JButton("검색");
		panel1.add(addBookButton);
		panel1.add(deleteBookButton);
		contentPane.add(panel1, BorderLayout.EAST);
		panel2.add(rentalBookButton);
		panel2.add(returnBookButton);
		panel2.add(rentalListButton);
		panel2.add(allListButton);
		contentPane.add(panel2, BorderLayout.NORTH);
		panel3.add(new JLabel("제목"));
		panel3.add(title);
		panel3.add(new JLabel("저자"));
		panel3.add(writer);
		panel3.add(new JLabel("출판사"));
		panel3.add(publisher);
		panel3.add(indexButton);
		panel3.add(new JLabel("코드"));
		panel3.add(code);
		contentPane.add(panel3, BorderLayout.SOUTH);
		String columNames[] = {"도서명", "저자", "출판사", "코드", "대여상태"};
		DefaultTableModel model = new DefaultTableModel(columNames, 0);
		JTable table = new JTable(model);
		this.model = model;
		BookDBMgr bkmgr = new BookDBMgr();
		
		bkmgr.printTable(table); // 프로그램 실행 시 테이블 화면 초기화 
		contentPane.add(new JScrollPane(table));
		
		ActionListener obj1 = new ActionListener()  {
			public void actionPerformed (ActionEvent e)  {
				addBookButton();
			}
		};
		addBookButton.addActionListener(obj1);
		
		ActionListener obj2 = new ActionListener()  {
			public void actionPerformed (ActionEvent e)  {
				deleteBookButton();
			}
		};
		deleteBookButton.addActionListener(obj2);
		
		ActionListener obj3 = new ActionListener()  {
			public void actionPerformed (ActionEvent e)  {
			}
		};
		
		ActionListener obj4 = new ActionListener()  {
			public void actionPerformed (ActionEvent e)  {
			}
		};
		
		ActionListener obj5 = new ActionListener()  {
			public void actionPerformed (ActionEvent e)  {
				rentalBookButton();
			}
		};
		rentalBookButton.addActionListener(obj5);
		
		ActionListener obj6 = new ActionListener()  {
			public void actionPerformed (ActionEvent e)  {
				returnBookGui();
			}
		};
		returnBookButton.addActionListener(obj6);
		
		ActionListener obj7 = new ActionListener()  {
			public void actionPerformed (ActionEvent e)  {
				bkmgr.rentalListAddRow(model);
			}
		};
		rentalListButton.addActionListener(obj7);
		
		ActionListener obj8 = new ActionListener()  {
			public void actionPerformed (ActionEvent e)  {
				bkmgr.allBookDataAddRow(model);
			}
		};
		allListButton.addActionListener(obj8);
		
		ActionListener obj9 = new ActionListener()  {
			public void actionPerformed (ActionEvent e)  {
			}
		};
		
		ActionListener obj10 = new ActionListener()  {
			public void actionPerformed (ActionEvent e)  {
				String titleStr = title.getText();
				String writerStr = writer.getText();
				String publisherStr = publisher.getText();
				String codeStr = code.getText();
				BookDBMgr bkmgr = new BookDBMgr();
				if (titleStr.equals("") && writerStr.equals("") && publisherStr.equals("")
						)  {
					if (!codeStr.equals(""))  {
						
						bkmgr.rentalBookIndex(codeStr, model);
						
						return;
					}	
					else  {
						System.out.println("검색조건을 한개 이상 입력해주세요");
						return;
					}
				}
				bkmgr.allRemoveRowData(model);
				bkmgr.rentalBookIndex(titleStr, writerStr, publisherStr,table);
			}
		};
		indexButton.addActionListener(obj10);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	


	public void addBookButton()  { // 도서추가 버튼 누르면 나오는 GUI
		JFrame frame = new JFrame("추가할 도서정보 입력");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocation(130,100);
		frame.setPreferredSize(new Dimension(400,200));
		Container contentPane = frame.getContentPane();
		JTextField bookName = new JTextField();
		JTextField writer = new JTextField();
		JTextField publisher = new JTextField();
		JTextField code = new JTextField();
		JButton button = new JButton("확인");
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(4, 2));
		panel1.add(new JLabel("도서명"));
		panel1.add(bookName);
		panel1.add(new JLabel("저자"));
		panel1.add(writer);
		panel1.add(new JLabel("출판사"));
		panel1.add(publisher);
		panel1.add(new JLabel("코드"));
		panel1.add(code);
		contentPane.add(panel1);
		contentPane.add(button, BorderLayout.SOUTH);
		BookDBMgr bkmgr = new BookDBMgr();

		ActionListener obj1 = new ActionListener()  {
			public void actionPerformed (ActionEvent e)  {
				String str1 = bookName.getText();
				String str2 = writer.getText();
				String str3 = publisher.getText();
				String str4 = code.getText();
				bkmgr.bookSave(str1, str2, str3, str4);
				frame.setVisible(false);
			}
		};
		button.addActionListener(obj1);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public void deleteBookButton()  { // 도서삭제 버튼 누르면 나오는 GUI
		JFrame frame = new JFrame("삭제할 도서코드 입력");
		frame.setLocation(130,100);
		frame.setPreferredSize(new Dimension(270,100));
		Container contentPane = frame.getContentPane();
		JTextField code = new JTextField();
		JButton button = new JButton("확인");
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 1));
		panel.add(new JLabel("도서코드"));
		panel.add(code);
		contentPane.add(panel);
		contentPane.add(button, BorderLayout.SOUTH);
		
		ActionListener obj1 = new ActionListener()  {
			public void actionPerformed (ActionEvent e)  {
				String codeStr = code.getText();
				BookDBMgr bkmgr = new BookDBMgr();
				bkmgr.bookDelete(codeStr);
				frame.setVisible(false);
			}
		};
		button.addActionListener(obj1);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public void rentalBookButton()  { // 대여 버튼을 누르면 나오는 GUI
		JFrame frame = new JFrame("대여(책 선택)");
		frame.setLocation(130, 100);
		frame.setPreferredSize(new Dimension(700,200));
		Container contentPane = frame.getContentPane();
		JTextField title = new JTextField(15);
		JTextField writer = new JTextField(4);
		JTextField publisher = new JTextField(6);
		JButton indexButton = new JButton("검색");
		JButton button = new JButton("확인");
		JPanel panel = new JPanel();
		panel.add(new JLabel("도서명"));
		panel.add(title);
		panel.add(new JLabel("저자"));
		panel.add(writer);
		panel.add(new JLabel("출판사"));
		panel.add(publisher);
		panel.add(indexButton);
		contentPane.add(panel, BorderLayout.NORTH);
		String colNames[] = {"도서명", "저자", "출판사", "코드", "대여상태"};
		DefaultTableModel model = new DefaultTableModel(colNames, 0);
		JTable table = new JTable(model);
		contentPane.add(new JScrollPane(table));
		contentPane.add(button, BorderLayout.SOUTH);
		
		ActionListener obj1 = new ActionListener()  {
			public void actionPerformed (ActionEvent e)  {
				int count = table.getRowCount();
				for (int cnt = 0; cnt < count; cnt++)  {
					model.removeRow(0);
				}
				BookDBMgr bkmgr = new BookDBMgr();
				bkmgr.rentalBookIndex(title.getText(), writer.getText(), publisher.getText(),table);
			}
		};
		indexButton.addActionListener(obj1);
		
		ActionListener obj2 = new ActionListener()  {
			public void actionPerformed (ActionEvent e)  {
				BookDBMgr bkmgr = new BookDBMgr();
				String selectBook[] = bkmgr.getTableData(table);
				if (selectBook == null)  {
					System.out.println("도서를 선택해 주세요");
					return;
				}
				else if (selectBook[4].equals("대여중"))  {
					System.out.println("이미 대여중인 책입니다");
					return;
				}
				frame.setVisible(false);
				rentalMemberGui(selectBook);
			}
		};
		button.addActionListener(obj2);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public void rentalMemberGui(String selectBook[])  { // 대여 버튼 -> 도서 선택 후 환인을 누르면 나오는 GUI
		JFrame frame = new JFrame("대여(회원선택)");
		frame.setLocation(130, 100);
		frame.setPreferredSize(new Dimension(700,200));
		Container contentPane = frame.getContentPane();
		JTextField name = new JTextField(4);
		JButton indexButton = new JButton("검색");
		JButton button = new JButton("확인");
		JPanel panel = new JPanel();
		panel.add(new JLabel("이름"));
		panel.add(name);
		panel.add(indexButton);
		contentPane.add(panel, BorderLayout.NORTH);
		String colNames[] = {"이름", "주소", "전화번호"};
		DefaultTableModel model = new DefaultTableModel(colNames, 0);
		JTable table = new JTable(model);
		contentPane.add(new JScrollPane(table));
		contentPane.add(button, BorderLayout.SOUTH);
		
		ActionListener obj1 = new ActionListener()  {
			public void actionPerformed (ActionEvent e)  {
				int count = table.getRowCount();
				for (int cnt = 0; cnt < count; cnt++)  {
					model.removeRow(0);
				}
				String nameStr = name.getText();
				BookDBMgr bkmgr = new BookDBMgr();
				bkmgr.rentalMemberIndex(nameStr, table);
			}
		};
		indexButton.addActionListener(obj1);
		
		ActionListener obj2 = new ActionListener()  {
			public void actionPerformed (ActionEvent e)  {
				BookDBMgr bkmgr = new BookDBMgr();
				String selectMember[] = bkmgr.getTableData(table);
				boolean b = bkmgr.mrb_list(selectMember[2]);
				if (!b)  {
					System.out.println("대여불가 회원(대여가능 수 초과)");
					return;
				}
				bkmgr.rental(selectBook, selectMember);
				frame.setVisible(false);
			}
		};
		button.addActionListener(obj2);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public void returnBookGui()  { // 반납 버튼을 누르면 나오는 GUI
		JFrame frame = new JFrame("반납할 도서의 코드 입력");
		frame.setLocation(130,100);
		frame.setPreferredSize(new Dimension(270,100));
		Container contentPane = frame.getContentPane();
		JTextField code = new JTextField();
		JButton button = new JButton("확인");
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 1));
		panel.add(new JLabel("도서코드"));
		panel.add(code);
		contentPane.add(panel);
		contentPane.add(button, BorderLayout.SOUTH);
		
		ActionListener obj1 = new ActionListener()  {
			public void actionPerformed (ActionEvent e)  {
				BookDBMgr bkmgr = new BookDBMgr();
				String codeStr = code.getText();
				bkmgr.returnbook(codeStr);
				frame.setVisible(false);
			}
		};
		button.addActionListener(obj1);
		
		frame.pack();
		frame.setVisible(true);
	}



	public static int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}
}
