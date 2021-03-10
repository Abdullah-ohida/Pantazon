package com.services;

import com.exceptions.ProductException;

public class ProductServiceImpl implements ProductService{
    Product productRepoMock = new Product();
    /**
     * Search for product with specified id
     *
     * @param productId
     * @return Product with valid product id
     */
    @Override
    public Product findProduct(String productId) throws ProductException {
        return productRepoMock;
    }
}
