package indhu.niit.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import indhu.niit.DAO.UserDAO;
import indhu.niit.DAO.productDao;
import indhu.niit.Model.Product;
import indhu.niit.Model.UserDetail;

@Controller
public class UserController 
{

	@Autowired
	productDao productDAO;
	
	@Autowired
	UserDAO userdao;

	@RequestMapping("/registerUser")
	public String register(@RequestParam("cust") String customer,@RequestParam("email") String email, @RequestParam("mobile") String mob, @RequestParam("address") String address,@RequestParam("user")String user,@RequestParam("pass") String pass, Model m)
	{
		System.out.println("Initial Process of User");
		UserDetail user1=new UserDetail();
		System.out.println("User object created");
		user1.setCustomerName(customer);
		user1.setEmailId(email);
		user1.setAddress(address);
		user1.setMobileNo(mob);
		user1.setUsername(user);
		user1.setPassword(pass);
		user1.setRole("ROLE_USER");
		user1.setEnabled(true);
		System.out.println("Add the user details");
		userdao.registerUser(user1);
		System.out.println("Added successfully");
		return "login";
	}
	
	@RequestMapping("/login_success")
	public String loginSuccess(HttpSession session,Model m)
	{
		String page="";
		
		boolean loggedIn=false;
		
		//This object will contain the logged in user detail like username and role.
		SecurityContext sContext=SecurityContextHolder.getContext();
		Authentication authentication=sContext.getAuthentication();
		
		String username=authentication.getName();
		
		//Getting all the roles associated with the user
		Collection<GrantedAuthority> roles=(Collection<GrantedAuthority>)authentication.getAuthorities();
		
		for(GrantedAuthority role:roles)
		{
			session.setAttribute("role", role.getAuthority());
			
			if(role.getAuthority().equals("ROLE_ADMIN"))
			{
				loggedIn=true;
				page="AdminHome";
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);
			}
			else
			{
				List<Product> productList=productDAO.listProducts();
				m.addAttribute("productList", productList);
				loggedIn=true;
				page="UserHome";
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);
			}
		}
		return page;
	}
	
	@RequestMapping("/perform_logout")
	public String loggingout(HttpSession session)
	{
		session.invalidate();
		return "login";
	}

}