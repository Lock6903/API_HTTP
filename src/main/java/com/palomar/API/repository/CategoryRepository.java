/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.palomar.API.repository;

import com.palomar.API.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author ericpaldor
 */
public interface CategoryRepository extends JpaRepository<Category, Integer>{
    
}
