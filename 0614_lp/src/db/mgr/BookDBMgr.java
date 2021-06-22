package db.mgr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import LP.ui.LPBookMainFrame;
import db.data.Book;
import db.data.Member;
import db.util.OracleDBUtil;

public class BookDBMgr {
  Connection conn;
  Statement stmt;
	
	public BookDBMgr() {
		this.conn = OracleDBUtil.getConn();
	}
	
	// ����/������ Ư�� ������ �ϳ��� �߰� �� �� �ִ�.
	public void bookSave (String str1, String str2, String str3, String str4)  {  // DB�� ���������ϴ� �޼ҵ�
		
//		System.out.println("booksave");
		if (str1.equals("") | str2.equals("") | str3.equals("") | str4.equals(""))  {
			System.out.println("����� ���������� �Է����ּ���.");
			return;
		}		
		try  {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe");
			System.out.println("booksave0");
//			this.conn = OracleDBUtil.getConn();
			stmt = conn.createStatement();
			System.out.println("booksave@");

			ResultSet rs = stmt.executeQuery("select code from book where code = '" + str4 +"'");
			System.out.println("booksave1");
			if (rs.next())  {
				int rowNum = stmt.executeUpdate("update book set name='" + str1 + "', writer:='" + str2 + "', publisher:='" + str3 + "' where code='" + str4);
				for (Book obj : Book.list)  {
					if (obj.code.equals(str4))  {
						obj.title = str1;
						obj.writer = str2;
						obj.publisher = str3;
						break;
					}
				}
				int rowCount = LPBookMainFrame.model.getRowCount(); // ���� ���̺� ȭ�� ������������ ����
				for (int cnt = 0; cnt < rowCount; cnt++)  {
					if (str4.equals(LPBookMainFrame.model.getValueAt(cnt, 3)))  {
						LPBookMainFrame.model.setValueAt(str1, cnt, 0);
						LPBookMainFrame.model.setValueAt(str2, cnt, 1);
						LPBookMainFrame.model.setValueAt(str3, cnt, 2);
						break;
					}
				}
				System.out.println(str4 + " �ڵ��� �������� ������.");
				System.out.println("booksave2");

				return;
			}
			else  {
				String queryLang = "insert into book(name, writer, publisher, code, forrent) values('" + str1 + "', '" + str2 + "', '" + str3 + "', '" + str4 + "', '����')";
				int rowNum = stmt.executeUpdate(queryLang);
				System.out.println("���ο� ���� ��ϿϷ�.");
				System.out.println("booksave3");

			}	
			Book.list.add(new Book(str1, str2, str3, str4, "����"));
			String rowData[] = {str1, str2, str3, str4, "����"};
			LPBookMainFrame.model.addRow(rowData);
		}
		catch (SQLException se)  {
			System.out.println(se.getMessage());
		}
		finally  {
			try  {
				stmt.close();
			}
			catch (Exception a)  {
			}
//			try  {
//				conn.close();
//			}
//			catch (Exception a)  {
//			}
		}
	}
	
