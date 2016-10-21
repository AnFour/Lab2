<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加图书</title>
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
	<div  align="center" >
		<s:form action="insertbook">
			<s:textfield name="ISBN" label="ISBN"/>
			<s:textfield name="Title" label="书名"/>
			<s:textfield name="AuthorID" label="作者ID"/>
			<s:textfield name="Name" label="作者"/>
			<s:textfield name="age" label="年龄"/>
			<s:textfield name="Country" label="国家"/>
			<s:textfield name="Publisher" label="出版社"/>
			<s:textfield name="PublishDate" label="出版日期"/>
			<s:textfield name="Price" label="单价"/>
			<s:submit value="添加图书"/>
		</s:form>
		<br><br>
		<a href="<%=request.getContextPath()%>/showbook.jsp"><button>查看现有图书</button></a>	
	</div>
</body>
</html>

