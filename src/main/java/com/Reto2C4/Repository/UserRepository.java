package com.Reto2C4.Repository;

import com.Reto2C4.Entity.User;
import com.Reto2C4.InterfaceCRUD.UserInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author dyper
 */
@Repository
public class UserRepository {
        
    @Autowired
    private UserInterface userCrudRepository;
    
    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }
    /**
     * 
     * @param id
     * @return 
     */

    public Optional<User> getUser(int id) {
        return  userCrudRepository.findById(id);
    }
    /**
     * 
     * @param user
     * @return  crear usuarios
     */
    
    public User create(User user) {
        return userCrudRepository.save(user);
    }/**
     * actualizar usuarios
     * @param user 
     */

    public void update(User user) {
        userCrudRepository.save(user);
    }
    /**
     * borrar usuarios
     * @param user 
     */

    public void delete(User user) {
        userCrudRepository.delete(user);
    }
    /**
     * 
     * @param email
     * @return verificar usuario por email
     */
    public boolean emailExists(String email) {
        Optional<User> usuario = userCrudRepository.findByEmail(email);

        return !usuario.isEmpty();
    }
     /**
      * 
      * @param email
      * @param password
      * @return autenticar el usuario por email y contraseña
      */
    public Optional<User> authenticateUser(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
    /**
     * 
     * @param birthday
     * @return 
     */
    public List <User> findByMonthBirthtDay (String birthday){
        return  userCrudRepository.findByMonthBirthtDay(birthday);
    }
}
