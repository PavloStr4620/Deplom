package com.example.deplom.service;

import com.example.deplom.DTOS.CameraDTO;

public interface CameraService {
    public void createCamera(CameraDTO cameraDTO);
    void update(CameraDTO cameraDTO);
}
