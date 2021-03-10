package com.services;

import com.exceptions.ProductException;

/**
 * Provides services for dealing with product in pentazon
 */

public interface ProductService {
    /**
     * Search for product with specified id
     * @param productId
     * @return Product with valid product id
     */
    Product findProduct(String productId) throws ProductException;
//    <Product> getAllProducts();
//    void removeProduct(int id);
//    void saveProduct(Product product);
//    void checkOut(Cart cart);
//    void addToCart(Product product);
}
