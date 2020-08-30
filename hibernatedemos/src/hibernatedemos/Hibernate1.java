package hibernatedemos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Hibernate1 
{ 
  public static void main(String ar[])
	{
	   Configuration config=new Configuration();
	   config.configure("hibernate_cfg.xml");
	   SessionFactory sessionfac=config.buildSessionFactory();
	   Session session1=sessionfac.openSession();
	   Session session2=sessionfac.openSession();
	   product prod=new product();
	   product prod2=new product();
	   
	   Student stud=new Student();
	   stud.setSid(1);
	   stud.setName("AAA");
	   stud.setMarks(90);
	   
	   
	   prod.setPid(11);
	   prod.setPname("Moto");
	   prod.setQty(10);
	   prod.setPrice(20000);
	   
	   Transaction tran1=session1.beginTransaction();
	   session1.save(prod);
	   
	   session1.save(stud);
	   
	   
	   
	   tran1.commit();
	   prod2.setPid(21);
	   prod2.setPname("Redmi");
	   prod2.setQty(100);
	   prod2.setPrice(20000);
	   session2.save(prod2);
	   Transaction tran2=session2.beginTransaction();
	   tran2.commit();
	   //session1.close();
	   System.out.println("Object saved successfully");
	   
	   //session1.disconnect();
	  
   }
}
