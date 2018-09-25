package ru.picnic.picnicservice.service;

import ru.picnic.picnicservice.dto.UserDTO;

import java.util.List;

public interface IUserService {
    
    public UserDTO getUserById(Long id);
    
    public List<UserDTO> getUsers(int page, int size);
    
    public void saveUser(UserDTO userDTO);
    
    public boolean usernameIsExist(String userName);
}
