package com.klu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.klu.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>
{

    // Derived Query Method
    List<Product> findByCategory(String category);

    // Derived Query Method
    List<Product> findByPriceBetween(double min,double max);

    // JPQL Query - Sorting by price
    @Query("SELECT p FROM Product p ORDER BY p.price ASC")
    List<Product> getProductsSorted();

    // JPQL Query - Price greater than value
    @Query("SELECT p FROM Product p WHERE p.price > ?1")
    List<Product> getExpensiveProducts(double price);

    // JPQL Query - Category
    @Query("SELECT p FROM Product p WHERE p.category=?1")
    List<Product> getProductsByCategory(String category);

}