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
	user=	userDAO.get("mukesh");
		Assert.assertEquals("User Test Case","mukesh",user.getUsername());
	 } 
	@Test
	public void getAlluserTestCase()
	{
	int size=	userDAO.list().size();
		Assert.assertEquals("Size Of Table",size, size);
	}
	@Test
	public void  getUserTestCase1()
	{
		user=userDAO.get("mukesh");
		Assert.assertNotNull("Get User Test Case",user);
		
	}
@Test
	public void saveTestCase()
	{
	    user.setMobile("8374047404");
		user.setEmail("pothanamukesh@gmail.com");
		user.setPassword("mukesh");
	    user.setRole("Admin");
	    user.setUsername("mukesh");
	    user.setEnabled(true);
		
	Assert.assertEquals("save Test Case",true,userDAO.saveOrUpdate(user));
	}
/*@Test
 public void upadateTestCase()
 {
	    user.setId("mukesh");
	    user.setName("mukesh");
		user.setMobile("8374047404");
		user.setEmail("pothanamukesh@gmail.com");
		user.setPassword("mukesh@123");
	    user.setUserName("mukesh");
		user.setRole("Admin");
		
		
	Assert.assertEquals("Upadte Test Case",true,userDAO.update(user));
 }*/
@Test
public void validateCredentials()
{
	user=userDAO.validate(1,"mukesh");
	Assert.assertNotNull("ValidateCredentials",user);
	}
@Test
public void invalidateCredentials()
{
	user=userDAO.validate(2,"niit@13");
	Assert.assertNull("INValidateCredentials",user);
	}

}
