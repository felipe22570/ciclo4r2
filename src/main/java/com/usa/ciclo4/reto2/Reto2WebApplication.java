//modelo
//interface
//repositorio
//servicio
//controlador


package com.usa.ciclo4.reto2;

import com.usa.ciclo4.reto2.interfaces.InterfaceCleaningProduct;
import com.usa.ciclo4.reto2.interfaces.InterfaceUser;
import com.usa.ciclo4.reto2.interfaces.OrderCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Reto2WebApplication implements CommandLineRunner {
        
        @Autowired
        private InterfaceCleaningProduct productCrudRepository;
        @Autowired
        private InterfaceUser userCrudRepository;
        @Autowired
        private OrderCrudRepository orderCrudRepository;
    
	public static void main(String[] args) {
		SpringApplication.run(Reto2WebApplication.class, args);
	}
        
        @Override
        public void run(String... args) throws Exception {
        productCrudRepository.deleteAll();
        userCrudRepository.deleteAll();
        orderCrudRepository.deleteAll();
    }

}
