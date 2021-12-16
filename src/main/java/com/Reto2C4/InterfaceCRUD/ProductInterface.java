package com.Reto2C4.InterfaceCRUD;

import com.Reto2C4.Entity.Product;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 
 * @author dyper
 */
public interface ProductInterface extends MongoRepository<Product, Integer>{
    public List <Product> findByPrice (double price);
    
}
