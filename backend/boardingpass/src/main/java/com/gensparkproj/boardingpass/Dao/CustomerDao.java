package com.gensparkproj.boardingpass.Dao;

import com.gensparkproj.boardingpass.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {
}
