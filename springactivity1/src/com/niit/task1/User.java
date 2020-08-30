package com.niit.task1;

public class User
{
  String Username;

public String getUsername() {
	return Username;
}

public void setUsername(String username) {
	Username = username;
}
  
  void show()
  {
	System.out.println("Welcome user : "+Username);  
  }
}
