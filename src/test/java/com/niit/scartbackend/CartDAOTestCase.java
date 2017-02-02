package com.niit.scartbackend;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.scartbackend.dao.CartDAO;
import com.niit.scartbackend.dao.CategoryDAO;
import com.niit.scartbackend.model.Cart;
import com.niit.scartbackend.model.Category;

import junit.framework.Assert;

public class CartDAOTestCase {
	@Autowired
	static CartDAO cartDAO;

	@Autowired
	static Cart cart;

	@Autowired
	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.scartbackend");
		context.refresh();

		cart = (Cart) context.getBean("cart");
		cartDAO = (CartDAO) context.getBean("cartDAOImpl");

	}

	@Test
	public void  getUserTestCase1()
	{
		cart=cartDAO.getitem(248);
		Assert.assertNotNull("Get User Test Case",cart);
		
	}

}
