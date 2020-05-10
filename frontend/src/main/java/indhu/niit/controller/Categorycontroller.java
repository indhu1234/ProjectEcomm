package indhu.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import indhu.niit.DAO.CategoryDaoIntf;


public class Categorycontroller 
{
	@Autowired
	CategoryDaoIntf categoryDAO;
	
	@RequestMapping("/cat")
	public String showCategoryPage()
	{
		//List<Category> categoryList=categoryDAO.listCategories();
		//m.addAttribute("categoryList", categoryList);
		
		return "Category";
	}

}
