/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.model.Meals;
import com.example.demo.model.Orders;
import com.example.demo.service.MealsService;
import com.example.demo.service.OrdersService;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author FP
 */
@Controller
public class OrdersController {
    @Autowired
    OrdersService  ordersService;
    @Autowired
    MealsService   mealsService;
    @GetMapping("/AddCar")
    public RedirectView AddCar(String num,HttpSession session)
    {
        LocalDate todays = LocalDate.now();  //今天日期
        String date=todays.toString();
        String acc=(String)session.getAttribute("account");
        Orders orders=ordersService.findMyOrders(acc, num, date);
	if(orders==null)
        {
             Meals m=mealsService.findbyMealNum(num);
             String ordersnum=date+(int)(Math.random()*900+100);             
             ordersService.InsertOrders(ordersnum,acc,date,num,m.getTitle(),m.getPrice());
        }  
        else
        {
            ordersService.UpdateOrders(orders.getOrdersnum(),orders.getQty()+1,(orders.getQty()+1)*orders.getPrice());
        }
        return new RedirectView("/showCar");
    }
    
    @GetMapping("/showCar")
    public String showCar(String acc,Model model,HttpSession session)
    {
        LocalDate todays = LocalDate.now();  //今天日期
        String date=todays.toString();
        acc=(String)session.getAttribute("account");
        List orders=ordersService.findByDateOrders(acc, date);
        model.addAttribute("orders",orders);
        
        int total=ordersService.totalOrders(acc, date);
        model.addAttribute("orders",orders);
        model.addAttribute("total", total);
        if (orders!=null)
              return "showCar";
        else
        {
            String message="目前沒有產品";           
            session.setAttribute("error", message);
            return "error";
        }    
    }
    
    @GetMapping("/delete")
    public  RedirectView delete(String num,HttpSession session)
    {
        LocalDate todays = LocalDate.now();  //今天日期
        String date=todays.toString();
        String acc=(String)session.getAttribute("account");
        ordersService.DeleteOrders(num,date,acc);
        return new RedirectView("/showCar?acc="+acc);
    }
}
