package com.example.deplom.repository;

import com.example.deplom.models.Tripod;
import com.example.deplom.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripodRepository extends JpaRepository<Tripod, Long> {
    Tripod getTripodById(Long id);
}
