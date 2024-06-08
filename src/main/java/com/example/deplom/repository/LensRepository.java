package com.example.deplom.repository;

import com.example.deplom.models.Lens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LensRepository extends JpaRepository<Lens, Long> {
    Lens getLensById(Long id);
    List<Lens> findByBayonet(String bayonet);

}
