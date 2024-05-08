/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.model.Meals;
import com.example.demo.service.MealsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author FP
 */
@Controller
public class MealsController {
    @Autowired
    MealsService mealsService;
    @GetMapping("/")
    public String index(Model model){
        List<Meals> meals=mealsService.findAll();
        model.addAttribute("meals",meals);
        return "index";
    }
}
