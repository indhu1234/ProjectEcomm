package com.niit.task1;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageTest 
{
   public static void main(String[] args) 
   {
	ApplicationContext context=new ClassPathXmlApplicationContext("Spring-Config.xml");
	Message mes=(Message) context.getBean("messagebean");
	User U=(User) context.getBean("customer");
	mes.setMessage("Welcome to new World of Learning");
	mes.showmessage();
	U.setUsername("Santhosh");
	U.show();
}
}
