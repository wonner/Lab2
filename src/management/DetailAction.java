package management;

import java.sql.SQLException;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class DetailAction extends ActionSupport{
	
	private String bookISBN;
	private Book bookdetail;
	
	public String getBookISBN() { return bookISBN; }
	
	public void setBookISBN(String bookISBN) { this.bookISBN=bookISBN; }
	
	public Book getBookdetail() { return bookdetail; }
	
	public String execute() throws SQLException, ClassNotFoundException
	{
		DBConnection db=new DBConnection();
		bookdetail=db.detailBook(bookISBN);
		return SUCCESS;
	}

}
