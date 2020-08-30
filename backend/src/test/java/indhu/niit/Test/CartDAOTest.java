package indhu.niit.Test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import indhu.niit.DAO.CartDAO;
import indhu.niit.Model.Cart;

public class CartDAOTest 
{
	static CartDAO cartDAO;
	
	@BeforeClass
   public static void executeFirst()
   {
	   AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	   context.scan("indhu.niit");
	   context.refresh();
	   cartDAO=(CartDAO) context.getBean("CartDAO");
	   System.out.println("Testing Success");
   }
	
  @Test
   public void addcartTest()
   {
	  Cart cart=new Cart();
	  cart.setCartId(2);
	  cart.setOrderId(1);
	  cart.setProductId(1);
	  cart.setProductName("Samsung Mobile");;
	  cart.setQuantity(2);
	  cart.setPrice(20000);
	  cart.setUsername("abirami");
	  cart.setStatus("NP");
	   assertTrue("Problem in inserting record",cartDAO.addToCart(cart));
   }

}
