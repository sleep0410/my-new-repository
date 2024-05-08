/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.Repository;

import com.example.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author FP
 */
@EnableJpaRepositories
public interface CustomerRepository extends JpaRepository<Customer,Integer>{
    @Query(value="select * from customer where account= ?1 and password= ?2",nativeQuery=true)
    public Customer findCustomer(String account,String password);
}
