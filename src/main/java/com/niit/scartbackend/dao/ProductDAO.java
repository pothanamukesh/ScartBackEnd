package com.niit.scartbackend.dao;

import java.util.List;

import com.niit.scartbackend.model.Product;

public interface ProductDAO {
	public List<Product> list();

	public Product get(String id);

	public boolean save(Product product);

	public boolean update(Product product);

	public boolean delete(Product product);

}
