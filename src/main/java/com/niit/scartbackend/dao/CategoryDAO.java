package com.niit.scartbackend.dao;

import java.util.List;

import com.niit.scartbackend.model.Category;

public interface CategoryDAO {
	public List<Category> list();

	public Category get(int id);

	public boolean saveorupdate(Category category);

	//public boolean update(Category category);

	public boolean delete(Category category);
}
