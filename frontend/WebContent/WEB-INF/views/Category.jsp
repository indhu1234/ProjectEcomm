<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@include file="index.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="table-responsive">
<form action="<c:url value="/insertCategory"/>" method="post">
<table align="center" class="table table-bordered">
	<tr>
		<td>Category Name</td>
		<td><input type="text" name="catName"/></td>
	</tr>
	<tr>
		<td>Category Desc</td>
		<td><textarea cols="40" rows="5" name="catDesc"></textarea></td>
	</tr>
	<tr>
		<td colspan="2">
			<center>
			<input type="submit" value="Insert Category" class="btn btn-info"/>
			</center>
		</td>
	</tr>
</table>
</div>
</form>
</body>
</html>