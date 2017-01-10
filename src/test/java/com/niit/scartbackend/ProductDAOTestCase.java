package com.niit.scartbackend;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.scartbackend.dao.ProductDAO;
import com.niit.scartbackend.model.Product;
import com.niit.scartbackend.model.User;

import junit.framework.Assert;

public class ProductDAOTestCase {
	
	@Autowired
	 static  ProductDAO productDAO;
	
	@Autowired
	 static Product product;
	
	@Autowired
	static	AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.scartbackend");
		context.refresh();
		
		product=(Product)context.getBean("product");
		productDAO=(ProductDAO)context.getBean("productDAOImpl");
		
	}
	  
	
@Test
	public void saveTestCase()
	{
	product.setId("Mukesh2");
	product.setName("lapTop");
	product.setDescription("Lap");
	product.setCategory_id("mukesh");
	product.setSupplier_id("mukesh");
	product.setPrice("1000");
	product.setDescription("laptop sale");
		
	Assert.assertEquals("save Test Case",true,productDAO.save(product));
	}

}
