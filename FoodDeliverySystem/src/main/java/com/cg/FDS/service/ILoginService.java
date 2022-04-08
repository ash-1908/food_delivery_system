package com.cg.FDS.service;

import com.cg.FDS.model.Login;

public interface ILoginService {

	public Login signIn(Login login);
	public Login signOut(Login login);
}
