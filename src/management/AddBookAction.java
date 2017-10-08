package management;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.opensymphony.xwork2.ActionSupport;

public class AddBookAction extends ActionSupport {
	
	private String isbn;
	private String title;
	private String authorid;
	private String publisher;
	private Date publishdate;
	private float price;
	
	public void setIsbn(String isbn) { this.isbn=isbn; }
	public void setTitle(String title) { this.title=title; }
	public void setAuthorid(String authorid) { this.authorid=authorid; }
	public String getAuthorid() { return this.authorid; }
	public void setPublisher(String publisher) { this.publisher=publisher; }
	public void setPublishdate(String publishdate) throws ParseException
	{
		SimpleDateFormat bartDateFormat =  
		        new SimpleDateFormat("yyyy-MM-dd");
		this.publishdate=new Date(bartDateFormat.parse(publishdate).getTime());  
	}
	public void setPrice(String price) { this.price=Float.parseFloat(price); }
	
	public String execute() throws ClassNotFoundException, SQLException
	{
		DBConnection db=new DBConnection();
		Book book=new Book(isbn,title,authorid,"",0,"",publisher,publishdate,price);
		boolean f=db.addBook(book);
		if(f) return SUCCESS;
		else return ERROR;
		
	}
	

}
