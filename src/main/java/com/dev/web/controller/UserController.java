package com.dev.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dev.web.bean.User;
import com.dev.web.service.UserDataService;

@RestController
@RequestMapping("/rest/users")
public class UserController {

	@Autowired 
	private UserDataService userDataService;
	
	 @RequestMapping(value = "/{user_id}", method = RequestMethod.GET)
	 @ResponseStatus(value = HttpStatus.NO_CONTENT)
	    public boolean isValidUser(@PathVariable("user_id") String userId) {
		 boolean isVaid = false;
		 if (userId!=null){
			 isVaid = true;
		 }
		 return isVaid;
	 }
	
	 
	 @RequestMapping( method = RequestMethod.POST)
	   public User createUser(@RequestBody @Validated User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()){
			throw new RuntimeException();
		}
		
		User createdUser =  userDataService.createUser(user);
		
		
		 return createdUser;
	 }
	
}
