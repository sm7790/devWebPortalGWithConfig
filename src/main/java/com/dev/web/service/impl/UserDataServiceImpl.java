package com.dev.web.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.web.bean.User;
import com.dev.web.dao.UserDAO;
import com.dev.web.service.UserDataService;

@Service
public class UserDataServiceImpl implements UserDataService{
	
	private UserDAO userDAO;
	
	@Autowired
	public UserDataServiceImpl(UserDAO dao) {
		// TODO Auto-generated constructor stub
		this.userDAO = dao;
	}

	@Override
	public User findUser(String userId){
		
		return null;
	}
	
	@Override
	@Transactional
	public User createUser(User user){
		
		User ccreatedUser = userDAO.create(user);
		return ccreatedUser;
	}

	@Override
	public User updateUser(User user){
		
		return null;
	}
	
	@Override 
	public void deleteUser(User user){
		
	}
}