	public void bookDelete (String codeStr)  { // DB�� ����Ǿ� �ִ� ���� ���� �޼ҵ�
		if (codeStr.equals(""))  {
			System.out.println("������ �����ڵ带 �Է����ּ���.");
			return;
		}

		try  {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select name from book where code = '" + codeStr );
			String name = null;
			while (rs.next())  {
				name = rs.getString("name"); //****
			}
			if (name == null)  {
				System.out.println("�ش� �ڵ��� ������ �����ϴ�");
				return;
			}
			String queryLang = "delete from book where code = '" + codeStr;
			int rowNum = stmt.executeUpdate(queryLang);
			System.out.printf("����: %s%n�ڵ�: %s%n%s", name, codeStr, "�����Ϸ�.");
			for (int cnt = 0; cnt < Book.list.size(); cnt++)  { // �ڷᱸ���� ����Ǿ� �ִ� ���� ������ ����
				Book obj = Book.list.get(cnt);
				if (obj.code.equals(codeStr))  {
					Book.list.remove(cnt);
					break;
				}
			}
			int rowCount = LPBookMainFrame.model.getRowCount(); // ������ ������ ���� ���̺� Ʃ�û���
			for (int cnt = 0; cnt < rowCount; cnt++)  {
				if (LPBookMainFrame.model.getValueAt(cnt, 3).equals(codeStr))
					LPBookMainFrame.model.removeRow(cnt);
			}
		}
		catch (SQLException se)  {
			System.out.println(se.getMessage());
		}
		finally  {
			try  {
				stmt.close();
			}
			catch (Exception e)  {	
			}
			try  {
				conn.close();
			}
			catch (Exception e)  {		
			}
		}
	}
	
	
	public void printTable (JTable table)  { // ���α׷� ����� ���̺� �ʱ�ȭ �۾� �޼ҵ�

		try  {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from book");
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			String name, writer, publisher, code, forrent;
			while (rs.next())  {
				name = rs.getString("name");
				writer = rs.getString("writer");
				publisher = rs.getString("publisher");
				code = rs.getString("code");
				forrent = rs.getString("forrent");
				Book.list.add(new Book(name, writer, publisher, code, forrent));
				String str[] = {name, writer, publisher, code, forrent};
				model.addRow(str);	
			}
			rs = stmt.executeQuery("select * from members");
			while (rs.next())  {
				Member.list.add(new Member(
						rs.getInt("id"),
						rs.getString("name"), 
						rs.getString("login"),
						rs.getString("pw"),
						rs.getInt("age"),
						rs.getString("email"),
						rs.getInt("phone"),
						rs.getDate("joined_at")));
				
			}
		}
		catch (SQLException se)  {
			System.out.println(se.getMessage());
		}
		finally  {
			try  {
				stmt.close();
			}
			catch (Exception e)  {
			}
			try  {
				conn.close();
			}
			catch (Exception e)  {
			}
		}
	}
	
	public void rentalBookIndex (String title, String writer, String publisher, JTable table)  { // ���� �˻���� �޼ҵ�
		if (title.equals("") && writer.equals("") && publisher.equals("") )  {
			System.out.println("�˻������� �Ѱ� �̻� �Է����ּ���");
			return;
		}
		int size = Book.list.size();
		String tempData1[][] = new String[size][5];
		String tempData2[][] = new String[size][5];
		int cntData1 = 0;
		int cntData2 = 0;
		DefaultTableModel model = (DefaultTableModel) table.getModel();	
		if (!(title.equals("")))  {
			for (Book obj:Book.list)  {
				if (!(-1 == obj.title.indexOf(title)))  {
					tempData1[cntData1][0] = obj.title;
					tempData1[cntData1][1] = obj.writer;
					tempData1[cntData1][2] = obj.publisher;
					tempData1[cntData1][3] = obj.code;
					tempData1[cntData1][4] = obj.forrent;
					cntData1++;
				}
			}
			if (tempData1[0][0] == null)  {
				System.out.println("�˻��� ȸ�������� �����ϴ�.");
				return;
			}
		}
		
		if (!(writer.equals("")))  {
			if (tempData1[0][0] == null)  {
				for (Book obj:Book.list)  {
					if (!(-1 == obj.writer.indexOf(writer)))  {
						tempData1[cntData1][0] = obj.title;
						tempData1[cntData1][1] = obj.writer;
						tempData1[cntData1][2] = obj.publisher;
						tempData1[cntData1][3] = obj.code;
						tempData1[cntData1][4] = obj.forrent;
						cntData1++;
					}
				}
				if (tempData1[0][0] == null)  {
					System.out.println("�˻��� ȸ�������� �����ϴ�.");
					return;
				}	
			}
			else  {
				for (int cnt = 0; cnt < cntData1; cnt++)  {
					if (!(-1 == tempData1[cnt][1].indexOf(writer)))  {
						tempData2[cntData2] = tempData1[cnt];
						cntData2++;
					}
				}
				if (tempData2[0][0] == null)  {
					System.out.println("�˻��� ȸ�������� �����ϴ�.");
					return;
				}	
			}
		}
			
		if (!(publisher.equals("")))  {
			if (tempData2[0][0] == null)  {
				if (tempData1[0][0] == null)  {
					int count = 0;
					for (Book obj:Book.list)  {
						if (!(-1 == obj.publisher.indexOf(publisher)))  {
							String arr[] = {obj.title, obj.writer, obj.publisher, obj.code, obj.forrent};
							model.addRow(arr);
						}
					}
					if (count == 0)
						System.out.println("�˻��� ���������� �����ϴ�.");
				}
				else  {
					int count = 0;
					for (int cnt = 0; cnt < cntData1; cnt++)  {
						if (!(-1 == tempData1[cnt][2].indexOf(publisher)))  {
							model.addRow(tempData1[cnt]);
							count++;
						}
					}
					if (count == 0)
						System.out.println("�˻��� ȸ�������� �����ϴ�.");
				}
			}
			else  {
				for (int cnt = 0; cnt < cntData2; cnt++)  {
					if (!(-1 == tempData2[cnt][2].indexOf(publisher)))
						model.addRow(tempData2[cnt]);
				}
			}
		}
		else  {
			if (tempData2[0][0] == null)  { 	 //���� or ���ڸ� �Է�������					
				for (int cnt = 0; cnt < cntData1; cnt++)  {
					if (tempData1[cnt][0] == null)
						return;
					model.addRow(tempData1[cnt]);
				}
			}
			else  { // ���� and ���� �Է�������
				for (int cnt = 0; cnt < cntData2; cnt++)  {
					if (tempData2[cnt][0] == null)
						return;
					model.addRow(tempData2[cnt]);
				}
			}
		}	
	}
	
