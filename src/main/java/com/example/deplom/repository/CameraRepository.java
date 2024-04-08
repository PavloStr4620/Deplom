package com.example.deplom.repository;

import com.example.deplom.models.Camera;
import com.example.deplom.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CameraRepository extends JpaRepository<Camera, Long> {

}
