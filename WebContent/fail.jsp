<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>插入失败</title>
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
	<div class="ex1" >
	<table class="ex1" align="center" border="0" style="width: 50%;">
		<tr>
			<td>插入失败，该书已被创建</td>
			<td><a href="<%=request.getContextPath()%>/insert.jsp"><button>重新输入</button></a></td>
		</tr>
	</table>
	</div>
</body>
</html>