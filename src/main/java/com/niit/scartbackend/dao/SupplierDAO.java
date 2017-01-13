package com.niit.scartbackend.dao;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.niit.scartbackend.model.Supplier;

@Repository
public interface SupplierDAO {

	public  boolean saveOrUpdate(Supplier supplier) ;
	
	//public boolean update(Supplier supplier);

	public boolean delete(Supplier supplier);

	public Supplier get(int id);

	public List<Supplier> list();
}
