package com.cg.FDS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.FDS.model.Login;
import com.cg.FDS.service.ILoginServiceImpl;

@RestController
@CrossOrigin("*")
public class LoginRestController {
	
	@Autowired
	ILoginServiceImpl logserve;
	
	@PostMapping("SignIn")
	public Login signIn(@RequestBody Login login) {
		return logserve.signIn(login);
	}
	
	@DeleteMapping("SignOut")
	public Login signOut(@RequestBody Login login) {
		return logserve.signOut(login);
	}	

}
