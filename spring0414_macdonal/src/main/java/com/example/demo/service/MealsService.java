/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.Repository.MealsRepository;
import com.example.demo.model.Meals;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author FP
 */
@Service
public class MealsService {
    @Autowired
    private MealsRepository mealsRepository;
    public List<Meals> findAll(){
        return mealsRepository.findAllData();
    }
    public Meals findbyMealNum(String num)
    {
        return mealsRepository.findbyMealNum(num);
    }
}
