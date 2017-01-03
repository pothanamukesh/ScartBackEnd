package com.niit.scartbackend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.scartbackend.dao.UserDAO;
import com.niit.scartbackend.model.User;

import junit.framework.Assert;

@SuppressWarnings({ "deprecation", "unused" })
public class UserDAOTestCase {

	@Autowired
	 static  UserDAO userDAO;
	
	@Autowired
	 static User user;
	
	@Autowired
	static	AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.scartbackend");
		context.refresh();
		
		user=(User)context.getBean("user");
		userDAO=(UserDAO)context.getBean("userDAOImpl");
		
	}
	
	@Test
	 public void getUserTestCase()
	 {
	user=	userDAO.get("niit");
		Assert.assertEquals("User Test Case","niit",user.getName());
	 }
	
	@Test
	public void validateCredentials()
	{
		user=userDAO.validate("niit","niit@123");
		Assert.assertEquals("Validate Test Case",user,user);
	}
    
	@Test
	public void getAlluserTestCase()
	{
	int size=	userDAO.list().size();
		Assert.assertEquals("Size Of Table",1, 1);
	}
	

}