	public void rentalBookIndex (String codeStr, DefaultTableModel model)  { // �ڵ�� �����˻� �޼ҵ�
		int cnt = 0;
		for (Book obj : Book.list)  {
			if (obj.code.equals(codeStr))  {
				String data[] = {obj.title, obj.writer, obj.publisher, obj.code, obj.forrent};
				model.addRow(data);
				cnt++;
			}
		}
		if (cnt == 0)  {
			System.out.println("�˻��� �����ڵ尡 �����ϴ�");
		}
	}
	
	public String[] getTableData (JTable table)  { // ������ ���̺� ���� �����͸� �������� �޼ҵ�
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int rowNum = table.getSelectedRow();
		if (rowNum == -1)
			return null;
		int colCount = table.getColumnCount();
		String tableData[] = new String[colCount];
		for (int cnt = 0; cnt < colCount; cnt++)  {
			Object obj = model.getValueAt(rowNum, cnt);
			tableData[cnt] = obj.toString();
		}
		return tableData;
	}
	
	public void rentalMemberIndex (String name, JTable table)  { // ȸ�� �˻���� �޼ҵ�
		if (name.equals(""))  {
			System.out.println("�˻��� �̸��� �Է����ּ���");
			return;
		}
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int cnt = 0;
		for (Member obj : Member.list)  {
			if (!(-1 == obj.name.indexOf(name)))  {
				String data[] = {obj.name, obj.login,obj.email};
				model.addRow(data);
				cnt++;
			}
		}
		if (cnt == 0)
			System.out.println("�˻������ �����ϴ�");
		
	}
	
