package com.ghost.model;

import com.ghost.service.UserStatus;

public class Registration {
	private String name;
	private String userName;
	private String password;
	private UserStatus userStatus;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "Registration [name=" + name + ", userName=" + userName + ", password=" + password + ", userStatus="
				+ userStatus + "]";
	}

	public UserStatus getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}

}
