package com.telusko.ProductSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProductService {
    @Autowired
    ProductDB db;
    public List<Product> getAllProducts(){
        // return products;
        return db.findAll();
    }
    public Product getProduct(String name){
        return db.findAll()
                .stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
    public List<Product> getProductText(String text){
        String str = text.toLowerCase();
        return db.findAll().stream().filter(p -> p.getName()
                .toLowerCase()
                .contains(str) || p.getType().toLowerCase().contains(str) || p.getPlace().toLowerCase().contains(str))
                .collect(Collectors.toList());
    }
    public List<Product> getProductsByPlace(String text){
        String str = text.toLowerCase();
        return db.findAll()
                .stream()
                .filter(p -> p.getPlace().toLowerCase().contains(str))
                .collect(Collectors.toList());
    }
    public List<Product> getProdswithOutofWarranty(Integer cutoff){
        return db.findAll()
                .stream()
                .filter(p -> p.getWarranty() < cutoff)
                .collect(Collectors.toList());
    }
}
