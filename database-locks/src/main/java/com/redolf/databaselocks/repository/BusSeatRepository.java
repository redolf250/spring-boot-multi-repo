package com.redolf.databaselocks.repository;

import com.redolf.databaselocks.entity.BusSeat;
import jakarta.persistence.LockModeType;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.OptimisticLock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BusSeatRepository extends JpaRepository<BusSeat, Integer> {

  @Transactional
  @Lock(LockModeType.PESSIMISTIC_WRITE)
  BusSeat findBusSeatsById(int id);
}