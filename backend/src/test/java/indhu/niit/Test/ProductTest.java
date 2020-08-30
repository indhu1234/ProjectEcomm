package indhu.niit.Test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import indhu.niit.DAO.productDao;
import indhu.niit.Model.Product;


public class ProductTest 
{
    
	static productDao productDAO;
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		//Package
		context.scan("indhu.niit");
		context.refresh();
		
		productDAO=(productDao) context.getBean("productDao");
	}

	@Ignore
	@Test
	public void TestProductadd()
	{
		Product product=new Product();
		
		product.setProdName("Samsung");
		product.setProdDesc("All Models");
		product.setStock(10);
		product.setPrice(15000);
		product.setCatid(1);
		
		assertTrue("Transaction Issue", productDAO.addProduct(product));
	}
	
	@Ignore
	@Test
	public void TestProddelete()
	{
		Product prod=productDAO.getProduct(45);
		assertTrue("transaction has completed ",productDAO.deleteProduct(prod));
	}
	
	@Test
	public void Testupdateprod()
	{
		Product prod=new Product();
		prod=productDAO.getProduct(45);
		prod.setPrice(30000);
	 assertTrue("Failed",productDAO.updateProduct(prod));
	}

}
