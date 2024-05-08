/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;


import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author FP
 */
@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
    
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @PostMapping("/loginSuccess")
    public RedirectView LoginMeals(@RequestParam("account") String account,@RequestParam("password") String password,Model model,HttpSession session){
        Customer cust =customerService.findbyCustomer(account, password);
        if(cust!=null){
            model.addAttribute("customer",cust);
            model.addAttribute("name",cust.getName());
            session.setAttribute("account", cust.getAccount());
            session.setAttribute("name", cust.getName());
            return new RedirectView("/");
        }
        else{
            String message=account+"登入失敗";
            session.setAttribute("message",message);
            return new RedirectView("/error.html");
        }
    }
    //登出
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }
}
