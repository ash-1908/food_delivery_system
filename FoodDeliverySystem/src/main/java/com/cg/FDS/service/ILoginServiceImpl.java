package com.cg.FDS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.FDS.dao.ILoginRepository;
import com.cg.FDS.exception.EmptyValuesException;
import com.cg.FDS.exception.login.UserAlreadyExistsException;
import com.cg.FDS.exception.login.UserNotFoundException;
import com.cg.FDS.exception.login.WrongPasswordException;
import com.cg.FDS.model.Login;

@Service
public class ILoginServiceImpl implements ILoginService {

	@Autowired
	ILoginRepository loginRepo;

	@Override
	public List<Login> getAllUsers() {
		return loginRepo.findAll();
	}

	@Override
	public Login signUp(Login login) {
		if (login.getUserId() == null || login.getUserId().length() == 0)
			throw new EmptyValuesException("User Id cannot be empty.");
		if (login.getUserName() == null || login.getUserName().length() == 0)
			throw new EmptyValuesException("User name cannot be empty.");
		if (login.getPassword() == null || login.getPassword().length() == 0)
			throw new EmptyValuesException("User password cannot be empty.");
		if (loginRepo.existsById(login.getUserId()))
			throw new UserAlreadyExistsException("User already exists.");

		loginRepo.save(login);
		return login;
	}

	@Override
	public Login signIn(Login login) {
		if (login.getUserId() == null || login.getUserId().length() == 0)
			throw new UserNotFoundException("User Id cannot be empty.");
		if (login.getPassword() == null || login.getPassword().length() == 0)
			throw new EmptyValuesException("User password cannot be empty.");
		if (!loginRepo.existsById(login.getUserId()))
			throw new UserNotFoundException("User does not exist.");
		Login dbCred = loginRepo.findById(login.getUserId()).get();
		if (!dbCred.getPassword().equals(login.getPassword()))
			throw new WrongPasswordException("User password is incorrect.");

		return dbCred;
	}

	@Override
	public Login resetPassword(Login login) {
		if (login.getUserId() == null || login.getUserId().length() == 0)
			throw new UserNotFoundException("User Id cannot be empty.");
		if (login.getUserName() == null || login.getUserName().length() == 0)
			throw new EmptyValuesException("User name cannot be empty.");
		if (!loginRepo.existsById(login.getUserId()))
			throw new UserNotFoundException("User does not exist.");
		if (login.getPassword() == null || login.getPassword().length() == 0)
			throw new EmptyValuesException("User password cannot be empty.");

		loginRepo.save(login);
		return login;
	}

	@Override
	public Login delete(String userId) {
		if (userId == null || userId.length() == 0)
			throw new EmptyValuesException("User Id cannot be empty.");
		if (!loginRepo.existsById(userId))
			throw new UserNotFoundException("User does not exist.");

		Login login = loginRepo.findById(userId).get();
		loginRepo.deleteById(userId);
		return login;
	}

}
