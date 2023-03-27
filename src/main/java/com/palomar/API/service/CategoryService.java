/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.palomar.API.service;

import com.palomar.API.model.Category;
import com.palomar.API.repository.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ericpaldor
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;
    
    public List<Category>listCategory(){
        return repository.findAll();
    }
    public void keepCategory(Category category){
        repository.save(category);
    }
    public Category obtainCategoryId (Integer id){
        return repository.findById(id).get();
    }
    public void deleteCategory (Integer id){
        repository.deleteById(id);
    }
}
