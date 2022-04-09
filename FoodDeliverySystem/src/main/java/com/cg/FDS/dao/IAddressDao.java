package com.cg.FDS.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.FDS.model.Address;

@Repository
public interface IAddressDao extends JpaRepository<Address, String>{

}
