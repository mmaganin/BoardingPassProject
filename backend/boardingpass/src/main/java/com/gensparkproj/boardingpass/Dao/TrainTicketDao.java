package com.gensparkproj.boardingpass.Dao;

import com.gensparkproj.boardingpass.Entity.TrainTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainTicketDao extends JpaRepository<TrainTicket, Integer> {
}
