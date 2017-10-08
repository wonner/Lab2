package management;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
		// TODO Auto-generated method stub
		DBConnection db=new DBConnection();

		ArrayList<Book> str=db.totalBook();
		for(Book e:str) { System.out.println(e.getTitle()); }
		db=new DBConnection();
		Book b=db.detailBook("978-7-5624-8541-1");
		System.out.println(b.getTitle());
		db=new DBConnection();
		//db.deleteBook("978-7-5624-8541-2");
		SimpleDateFormat bartDateFormat =  
		        new SimpleDateFormat("yyyy-MM-dd");
		//db.addBook(new Book("1234567124","java","3","",0,"","z",new Date(bartDateFormat.parse("1997-01-01").getTime()),23));

	}

}
