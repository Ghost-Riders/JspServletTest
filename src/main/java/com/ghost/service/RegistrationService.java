package com.ghost.service;

import com.ghost.model.Registration;

public interface RegistrationService {
	boolean saveRegistry(Registration registry);

	Registration getUserRegistry(String userName);

	boolean getUserStatus(String userName);

	boolean getAuthenticate(String userName, String password);

}
