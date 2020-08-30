package indhu.niit.Test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import indhu.niit.DAO.UserDAO;
import indhu.niit.Model.UserDetail;


public class UserDAOTest 
{

	static UserDAO userDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("indhu.niit");
		context.refresh();
		userDAO=(UserDAO)context.getBean("userDAO");
	}
	
	@Ignore
	@Test
	public void testregisterUser()
	{
		UserDetail user=new UserDetail();
		
		user.setUsername("Arun");
		user.setCustomerName("Arun Easwar K");
		user.setAddress("AnnaNagar,chennai");
		user.setEmailId("arun@gmail.com");
		user.setEnabled(true);
		user.setMobileNo("9957898812");
		user.setPassword("12345");
		user.setRole("ROLE_USER");
		
		assertTrue("Problem in Registering User:",userDAO.registerUser(user));
	}

	@Test
	public void testupdateuser()
	{
	
		UserDetail user1=new UserDetail();
		user1=userDAO.getUser("vinod");
		/*user1.setUsername("indhu");*/
		user1.setCustomerName("Indhu");
		user1.setEmailId("indhu@gmail.com");
		user1.setRole("ROLE_USER");
		assertTrue("Update is failed ",userDAO.updateUser(user1));
	}
}
