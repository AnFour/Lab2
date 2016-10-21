package com.action;
import java.sql.*;

public class Sync 
{
	private  static Connection connect = null;
	public static Connection GetConnection() throws Exception
	{
		 Class.forName("com.mysql.jdbc.Driver");
		 String url="jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_jacuzzi";
		 connect = DriverManager.getConnection(
		      url,"x4kz5ynl54","wwly55zw04yll4i2iwwwz3mzkw2j0jl3j0k1ll1z");

		 return connect;
	}
}
