package com.micro.general.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.micro.general.beans.UserRequest;
import com.micro.general.beans.UserResponse;
import com.micro.general.constant.AppConstants;
import com.micro.general.entity.User;
import com.micro.general.exception.ApiException;
import com.micro.general.repository.UserRepository;
import com.micro.general.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserResponse> getListUsers(UserRequest payload) {
		List<UserResponse> rs = null;
		Pageable pagination = PageRequest.of(payload.getPage(), payload.getSize());
		Page<User> users = userRepository.findAll(pagination);
		List<User> listUser = users.getContent();
		if (users.getSize() > 0) {
			rs = new ArrayList<UserResponse>();
			for (User u : listUser) {
				UserResponse userRs = new UserResponse();
				userRs.setEmail(u.getEmail());
				userRs.setIdUser(u.getIdUser());
				userRs.setName(u.getName());
				rs.add(userRs);
			}
		}
		return rs;
	}

	@Override
	public void insertUser(User user) throws ApiException {
		if (userRepository.findUserByEmail(user.getEmail()) > 0) {
			throw new ApiException(AppConstants.USER_ALREADY_EXISTS);
		}
		user.setIdUser(UUID.randomUUID().toString());
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
		userRepository.save(user);
	}

	@Override
	public void inserAllUsers(List<User> users) {
		userRepository.saveAll(users);
	}

	@Override
	public UserResponse getUserById(String id) {
		UserResponse rs = null;
		if (userRepository.existsById(id)) {
			User user = userRepository.getReferenceById(id);
			rs = new UserResponse();
			rs.setEmail(user.getEmail());
			rs.setIdUser(user.getIdUser());
			rs.setName(user.getName());
		}
		return rs;
	}
	
}
