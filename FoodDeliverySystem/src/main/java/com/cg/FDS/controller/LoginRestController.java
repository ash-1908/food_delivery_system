package com.cg.FDS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping("/users/all")
	public ResponseEntity<List<Login>> getAllUsers() {
		return new ResponseEntity<List<Login>>(loginServ.getAllUsers(), HttpStatus.OK);
	}

	@PostMapping("/signup")
	public ResponseEntity<Login> signUp(@RequestBody Login login) {

		return new ResponseEntity<Login>(loginServ.signUp(login), HttpStatus.OK);
	}

	@PostMapping("/signin")
	public ResponseEntity<Login> signIn(@RequestBody Login login) {

		return new ResponseEntity<Login>(loginServ.signIn(login), HttpStatus.OK);
	}

	@PostMapping("/resetpassword")
	public ResponseEntity<Login> resetPassword(@RequestBody Login login) {

		return new ResponseEntity<Login>(loginServ.resetPassword(login), HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Login> signOut(@RequestBody Login login) {

		return new ResponseEntity<Login>(loginServ.delete(login), HttpStatus.OK);
	}

}
