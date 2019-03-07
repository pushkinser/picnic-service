package ru.picnic.picnicservice.service.impl;

import static ru.picnic.picnicservice.mapper.UserMapper.MAPPER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.picnic.picnicservice.domain.dto.UserDTO;
import ru.picnic.picnicservice.domain.model.User;
import ru.picnic.picnicservice.repositories.UserRepository;
import ru.picnic.picnicservice.service.IUserService;

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
        return MAPPER.userToUserDTO(user);
    }

    @Override
    public List<UserDTO> getUsers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<User> users = userRepository.findAll(pageable).getContent();
        return users.stream()
                    .map(MAPPER::userToUserDTO)
                    .collect(Collectors.toList());
    }

    @Override
    public void saveUser(UserDTO userDTO) {
        User user = MAPPER.userDTOtoUser(userDTO);
        userRepository.save(user);
    }

    @Override
    public boolean usernameIsExist(String userName) {
        return userRepository.existsUserByUserName(userName);
    }

}
