package com.cg.FDS.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.FDS.model.Login;
import com.cg.FDS.model.OrderDetails;

@Repository
public interface ILoginRepository extends JpaRepository<Login,String >{

}
