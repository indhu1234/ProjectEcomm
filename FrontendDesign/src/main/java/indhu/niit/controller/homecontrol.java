package indhu.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homecontrol
{
   @RequestMapping("/login")
   public String showLogin()
   {
	   return "login";
   }
   
}
