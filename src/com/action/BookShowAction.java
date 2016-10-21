package com.action;

import com.opensymphony.xwork2.ActionSupport;

public class BookShowAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
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
}
