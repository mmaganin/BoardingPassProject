package com.gensparkproj.boardingpass.Dao;

import com.gensparkproj.boardingpass.Entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainDao extends JpaRepository<Train, Integer> {
}
