package ru.picnic.picnicservice.dto;

import lombok.Data;
import ru.picnic.picnicservice.model.Role;

@Data
public class UserDTO {
    
    private Long id;
    private String userName;
    private String password;
    private String email;
    private Role role;
    
}
