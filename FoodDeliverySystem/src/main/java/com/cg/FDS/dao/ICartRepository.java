package com.cg.FDS.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.FDS.model.FoodCart;
@Repository
public interface ICartRepository extends JpaRepository<FoodCart, String> {

}
