/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.Repository.OrdersRepository;
import com.example.demo.model.Orders;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author FP
 */
@Service
public class OrdersService {
    @Autowired
    OrdersRepository   ordersRepository;

    public Orders findMyOrders(String account,String meal,String date)
    {
        return ordersRepository.findOrders(account, meal,date);
    }   

    
    public void InsertOrders(String ordersnum,String acc,String date,String mealsnum,String title,int price)

    {
        ordersRepository.InsertOrderData(ordersnum,acc,date,mealsnum,title,price);
    }    

    
    public void UpdateOrders(String ordersnum,int qty,int tal)

    {
        ordersRepository.UpdateOrdersData(ordersnum,qty,tal);
    }


    public List<Orders> findByDateOrders(String account,String date)
    {
        return ordersRepository.findByDateOrders(account, date);
    } 

    
    public void DeleteOrders(String num,String date,String acc)
    {                                          
        ordersRepository.DeleteOrdersData(num,date,acc);
    }


    public Integer totalOrders(String account,String date)
    {
        return ordersRepository.totalOrders(account, date);
    }
}
