package com.cg.FDS.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "login_tbl")
public class Login {

	@Id
	@Column(name = "user_id", length = 10)
	private String userId;

	@Column(name = "name", length = 20)
	private String userName;

	@Column(name = "pwd", length = 30)
	private String password;

	public Login() {
		super();
	}

	public Login(String userId, String userName, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Login [userId=" + userId + ", userName=" + userName + ", password=" + password + "]";
	}

}
