package com.micro.general.service.impl;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.micro.general.entity.User;
import com.micro.general.repository.UserRepository;
import com.micro.general.service.IUserService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private UserRepository userRepo;
	
	@BeforeEach
	void setup() {
		userRepo.deleteAll();
	}
	
	@Test
	public void testInsertAndSize() {
		User user = new User();
		user.setName("Syahrul Ilham");
		user.setEmail("syahrulilham62@gmail.com");
		user.setPassword("testpassword");
		user.setAddress("Cipedak");
		user.setIsActive(1);
		user.setCreatedAt(new Date());
		
		userService.insertUser(user);
		List<User> listUsers = userRepo.findAll();
		assertEquals(listUsers.get(0).getEmail(), user.getEmail());
	}

}
