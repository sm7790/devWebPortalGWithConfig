package com.dev.web.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="dev_user")
public class User {
 
	@Id
	@Column(name="user_id")
	private String userId;
	
	public User() {
        this.setUserId(java.util.UUID.randomUUID().toString());
    }
	
	@Column(name="user_password")
   	private String password;
   	
   	@NotNull
    @Size(min = 4, max = 30)
   	@Column(name="user_name")
	private String userName;
   	
   	@Column(name="user_email")
   	private String userEmail;
   	
   	@Column(name="user_description")
	private String userDescription;
   	
   	@Column(name="user_dept")
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
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
}
