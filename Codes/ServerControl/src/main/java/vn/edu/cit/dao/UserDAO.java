package vn.edu.cit.dao;

import vn.edu.cit.model.User;

public interface UserDAO {
	public void createUser(User user);

	public User getUser(String email);

	public void updateUser(User user);
}
