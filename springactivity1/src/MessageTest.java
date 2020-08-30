

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.niit.task1.Message;

public class MessageTest 
{
   public static void main(String[] args) 
   {
	ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
	Message mes=(Message) context.getBean("messagebean");
	mes.setMessage("Welcome to new World of Learning");
	mes.showmessage();
}
}
