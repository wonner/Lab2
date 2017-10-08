package management;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteAction extends ActionSupport {
	
	private String bookISBN;
	
	public void setBookISBN(String bookISBN) { this.bookISBN=bookISBN; }
	
	public String execute() throws ClassNotFoundException, SQLException
	{
		DBConnection db=new DBConnection();
		db.deleteBook(bookISBN);
		return SUCCESS;
	}

}
