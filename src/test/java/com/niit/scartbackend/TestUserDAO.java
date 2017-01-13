package com.niit.scartbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.scartbackend.dao.UserDAO;
import com.niit.scartbackend.model.User;

public class TestUserDAO {
	@Autowired
	UserDAO userDAO;
	@Autowired
	User user;
     
	@Autowired
	  AnnotationConfigApplicationContext context;
	   
	   public TestUserDAO()
	   {
		   
		   context=new AnnotationConfigApplicationContext();
		   context.scan("com.niit.scartbackend");
		   
		   context.refresh();
		   
		   userDAO=(UserDAO) context.getBean("userDAOImpl");
		   
		   user=(User)context.getBean("user");
		   
	   }
	   public boolean validate(String username,String password)
	   {
		   if(userDAO.validate(username, password)==null)
		   {
			   System.out.println("User does not exit");
			   return false;
			}
		   else
			   {
			   System.out.println("User  exit");
			   return true;
			   }
		     
	   }
	   public static void main(String args[])
	   {
		   TestUserDAO t=new TestUserDAO();
		   t.validate("mukesh","mukesh");
	   }
	
	
	
	
}
