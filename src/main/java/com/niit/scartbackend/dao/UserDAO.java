package com.niit.scartbackend.dao;

import java.util.List;

import com.niit.scartbackend.model.User;

public interface UserDAO {

	public List<User> list();

	public User get(String id);

	public boolean save(User user);

	public boolean update(User user);

	public User validate(String id, String password);
}
