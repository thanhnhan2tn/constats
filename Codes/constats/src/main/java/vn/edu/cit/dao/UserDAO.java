package vn.edu.cit.dao;

import vn.edu.cit.model.User;

public interface UserDAO {
	public void create(User user);

	public User getByUsername(String userName);

	public void update(User user);

	public int deleteById(String userId);

	public int deleteByUsername(String userName);
}
