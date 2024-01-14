package com.micro.general.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.commons.beans.beans.Request;
import com.commons.beans.beans.Response;
import com.commons.beans.beans.UserRequest;
import com.commons.beans.beans.UserResponse;
import com.commons.beans.constant.ApiResponse;
import com.micro.general.entity.User;
import com.micro.general.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	
    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<UserResponse>> getListUser(@RequestBody Request<UserRequest> rq){
    	Response<List<UserResponse>> rs = new Response<List<UserResponse>>();
		List<UserResponse> listUser = userService.getListUsers(rq.getRequestPayload());
		if (listUser != null) {
			rs.setData(listUser);
			rs.setStatusResponse(ApiResponse.SUCCESS);
		}else {
			rs.setStatusResponse(ApiResponse.DATA_NOT_FOUND);
		}
    	return rs;
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<String> saveUser(@RequestBody Request<UserRequest> rq){
    	Response<String> rs = new Response<String>();
    	UserRequest payload = rq.getRequestPayload();
    	try {
    		User user = new User();
    		user.setName(payload.getName());
    		user.setEmail(payload.getEmail());
    		user.setPassword(payload.getPassword());
    		user.setAddress(payload.getAddress());
    		user.setIsActive(1);
    		user.setCreatedAt(new Date());
    		userService.insertUser(user);
    		rs.setStatusResponse(ApiResponse.SUCCESS);
		} catch (Exception e) {
			rs.setStatusResponse(ApiResponse.FAILED);
		}
    	return rs;
    }
    
    @RequestMapping(value = "/detail", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<UserResponse> detailUser(@RequestBody Request<UserRequest> rq){
    	Response<UserResponse> rs = new Response<UserResponse>();
    	UserRequest payload = rq.getRequestPayload();
		UserResponse user = userService.getUserByEmail(payload.getEmail());
		if (!user.equals(null)) {
			rs.setData(user);
			rs.setStatusResponse(ApiResponse.SUCCESS);
		}else {
			rs.setStatusResponse(ApiResponse.DATA_NOT_FOUND);
		}
    	return rs;
    }
}
