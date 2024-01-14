package com.micro.general.service;

import java.util.List;

import com.commons.beans.beans.UserRequest;
import com.commons.beans.beans.UserResponse;
import com.micro.general.entity.User;
import com.micro.general.exception.ApiException;

public interface IUserService {
	
	public void insertUser(User user) throws ApiException;
	public List<UserResponse> getListUsers(UserRequest payload); 
	public void inserAllUsers(List<User> users);
	public UserResponse getUserByEmail(String id);
	
}
