package com.example.deplom.service.serviceImpl;

import com.example.deplom.DTOS.CameraDTO;
import com.example.deplom.repository.CameraRepository;
import com.example.deplom.repository.UserRepository;
import com.example.deplom.service.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CameraServiceImpl implements CameraService {
    private final UserRepository userRepository;

    @Autowired
    public CameraServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createCamera(CameraDTO cameraDTO) {

    }

    @Override
    public void update(CameraDTO cameraDTO) {

    }
}
