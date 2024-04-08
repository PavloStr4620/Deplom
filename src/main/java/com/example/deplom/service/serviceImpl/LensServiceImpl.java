package com.example.deplom.service.serviceImpl;

import com.example.deplom.DTOS.LensDTO;
import com.example.deplom.repository.LensRepository;
import com.example.deplom.repository.UserRepository;
import com.example.deplom.service.LensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LensServiceImpl implements LensService {
    private final UserRepository userRepository;

    @Autowired
    public LensServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createLens(LensDTO lensDTO) {

    }

    @Override
    public void update(LensDTO lensDTO) {

    }
}
