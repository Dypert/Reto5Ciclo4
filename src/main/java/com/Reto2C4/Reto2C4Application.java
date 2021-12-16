package com.Reto2C4;

import com.Reto2C4.InterfaceCRUD.OrderInterface;
import com.Reto2C4.InterfaceCRUD.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import com.Reto2C4.InterfaceCRUD.ProductInterface;

@Component
@SpringBootApplication
public class Reto2C4Application implements CommandLineRunner{

    @Autowired
    public UserInterface userCrudRepository;
            //UserRepository;
    
    @Autowired
    public ProductInterface prodcuctCrudRepository;
            //ProductRepository;
    
    @Autowired
    public OrderInterface orderCrudRepository;
            //OrderRepository;
    
	public static void main(String[] args) {
		SpringApplication.run(Reto2C4Application.class, args);
	}
        /**
         * dependencias para eliminar las tablas
         * @param args
         * @throws Exception 
         */
    @Override
    public void run(String... args) throws Exception {
        userCrudRepository.deleteAll();
        prodcuctCrudRepository.deleteAll();
        orderCrudRepository.deleteAll();
    }
}
