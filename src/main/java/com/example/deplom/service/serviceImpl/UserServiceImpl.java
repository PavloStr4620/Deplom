package com.example.deplom.service.serviceImpl;

import com.example.deplom.DTOS.UserDTO;
import com.example.deplom.mappers.UserMapper;
import com.example.deplom.models.User;
import com.example.deplom.repository.UserRepository;
import com.example.deplom.service.UserService;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public UserDTO findUserById(Long id) {
        User user = userRepository.getUserById(id);
        return UserMapper.INSTANCE.toDTO(user);
    }

    public void deleteUserById(Long Id){
        userRepository.deleteById(Id);
    }

    @Override
    public void updateUser(Long id, UserDTO userDTO) {
        Optional<User> userOptional = userRepository.findById(id);
        User user = userOptional.orElseThrow(() -> new NotFoundException("Not found user by id" + id));
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setRole(userDTO.getRole());

        userRepository.save(user);
    }

    @Override
    public List<UserDTO> getAllUser(PageRequest pageRequest) {
        List<User> users = userRepository.findAll(pageRequest).getContent();
        return users.stream().map(UserMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }


}
