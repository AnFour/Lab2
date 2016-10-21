package com.action;
import java.util.*;
import java.sql.*;
import com.action.Bean;
import com.action.Sync;

public class DaoBook
{
	public List <String> getBookTitle(String Name)
	{
		List <String> L = new ArrayList <String>();
		try
		{
			String sql1 = "select AuthorID,Name from author";
			Connection con = Sync.GetConnection();
			PreparedStatement st1 = con.prepareStatement(sql1);
			ResultSet rs1 = st1.executeQuery();
			List <String> ID_L = new ArrayList <String>();
			while(rs1.next())
			{
				if(rs1.getString(2).equals(Name))
				{
					ID_L.add(rs1.getString(1));
				}
			}
			String sql2 = "select Title,AuthorID from book";
			PreparedStatement st2 = con.prepareStatement(sql2);
			ResultSet rs2 = st2.executeQuery();
			while(rs2.next())
			{
				for(int i=0;i<ID_L.size();i++)
					if(rs2.getString(2).equals(ID_L.get(i)))
					{
						L.add(rs2.getString(1));
					}
			}	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return L;
	}
	
	public boolean delete(String ISBN)
	{
		boolean result = false;
		try
		{
			String sql1 = "delete from book where ISBN = ?";
			Connection con = Sync.GetConnection();
			PreparedStatement st1 = con.prepareStatement(sql1);
			st1.setString(1, ISBN);
			result = st1.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	public Bean getBookDetail(String ISBN,String AuthorID)
	{
		Bean b = new Bean();
		try
		{
			String sql1 = "select * from book,author where book.AuthorID=author.AuthorID";
			Connection con = Sync.GetConnection();
			PreparedStatement st1 = con.prepareStatement(sql1);
			ResultSet rs1 = st1.executeQuery();
			while(rs1.next())
			{
				if(rs1.getString("ISBN").equals(ISBN))
				{
					b.setISBN(rs1.getString("ISBN"));
					b.setTitle(rs1.getString("Title"));
					b.setAuthorID(rs1.getString("AuthorID"));
					b.setPublisher(rs1.getString("Publisher"));
					b.setPublishDate(rs1.getString("PublishDate"));
					b.setPrice(rs1.getDouble("Price"));
					b.setName(rs1.getString("Name"));
					b.setage(rs1.getInt("age"));
					b.setCountry(rs1.getString("Country"));
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;
	}
	
	public boolean JudgeISBN(Bean book)
	{
		boolean result = true;
		try
		{
			String sql1 = "select ISBN from book";
			Connection con = Sync.GetConnection();
			PreparedStatement st1 = con.prepareStatement(sql1);
			ResultSet rs1 = st1.executeQuery();
			while(rs1.next())
			{
				if(rs1.getString("ISBN").equals(book.getISBN()))
				{
					result = false;
					break;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean JudgeAuthorID(Bean book)
	{
		boolean result = true;
		try
		{
			String sql1 = "select AuthorID from author";
			Connection con = Sync.GetConnection();
			PreparedStatement st1 = con.prepareStatement(sql1);
			ResultSet rs1 = st1.executeQuery();
			while(rs1.next())
			{
				if(rs1.getString("AuthorID").equals(book.getAuthorID()))
				{
					result = false;
					break;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean insert(Bean book)
	{
		boolean result = true;
		if(!JudgeISBN(book))
		{
			result = false;
			return result;
		}
		try
		{
			if(JudgeAuthorID(book))
			{
				String sql1 = "insert into author(AuthorID,Name,age,Country) values (?,?,?,?)";
				Connection con = Sync.GetConnection();
				PreparedStatement st1 = con.prepareStatement(sql1);
				st1.setString(1, book.getAuthorID());
				st1.setString(2, book.getName());
				st1.setInt(3, book.getage());
				st1.setString(4, book.getCountry());
				st1.executeUpdate();
				String sql2 = "insert into book(ISBN,Title,AuthorID,Publisher,PublishDate,"
						+ "Price) values (?,?,?,?,?,?)";
				PreparedStatement st2 = con.prepareStatement(sql2);
				st2.setString(3, book.getAuthorID());
				st2.setString(1, book.getISBN());
				st2.setString(2, book.getTitle());
				st2.setString(4,book.getPublisher());
				st2.setString(5, book.getPublishDate());
				st2.setDouble(6, book.getPrice());
				st2.executeUpdate();
			}
			else
			{
				String sql2 = "insert into book(ISBN,Title,AuthorID,Publisher,PublishDate,"
						+ "Price) values (?,?,?,?,?,?)";
				Connection con = Sync.GetConnection();
				PreparedStatement st2 = con.prepareStatement(sql2);
				st2.setString(3, book.getAuthorID());
				st2.setString(1, book.getISBN());
				st2.setString(2, book.getTitle());
				st2.setString(4,book.getPublisher());
				st2.setString(5, book.getPublishDate());
				st2.setDouble(6, book.getPrice());
				st2.executeUpdate();
			}
			
		}
		catch(Exception e)
		{
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	
}
