package com.niit.scartbackend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.scartbackend.model.User;

@Repository
public interface UserDAO {
	public boolean saveOrUpdate(User user);

	public boolean delete(User user);

	public List<User> list();

	public User get(int id);

	//public boolean save(User user);

	//public boolean update(User user);

	public User validate(String username, String password);

	public User get(String username);
}
