package com.example.deplom.repository;

import com.example.deplom.models.Camera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CameraRepository extends JpaRepository<Camera, Long> {

    Camera getCameraById(Long id);

    List<Camera> findByBrand(String brand);
}
