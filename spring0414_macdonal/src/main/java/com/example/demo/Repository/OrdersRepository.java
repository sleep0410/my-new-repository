/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.Repository;

import com.example.demo.model.Meals;
import com.example.demo.model.Orders;
import jakarta.transaction.Transactional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/**
 *
 * @author FP
 */
@EnableJpaRepositories
public interface OrdersRepository extends JpaRepository<Orders,Integer> {
    @Query(value="select * from Orders where account= ?1 and mealnum= ?2 and orderdate= ?3" ,nativeQuery = true)
    public Orders  findOrders(String account,String meal,String date);
    

    @Transactional
    @Modifying
    @Query(value="insert into orders (ordersnum,account,orderdate,mealnum,mealtitle,qty,price,total)values( ?1, ?2, ?3, ?4, ?5,1, ?6, ?6)" ,nativeQuery = true)
    public void InsertOrderData(String ordersnum,String acc,String date,String mealsnum,String title,int  price);
    
    
    @Transactional
    @Modifying
    @Query(value="update Orders set qty= ?2,total= ?3 where ordersnum= ?1")
    public void UpdateOrdersData(String ordersnum,int qty,int tal);
  

    @Query(value="select * from Orders where account= ?1 and orderdate= ?2" ,nativeQuery = true)
    public List<Orders> findByDateOrders(String account,String date);

   
    @Transactional
    @Modifying
    @Query(value="delete from Orders where mealnum= ?1 and orderdate= ?2 and account= ?3")
    public void DeleteOrdersData(String num,String date,String acc);
   

     @Query(value="select sum(total) as total from Orders where account= ?1 and orderdate= ?2",nativeQuery = true)
     public Integer totalOrders(String account,String date);
}

