package com.gensparkproj.boardingpass.Dao;

import com.gensparkproj.boardingpass.Entity.BoardingPass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

@Repository
public interface BoardingPassDao extends JpaRepository<BoardingPass, Integer> {
}
