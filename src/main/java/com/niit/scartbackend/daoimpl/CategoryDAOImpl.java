package com.niit.scartbackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.scartbackend.dao.CategoryDAO;
import com.niit.scartbackend.model.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	private static final Logger log = LoggerFactory.getLogger(ProductDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public CategoryDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean save(Category category) {
		try {
			log.debug("Save method Is Starting...........S......! ");
			sessionFactory.getCurrentSession().save(category);
			log.debug("Save Method is Ending.........S.......!");
			return true;
		} catch (Exception e) {
			log.info("Exception Occureing save Method....S......!" + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(Category category) {
		try {
			log.debug("Update method Is Starting..........U.......! ");
			sessionFactory.getCurrentSession().save(category);
			log.debug("update Method is Ending.........U.......!");
			return true;

		} catch (Exception e) {
			log.info("Exception Occureing Update Method......U.....!" + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(Category category) {
		try {
			log.debug("Delete method Is Starting..........D.......! ");
			sessionFactory.getCurrentSession().save(category);
			log.debug("Delete Method is Ending.........D.......!");
			return true;
		} catch (Exception e) {
			log.info("Exception Occureing Delete Method......D.....!" + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public List<Category> list() {
		return null;
	}

	@Transactional
	public Category get(String id) {
		return null;
	}

}
