<%@include file="menu.jsp" %>
 
<form action="perform_login" method="post">
<table class="table table-bordered">
	<tr>
		<td colspan="2"><center> Sign In  </center></td>
	</tr>
	<tr>
		<td>User Name</td>
		<td><input type="text" name="username"/></td>
	</tr>
	<tr>
		<td>Password</td>
		<td><input type="password" name="password"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<center>
				<input type="submit" value="Sign In" class="btn btn-info"/>
			</center>
		</td>
	</tr>
</table>
</form>

</body>
</html>