package com.micro.general.service.impl;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.micro.general.constant.AppConstants;
import com.micro.general.entity.User;
import com.micro.general.repository.UserRepository;
import com.micro.general.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getListUsers() {
		return userRepository.findAll();
	}

	@Override
	public void insertUser(User user) {
		if (userRepository.findUserByEmail(user.getEmail()) > 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, AppConstants.USER_ALREADY_EXISTS);
		}
		user.setIdUser(UUID.randomUUID().toString());
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
		userRepository.save(user);
	}

	@Override
	public void inserAllUsers(List<User> users) {
		userRepository.saveAll(users);
		
	}
	
	
}
