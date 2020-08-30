package indhu.niit.Test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import indhu.niit.DAO.OrderDAO;
import indhu.niit.Model.OrderDetail;

public class OrderDAOTest 
{

	static OrderDAO orderdao;
	
	//@BeforeClass
	public static void testorder()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("indhu.niit.*");
		context.refresh();
		orderdao=(OrderDAO) context.getBean("orderDAO");
		System.out.println("Success");
	}

	@Test
	public void testPayment()
	{
		OrderDetail orderInfo=new OrderDetail();
		orderInfo.setOrderDate(new java.util.Date());
		orderInfo.setTotalShoppingAmount(77000);
		orderInfo.setUsername("charu");
		orderInfo.setPmode("COD");
		
		assertTrue("Problem in Order Payment",orderdao.payment(orderInfo));
		assertTrue("Problem in Updating Payment",orderdao.updateCartItemStatus(orderInfo.getUsername(),orderInfo.getOrderId()));
	}
}
