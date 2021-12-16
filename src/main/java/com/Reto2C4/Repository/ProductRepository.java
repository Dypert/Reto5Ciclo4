/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto2C4.Repository;


import com.Reto2C4.Entity.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.Reto2C4.InterfaceCRUD.ProductInterface;

/**
 * 
 * @author dyper
 */
@Repository
public class ProductRepository {
    
    @Autowired
    private ProductInterface prodcuctCrudRepository;
    /**
     * 
     * @return listar los productos
     */
    public List<Product> getAll() {
        return prodcuctCrudRepository.findAll();
    }
    /**
     * 
     * @param id
     * @return buscar un producto por id
     */
    public Optional<Product> getproduct(Integer id) {
        return prodcuctCrudRepository.findById(id);
    }
    /**
     * 
     * @param product
     * @return crear lista de productos
     */
    public Product create(Product product) {
        return prodcuctCrudRepository.save(product);
    }
    /**
     * agregar un producto
     * @param product 
     */

    public void update(Product product) {
        prodcuctCrudRepository.save(product);
    }
    /**
     * borrar un producto
     * @param product 
     */

    public void delete(Product product) {
        prodcuctCrudRepository.delete(product);
    }
     public List <Product> findByPrice (double price){
        return  prodcuctCrudRepository.findByPrice(price);
    }
}
