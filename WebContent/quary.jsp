<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书查询</title>
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
	<br><br>
	<div align="center" class="ex1">
	<s:form action="getBookTitle">
			<s:textfield  class="ex1" name="Name" label="请输入作者的姓名"/>
			<s:submit class="ex1" value="提交"/>
	</s:form>
	<%
		out.print("查询到的书名为:\n");
	%>
	<table class="ex1"  align="center" >
		<s:iterator value="listtitle" var="Title">
			<tr><td>${Title}</td></tr>
		</s:iterator>
	</table>
	<br><br>
	<table align="center" border="0" class="ex1">
	<tr>
	<td><a href="<%=request.getContextPath()%>/showbook.jsp"><button>查看现有图书</button></a></td>
	</tr>
	</table>
	</div>
</body>
</html>