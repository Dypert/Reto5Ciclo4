package com.Reto2C4.Service;

import com.Reto2C4.Entity.Product;
import com.Reto2C4.Repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author dyper
 */
@Service
public class ProductService {
    
    @Autowired 
    private ProductRepository productService;
    
    /**
     * 
     * @return 
     */
    public List<Product> getAll() {
        return productService.getAll();
    }
    /**
     * 
     * @param id
     * @return 
     */

    public Optional<Product> getproduct(int id) {
        return productService.getproduct(id);
    }
    /**
     * 
     * @param product
     * @return 
     */
    
    public Product create(Product product) {
        if (product.getId() == null) {
            return product;
        } else {
            return productService.create(product);
        }
    }
    /**
     * 
     * @param product
     * @return listar productos a la table
     */

    public Product update(Product product) {

        if (product.getId() != null) {
            Optional<Product> updateCrud = productService.getproduct(product.getId());
            if (!updateCrud.isEmpty()) {

                if (product.getBrand() != null) {
                    updateCrud.get().setBrand(product.getBrand());
                }               
                if (product.getProcesor() != null) {
                    updateCrud.get().setProcesor(product.getProcesor());
                }
                if (product.getOs() != null) {
                    updateCrud.get().setOs(product.getOs());
                }
                if (product.getDescription() != null) {
                    updateCrud.get().setDescription(product.getDescription());
                }
                if (product.getMemory() != null) {
                    updateCrud.get().setMemory(product.getMemory());
                }
                if (product.getHardDrive() != null) {
                    updateCrud.get().setHardDrive(product.getHardDrive());
                }
                if (product.getPrice() != 0.0) {
                    updateCrud.get().setPrice(product.getPrice());
                }
                if (product.getQuantity() != 0) {
                    updateCrud.get().setQuantity(product.getQuantity());
                }
                if (product.getPhotography() != null) {
                    updateCrud.get().setPhotography(product.getPhotography());
                }
                updateCrud.get().setAvailability(product.isAvailability());
                productService.update(updateCrud.get());
                return updateCrud.get();
            } else {
                return product;
            }
        } else {
            return product;
        }
    }
    
    /**
     * 
     * @param prodcutId
     * @return 
     */
    public boolean delete(int prodcutId) {
        Boolean aBoolean = getproduct(prodcutId).map( product -> {
            productService.delete(product);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    public List <Product> findByPrice (double price){
        return  productService.findByPrice(price);
    }
    
    private boolean checkStrings(String string1, String string2) {
        return string1.indexOf(string2)>=0;
    }
    
    public List <Product> findByDescription (String description2){
        List <Product> product = productService.getAll();
        ArrayList<Product> product2 = new ArrayList();
        for(Product produc: product){
            String descripcion1 = produc.getDescription();
            
            if (checkStrings(descripcion1, description2)) {
                product2.add(produc);
            }
            
        }
        
        return (List<Product>) product2;
    }

    
}
