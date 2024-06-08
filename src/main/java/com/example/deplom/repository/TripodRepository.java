package com.example.deplom.repository;

import com.example.deplom.models.Lens;
import com.example.deplom.models.Tripod;
import com.example.deplom.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripodRepository extends JpaRepository<Tripod, Long> {
    Tripod getTripodById(Long id);
    List<Tripod> findByType(String type);

}
