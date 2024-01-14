package com.micro.general.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.micro.general.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, String>{
	// saya codding pake sts 4 jadi gada auto complete untuk jpanya, mau gamau saya pakai @query
	
	@Query("SELECT COUNT(u) FROM User u WHERE u.email=?1")
	public Integer countEmailUser(String email);
	
	@Query("SELECT u FROM User u Where u.email=?1")
	public User findUserByEmail(String email);
	
	
}
