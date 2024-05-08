/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.Repository.CustomerRepository;
import com.example.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author FP
 */
@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    public Customer findbyCustomer(String account,String password){
        return customerRepository.findCustomer(account, password);
    }
}
