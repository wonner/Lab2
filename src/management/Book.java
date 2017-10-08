package management;

import java.sql.Date;

public class Book {
	
	private String ISBN;
	private String title;
	private Author author;
	public class Author
	{
		private String authorID;
		private String name;
		private int age;
		private String country;
		
		public Author(String authorID,String name,int age,String country)
		{
			this.authorID=authorID;
			this.name=name;
			this.age=age;
			this.country=country;
		}
		
		public String getAuthorID() { return this.authorID; }
		public String getName() { return this.name; }
		public int getAge() { return this.age; }
		public String getCountry() { return this.country; }
		public void setAuthorID(String authorID) { this.authorID=authorID; }
 	}
	private String publisher;
	private Date publishDate;
	private float price;
	
	public Book(String ISBN,String title,String authorID,String name,int age,String country,String publisher,Date publishDate,float price)
	{
		this.ISBN=ISBN;
		this.title=title;
		this.author=new Author(authorID,name,age,country);
		this.publisher=publisher;
		this.publishDate=publishDate;
		this.price=price;
	}
	
	public Book(String title)
	{
		this.title=title;
	}
	
	public String getISBN() { return this.ISBN; }
	public String getTitle() { return this.title; }
	public String getAuthorID() { return this.author.getAuthorID(); }
	public String getName()	{ return this.author.getName(); }
	public int getAge() { return this.author.getAge(); }
	public String getCountry() { return this.author.getCountry(); }
	public String getPublisher() { return this.publisher; }
	public Date getPublishDate() { return this.publishDate; }
	public float getPrice() { return this.price; }
	public void setAuthorID(String authorID) { this.author.setAuthorID(authorID); }

}
