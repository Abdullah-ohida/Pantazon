package com.services;

import com.exceptions.ProductException;
import com.model.Product;

/**
 * Provides services for dealing with product in pentazon
 */

public interface ProductService {
    /**
     * search for product with the specified id
     * @param productId
     * @return
     * @throws ProductException
     */
    public Product findProductById(String productId) throws ProductException;
//    <Product> getAllProducts();
//    void removeProduct(int id);
//    void saveProduct(Product product);
//    void checkOut(Cart cart);
//    void addToCart(Product product);
}
