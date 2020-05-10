package indhu.niit.DAO;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import indhu.niit.Model.Product;

/*@Repository("productDao")*/
@Transactional
public class ProductDaoImpl implements productDao
{

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public boolean addProduct(Product product)
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
		
	}
    
}
