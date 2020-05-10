package indhu.niit.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DBConfig1 
{
  public static void main(String ar[])
  {
	  AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	   context.scan("indhu.niit");
	   
	   context.refresh();	  
	   System.out.println("Configuration success");
  }
}
