package management;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateBookAction extends ActionSupport{
	
	private String upisbn;
	private String uppublisher;
	private Date uppublishdate;
	private float upprice;
	private String upname;
	private int upage;
	private String upcountry;
	
	public void setUpisbn(String isbn) { this.upisbn=isbn; }
	public void setUppublisher(String publisher) { this.uppublisher=publisher; }
	public void setUppublishdate(String publishdate) throws ParseException
	{
		SimpleDateFormat bartDateFormat =  
		        new SimpleDateFormat("yyyy-MM-dd");
		this.uppublishdate=new Date(bartDateFormat.parse(publishdate).getTime());  
	}
	public void setUpprice(String price) { this.upprice=Float.parseFloat(price); }
	public void setUpname(String name) { this.upname=name; }
	public void setUpage(String age) { this.upage=Integer.parseInt(age); }
	public void setUpcountry(String country) { this.upcountry=country; }
	
	public String execute() throws ClassNotFoundException, SQLException
	{
		Book book=new Book(upisbn,"","",upname,upage,upcountry,uppublisher,uppublishdate,upprice);
		DBConnection db=new DBConnection();
		db.updateBook(book);
		return SUCCESS;
	}


}
