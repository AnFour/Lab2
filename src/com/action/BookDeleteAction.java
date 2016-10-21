package com.action;

import com.action.DaoBook;
import com.opensymphony.xwork2.ActionSupport;

//git test

@SuppressWarnings("serial")
public class BookDeleteAction extends ActionSupport
{
	private String ISBN;
	
	public void setISBN(String ISBN)
	{
		this.ISBN = ISBN;
	}
	
	public String delete()
	{
		try
		{
			DaoBook D = new DaoBook();
			D.delete(ISBN);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "success";
	}
}
