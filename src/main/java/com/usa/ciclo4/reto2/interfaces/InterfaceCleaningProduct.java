/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.usa.ciclo4.reto2.interfaces;


import com.usa.ciclo4.reto2.modelo.CleaningProduct;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author USUARIO
 */
public interface InterfaceCleaningProduct extends MongoRepository<CleaningProduct, String> {
    public List<CleaningProduct> findByPriceLessThanEqual(double price);
    public List<CleaningProduct> findByDescriptionContainingIgnoreCase(String description);
}
