package com.action;

import java.util.List;
import com.action.DaoBook;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BookGetAction extends ActionSupport
{
	private String Name;
	
	public void setName(String Name)
	{
		this.Name = Name;
	}
	
	public String getName()
	{
		return Name;
	}
	
	public String getBookTitle()
	 {
		 DaoBook D = new DaoBook();
		 List <String> L = D.getBookTitle(Name);
		 ActionContext.getContext().put("listtitle", L);
		 return "success";
	 }

}
