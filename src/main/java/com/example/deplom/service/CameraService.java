package com.example.deplom.service;

import com.example.deplom.DTOS.CameraDTO;
import com.example.deplom.models.Camera;
import com.example.deplom.repository.CameraRepository;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface CameraService {

    void createCamera(CameraDTO cameraDTO);
    CameraDTO findCameraById(Long id);


    void deleteCameraById(Long id);
    void updateCamera(Long Id, CameraDTO cameraDTO);
    List<CameraDTO> getAllCamera(PageRequest pageRequest);
    public List<Camera> findCamerasByBrand(String brand);

    List<Camera> getAllCamera();
}
