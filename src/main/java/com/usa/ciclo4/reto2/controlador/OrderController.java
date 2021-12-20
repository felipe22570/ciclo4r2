package com.usa.ciclo4.reto2.controlador;


import com.usa.ciclo4.reto2.modelo.Order;
import com.usa.ciclo4.reto2.servicio.OrderService;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author desaextremo
 */
@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,
        RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable("id") int id) {
        return orderService.getOrder(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order create(@RequestBody Order gadget) {
        return orderService.create(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order gadget) {
        return orderService.update(gadget);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return orderService.delete(id);
    }

    @GetMapping("/zona/{zona}")
    public List<Order> findByZone(@PathVariable("zona") String zona) {
        return orderService.findByZone(zona);
    }
    
    @GetMapping("/salesman/{id}")
    public List<Order> salesManExist(@PathVariable("id") int id){
        return orderService.getOrderBySalesManId(id);
    }

    @GetMapping("/state/{status}/{id}")
    public List<Order> salesManIdAndStatusExist(@PathVariable("id") int id, @PathVariable("status") String status){
        return orderService.getOrderBySalesManIdAndStatus(id, status);
    }

    /*@GetMapping("/date/{registerDay}/{id}")
    public List<Order> RegisterDayAndSalesManIdExist(@PathVariable("id") int id, @PathVariable("registerDay") Date registerDay){
        return orderService.getOrderByRegisterDayAndSalesManId(registerDay, id);
    }*/

    @GetMapping("/date/{registerDay}/{id}")
    public List<Order> getByRegisterDayAndSalesManId(@PathVariable("registerDay")String  registerDay,@PathVariable("id") Integer id){
        return orderService.getByRegisterDayAndSalesManId(registerDay, id);
    }

}
