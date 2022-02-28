package com.example.ingresswebapp1.repository;

import com.example.ingresswebapp1.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer>{
    List<Product> findAll(); // select * from products order by id;
    Product findProductById(Integer id); // select * from product where id = 55;
    void deleteById(Integer id); // select null from products where id = x;
}

