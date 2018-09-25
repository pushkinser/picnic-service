package ru.picnic.picnicservice.mapper;

import org.junit.Test;
import ru.picnic.picnicservice.dto.UserDTO;
import ru.picnic.picnicservice.model.Role;
import ru.picnic.picnicservice.model.RoleName;
import ru.picnic.picnicservice.model.User;

import static org.junit.Assert.*;

public class UserMapStructUnitTest {

    @Test
    public void whenConvertUserEntityToUserDTO_thenCorrect() {
        User user = User.builder()
                .id(10L)
                .userName("userName")
                .email("email")
                .password("encrypt")
                .role(Role.builder()
                        .roleName(RoleName.USER.toString())
                        .build())
                .build();
        
        UserDTO userDTO = UserMapper.MAPPER.userToUserDTO(user);
    
        assertEquals(user.getId(), userDTO.getId());
        assertEquals(user.getUserName(), userDTO.getUserName());
        assertEquals(user.getEmail(), userDTO.getEmail());
        assertEquals(user.getPassword(), userDTO.getPassword());
        assertEquals(user.getRole(), userDTO.getRole());
    }
    
    @Test
    public void whenConvertUserDTOToUserEntity_thenCorrect() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(7L);
        userDTO.setUserName("userName");
        userDTO.setEmail("email");
        userDTO.setPassword("pas");
        userDTO.setRole(Role.builder()
                .roleName(RoleName.USER.toString())
                .build());
        
        User user = UserMapper.MAPPER.userDTOtoUser(userDTO);
        assertEquals(userDTO.getId(), user.getId());
        assertEquals(userDTO.getUserName(), user.getUserName());
        assertEquals(userDTO.getEmail(), user.getEmail());
        assertEquals(userDTO.getPassword(), user.getPassword());
        assertEquals(userDTO.getRole(), user.getRole());
        
    }
}