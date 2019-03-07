package ru.picnic.picnicservice.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import ru.picnic.picnicservice.domain.dto.UserDTO;
import ru.picnic.picnicservice.domain.model.Role;
import ru.picnic.picnicservice.domain.model.RoleName;
import ru.picnic.picnicservice.domain.model.User;

public class UserMapperTest {

    private static final String USER_NAME = "userName";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "encrypt";
    private static final long USER_ID = 10L;

    @Test
    public void whenConvertUserEntityToUserDTO_thenCorrect() {
        User user = buildUser();

        UserDTO userDTO = UserMapper.MAPPER.userToUserDTO(user);

        assertEquals(user.getId(), userDTO.getId());
        assertEquals(user.getUserName(), userDTO.getUserName());
        assertEquals(user.getEmail(), userDTO.getEmail());
        assertEquals(user.getPassword(), userDTO.getPassword());
        assertEquals(user.getRole().getRoleName(), userDTO.getRole().getRoleName());
    }

    @Test
    public void whenConvertUserDTOToUserEntity_thenCorrect() {
        UserDTO userDTO = buildUserDTO();

        User user = UserMapper.MAPPER.userDTOtoUser(userDTO);

        assertEquals(userDTO.getId(), user.getId());
        assertEquals(userDTO.getUserName(), user.getUserName());
        assertEquals(userDTO.getEmail(), user.getEmail());
        assertEquals(userDTO.getPassword(), user.getPassword());
        assertEquals(userDTO.getRole(), user.getRole());

    }

    private UserDTO buildUserDTO() {
        return UserDTO.builder()
                      .id(USER_ID)
                      .userName(USER_NAME)
                      .email(EMAIL)
                      .password(PASSWORD)
                      .role(buildRole())
                      .build();
    }

    private User buildUser() {
        return User.builder()
                   .id(USER_ID)
                   .userName(USER_NAME)
                   .email(EMAIL)
                   .password(PASSWORD)
                   .role(buildRole())
                   .build();
    }

    private Role buildRole() {
        return new Role(RoleName.USER.toString());
    }
}
