package com.example.deplom.repository;

import com.example.deplom.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getUserById(Long id);
    Optional<User> findByUsername(String username);
//    boolean findByName(String username);
}
