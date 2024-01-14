package com.micro.general.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.micro.general.beans.UserRequest;
import com.micro.general.beans.UserResponse;
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
	
	@Test
	public void insertAll() {
		List<User> users = new ArrayList<User>();
		for (int i = 1; i < 24; i++) {
			User user = new User();
			user.setName("Syahrul Ilham" + i);
			user.setEmail("syahrulilham62"+i+"@gmail.com");
			user.setPassword("testpassword");
			user.setAddress("Cipedak");
			user.setIsActive(1);
			user.setCreatedAt(new Date());
			users.add(user);
		}
		
		userRepo.saveAll(users);
	}
	
	@Test
	public void testListUserPagination() throws JsonProcessingException {
		
		
		UserRequest rq = new UserRequest();
		ObjectMapper mapper = new ObjectMapper();
		rq.setPage(1);
		rq.setPage(rq.getPage() - 1);
		rq.setSize(10);
		
		List<UserResponse> userList= userService.getListUsers(rq);
		System.out.println(mapper.writeValueAsString(userList));
		assertEquals(Integer.valueOf(userList.size()), rq.getSize());
	}
	
//	@Test
//	public void testSuccessInsert() throws JsonProcessingException {
//		BaseReponse<User> rs = new BaseReponse<User>();
//		ObjectMapper mapper = new ObjectMapper();
//		
//		User user = new User();
//		user.setName("Syahrul Ilham");
//		user.setEmail("syahrulilham62@gmail.com");
//		user.setPassword("testpassword");
//		user.setAddress("Cipedak");
//		user.setIsActive(1);
//		user.setCreatedAt(new Date());
//		
//		try {
//			userService.insertUser(user);
//			rs.setData(user);
//			rs.setMessage("success");
//			rs.setStatus(HttpStatus.OK.toString());
//		} catch (Exception e) {
//			rs.setData(null);
//			rs.setMessage(e.getMessage());
//		}
//		if (rs.getMessage().isEmpty()) {
//			List<User> listUsers = userRepo.findAll();
//			assertEquals(listUsers.get(0).getEmail(), user.getEmail());
//			System.out.println(mapper.writeValueAsString(rs));
//		}else {
//			System.out.println(mapper.writeValueAsString(rs));
//		}
//	}
//	
//	@Test
//	public void testFailedInsert() throws JsonProcessingException {
//		BaseReponse<User> rs = new BaseReponse<User>();
//		ObjectMapper mapper = new ObjectMapper();
//		
//		User user = new User();
//		user.setName("Syahrul Ilham");
//		user.setEmail("syahrulilham62@gmail.com");
//		user.setPassword("testpassword");
//		user.setAddress("Cipedak");
//		user.setIsActive(1);
//		user.setCreatedAt(new Date());
//		
//		try {
//			userService.insertUser(user);
//			rs.setData(user);
//			rs.setMessage("success");
//			rs.setStatus(HttpStatus.OK.toString());
//		} catch (Exception e) {
//			rs.setData(null);
//			rs.setMessage(e.getMessage());
//		}
//		if (rs.getMessage().isEmpty()) {
//			List<User> listUsers = userRepo.findAll();
//			assertEquals(listUsers.get(0).getEmail(), user.getEmail());
//			System.out.println(mapper.writeValueAsString(rs));
//		}else {
//			System.out.println(mapper.writeValueAsString(rs));
//		}
//	}

}
