package management;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport {
	
	private String authorname;
	private ArrayList<Book> titleList;

	public String getAuthorname() { return authorname; }
	
	public void setAuthorname(String authorname) { this.authorname=authorname; }
	
	public ArrayList<Book> getTitleList() { return titleList; }
	
	public String execute() throws SQLException, ClassNotFoundException
	{
		DBConnection db=new DBConnection();
		titleList=db.searchAuthor(authorname);
		return SUCCESS;
	}
	
	

}
