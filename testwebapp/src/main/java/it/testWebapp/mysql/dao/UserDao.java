package it.testWebapp.mysql.dao;

import java.util.List;

import it.testWebapp.model.User;

public interface UserDao {
	
	public void createUser(User user);
	
	public User getUser(Integer id);
	
	public List<User> getUserByName(String name);
	
	public User getUserByEmail(String email);
	
	public List<User> getUsers();
}
