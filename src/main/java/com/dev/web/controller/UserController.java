package com.dev.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/users")
public class UserController {

	 @RequestMapping(value = "/{user_id}", method = RequestMethod.GET)
	 @ResponseStatus(value = HttpStatus.NO_CONTENT)
	    public boolean isValidUser(@PathVariable("user_id") String userId) {
		 boolean isVaid = false;
		 if (userId!=null){
			 isVaid = true;
		 }
		 return isVaid;
	 }
	
	
}
