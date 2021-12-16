package com.Reto2C4.InterfaceCRUD;

import com.Reto2C4.Entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 
 * @author dyper
 */
public interface UserInterface extends MongoRepository<User, Integer>{
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
    
     public List <User> findByMonthBirthtDay (String birthday);
}
