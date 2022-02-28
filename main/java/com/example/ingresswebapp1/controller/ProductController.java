package com.example.ingresswebapp1.controller;

import com.example.ingresswebapp1.model.Product;
import com.example.ingresswebapp1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.h2.H2ConsoleAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping
    public String addProduct(
            @RequestParam(value="product_name") String productName,
            @RequestParam(value="product_type") String productType,
            @RequestParam(value="product_count") Integer productCount
    )
    {
        Product product = new Product();
        product.setProductName(productName);
        product.setProductType(productType);
        product.setProductCount(productCount);
        productRepository.save(product);
        return "redirect:/";
    }


    @GetMapping("/{id}")
    public String getProduct(Model model, @PathVariable("id") Integer id){
        Product product = productRepository.findProductById(id);
        model.addAttribute("product", product);
        return "product";
    }

    @PostMapping("/{id}")
    public String updateProduct
            (
            @PathVariable("id") Integer id,
            @RequestParam(value="product_name") String productName,
            @RequestParam(value="product_type") String productType,
            @RequestParam(value="product_count") Integer productCount
            )
    {
        Product product = productRepository.findProductById(id);
        product.setProductName(productName);
        product.setProductType(productType);
        product.setProductCount(productCount);
        productRepository.save(product);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String deleteProduct(@PathVariable("id") Integer id){
        productRepository.deleteById(id);
        return "redirect:/";
    }




}
