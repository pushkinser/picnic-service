package ru.picnic.picnicservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.picnic.picnicservice.dto.UserDTO;
import ru.picnic.picnicservice.model.User;

@Mapper
public interface UserMapper {
    
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);
    
    UserDTO userToUserDTO(User user);
    
    User userDTOtoUser(UserDTO userDTO);
}
