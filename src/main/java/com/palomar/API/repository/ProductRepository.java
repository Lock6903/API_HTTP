/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.palomar.API.repository;

import com.palomar.API.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author ericpaldor
 */
public interface ProductRepository extends JpaRepository<Product, Integer>{
    
}
