<%@include file="menu.jsp" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h3 align="center">Product Catalog</h3>

<div class="container">
	<div  class="row text-center text-lg-left">
	
	<c:forEach items="${productList}" var="product">
		<div class="col-md-3 col-sm-4 col-xs-12">
			<a href="<c:url value="/totalProductDisplay/${product.prodid}"/>" class="d-block mb-4 h-100">
			<img class="img-fluid img-thumbnail" src="<c:url value="/resources/images/${product.prodid}.jpg"/>" width="100" height="100"/>
			<p>Price :${product.Price}</p>
			<p>Stock :${product.stock}</p>
			</a>
		</div>
	</c:forEach>
	
	</div>
</div>


</body>
</html>