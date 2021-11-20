package com.ghost.serviceimpl;

import com.ghost.model.Registration;
import com.ghost.service.RegistrationService;
import com.ghost.service.UserStatus;

public class RegistrationServiceImpl implements RegistrationService {

	private Registration registry;

	public RegistrationServiceImpl() {
		this.registry = new Registration();
		registry.setName("Manmath");
		registry.setPassword("Manmath");
		registry.setUserName("Manmath");
		registry.setUserStatus(UserStatus.ACTIVE);

	}

	@Override
	public boolean saveRegistry(Registration registry) {
		/*
		 * Logic to save registation
		 */

		return true;
	}

	@Override
	public Registration getUserRegistry(String userName) {
		// TODO Auto-generated method stub
		if (userName.equals(this.registry.getUserName())) {
			return this.registry;
		} else {
			return null;
		}
	}

	@Override
	public boolean getUserStatus(String userName) {
		if (userName.equals(this.registry.getUserName()) && this.registry.getUserStatus().equals(UserStatus.ACTIVE)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean getAuthenticate(String userName, String password) {
		if (userName.equals(this.registry.getUserName()) && password.equals(this.registry.getPassword())) {
			return true;
		} else {

			return false;
		}
	}

}
