package com.usa.ciclo4.reto2.repositorio;

import com.usa.ciclo4.reto2.interfaces.OrderCrudRepository;
import com.usa.ciclo4.reto2.modelo.Order;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author desarrolloextremo
 */
@Repository
public class OrderRepository {

    @Autowired
    private OrderCrudRepository orderCrudRepository;

    public List<Order> getAll() {
        return (List<Order>) orderCrudRepository.findAll();
    }

    public Optional<Order> getOrder(int id) {
        return orderCrudRepository.findById(id);
    }

    public Order create(Order order) {
        return orderCrudRepository.save(order);
    }

    public void update(Order order) {
        orderCrudRepository.save(order);
    }

    public void delete(Order order) {
        orderCrudRepository.delete(order);
    }
    
    public Optional<Order> lastUserId(){
        return orderCrudRepository.findTopByOrderByIdDesc();
    }

    public List<Order> findByZone(String zona) {
        return orderCrudRepository.findByZone(zona);
    }
    
      public List<Order> getOrderBySalesManId(int id){
        return orderCrudRepository.findBySalesManId(id);
    }

    public List<Order> getOrderBySalesManIdAndStatus(int id, String status){
        return orderCrudRepository.findBySalesManIdAndStatus(id, status);
    }

    /*public List<Order> getOrderByRegisterDayAndSalesManId(Date registerDay, Integer id){
        return orderCrudRepository.findByRegisterDayAndSalesManId(registerDay, id);
    }*/

    public List<Order> getByRegisterDayAndSalesManId(String registerDay, Integer id){
        try {
            return orderCrudRepository.findByRegisterDayAndSalesManId(new SimpleDateFormat("yyyy-MM-dd").parse(registerDay), id);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
