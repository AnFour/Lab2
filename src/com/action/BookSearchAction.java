package com.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.action.Sync;
import com.opensymphony.xwork2.ActionSupport;

public class BookSearchAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String book_name = new String();
	public String ss()
		{
			System.out.println(book_name);
			if(book_name.length()!=0){
				try{
					Connection con = Sync.GetConnection();
					PreparedStatement stmt = con.prepareStatement("select * from author"+" where name = ?");
					stmt.setString(1, book_name);
					ResultSet row = stmt.executeQuery();
					row.last();
					int rowCount = row.getRow(); 
					row.first();
					String[] myauthor;
					if(rowCount==0)
					{
						return "add";  
					}
					else{
						int  number=0;
						myauthor = new String[4];
						for(int i=0;i<4;i++){
							myauthor[i]= row.getString(i+1);
						}
						
						PreparedStatement stmt1 = con.prepareStatement("select * from book"+" where AuthorID = ?");
						stmt1.setString(1, myauthor[0]);
						ResultSet row1 = stmt1.executeQuery();
						row1.last();
						int rowCountt = row1.getRow();
						String[][] mybook=new String[rowCountt][];
						String[] mytitle = new String[rowCountt];
						row1.first();
						mytitle[0] = row1.getString(2);
						for(int i=0;i<rowCountt;i++){
							mybook[i] = new String[6];
						}
						for(int i=0;i<6;i++){
							System.out.println(number);
							System.out.println(row1.getString(i+1));
							mybook[number][i]= row1.getString(i+1);
						}
					    number++;
						while(row1.next())
						{
							for(int i=0;i<6;i++){
								mybook[number][i]= row1.getString(i+1);
							}
							mytitle[number] = row1.getString(2);
							number++;
						}
						Sync.GetConnection();
					return SUCCESS;
					}
				}catch (Exception e) {
					System.out.print("get data error!");
					e.printStackTrace();
					return "no";
				}
			}
			else
				return "Original";
		}
		public String getBook_name() {
			return book_name;
		}
		public void setBook_name(String book_name) {
			this.book_name = book_name;
		}

	}

