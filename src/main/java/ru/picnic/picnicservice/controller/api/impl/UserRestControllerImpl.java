package ru.picnic.picnicservice.controller.api.impl;

import static org.springframework.http.ResponseEntity.ok;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.picnic.picnicservice.controller.api.UserRestController;
import ru.picnic.picnicservice.domain.dto.UserDTO;
import ru.picnic.picnicservice.service.IUserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserRestControllerImpl implements UserRestController {

    private final IUserService userService;

    @Override
    public ResponseEntity<UserDTO> getUserById(@PathVariable(value = "id") Long id) {
        return ok(userService.getUserById(id));
    }

    @Override
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ok(userService.getUsers(0, Integer.MAX_VALUE));
    }

    @Override
    public ResponseEntity<List<UserDTO>> getUsersWithPagination(@PathVariable("page") int page,
                                                                @PathVariable("size") int size) {
        return ok(userService.getUsers(page, size));
    }
}
