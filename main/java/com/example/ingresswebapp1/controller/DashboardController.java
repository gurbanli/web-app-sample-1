package com.example.ingresswebapp1.controller;

import com.example.ingresswebapp1.model.Product;
import com.example.ingresswebapp1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DashboardController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/")
    public String indexPage(Model model){
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "index";
    }
}