package db.data;
import java.util.ArrayList;
import java.util.Date;

public class Book {

	public static ArrayList<Book> list = new ArrayList<Book>();
	public String title;
	public String writer;
	public String publisher;
	public String code;
	public String forrent;
	
	public Book() {}
	
	
	
	
	public Book(String title, String writer, String publisher, String code) {
		super();
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.code = code;
	}




	public Book(String title, String writer, String publisher, String code, String forrent)  {
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.code = code;
		this.forrent = forrent;
	}

	




	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public String getWriter() {
		return writer;
	}




	public void setWriter(String writer) {
		this.writer = writer;
	}




	public String getPublisher() {
		return publisher;
	}




	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}




	public String getCode() {
		return code;
	}




	public void setCode(String code) {
		this.code = code;
	}




	public String getForrent() {
		return forrent;
	}




	public void setForrent(String forrent) {
		this.forrent = forrent;
	}




	@Override
	public String toString() {
		return "Book [title=" + title + ", writer=" + writer + ", publisher=" + publisher + ", code="
				+ code + ", forrent=" + forrent + "]";
	}
	
	
	
	
	

}
