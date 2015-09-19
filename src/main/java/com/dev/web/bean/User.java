package com.dev.web.bean;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class User {
 
	@Id
	private String userId;
	
	@NotNull
    @Size(min = 4, max = 30)
   	private String password;
	private String userName;
	private String userDescription;
	private String userDepartment;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserDescription() {
		return userDescription;
	}
	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}
	public String getUserDepartment() {
		return userDepartment;
	}
	public void setUserDepartment(String userDepartmennt) {
		this.userDepartment = userDepartmennt;
	}
}
