/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.Repository;

import com.example.demo.model.Meals;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author FP
 */
@EnableJpaRepositories                               
public interface MealsRepository extends JpaRepository<Meals,String>{
    @Query(value="select * from Meals" ,nativeQuery = true)
    public List<Meals>  findAllData();
    
     @Query(value="select * from Meals where num= ?1",nativeQuery = true)
      public Meals findbyMealNum(String num);
}
