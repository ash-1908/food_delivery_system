package com.cg.FDS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.FDS.dao.ILoginRepository;
import com.cg.FDS.exception.login.UserNotFoundException;
import com.cg.FDS.model.Login;

@Service
public class ILoginServiceImpl implements ILoginService {

	@Autowired
	ILoginRepository loginRepo;
<<<<<<< HEAD
	
	
=======

	public Login signUp(Login login) {
		if (login.getUserName() == null || login.getUserName().length() == 0)
			throw new UserNotFoundException("User name cannot be empty.");
		if (login.getUserId() == null || login.getUserId().length() == 0)
			throw new UserNotFoundException("User Id cannot be empty.");
		if (login.getPassword() == null || login.getPassword().length() == 0)
			throw new UserNotFoundException("User password cannot be empty.");
		if (loginRepo.existsById(login.getUserId()))
			throw new UserNotFoundException("User does not exist.");

		loginRepo.save(login);
		return login;
	}

>>>>>>> 8b033545f830c9f5aba0135bea335dbda948f070
	@Override
	public Login signIn(Login login) {
		if (login.getUserName() == null || login.getUserName().length() == 0)
			throw new UserNotFoundException("User name cannot be empty.");

		loginRepo.save(login);
		return login;
	}

	@Override
	public Login signOut(Login login) {
		if (login.getUserName() == null || login.getUserName().length() == 0)
			throw new UserNotFoundException("User name cannot be empty.");
		if (loginRepo.existsById(login.getUserId()))
			throw new UserNotFoundException("User does not exist.");

		loginRepo.deleteById(login.getUserId());
		return login;
	}

}
