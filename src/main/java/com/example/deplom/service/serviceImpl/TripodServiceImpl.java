package com.example.deplom.service.serviceImpl;

import com.example.deplom.DTOS.TripodDTO;
import com.example.deplom.repository.UserRepository;
import com.example.deplom.service.TripodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripodServiceImpl implements TripodService {
    private final UserRepository userRepository;

    @Autowired
    public TripodServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createTripod(TripodDTO tripodDTO) {

    }

    @Override
    public void update(TripodDTO tripodDTO) {

    }
}
