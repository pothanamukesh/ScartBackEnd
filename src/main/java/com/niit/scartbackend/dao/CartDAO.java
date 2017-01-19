package com.niit.scartbackend.dao;

import java.util.List;

import com.niit.scartbackend.model.Cart;

public interface CartDAO {
	public List<Cart> list();

	public boolean save(Cart cart);

	public boolean update(Cart cart);

	public boolean delete(Cart cart);

	public Cart get(int id);

	public Cart getproduct(int id);

	public long cartsize(int userId);

	public double CartPrice(int userId);

	public void pay(int userId);
}
