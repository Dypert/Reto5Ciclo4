package com.Reto2C4.InterfaceCRUD;

import com.Reto2C4.Entity.Order;
import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 *
 * @author dyper
 */
public interface OrderInterface extends MongoRepository<Order, Integer>{
   List<Order> findBySalesManZone(String zone);
   List<Order> findBySalesManId(Integer id);
   List<Order> findBySalesManIdAndStatus(Integer id, String status);
   List<Order> findByRegisterDayAndSalesManId(Date registerDay, Integer id);
   
   

    //Retorna las ordenes de pedido que coincidad con la zona recibida como parametro
    //@Query("{'salesMan.zone': ?0}")
    //List<Order> findByZone(final String country);
    
    //Retorna las ordenes x estado
    //@Query("{status: ?0}")
    //List<Order> findByStatus(final String status);
    
    //Para seleccionar la orden con el id maximo
    //Optional<Order> findTopByOrderByIdDesc();
    
}
