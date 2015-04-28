package edu.ctu.mongodb.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.ctu.mongodb.domain.User;


public interface UserRepositoryDao extends CrudRepository<User, String> {
	
	
	public User findByEmail(String email);

}
