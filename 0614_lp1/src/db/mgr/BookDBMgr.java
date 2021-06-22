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
	
	// 어드민/스탭은 특정 음식을 하나를 추가 할 수 있다.
	public void bookSave (String str1, String str2, String str3, String str4)  {  // DB에 도서저장하는 메소드
		
//		System.out.println("booksave");
		if (str1.equals("") | str2.equals("") | str3.equals("") | str4.equals(""))  {
			System.out.println("등록할 도서정보를 입력해주세요.");
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
				int rowCount = LPBookMainFrame.model.getRowCount(); // 도서 테이블 화면 도서변경정보 갱신
				for (int cnt = 0; cnt < rowCount; cnt++)  {
					if (str4.equals(LPBookMainFrame.model.getValueAt(cnt, 3)))  {
						LPBookMainFrame.model.setValueAt(str1, cnt, 0);
						LPBookMainFrame.model.setValueAt(str2, cnt, 1);
						LPBookMainFrame.model.setValueAt(str3, cnt, 2);
						break;
					}
				}
				System.out.println(str4 + " 코드의 도서정보 수정됨.");
				System.out.println("booksave2");

				return;
			}
			else  {
				String queryLang = "insert into book(name, writer, publisher, code, forrent) values('" + str1 + "', '" + str2 + "', '" + str3 + "', '" + str4 + "', '가능')";
				int rowNum = stmt.executeUpdate(queryLang);
				System.out.println("새로운 도서 등록완료.");
				System.out.println("booksave3");

			}	
			Book.list.add(new Book(str1, str2, str3, str4, "가능"));
			String rowData[] = {str1, str2, str3, str4, "가능"};
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
	
	public void bookDelete (String codeStr)  { // DB에 저장되어 있는 도서 삭제 메소드
		if (codeStr.equals(""))  {
			System.out.println("삭제할 도서코드를 입력해주세요.");
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
				System.out.println("해당 코드의 도서가 없습니다");
				return;
			}
			String queryLang = "delete from book where code = '" + codeStr;
			int rowNum = stmt.executeUpdate(queryLang);
			System.out.printf("제목: %s%n코드: %s%n%s", name, codeStr, "삭제완료.");
			for (int cnt = 0; cnt < Book.list.size(); cnt++)  { // 자료구조에 저장되어 있는 도서 데이터 삭제
				Book obj = Book.list.get(cnt);
				if (obj.code.equals(codeStr))  {
					Book.list.remove(cnt);
					break;
				}
			}
			int rowCount = LPBookMainFrame.model.getRowCount(); // 삭제한 도서와 같은 테이블 튜플삭제
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
	
	
	public void printTable (JTable table)  { // 프로그램 실행시 테이블 초기화 작업 메소드

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
	
	public void rentalBookIndex (String title, String writer, String publisher, JTable table)  { // 도서 검색기능 메소드
		if (title.equals("") && writer.equals("") && publisher.equals("") )  {
			System.out.println("검색조건을 한개 이상 입력해주세요");
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
				System.out.println("검색한 회원정보가 없습니다.");
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
					System.out.println("검색한 회원정보가 없습니다.");
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
					System.out.println("검색한 회원정보가 없습니다.");
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
						System.out.println("검색한 도서정보가 없습니다.");
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
						System.out.println("검색한 회원정보가 없습니다.");
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
			if (tempData2[0][0] == null)  { 	 //제목 or 저자만 입력했을시					
				for (int cnt = 0; cnt < cntData1; cnt++)  {
					if (tempData1[cnt][0] == null)
						return;
					model.addRow(tempData1[cnt]);
				}
			}
			else  { // 제목 and 저자 입력했을시
				for (int cnt = 0; cnt < cntData2; cnt++)  {
					if (tempData2[cnt][0] == null)
						return;
					model.addRow(tempData2[cnt]);
				}
			}
		}	
	}
	
	public void rentalBookIndex (String codeStr, DefaultTableModel model)  { // 코드로 도서검색 메소드
		int cnt = 0;
		for (Book obj : Book.list)  {
			if (obj.code.equals(codeStr))  {
				String data[] = {obj.title, obj.writer, obj.publisher, obj.code, obj.forrent};
				model.addRow(data);
				cnt++;
			}
		}
		if (cnt == 0)  {
			System.out.println("검색한 도서코드가 없습니다");
		}
	}
	
	public String[] getTableData (JTable table)  { // 선택한 테이블 행의 데이터를 가져오는 메소드
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
	
	public void rentalMemberIndex (String name, JTable table)  { // 회원 검색기능 메소드
		if (name.equals(""))  {
			System.out.println("검색할 이름을 입력해주세요");
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
			System.out.println("검색결과가 없습니다");
		
	}
	
	public void rental (String selectBook[], String selectMember[])  { // 대여처리하는 메소드
	
		try  {
			
			stmt = conn.createStatement();
			stmt.executeUpdate("update book set forrent:= '대여중' where code = '" + selectBook[3]);
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
			System.out.printf("대여자: %s%n제목: %s(%s)%n%s", selectMember[0], selectBook[0], selectBook[3], "대여작업 완료");
			for (Book obj : Book.list)  { // 자료구조에 있는 도서데이터 '대여중'으로 갱신작업
				if (obj.code.equals(selectBook[3]))  {
					obj.setForrent("대여중");
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
			int rowCount = LPBookMainFrame.model.getRowCount(); // 도서 테이블 화면 대여중으로 화면 갱신
			for (int cnt = 0; cnt < rowCount; cnt++)  {
				if (selectBook[3].equals(LPBookMainFrame.model.getValueAt(cnt, 3)))  {
					LPBookMainFrame.model.setValueAt("대여중", cnt, 4);
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
	
	public boolean mrb_list(String phone)  { // 회원이 대여 가능한 상태인지(대여권수. 최대3권) 확인하는 메소드
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
	
	public void returnbook (String code)  { // 반납 처리하는 메소드
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
				System.out.println("도서코드를 잘못 입력하였습니다");
				return;
			}
			else if (forrent.equals("가능"))  {
				System.out.println("이미 반납되어 있습니다");
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
				System.out.println("에러");
				return;
			}
			stmt.executeUpdate("update book set forrent:='가능' where code = '" + code );
			System.out.printf("제목: %s%n코드: %s%n%s%n", title, code, name + " 회원님의 반납완료");
			for (Book obj : Book.list)  { // 자료구조에 있는 도서데이터 '가능'으로 갱신작업
				if (obj.code.equals(code))  {
					obj.setForrent("가능");
					break;
				}
			}
			for (Member obj : Member.list)  { // 자료구조에 있는 회원데이터에서 반납하는 회원의 3개의 대여목록에서 반납도서 삭제
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
			int rowCount = LPBookMainFrame.model.getRowCount(); // 도서 테이블 화면 대여가능으로 화면 갱신
			for (int cnt = 0; cnt < rowCount; cnt++)  {
				if (code.equals(LPBookMainFrame.model.getValueAt(cnt, 3)))  {
					LPBookMainFrame.model.setValueAt("가능", cnt, 4);
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
	
	public void allRemoveRowData (DefaultTableModel model)  { // 테이블의 모든 튜플 삭제 메소드
		int rowCount = model.getRowCount();
		for (int cnt = 0; cnt < rowCount; cnt++)  {
			model.removeRow(0);
		}
	}
	
	public void rentalListAddRow (DefaultTableModel model)  { // 대여중인 도서데이터만 테이블 튜플에 추가하는 메소드
		allRemoveRowData(model);
		for (Book obj : Book.list)  {
			if (obj.forrent.equals("대여중"))  {
				String data[] = {obj.title, obj.writer, obj.publisher, obj.code, obj.forrent};
				model.addRow(data);
			}	
		}
	}
	
	public void allBookDataAddRow (DefaultTableModel model)  { // 모든 도서 데이터 테이블 튜플에 추가하는 메소드
		allRemoveRowData(model);
		for (Book obj : Book.list)  {
			String data[] = {obj.title, obj.writer, obj.publisher, obj.code, obj.forrent};
			model.addRow(data);
		}
	}
	
	public void allMemberDataAddRow (DefaultTableModel model)  { // 모든 회원 데이터 테이블 튜플에 추가하는 메소드
		for (Member obj : Member.list)  {
			String data[] = {obj.name, obj.login,obj.email};
			model.addRow(data);
		}
	}




}
