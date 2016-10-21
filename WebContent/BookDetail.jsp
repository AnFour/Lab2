<%@ page language="java" import="java.sql.*" import="com.action.DaoBook" import="com.action.Bean"
contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看图书</title>
<style type="text/css">
p.ex1
{
font:font-size:12px;
 line-height:150%;
 background:#fff;
 text-align:center;
 color:#333;;
}

</style>
</head>
<body>
	<div id="Layer1" style="position:absolute; width:100%; height:100%; z-index:-1">    
		<img src="image/background.jpg" height="100%" width="100%"/>    
	</div> 

	<table class="ex1" align="center" border="1" style="width:80%;">
	<tbody>
		<tr>
			<TD >ISBN</TD>
			<TD >书名</TD>
			<TD >作者ID</TD>
			<TD >作者</TD>
			<TD >年龄</TD>
			<TD >国家</TD>
			<TD >出版社</TD>
			<TD >出版日期</TD>
			<TD >单价</TD>
		</tr>
		<%
			String ISBN = request.getParameter("ISBN");
			String AuthorID = request.getParameter("AuthorID");
			DaoBook D = new DaoBook();
			Bean bookdetail = D.getBookDetail(ISBN, AuthorID);
		%>
		<tr>
			<TD><%= bookdetail.getISBN() %> </TD>
			<TD><%= bookdetail.getTitle() %></TD>
			<TD><%= bookdetail.getAuthorID() %></TD>
			<TD><%= bookdetail.getName() %></TD>
			<TD><%= bookdetail.getage() %></TD>
			<TD><%= bookdetail.getCountry() %></TD>
			<TD><%= bookdetail.getPublisher() %></TD>
			<TD><%= bookdetail.getPublishDate() %></TD>
			<TD><%= bookdetail.getPrice() %></TD>
		</tr>
	</tbody>
	</table>
	<br>
	<br>
	<div style="text-align:center" class="ex1">
	<a href="<%=request.getContextPath()%>/showbook.jsp"><button>查看现有图书</button></a>	
	</div>
</body>
</html>