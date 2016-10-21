<%@ page language="java" import="java.sql.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书管理系统</title>
<style type= text/css>
body
{
font-size:12px;
 line-height:150%;
 background:#fff;
 text-align:center;
 color:#333;
 font-family:"宋体";
}

</style>
</head>
<body>
	
	<div id="Layer1" style="position:absolute; width:100%; height:100%; z-index:-1">    
		<img src="image/background.jpg" height="100%" width="100%"/>    
	</div> 
	<br>
	<br>
	<br>
	<br>
	<br>
	<br><br><br>

	<table align="center" border="0" style="width:80%;" >
		<tr>
			<TD >ISBN</TD>
			<TD >书名</TD>
			<TD >作者ID</TD>
			<TD >作者</TD>
			<TD >出版社</TD>
			<TD >出版日期</TD>
			<TD >单价</TD>
			<TD >操作</TD>
			<TD >删除</TD>
		</tr>
			<%	
			try
				{
				Connection connect = null;
				Class.forName("com.mysql.jdbc.Driver");    
				String url="jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_jacuzzi";
			    connect = DriverManager.getConnection(
				      url,"x4kz5ynl54","wwly55zw04yll4i2iwwwz3mzkw2j0jl3j0k1ll1z");
				String sql1 = "select * from book,author where book.AuthorID=author.AuthorID";
				PreparedStatement st1 = connect.prepareStatement(sql1);
				ResultSet rs1 = st1.executeQuery();
				while(rs1.next())
				{ %>
				<tr>	
					<TD><%=rs1.getString("ISBN") %></TD>
					<TD><%=rs1.getString("Title") %></TD>
					<TD><%=rs1.getString("AuthorID") %></TD>
					<TD><%=rs1.getString("Name") %></TD>
					<TD><%=rs1.getString("Publisher") %></TD>
					<TD><%=rs1.getString("PublishDate") %></TD>
					<TD><%=rs1.getDouble("Price") %></TD>
					<TD><a href="<%=request.getContextPath()%>/BookDetail.jsp?ISBN=<%=rs1.getString("ISBN")%>&AuthorID=<%=rs1.getString("AuthorID")%>"><button>查看</button></a></TD>		
					<TD><a href="<%=request.getContextPath()%>/deletebook.action?ISBN=<%=rs1.getString("ISBN")%>"><button>删除</button></a></TD>
				</tr>
				<% }
				rs1.close();
				st1.close();
				connect.close();
			    }
				catch(Exception e)
				{
					e.printStackTrace();
				}%>
	</table >
	<br><br><br>
	<table align="center" border="0" style="width:50%;" >
	<tr>		
		<td><a href="<%=request.getContextPath()%>/insert.jsp"><button>添加新书</button></a></td>
		<td><a href="<%=request.getContextPath()%>/quary.jsp"><button>查询图书</button></a></td>
	</tr>
	</table>
</body>
</html>

