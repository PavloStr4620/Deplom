package com.example.deplom.service.serviceImpl;

import com.example.deplom.DTOS.UserDTO;
import com.example.deplom.mappers.UserMapper;
import com.example.deplom.models.User;
import com.example.deplom.repository.UserRepository;
import com.example.deplom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(UserDTO userDTO) {
        User user = UserMapper.INSTANCE.toModel(userDTO);
        userRepository.save(user);
    }

    @Override
    public void update(UserDTO userDTO) {

    }
}
