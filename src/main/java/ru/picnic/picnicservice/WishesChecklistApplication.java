package ru.picnic.picnicservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.picnic.picnicservice.domain.model.Role;
import ru.picnic.picnicservice.domain.model.RoleName;
import ru.picnic.picnicservice.domain.model.User;
import ru.picnic.picnicservice.repositories.UserRepository;
import ru.picnic.picnicservice.service.IUserService;

@SpringBootApplication
public class WishesChecklistApplication {

    private final Logger logger = LoggerFactory.getLogger(WishesChecklistApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WishesChecklistApplication.class, args);
    }

    @Bean
    public CommandLineRunner insertUserData(UserRepository userRepository, IUserService IUserService) {
        return args -> {

            User user = User.builder()
                            .userName("saveByMain")
                            .password("password")
                            .email("new-user@mail.com")
                            .role(new Role(RoleName.USER.toString()))
                            .build();

            User saveUser = userRepository.save(user);
            logger.info("Saves user " + saveUser);
            saveUser.setUserName("newUserName");
            User updateUser = userRepository.saveAndFlush(saveUser);
            logger.info("Update user " + updateUser);
            logger.info("Users " + IUserService.getUsers(0, Integer.MAX_VALUE));
        };
    }
}
