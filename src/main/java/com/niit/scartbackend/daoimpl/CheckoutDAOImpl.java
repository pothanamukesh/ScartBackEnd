package com.niit.scartbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.scartbackend.dao.CheckoutDAO;
import com.niit.scartbackend.model.Checkout;



public class CheckoutDAOImpl implements CheckoutDAO {
	@Autowired
	private SessionFactory sessionFactory;
	public CheckoutDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	@Transactional
	public boolean saveOrUpdate(Checkout checkout) {
			try {
				sessionFactory.getCurrentSession().saveOrUpdate(checkout);
				return true;
			} catch (Exception e) {
				
				e.printStackTrace();
				return false;
			}
	}

	@Transactional
	public boolean delete(Checkout checkout) {
			try {
				sessionFactory.getCurrentSession().delete(checkout);
				return true;
			} catch (Exception e) {
				
				e.printStackTrace();
				return false;
			}
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Transactional
	public List<Checkout> list() {
		String hql ="from Checkout";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public Checkout get(int id) {
		String hql = "from Checkout where id= "+ "'"+ id+"'" ;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Checkout>list= query.list();
		
		if(list.isEmpty())
		{
			
			return null;
		}
		else
		{
			return list.get(0);
		}
	}
}