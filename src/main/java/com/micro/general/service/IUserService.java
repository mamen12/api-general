package com.micro.general.service;

import java.util.List;

import com.micro.general.entity.User;

public interface IUserService {
	
	public void insertUser(User user);
	public List<User> getListUsers(); 
	public void inserAllUsers(List<User> users);
	
}
