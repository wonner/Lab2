package management;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

public class AddAuthorAction extends ActionSupport{
	
	private String authorid;
	private String name;
	private int age;
	private String country;
	
	public void setAuthorid(String authorid) { this.authorid=authorid; }
	public void setName(String name) { this.name=name; }
	public void setAge(String age) { this.age=Integer.parseInt(age); }
	public void setCountry(String country) { this.country=country; }
	
	public String execute() throws ClassNotFoundException, SQLException
	{
		Book book=new Book("","",authorid,name,age,country,"",null,(float)0);
		DBConnection db=new DBConnection();
		db.addAuthor(book);
		return SUCCESS;
		
	}

}
