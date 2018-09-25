package ru.picnic.picnicservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.picnic.picnicservice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    User findByUserName(String username);
    
    boolean existsByUserName(String username);
    
    boolean existsUserByUserName(String username);
}
