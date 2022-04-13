package com.cg.FDS.service;

import java.util.List;

import com.cg.FDS.model.Login;

public interface ILoginService {

	Login signIn(Login login);

	List<Login> getAllUsers();

	Login delete(Login login);

	Login signUp(Login login);

	Login resetPassword(Login login);
}