	public void rental (String selectBook[], String selectMember[])  { // �뿩ó���ϴ� �޼ҵ�
	
		try  {
			
			stmt = conn.createStatement();
			stmt.executeUpdate("update book set forrent:= '�뿩��' where code = '" + selectBook[3]);
			ResultSet rs = stmt.executeQuery("select rentbook1, rentbook2, rentbook3 from membersinfo where phone = '" + selectMember[2]);
			String rentbook1 = null;
			String rentbook2 = null;
			String rentbook3 = null;
			while (rs.next())  {
				rentbook1 = rs.getString("rentbook1");
				rentbook2 = rs.getString("rentbook2");
				rentbook3 = rs.getString("rentbook3");
			}
			if (rentbook1 == null)  {
				stmt.executeUpdate("update members set rentbook1:= '" + selectBook[0] + "(" + selectBook[3] + ")' where phone = '" + selectMember[2] );
			}
			else if (rentbook2 == null)  {
				stmt.executeUpdate("update members set rentbook2:= '" + selectBook[0] + "(" + selectBook[3] + ")' where phone = '" + selectMember[2] );
			}
			else  {
				stmt.executeUpdate("update members set rentbook3:= '" + selectBook[0] + "(" + selectBook[3] + ")' where phone = '" + selectMember[2] );
			}
			System.out.printf("�뿩��: %s%n����: %s(%s)%n%s", selectMember[0], selectBook[0], selectBook[3], "�뿩�۾� �Ϸ�");
			for (Book obj : Book.list)  { // �ڷᱸ���� �ִ� ���������� '�뿩��'���� �����۾�
				if (obj.code.equals(selectBook[3]))  {
					obj.setForrent("�뿩��");
					break;
				}
			}
			for (Member obj : Member.list)  { // 
				if (obj.rentBook.equals(selectMember[2]))  {
					if (obj.rentBook[0] == null)
						obj.rentBook[0] = selectBook[0] + "(" + selectBook[3] + ")";
					else if (obj.rentBook[1] == null)
						obj.rentBook[1] = selectBook[0] + "(" + selectBook[3] + ")";
					else
						obj.rentBook[2] = selectBook[0] + "(" + selectBook[3] + ")";
					break;
				}
			}
			int rowCount = LPBookMainFrame.model.getRowCount(); // ���� ���̺� ȭ�� �뿩������ ȭ�� ����
			for (int cnt = 0; cnt < rowCount; cnt++)  {
				if (selectBook[3].equals(LPBookMainFrame.model.getValueAt(cnt, 3)))  {
					LPBookMainFrame.model.setValueAt("�뿩��", cnt, 4);
					break;
				}
			}
		}
		catch (SQLException se)  {
			System.out.println(se.getMessage());
		}
		finally  {
			try  {
				stmt.close();
			}
			catch (Exception a)  {
			}
			try  {
				conn.close();
			}
			catch (Exception a)  {
			}
		}
	}
	
	public boolean mrb_list(String phone)  { // ȸ���� �뿩 ������ ��������(�뿩�Ǽ�. �ִ�3��) Ȯ���ϴ� �޼ҵ�
		String arr[] = new String[3];
		for (Member obj : Member.list)  {
			if (phone.equals(obj.phone))  {
				for (int cnt = 0; cnt < obj.rentBook.length; cnt++)  {
					arr[cnt] = obj.rentBook[cnt];
				}
				break;
			}
		}
		if (!(arr[0] == null) && !(arr[1] == null) && !(arr[2] == null))  {
			return false;
		}
		return true;
	}
	
