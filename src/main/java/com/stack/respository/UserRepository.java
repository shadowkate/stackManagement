package com.stack.respository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stack.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	public	User findByEmailAndPassword(String mobileNo, String password);
}
