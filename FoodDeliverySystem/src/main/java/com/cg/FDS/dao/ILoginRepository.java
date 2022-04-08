package com.cg.FDS.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.FDS.model.Login;
import com.cg.FDS.model.OrderDetails;

public interface ILoginRepository extends JpaRepository<Login,String >{

	public Login signIn(Login login);
	public Login signOut(Login login);
}
