package com.niit.scartbackend;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.scartbackend.dao.CategoryDAO;
import com.niit.scartbackend.dao.ProductDAO;
import com.niit.scartbackend.model.Category;
import com.niit.scartbackend.model.Product;

import junit.framework.Assert;

public class CategoryDAOTstCase {
	@Autowired
	static CategoryDAO categoryDAO;

	@Autowired
	static Category category;

	@Autowired
	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.scartbackend");
		context.refresh();

		category = (Category) context.getBean("category");
		categoryDAO = (CategoryDAO) context.getBean("categoryDAOImpl");

	}

	@Test
	public void saveTestCase() {
		category.setId("mukesh1");
		category.setName("electronis");
		category.setDescription("this is electronis");

		Assert.assertEquals("save Test Case", true, categoryDAO.save(category));
	}

}
