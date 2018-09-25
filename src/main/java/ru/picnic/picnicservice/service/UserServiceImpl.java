package ru.picnic.picnicservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.picnic.picnicservice.dto.UserDTO;
import ru.picnic.picnicservice.mapper.UserMapper;
import ru.picnic.picnicservice.model.User;
import ru.picnic.picnicservice.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return  UserMapper.MAPPER.userToUserDTO(user);
    }
    
    @Override
    public List<UserDTO> getUsers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<User> users = userRepository.findAll(pageable).getContent();
        return users.stream().map(UserMapper.MAPPER::userToUserDTO).collect(Collectors.toList());
    }
    
//    @Override
//    public List<User> getAllUsers() {
//        List<User> users = userRepository.findAll();
//        return users;
//    }

    @Override
    public void saveUser(UserDTO userDTO) {
        User user = UserMapper.MAPPER.userDTOtoUser(userDTO);
        userRepository.save(user);
    }
    
    @Override
    public boolean usernameIsExist(String userName) {
        return userRepository.existsUserByUserName(userName);
    }
    
}
