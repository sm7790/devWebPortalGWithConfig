package com.dev.web.service;

import com.dev.web.bean.User;

public interface UserDataService {

	public User findUser(String userId);
	
	public User createUser(User user);
	
	public void deleteUser(User user);
	
	public User updateUser(User user);
	
}
