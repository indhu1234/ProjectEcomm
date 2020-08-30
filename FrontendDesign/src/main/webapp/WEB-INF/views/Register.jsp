<%@include file="menu.jsp" %>

<h3 align="center">Register Page</h3>
<pre>
<form action="<c:url value="/registerUser"></c:url>" method="POST">
Enter Customer Name : <input type="text" name="cust">
Enter Email ID : <input type="email" name="email">
Enter Contact No. : <input type="text" name="mobile">
Enter Address : <input type="text" name="address">
user name : <input type="text" name="user">
Password : <input type="password" name="pass">
<input type="submit" value="Register">


</form>
</pre>
</body>
</html>