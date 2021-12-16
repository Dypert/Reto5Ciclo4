package com.Reto2C4.Service;

import com.Reto2C4.Entity.User;
import com.Reto2C4.Repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author dyper
 */
@Service 
public class UserService {
    
    @Autowired 
    private UserRepository UserService;
    
    public List<User> getAll() {
        return UserService.getAll();
    }
    /**
     * 
     * @param id
     * @return buscar usuario por id
     */

    public Optional<User> getUser(int id) {
        return UserService.getUser(id);
    }
    /**
     * 
     * @param user
     * @return crear usuario 
     * verificar por id
     */
    public User create(User user) {
        if (user.getId() == null) {
            return user;
        } else {
            Optional<User> e = UserService.getUser(user.getId());
            if (e.isEmpty()) {
                if (emailExists(user.getEmail()) == false) {
                    return UserService.create(user);
                } else {
                    return user;
                }
            } else {
                return user;
            }
        }
    }
    
    public boolean emailExists(String email) {
        return UserService.emailExists(email);
    }
    /**
     * 
     * @param user
     * @return listar datos del usuario
     */
    
    public User update(User user) {

        if (user.getId() != null) {
            Optional<User> updateCrud = UserService.getUser(user.getId());
            if (!updateCrud.isEmpty()) {

                if (user.getIdentification() != null) {
                    updateCrud.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    updateCrud.get().setName(user.getName());
                }
                if (user.getBirthtDay()!= null) {
                    updateCrud.get().setBirthtDay(user.getBirthtDay());
                }
                if (user.getMonthBirthtDay()!=null){
                    updateCrud.get().setMonthBirthtDay(user.getMonthBirthtDay());
                }
                
                if (user.getAddress() != null) {
                    updateCrud.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    updateCrud.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    updateCrud.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    updateCrud.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    updateCrud.get().setZone(user.getZone());
                }
                if (user.getType() != null) {
                    updateCrud.get().setType(user.getType());
                }
                UserService.update(updateCrud.get());
                return updateCrud.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }
    /**
     * 
     * @param userId
     * @return borrar un usuario por id
     */
    
    public boolean delete(int userId) {
        Boolean aBoolean = getUser(userId).map(user -> {
            UserService.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    /**
     * 
     * @param email
     * @param password
     * @return autenticar usuario por email y password
     */
    
    public User authenticateUser(String email, String password) {
        Optional<User> usuario = UserService.authenticateUser(email, password);

        if (usuario.isEmpty()) {
            return new User();
        } else {
            return usuario.get();
        }
    }
    public List <User> findByMonthBirthtDay (String birthday){
        return  UserService.findByMonthBirthtDay(birthday);
    }
}
