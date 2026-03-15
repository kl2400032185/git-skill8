package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.model.Product;
import com.klu.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository repo;

    // Category search
    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category)
    {
        return repo.findByCategory(category);
    }

    // Price filter
    @GetMapping("/filter")
    public List<Product> getByPriceRange(@RequestParam double min,
                                         @RequestParam double max)
    {
        return repo.findByPriceBetween(min,max);
    }

    // Sorted products
    @GetMapping("/sorted")
    public List<Product> getSortedProducts()
    {
        return repo.getProductsSorted();
    }

    // Expensive products
    @GetMapping("/expensive/{price}")
    public List<Product> getExpensive(@PathVariable double price)
    {
        return repo.getExpensiveProducts(price);
    }
}