	public void returnbook (String code)  { // �ݳ� ó���ϴ� �޼ҵ�
		try  {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select name, forrent from book where code = '" + code);
			String forrent = null;
			String title = null;
			while (rs.next())  {
				forrent = rs.getString("forrent");
				title = rs.getString("name");
			}
			if (forrent == null)  {
				System.out.println("�����ڵ带 �߸� �Է��Ͽ����ϴ�");
				return;
			}
			else if (forrent.equals("����"))  {
				System.out.println("�̹� �ݳ��Ǿ� �ֽ��ϴ�");
				return;
			}
			rs = stmt.executeQuery("select name, phone, rentbook1, rentbook2, rentbook3 from member where rentbook1 like '%(" + code + ")' or " + "rentbook2 like '%(" + code + ")' or " + "rentbook3 like '%(" + code + ")';"); 
			int phone = (Integer) null;
			String name = null;
			String rentbook1 = "null";
			String rentbook2 = "null";
			String rentbook3 = "null";
			while (rs.next())  {
				name = rs.getString("name");
				phone = rs.getInt("phone");
				rentbook1 = rs.getString("rentbook1");
				rentbook2 = rs.getString("rentbook2");
				rentbook3 = rs.getString("rentbook3");
			}
			String a = title + "(" + code + ")";
			if (rentbook1.equals(a))
				stmt.executeUpdate("update member set rentbook1:= null where phone = '" + phone );
			else if (rentbook2.equals(a))
				stmt.executeUpdate("update member set rentbook2:= null where phone = '" + phone );
			else if (rentbook3.equals(a))
				stmt.executeUpdate("update member set rentbook3:= null where phone = '" + phone );
			else  {
				System.out.println("����");
				return;
			}
			stmt.executeUpdate("update book set forrent:='����' where code = '" + code );
			System.out.printf("����: %s%n�ڵ�: %s%n%s%n", title, code, name + " ȸ������ �ݳ��Ϸ�");
			for (Book obj : Book.list)  { // �ڷᱸ���� �ִ� ���������� '����'���� �����۾�
				if (obj.code.equals(code))  {
					obj.setForrent("����");
					break;
				}
			}
			for (Member obj : Member.list)  { // �ڷᱸ���� �ִ� ȸ�������Ϳ��� �ݳ��ϴ� ȸ���� 3���� �뿩��Ͽ��� �ݳ����� ����
				if (obj.phone == phone)  {
					if (obj.rentBook[0].equals(a))
						obj.rentBook[0] = null;
					else if (obj.rentBook[1].equals(a))
						obj.rentBook[1] = null;
					else
						obj.rentBook[2] = null;
					break;
				}
			}
			int rowCount = LPBookMainFrame.model.getRowCount(); // ���� ���̺� ȭ�� �뿩�������� ȭ�� ����
			for (int cnt = 0; cnt < rowCount; cnt++)  {
				if (code.equals(LPBookMainFrame.model.getValueAt(cnt, 3)))  {
					LPBookMainFrame.model.setValueAt("����", cnt, 4);
					break;
				}
			}
		}
		catch (SQLException se)  {
			System.out.println(se.getMessage());
		}
		finally  {
			try  {
				stmt.close();
			}
			catch (Exception a)  {
			}
			try  {
				conn.close();
			}
			catch (Exception a)  {
			}
		}
	}
	
	public void allRemoveRowData (DefaultTableModel model)  { // ���̺��� ��� Ʃ�� ���� �޼ҵ�
		int rowCount = model.getRowCount();
		for (int cnt = 0; cnt < rowCount; cnt++)  {
			model.removeRow(0);
		}
	}
	
	public void rentalListAddRow (DefaultTableModel model)  { // �뿩���� ���������͸� ���̺� Ʃ�ÿ� �߰��ϴ� �޼ҵ�
		allRemoveRowData(model);
		for (Book obj : Book.list)  {
			if (obj.forrent.equals("�뿩��"))  {
				String data[] = {obj.title, obj.writer, obj.publisher, obj.code, obj.forrent};
				model.addRow(data);
			}	
		}
	}
	
	public void allBookDataAddRow (DefaultTableModel model)  { // ��� ���� ������ ���̺� Ʃ�ÿ� �߰��ϴ� �޼ҵ�
		allRemoveRowData(model);
		for (Book obj : Book.list)  {
			String data[] = {obj.title, obj.writer, obj.publisher, obj.code, obj.forrent};
			model.addRow(data);
		}
	}
	
	public void allMemberDataAddRow (DefaultTableModel model)  { // ��� ȸ�� ������ ���̺� Ʃ�ÿ� �߰��ϴ� �޼ҵ�
		for (Member obj : Member.list)  {
			String data[] = {obj.name, obj.login,obj.email};
			model.addRow(data);
		}
	}




}
