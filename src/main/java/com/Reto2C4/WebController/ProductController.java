package com.Reto2C4.WebController;

import com.Reto2C4.Entity.Product;
import com.Reto2C4.Service.ProductService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author dyper
 */
@RestController
@RequestMapping("/api/clone")
@CrossOrigin("*")
public class ProductController {
    
    @Autowired 
    private ProductService productWeb;

    @GetMapping("/all")
    public List<Product> getAll() {
        return productWeb.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Product> getproduct(@PathVariable("id") int id) {
        return productWeb.getproduct(id);
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product) {
        return productWeb.create(product);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Product update(@RequestBody Product product) {
        return productWeb.update(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return productWeb.delete(id);
    }
    @GetMapping("/price/{price}")
    public List<Product> findByPrice(@PathVariable("price") double price) {
        return productWeb.findByPrice(price);
    }
    
    @GetMapping("/description/{description}")
    public List<Product> findByDescription(@PathVariable("description") String description) {
        return productWeb.findByDescription(description);
    }  
}
