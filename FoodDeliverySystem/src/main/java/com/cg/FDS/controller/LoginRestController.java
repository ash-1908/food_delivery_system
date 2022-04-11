package com.cg.FDS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	ILoginServiceImpl loginServ;

	@PostMapping("/signin")
	public ResponseEntity<Login> signIn(@RequestBody Login login) {

		return new ResponseEntity<Login>(loginServ.signIn(login), HttpStatus.OK);
	}

	@DeleteMapping("/signout")
	public ResponseEntity<Login> signOut(@RequestBody Login login) {

		return new ResponseEntity<Login>(loginServ.signOut(login), HttpStatus.OK);
	}

}
