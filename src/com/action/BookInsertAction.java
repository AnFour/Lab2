package com.action;

import com.action.DaoBook;
import com.action.Bean;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BookInsertAction extends ActionSupport
{
	private String ISBN;
	private String Title;
	private String AuthorID;
	private String Publisher;
	private String PublishDate;
	private double Price;
	private String Name;
	private int age;
	private String Country;
	
	public void setISBN(String ISBN)
	{
		this.ISBN = ISBN;
	}
	
	public void setTitle(String Title)
	{
		this.Title = Title;
	}
	
	public void setAuthorID(String AuthorID)
	{
		this.AuthorID = AuthorID;
	}
	
	public void setPublisher(String Publisher)
	{
		this.Publisher = Publisher;
	}
	
	public void setPublishDate(String PublishDate)
	{
		this.PublishDate = PublishDate;
	}
	
	public void setPrice(double Price)
	{
		this.Price = Price;
	}
	
	public void setName(String Name)
	{
		this.Name = Name;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public void setCountry(String Country)
	{
		this.Country = Country;
	}
	
	public String insert()
	{
		Bean book = new Bean();
		book.setISBN(ISBN);
		book.setTitle(Title);
		book.setAuthorID(AuthorID);
		book.setName(Name);
		book.setage(age);
		book.setCountry(Country);
		book.setPublisher(Publisher);
		book.setPublishDate(PublishDate);
		book.setPrice(Price);
		DaoBook D = new DaoBook();
		if(D.insert(book))
		{
			return "success";
		}
		else
		{
			return "fail";
		}
	}
}
