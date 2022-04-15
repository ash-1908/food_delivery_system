package com.cg.FDS.service;

import java.util.List;

import com.cg.FDS.model.Login;

public interface ILoginService {

	Login signIn(Login login);

	List<Login> getAllUsers();

	Login delete(String userId);

	public Login signUp(Login login);

	public Login resetPassword(Login login);
}
