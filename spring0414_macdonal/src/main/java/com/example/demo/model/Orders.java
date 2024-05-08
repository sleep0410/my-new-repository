/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 *
 * @author FP
 */
@Data
@Entity
public class Orders {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)  //自動編號
    private int id;
    private String ordersnum;
    private String account;
    private String orderdate;
    private String mealnum;
    private String mealtitle;
    private int qty;
    private int price;
    private int total;        
}
