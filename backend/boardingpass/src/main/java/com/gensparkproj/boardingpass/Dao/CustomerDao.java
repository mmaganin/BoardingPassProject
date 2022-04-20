package com.gensparkproj.boardingpass.Dao;

import com.gensparkproj.boardingpass.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//JpaRepository<x, y> (x=table, y=primary key) has a bunch of methods for interacting with DB
@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {
}
