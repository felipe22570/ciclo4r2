/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo4.reto2.repositorio;

import com.usa.ciclo4.reto2.modelo.CleaningProduct;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.usa.ciclo4.reto2.interfaces.InterfaceCleaningProduct;

/**
 *
 * @author USUARIO
 */
@Repository
public class CleaningProductRepositorio {
    @Autowired
    private InterfaceCleaningProduct repository;

    public List<CleaningProduct> getAll() {
        return repository.findAll();
    }

    public Optional<CleaningProduct> getClothe(String reference) {
        return repository.findById(reference);
    }
    public CleaningProduct create(CleaningProduct clothe) {
        return repository.save(clothe);
    }

    public void update(CleaningProduct clothe) {
        repository.save(clothe);
    }
    
    public void delete(CleaningProduct clothe) {
        repository.delete(clothe);
    }
    
    public List<CleaningProduct> getByPrice(double price){
        return repository.findByPriceLessThanEqual(price);
    }

    public List<CleaningProduct> getByDescriptionContains(String description){
        return repository.findByDescriptionContainingIgnoreCase(description);
    }
}
