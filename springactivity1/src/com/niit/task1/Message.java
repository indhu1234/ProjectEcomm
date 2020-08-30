package com.niit.task1;

public class Message 
{
   private String message;

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}
   
   public void showmessage()
   {
	   System.out.println("Welcome to project : "+message);
   }
}
