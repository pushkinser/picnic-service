package ru.picnic.picnicservice.controller.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.picnic.picnicservice.dto.UserDTO;
import ru.picnic.picnicservice.service.IUserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
    
    private final IUserService userService;
    private final Logger logger = LoggerFactory.getLogger(UserRestController.class);
    
    @Autowired
    public UserRestController(IUserService userService) {
        this.userService = userService;
    }
    
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getUserById(@PathVariable(value = "id") Long id) {
        logger.info("Get user by id " + id);
        return userService.getUserById(id);
    }
    
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> getAllUsers() {
        logger.info("Get all users");
        return  userService.getUsers(0, Integer.MAX_VALUE);
    }
    
    @GetMapping("/page/{page}/size/{size}")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> getUsersWithPagination(@PathVariable("page") int page, @PathVariable("size") int size) {
        logger.info("Get users page " + page + " size " + size);
        return userService.getUsers(page, size);
    }
}
