package indhu.niit.Test;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import indhu.niit.DAO.CategoryDaoIntf;
import indhu.niit.Model.Category;
import junit.framework.TestCase;

public class CategoryTest extends TestCase 
{
	static CategoryDaoIntf categoryDAO;

	@BeforeClass
	public static void testCat()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("indhu.niit.*");
		context.refresh();
		

		categoryDAO=(CategoryDaoIntf) context.getBean("categoryDAO");
	}

	@Ignore
	@Test
	public void testaddCategory()
	{
		Category category=new Category();
		category.setCategoryName("Samsung mobile");
		category.setCategoryDesc("All Samsung  Smart Phone Mobile");
		assertTrue("Problem in adding the Category ",categoryDAO.addCategory(category));	

		//categoryDAO.addCategory(category);
	}
	@Ignore
	@Test
	public void getCategoryTest()
	{
		assertNotNull("Problem in get Category",categoryDAO.getCategory(1));
	}
	
	
	@Test
	public void testdeleteCategory()
	{
		Category category=categoryDAO.getCategory(2);
		assertTrue("Problem in Deletion:",categoryDAO.deleteCategory(category));
	}
	@Ignore
	@Test
	public void updateCategoryTest()
	{
		Category category=categoryDAO.getCategory(1);
		category.setCategoryName(" xiomi mobile Phone");
		assertTrue("Problem in Updation",categoryDAO.updateCategory(category));
	}
	
	@Ignore
    @Test
	public void listCategoriesTest()
	{
		List<Category> listCategories=categoryDAO.listCategories();
		assertNotNull("No Categories",listCategories);
		
		for(Category category:listCategories)
		{
			System.out.print(category.getCategoryId()+":::");
			System.out.print(category.getCategoryName()+":::");
			System.out.println(category.getCategoryDesc());
		}
	}	
}


