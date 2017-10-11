package management;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;




public class DBConnection {
	
	private String driver = "com.mysql.jdbc.Driver"; // 驱动程序名
	private String url = "jdbc:mysql://ajpinvgwhudt.mysql.sae.sina.com.cn:10667/book"; // URL指向要访问的数据库名
	private String user = "root";  // MySQL配置时的用户名
	private String password = "yyww123456"; // MySQL配置时的密码
	private static Connection conn;
	
	public DBConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName(driver);
        conn = DriverManager.getConnection(url, user, password);
	}
	
	public ArrayList<Book> searchAuthor(String name) throws SQLException
	{
		ArrayList<Book> titleList=new ArrayList<>();
		String authorID=null;
		Statement statement = conn.createStatement();	// statement用来执行SQL语句
		String sql = "SELECT * FROM author where name='"+name+"'";	// 要执行的SQL语句
		ResultSet rs = statement.executeQuery(sql);	// 结果集
		if(rs.next())
		{
			authorID=rs.getString("AuthorID");
			int age=rs.getInt("Age");
			String country=rs.getString("Country");
			sql = "select * from book where AuthorID='"+authorID+"'";
			rs=statement.executeQuery(sql);
			while (rs.next()){  
				String ISBN=rs.getString("ISBN");
				String title=rs.getString("Title");
				String publisher=rs.getString("Publisher");
				Date publishDate=rs.getDate("PublishDate");
				float price=rs.getFloat("Price");
				titleList.add(new Book(ISBN,title,authorID,name,age,country,publisher,publishDate,price));   //将找出的数据存入messageList  
		    }
		}  
		statement.close();
	    rs.close();
		conn.close();
		return titleList;
	}
	
	public ArrayList<Book> totalBook() throws SQLException
	{
		ArrayList<Book> titleList=new ArrayList<>();
		Statement statement = conn.createStatement();	// statement用来执行SQL语句
		Statement statement1= conn.createStatement();
		String sql = "SELECT * FROM book";	// 要执行的SQL语句
		ResultSet rs = statement.executeQuery(sql);	// 结果集
		while(rs.next())
		{
			String ISBN=rs.getString("ISBN");
			String title=rs.getString("Title");
			String authorID=rs.getString("AuthorID");
			String publisher=rs.getString("Publisher");
			Date publishDate=rs.getDate("PublishDate");
			float price=rs.getFloat("Price");
			sql = "select * from author where AuthorID='"+authorID+"'";
			ResultSet rs1=statement1.executeQuery(sql);
			if(rs1.next()){  
				int age=rs1.getInt("Age");
				String country=rs1.getString("Country");
				titleList.add(new Book(ISBN,title,authorID,null,age,country,publisher,publishDate,price));   //将找出的数据存入messageList  
		    }
		}  
		statement.close();
	    rs.close();
		conn.close();
		return titleList;
	}
	
	public Book detailBook(String ISBN) throws SQLException
	{
		Book b = null;
		Statement statement = conn.createStatement();	// statement用来执行SQL语句
		String sql = "SELECT * FROM book where ISBN='"+ISBN+"'";	// 要执行的SQL语句
		ResultSet rs = statement.executeQuery(sql);	// 结果集
		if(rs.next())
		{
			String title=rs.getString("Title");
			String publisher=rs.getString("Publisher");
			Date publishDate=rs.getDate("PublishDate");
			float price=rs.getFloat("Price");
			String authorID=rs.getString("AuthorID");
			sql="select * from author where AuthorID='"+authorID+"'";
			rs=statement.executeQuery(sql);
			if(rs.next())
			{
				String name=rs.getString("Name");
				int age=rs.getInt("Age");
				String country=rs.getString("Country");
				b=new Book(ISBN,title,authorID,name,age,country,publisher,publishDate,price);
			}
			
			
		}
		statement.close();
	    rs.close();
		conn.close();
		return b;
	}
	
	public void deleteBook(String ISBN) throws SQLException
	{
		Statement statement = conn.createStatement();	// statement用来执行SQL语句
		String sql = "delete FROM book where ISBN='"+ISBN+"'";	// 要执行的SQL语句
		statement.executeUpdate(sql);	// 结果集
		statement.close();
		conn.close();
	}
	
	public boolean findAuthorID(String authorid) throws SQLException
	{
		Statement statement = conn.createStatement();	// statement用来执行SQL语句
		String sql = "SELECT * FROM author where AuthorID='"+authorid+"'";	// 要执行的SQL语句
		ResultSet rs = statement.executeQuery(sql);	// 结果集
		boolean ret=rs.next();
		statement.close();
	    rs.close();
		return ret;
	}
	
	public boolean addBook(Book book) throws SQLException
	{
		boolean ret=findAuthorID(book.getAuthorID());
		PreparedStatement statement;
		if(!ret)
		{
			String sql="insert into author (AuthorID) values (?)";
			statement=conn.prepareStatement(sql);
			statement.setString(1, book.getAuthorID());
			statement.executeUpdate();
		}
		String sql = "insert into book (ISBN,Title,AuthorID,Publisher,PublishDate,Price) values (?,?,?,?,?,?)";	// 要执行的SQL语句
		statement=conn.prepareStatement(sql);
		statement.setString(1, book.getISBN());
		statement.setString(2, book.getTitle());
		statement.setString(3, book.getAuthorID());
		statement.setString(4, book.getPublisher());
		statement.setDate(5, book.getPublishDate());
		statement.setFloat(6, book.getPrice());
		statement.executeUpdate(); 
		statement.close();
		conn.close();
		return ret;
	}
	
	public void addAuthor(Book book) throws SQLException
	{
		String sql = "update author set name=?,age=?,country=? where authorID="+book.getAuthorID();	// 要执行的SQL语句
		PreparedStatement statement=conn.prepareStatement(sql);
		statement.setString(1, book.getName());
		statement.setInt(2,book.getAge());
		statement.setString(3, book.getCountry());
		statement.executeUpdate();
		statement.close();
		conn.close();
		
	}
	
	public void updateBook(Book book) throws SQLException
	{
		String sql = "update book set publisher=?,publishdate=?,price=? where ISBN='"+book.getISBN()+"'";	// 要执行的SQL语句
		PreparedStatement statement=conn.prepareStatement(sql);
		statement.setString(1, book.getPublisher());
		statement.setDate(2, book.getPublishDate());
		statement.setFloat(3, book.getPrice());
		statement.executeUpdate();
		sql = "select * from book where ISBN='"+book.getISBN()+"'";
		ResultSet rs = statement.executeQuery(sql);	// 结果集
		if(rs.next())
		{
			book.setAuthorID(rs.getString("AuthorID"));
			addAuthor(book);
		}
	}
	
}