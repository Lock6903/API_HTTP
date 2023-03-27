/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.palomar.API.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;





/**
 *
 * @author ericpaldor
 */
@Entity
@Table(name = "category")
@Data @NoArgsConstructor @AllArgsConstructor
public class Category {

   @Id @GeneratedValue
    private Integer id;
    private String category;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cp_fk")
    private List<Product> products;

}
