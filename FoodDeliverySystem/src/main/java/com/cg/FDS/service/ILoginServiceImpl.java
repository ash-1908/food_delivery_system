package com.cg.FDS.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.FDS.dao.ICustomerRepository;
import com.cg.FDS.dao.ILoginRepository;
import com.cg.FDS.model.Login;

public class ILoginServiceImpl implements ILoginService{

	@Autowired
	ILoginRepository loginRepo;
	
	@Override
	public Login signIn(Login login) {
		// TODO Auto-generated method stub
		loginRepo.save(login);
		return login;
	}

	@Override
	public Login signOut(Login login) {
		// TODO Auto-generated method stub
		if(loginRepo.existsById(login.getUserId())) {
			loginRepo.deleteById(login.getUserId());
			return login;
		}
		return null;
	}

}
