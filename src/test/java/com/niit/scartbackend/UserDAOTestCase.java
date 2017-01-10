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
	user=	userDAO.get("Mukesh");
		Assert.assertEquals("User Test Case","Mukesh",user.getName());
	 }
	
	@Test
	public void validateCredentials()
	{
		user=userDAO.validate("Mukesh","sai123");
		Assert.assertNotNull("ValidateCredentials",user);
		}
	@Test
	public void invalidateCredentials()
	{
		user=userDAO.validate("mukesh","niit@13");
		Assert.assertNull("INValidateCredentials",user);
		}
    
	@Test
	public void getAlluserTestCase()
	{
	int size=	userDAO.list().size();
		Assert.assertEquals("Size Of Table",1, 1);
	}
	@Test
	public void  getUserTestCase1()
	{
		user=userDAO.get("niit");
		Assert.assertNotNull("Get User Test Case",user);
		
	}
@Test
	public void saveTestCase()
	{
		user.setId("yuga");
		user.setName("yuga");
		user.setMobile("8374047404");
		user.setEmail("pothanamukesh@gmail.com");
		user.setPassword("mukesh");
	    user.setRole("Admin");
	    user.setUserName("mukesh");
		
	Assert.assertEquals("save Test Case",true,userDAO.save(user));
	}
/*@Test
 public void upadateTestCase()
 {
	    user.setId("niit");
	
		user.setRole("Role_user");
		
		
	Assert.assertEquals("Upadte Test Case",true,userDAO.update(user));
 }*/

}
