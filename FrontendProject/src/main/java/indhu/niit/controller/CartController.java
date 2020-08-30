package indhu.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import indhu.niit.DAO.CartDAO;
import indhu.niit.DAO.productDao;
import indhu.niit.Model.Cart;
import indhu.niit.Model.Product;

@Controller
public class CartController
{
    @Autowired
    CartDAO cartDAO;
    
    @Autowired
    productDao productDAO;
    
	
	@RequestMapping("/cart")
	public String showCart(HttpSession session, Model m )
	{
       String username=(String)session.getAttribute("username");
		System.out.println("From Cart Controller "+username);
		List<Cart> cartItemList=cartDAO.listCartItems(username);
		m.addAttribute("listCartItems", cartItemList);
		
		//.m.addAttribute("total_Amount", this.totalCartValue(cartItemList)
		return "Cart";
	}
	@RequestMapping("/addToCart/{prodid}")
	public String addtocart(@PathVariable("prodid")int productId,@RequestParam("quantity")int quantity,Model m,HttpSession session)
	{
		Product product=productDAO.getProduct(productId);
		String username=(String)session.getAttribute("username");
		
		Cart cartItem=new Cart();
		cartItem.setProductId(product.getProdid());
		cartItem.setProductName(product.getProdName());
		cartItem.setPrice(product.getPrice());
		cartItem.setQuantity(quantity);
		cartItem.setStatus("NP");
		cartItem.setUsername(username);
		
		cartDAO.addToCart(cartItem);
		
		List<Cart> cartItemList=cartDAO.listCartItems(username);
		m.addAttribute("listCartItems", cartItemList);
		
		m.addAttribute("total_Amount", this.totalCartValue(cartItemList));
		
		return "Cart";
	}
	
	@RequestMapping("/deleteCartItem/{cartId}")
	public String deletecart(@PathVariable("cartId") int cartid,Model m,HttpSession session)
	{
		Cart cart=cartDAO.getCartItem(cartid);
		cartDAO.deleteCartItem(cart);
		String username=(String) session.getAttribute("username");
		List<Cart> cartItemList=cartDAO.listCartItems(username);
		m.addAttribute("listCartItems", cartItemList);
		System.out.println("Record deleted");
		return "Cart";
	}
	
	@RequestMapping(value="/updateCartItem/{cartItemId}")
	public String updateCartItem(@PathVariable("cartItemId")int cartItemId,@RequestParam("quantity")int quantity,Model m,HttpSession session)
	{
		Cart cartItem=cartDAO.getCartItem(cartItemId);
		cartItem.setQuantity(quantity);
		cartDAO.updateCartItem(cartItem);
		
		String username=(String)session.getAttribute("username");
		
		List<Cart> cartItemList=cartDAO.listCartItems(username);
		m.addAttribute("listCartItems", cartItemList);
		
		m.addAttribute("total_Amount", this.totalCartValue(cartItemList));
		
		return "Cart";
	}
	
	@RequestMapping(value="/confirmOrder")
	public String confirmOrder(Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		
		List<Cart> cartItemList=cartDAO.listCartItems(username);
		m.addAttribute("listCartItems", cartItemList);
		
		m.addAttribute("total_Amount", this.totalCartValue(cartItemList));
		
		return "OrderConfirm";
	}
	
	public double totalCartValue(List<Cart> cartItemList)
	{
		double totalCost=0;
		int i=0;
		
		while(i<cartItemList.size())
		{
			Cart cartItem=cartItemList.get(i);
			totalCost=totalCost+(cartItem.getPrice()*cartItem.getQuantity());
			i++;
		}
		
		return totalCost;
	}
}
