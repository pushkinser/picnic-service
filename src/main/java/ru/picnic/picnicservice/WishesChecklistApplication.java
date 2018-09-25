package ru.picnic.picnicservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.picnic.picnicservice.model.Role;
import ru.picnic.picnicservice.model.RoleName;
import ru.picnic.picnicservice.model.User;
import ru.picnic.picnicservice.repositories.UserRepository;
import ru.picnic.picnicservice.service.IUserService;

@SpringBootApplication
public class WishesChecklistApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(WishesChecklistApplication.class, args);
    }
    
    @Bean
    public CommandLineRunner insertUserData(UserRepository userRepository, IUserService IUserService) {
        return (args) -> {
            
            User user = User.builder()
                    .userName("saveByMain")
                    .password("password")
                    .email("new-user@mail.com")
                    .role(Role.builder()
                            .roleName(RoleName.USER.toString())
                            .build())
                    .build();
            
            User saveUser = userRepository.save(user);
            System.out.println("Saves user " + saveUser);
            saveUser.setUserName("newUserName");
            User updateUser = userRepository.saveAndFlush(saveUser);
            System.out.println("Update user " + updateUser);
            System.out.println("Users " + IUserService.getUsers(0, Integer.MAX_VALUE));
        };
    }
    
}
