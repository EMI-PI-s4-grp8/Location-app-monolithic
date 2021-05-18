package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);
}

//forgot password uses :
//@Repository("userRepository")
//public interface UserRepository extends CrudRepository<User, String> {
//	User findByEmailIdIgnoreCase(String emailId);
//}
