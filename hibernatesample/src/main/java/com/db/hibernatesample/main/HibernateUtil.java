package com.db.hibernatesample.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil 
{
   public static void main(String[] args)
   {
	   Configuration config=new Configuration();
	   config.configure("hibernate.cfg.xml");
	   SessionFactory sessionfactory=config.buildSessionFactory();
	   Session session=sessionfactory.openSession();
	   Employee employee=new Employee();
	   employee.setEid(1001);
	   employee.setEname("Anitha");
	   employee.setAddr("Chennai");
	   employee.setSalary(40000);
	   Transaction transaction=session.beginTransaction();
	   session.save(employee);
	   transaction.commit();
	   session.close();
	   System.out.println("Object Saved");
	   
	   
   }
}
