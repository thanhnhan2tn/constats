package vn.edu.cit.dao;

import java.util.List;

import vn.edu.cit.model.User;

public interface UserDAO {
	public void createUser(User user);

	public User getUser(String email);

	public void updateUser(User user);
	
	public List<User> getUsers();
}
