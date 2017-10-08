package management;

import java.sql.SQLException;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class TotalAction extends ActionSupport{

	private ArrayList<Book> totalList;
	
	public ArrayList<Book> getTotalList() { return totalList; }
	
	public String execute() throws SQLException, ClassNotFoundException
	{
		DBConnection db=new DBConnection();
		totalList=db.totalBook();
		return SUCCESS;
	}
}
