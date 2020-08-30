<%@include file="menu.jsp" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h3 align="center">Product Information</h3>

<div class="container">
    <div class="content-wrapper">	
		<div class="item-container">	
			<div class="container">	
			<div class="row">
				<div class="col-md-6 col-lg-6 col-sm-6 col-xs-12">
					<div class="product col-md-3 service-image-left">
						<center>
							<img id="item-display" src="<c:url value="/resources/images/${product.prodid}.jpg"/>" alt=""></img>
						</center>
					</div>
				</div>
				<form action="<c:url value="/addToCart/${product.prodid}"/>" method="get">
				<div class="col-md-6 col-lg-6 col-sm-6 col-xs-12">
					<div class="product-title">${product.prodName}</div>
					<div class="product-desc">${product.prodDesc}</div>
					<hr>
					<div class="product-price">INR ${product.price}/-</div>
					<div class="product-stock">In Stock</div>
					<div class="product-price">Quantity 
							<select name="quantity">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
							</select>
					</div>
					<hr>
					<div class="btn-group cart">
						<input type="submit" value="Add to Cart" class="btn btn-success">
					</div>
					</form>
					<div class="btn-group wishlist">
					<form action="<c:url value='/payment'></c:url>" method="post">
					
						<input type="submit" value="Buy Now" class="btn btn-danger">
							
					</form>
					</div>
				</div>
				
			  </div>
			  
				
			</div> 
		</div>

</div>

</body>
</html>