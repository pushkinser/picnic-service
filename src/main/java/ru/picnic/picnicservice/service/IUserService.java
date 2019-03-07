package ru.picnic.picnicservice.service;

import ru.picnic.picnicservice.domain.dto.UserDTO;

import java.util.List;

public interface IUserService {

    UserDTO getUserById(Long id);

    List<UserDTO> getUsers(int page, int size);

    void saveUser(UserDTO userDTO);

    boolean usernameIsExist(String userName);
}
