package com.niit.scartbackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.scartbackend.dao.SupplierDAO;
import com.niit.scartbackend.model.Supplier;
import com.niit.scartbackend.model.User;

@Repository
public class SupplierDAOImpl implements SupplierDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	 public SupplierDAOImpl(SessionFactory sessionFactory)
	    {
	    	this.sessionFactory=sessionFactory;
	    }

	@Transactional
	public boolean save(Supplier supplier) {
		try
		{
			System.out.println("save method is executed in supplier");
		sessionFactory.getCurrentSession().save(supplier);
		return true; 
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	
	}

	@Transactional
	public boolean update(Supplier supplier) {
		try
		{
		sessionFactory.getCurrentSession().update(supplier);
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Transactional
	public boolean delete(Supplier supplier) {
		// TODO Auto-generated method stub
		return false;
	}

	@Transactional
	public Supplier get(String id) {
		return (Supplier) sessionFactory.getCurrentSession().get(Supplier.class,id);
	}

	@Transactional
	public List<Supplier> list() {
		String hql="from Supplier";
		 Query query= sessionFactory.getCurrentSession().createQuery(hql);

		return query.list();
	}

}
