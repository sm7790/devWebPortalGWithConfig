package com.dev.web.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dev.web.bean.User;

@Controller
public class PortalController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {
		return "Welcome";
	}

	@RequestMapping(value = "/userOperation", method = RequestMethod.GET)
	public String userOperation(Map<String, Object> model) {

		return "/UserOperation";

	}

	@RequestMapping(value = "/userCreation", method = RequestMethod.GET)
	public String forwardCreateUser(Map<String, Object> model) {

		return "/UserCreation";

	}

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public ModelAndView createUser(@Validated User user, BindingResult bindingResult) {
		System.out.println("username: " + user.getUserName());
		System.out.println("password: " + user.getPassword());
		System.out.println("email: " + user.getUserDescription());

		ModelAndView model = new ModelAndView("ShowUser");
		model.addObject("user", user);
		return model;

	}
}
