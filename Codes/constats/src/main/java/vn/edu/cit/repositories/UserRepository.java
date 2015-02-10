package vn.edu.cit.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import vn.edu.cit.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
