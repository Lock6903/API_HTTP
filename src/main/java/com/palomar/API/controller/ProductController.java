/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.palomar.API.controller;

import com.palomar.API.model.Product;
import com.palomar.API.model.Category;
import com.palomar.API.service.ProductService;
import com.palomar.API.service.CategoryService;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ericpaldor
 */
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

//----------------------------------------------------------------------------//

    @GetMapping("/product")
    public List<Product> listProducts() {
        return productService.listProducts();
    }
    @GetMapping("/category")
    public List<Category> listCategory() {
        return categoryService.listCategory();
    }
//----------------------------------------------------------------------------//
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> obtainProduct(@PathVariable Integer id) {
        try {
            Product product = productService.obtainProductId(id);
            return ResponseEntity.ok(product);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<Category> obtainCategory(@PathVariable Integer id) {
        try {
            Category category = categoryService.obtainCategoryId(id);
            return ResponseEntity.ok(category);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
//----------------------------------------------------------------------------//

    @PostMapping("/product")
    public void newProduct (@RequestBody Product product){
        productService.keepProduct(product);
    }
    @PostMapping("/category")
    public void newCategory (@RequestBody Category category){
        categoryService.keepCategory(category);
    }

//----------------------------------------------------------------------------//
    
    @PutMapping("/product/{id}")
    public ResponseEntity<?> editProduct (@RequestBody Product product, @PathVariable Integer id){
        try{
            Product productExist = productService.obtainProductId(id);
            productExist.setProduct_name(product.getProduct_name());
            productExist.setPrice(product.getPrice());
            productExist.setCp_fk(product.getCp_fk());
            productService.keepProduct(productExist);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/category/{id}")
    public ResponseEntity<?> editCategory (@RequestBody Category category, @PathVariable Integer id){
        try{
            Category categoryExist = categoryService.obtainCategoryId(id);
            categoryExist.setCategory(category.getCategory());
            categoryService.keepCategory(categoryExist);
            return new ResponseEntity<Category>(category, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
    }
    
//----------------------------------------------------------------------------//

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);
    }
    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable Integer id){
        categoryService.deleteCategory(id);
    }
}
