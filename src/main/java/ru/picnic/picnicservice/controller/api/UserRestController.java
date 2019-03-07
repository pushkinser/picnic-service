package ru.picnic.picnicservice.controller.api;

import static ru.picnic.picnicservice.util.constants.UrlConstant.ENDPOINT_USER;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.picnic.picnicservice.domain.dto.UserDTO;

import java.util.List;

public interface UserRestController {

    @GetMapping(value = ENDPOINT_USER + "/{id}")
    ResponseEntity<UserDTO> getUserById(@PathVariable(value = "id") Long id);

    @GetMapping(value = ENDPOINT_USER + "/all")
    ResponseEntity<List<UserDTO>> getAllUsers();

    @GetMapping(value = ENDPOINT_USER + "/page/{page}/size/{size}")
    ResponseEntity<List<UserDTO>> getUsersWithPagination(@PathVariable("page") int page, @PathVariable("size") int size);
}
