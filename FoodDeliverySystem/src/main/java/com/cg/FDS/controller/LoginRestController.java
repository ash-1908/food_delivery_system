package com.cg.FDS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.FDS.dao.ILoginRepository;
import com.cg.FDS.exception.customer.CustomerAlreadyExistsException;
import com.cg.FDS.exception.login.LoginAlreadyExistsException;
import com.cg.FDS.exception.login.LoginNotFoundException;
import com.cg.FDS.model.Login;
import com.cg.FDS.service.ILoginServiceImpl;

@RestController
@CrossOrigin("*")
public class LoginRestController {
	
	@Autowired
	ILoginServiceImpl logserve;
	ILoginRepository loginRepo;
	
	@PostMapping("/signin")
	public Login signIn(@RequestBody Login login) {
		try {
			if(loginRepo.existsById(login.getUserId())) {
				throw new LoginAlreadyExistsException("Already Logged In.");
			}	
		}
		catch(LoginAlreadyExistsException e) {
			System.out.println(e.getMessage());
		}
		return logserve.signIn(login);
	}
	
	@DeleteMapping("/signout")
	public Login signOut(@RequestBody Login login) {
		try {
			if(!loginRepo.existsById(login.getUserId())) {
				throw new LoginNotFoundException("Already Logged In.");
			}	
		}
		catch(LoginNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return logserve.signOut(login);
	}	

}
